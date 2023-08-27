package org.im97mori.ble.characteristic.u2b4b;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class DeviceWearingPositionAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        //noinspection DataFlowIssue
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_OTHER;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_HEAD;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_HEAD_EAR;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_HEAD_EAR_RIGHT;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_HEAD_EAR_LEFT;
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_HEAD_NECK;
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK;
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK_PELVIS;
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK_PELVIS_RIGHT;
        data_00009 = data;
    }

    private static final byte[] data_00010;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK_PELVIS_LEFT;
        data_00010 = data;
    }

    private static final byte[] data_00011;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK_THORAX;
        data_00011 = data;
    }
    
    private static final byte[] data_00012;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK_THORAX_RIGHT;
        data_00012 = data;
    }

    private static final byte[] data_00013;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK_THORAX_LEFT;
        data_00013 = data;
    }

    private static final byte[] data_00014;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK_BACK;
        data_00014 = data;
    }

    private static final byte[] data_00015;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY;
        data_00015 = data;
    }

    private static final byte[] data_00016;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_RIGHT;
        data_00016 = data;
    }

    private static final byte[] data_00017;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_LEFT;
        data_00017 = data;
    }

    private static final byte[] data_00018;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_WRIST;
        data_00018 = data;
    }

    private static final byte[] data_00019;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_WRIST_RIGHT;
        data_00019 = data;
    }

    private static final byte[] data_00020;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_WRIST_LEFT;
        data_00020 = data;
    }

    private static final byte[] data_00021;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_FINGER;
        data_00021 = data;
    }

    private static final byte[] data_00022;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_FINGER_RIGHT;
        data_00022 = data;
    }
    
    private static final byte[] data_00023;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_FINGER_LEFT;
        data_00023 = data;
    }

    private static final byte[] data_00024;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_HAND;
        data_00024 = data;
    }
    
    private static final byte[] data_00025;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_HAND_RIGHT;
        data_00025 = data;
    }

    private static final byte[] data_00026;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_HAND_LEFT;
        data_00026 = data;
    }

    private static final byte[] data_00027;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY;
        data_00027 = data;
    }

    private static final byte[] data_00028;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_RIGHT;
        data_00028 = data;
    }

    private static final byte[] data_00029;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_LEFT;
        data_00029 = data;
    }

    private static final byte[] data_00030;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_ANKLE;
        data_00030 = data;
    }

    private static final byte[] data_00031;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_ANKLE_RIGHT;
        data_00031 = data;
    }

    private static final byte[] data_00032;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_ANKLE_LEFT;
        data_00032 = data;
    }

    private static final byte[] data_00033;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_FOOT;
        data_00033 = data;
    }
    
    private static final byte[] data_00034;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_FOOT_RIGHT;
        data_00034 = data;
    }

    private static final byte[] data_00035;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_FOOT_LEFT;
        data_00035 = data;
    }

    private static final byte[] data_00036;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_PANTS_POCKET;
        data_00036 = data;
    }

    private static final byte[] data_00037;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_PANTS_POCKET_RIGHT;
        data_00037 = data;
    }

    private static final byte[] data_00038;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_PANTS_POCKET_LEFT;
        data_00038 = data;
    }

    private static final byte[] data_00039;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_CHEST_POCKET;
        data_00039 = data;
    }

    private static final byte[] data_00040;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_CHEST_POCKET_RIGHT;
        data_00040 = data;
    }

    private static final byte[] data_00041;
    static {
        byte[] data = new byte[1];
        data[ 0] = DeviceWearingPosition.DEVICE_WEARING_POSITION_CHEST_POCKET_LEFT;
        data_00041 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_OTHER, result1.getDeviceWearingPosition());
        assertTrue(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_HEAD, result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertTrue(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_HEAD_EAR, result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertTrue(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_HEAD_EAR_RIGHT, result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertTrue(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00005() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_HEAD_EAR_LEFT, result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertTrue(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00006() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_HEAD_NECK, result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertTrue(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00007() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK, result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertTrue(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00008() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK_PELVIS, result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertTrue(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00009() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK_PELVIS_RIGHT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertTrue(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00010() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK_PELVIS_LEFT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertTrue(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00011() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK_THORAX, result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertTrue(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00012() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK_THORAX_RIGHT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertTrue(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00013() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK_THORAX_LEFT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertTrue(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00014() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_TRUNK_BACK, result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertTrue(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00015() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY, result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertTrue(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00016() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_RIGHT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertTrue(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00017() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_LEFT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertTrue(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00018() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_WRIST,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertTrue(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00019() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_WRIST_RIGHT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertTrue(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00020() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_WRIST_LEFT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertTrue(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00021() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_FINGER,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertTrue(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00022() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_FINGER_RIGHT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertTrue(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00023() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_FINGER_LEFT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertTrue(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00024() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_HAND,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertTrue(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00025() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_HAND_RIGHT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertTrue(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00026() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_UPPER_EXTREMITY_HAND_LEFT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertTrue(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00027() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY, result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertTrue(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00028() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_RIGHT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertTrue(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00029() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_LEFT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertTrue(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00030() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_ANKLE,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertTrue(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00031() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_ANKLE_RIGHT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertTrue(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00032() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_ANKLE_LEFT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertTrue(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00033() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_FOOT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertTrue(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00034() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_FOOT_RIGHT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertTrue(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00035() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_LOWER_EXTREMITY_FOOT_LEFT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertTrue(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00036() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_PANTS_POCKET, result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertTrue(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00037() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_PANTS_POCKET_RIGHT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertTrue(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00038() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_PANTS_POCKET_LEFT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertTrue(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00039() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_CHEST_POCKET, result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertTrue(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00040() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_CHEST_POCKET_RIGHT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertTrue(result1.isDeviceWearingPositionChestPocketRight());
        assertFalse(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00041() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_CHEST_POCKET_LEFT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertTrue(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_constructor_00101() {
        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(
                DeviceWearingPosition.DEVICE_WEARING_POSITION_CHEST_POCKET_LEFT);
        assertEquals(DeviceWearingPosition.DEVICE_WEARING_POSITION_CHEST_POCKET_LEFT,
                result1.getDeviceWearingPosition());
        assertFalse(result1.isDeviceWearingPositionOther());
        assertFalse(result1.isDeviceWearingPositionHead());
        assertFalse(result1.isDeviceWearingPositionHeadEar());
        assertFalse(result1.isDeviceWearingPositionHeadEarRight());
        assertFalse(result1.isDeviceWearingPositionHeadEarLeft());
        assertFalse(result1.isDeviceWearingPositionHeadNeck());
        assertFalse(result1.isDeviceWearingPositionTrunk());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvis());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisRight());
        assertFalse(result1.isDeviceWearingPositionTrunkPelvisLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThorax());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxRight());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxLeft());
        assertFalse(result1.isDeviceWearingPositionTrunkThoraxBack());
        assertFalse(result1.isDeviceWearingPositionUpperExtremity());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWrist());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityWristLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFinger());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityFingerLeft());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHand());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandRight());
        assertFalse(result1.isDeviceWearingPositionUpperExtremityHandLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremity());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkle());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityAnkleLeft());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFoot());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootRight());
        assertFalse(result1.isDeviceWearingPositionLowerExtremityFootLeft());
        assertFalse(result1.isDeviceWearingPositionPantsPocket());
        assertFalse(result1.isDeviceWearingPositionPantsPocketRight());
        assertFalse(result1.isDeviceWearingPositionPantsPocketLeft());
        assertFalse(result1.isDeviceWearingPositionChestPocket());
        assertFalse(result1.isDeviceWearingPositionChestPocketRight());
        assertTrue(result1.isDeviceWearingPositionChestPocketLeft());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00010() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00011() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00012() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00013() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00014() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00015() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00016() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00017() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00018() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00019() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00020() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00021() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00022() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00023() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00024() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00025() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00026() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00027() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00028() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00029() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00030() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00031() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00032() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00033() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00034() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00035() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00036() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00037() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00038() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00039() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00040() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_1_00041() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getDeviceWearingPosition(), result2.getDeviceWearingPosition());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00010() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00011() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00012() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00013() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00014() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00015() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00016() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00017() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00018() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00019() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00020() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00021() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00022() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00023() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00024() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00025() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00026() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00027() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00028() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00029() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00030() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00031() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00032() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00033() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00034() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00035() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00036() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00037() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00038() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00039() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00040() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00041() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00010() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00011() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }


    @Test
    public void test_parcelable_3_00012() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00013() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00014() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00015() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00016() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00017() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00018() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00019() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00020() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00021() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }


    @Test
    public void test_parcelable_3_00022() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00023() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00024() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00025() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00026() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00027() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00028() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00029() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00030() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00031() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }


    @Test
    public void test_parcelable_3_00032() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00033() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00034() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00035() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00036() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00037() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00038() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00039() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00040() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00041() {
        byte[] data = getData();

        DeviceWearingPositionAndroid result1 = new DeviceWearingPositionAndroid(data);
        DeviceWearingPositionAndroid result2 = DeviceWearingPositionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
