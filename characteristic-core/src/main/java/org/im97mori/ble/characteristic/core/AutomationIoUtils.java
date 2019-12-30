package org.im97mori.ble.characteristic.core;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.descriptor.CharacteristicPresentationFormat;
import org.im97mori.ble.descriptor.NumberOfDigitals;

/**
 * Utility for org.bluetooth.service.automation_io(0x1815) service
 */
@SuppressWarnings("WeakerAccess")
public class AutomationIoUtils {

    /**
     * 0: Inactive
     */
    public static final int DIGITAL_INACTIVE = 0;

    /**
     * 1: Active
     */
    public static final int DIGITAL_ACTIVE = 1;

    /**
     * 2: Tri-state
     */
    public static final int DIGITAL_TRI_STATE = 2;

    /**
     * 3: Output-state
     */
    public static final int DIGITAL_OUTPUT_STATE = 3;

    /**
     * @param index field index {@link NumberOfDigitals#getNoOfDigitals()}
     * @return {@code true}:Inactive, {@code false}:not Inactive
     */
    public static boolean isInactive(@NonNull byte[] data, int index) {
        return isMatched(data, index, DIGITAL_INACTIVE);
    }

    /**
     * @param index field index {@link NumberOfDigitals#getNoOfDigitals()}
     * @return {@code true}:Active, {@code false}:not Active
     */
    public static boolean isActive(@NonNull byte[] data, int index) {
        return isMatched(data, index, DIGITAL_ACTIVE);
    }

    /**
     * @param index field index {@link NumberOfDigitals#getNoOfDigitals()}
     * @return {@code true}:Tri-state, {@code false}:not Tri-state
     */
    public static boolean isTriState(@NonNull byte[] data, int index) {
        return isMatched(data, index, DIGITAL_TRI_STATE);
    }

    /**
     * @param index field index {@link NumberOfDigitals#getNoOfDigitals()}
     * @return {@code true}:Output-state, {@code false}:not Output-state
     */
    public static boolean isOutputState(@NonNull byte[] data, int index) {
        return isMatched(data, index, DIGITAL_OUTPUT_STATE);
    }


    /**
     * check Digital state
     *
     * @param index  field index {@link NumberOfDigitals#getNoOfDigitals()}
     * @param expect one of {@link #DIGITAL_INACTIVE}
     *               , {@link #DIGITAL_ACTIVE}
     *               , {@link #DIGITAL_TRI_STATE}
     *               , {@link #DIGITAL_OUTPUT_STATE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private static boolean isMatched(@NonNull byte[] data, int index, int expect) {
        int v = index / 4;
        int h = index % 4;
        return ((data[v] >> (h * 2)) & 0b00000011) == expect;
    }

    /**
     * @param format {@link CharacteristicPresentationFormat} from this characteristic
     * @return Analog with format
     */
    public static double getAnalogWithFormat(@NonNull byte[] data, @NonNull CharacteristicPresentationFormat format, int analogOffset) {
        int exponent = 0;
        double value = 0;
        if (CharacteristicPresentationFormat.FORMAT_UNSIGNED_8_BIT_INTEGER == format.getFormat()) {
            exponent = format.getExponent();
            value = BLEUtils.createUInt8(data, analogOffset);
        } else if (CharacteristicPresentationFormat.FORMAT_UNSIGNED_12_BIT_INTEGER == format.getFormat()) {
            exponent = format.getExponent();
            value = BLEUtils.createUInt12(data, analogOffset);
        } else if (CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER == format.getFormat()) {
            exponent = format.getExponent();
            value = BLEUtils.createUInt16(data, analogOffset);
        } else if (CharacteristicPresentationFormat.FORMAT_SIGNED_8_BIT_INTEGER == format.getFormat()) {
            exponent = format.getExponent();
            value = BLEUtils.createSInt8(data, analogOffset);
        } else if (CharacteristicPresentationFormat.FORMAT_SIGNED_12_BIT_INTEGER == format.getFormat()) {
            exponent = format.getExponent();
            value = BLEUtils.createSInt12(data, analogOffset);
        } else if (CharacteristicPresentationFormat.FORMAT_SIGNED_16_BIT_INTEGER == format.getFormat()) {
            exponent = format.getExponent();
            value = BLEUtils.createSInt16(data, analogOffset);
        } else if (CharacteristicPresentationFormat.FORMAT_IEEE_11073_16_BIT_SFLOAT == format.getFormat()) {
            value = BLEUtils.createSfloat(data, analogOffset);
        }
//        else if (CharacteristicPresentationFormat.FORMAT_IEEE_20601_FORMAT == format.getFormat()) {
//            // TODO duint16 from 2 octets? need multiple packet?
//        }
        return value * Math.pow(10, exponent);
    }
}
