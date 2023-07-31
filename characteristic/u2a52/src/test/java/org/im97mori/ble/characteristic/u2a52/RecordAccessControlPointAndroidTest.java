package org.im97mori.ble.characteristic.u2a52;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

/** @noinspection DataFlowIssue*/
@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class RecordAccessControlPointAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_ALL_RECORDS;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_01;
        data[ 3] = 0x01;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_02;
        data[ 3] = 0x01;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_04;
        data[ 3] = 0x01;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_07;
        data[ 3] = 0x01;
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_01;
        data[ 3] = 0x01;
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_02;
        data[ 3] = 0x01;
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_04;
        data[ 3] = 0x01;
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_07;
        data[ 3] = 0x01;
        data_00009 = data;
    }

    private static final byte[] data_00010;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_01;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00010 = data;
    }

    private static final byte[] data_00011;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_02;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00011 = data;
    }

    private static final byte[] data_00012;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_04;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00012 = data;
    }

    private static final byte[] data_00013;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_07;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00013 = data;
    }

    private static final byte[] data_00014;
    static {
        byte[] data = new byte[2];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_FIRST_RECORD;
        data_00014 = data;
    }

    private static final byte[] data_00015;
    static {
        byte[] data = new byte[2];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LAST_RECORD;
        data_00015 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[2];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_ALL_RECORDS;
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_01;
        data[ 3] = 0x01;
        data_00102 = data;
    }

    private static final byte[] data_00103;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_02;
        data[ 3] = 0x01;
        data_00103 = data;
    }

    private static final byte[] data_00104;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_04;
        data[ 3] = 0x01;
        data_00104 = data;
    }

    private static final byte[] data_00105;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_07;
        data[ 3] = 0x01;
        data_00105 = data;
    }

    private static final byte[] data_00106;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_01;
        data[ 3] = 0x01;
        data_00106 = data;
    }

    private static final byte[] data_00107;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_02;
        data[ 3] = 0x01;
        data_00107 = data;
    }

    private static final byte[] data_00108;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_04;
        data[ 3] = 0x01;
        data_00108 = data;
    }

    private static final byte[] data_00109;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_07;
        data[ 3] = 0x01;
        data_00109 = data;
    }

    private static final byte[] data_00110;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_01;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00110 = data;
    }

    private static final byte[] data_00111;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_02;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00111 = data;
    }

    private static final byte[] data_00112;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_04;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00112 = data;
    }

    private static final byte[] data_00113;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_07;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00113 = data;
    }

    private static final byte[] data_00114;
    static {
        byte[] data = new byte[2];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_FIRST_RECORD;
        data_00114 = data;
    }

    private static final byte[] data_00115;
    static {
        byte[] data = new byte[2];
        data[ 0] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LAST_RECORD;
        data_00115 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[3];
        data[ 0] = RecordAccessControlPoint.OP_CODE_ABORT_OPERATION;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.KEY_03;
        data_00201 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[2];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_ALL_RECORDS;
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_01;
        data[ 3] = 0x01;
        data_00302 = data;
    }

    private static final byte[] data_00303;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_02;
        data[ 3] = 0x01;
        data_00303 = data;
    }

    private static final byte[] data_00304;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_04;
        data[ 3] = 0x01;
        data_00304 = data;
    }

    private static final byte[] data_00305;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_07;
        data[ 3] = 0x01;
        data_00305 = data;
    }

    private static final byte[] data_00306;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_01;
        data[ 3] = 0x01;
        data_00306 = data;
    }

    private static final byte[] data_00307;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_02;
        data[ 3] = 0x01;
        data_00307 = data;
    }

    private static final byte[] data_00308;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_04;
        data[ 3] = 0x01;
        data_00308 = data;
    }

    private static final byte[] data_00309;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_07;
        data[ 3] = 0x01;
        data_00309 = data;
    }

    private static final byte[] data_00310;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_01;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00310 = data;
    }

    private static final byte[] data_00311;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_02;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00311 = data;
    }

    private static final byte[] data_00312;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_04;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00312 = data;
    }

    private static final byte[] data_00313;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_07;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00313 = data;
    }

    private static final byte[] data_00314;
    static {
        byte[] data = new byte[2];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_FIRST_RECORD;
        data_00314 = data;
    }

    private static final byte[] data_00315;
    static {
        byte[] data = new byte[2];
        data[ 0] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LAST_RECORD;
        data_00315 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[3];
        data[ 0] = RecordAccessControlPoint.OP_CODE_NUMBER_OF_STORED_RECORDS_RESPONSE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = 0x01;
        data_00401 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_SUCCESS;
        data_00501 = data;
    }

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_OP_CODE_NOT_SUPPORTED;
        data_00502 = data;
    }

    private static final byte[] data_00503;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERATOR;
        data_00503 = data;
    }

    private static final byte[] data_00504;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_OPERATOR_NOT_SUPPORTED;
        data_00504 = data;
    }

    private static final byte[] data_00505;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERAND;
        data_00505 = data;
    }

    private static final byte[] data_00506;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_NO_RECORDS_FOUND;
        data_00506 = data;
    }

    private static final byte[] data_00507;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_ABORT_UNSUCCESSFUL;
        data_00507 = data;
    }

    private static final byte[] data_00508;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_PROCEDURE_NOT_COMPLETED;
        data_00508 = data;
    }

    private static final byte[] data_00509;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_OPERAND_NOT_SUPPORTED;
        data_00509 = data;
    }

    private static final byte[] data_00510;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_SUCCESS;
        data_00510 = data;
    }

    private static final byte[] data_00511;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_OP_CODE_NOT_SUPPORTED;
        data_00511 = data;
    }

    private static final byte[] data_00512;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERATOR;
        data_00512 = data;
    }

    private static final byte[] data_00513;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_OPERATOR_NOT_SUPPORTED;
        data_00513 = data;
    }

    private static final byte[] data_00514;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERAND;
        data_00514 = data;
    }

    private static final byte[] data_00515;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_NO_RECORDS_FOUND;
        data_00515 = data;
    }

    private static final byte[] data_00516;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_ABORT_UNSUCCESSFUL;
        data_00516 = data;
    }

    private static final byte[] data_00517;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_PROCEDURE_NOT_COMPLETED;
        data_00517 = data;
    }

    private static final byte[] data_00518;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_OPERAND_NOT_SUPPORTED;
        data_00518 = data;
    }

    private static final byte[] data_00519;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_ABORT_OPERATION;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_SUCCESS;
        data_00519 = data;
    }

    private static final byte[] data_00520;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_ABORT_OPERATION;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_OP_CODE_NOT_SUPPORTED;
        data_00520 = data;
    }

    private static final byte[] data_00521;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_ABORT_OPERATION;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERATOR;
        data_00521 = data;
    }

    private static final byte[] data_00522;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_ABORT_OPERATION;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_OPERATOR_NOT_SUPPORTED;
        data_00522 = data;
    }

    private static final byte[] data_00523;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_ABORT_OPERATION;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERAND;
        data_00523 = data;
    }

    private static final byte[] data_00524;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_ABORT_OPERATION;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_NO_RECORDS_FOUND;
        data_00524 = data;
    }

    private static final byte[] data_00525;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_ABORT_OPERATION;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_ABORT_UNSUCCESSFUL;
        data_00525 = data;
    }

    private static final byte[] data_00526;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_ABORT_OPERATION;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_PROCEDURE_NOT_COMPLETED;
        data_00526 = data;
    }

    private static final byte[] data_00527;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_ABORT_OPERATION;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_OPERAND_NOT_SUPPORTED;
        data_00527 = data;
    }

    private static final byte[] data_00528;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_SUCCESS;
        data_00528 = data;
    }

    private static final byte[] data_00529;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_OP_CODE_NOT_SUPPORTED;
        data_00529 = data;
    }

    private static final byte[] data_00530;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERATOR;
        data_00530 = data;
    }

    private static final byte[] data_00531;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_OPERATOR_NOT_SUPPORTED;
        data_00531 = data;
    }

    private static final byte[] data_00532;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERAND;
        data_00532 = data;
    }

    private static final byte[] data_00533;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_NO_RECORDS_FOUND;
        data_00533 = data;
    }

    private static final byte[] data_00534;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_ABORT_UNSUCCESSFUL;
        data_00534 = data;
    }

    private static final byte[] data_00535;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_PROCEDURE_NOT_COMPLETED;
        data_00535 = data;
    }

    private static final byte[] data_00536;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS;
        data[ 3] = RecordAccessControlPoint.RESPONSE_CODE_OPERAND_NOT_SUPPORTED;
        data_00536 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[2];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_ALL_RECORDS;
        data_00601 = data;
    }

    private static final byte[] data_00602;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_01;
        data[ 3] = 0x01;
        data_00602 = data;
    }

    private static final byte[] data_00603;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_02;
        data[ 3] = 0x01;
        data_00603 = data;
    }

    private static final byte[] data_00604;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_04;
        data[ 3] = 0x01;
        data_00604 = data;
    }

    private static final byte[] data_00605;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_07;
        data[ 3] = 0x01;
        data_00605 = data;
    }

    private static final byte[] data_00606;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_01;
        data[ 3] = 0x01;
        data_00606 = data;
    }

    private static final byte[] data_00607;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_02;
        data[ 3] = 0x01;
        data_00607 = data;
    }

    private static final byte[] data_00608;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_04;
        data[ 3] = 0x01;
        data_00608 = data;
    }

    private static final byte[] data_00609;
    static {
        byte[] data = new byte[4];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO;
        data[ 2] = RecordAccessControlPoint.KEY_07;
        data[ 3] = 0x01;
        data_00609 = data;
    }

    private static final byte[] data_00610;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_01;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00610 = data;
    }

    private static final byte[] data_00611;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_02;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00611 = data;
    }

    private static final byte[] data_00612;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_04;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00612 = data;
    }

    private static final byte[] data_00613;
    static {
        byte[] data = new byte[5];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF;
        data[ 2] = RecordAccessControlPoint.KEY_07;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00613 = data;
    }

    private static final byte[] data_00614;
    static {
        byte[] data = new byte[2];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_FIRST_RECORD;
        data_00614 = data;
    }

    private static final byte[] data_00615;
    static {
        byte[] data = new byte[2];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT;
        data[ 1] = RecordAccessControlPoint.OPERATOR_LAST_RECORD;
        data_00615 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[3];
        data[ 0] = RecordAccessControlPoint.OP_CODE_COMBINED_REPORT_RESPONSE;
        data[ 1] = RecordAccessControlPoint.OPERATOR_NULL;
        data[ 2] = 0x01;
        data_00701 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_ALL_RECORDS, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertTrue(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(new byte[0], result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_01, result1.getKey());
        assertFalse(result1.isKey00());
        assertTrue(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_02, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertTrue(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_04, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertTrue(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00005() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_07, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertTrue(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00006() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_01, result1.getKey());
        assertFalse(result1.isKey00());
        assertTrue(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00007() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_02, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertTrue(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00008() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_04, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertTrue(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00009() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_07, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertTrue(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00010() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_01, result1.getKey());
        assertFalse(result1.isKey00());
        assertTrue(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00011() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_02, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertTrue(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00012() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_04, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertTrue(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00013() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_07, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertTrue(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00014() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_FIRST_RECORD, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertTrue(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(new byte[0], result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00015() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getOpCode());
        assertTrue(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LAST_RECORD, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertTrue(result1.isOperatorLastRecord());
        assertArrayEquals(new byte[0], result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_ALL_RECORDS, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertTrue(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(new byte[0], result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_01, result1.getKey());
        assertFalse(result1.isKey00());
        assertTrue(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00103() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_02, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertTrue(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00104() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_04, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertTrue(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00105() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_07, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertTrue(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00106() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_01, result1.getKey());
        assertFalse(result1.isKey00());
        assertTrue(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00107() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_02, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertTrue(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00108() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_04, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertTrue(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00109() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_07, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertTrue(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00110() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_01, result1.getKey());
        assertFalse(result1.isKey00());
        assertTrue(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00111() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_02, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertTrue(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00112() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_04, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertTrue(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00113() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_07, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertTrue(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00114() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_FIRST_RECORD, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertTrue(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(new byte[0], result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00115() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LAST_RECORD, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertTrue(result1.isOperatorLastRecord());
        assertArrayEquals(new byte[0], result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_ABORT_OPERATION, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_03, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertTrue(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_ALL_RECORDS, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertTrue(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(new byte[0], result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00302() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_01, result1.getKey());
        assertFalse(result1.isKey00());
        assertTrue(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00303() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_02, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertTrue(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00304() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_04, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertTrue(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00305() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_07, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertTrue(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00306() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_01, result1.getKey());
        assertFalse(result1.isKey00());
        assertTrue(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00307() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_02, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertTrue(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00308() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_04, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertTrue(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00309() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_07, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertTrue(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00310() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_01, result1.getKey());
        assertFalse(result1.isKey00());
        assertTrue(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00311() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_02, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertTrue(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00312() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_04, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertTrue(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00313() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_07, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertTrue(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00314() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_FIRST_RECORD, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertTrue(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(new byte[0], result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00315() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertTrue(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LAST_RECORD, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertTrue(result1.isOperatorLastRecord());
        assertArrayEquals(new byte[0], result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_NUMBER_OF_STORED_RECORDS_RESPONSE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertTrue(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00501() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_SUCCESS, result1.getResponseCode());
        assertTrue(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00502() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_OP_CODE_NOT_SUPPORTED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertTrue(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00503() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERATOR, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertTrue(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00504() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_OPERATOR_NOT_SUPPORTED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertTrue(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00505() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERAND, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertTrue(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00506() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_NO_RECORDS_FOUND, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertTrue(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00507() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_ABORT_UNSUCCESSFUL, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertTrue(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00508() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_PROCEDURE_NOT_COMPLETED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertTrue(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00509() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_OPERAND_NOT_SUPPORTED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertTrue(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00510() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_SUCCESS, result1.getResponseCode());
        assertTrue(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00511() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_OP_CODE_NOT_SUPPORTED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertTrue(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00512() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERATOR, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertTrue(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00513() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_OPERATOR_NOT_SUPPORTED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertTrue(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00514() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERAND, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertTrue(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00515() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_NO_RECORDS_FOUND, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertTrue(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00516() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_ABORT_UNSUCCESSFUL, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertTrue(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00517() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_PROCEDURE_NOT_COMPLETED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertTrue(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00518() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_DELETE_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_OPERAND_NOT_SUPPORTED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertTrue(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00519() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_ABORT_OPERATION, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_SUCCESS, result1.getResponseCode());
        assertTrue(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00520() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_ABORT_OPERATION, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_OP_CODE_NOT_SUPPORTED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertTrue(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00521() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_ABORT_OPERATION, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERATOR, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertTrue(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00522() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_ABORT_OPERATION, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_OPERATOR_NOT_SUPPORTED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertTrue(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00523() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_ABORT_OPERATION, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERAND, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertTrue(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00524() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_ABORT_OPERATION, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_NO_RECORDS_FOUND, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertTrue(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00525() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_ABORT_OPERATION, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_ABORT_UNSUCCESSFUL, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertTrue(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00526() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_ABORT_OPERATION, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_PROCEDURE_NOT_COMPLETED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertTrue(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00527() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_ABORT_OPERATION, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_OPERAND_NOT_SUPPORTED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertTrue(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00528() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_SUCCESS, result1.getResponseCode());
        assertTrue(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00529() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_OP_CODE_NOT_SUPPORTED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertTrue(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00530() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERATOR, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertTrue(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00531() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_OPERATOR_NOT_SUPPORTED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertTrue(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00532() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_INVALID_OPERAND, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertTrue(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00533() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_NO_RECORDS_FOUND, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertTrue(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00534() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_ABORT_UNSUCCESSFUL, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertTrue(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00535() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_PROCEDURE_NOT_COMPLETED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertTrue(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00536() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(RecordAccessControlPoint.OP_CODE_REPORT_NUMBER_OF_STORED_RECORDS, result1.getRequestOpCode());
        assertEquals(RecordAccessControlPoint.RESPONSE_CODE_OPERAND_NOT_SUPPORTED, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertTrue(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00601() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_ALL_RECORDS, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertTrue(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(new byte[0], result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00602() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_01, result1.getKey());
        assertFalse(result1.isKey00());
        assertTrue(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00603() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_02, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertTrue(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00604() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_04, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertTrue(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00605() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LESS_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertTrue(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_07, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertTrue(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00606() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_01, result1.getKey());
        assertFalse(result1.isKey00());
        assertTrue(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00607() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_02, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertTrue(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00608() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_04, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertTrue(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00609() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_THAN_OR_EQUAL_TO, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertTrue(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_07, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertTrue(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00610() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_01, result1.getKey());
        assertFalse(result1.isKey00());
        assertTrue(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00611() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_02, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertTrue(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00612() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_04, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertTrue(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00613() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_GREATER_WITHIN_RANGE_OF, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertTrue(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_07, result1.getKey());
        assertFalse(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertTrue(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00614() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_FIRST_RECORD, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertTrue(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(new byte[0], result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00615() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_LAST_RECORD, result1.getOperator());
        assertFalse(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertTrue(result1.isOperatorLastRecord());
        assertArrayEquals(new byte[0], result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00701() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertEquals(RecordAccessControlPoint.OP_CODE_COMBINED_REPORT_RESPONSE, result1.getOpCode());
        assertFalse(result1.isOpCodeReportStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeAbortOperation(result1.getOpCode()));
        assertFalse(result1.isOpCodeReportNumberOfStoredRecords(result1.getOpCode()));
        assertFalse(result1.isOpCodeNumberOfStoredRecordsResponse(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertFalse(result1.isOpCodeCombinedReport(result1.getOpCode()));
        assertTrue(result1.isOpCodeCombinedReportResponse(result1.getOpCode()));
        assertEquals(RecordAccessControlPoint.OPERATOR_NULL, result1.getOperator());
        assertTrue(result1.isOperatorNull());
        assertFalse(result1.isOperatorAllRecords());
        assertFalse(result1.isOperatorLessThanOrEqualTo());
        assertFalse(result1.isOperatorGreaterThanOrEqualTo());
        assertFalse(result1.isOperatorWithinRangeOf());
        assertFalse(result1.isOperatorFirstRecord());
        assertFalse(result1.isOperatorLastRecord());
        assertArrayEquals(Arrays.copyOfRange(data, 2, data.length), result1.getOperand());
                assertEquals(RecordAccessControlPoint.KEY_00, result1.getKey());
        assertTrue(result1.isKey00());
        assertFalse(result1.isKey01());
        assertFalse(result1.isKey02());
        assertFalse(result1.isKey03());
        assertFalse(result1.isKey04());
        assertFalse(result1.isKey05());
        assertFalse(result1.isKey06());
        assertFalse(result1.isKey07());
        assertFalse(result1.isKey08());
        assertEquals(0, result1.getRequestOpCode());
        assertEquals(0, result1.getResponseCode());
        assertFalse(result1.isResponseCodeSuccess());
        assertFalse(result1.isResponseCodeOpCodeNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperator());
        assertFalse(result1.isResponseCodeOperatorNotSupported());
        assertFalse(result1.isResponseCodeInvalidOperand());
        assertFalse(result1.isResponseCodeNoRecordsFound());
        assertFalse(result1.isResponseCodeAbortUnsuccessful());
        assertFalse(result1.isResponseCodeProcedureNotCompleted());
        assertFalse(result1.isResponseCodeOperandNotSupported());
    }

    @Test
    public void test_constructor_00801() {
        int opCode = 1;
        int operator = 2;
        byte[] operand = new byte[]{3};

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(opCode, operator, operand);
        assertEquals(opCode, result1.getOpCode());
        assertEquals(operator, result1.getOperator());
        assertArrayEquals(operand, result1.getOperand());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00010() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00011() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00012() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00013() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00014() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00015() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00103() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00104() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00105() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00106() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00107() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00108() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00109() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00110() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00111() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00112() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00113() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00114() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00115() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00302() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00303() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00304() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00305() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00306() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00307() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00308() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00309() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00310() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00311() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00312() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00313() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00314() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00315() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00502() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00503() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00504() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00505() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00506() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00507() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00508() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00509() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00510() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00511() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00512() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00513() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00514() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00515() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00516() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00517() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00518() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00519() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00520() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00521() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00522() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00523() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00524() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00525() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00526() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00527() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00528() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00529() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00530() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00531() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00532() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00533() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00534() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00535() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00536() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00602() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00603() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00604() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00605() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00606() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00607() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00608() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00609() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00610() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00611() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00612() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00613() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00614() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00615() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperator(), result2.getOperator());
        assertArrayEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00010() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00011() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00012() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00013() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00014() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00015() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00103() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00104() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00105() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00106() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00107() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00108() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00109() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00110() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00111() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00112() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00113() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00114() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00115() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00303() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00304() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00305() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00306() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00307() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00308() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00309() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00310() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00311() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00312() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00313() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00314() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00315() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00503() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00504() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00505() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00506() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00507() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00508() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00509() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00510() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00511() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00512() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00513() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00514() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00515() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00516() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00517() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00518() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00519() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00520() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00521() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00522() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00523() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00524() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00525() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00526() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00527() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00528() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00529() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00530() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00531() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00532() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00533() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00534() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00535() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00536() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00602() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00603() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00604() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00605() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00606() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00607() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00608() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00609() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00610() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00611() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00612() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00613() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00614() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00615() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00010() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00011() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00012() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00013() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00014() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00015() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00103() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00104() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00105() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00106() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00107() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00108() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00109() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00110() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00111() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00112() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00113() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00114() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00115() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00303() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00304() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00305() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00306() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00307() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00308() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00309() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00310() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00311() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00312() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00313() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00314() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00315() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00503() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00504() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00505() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00506() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00507() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00508() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00509() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00510() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00511() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00512() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00513() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00514() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00515() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00516() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00517() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00518() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00519() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00520() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00521() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00522() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00523() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00524() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00525() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00526() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00527() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00528() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00529() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00530() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00531() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00532() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00533() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00534() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00535() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00536() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00602() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00603() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00604() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00605() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00606() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00607() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00608() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00609() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00610() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00611() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00612() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00613() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00614() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00615() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        RecordAccessControlPointAndroid result1 = new RecordAccessControlPointAndroid(data);
        RecordAccessControlPointAndroid result2 = RecordAccessControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
