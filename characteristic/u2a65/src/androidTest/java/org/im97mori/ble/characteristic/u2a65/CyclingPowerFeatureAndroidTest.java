package org.im97mori.ble.characteristic.u2a65;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused"})
public class CyclingPowerFeatureAndroidTest {

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

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_PEDAL_POWER_BALANCE_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeaturePedalPowerBalanceNotSupported());
        assertFalse(result1.isCyclingPowerFeaturePedalPowerBalanceSupported());
    }

    //@formatter:off
    private static final byte[] data_00002;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_PEDAL_POWER_BALANCE_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00002 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeaturePedalPowerBalanceNotSupported());
        assertTrue(result1.isCyclingPowerFeaturePedalPowerBalanceSupported());
    }

    //@formatter:off
    private static final byte[] data_00101;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_ACCUMULATED_TORQUE_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00101 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureAccumulatedTorqueNotSupported());
        assertFalse(result1.isCyclingPowerFeatureAccumulatedTorqueSupported());
    }

    //@formatter:off
    private static final byte[] data_00102;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_ACCUMULATED_TORQUE_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00102 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureAccumulatedTorqueNotSupported());
        assertTrue(result1.isCyclingPowerFeatureAccumulatedTorqueSupported());
    }

    //@formatter:off
    private static final byte[] data_00201;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00201 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureWheelRevolutionDataNotSupported());
        assertFalse(result1.isCyclingPowerFeatureWheelRevolutionDataSupported());
    }

    //@formatter:off
    private static final byte[] data_00202;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00202 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureWheelRevolutionDataNotSupported());
        assertTrue(result1.isCyclingPowerFeatureWheelRevolutionDataSupported());
    }

    //@formatter:off
    private static final byte[] data_00301;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00301 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureCrankRevolutionDataNotSupported());
        assertFalse(result1.isCyclingPowerFeatureCrankRevolutionDataSupported());
    }

    //@formatter:off
    private static final byte[] data_00302;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00302 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureCrankRevolutionDataNotSupported());
        assertTrue(result1.isCyclingPowerFeatureCrankRevolutionDataSupported());
    }

    //@formatter:off
    private static final byte[] data_00401;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_EXTREME_MAGNITUDES_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00401 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureExtremeMagnitudesNotSupported());
        assertFalse(result1.isCyclingPowerFeatureExtremeMagnitudesSupported());
    }

    //@formatter:off
    private static final byte[] data_00402;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_EXTREME_MAGNITUDES_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00402 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureExtremeMagnitudesNotSupported());
        assertTrue(result1.isCyclingPowerFeatureExtremeMagnitudesSupported());
    }

    //@formatter:off
    private static final byte[] data_00501;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_EXTREME_ANGLES_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00501 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureExtremeAnglesNotSupported());
        assertFalse(result1.isCyclingPowerFeatureExtremeAnglesSupported());

    }

    //@formatter:off
    private static final byte[] data_00502;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_EXTREME_ANGLES_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00502 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureExtremeAnglesNotSupported());
        assertTrue(result1.isCyclingPowerFeatureExtremeAnglesSupported());
    }

    //@formatter:off
    private static final byte[] data_00601;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_TOP_AND_BOTTOM_DEAD_SPOT_ANGLES_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00601 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureTopAndBottomDeadSpotAnglesNotSupported());
        assertFalse(result1.isCyclingPowerFeatureTopAndBottomDeadSpotAnglesSupported());
    }

    //@formatter:off
    private static final byte[] data_00602;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_TOP_AND_BOTTOM_DEAD_SPOT_ANGLES_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00602 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureTopAndBottomDeadSpotAnglesNotSupported());
        assertTrue(result1.isCyclingPowerFeatureTopAndBottomDeadSpotAnglesSupported());
    }

    //@formatter:off
    private static final byte[] data_00701;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_ACCUMULATED_ENERGY_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00701 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureAccumulatedEnergyNotSupported());
        assertFalse(result1.isCyclingPowerFeatureAccumulatedEnergySupported());
    }

    //@formatter:off
    private static final byte[] data_00702;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_ACCUMULATED_ENERGY_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00702 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureAccumulatedEnergyNotSupported());
        assertTrue(result1.isCyclingPowerFeatureAccumulatedEnergySupported());
    }

    //@formatter:off
    private static final byte[] data_00801;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_INDICATOR_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00801 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureOffsetCompensationIndicatorNotSupported());
        assertFalse(result1.isCyclingPowerFeatureOffsetCompensationIndicatorSupported());
    }

    //@formatter:off
    private static final byte[] data_00802;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_INDICATOR_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00802 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureOffsetCompensationIndicatorNotSupported());
        assertTrue(result1.isCyclingPowerFeatureOffsetCompensationIndicatorSupported());
    }

    //@formatter:off
    private static final byte[] data_00901;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00901 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureOffsetCompensationNotSupported());
        assertFalse(result1.isCyclingPowerFeatureOffsetCompensationSupported());
    }

    //@formatter:off
    private static final byte[] data_00902;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_00902 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureOffsetCompensationNotSupported());
        assertTrue(result1.isCyclingPowerFeatureOffsetCompensationSupported());
    }

    //@formatter:off
    private static final byte[] data_01001;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureCyclingPowerMeasurementCharacteristicContentMaskingNotSupported());
        assertFalse(result1.isCyclingPowerFeatureCyclingPowerMeasurementCharacteristicContentMaskingSupported());
    }

    //@formatter:off
    private static final byte[] data_01002;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01002 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureCyclingPowerMeasurementCharacteristicContentMaskingNotSupported());
        assertTrue(result1.isCyclingPowerFeatureCyclingPowerMeasurementCharacteristicContentMaskingSupported());
    }

    //@formatter:off
    private static final byte[] data_01101;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01101 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureCyclingMultipleSensorLocationsNotSupported());
        assertFalse(result1.isCyclingPowerFeatureCyclingMultipleSensorLocationsSupported());
    }

    //@formatter:off
    private static final byte[] data_01102;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01102 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureCyclingMultipleSensorLocationsNotSupported());
        assertTrue(result1.isCyclingPowerFeatureCyclingMultipleSensorLocationsSupported());
    }

    //@formatter:off
    private static final byte[] data_01201;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01201 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureCrankLengthAdjustmentNotSupported());
        assertFalse(result1.isCyclingPowerFeatureCrankLengthAdjustmentSupported());
    }

    //@formatter:off
    private static final byte[] data_01202;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01202 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureCrankLengthAdjustmentNotSupported());
        assertTrue(result1.isCyclingPowerFeatureCrankLengthAdjustmentSupported());
    }

    //@formatter:off
    private static final byte[] data_01301;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_CHAIN_LENGTH_ADJUSTMENT_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01301 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureChainLengthAdjustmentNotSupported());
        assertFalse(result1.isCyclingPowerFeatureChainLengthAdjustmentSupported());
    }

    //@formatter:off
    private static final byte[] data_01302;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_CHAIN_LENGTH_ADJUSTMENT_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01302 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureChainLengthAdjustmentNotSupported());
        assertTrue(result1.isCyclingPowerFeatureChainLengthAdjustmentSupported());
    }

    //@formatter:off
    private static final byte[] data_01401;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_CHAIN_WEIGHT_ADJUSTMENT_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01401 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureChainWeightAdjustmentNotSupported());
        assertFalse(result1.isCyclingPowerFeatureChainWeightAdjustmentSupported());
    }

    //@formatter:off
    private static final byte[] data_01402;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_CHAIN_WEIGHT_ADJUSTMENT_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01402 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureChainWeightAdjustmentNotSupported());
        assertTrue(result1.isCyclingPowerFeatureChainWeightAdjustmentSupported());
    }

    //@formatter:off
    private static final byte[] data_01501;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_SPAN_LENGTH_ADJUSTMENT_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01501 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureSpanLengthAdjustmentNotSupported());
        assertFalse(result1.isCyclingPowerFeatureSpanLengthAdjustmentSupported());
    }

    //@formatter:off
    private static final byte[] data_01502;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_SPAN_LENGTH_ADJUSTMENT_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01502 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureSpanLengthAdjustmentNotSupported());
        assertTrue(result1.isCyclingPowerFeatureSpanLengthAdjustmentSupported());
    }

    //@formatter:off
    private static final byte[] data_01601;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_FORCE_BASED;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01601 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureSensorMeasurementContextForceBased());
        assertFalse(result1.isCyclingPowerFeatureSensorMeasurementContextTorqueBased());
    }

    //@formatter:off
    private static final byte[] data_01602;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_TORQUE_BASED;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01602 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureSensorMeasurementContextForceBased());
        assertTrue(result1.isCyclingPowerFeatureSensorMeasurementContextTorqueBased());
    }

    //@formatter:off
    private static final byte[] data_01701;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_INSTANTANEOUS_MEASUREMENT_DIRECTION_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01701 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureInstantaneousMeasurementDirectionNotSupported());
        assertFalse(result1.isCyclingPowerFeatureInstantaneousMeasurementDirectionSupported());
    }

    //@formatter:off
    private static final byte[] data_01702;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_INSTANTANEOUS_MEASUREMENT_DIRECTION_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01702 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureInstantaneousMeasurementDirectionNotSupported());
        assertTrue(result1.isCyclingPowerFeatureInstantaneousMeasurementDirectionSupported());
    }

    //@formatter:off
    private static final byte[] data_01801;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01801 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureFactoryCalibrationDateNotSupported());
        assertFalse(result1.isCyclingPowerFeatureFactoryCalibrationDateSupported());
    }

    //@formatter:off
    private static final byte[] data_01802;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01802 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureFactoryCalibrationDateNotSupported());
        assertTrue(result1.isCyclingPowerFeatureFactoryCalibrationDateSupported());
    }

    //@formatter:off
    private static final byte[] data_01901;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01901 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureEnhancedOffsetCompensationNotSupported());
        assertFalse(result1.isCyclingPowerFeatureEnhancedOffsetCompensationSupported());
    }

    //@formatter:off
    private static final byte[] data_01902;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_01902 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_01902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureEnhancedOffsetCompensationNotSupported());
        assertTrue(result1.isCyclingPowerFeatureEnhancedOffsetCompensationSupported());
    }

    //@formatter:off
    private static final byte[] data_02001;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_UNSPECIFIED;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_02001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_02001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertTrue(result1.isCyclingPowerFeatureCyclingPowerDistributeSystemSupportUnspecified());
        assertFalse(result1.isCyclingPowerFeatureCyclingPowerDistributeSystemSupportNotForUse());
        assertFalse(result1.isCyclingPowerFeatureCyclingPowerDistributeSystemSupportCanBeUsed());
    }

    //@formatter:off
    private static final byte[] data_02002;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_NOT_FOR_USE_IN_A_DISTRIBUTED_SYSTEM;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_02002 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_02002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureCyclingPowerDistributeSystemSupportUnspecified());
        assertTrue(result1.isCyclingPowerFeatureCyclingPowerDistributeSystemSupportNotForUse());
        assertFalse(result1.isCyclingPowerFeatureCyclingPowerDistributeSystemSupportCanBeUsed());
    }


    //@formatter:off
    private static final byte[] data_02003;
    static {
        byte[] data = new byte[4];
        int flag = CyclingPowerFeature.CYCLING_POWER_FEATURE_DISTRIBUTE_SYSTEM_SUPPORT_CAN_BE_USED_IN_A_DISTRIBUTED_SYSTEM;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data[ 2] = (byte) (flag >> 16);
        data[ 3] = (byte) (flag >> 24);
        data_02003 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_02003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCyclingPowerFeature());
        assertFalse(result1.isCyclingPowerFeatureCyclingPowerDistributeSystemSupportUnspecified());
        assertFalse(result1.isCyclingPowerFeatureCyclingPowerDistributeSystemSupportNotForUse());
        assertTrue(result1.isCyclingPowerFeatureCyclingPowerDistributeSystemSupportCanBeUsed());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());

    }

    @Test
    public void test_parcelable_1_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_00902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_01902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_02001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_02002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_1_02003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCyclingPowerFeature(), result2.getCyclingPowerFeature());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());

    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CyclingPowerFeatureAndroid result1 = new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        CyclingPowerFeatureAndroid result2 = CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
