package org.im97mori.ble.characteristic.u2b36;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

@SuppressWarnings("unused")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
		// required to access final members on androidx.loader.content.ModernAsyncTask
		"androidx.loader.content"}
		, sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class BloodPressureRecordAndroidTest extends TestBase {

	@Test
	public void test_constructor_1_00001() {
		byte[] data = new byte[8];
		data[0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
				| BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE | (0x02 << 2));
		data[1] = 0x03;
		data[2] = 0x04;
		data[3] = 0x05;
		data[4] = 0x06;
		data[5] = 0x07;
		data[6] = 0x08;
		data[7] = 0x09;

		BloodPressureRecordPacketAndroid packet1 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);
		BloodPressureRecordAndroid result1 = new BloodPressureRecordAndroid(packet1);
		assertEquals(packet1.getSequenceNumber(), result1.getSequenceNumber());
		assertEquals(packet1.getUuid(), result1.getUuid());
		assertArrayEquals(packet1.getRecordedCharacteristicWithCrc(), result1.getRecordedCharacteristicWithCrc());
		assertArrayEquals(packet1.getRecordedCharacteristicWithNoCrc(), result1.getRecordedCharacteristicWithNoCrc());
		assertArrayEquals(packet1.getCrc(), result1.getCrc());
	}

	@Test
	public void test_constructor_1_00002() {
		byte[] data = new byte[6];
		data[0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
				| BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE | (0x02 << 2));
		data[1] = 0x03;
		data[2] = 0x04;
		data[3] = 0x05;
		data[4] = 0x06;
		data[5] = 0x07;
		BloodPressureRecordPacketAndroid packet1 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);

		data = new byte[4];
		data[0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
				| BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE | (0x08 << 2));
		data[1] = 0x09;
		data[2] = 0x0a;
		data[3] = 0x0b;
		BloodPressureRecordPacketAndroid packet2 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);

		BloodPressureRecordAndroid result1 = new BloodPressureRecordAndroid(packet1, packet2);
		assertEquals(packet1.getSequenceNumber(), result1.getSequenceNumber());
		assertEquals(packet1.getUuid(), result1.getUuid());

		byte[] expect = new byte[4];
		System.arraycopy(packet1.getRecordedCharacteristicWithCrc(), 0, expect, 0,
				packet1.getRecordedCharacteristicWithCrc().length);
		System.arraycopy(packet2.getRecordedCharacteristicWithCrc(), 0, expect,
				packet1.getRecordedCharacteristicWithCrc().length, packet2.getRecordedCharacteristicWithCrc().length);
		assertArrayEquals(expect, result1.getRecordedCharacteristicWithCrc());
		assertArrayEquals(Arrays.copyOfRange(expect, 0, expect.length - 2),
				result1.getRecordedCharacteristicWithNoCrc());
		assertArrayEquals(Arrays.copyOfRange(expect, expect.length - 2, expect.length), packet2.getCrc());
	}

	@Test
	public void test_constructor_1_00003() {
		byte[] data = new byte[6];
		data[0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
				| BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE | (0x02 << 2));
		data[1] = 0x03;
		data[2] = 0x04;
		data[3] = 0x05;
		data[4] = 0x06;
		data[5] = 0x07;
		BloodPressureRecordPacketAndroid packet1 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);

		data = new byte[2];
		data[0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
				| BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE | (0x08 << 2));
		data[1] = 0x09;
		BloodPressureRecordPacketAndroid packet2 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);

		data = new byte[4];
		data[0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
				| BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE | (0x0a << 2));
		data[1] = 0x0b;
		data[2] = 0x0c;
		data[3] = 0x0d;
		BloodPressureRecordPacketAndroid packet3 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);

		BloodPressureRecordAndroid result1 = new BloodPressureRecordAndroid(packet1, packet2, packet3);
		assertEquals(packet1.getSequenceNumber(), result1.getSequenceNumber());
		assertEquals(packet1.getUuid(), result1.getUuid());

		byte[] expect = new byte[5];
		System.arraycopy(packet1.getRecordedCharacteristicWithCrc(), 0, expect, 0,
				packet1.getRecordedCharacteristicWithCrc().length);
		System.arraycopy(packet2.getRecordedCharacteristicWithCrc(), 0, expect,
				packet1.getRecordedCharacteristicWithCrc().length, packet2.getRecordedCharacteristicWithCrc().length);
		System.arraycopy(packet3.getRecordedCharacteristicWithCrc(), 0, expect,
				packet1.getRecordedCharacteristicWithCrc().length + packet2.getRecordedCharacteristicWithCrc().length,
				packet3.getRecordedCharacteristicWithCrc().length);
		assertArrayEquals(expect, result1.getRecordedCharacteristicWithCrc());
		assertArrayEquals(Arrays.copyOfRange(expect, 0, expect.length - 2),
				result1.getRecordedCharacteristicWithNoCrc());
		assertArrayEquals(Arrays.copyOfRange(expect, expect.length - 2, expect.length), packet3.getCrc());
	}

	@Test
	public void test_constructor_2_00001() {
		byte[] data = new byte[7];
		data[0] = 0x03;
		data[1] = 0x04;
		data[2] = 0x05;
		data[3] = 0x06;
		data[4] = 0x07;
		data[5] = 0x08;
		data[6] = 0x09;

		int sequenceNumber = BLEUtils.createUInt16(data, 0);
		int uuid = BLEUtils.createUInt16(data, 2);
		byte[] recordedCharacteristic = Arrays.copyOfRange(data, 4, data.length - 2);
		byte[] crc = Arrays.copyOfRange(data, data.length - 2, data.length);

		BloodPressureRecordAndroid result1 = new BloodPressureRecordAndroid(sequenceNumber, uuid, recordedCharacteristic, crc);
		assertEquals(sequenceNumber, result1.getSequenceNumber());
		assertEquals(uuid, result1.getUuid());
		assertArrayEquals(Arrays.copyOfRange(data, 4, data.length), result1.getRecordedCharacteristicWithCrc());
		assertArrayEquals(recordedCharacteristic, result1.getRecordedCharacteristicWithNoCrc());
		assertArrayEquals(crc, result1.getCrc());
	}

	@Test
	public void test_parcelable_2_00001() {
		byte[] data = new byte[8];
		data[0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
				| BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE | (0x02 << 2));
		data[1] = 0x03;
		data[2] = 0x04;
		data[3] = 0x05;
		data[4] = 0x06;
		data[5] = 0x07;
		data[6] = 0x08;
		data[7] = 0x09;

		BloodPressureRecordPacketAndroid packet1 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);
		BloodPressureRecordAndroid result1 = new BloodPressureRecordAndroid(packet1);
		assertArrayEquals(Arrays.copyOfRange(data, 1, data.length), result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00002() {
		byte[] data = new byte[6];
		data[0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
				| BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE | (0x02 << 2));
		data[1] = 0x03;
		data[2] = 0x04;
		data[3] = 0x05;
		data[4] = 0x06;
		data[5] = 0x07;
		BloodPressureRecordPacketAndroid packet1 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);

		data = new byte[4];
		data[0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
				| BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE | (0x08 << 2));
		data[1] = 0x09;
		data[2] = 0x0a;
		data[3] = 0x0b;
		BloodPressureRecordPacketAndroid packet2 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);

		BloodPressureRecordAndroid result1 = new BloodPressureRecordAndroid(packet1, packet2);

		byte[] expect = new byte[8];
		expect[0] = (byte) packet1.getSequenceNumber();
		expect[1] = (byte) (packet1.getSequenceNumber() >> 8);
		expect[2] = (byte) packet1.getUuid();
		expect[3] = (byte) (packet1.getUuid() >> 8);
		System.arraycopy(packet1.getRecordedCharacteristicWithCrc(), 0, expect, 4,
				packet1.getRecordedCharacteristicWithCrc().length);
		System.arraycopy(packet2.getRecordedCharacteristicWithCrc(), 0, expect,
				4 + packet1.getRecordedCharacteristicWithCrc().length,
				packet2.getRecordedCharacteristicWithCrc().length);
		assertArrayEquals(expect, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00003() {
		byte[] data = new byte[6];
		data[0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
				| BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE | (0x02 << 2));
		data[1] = 0x03;
		data[2] = 0x04;
		data[3] = 0x05;
		data[4] = 0x06;
		data[5] = 0x07;
		BloodPressureRecordPacketAndroid packet1 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);

		data = new byte[2];
		data[0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
				| BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE | (0x08 << 2));
		data[1] = 0x09;
		BloodPressureRecordPacketAndroid packet2 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);

		data = new byte[4];
		data[0] = (byte) (BloodPressureRecordPacket.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
				| BloodPressureRecordPacket.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE | (0x0a << 2));
		data[1] = 0x0b;
		data[2] = 0x0c;
		data[3] = 0x0d;
		BloodPressureRecordPacketAndroid packet3 = BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(data);

		BloodPressureRecordAndroid result1 = new BloodPressureRecordAndroid(packet1, packet2, packet3);

		byte[] expect = new byte[9];
		expect[0] = (byte) packet1.getSequenceNumber();
		expect[1] = (byte) (packet1.getSequenceNumber() >> 8);
		expect[2] = (byte) packet1.getUuid();
		expect[3] = (byte) (packet1.getUuid() >> 8);
		System.arraycopy(packet1.getRecordedCharacteristicWithCrc(), 0, expect, 4,
				packet1.getRecordedCharacteristicWithCrc().length);
		System.arraycopy(packet2.getRecordedCharacteristicWithCrc(), 0, expect,
				4 + packet1.getRecordedCharacteristicWithCrc().length,
				packet2.getRecordedCharacteristicWithCrc().length);
		System.arraycopy(packet3.getRecordedCharacteristicWithCrc(), 0, expect,
				4 + packet1.getRecordedCharacteristicWithCrc().length
						+ packet2.getRecordedCharacteristicWithCrc().length,
				packet3.getRecordedCharacteristicWithCrc().length);
		assertArrayEquals(expect, result1.getBytes());
	}

}
