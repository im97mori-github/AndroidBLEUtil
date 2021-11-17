package org.im97mori.ble.characteristic.u2b36;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Arrays;

@SuppressWarnings("unused")
public class BloodPressureRecordPacketAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[8];
        data[ 0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (0x02 << 2));
        data[ 1] = 0x03;
        data[ 2] = 0x04;
        data[ 3] = 0x05;
        data[ 4] = 0x06;
        data[ 5] = 0x07;
        data[ 6] = 0x08;
        data[ 7] = 0x09;

        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[6];
        data[ 0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                    | (0x02 << 2));
        data[ 1] = 0x03;
        data[ 2] = 0x04;
        data[ 3] = 0x05;
        data[ 4] = 0x06;
        data[ 5] = 0x07;

        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[4];
        data[ 0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (0x02 << 2));
        data[ 1] = 0x03;
        data[ 2] = 0x04;
        data[ 3] = 0x05;

        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[8];
        data[ 0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                    | (0x02 << 2));
        data[ 1] = 0x03;

        data_00004 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(BLEUtils.createUInt16(data, 1), result1.getSequenceNumber());
        assertEquals(BLEUtils.createUInt16(data, 3), result1.getUuid());
        assertArrayEquals(Arrays.copyOfRange(data, 5, data.length), result1.getRecordedCharacteristicWithCrc());
        assertArrayEquals(Arrays.copyOfRange(data, 5, data.length - 2), result1.getRecordedCharacteristicWithNoCrc());
        assertArrayEquals(Arrays.copyOfRange(data, data.length - 2, data.length), result1.getCrc());
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertTrue(result1.isSegmentationHeaderNotLastSegment());
        assertFalse(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(BLEUtils.createUInt16(data, 1), result1.getSequenceNumber());
        assertEquals(BLEUtils.createUInt16(data, 3), result1.getUuid());
        assertArrayEquals(Arrays.copyOfRange(data, 5, data.length), result1.getRecordedCharacteristicWithCrc());
    }

    @Test
    public void test_constructor_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertTrue(result1.isSegmentationHeaderNotFirstSegment());
        assertFalse(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertArrayEquals(Arrays.copyOfRange(data, 1, data.length), result1.getRecordedCharacteristicWithCrc());
        assertArrayEquals(Arrays.copyOfRange(data, 1, data.length - 2), result1.getRecordedCharacteristicWithNoCrc());
        assertArrayEquals(Arrays.copyOfRange(data, data.length - 2, data.length), result1.getCrc());
    }

    @Test
    public void test_constructor_1_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertTrue(result1.isSegmentationHeaderNotFirstSegment());
        assertFalse(result1.isSegmentationHeaderFirstSegment());
        assertTrue(result1.isSegmentationHeaderNotLastSegment());
        assertFalse(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertArrayEquals(Arrays.copyOfRange(data, 1, data.length), result1.getRecordedCharacteristicWithCrc());
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        int segmentationHeader = BLEUtils.createUInt8(data, 0);
        int sequenceNumber = BLEUtils.createUInt16(data, 1);
        int uuid = BLEUtils.createUInt16(data, 3);
        byte[] recordedCharacteristic = Arrays.copyOfRange(data, 5, data.length - 2);
        byte[] crc = Arrays.copyOfRange(data, data.length - 2, data.length);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(segmentationHeader, sequenceNumber, uuid,
                recordedCharacteristic, crc);
        assertEquals(segmentationHeader, result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(sequenceNumber, result1.getSequenceNumber());
        assertEquals(uuid, result1.getUuid());
        assertArrayEquals(Arrays.copyOfRange(data, 5, data.length), result1.getRecordedCharacteristicWithCrc());
        assertArrayEquals(recordedCharacteristic, result1.getRecordedCharacteristicWithNoCrc());
        assertArrayEquals(crc, result1.getCrc());
    }

    @Test
    public void test_constructor_2_00002() {
        byte[] data = getData();

        int segmentationHeader = BLEUtils.createUInt8(data, 0);
        int sequenceNumber = BLEUtils.createUInt16(data, 1);
        int uuid = BLEUtils.createUInt16(data, 3);
        byte[] recordedCharacteristic = Arrays.copyOfRange(data, 5, data.length);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(segmentationHeader, sequenceNumber, uuid,
                recordedCharacteristic, null);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertTrue(result1.isSegmentationHeaderNotLastSegment());
        assertFalse(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(BLEUtils.createUInt16(data, 1), result1.getSequenceNumber());
    }

    @Test
    public void test_constructor_2_00003() {
        byte[] data = getData();

        int segmentationHeader = BLEUtils.createUInt8(data, 0);
        byte[] recordedCharacteristic = Arrays.copyOfRange(data, 1, data.length - 2);
        byte[] crc = Arrays.copyOfRange(data, data.length - 2, data.length);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(segmentationHeader, 0, 0,
                recordedCharacteristic, crc);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertTrue(result1.isSegmentationHeaderNotFirstSegment());
        assertFalse(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertArrayEquals(Arrays.copyOfRange(data, 1, data.length), result1.getRecordedCharacteristicWithCrc());
        assertArrayEquals(Arrays.copyOfRange(data, 1, data.length - 2), result1.getRecordedCharacteristicWithNoCrc());
        assertArrayEquals(Arrays.copyOfRange(data, data.length - 2, data.length), result1.getCrc());
    }

    @Test
    public void test_constructor_2_00004() {
        byte[] data = getData();

        int segmentationHeader = BLEUtils.createUInt8(data, 0);
        byte[] recordedCharacteristic = Arrays.copyOfRange(data, 1, data.length);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(segmentationHeader, 0, 0,
                recordedCharacteristic, null);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertTrue(result1.isSegmentationHeaderNotFirstSegment());
        assertFalse(result1.isSegmentationHeaderFirstSegment());
        assertTrue(result1.isSegmentationHeaderNotLastSegment());
        assertFalse(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertArrayEquals(Arrays.copyOfRange(data, 1, data.length), result1.getRecordedCharacteristicWithCrc());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureRecordPacketAndroid result2 = BloodPressureRecordPacketAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getSegmentationHeader(), result2.getSegmentationHeader());
        assertEquals(result1.getSegmentationHeaderRollingSegmentNumber(), result2.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(result1.getSequenceNumber(), result2.getSequenceNumber());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getRecordedCharacteristicWithCrc(), result2.getRecordedCharacteristicWithCrc());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureRecordPacketAndroid result2 = BloodPressureRecordPacketAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getSegmentationHeader(), result2.getSegmentationHeader());
        assertEquals(result1.getSegmentationHeaderRollingSegmentNumber(), result2.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(result1.getSequenceNumber(), result2.getSequenceNumber());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getRecordedCharacteristicWithCrc(), result2.getRecordedCharacteristicWithCrc());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureRecordPacketAndroid result2 = BloodPressureRecordPacketAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getSegmentationHeader(), result2.getSegmentationHeader());
        assertEquals(result1.getSegmentationHeaderRollingSegmentNumber(), result2.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(result1.getSequenceNumber(), result2.getSequenceNumber());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getRecordedCharacteristicWithCrc(), result2.getRecordedCharacteristicWithCrc());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureRecordPacketAndroid result2 = BloodPressureRecordPacketAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getSegmentationHeader(), result2.getSegmentationHeader());
        assertEquals(result1.getSegmentationHeaderRollingSegmentNumber(), result2.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(result1.getSequenceNumber(), result2.getSequenceNumber());
        assertEquals(result1.getUuid(), result2.getUuid());
        assertArrayEquals(result1.getRecordedCharacteristicWithCrc(), result2.getRecordedCharacteristicWithCrc());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        BloodPressureRecordPacketAndroid result2 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        BloodPressureRecordPacketAndroid result2 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        BloodPressureRecordPacketAndroid result2 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureRecordPacketAndroid result1 = new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        BloodPressureRecordPacketAndroid result2 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
