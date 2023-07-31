package org.im97mori.ble.characteristic.u2ac5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

@SuppressWarnings("unused")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ObjectActionControlPointAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[7];
        data[ 0] = ObjectActionControlPoint.OP_CODE_CREATE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
		data_00001 = data;
	}

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[1];
        data[ 0] = ObjectActionControlPoint.OP_CODE_DELETE;
        data_00101 = data;
	}

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[9];
        data[ 0] = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data_00201 = data;
	}

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[2];
        data[ 0] = ObjectActionControlPoint.OP_CODE_EXECUTE;
        data[ 1] = 0x01;
        data_00301 = data;
	}

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[9];
        data[ 0] = ObjectActionControlPoint.OP_CODE_READ;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data_00401 = data;
	}

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[10];
        data[ 0] = ObjectActionControlPoint.OP_CODE_WRITE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        data_00501 = data;
	}

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[10];
        data[ 0] = ObjectActionControlPoint.OP_CODE_WRITE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = ObjectActionControlPoint.MODE_TRUNCATE_TRUE;
        data_00502 = data;
	}

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[1];
        data[ 0] = ObjectActionControlPoint.OP_CODE_ABORT;
        data_00601 = data;
	}

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CREATE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        data_00701 = data;
	}

    private static final byte[] data_00702;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CREATE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_00702 = data;
	}

    private static final byte[] data_00703;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CREATE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_00703 = data;
	}

    private static final byte[] data_00704;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CREATE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES;
        data_00704 = data;
	}

    private static final byte[] data_00705;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CREATE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT;
        data_00705 = data;
	}

    private static final byte[] data_00706;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CREATE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE;
        data_00706 = data;
	}

    private static final byte[] data_00707;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CREATE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE;
        data_00707 = data;
	}

    private static final byte[] data_00708;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CREATE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED;
        data_00708 = data;
	}

    private static final byte[] data_00709;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CREATE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED;
        data_00709 = data;
	}

    private static final byte[] data_00710;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CREATE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_00710 = data;
	}

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_DELETE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        data_00801 = data;
	}

    private static final byte[] data_00802;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_DELETE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_00802 = data;
	}

    private static final byte[] data_00803;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_DELETE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_00803 = data;
	}

    private static final byte[] data_00804;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_DELETE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES;
        data_00804 = data;
	}

    private static final byte[] data_00805;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_DELETE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT;
        data_00805 = data;
	}

    private static final byte[] data_00806;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_DELETE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE;
        data_00806 = data;
	}

    private static final byte[] data_00807;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_DELETE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE;
        data_00807 = data;
	}

    private static final byte[] data_00808;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_DELETE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED;
        data_00808 = data;
	}

    private static final byte[] data_00809;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_DELETE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED;
        data_00809 = data;
	}

    private static final byte[] data_00810;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_DELETE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_00810 = data;
	}

    private static final byte[] data_00901;
    static {
        byte[] data = new byte[7];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data[ 5] = 0x03;
        data[ 6] = 0x04;
        data_00901 = data;
	}

    private static final byte[] data_00902;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_00902 = data;
	}

    private static final byte[] data_00903;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_00903 = data;
	}

    private static final byte[] data_00904;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES;
        data_00904 = data;
	}

    private static final byte[] data_00905;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT;
        data_00905 = data;
	}

    private static final byte[] data_00906;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE;
        data_00906 = data;
	}

    private static final byte[] data_00907;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE;
        data_00907 = data;
	}

    private static final byte[] data_00908;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED;
        data_00908 = data;
	}

    private static final byte[] data_00909;
    static {
	    byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED;
        data_00909 = data;
	}

    private static final byte[] data_00910;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_00910 = data;
	}

    private static final byte[] data_01001;
    static {
        byte[] data = new byte[4];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_EXECUTE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        data[ 3] = 0x01;
        data_01001 = data;
	}

    private static final byte[] data_01002;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_EXECUTE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_01002 = data;
	}

    private static final byte[] data_01003;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_EXECUTE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_01003 = data;
	}

    private static final byte[] data_01004;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_EXECUTE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES;
        data_01004 = data;
	}

    private static final byte[] data_01005;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_EXECUTE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT;
        data_01005 = data;
	}

    private static final byte[] data_01006;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_EXECUTE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE;
        data_01006 = data;
	}

    private static final byte[] data_01007;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_EXECUTE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE;
        data_01007 = data;
	}

    private static final byte[] data_01008;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_EXECUTE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED;
        data_01008 = data;
	}

    private static final byte[] data_01009;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_EXECUTE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED;
        data_01009 = data;
	}

    private static final byte[] data_01010;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_EXECUTE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01010 = data;
	}

    private static final byte[] data_01101;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_READ;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        data_01101 = data;
	}

    private static final byte[] data_01102;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_READ;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_01102 = data;
	}

    private static final byte[] data_01103;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_READ;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_01103 = data;
	}

    private static final byte[] data_01104;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_READ;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES;
        data_01104 = data;
	}

    private static final byte[] data_01105;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_READ;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT;
        data_01105 = data;
	}

    private static final byte[] data_01106;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_READ;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE;
        data_01106 = data;
	}

    private static final byte[] data_01107;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_READ;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE;
        data_01107 = data;
	}

    private static final byte[] data_01108;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_READ;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED;
        data_01108 = data;
	}

    private static final byte[] data_01109;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_READ;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED;
        data_01109 = data;
	}

    private static final byte[] data_01110;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_READ;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01110 = data;
	}

    private static final byte[] data_01201;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_WRITE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        data_01201 = data;
	}

    private static final byte[] data_01202;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_WRITE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_01202 = data;
	}

    private static final byte[] data_01203;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_WRITE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_01203 = data;
	}

    private static final byte[] data_01204;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_WRITE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES;
        data_01204 = data;
	}

    private static final byte[] data_01205;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_WRITE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT;
        data_01205 = data;
	}

    private static final byte[] data_01206;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_WRITE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE;
        data_01206 = data;
	}

    private static final byte[] data_01207;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_WRITE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE;
        data_01207 = data;
	}

    private static final byte[] data_01208;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_WRITE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED;
        data_01208 = data;
	}

    private static final byte[] data_01209;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_WRITE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED;
        data_01209 = data;
	}

    private static final byte[] data_01210;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_WRITE;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01210 = data;
	}

    private static final byte[] data_01301;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_ABORT;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        data_01301 = data;
	}

    private static final byte[] data_01302;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_ABORT;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_01302 = data;
	}

    private static final byte[] data_01303;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_ABORT;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_01303 = data;
	}

    private static final byte[] data_01304;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_ABORT;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES;
        data_01304 = data;
	}

    private static final byte[] data_01305;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_ABORT;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT;
        data_01305 = data;
	}

    private static final byte[] data_01306;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_ABORT;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE;
        data_01306 = data;
	}

    private static final byte[] data_01307;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_ABORT;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE;
        data_01307 = data;
	}

    private static final byte[] data_01308;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_ABORT;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED;
        data_01308 = data;
	}

    private static final byte[] data_01309;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_ABORT;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED;
        data_01309 = data;
	}

    private static final byte[] data_01310;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectActionControlPoint.OP_CODE_ABORT;
        data[ 2] = ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_01310 = data;
	}
	//@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(BLEUtils.createUInt32(data, 1), result1.getSize());
        assertArrayEquals(Arrays.copyOfRange(data, 5, data.length), result1.getType());
    }

    @Test
    public void test_constructor_1_00101() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_1_00201() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(BLEUtils.createUInt32(data, 1), result1.getOffset());
        assertEquals(BLEUtils.createUInt32(data, 5), result1.getLength());
    }

    @Test
    public void test_constructor_1_00301() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertArrayEquals(Arrays.copyOfRange(data, 1, data.length), result1.getParameter());
    }

    @Test
    public void test_constructor_1_00401() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(BLEUtils.createUInt32(data, 1), result1.getOffset());
        assertEquals(BLEUtils.createUInt32(data, 5), result1.getLength());
    }

    @Test
    public void test_constructor_1_00501() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(BLEUtils.createUInt32(data, 1), result1.getOffset());
        assertEquals(BLEUtils.createUInt32(data, 5), result1.getLength());
        assertEquals(ObjectActionControlPoint.MODE_TRUNCATE_FALSE, result1.getMode());
        assertTrue(result1.isModeTruncateFalse());
        assertFalse(result1.isModeTruncateTrue());
    }

    @Test
    public void test_constructor_1_00502() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(BLEUtils.createUInt32(data, 1), result1.getOffset());
        assertEquals(BLEUtils.createUInt32(data, 5), result1.getLength());
        assertEquals(ObjectActionControlPoint.MODE_TRUNCATE_TRUE, result1.getMode());
        assertFalse(result1.isModeTruncateFalse());
        assertTrue(result1.isModeTruncateTrue());
    }

    @Test
    public void test_constructor_1_00601() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_1_00701() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00702() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00703() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00704() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00705() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertTrue(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00706() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertTrue(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00707() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertTrue(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00708() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertTrue(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00709() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertTrue(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00710() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertTrue(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00801() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00802() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00803() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00804() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00805() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertTrue(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00806() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertTrue(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00807() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertTrue(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00808() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertTrue(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00809() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertTrue(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00810() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertTrue(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00901() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00902() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00903() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00904() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00905() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertTrue(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00906() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertTrue(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00907() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertTrue(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00908() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertTrue(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00909() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertTrue(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_00910() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertTrue(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01001() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01002() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01003() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01004() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01005() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertTrue(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01006() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertTrue(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01007() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertTrue(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01008() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertTrue(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01009() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertTrue(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01010() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertTrue(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01101() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01102() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01103() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01104() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01105() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertTrue(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01106() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertTrue(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01107() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertTrue(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01108() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertTrue(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01109() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertTrue(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01110() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertTrue(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01201() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01202() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01203() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01204() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01205() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertTrue(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01206() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertTrue(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01207() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertTrue(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01208() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertTrue(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01209() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertTrue(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01210() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertTrue(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01301() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01302() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01303() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01304() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01305() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertTrue(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01306() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertTrue(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01307() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertTrue(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01308() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertTrue(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01309() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertTrue(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_1_01310() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertTrue(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00001() {
        int opCode = ObjectActionControlPoint.OP_CODE_CREATE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(size, result1.getSize());
        assertArrayEquals(type, result1.getType());
    }

    @Test
    public void test_constructor_2_00101() {
        int opCode = ObjectActionControlPoint.OP_CODE_DELETE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_2_00201() {
        int opCode = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(offset, result1.getOffset());
        assertEquals(length, result1.getLength());
    }

    @Test
    public void test_constructor_2_00301() {
        int opCode = ObjectActionControlPoint.OP_CODE_EXECUTE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertArrayEquals(parameter, result1.getParameter());
    }

    @Test
    public void test_constructor_2_00401() {
        int opCode = ObjectActionControlPoint.OP_CODE_READ;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(offset, result1.getOffset());
        assertEquals(length, result1.getLength());
    }

    @Test
    public void test_constructor_2_00501() {
        int opCode = ObjectActionControlPoint.OP_CODE_WRITE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(offset, result1.getOffset());
        assertEquals(length, result1.getLength());
        assertEquals(mode, result1.getMode());
        assertTrue(result1.isModeTruncateFalse());
        assertFalse(result1.isModeTruncateTrue());
    }

    @Test
    public void test_constructor_2_00502() {
        int opCode = ObjectActionControlPoint.OP_CODE_WRITE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_TRUE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(offset, result1.getOffset());
        assertEquals(length, result1.getLength());
        assertEquals(mode, result1.getMode());
        assertFalse(result1.isModeTruncateFalse());
        assertTrue(result1.isModeTruncateTrue());
    }

    @Test
    public void test_constructor_2_00601() {
        int opCode = ObjectActionControlPoint.OP_CODE_ABORT;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_2_00701() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CREATE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00702() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CREATE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00703() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CREATE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00704() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CREATE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00705() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CREATE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertTrue(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00706() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CREATE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertTrue(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00707() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CREATE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertTrue(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00708() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CREATE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertTrue(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00709() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CREATE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertTrue(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00710() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CREATE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CREATE, result1.getRequestOpCode());
        assertTrue(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertTrue(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00801() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_DELETE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00802() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_DELETE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00803() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_DELETE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00804() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_DELETE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00805() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_DELETE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertTrue(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00806() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_DELETE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertTrue(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00807() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_DELETE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertTrue(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00808() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_DELETE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertTrue(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00809() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_DELETE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertTrue(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00810() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_DELETE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_DELETE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertTrue(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00901() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00902() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00903() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00904() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00905() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertTrue(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00906() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertTrue(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00907() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertTrue(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00908() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertTrue(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00909() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertTrue(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_00910() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_CALCULATE_CHECKSUM, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertTrue(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01001() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_EXECUTE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01002() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_EXECUTE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01003() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_EXECUTE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01004() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_EXECUTE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01005() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_EXECUTE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertTrue(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01006() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_EXECUTE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertTrue(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01007() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_EXECUTE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertTrue(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01008() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_EXECUTE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertTrue(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01009() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_EXECUTE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertTrue(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01010() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_EXECUTE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_EXECUTE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertTrue(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01101() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_READ;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01102() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_READ;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01103() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_READ;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01104() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_READ;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01105() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_READ;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertTrue(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01106() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_READ;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertTrue(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01107() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_READ;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertTrue(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01108() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_READ;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertTrue(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01109() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_READ;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertTrue(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01110() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_READ;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_READ, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertTrue(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01201() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_WRITE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01202() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_WRITE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01203() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_WRITE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01204() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_WRITE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01205() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_WRITE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertTrue(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01206() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_WRITE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertTrue(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01207() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_WRITE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertTrue(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01208() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_WRITE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertTrue(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01209() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_WRITE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertTrue(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01210() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_WRITE;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_WRITE, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertTrue(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01301() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_ABORT;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_SUCCESS;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertTrue(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01302() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_ABORT;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertTrue(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01303() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_ABORT;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertTrue(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01304() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_ABORT;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INSUFFICIENT_RESOUCES, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertTrue(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01305() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_ABORT;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_INVALID_OBJECT, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertTrue(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01306() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_ABORT;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_CHANNEL_UNAVAILABLE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertTrue(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01307() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_ABORT;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_UNSUPPORTED_TYPE, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertTrue(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01308() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_ABORT;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_PROCEDURE_NOT_PERMITTED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertTrue(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01309() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_ABORT;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OBJECT_LOCKED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertTrue(result1.isResultCodeObjectLocked());
        assertFalse(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_constructor_2_01310() {
        int opCode = ObjectActionControlPoint.OP_CODE_RESPONSE_CODE;
        long size = 2;
        byte[] type = new byte[]{3, 4};
        long offset = 5;
        long length = 6;
        byte[] parameter = new byte[]{7};
        int mode = ObjectActionControlPoint.MODE_TRUNCATE_FALSE;
        int requestOpCode = ObjectActionControlPoint.OP_CODE_ABORT;
        int resultCode = ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED;
        int checksum = 8;
        byte[] responseParameter = new byte[]{9};

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(opCode, size, type, offset, length, parameter,
                mode, requestOpCode, resultCode, checksum, responseParameter);
        assertEquals(ObjectActionControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbort(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectActionControlPoint.OP_CODE_ABORT, result1.getRequestOpCode());
        assertFalse(result1.isOpCodeCreate(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeDelete(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeCalculateChecksum(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeExecute(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRead(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeWrite(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeAbort(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(ObjectActionControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertFalse(result1.isResultCodeSuccess());
        assertFalse(result1.isResultCodeOpCodeNotSupported());
        assertFalse(result1.isResultCodeInvalidParameter());
        assertFalse(result1.isResultCodeInsufficientResources());
        assertFalse(result1.isResultCodeInvalidObject());
        assertFalse(result1.isResultCodeChannelUnavailable());
        assertFalse(result1.isResultCodeUnsupportedType());
        assertFalse(result1.isResultCodeProcedureNotPermitted());
        assertFalse(result1.isResultCodeObjectLocked());
        assertTrue(result1.isResultCodeOperationFailedd());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00502() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00702() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00703() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00704() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00705() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00706() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00707() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00708() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00709() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00710() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00801() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00802() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00803() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00804() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00805() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00806() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00807() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00808() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00809() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00810() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00901() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00902() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00903() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00904() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00905() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00906() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00907() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00908() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00909() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00910() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01001() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01002() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01003() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01004() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01005() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01006() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01007() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01008() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01009() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01010() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01101() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01102() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01103() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01104() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01105() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01106() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01107() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01108() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01109() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01110() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01201() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01202() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01203() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01204() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01205() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01206() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01207() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01208() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01209() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01210() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01301() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01302() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01303() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01304() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01305() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01306() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01307() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01308() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01309() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_01310() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getSize(), result1.getSize());
        assertArrayEquals(result2.getType(), result1.getType());
        assertEquals(result2.getOffset(), result1.getOffset());
        assertEquals(result2.getLength(), result1.getLength());
        assertArrayEquals(result2.getParameter(), result1.getParameter());
        assertEquals(result2.getMode(), result1.getMode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getChecksum(), result1.getChecksum());
        assertArrayEquals(result2.getResponseParameter(), result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00702() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00703() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00704() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00705() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00706() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00707() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00708() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00709() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00710() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00801() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00802() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00803() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00804() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00805() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00806() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00807() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00808() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00809() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00810() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00901() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00902() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00903() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00904() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00905() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00906() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00907() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00908() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00909() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00910() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01001() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01002() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01003() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01004() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01005() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01006() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01007() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01008() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01009() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01010() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01101() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01102() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01103() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01104() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01105() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01106() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01107() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01108() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01109() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01110() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01201() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01202() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01203() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01204() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01205() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01206() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01207() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01208() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01209() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01210() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01301() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01302() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01303() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01304() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01305() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01306() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01307() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01308() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01309() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01310() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00702() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00703() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00704() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00705() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00706() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00707() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00708() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00709() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00710() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00802() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00803() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00804() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00805() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00806() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00807() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00808() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00809() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00810() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00901() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00902() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00903() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00904() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00905() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00906() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00907() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00908() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00909() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00910() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01001() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01002() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01003() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01004() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01005() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01006() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01007() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01008() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01009() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01010() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01101() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01102() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01103() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01104() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01105() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01106() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01107() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01108() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01109() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01110() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01201() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01202() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01203() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01204() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01205() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01206() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01207() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01208() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01209() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01210() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01301() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01302() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01303() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01304() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01305() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01306() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01307() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01308() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01309() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01310() {
        byte[] data = getData();

        ObjectActionControlPointAndroid result1 = new ObjectActionControlPointAndroid(data);
        ObjectActionControlPointAndroid result2 = ObjectActionControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
