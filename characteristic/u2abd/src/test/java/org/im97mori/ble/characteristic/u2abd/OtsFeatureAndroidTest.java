package org.im97mori.ble.characteristic.u2abd;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

@SuppressWarnings({"unused", "ConstantConditions"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class OtsFeatureAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_FALSE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00001 = data;
    }

    private static final byte[] data_00002;

    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_TRUE | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_FALSE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00002 = data;
    }

    private static final byte[] data_00003;

    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_TRUE
                | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_FALSE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00003 = data;
    }

    private static final byte[] data_00004;

    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_TRUE
                | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_FALSE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00004 = data;
    }

    private static final byte[] data_00005;

    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_TRUE | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_FALSE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00005 = data;
    }

    private static final byte[] data_00006;

    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_TRUE
                | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_FALSE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00006 = data;
    }

    private static final byte[] data_00007;

    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_TRUE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_FALSE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00007 = data;
    }

    private static final byte[] data_00008;

    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_TRUE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_FALSE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00008 = data;
    }

    private static final byte[] data_00009;

    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_TRUE | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_FALSE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00009 = data;
    }

    private static final byte[] data_00010;

    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_TRUE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_FALSE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00010 = data;
    }

    private static final byte[] data_00011;

    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_TRUE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00011 = data;
    }

    private static final byte[] data_00012;

    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_FALSE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_TRUE | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00012 = data;
    }

    private static final byte[] data_00013;

    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_FALSE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_TRUE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00013 = data;
    }

    private static final byte[] data_00014;

    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_FALSE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_TRUE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00014 = data;
    }

    private static final byte[] data_00015;

    static {
        int oacpFeature = OtsFeature.OACP_CREATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_DELETE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE | OtsFeature.OACP_READ_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OACP_WRITE_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE | OtsFeature.PATCHING_OF_OBJECTS_SUPPORTED_FALSE
                | OtsFeature.OACP_ABORT_OP_CODE_SUPPORTED_FALSE;
        int olcpFeature = OtsFeature.OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE | OtsFeature.OLCP_ORDER_OP_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE
                | OtsFeature.OLCP_CLEAR_MARKING_CODE_SUPPORTED_TRUE;
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) oacpFeature;
        data[ 1] = (byte) (oacpFeature >> 8);
        data[ 2] = (byte) (oacpFeature >> 16);
        data[ 3] = (byte) (oacpFeature >> 24);
        data[ 4] = (byte) olcpFeature;
        data[ 5] = (byte) (olcpFeature >> 8);
        data[ 6] = (byte) (olcpFeature >> 16);
        data[ 7] = (byte) (olcpFeature >> 24);
        //@formatter:on
        data_00015 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertFalse(result1.isOacpCreateOpCodeNotSupported());
        assertTrue(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertFalse(result1.isOacpDeleteOpCodeNotSupported());
        assertTrue(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_1_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertFalse(result1.isOacpCalculateOpCodeNotSupported());
        assertTrue(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_1_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertFalse(result1.isOacpExecuteOpCodeNotSupported());
        assertTrue(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_1_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertFalse(result1.isOacpReadOpCodeNotSupported());
        assertTrue(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_1_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertFalse(result1.isOacpWriteOpCodeNotSupported());
        assertTrue(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_1_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_1_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertFalse(result1.isTruncationOfObjectsNotSupported());
        assertTrue(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_1_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertFalse(result1.isPatchingOfObjectsNotSupported());
        assertTrue(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_1_00011() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertFalse(result1.isOacpAbortOpCodeNotSupported());
        assertTrue(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_1_00012() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertFalse(result1.isOlcpGoToOpCodeNotSupported());
        assertTrue(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_1_00013() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertFalse(result1.isOlcpOrderOpCodeNotSupported());
        assertTrue(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_1_00014() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_1_00015() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(false, false, false, false, false, false, false, false, false, false, false,
                false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00002() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(true, false, false, false, false, false, false, false, false, false, false,
                false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertFalse(result1.isOacpCreateOpCodeNotSupported());
        assertTrue(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00003() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(false, true, false, false, false, false, false, false, false, false, false,
                false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertFalse(result1.isOacpDeleteOpCodeNotSupported());
        assertTrue(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00004() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(false, false, true, false, false, false, false, false, false, false, false,
                false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertFalse(result1.isOacpCalculateOpCodeNotSupported());
        assertTrue(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00005() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(false, false, false, true, false, false, false, false, false, false, false,
                false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertFalse(result1.isOacpExecuteOpCodeNotSupported());
        assertTrue(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00006() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(false, false, false, false, true, false, false, false, false, false, false,
                false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertFalse(result1.isOacpReadOpCodeNotSupported());
        assertTrue(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00007() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(false, false, false, false, false, true, false, false, false, false, false,
                false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertFalse(result1.isOacpWriteOpCodeNotSupported());
        assertTrue(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00008() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(false, false, false, false, false, false, true, false, false, false, false,
                false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00009() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(false, false, false, false, false, false, false, true, false, false, false,
                false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertFalse(result1.isTruncationOfObjectsNotSupported());
        assertTrue(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00010() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(false, false, false, false, false, false, false, false, true, false, false,
                false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertFalse(result1.isPatchingOfObjectsNotSupported());
        assertTrue(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00011() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(false, false, false, false, false, false, false, false, false, true, false,
                false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertFalse(result1.isOacpAbortOpCodeNotSupported());
        assertTrue(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00012() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(false, false, false, false, false, false, false, false, false, false, true,
                false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertFalse(result1.isOlcpGoToOpCodeNotSupported());
        assertTrue(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00013() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(false, false, false, false, false, false, false, false, false, false, false,
                true, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertFalse(result1.isOlcpOrderOpCodeNotSupported());
        assertTrue(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00014() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(false, false, false, false, false, false, false, false, false, false, false,
                false, true, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_constructor_2_00015() {
        byte[] data = getData();

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(false, false, false, false, false, false, false, false, false, false, false,
                false, false, true);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getOacpFeatures());
        assertTrue(result1.isOacpCreateOpCodeNotSupported());
        assertFalse(result1.isOacpCreateOpCodeSupported());
        assertTrue(result1.isOacpDeleteOpCodeNotSupported());
        assertFalse(result1.isOacpDeleteOpCodeSupported());
        assertTrue(result1.isOacpCalculateOpCodeNotSupported());
        assertFalse(result1.isOacpCalculateOpCodeSupported());
        assertTrue(result1.isOacpExecuteOpCodeNotSupported());
        assertFalse(result1.isOacpExecuteOpCodeSupported());
        assertTrue(result1.isOacpReadOpCodeNotSupported());
        assertFalse(result1.isOacpReadOpCodeSupported());
        assertTrue(result1.isOacpWriteOpCodeNotSupported());
        assertFalse(result1.isOacpWriteOpCodeSupported());
        assertTrue(result1.isAppendingAdditionalDataToObjectsNotSupported());
        assertFalse(result1.isAppendingAdditionalDataToObjectsSupported());
        assertTrue(result1.isTruncationOfObjectsNotSupported());
        assertFalse(result1.isTruncationOfObjectsSupported());
        assertTrue(result1.isPatchingOfObjectsNotSupported());
        assertFalse(result1.isPatchingOfObjectsSupported());
        assertTrue(result1.isOacpAbortOpCodeNotSupported());
        assertFalse(result1.isOacpAbortOpCodeSupported());
        assertArrayEquals(Arrays.copyOfRange(data, 4, 8), result1.getOlcpFeatures());
        assertTrue(result1.isOlcpGoToOpCodeNotSupported());
        assertFalse(result1.isOlcpGoToOpCodeSupported());
        assertTrue(result1.isOlcpOrderOpCodeNotSupported());
        assertFalse(result1.isOlcpOrderOpCodeSupported());
        assertTrue(result1.isOlcpRequestNumberOfObjectsOpCodeNotSupported());
        assertFalse(result1.isOlcpRequestNumberOfObjectsOpCodeSupported());
        assertFalse(result1.isOlcpClearMarkingOpCodeNotSupported());
        assertTrue(result1.isOlcpClearMarkingOpCodeSupported());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_1_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_1_00011() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_1_00012() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_1_00013() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_1_00014() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_1_00015() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getOacpFeatures(), result2.getOacpFeatures());
        assertArrayEquals(result1.getOlcpFeatures(), result2.getOlcpFeatures());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00011() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00012() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00013() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00014() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00015() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00011() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00012() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00013() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00014() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00015() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        OtsFeatureAndroid result1 = new OtsFeatureAndroid(bluetoothGattCharacteristic);
        OtsFeatureAndroid result2 = OtsFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
