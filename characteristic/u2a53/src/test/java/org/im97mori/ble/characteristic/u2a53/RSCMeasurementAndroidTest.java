package org.im97mori.ble.characteristic.u2a53;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class RSCMeasurementAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        data[ 0] = RSCMeasurement.FLAGS_INSTANTANEOUS_STRIDE_LENGTH_PRESENT_FALSE
                | RSCMeasurement.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RSCMeasurement.FLAGS_WALKING_OR_RUNNING_STATUS_BITS_WALKING;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[6];
        data[ 0] = RSCMeasurement.FLAGS_INSTANTANEOUS_STRIDE_LENGTH_PRESENT_TRUE
                | RSCMeasurement.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RSCMeasurement.FLAGS_WALKING_OR_RUNNING_STATUS_BITS_WALKING;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[4];
        data[ 0] = RSCMeasurement.FLAGS_INSTANTANEOUS_STRIDE_LENGTH_PRESENT_FALSE
                | RSCMeasurement.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RSCMeasurement.FLAGS_WALKING_OR_RUNNING_STATUS_BITS_WALKING;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[8];
        data[ 0] = RSCMeasurement.FLAGS_INSTANTANEOUS_STRIDE_LENGTH_PRESENT_FALSE
                | RSCMeasurement.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | RSCMeasurement.FLAGS_WALKING_OR_RUNNING_STATUS_BITS_WALKING;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[4];
        data[ 0] = RSCMeasurement.FLAGS_INSTANTANEOUS_STRIDE_LENGTH_PRESENT_FALSE
                | RSCMeasurement.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RSCMeasurement.FLAGS_WALKING_OR_RUNNING_STATUS_BITS_WALKING;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[4];
        data[ 0] = RSCMeasurement.FLAGS_INSTANTANEOUS_STRIDE_LENGTH_PRESENT_FALSE
                | RSCMeasurement.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | RSCMeasurement.FLAGS_WALKING_OR_RUNNING_STATUS_BITS_RUNNING;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data_00202 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsInstantaneousStrideLengthNotPresent());
        assertFalse(result1.isFlagsInstantaneousStrideLengthPresent());
        assertEquals(0x0201, result1.getInstantaneousSpeed());
        assertEquals(0x0201 * RSCMeasurement.INSTANTANEOUS_SPEED_RESOLUTION,
                result1.getInstantaneousSpeedMeterPerSecond(), 0);
        assertEquals(0x03, result1.getInstantaneousCadence());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsInstantaneousStrideLengthNotPresent());
        assertTrue(result1.isFlagsInstantaneousStrideLengthPresent());
        assertEquals(0x0201, result1.getInstantaneousSpeed());
        assertEquals(0x0201 * RSCMeasurement.INSTANTANEOUS_SPEED_RESOLUTION,
                result1.getInstantaneousSpeedMeterPerSecond(), 0);
        assertEquals(0x03, result1.getInstantaneousCadence());
        assertEquals(0x0504, result1.getInstantaneousStrideLength());
        assertEquals(0x0504 * RSCMeasurement.INSTANTANEOUS_STRIDE_RESOLUTION,
                result1.getInstantaneousStrideLengthMeter(), 0);
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsTotalDistanceNotPresent());
        assertFalse(result1.isFlagsTotalDistancePresent());
        assertEquals(0x0201, result1.getInstantaneousSpeed());
        assertEquals(0x0201 * RSCMeasurement.INSTANTANEOUS_SPEED_RESOLUTION,
                result1.getInstantaneousSpeedMeterPerSecond(), 0);
        assertEquals(0x03, result1.getInstantaneousCadence());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsTotalDistanceNotPresent());
        assertTrue(result1.isFlagsTotalDistancePresent());
        assertEquals(0x0201, result1.getInstantaneousSpeed());
        assertEquals(0x0201 * RSCMeasurement.INSTANTANEOUS_SPEED_RESOLUTION,
                result1.getInstantaneousSpeedMeterPerSecond(), 0);
        assertEquals(0x03, result1.getInstantaneousCadence());
        assertEquals(0x07060504L, result1.getTotalDistance());
        assertEquals(0x07060504L * RSCMeasurement.TOTAL_DISTANCE_RESOLUTION, result1.getTotalDistanceMeter(), 0);
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsWalkingOrRunningStatusBitsWalking());
        assertFalse(result1.isFlagsWalkingOrRunningStatusBitsRunning());
        assertEquals(0x0201, result1.getInstantaneousSpeed());
        assertEquals(0x03, result1.getInstantaneousCadence());
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsWalkingOrRunningStatusBitsWalking());
        assertTrue(result1.isFlagsWalkingOrRunningStatusBitsRunning());
        assertEquals(0x0201, result1.getInstantaneousSpeed());
        assertEquals(0x03, result1.getInstantaneousCadence());
    }

    @Test
    public void test_constructor_00203() {
        int flags = 1;
        int instantaneousSpeed = 2;
        int instantaneousCadence = 3;
        int instantaneousStrideLength = 4;
        long totalDistance = 5;

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(flags, instantaneousSpeed, instantaneousCadence, instantaneousStrideLength, totalDistance);
        assertEquals(flags, result1.getFlags());
        assertEquals(instantaneousSpeed, result1.getInstantaneousSpeed());
        assertEquals(instantaneousCadence, result1.getInstantaneousCadence());
        assertEquals(instantaneousStrideLength, result1.getInstantaneousStrideLength());
        assertEquals(totalDistance, result1.getTotalDistance());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RSCMeasurementAndroid result2 = RSCMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getInstantaneousCadence(), result2.getInstantaneousCadence());
        assertEquals(result1.getInstantaneousStrideLength(), result2.getInstantaneousStrideLength());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RSCMeasurementAndroid result2 = RSCMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getInstantaneousCadence(), result2.getInstantaneousCadence());
        assertEquals(result1.getInstantaneousStrideLength(), result2.getInstantaneousStrideLength());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RSCMeasurementAndroid result2 = RSCMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getInstantaneousCadence(), result2.getInstantaneousCadence());
        assertEquals(result1.getInstantaneousStrideLength(), result2.getInstantaneousStrideLength());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RSCMeasurementAndroid result2 = RSCMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getInstantaneousCadence(), result2.getInstantaneousCadence());
        assertEquals(result1.getInstantaneousStrideLength(), result2.getInstantaneousStrideLength());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RSCMeasurementAndroid result2 = RSCMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getInstantaneousCadence(), result2.getInstantaneousCadence());
        assertEquals(result1.getInstantaneousStrideLength(), result2.getInstantaneousStrideLength());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RSCMeasurementAndroid result2 = RSCMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getInstantaneousCadence(), result2.getInstantaneousCadence());
        assertEquals(result1.getInstantaneousStrideLength(), result2.getInstantaneousStrideLength());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        RSCMeasurementAndroid result2 = RSCMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        RSCMeasurementAndroid result2 = RSCMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        RSCMeasurementAndroid result2 = RSCMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        RSCMeasurementAndroid result2 = RSCMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        RSCMeasurementAndroid result2 = RSCMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RSCMeasurementAndroid result1 = new RSCMeasurementAndroid(bluetoothGattCharacteristic);
        RSCMeasurementAndroid result2 = RSCMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
