package org.im97mori.ble.characteristic.u2af4;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.Count16Utils;
import org.im97mori.ble.characteristic.core.TimeExponential8Utils;
import org.im97mori.ble.characteristic.core.TimeSecond16Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class EventStatisticsAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) Count16Utils.COUNT_IS_NOT_KNOWN;
        data[ 1] = (byte) (Count16Utils.COUNT_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN >> 8);
        data[ 4] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        data[ 5] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        EventStatisticsAndroid result = new EventStatisticsAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getNumberOfEvents());
        assertEquals(BLEUtils.createUInt16(data, 2), result.getAverageEventDuration());
        assertEquals(BLEUtils.createUInt8(data, 4), result.getTimeElapsedSinceLastEvent());
        assertEquals(BLEUtils.createUInt8(data, 5), result.getSensingDuration());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MINIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM;
        data[ 3] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM >> 8);
        data[ 4] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        data[ 5] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        //@formatter:on

        EventStatisticsAndroid result = new EventStatisticsAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getNumberOfEvents());
        assertEquals(BLEUtils.createUInt16(data, 2), result.getAverageEventDuration());
        assertEquals(BLEUtils.createUInt8(data, 4), result.getTimeElapsedSinceLastEvent());
        assertEquals(BLEUtils.createUInt8(data, 5), result.getSensingDuration());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MAXIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM;
        data[ 3] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM >> 8);
        data[ 4] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        data[ 5] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        //@formatter:on

        EventStatisticsAndroid result = new EventStatisticsAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getNumberOfEvents());
        assertEquals(BLEUtils.createUInt16(data, 2), result.getAverageEventDuration());
        assertEquals(BLEUtils.createUInt8(data, 4), result.getTimeElapsedSinceLastEvent());
        assertEquals(BLEUtils.createUInt8(data, 5), result.getSensingDuration());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on

        EventStatisticsAndroid result = new EventStatisticsAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getNumberOfEvents());
        assertEquals(BLEUtils.createUInt16(data, 2), result.getAverageEventDuration());
        assertEquals(BLEUtils.createUInt8(data, 4), result.getTimeElapsedSinceLastEvent());
        assertEquals(BLEUtils.createUInt8(data, 5), result.getSensingDuration());
    }

    @Test
    public void test_constructor_00101() {
        int numberOfEvents = Count16Utils.COUNT_IS_NOT_KNOWN;
        int averageEventDuration = TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN;
        int timeElapsedSinceLastEvent = TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        int sensingDuration = TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;

        EventStatisticsAndroid result = new EventStatisticsAndroid(numberOfEvents, averageEventDuration, timeElapsedSinceLastEvent, sensingDuration);
        assertEquals(numberOfEvents, result.getNumberOfEvents());
        assertEquals(averageEventDuration, result.getAverageEventDuration());
        assertEquals(timeElapsedSinceLastEvent, result.getTimeElapsedSinceLastEvent());
        assertEquals(sensingDuration, result.getSensingDuration());
    }

    @Test
    public void test_constructor_00102() {
        int numberOfEvents = Count16Utils.COUNT_VALUE_MINIMUM;
        int averageEventDuration = TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM;
        int timeElapsedSinceLastEvent = TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        int sensingDuration = TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;

        EventStatisticsAndroid result = new EventStatisticsAndroid(numberOfEvents, averageEventDuration, timeElapsedSinceLastEvent, sensingDuration);
        assertEquals(numberOfEvents, result.getNumberOfEvents());
        assertEquals(averageEventDuration, result.getAverageEventDuration());
        assertEquals(timeElapsedSinceLastEvent, result.getTimeElapsedSinceLastEvent());
        assertEquals(sensingDuration, result.getSensingDuration());
    }

    @Test
    public void test_constructor_00103() {
        int numberOfEvents = Count16Utils.COUNT_VALUE_MAXIMUM;
        int averageEventDuration = TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM;
        int timeElapsedSinceLastEvent = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        int sensingDuration = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;

        EventStatisticsAndroid result = new EventStatisticsAndroid(numberOfEvents, averageEventDuration, timeElapsedSinceLastEvent, sensingDuration);
        assertEquals(numberOfEvents, result.getNumberOfEvents());
        assertEquals(averageEventDuration, result.getAverageEventDuration());
        assertEquals(timeElapsedSinceLastEvent, result.getTimeElapsedSinceLastEvent());
        assertEquals(sensingDuration, result.getSensingDuration());
    }

    @Test
    public void test_constructor_00104() {
        int numberOfEvents = 1;
        int averageEventDuration = 2;
        int timeElapsedSinceLastEvent = 3;
        int sensingDuration = 4;

        EventStatisticsAndroid result = new EventStatisticsAndroid(numberOfEvents, averageEventDuration, timeElapsedSinceLastEvent, sensingDuration);
        assertEquals(numberOfEvents, result.getNumberOfEvents());
        assertEquals(averageEventDuration, result.getAverageEventDuration());
        assertEquals(timeElapsedSinceLastEvent, result.getTimeElapsedSinceLastEvent());
        assertEquals(sensingDuration, result.getSensingDuration());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) Count16Utils.COUNT_IS_NOT_KNOWN;
        data[ 1] = (byte) (Count16Utils.COUNT_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN >> 8);
        data[ 4] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        data[ 5] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        EventStatisticsAndroid result1 = new EventStatisticsAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EventStatisticsAndroid result2 = EventStatisticsAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getNumberOfEvents(), result1.getNumberOfEvents());
        assertEquals(result2.getAverageEventDuration(), result1.getAverageEventDuration());
        assertEquals(result2.getTimeElapsedSinceLastEvent(), result1.getTimeElapsedSinceLastEvent());
        assertEquals(result2.getSensingDuration(), result1.getSensingDuration());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MINIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM;
        data[ 3] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM >> 8);
        data[ 4] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        data[ 5] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        //@formatter:on

        EventStatisticsAndroid result1 = new EventStatisticsAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EventStatisticsAndroid result2 = EventStatisticsAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getNumberOfEvents(), result1.getNumberOfEvents());
        assertEquals(result2.getAverageEventDuration(), result1.getAverageEventDuration());
        assertEquals(result2.getTimeElapsedSinceLastEvent(), result1.getTimeElapsedSinceLastEvent());
        assertEquals(result2.getSensingDuration(), result1.getSensingDuration());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MAXIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM;
        data[ 3] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM >> 8);
        data[ 4] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        data[ 5] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        //@formatter:on

        EventStatisticsAndroid result1 = new EventStatisticsAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EventStatisticsAndroid result2 = EventStatisticsAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getNumberOfEvents(), result1.getNumberOfEvents());
        assertEquals(result2.getAverageEventDuration(), result1.getAverageEventDuration());
        assertEquals(result2.getTimeElapsedSinceLastEvent(), result1.getTimeElapsedSinceLastEvent());
        assertEquals(result2.getSensingDuration(), result1.getSensingDuration());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on

        EventStatisticsAndroid result1 = new EventStatisticsAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EventStatisticsAndroid result2 = EventStatisticsAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getNumberOfEvents(), result1.getNumberOfEvents());
        assertEquals(result2.getAverageEventDuration(), result1.getAverageEventDuration());
        assertEquals(result2.getTimeElapsedSinceLastEvent(), result1.getTimeElapsedSinceLastEvent());
        assertEquals(result2.getSensingDuration(), result1.getSensingDuration());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) Count16Utils.COUNT_IS_NOT_KNOWN;
        data[ 1] = (byte) (Count16Utils.COUNT_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN >> 8);
        data[ 4] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        data[ 5] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        EventStatisticsAndroid result1 = new EventStatisticsAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MINIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM;
        data[ 3] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM >> 8);
        data[ 4] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        data[ 5] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        //@formatter:on

        EventStatisticsAndroid result1 = new EventStatisticsAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MAXIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM;
        data[ 3] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM >> 8);
        data[ 4] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        data[ 5] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        //@formatter:on

        EventStatisticsAndroid result1 = new EventStatisticsAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on

        EventStatisticsAndroid result1 = new EventStatisticsAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) Count16Utils.COUNT_IS_NOT_KNOWN;
        data[ 1] = (byte) (Count16Utils.COUNT_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_IS_NOT_KNOWN >> 8);
        data[ 4] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        data[ 5] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        EventStatisticsAndroid result1 = new EventStatisticsAndroid(data);
        EventStatisticsAndroid result2 = EventStatisticsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MINIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM;
        data[ 3] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MINIMUM >> 8);
        data[ 4] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        data[ 5] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        //@formatter:on

        EventStatisticsAndroid result1 = new EventStatisticsAndroid(data);
        EventStatisticsAndroid result2 = EventStatisticsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MAXIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM;
        data[ 3] = (byte) (TimeSecond16Utils.TIME_SECOND_16_VALUE_MAXIMUM >> 8);
        data[ 4] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        data[ 5] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        //@formatter:on

        EventStatisticsAndroid result1 = new EventStatisticsAndroid(data);
        EventStatisticsAndroid result2 = EventStatisticsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on

        EventStatisticsAndroid result1 = new EventStatisticsAndroid(data);
        EventStatisticsAndroid result2 = EventStatisticsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
