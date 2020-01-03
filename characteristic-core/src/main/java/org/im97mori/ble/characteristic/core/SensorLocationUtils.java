package org.im97mori.ble.characteristic.core;

/**
 * Utility for org.bluetooth.characteristic.sensor_location(0x2A5D) characteristic
 */
@SuppressWarnings("WeakerAccess")
public class SensorLocationUtils {

    /**
     * 0: Other
     */
    public static final int SENSOR_LOCATION_OTHER = 0;

    /**
     * 1: Top of shoe
     */
    public static final int SENSOR_LOCATION_TOP_OF_SHOE = 1;

    /**
     * 2: In shoe
     */
    public static final int SENSOR_LOCATION_IN_SHOE = 2;

    /**
     * 3: Hip
     */
    public static final int SENSOR_LOCATION_HIP = 3;

    /**
     * 4: Front Wheel
     */
    public static final int SENSOR_LOCATION_FRONT_WHEEL = 4;

    /**
     * 5: Left Crank
     */
    public static final int SENSOR_LOCATION_LEFT_CRANK = 5;

    /**
     * 6: Right Crank
     */
    public static final int SENSOR_LOCATION_RIGHT_CRANK = 6;

    /**
     * 7: Left Pedal
     */
    public static final int SENSOR_LOCATION_LEFT_PEDAL = 7;

    /**
     * 8: Right Pedal
     */
    public static final int SENSOR_LOCATION_RIGHT_PEDAL = 8;

    /**
     * 9: Front Hub
     */
    public static final int SENSOR_LOCATION_FRONT_HUB = 9;

    /**
     * 10: Rear Dropout
     */
    public static final int SENSOR_LOCATION_REAR_DROPOUT = 10;

    /**
     * 11: Chainstay
     */
    public static final int SENSOR_LOCATION_CHAINSTAY = 11;

    /**
     * 12: Rear Wheel
     */
    public static final int SENSOR_LOCATION_REAR_WHEEL = 12;

    /**
     * 13: Rear Hub
     */
    public static final int SENSOR_LOCATION_REAR_HUB = 13;

    /**
     * 14: Chest
     */
    public static final int SENSOR_LOCATION_CHEST = 14;

    /**
     * 15: Spider
     */
    public static final int SENSOR_LOCATION_SPIDER = 15;

    /**
     * 16: Chain Ring
     */
    public static final int SENSOR_LOCATION_CHAIN_RING = 16;

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Ohter, {@code false}:not Other
     */
    public static boolean isSensorLocationOhter(int sensorLocation) {
        return SENSOR_LOCATION_OTHER == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Top of shoe, {@code false}:not Top of shoe
     */
    public static boolean isSensorLocationTopOfShoe(int sensorLocation) {
        return SENSOR_LOCATION_TOP_OF_SHOE == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Top of shoe, {@code false}:not Top of shoe
     */
    public static boolean isSensorLocationInShoe(int sensorLocation) {
        return SENSOR_LOCATION_IN_SHOE == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Hip, {@code false}:not Hip
     */
    public static boolean isSensorLocationHip(int sensorLocation) {
        return SENSOR_LOCATION_HIP == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Front Wheel, {@code false}:not Front Wheel
     */
    public static boolean isSensorLocationFrontWheel(int sensorLocation) {
        return SENSOR_LOCATION_FRONT_WHEEL == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Left Crank, {@code false}:not Left Crank
     */
    public static boolean isSensorLocationLeftCrank(int sensorLocation) {
        return SENSOR_LOCATION_LEFT_CRANK == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Right Crank, {@code false}:not Right Crank
     */
    public static boolean isSensorLocationRightCrank(int sensorLocation) {
        return SENSOR_LOCATION_RIGHT_CRANK == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Left Pedal, {@code false}:not Left Pedal
     */
    public static boolean isSensorLocationLeftPedal(int sensorLocation) {
        return SENSOR_LOCATION_LEFT_PEDAL == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Right, {@code false}:not Right Pedal
     */
    public static boolean isSensorLocationRightPedal(int sensorLocation) {
        return SENSOR_LOCATION_RIGHT_PEDAL == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Front Hub, {@code false}:not Front Hub
     */
    public static boolean isSensorLocationFrontHub(int sensorLocation) {
        return SENSOR_LOCATION_FRONT_HUB == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Rear Dropout, {@code false}:not Rear Dropout
     */
    public static boolean isSensorLocationRearDropout(int sensorLocation) {
        return SENSOR_LOCATION_REAR_DROPOUT == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Chainstay, {@code false}:not Chainstay
     */
    public static boolean isSensorLocationChainstay(int sensorLocation) {
        return SENSOR_LOCATION_CHAINSTAY == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Rear Wheel, {@code false}:not Rear Wheel
     */
    public static boolean isSensorLocationRearWheel(int sensorLocation) {
        return SENSOR_LOCATION_REAR_WHEEL == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Rear Hub, {@code false}:not Rear Hub
     */
    public static boolean isSensorLocationRearHub(int sensorLocation) {
        return SENSOR_LOCATION_REAR_HUB == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Chest, {@code false}:not Chest
     */
    public static boolean isSensorLocationChest(int sensorLocation) {
        return SENSOR_LOCATION_CHEST == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Spider, {@code false}:not Spider
     */
    public static boolean isSensorLocationSpider(int sensorLocation) {
        return SENSOR_LOCATION_SPIDER == sensorLocation;
    }

    /**
     * @param sensorLocation Sensor Location
     * @return {@code true}:Chain Ring, {@code false}:not Chain Ring
     */
    public static boolean isSensorLocationChainRing(int sensorLocation) {
        return SENSOR_LOCATION_CHAIN_RING == sensorLocation;
    }

}
