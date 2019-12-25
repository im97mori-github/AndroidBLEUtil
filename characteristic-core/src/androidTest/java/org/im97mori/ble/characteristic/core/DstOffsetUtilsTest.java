package org.im97mori.ble.characteristic.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DstOffsetUtilsTest {

    @Test
    public void test_isDstOffsetStandardTime001(){
        assertTrue(DstOffsetUtils.isDstOffsetStandardTime(DstOffsetUtils.DST_OFFSET_STANDARD_TIME));
    }

    @Test
    public void test_isDstOffsetStandardTime002(){
        assertFalse(DstOffsetUtils.isDstOffsetStandardTime(DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstOffsetStandardTime003(){
        assertFalse(DstOffsetUtils.isDstOffsetStandardTime(DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstOffsetStandardTime004(){
        assertFalse(DstOffsetUtils.isDstOffsetStandardTime(DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstOffsetStandardTime005(){
        assertFalse(DstOffsetUtils.isDstOffsetStandardTime(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN));
    }

    @Test
    public void test_isDstOffsetHalfAnHourDaylightTime001(){
        assertFalse(DstOffsetUtils.isDstOffsetHalfAnHourDaylightTime(DstOffsetUtils.DST_OFFSET_STANDARD_TIME));
    }

    @Test
    public void test_isDstOffsetHalfAnHourDaylightTime002(){
        assertTrue(DstOffsetUtils.isDstOffsetHalfAnHourDaylightTime(DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstOffsetHalfAnHourDaylightTime003(){
        assertFalse(DstOffsetUtils.isDstOffsetHalfAnHourDaylightTime(DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstOffsetHalfAnHourDaylightTime004(){
        assertFalse(DstOffsetUtils.isDstOffsetHalfAnHourDaylightTime(DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstOffsetHalfAnHourDaylightTime005(){
        assertFalse(DstOffsetUtils.isDstOffsetHalfAnHourDaylightTime(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN));
    }

    @Test
    public void test_isDstOffsetDaylightTime001(){
        assertFalse(DstOffsetUtils.isDstOffsetDaylightTime(DstOffsetUtils.DST_OFFSET_STANDARD_TIME));
    }

    @Test
    public void test_isDstOffsetDaylightTime002(){
        assertFalse(DstOffsetUtils.isDstOffsetDaylightTime(DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstOffsetDaylightTime003(){
        assertTrue(DstOffsetUtils.isDstOffsetDaylightTime(DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstOffsetDaylightTime004(){
        assertFalse(DstOffsetUtils.isDstOffsetDaylightTime(DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstOffsetDaylightTime005(){
        assertFalse(DstOffsetUtils.isDstOffsetDaylightTime(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN));
    }

    @Test
    public void test_isDstOffsetDoubleDaylightTime001(){
        assertFalse(DstOffsetUtils.isDstOffsetDoubleDaylightTime(DstOffsetUtils.DST_OFFSET_STANDARD_TIME));
    }

    @Test
    public void test_isDstOffsetDoubleDaylightTime002(){
        assertFalse(DstOffsetUtils.isDstOffsetDoubleDaylightTime(DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstOffsetDoubleDaylightTime003(){
        assertFalse(DstOffsetUtils.isDstOffsetDoubleDaylightTime(DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstOffsetDoubleDaylightTime004(){
        assertTrue(DstOffsetUtils.isDstOffsetDoubleDaylightTime(DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstOffsetDoubleDaylightTime005(){
        assertFalse(DstOffsetUtils.isDstOffsetDoubleDaylightTime(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN));
    }

    @Test
    public void test_isDstNotKnown001(){
        assertFalse(DstOffsetUtils.isDstNotKnown(DstOffsetUtils.DST_OFFSET_STANDARD_TIME));
    }

    @Test
    public void test_isDstNotKnown002(){
        assertFalse(DstOffsetUtils.isDstNotKnown(DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstNotKnown003(){
        assertFalse(DstOffsetUtils.isDstNotKnown(DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstNotKnown004(){
        assertFalse(DstOffsetUtils.isDstNotKnown(DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME));
    }

    @Test
    public void test_isDstNotKnown005(){
        assertTrue(DstOffsetUtils.isDstNotKnown(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN));
    }

    @Test
    public void test_getDstOffsetMin001() {
        assertEquals(DstOffsetUtils.DST_OFFSET_UNIT * DstOffsetUtils.DST_OFFSET_STANDARD_TIME, DstOffsetUtils.getDstOffsetMin(DstOffsetUtils.DST_OFFSET_STANDARD_TIME));
    }

    @Test
    public void test_getDstOffsetMin002() {
        assertEquals(DstOffsetUtils.DST_OFFSET_UNIT * DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME, DstOffsetUtils.getDstOffsetMin(DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME));
    }

    @Test
    public void test_getDstOffsetMin003() {
        assertEquals(DstOffsetUtils.DST_OFFSET_UNIT * DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME, DstOffsetUtils.getDstOffsetMin(DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME));
    }

    @Test
    public void test_getDstOffsetMin004() {
        assertEquals(DstOffsetUtils.DST_OFFSET_UNIT * DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME, DstOffsetUtils.getDstOffsetMin(DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME));
    }

    @Test
    public void test_getDstOffsetMin005() {
        assertEquals(DstOffsetUtils.DST_OFFSET_UNIT * DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN, DstOffsetUtils.getDstOffsetMin(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN));
    }

    @Test
    public void test_getDstOffsetMillis001() {
        assertEquals(DstOffsetUtils.DST_OFFSET_UNIT * DstOffsetUtils.DST_OFFSET_STANDARD_TIME * 1000L, DstOffsetUtils.getDstOffsetMillis(DstOffsetUtils.DST_OFFSET_STANDARD_TIME));
    }

    @Test
    public void test_getDstOffsetMillis002() {
        assertEquals(DstOffsetUtils.DST_OFFSET_UNIT * DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME * 1000L, DstOffsetUtils.getDstOffsetMillis(DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME));
    }

    @Test
    public void test_getDstOffsetMillis003() {
        assertEquals(DstOffsetUtils.DST_OFFSET_UNIT * DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME * 1000L, DstOffsetUtils.getDstOffsetMillis(DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME));
    }

    @Test
    public void test_getDstOffsetMillis004() {
        assertEquals(DstOffsetUtils.DST_OFFSET_UNIT * DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME * 1000L, DstOffsetUtils.getDstOffsetMillis(DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME));
    }

    @Test
    public void test_getDstOffsetMillis005() {
        assertEquals(DstOffsetUtils.DST_OFFSET_UNIT * DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN * 1000L, DstOffsetUtils.getDstOffsetMillis(DstOffsetUtils.DST_OFFSET_IS_NOT_KNOWN));
    }

}
