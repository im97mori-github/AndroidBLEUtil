package org.im97mori.ble.characteristic;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateTimeUtilsTest {

    @Test
    public void test_isYearNotKnown001() {
        assertTrue(DateTimeUtils.isYearNotKnown(DateTimeUtils.YEAR_IS_NOT_KNOWN));
    }

    @Test
    public void test_isYearNotKnown002() {
        assertFalse(DateTimeUtils.isYearNotKnown(1582));
    }

    @Test
    public void test_isYearNotKnown003() {
        assertFalse(DateTimeUtils.isYearNotKnown(9999));
    }

    @Test
    public void test_IsMonth001() {
        assertTrue(DateTimeUtils.isMonthNotKnown(DateTimeUtils.MONTH_IS_NOT_KNOWN));
        assertFalse(DateTimeUtils.isMonthJanuary(DateTimeUtils.MONTH_IS_NOT_KNOWN));
        assertFalse(DateTimeUtils.isMonthFebruary(DateTimeUtils.MONTH_IS_NOT_KNOWN));
        assertFalse(DateTimeUtils.isMonthMarch(DateTimeUtils.MONTH_IS_NOT_KNOWN));
        assertFalse(DateTimeUtils.isMonthApril(DateTimeUtils.MONTH_IS_NOT_KNOWN));
        assertFalse(DateTimeUtils.isMonthMay(DateTimeUtils.MONTH_IS_NOT_KNOWN));
        assertFalse(DateTimeUtils.isMonthJune(DateTimeUtils.MONTH_IS_NOT_KNOWN));
        assertFalse(DateTimeUtils.isMonthJuly(DateTimeUtils.MONTH_IS_NOT_KNOWN));
        assertFalse(DateTimeUtils.isMonthAugust(DateTimeUtils.MONTH_IS_NOT_KNOWN));
        assertFalse(DateTimeUtils.isMonthSeptember(DateTimeUtils.MONTH_IS_NOT_KNOWN));
        assertFalse(DateTimeUtils.isMonthOctober(DateTimeUtils.MONTH_IS_NOT_KNOWN));
        assertFalse(DateTimeUtils.isMonthNovember(DateTimeUtils.MONTH_IS_NOT_KNOWN));
        assertFalse(DateTimeUtils.isMonthDecember(DateTimeUtils.MONTH_IS_NOT_KNOWN));
    }

    @Test
    public void test_IsMonth002() {
        assertFalse(DateTimeUtils.isMonthNotKnown(DateTimeUtils.MONTH_JANUARY));
        assertTrue(DateTimeUtils.isMonthJanuary(DateTimeUtils.MONTH_JANUARY));
        assertFalse(DateTimeUtils.isMonthFebruary(DateTimeUtils.MONTH_JANUARY));
        assertFalse(DateTimeUtils.isMonthMarch(DateTimeUtils.MONTH_JANUARY));
        assertFalse(DateTimeUtils.isMonthApril(DateTimeUtils.MONTH_JANUARY));
        assertFalse(DateTimeUtils.isMonthMay(DateTimeUtils.MONTH_JANUARY));
        assertFalse(DateTimeUtils.isMonthJune(DateTimeUtils.MONTH_JANUARY));
        assertFalse(DateTimeUtils.isMonthJuly(DateTimeUtils.MONTH_JANUARY));
        assertFalse(DateTimeUtils.isMonthAugust(DateTimeUtils.MONTH_JANUARY));
        assertFalse(DateTimeUtils.isMonthSeptember(DateTimeUtils.MONTH_JANUARY));
        assertFalse(DateTimeUtils.isMonthOctober(DateTimeUtils.MONTH_JANUARY));
        assertFalse(DateTimeUtils.isMonthNovember(DateTimeUtils.MONTH_JANUARY));
        assertFalse(DateTimeUtils.isMonthDecember(DateTimeUtils.MONTH_JANUARY));
    }

    @Test
    public void test_IsMonth003() {
        assertFalse(DateTimeUtils.isMonthNotKnown(DateTimeUtils.MONTH_FEBRUARY));
        assertFalse(DateTimeUtils.isMonthJanuary(DateTimeUtils.MONTH_FEBRUARY));
        assertTrue(DateTimeUtils.isMonthFebruary(DateTimeUtils.MONTH_FEBRUARY));
        assertFalse(DateTimeUtils.isMonthMarch(DateTimeUtils.MONTH_FEBRUARY));
        assertFalse(DateTimeUtils.isMonthApril(DateTimeUtils.MONTH_FEBRUARY));
        assertFalse(DateTimeUtils.isMonthMay(DateTimeUtils.MONTH_FEBRUARY));
        assertFalse(DateTimeUtils.isMonthJune(DateTimeUtils.MONTH_FEBRUARY));
        assertFalse(DateTimeUtils.isMonthJuly(DateTimeUtils.MONTH_FEBRUARY));
        assertFalse(DateTimeUtils.isMonthAugust(DateTimeUtils.MONTH_FEBRUARY));
        assertFalse(DateTimeUtils.isMonthSeptember(DateTimeUtils.MONTH_FEBRUARY));
        assertFalse(DateTimeUtils.isMonthOctober(DateTimeUtils.MONTH_FEBRUARY));
        assertFalse(DateTimeUtils.isMonthNovember(DateTimeUtils.MONTH_FEBRUARY));
        assertFalse(DateTimeUtils.isMonthDecember(DateTimeUtils.MONTH_FEBRUARY));
    }

    @Test
    public void test_IsMonth004() {
        assertFalse(DateTimeUtils.isMonthNotKnown(DateTimeUtils.MONTH_MARCH));
        assertFalse(DateTimeUtils.isMonthJanuary(DateTimeUtils.MONTH_MARCH));
        assertFalse(DateTimeUtils.isMonthFebruary(DateTimeUtils.MONTH_MARCH));
        assertTrue(DateTimeUtils.isMonthMarch(DateTimeUtils.MONTH_MARCH));
        assertFalse(DateTimeUtils.isMonthApril(DateTimeUtils.MONTH_MARCH));
        assertFalse(DateTimeUtils.isMonthMay(DateTimeUtils.MONTH_MARCH));
        assertFalse(DateTimeUtils.isMonthJune(DateTimeUtils.MONTH_MARCH));
        assertFalse(DateTimeUtils.isMonthJuly(DateTimeUtils.MONTH_MARCH));
        assertFalse(DateTimeUtils.isMonthAugust(DateTimeUtils.MONTH_MARCH));
        assertFalse(DateTimeUtils.isMonthSeptember(DateTimeUtils.MONTH_MARCH));
        assertFalse(DateTimeUtils.isMonthOctober(DateTimeUtils.MONTH_MARCH));
        assertFalse(DateTimeUtils.isMonthNovember(DateTimeUtils.MONTH_MARCH));
        assertFalse(DateTimeUtils.isMonthDecember(DateTimeUtils.MONTH_MARCH));
    }

    @Test
    public void test_IsMonth005() {
        assertFalse(DateTimeUtils.isMonthNotKnown(DateTimeUtils.MONTH_APRIL));
        assertFalse(DateTimeUtils.isMonthJanuary(DateTimeUtils.MONTH_APRIL));
        assertFalse(DateTimeUtils.isMonthFebruary(DateTimeUtils.MONTH_APRIL));
        assertFalse(DateTimeUtils.isMonthMarch(DateTimeUtils.MONTH_APRIL));
        assertTrue(DateTimeUtils.isMonthApril(DateTimeUtils.MONTH_APRIL));
        assertFalse(DateTimeUtils.isMonthMay(DateTimeUtils.MONTH_APRIL));
        assertFalse(DateTimeUtils.isMonthJune(DateTimeUtils.MONTH_APRIL));
        assertFalse(DateTimeUtils.isMonthJuly(DateTimeUtils.MONTH_APRIL));
        assertFalse(DateTimeUtils.isMonthAugust(DateTimeUtils.MONTH_APRIL));
        assertFalse(DateTimeUtils.isMonthSeptember(DateTimeUtils.MONTH_APRIL));
        assertFalse(DateTimeUtils.isMonthOctober(DateTimeUtils.MONTH_APRIL));
        assertFalse(DateTimeUtils.isMonthNovember(DateTimeUtils.MONTH_APRIL));
        assertFalse(DateTimeUtils.isMonthDecember(DateTimeUtils.MONTH_APRIL));
    }

    @Test
    public void test_IsMonth006() {
        assertFalse(DateTimeUtils.isMonthNotKnown(DateTimeUtils.MONTH_MAY));
        assertFalse(DateTimeUtils.isMonthJanuary(DateTimeUtils.MONTH_MAY));
        assertFalse(DateTimeUtils.isMonthFebruary(DateTimeUtils.MONTH_MAY));
        assertFalse(DateTimeUtils.isMonthMarch(DateTimeUtils.MONTH_MAY));
        assertFalse(DateTimeUtils.isMonthApril(DateTimeUtils.MONTH_MAY));
        assertTrue(DateTimeUtils.isMonthMay(DateTimeUtils.MONTH_MAY));
        assertFalse(DateTimeUtils.isMonthJune(DateTimeUtils.MONTH_MAY));
        assertFalse(DateTimeUtils.isMonthJuly(DateTimeUtils.MONTH_MAY));
        assertFalse(DateTimeUtils.isMonthAugust(DateTimeUtils.MONTH_MAY));
        assertFalse(DateTimeUtils.isMonthSeptember(DateTimeUtils.MONTH_MAY));
        assertFalse(DateTimeUtils.isMonthOctober(DateTimeUtils.MONTH_MAY));
        assertFalse(DateTimeUtils.isMonthNovember(DateTimeUtils.MONTH_MAY));
        assertFalse(DateTimeUtils.isMonthDecember(DateTimeUtils.MONTH_MAY));
    }

    @Test
    public void test_IsMonth007() {
        assertFalse(DateTimeUtils.isMonthNotKnown(DateTimeUtils.MONTH_JUNE));
        assertFalse(DateTimeUtils.isMonthJanuary(DateTimeUtils.MONTH_JUNE));
        assertFalse(DateTimeUtils.isMonthFebruary(DateTimeUtils.MONTH_JUNE));
        assertFalse(DateTimeUtils.isMonthMarch(DateTimeUtils.MONTH_JUNE));
        assertFalse(DateTimeUtils.isMonthApril(DateTimeUtils.MONTH_JUNE));
        assertFalse(DateTimeUtils.isMonthMay(DateTimeUtils.MONTH_JUNE));
        assertTrue(DateTimeUtils.isMonthJune(DateTimeUtils.MONTH_JUNE));
        assertFalse(DateTimeUtils.isMonthJuly(DateTimeUtils.MONTH_JUNE));
        assertFalse(DateTimeUtils.isMonthAugust(DateTimeUtils.MONTH_JUNE));
        assertFalse(DateTimeUtils.isMonthSeptember(DateTimeUtils.MONTH_JUNE));
        assertFalse(DateTimeUtils.isMonthOctober(DateTimeUtils.MONTH_JUNE));
        assertFalse(DateTimeUtils.isMonthNovember(DateTimeUtils.MONTH_JUNE));
        assertFalse(DateTimeUtils.isMonthDecember(DateTimeUtils.MONTH_JUNE));
    }

    @Test
    public void test_IsMonth008() {
        assertFalse(DateTimeUtils.isMonthNotKnown(DateTimeUtils.MONTH_JULY));
        assertFalse(DateTimeUtils.isMonthJanuary(DateTimeUtils.MONTH_JULY));
        assertFalse(DateTimeUtils.isMonthFebruary(DateTimeUtils.MONTH_JULY));
        assertFalse(DateTimeUtils.isMonthMarch(DateTimeUtils.MONTH_JULY));
        assertFalse(DateTimeUtils.isMonthApril(DateTimeUtils.MONTH_JULY));
        assertFalse(DateTimeUtils.isMonthMay(DateTimeUtils.MONTH_JULY));
        assertFalse(DateTimeUtils.isMonthJune(DateTimeUtils.MONTH_JULY));
        assertTrue(DateTimeUtils.isMonthJuly(DateTimeUtils.MONTH_JULY));
        assertFalse(DateTimeUtils.isMonthAugust(DateTimeUtils.MONTH_JULY));
        assertFalse(DateTimeUtils.isMonthSeptember(DateTimeUtils.MONTH_JULY));
        assertFalse(DateTimeUtils.isMonthOctober(DateTimeUtils.MONTH_JULY));
        assertFalse(DateTimeUtils.isMonthNovember(DateTimeUtils.MONTH_JULY));
        assertFalse(DateTimeUtils.isMonthDecember(DateTimeUtils.MONTH_JULY));
    }

    @Test
    public void test_IsMonth009() {
        assertFalse(DateTimeUtils.isMonthNotKnown(DateTimeUtils.MONTH_AUGUST));
        assertFalse(DateTimeUtils.isMonthJanuary(DateTimeUtils.MONTH_AUGUST));
        assertFalse(DateTimeUtils.isMonthFebruary(DateTimeUtils.MONTH_AUGUST));
        assertFalse(DateTimeUtils.isMonthMarch(DateTimeUtils.MONTH_AUGUST));
        assertFalse(DateTimeUtils.isMonthApril(DateTimeUtils.MONTH_AUGUST));
        assertFalse(DateTimeUtils.isMonthMay(DateTimeUtils.MONTH_AUGUST));
        assertFalse(DateTimeUtils.isMonthJune(DateTimeUtils.MONTH_AUGUST));
        assertFalse(DateTimeUtils.isMonthJuly(DateTimeUtils.MONTH_AUGUST));
        assertTrue(DateTimeUtils.isMonthAugust(DateTimeUtils.MONTH_AUGUST));
        assertFalse(DateTimeUtils.isMonthSeptember(DateTimeUtils.MONTH_AUGUST));
        assertFalse(DateTimeUtils.isMonthOctober(DateTimeUtils.MONTH_AUGUST));
        assertFalse(DateTimeUtils.isMonthNovember(DateTimeUtils.MONTH_AUGUST));
        assertFalse(DateTimeUtils.isMonthDecember(DateTimeUtils.MONTH_AUGUST));
    }

    @Test
    public void test_IsMonth010() {
        assertFalse(DateTimeUtils.isMonthNotKnown(DateTimeUtils.MONTH_SEPTEMBER));
        assertFalse(DateTimeUtils.isMonthJanuary(DateTimeUtils.MONTH_SEPTEMBER));
        assertFalse(DateTimeUtils.isMonthFebruary(DateTimeUtils.MONTH_SEPTEMBER));
        assertFalse(DateTimeUtils.isMonthMarch(DateTimeUtils.MONTH_SEPTEMBER));
        assertFalse(DateTimeUtils.isMonthApril(DateTimeUtils.MONTH_SEPTEMBER));
        assertFalse(DateTimeUtils.isMonthMay(DateTimeUtils.MONTH_SEPTEMBER));
        assertFalse(DateTimeUtils.isMonthJune(DateTimeUtils.MONTH_SEPTEMBER));
        assertFalse(DateTimeUtils.isMonthJuly(DateTimeUtils.MONTH_SEPTEMBER));
        assertFalse(DateTimeUtils.isMonthAugust(DateTimeUtils.MONTH_SEPTEMBER));
        assertTrue(DateTimeUtils.isMonthSeptember(DateTimeUtils.MONTH_SEPTEMBER));
        assertFalse(DateTimeUtils.isMonthOctober(DateTimeUtils.MONTH_SEPTEMBER));
        assertFalse(DateTimeUtils.isMonthNovember(DateTimeUtils.MONTH_SEPTEMBER));
        assertFalse(DateTimeUtils.isMonthDecember(DateTimeUtils.MONTH_SEPTEMBER));
    }

    @Test
    public void test_IsMonth011() {
        assertFalse(DateTimeUtils.isMonthNotKnown(DateTimeUtils.MONTH_OCTOBER));
        assertFalse(DateTimeUtils.isMonthJanuary(DateTimeUtils.MONTH_OCTOBER));
        assertFalse(DateTimeUtils.isMonthFebruary(DateTimeUtils.MONTH_OCTOBER));
        assertFalse(DateTimeUtils.isMonthMarch(DateTimeUtils.MONTH_OCTOBER));
        assertFalse(DateTimeUtils.isMonthApril(DateTimeUtils.MONTH_OCTOBER));
        assertFalse(DateTimeUtils.isMonthMay(DateTimeUtils.MONTH_OCTOBER));
        assertFalse(DateTimeUtils.isMonthJune(DateTimeUtils.MONTH_OCTOBER));
        assertFalse(DateTimeUtils.isMonthJuly(DateTimeUtils.MONTH_OCTOBER));
        assertFalse(DateTimeUtils.isMonthAugust(DateTimeUtils.MONTH_OCTOBER));
        assertFalse(DateTimeUtils.isMonthSeptember(DateTimeUtils.MONTH_OCTOBER));
        assertTrue(DateTimeUtils.isMonthOctober(DateTimeUtils.MONTH_OCTOBER));
        assertFalse(DateTimeUtils.isMonthNovember(DateTimeUtils.MONTH_OCTOBER));
        assertFalse(DateTimeUtils.isMonthDecember(DateTimeUtils.MONTH_OCTOBER));
    }

    @Test
    public void test_IsMonth012() {
        assertFalse(DateTimeUtils.isMonthNotKnown(DateTimeUtils.MONTH_NOVEMBER));
        assertFalse(DateTimeUtils.isMonthJanuary(DateTimeUtils.MONTH_NOVEMBER));
        assertFalse(DateTimeUtils.isMonthFebruary(DateTimeUtils.MONTH_NOVEMBER));
        assertFalse(DateTimeUtils.isMonthMarch(DateTimeUtils.MONTH_NOVEMBER));
        assertFalse(DateTimeUtils.isMonthApril(DateTimeUtils.MONTH_NOVEMBER));
        assertFalse(DateTimeUtils.isMonthMay(DateTimeUtils.MONTH_NOVEMBER));
        assertFalse(DateTimeUtils.isMonthJune(DateTimeUtils.MONTH_NOVEMBER));
        assertFalse(DateTimeUtils.isMonthJuly(DateTimeUtils.MONTH_NOVEMBER));
        assertFalse(DateTimeUtils.isMonthAugust(DateTimeUtils.MONTH_NOVEMBER));
        assertFalse(DateTimeUtils.isMonthSeptember(DateTimeUtils.MONTH_NOVEMBER));
        assertFalse(DateTimeUtils.isMonthOctober(DateTimeUtils.MONTH_NOVEMBER));
        assertTrue(DateTimeUtils.isMonthNovember(DateTimeUtils.MONTH_NOVEMBER));
        assertFalse(DateTimeUtils.isMonthDecember(DateTimeUtils.MONTH_NOVEMBER));
    }

    @Test
    public void test_IsMonth013() {
        assertFalse(DateTimeUtils.isMonthNotKnown(DateTimeUtils.MONTH_DECEMBER));
        assertFalse(DateTimeUtils.isMonthJanuary(DateTimeUtils.MONTH_DECEMBER));
        assertFalse(DateTimeUtils.isMonthFebruary(DateTimeUtils.MONTH_DECEMBER));
        assertFalse(DateTimeUtils.isMonthMarch(DateTimeUtils.MONTH_DECEMBER));
        assertFalse(DateTimeUtils.isMonthApril(DateTimeUtils.MONTH_DECEMBER));
        assertFalse(DateTimeUtils.isMonthMay(DateTimeUtils.MONTH_DECEMBER));
        assertFalse(DateTimeUtils.isMonthJune(DateTimeUtils.MONTH_DECEMBER));
        assertFalse(DateTimeUtils.isMonthJuly(DateTimeUtils.MONTH_DECEMBER));
        assertFalse(DateTimeUtils.isMonthAugust(DateTimeUtils.MONTH_DECEMBER));
        assertFalse(DateTimeUtils.isMonthSeptember(DateTimeUtils.MONTH_DECEMBER));
        assertFalse(DateTimeUtils.isMonthOctober(DateTimeUtils.MONTH_DECEMBER));
        assertFalse(DateTimeUtils.isMonthNovember(DateTimeUtils.MONTH_DECEMBER));
        assertTrue(DateTimeUtils.isMonthDecember(DateTimeUtils.MONTH_DECEMBER));
    }

    @Test
    public void test_isDayOfMonthNotKnown001() {
        assertTrue(DateTimeUtils.isDayOfMonthNotKnown(DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN));
    }

    @Test
    public void test_isDayOfMonthNotKnown002() {
        assertFalse(DateTimeUtils.isDayOfMonthNotKnown(DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN + 1));
    }

}
