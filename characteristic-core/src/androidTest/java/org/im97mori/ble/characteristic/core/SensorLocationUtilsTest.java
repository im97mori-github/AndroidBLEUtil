package org.im97mori.ble.characteristic.core;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SensorLocationUtilsTest {

    @Test
    public void test_isSensorLocationOhter_001() {
        assertTrue(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationOhter(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationTopOfShoe_001() {
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertTrue(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationTopOfShoe(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationInShoe_001() {
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertTrue(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationInShoe(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationHip_001() {
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertTrue(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationHip(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationFrontWheel_001() {
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertTrue(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationFrontWheel(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationLeftCrank_001() {
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertTrue(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationLeftCrank(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationRightCrank_001() {
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertTrue(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationRightCrank(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationLeftPedal_001() {
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertTrue(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationLeftPedal(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationRightPedal_001() {
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertTrue(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationRightPedal(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationFrontHub_001() {
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertTrue(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationFrontHub(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationRearDropout_001() {
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertTrue(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationRearDropout(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationChainstay_001() {
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertTrue(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationChainstay(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationRearWheel_001() {
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertTrue(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationRearWheel(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationRearHub_001() {
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertTrue(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationRearHub(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationChest_001() {
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertTrue(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationChest(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationSpider_001() {
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertTrue(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertFalse(SensorLocationUtils.isSensorLocationSpider(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

    @Test
    public void test_isSensorLocationChainRing_001() {
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_OTHER));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_IN_SHOE));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_HIP));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_REAR_HUB));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_CHEST));
        assertFalse(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_SPIDER));
        assertTrue(SensorLocationUtils.isSensorLocationChainRing(SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING));
    }

}
