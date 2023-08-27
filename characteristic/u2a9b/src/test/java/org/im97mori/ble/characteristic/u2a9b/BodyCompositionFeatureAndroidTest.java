package org.im97mori.ble.characteristic.u2a9b;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class BodyCompositionFeatureAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor002() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_TRUE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertTrue(result1.isTimeStampSupported());
        assertFalse(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor003() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_TRUE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertTrue(result1.isMultipleUsersSupported());
        assertFalse(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor004() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_TRUE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertTrue(result1.isBasalMetabolismSupported());
        assertFalse(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor005() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_TRUE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertTrue(result1.isMusclePercentageSupported());
        assertFalse(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor006() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_TRUE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertTrue(result1.isMuscleMassSupported());
        assertFalse(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor007() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_TRUE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertTrue(result1.isFatFreeMassSupported());
        assertFalse(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor008() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_TRUE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertTrue(result1.isSoftLeanMassSupported());
        assertFalse(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor009() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_TRUE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertTrue(result1.isBodyWaterMassSupported());
        assertFalse(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor010() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_TRUE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertTrue(result1.isImpedanceSupported());
        assertFalse(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor011() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_TRUE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertTrue(result1.isWeightSupported());
        assertFalse(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor012() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_TRUE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertTrue(result1.isHeightSupported());
        assertFalse(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor013() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_5KG_OR_1LB
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertFalse(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertTrue(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor014() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_2KG_OR_0_5LB
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertFalse(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertTrue(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor015() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_1KG_OR_0_2LB
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertFalse(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertTrue(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor016() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_05KG_OR_0_1B
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertFalse(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertTrue(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor017() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_02KG_OR_0_05B
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertFalse(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertTrue(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor018() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_01KG_OR_0_02B
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertFalse(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertTrue(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor019() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_005KG_OR_0_01B
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertFalse(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertTrue(result1.isMassScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor020() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_01_METER_OR_1INCH;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertFalse(result1.isHeightMeasurementResolutionNotSpecified());
        assertTrue(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor021() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_005METER_OR_0_5INCH;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertFalse(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertTrue(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor022() {
        int flags = BodyCompositionFeatureAndroid.TIME_STAMP_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MULTIPLE_USERS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BASAL_METABOLISM_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_PERCENTAGE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MUSCLE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.FAT_FREE_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.SOTT_LEAN_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.BODY_WATER_MASS_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.IMPEDANCE_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.WEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.HEIGHT_SUPPORTED_FALSE
                | BodyCompositionFeatureAndroid.MASS_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | BodyCompositionFeatureAndroid.HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_001METER_OR_0_1INCH;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBodyCompositionFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBasalMetabolismSupported());
        assertTrue(result1.isBasalMetabolismNotSupported());
        assertFalse(result1.isMusclePercentageSupported());
        assertTrue(result1.isMusclePercentageNotSupported());
        assertFalse(result1.isMuscleMassSupported());
        assertTrue(result1.isMuscleMassNotSupported());
        assertFalse(result1.isFatFreeMassSupported());
        assertTrue(result1.isFatFreeMassNotSupported());
        assertFalse(result1.isSoftLeanMassSupported());
        assertTrue(result1.isSoftLeanMassNotSupported());
        assertFalse(result1.isBodyWaterMassSupported());
        assertTrue(result1.isBodyWaterMassNotSupported());
        assertFalse(result1.isImpedanceSupported());
        assertTrue(result1.isImpedanceNotSupported());
        assertFalse(result1.isWeightSupported());
        assertTrue(result1.isWeightNotSupported());
        assertFalse(result1.isHeightSupported());
        assertTrue(result1.isHeightNotSupported());
        assertTrue(result1.isMassScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isMassScaleMeasurementResolution1());
        assertFalse(result1.isMassScaleMeasurementResolution2());
        assertFalse(result1.isMassScaleMeasurementResolution3());
        assertFalse(result1.isMassScaleMeasurementResolution4());
        assertFalse(result1.isMassScaleMeasurementResolution5());
        assertFalse(result1.isMassScaleMeasurementResolution6());
        assertFalse(result1.isMassScaleMeasurementResolution7());
        assertFalse(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertTrue(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionFeatureAndroid result2 = BodyCompositionFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getBodyCompositionFeature(), result2.getBodyCompositionFeature());
        assertEquals(result1.isTimeStampSupported(), result2.isTimeStampSupported());
        assertEquals(result1.isTimeStampNotSupported(), result2.isTimeStampNotSupported());
        assertEquals(result1.isMultipleUsersSupported(), result2.isMultipleUsersSupported());
        assertEquals(result1.isMultipleUsersNotSupported(), result2.isMultipleUsersNotSupported());
        assertEquals(result1.isBasalMetabolismSupported(), result2.isBasalMetabolismSupported());
        assertEquals(result1.isBasalMetabolismNotSupported(), result2.isBasalMetabolismNotSupported());
        assertEquals(result1.isMusclePercentageSupported(), result2.isMusclePercentageSupported());
        assertEquals(result1.isMusclePercentageNotSupported(), result2.isMusclePercentageNotSupported());
        assertEquals(result1.isMuscleMassSupported(), result2.isMuscleMassSupported());
        assertEquals(result1.isMuscleMassNotSupported(), result2.isMuscleMassNotSupported());
        assertEquals(result1.isFatFreeMassSupported(), result2.isFatFreeMassSupported());
        assertEquals(result1.isFatFreeMassNotSupported(), result2.isFatFreeMassNotSupported());
        assertEquals(result1.isSoftLeanMassSupported(), result2.isSoftLeanMassSupported());
        assertEquals(result1.isSoftLeanMassNotSupported(), result2.isSoftLeanMassNotSupported());
        assertEquals(result1.isBodyWaterMassSupported(), result2.isBodyWaterMassSupported());
        assertEquals(result1.isBodyWaterMassNotSupported(), result2.isBodyWaterMassNotSupported());
        assertEquals(result1.isImpedanceSupported(), result2.isImpedanceSupported());
        assertEquals(result1.isImpedanceNotSupported(), result2.isImpedanceNotSupported());
        assertEquals(result1.isWeightSupported(), result2.isWeightSupported());
        assertEquals(result1.isWeightNotSupported(), result2.isWeightNotSupported());
        assertEquals(result1.isHeightSupported(), result2.isHeightSupported());
        assertEquals(result1.isHeightNotSupported(), result2.isHeightNotSupported());
        assertEquals(result1.isMassScaleMeasurementResolutionNotSpecified(), result2.isMassScaleMeasurementResolutionNotSpecified());
        assertEquals(result1.isMassScaleMeasurementResolution1(), result2.isMassScaleMeasurementResolution1());
        assertEquals(result1.isMassScaleMeasurementResolution2(), result2.isMassScaleMeasurementResolution2());
        assertEquals(result1.isMassScaleMeasurementResolution3(), result2.isMassScaleMeasurementResolution3());
        assertEquals(result1.isMassScaleMeasurementResolution4(), result2.isMassScaleMeasurementResolution4());
        assertEquals(result1.isMassScaleMeasurementResolution5(), result2.isMassScaleMeasurementResolution5());
        assertEquals(result1.isMassScaleMeasurementResolution6(), result2.isMassScaleMeasurementResolution6());
        assertEquals(result1.isMassScaleMeasurementResolution7(), result2.isMassScaleMeasurementResolution7());
        assertEquals(result1.isHeightMeasurementResolutionNotSpecified(), result2.isHeightMeasurementResolutionNotSpecified());
        assertEquals(result1.isHeightMeasurementResolution1(), result2.isHeightMeasurementResolution1());
        assertEquals(result1.isHeightMeasurementResolution2(), result2.isHeightMeasurementResolution2());
        assertEquals(result1.isHeightMeasurementResolution3(), result2.isHeightMeasurementResolution3());
    }


    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BodyCompositionFeatureAndroid result1 = new BodyCompositionFeatureAndroid(data);
        BodyCompositionFeatureAndroid result2 = BodyCompositionFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
