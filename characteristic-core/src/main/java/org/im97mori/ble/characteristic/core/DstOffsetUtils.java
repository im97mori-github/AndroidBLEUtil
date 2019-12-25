package org.im97mori.ble.characteristic.core;

/**
 * Utility for org.bluetooth.characteristic.date_time(0x2A08) characteristic
 */
@SuppressWarnings("WeakerAccess")
public class DstOffsetUtils {

    /**
     * 0(0min): Standard Time
     */
    public static final int DST_OFFSET_STANDARD_TIME = 0;

    /**
     * 2(30min): Half An Hour Daylight Time (+0.5h)
     */
    public static final int DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME = 2;

    /**
     * 4(60min): Daylight Time (+1h)
     */
    public static final int DST_OFFSET_DAYLIGHT_TIME = 4;

    /**
     * 8(120min): Double Daylight Time (+2h)
     */
    public static final int DST_OFFSET_DOUBLE_DAYLIGHT_TIME = 8;

    /**
     * 255(0xff): DST is not known
     */
    public static final int DST_OFFSET_IS_NOT_KNOWN = 255;

    /**
     * DST unit(min)
     */
    public static final int DST_OFFSET_UNIT = 15;

    /**
     * @param dstOffset org.bluetooth.characteristic.dst_offset
     * @return {@code true}:Standard Time, {@code false}:not Standard Time
     * @see #DST_OFFSET_STANDARD_TIME
     */
    public static boolean isDstOffsetStandardTime(int dstOffset) {
        return DST_OFFSET_STANDARD_TIME == dstOffset;
    }

    /**
     * @param dstOffset org.bluetooth.characteristic.dst_offset
     * @return {@code true}:Half An Hour Daylight Time, {@code false}:not Half An Hour Daylight Time
     * @see #DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME
     */
    public static boolean isDstOffsetHalfAnHourDaylightTime(int dstOffset) {
        return DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME == dstOffset;
    }

    /**
     * @param dstOffset org.bluetooth.characteristic.dst_offset
     * @return {@code true}:Daylight Time, {@code false}:not Daylight Time
     * @see #DST_OFFSET_DAYLIGHT_TIME
     */
    public static boolean isDstOffsetDaylightTime(int dstOffset) {
        return DST_OFFSET_DAYLIGHT_TIME == dstOffset;
    }

    /**
     * @param dstOffset org.bluetooth.characteristic.dst_offset
     * @return {@code true}:Double Daylight Time, {@code false}:not Double Daylight Time
     * @see #DST_OFFSET_DOUBLE_DAYLIGHT_TIME
     */
    public static boolean isDstOffsetDoubleDaylightTime(int dstOffset) {
        return DST_OFFSET_DOUBLE_DAYLIGHT_TIME == dstOffset;
    }

    /**
     * @param dstOffset org.bluetooth.characteristic.dst_offset
     * @return {@code true}:DST is not known, {@code false}:has DST information
     * @see #DST_OFFSET_IS_NOT_KNOWN
     */
    public static boolean isDstNotKnown(int dstOffset) {
        return (DST_OFFSET_IS_NOT_KNOWN & dstOffset) == DST_OFFSET_IS_NOT_KNOWN;
    }

    /**
     * @param dstOffset org.bluetooth.characteristic.dst_offset
     * @return DST Offset(mins)
     */
    public static int getDstOffsetMin(int dstOffset) {
        return DST_OFFSET_UNIT * dstOffset;
    }

    /**
     * @param dstOffset org.bluetooth.characteristic.dst_offset
     * @return DST Offset(millis)
     */
    public static long getDstOffsetMillis(int dstOffset) {
        return getDstOffsetMin(dstOffset) * 1000L;
    }

}