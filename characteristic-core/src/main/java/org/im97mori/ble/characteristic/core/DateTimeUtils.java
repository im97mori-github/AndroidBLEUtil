package org.im97mori.ble.characteristic.core;

/**
 * Utility for org.bluetooth.characteristic.date_time(0x2A08) characteristic
 */
@SuppressWarnings("WeakerAccess")
public class DateTimeUtils {

    /**
     * 0: Year is not known
     */
    public static final int YEAR_IS_NOT_KNOWN = 0;

    /**
     * 0: Month is not known
     */
    public static final int MONTH_IS_NOT_KNOWN = 0;

    /**
     * 1: January
     */
    public static final int MONTH_JANUARY = 1;

    /**
     * 2: February
     */
    public static final int MONTH_FEBRUARY = 2;

    /**
     * 3: March
     */
    public static final int MONTH_MARCH = 3;

    /**
     * 4: April
     */
    public static final int MONTH_APRIL = 4;

    /**
     * 5: May
     */
    public static final int MONTH_MAY = 5;

    /**
     * 6: June
     */
    public static final int MONTH_JUNE = 6;

    /**
     * 7: July
     */
    public static final int MONTH_JULY = 7;

    /**
     * 8: August
     */
    public static final int MONTH_AUGUST = 8;

    /**
     * 9: September
     */
    public static final int MONTH_SEPTEMBER = 9;

    /**
     * 10: October
     */
    public static final int MONTH_OCTOBER = 10;

    /**
     * 11: November
     */
    public static final int MONTH_NOVEMBER = 11;

    /**
     * 12: December
     */
    public static final int MONTH_DECEMBER = 12;

    /**
     * 0: Day of Month is not known
     */
    public static final int DAY_OF_MONTH_IS_NOT_KNOWN = 0;

    /**
     * @param year org.bluetooth.unit.time.year
     * @return {@code true}:Year is not known, {@code false}:has year information
     * @see #YEAR_IS_NOT_KNOWN
     */
    public static boolean isYearNotKnown(int year) {
        return YEAR_IS_NOT_KNOWN == year;
    }

    /**
     * @param month org.bluetooth.unit.time.month
     * @return {@code true}:Month is not known, {@code false}:has month information
     * @see #MONTH_IS_NOT_KNOWN
     */
    public static boolean isMonthNotKnown(int month) {
        return MONTH_IS_NOT_KNOWN == month;
    }

    /**
     * @param month org.bluetooth.unit.time.month
     * @return {@code true}:January, {@code false}:not January
     * @see #MONTH_JANUARY
     */
    public static boolean isMonthJanuary(int month) {
        return MONTH_JANUARY == month;
    }

    /**
     * @param month org.bluetooth.unit.time.month
     * @return {@code true}:February, {@code false}:not February
     * @see #MONTH_FEBRUARY
     */
    public static boolean isMonthFebruary(int month) {
        return MONTH_FEBRUARY == month;
    }

    /**
     * @param month org.bluetooth.unit.time.month
     * @return {@code true}:March, {@code false}:not March
     * @see #MONTH_MARCH
     */
    public static boolean isMonthMarch(int month) {
        return MONTH_MARCH == month;
    }

    /**
     * @param month org.bluetooth.unit.time.month
     * @return {@code true}:April, {@code false}:not April
     * @see #MONTH_APRIL
     */
    public static boolean isMonthApril(int month) {
        return MONTH_APRIL == month;
    }

    /**
     * @param month org.bluetooth.unit.time.month
     * @return {@code true}:May, {@code false}:not May
     * @see #MONTH_MAY
     */
    public static boolean isMonthMay(int month) {
        return MONTH_MAY == month;
    }

    /**
     * @param month org.bluetooth.unit.time.month
     * @return {@code true}:June, {@code false}:not June
     * @see #MONTH_JUNE
     */
    public static boolean isMonthJune(int month) {
        return MONTH_JUNE == month;
    }

    /**
     * @param month org.bluetooth.unit.time.month
     * @return {@code true}:July, {@code false}:not July
     * @see #MONTH_JULY
     */
    public static boolean isMonthJuly(int month) {
        return MONTH_JULY == month;
    }

    /**
     * @param month org.bluetooth.unit.time.month
     * @return {@code true}:August, {@code false}:not August
     * @see #MONTH_AUGUST
     */
    public static boolean isMonthAugust(int month) {
        return MONTH_AUGUST == month;
    }

    /**
     * @param month org.bluetooth.unit.time.month
     * @return {@code true}:September, {@code false}:not September
     * @see #MONTH_SEPTEMBER
     */
    public static boolean isMonthSeptember(int month) {
        return MONTH_SEPTEMBER == month;
    }

    /**
     * @param month org.bluetooth.unit.time.month
     * @return {@code true}:October, {@code false}:not October
     * @see #MONTH_OCTOBER
     */
    public static boolean isMonthOctober(int month) {
        return MONTH_OCTOBER == month;
    }

    /**
     * @param month org.bluetooth.unit.time.month
     * @return {@code true}:November, {@code false}:not November
     * @see #MONTH_NOVEMBER
     */
    public static boolean isMonthNovember(int month) {
        return MONTH_NOVEMBER == month;
    }

    /**
     * @param month org.bluetooth.unit.time.month
     * @return {@code true}:December, {@code false}:not December
     * @see #MONTH_DECEMBER
     */
    public static boolean isMonthDecember(int month) {
        return MONTH_DECEMBER == month;
    }

    /**
     * @param day org.bluetooth.unit.time.day
     * @return {@code true}:Day of Month is not known, {@code false}:has day of month information
     * @see #DAY_OF_MONTH_IS_NOT_KNOWN
     */
    public static boolean isDayOfMonthNotKnown(int day) {
        return DAY_OF_MONTH_IS_NOT_KNOWN == day;
    }

}
