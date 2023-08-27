package org.im97mori.ble.characteristic.u2ac6;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@SuppressWarnings("unused")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ObjectListControlPointAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = ObjectListControlPoint.OP_CODE_FIRST;
		data_00001 = data;
	}

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[1];
        data[ 0] = ObjectListControlPoint.OP_CODE_LAST;
        data_00101 = data;
	}

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[1];
        data[ 0] = ObjectListControlPoint.OP_CODE_PREVIOUS;
        data_00201 = data;
	}

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[1];
        data[ 0] = ObjectListControlPoint.OP_CODE_NEXT;
        data_00301 = data;
	}

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[7];
        data[ 0] = ObjectListControlPoint.OP_CODE_GO_TO;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data_00401 = data;
	}

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[2];
        data[ 0] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 1] = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_NAME_ASCENDING;
        data_00501 = data;
	}

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[2];
        data[ 0] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 1] = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_TYPE_ASCENDING;
        data_00502 = data;
	}

    private static final byte[] data_00503;
    static {
        byte[] data = new byte[2];
        data[ 0] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 1] = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_CURRENT_SIZE_ASCENDING;
        data_00503 = data;
	}

    private static final byte[] data_00504;
    static {
        byte[] data = new byte[2];
        data[ 0] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 1] = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_FIRST_CREATED_TIMESTAMP_ASCENDING;
        data_00504 = data;
	}

    private static final byte[] data_00505;
    static {
        byte[] data = new byte[2];
        data[ 0] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 1] = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_LAST_MODIFIED_TIMESTAMP_ASCENDING;
        data_00505 = data;
	}

    private static final byte[] data_00506;
    static {
        byte[] data = new byte[2];
        data[ 0] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 1] = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_NAME_DESCENDING;
        data_00506 = data;
	}

    private static final byte[] data_00507;
    static {
        byte[] data = new byte[2];
        data[ 0] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 1] = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_TYPE_DESCENDING;
        data_00507 = data;
	}

    private static final byte[] data_00508;
    static {
        byte[] data = new byte[2];
        data[ 0] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 1] = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_CURRENT_SIZE_DESCENDING;
        data_00508 = data;
	}

    private static final byte[] data_00509;
    static {
        byte[] data = new byte[2];
        data[ 0] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 1] = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_FIRST_CREATED_TIMESTAMP_DESCENDING;
        data_00509 = data;
	}

    private static final byte[] data_00510;
    static {
        byte[] data = new byte[2];
        data[ 0] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 1] = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_LAST_MODIFIED_TIMESTAMP_DESCENDING;
        data_00510 = data;
	}

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[1];
        data[ 0] = ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS;
        data_00601 = data;
	}

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[1];
        data[ 0] = ObjectListControlPoint.OP_CODE_CLEAR_MARKING;
        data_00701 = data;
	}

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_FIRST;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        data_00801 = data;
	}

    private static final byte[] data_00802;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_FIRST;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_00802 = data;
	}

    private static final byte[] data_00803;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_FIRST;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        data_00803 = data;
	}

    private static final byte[] data_00804;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_FIRST;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        data_00804 = data;
	}

    private static final byte[] data_00805;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_LAST;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        data_00805 = data;
	}

    private static final byte[] data_00806;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_LAST;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_00806 = data;
	}

    private static final byte[] data_00807;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_LAST;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        data_00807 = data;
	}

    private static final byte[] data_00808;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_LAST;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        data_00808 = data;
	}

    private static final byte[] data_00809;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_PREVIOUS;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        data_00809 = data;
	}

    private static final byte[] data_00810;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_PREVIOUS;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OUT_OF_BOUNDS;
        data_00810 = data;
	}

    private static final byte[] data_00811;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_PREVIOUS;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_00811 = data;
	}

    private static final byte[] data_00812;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_PREVIOUS;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        data_00812 = data;
	}

    private static final byte[] data_00813;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_PREVIOUS;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        data_00813 = data;
	}

    private static final byte[] data_00814;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_NEXT;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        data_00814 = data;
	}

    private static final byte[] data_00815;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_NEXT;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OUT_OF_BOUNDS;
        data_00815 = data;
	}

    private static final byte[] data_00816;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_NEXT;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_00816 = data;
	}

    private static final byte[] data_00817;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_NEXT;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        data_00817 = data;
	}

    private static final byte[] data_00818;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_NEXT;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        data_00818 = data;
	}

    private static final byte[] data_00819;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_GO_TO;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        data_00819 = data;
	}

    private static final byte[] data_00820;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_GO_TO;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_00820 = data;
	}

    private static final byte[] data_00821;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_GO_TO;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OBJECT_ID_NOT_FOUND;
        data_00821 = data;
	}

    private static final byte[] data_00822;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_GO_TO;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_00822 = data;
	}

    private static final byte[] data_00823;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_GO_TO;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_00823 = data;
	}

    private static final byte[] data_00824;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_GO_TO;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        data_00824 = data;
	}

    private static final byte[] data_00825;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_GO_TO;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        data_00825 = data;
	}

    private static final byte[] data_00826;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        data_00826 = data;
	}

    private static final byte[] data_00827;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_INVALID_PARAMETER;
        data_00827 = data;
	}

    private static final byte[] data_00828;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_00828 = data;
	}

    private static final byte[] data_00829;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_00829 = data;
	}

    private static final byte[] data_00830;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        data_00830 = data;
	}

    private static final byte[] data_00831;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_ORDER;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        data_00831 = data;
	}

    private static final byte[] data_00832;
    static {
    	byte[] data = new byte[7];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data[ 5] = 0x03;
        data[ 6] = 0x04;
        data_00832 = data;
	}

    private static final byte[] data_00833;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_00833 = data;
	}

    private static final byte[] data_00834;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_00834 = data;
	}

    private static final byte[] data_00835;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        data_00835 = data;
	}

    private static final byte[] data_00836;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        data_00836 = data;
	}

    private static final byte[] data_00837;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_CLEAR_MARKING;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        data_00837 = data;
	}

    private static final byte[] data_00838;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_CLEAR_MARKING;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_00838 = data;
	}

    private static final byte[] data_00839;
    static {
        byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_CLEAR_MARKING;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        data_00839 = data;
	}

    private static final byte[] data_00840;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_CLEAR_MARKING;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        data_00840 = data;
	}

    private static final byte[] data_00841;
    static {
    	byte[] data = new byte[3];
        data[ 0] = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = ObjectListControlPoint.OP_CODE_CLEAR_MARKING;
        data[ 2] = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        data_00841 = data;
	}
	//@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_FIRST, result1.getOpCode());
        assertTrue(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_1_00101() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_LAST, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertTrue(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_1_00201() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_PREVIOUS, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertTrue(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_1_00301() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_NEXT, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertTrue(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_1_00401() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertTrue(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(BLEUtils.createUInt48(data, 1), result1.getObjectId());
    }

    @Test
    public void test_constructor_1_00501() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_NAME_ASCENDING, result1.getListSortOrder());
    }

    @Test
    public void test_constructor_1_00502() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_TYPE_ASCENDING, result1.getListSortOrder());
    }

    @Test
    public void test_constructor_1_00503() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_CURRENT_SIZE_ASCENDING, result1.getListSortOrder());
    }

    @Test
    public void test_constructor_1_00504() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_FIRST_CREATED_TIMESTAMP_ASCENDING,
                result1.getListSortOrder());
    }

    @Test
    public void test_constructor_1_00505() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_LAST_MODIFIED_TIMESTAMP_ASCENDING,
                result1.getListSortOrder());
    }

    @Test
    public void test_constructor_1_00506() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_NAME_DESCENDING, result1.getListSortOrder());
    }

    @Test
    public void test_constructor_1_00507() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_TYPE_DESCENDING, result1.getListSortOrder());
    }

    @Test
    public void test_constructor_1_00508() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_CURRENT_SIZE_DESCENDING, result1.getListSortOrder());
    }

    @Test
    public void test_constructor_1_00509() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_FIRST_CREATED_TIMESTAMP_DESCENDING,
                result1.getListSortOrder());
    }

    @Test
    public void test_constructor_1_00510() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_LAST_MODIFIED_TIMESTAMP_DESCENDING,
                result1.getListSortOrder());
    }

    @Test
    public void test_constructor_1_00601() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertTrue(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_1_00701() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_CLEAR_MARKING, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertTrue(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_1_00801() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_FIRST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00802() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_FIRST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00803() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_FIRST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00804() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_FIRST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00805() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_LAST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00806() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_LAST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00807() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_LAST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00808() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_LAST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00809() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_PREVIOUS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00810() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_PREVIOUS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OUT_OF_BOUNDS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00811() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_PREVIOUS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00812() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_PREVIOUS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00813() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_PREVIOUS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00814() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_NEXT, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00815() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_NEXT, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OUT_OF_BOUNDS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00816() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_NEXT, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00817() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_NEXT, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00818() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_NEXT, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00819() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00820() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00821() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OBJECT_ID_NOT_FOUND, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00822() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00823() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00824() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00825() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00826() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00827() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00828() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00829() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00830() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00831() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00832() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertEquals(BLEUtils.createUInt32(data, 3), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_constructor_1_00833() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00834() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00835() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00836() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00837() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_CLEAR_MARKING, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00838() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_CLEAR_MARKING, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00839() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_CLEAR_MARKING, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00840() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_CLEAR_MARKING, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_1_00841() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_CLEAR_MARKING, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00001() {
        int opCode = ObjectListControlPoint.OP_CODE_FIRST;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_FIRST, result1.getOpCode());
        assertTrue(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_2_00101() {
        int opCode = ObjectListControlPoint.OP_CODE_LAST;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_LAST, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertTrue(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_2_00201() {
        int opCode = ObjectListControlPoint.OP_CODE_PREVIOUS;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_PREVIOUS, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertTrue(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_2_00301() {
        int opCode = ObjectListControlPoint.OP_CODE_NEXT;
        long objectId = 1;
        int listSortOrder = 0;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_NEXT, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertTrue(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_2_00401() {
        int opCode = ObjectListControlPoint.OP_CODE_GO_TO;
        long objectId = 1;
        int listSortOrder = 0;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertTrue(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(objectId, result1.getObjectId());
    }

    @Test
    public void test_constructor_2_00501() {
        int opCode = ObjectListControlPoint.OP_CODE_ORDER;
        long objectId = 0;
        int listSortOrder = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_NAME_ASCENDING;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_NAME_ASCENDING, result1.getListSortOrder());
    }

    @Test
    public void test_constructor_2_00502() {
        int opCode = ObjectListControlPoint.OP_CODE_ORDER;
        long objectId = 0;
        int listSortOrder = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_TYPE_ASCENDING;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_TYPE_ASCENDING, result1.getListSortOrder());
    }

    @Test
    public void test_constructor_2_00503() {
        int opCode = ObjectListControlPoint.OP_CODE_ORDER;
        long objectId = 0;
        int listSortOrder = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_CURRENT_SIZE_ASCENDING;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_CURRENT_SIZE_ASCENDING, result1.getListSortOrder());
    }

    @Test
    public void test_constructor_2_00504() {
        int opCode = ObjectListControlPoint.OP_CODE_ORDER;
        long objectId = 0;
        int listSortOrder = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_FIRST_CREATED_TIMESTAMP_ASCENDING;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_FIRST_CREATED_TIMESTAMP_ASCENDING,
                result1.getListSortOrder());
    }

    @Test
    public void test_constructor_2_00505() {
        int opCode = ObjectListControlPoint.OP_CODE_ORDER;
        long objectId = 0;
        int listSortOrder = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_LAST_MODIFIED_TIMESTAMP_ASCENDING;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_LAST_MODIFIED_TIMESTAMP_ASCENDING,
                result1.getListSortOrder());
    }

    @Test
    public void test_constructor_2_00506() {
        int opCode = ObjectListControlPoint.OP_CODE_ORDER;
        long objectId = 0;
        int listSortOrder = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_NAME_DESCENDING;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_NAME_DESCENDING, result1.getListSortOrder());
    }

    @Test
    public void test_constructor_2_00507() {
        int opCode = ObjectListControlPoint.OP_CODE_ORDER;
        long objectId = 0;
        int listSortOrder = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_TYPE_DESCENDING;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_TYPE_DESCENDING, result1.getListSortOrder());
    }

    @Test
    public void test_constructor_2_00508() {
        int opCode = ObjectListControlPoint.OP_CODE_ORDER;
        long objectId = 0;
        int listSortOrder = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_CURRENT_SIZE_DESCENDING;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_CURRENT_SIZE_DESCENDING, result1.getListSortOrder());
    }

    @Test
    public void test_constructor_2_00509() {
        int opCode = ObjectListControlPoint.OP_CODE_ORDER;
        long objectId = 0;
        int listSortOrder = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_FIRST_CREATED_TIMESTAMP_DESCENDING;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_FIRST_CREATED_TIMESTAMP_DESCENDING,
                result1.getListSortOrder());
    }

    @Test
    public void test_constructor_2_00510() {
        int opCode = ObjectListControlPoint.OP_CODE_ORDER;
        long objectId = 0;
        int listSortOrder = ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_LAST_MODIFIED_TIMESTAMP_DESCENDING;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertTrue(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.LIST_SORT_ORDER_OBJECT_LAST_MODIFIED_TIMESTAMP_DESCENDING,
                result1.getListSortOrder());
    }

    @Test
    public void test_constructor_2_00601() {
        int opCode = ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertTrue(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_2_00701() {
        int opCode = ObjectListControlPoint.OP_CODE_CLEAR_MARKING;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = 0;
        int resultCode = 0;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_CLEAR_MARKING, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertTrue(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_2_00801() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_FIRST;
        int resultCode = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_FIRST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00802() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_FIRST;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_FIRST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00803() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_FIRST;
        int resultCode = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_FIRST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00804() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_FIRST;
        int resultCode = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_FIRST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00805() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_LAST;
        int resultCode = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_LAST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00806() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_LAST;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_LAST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00807() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_LAST;
        int resultCode = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_LAST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00808() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_LAST;
        int resultCode = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_LAST, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00809() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_PREVIOUS;
        int resultCode = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_PREVIOUS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00810() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_PREVIOUS;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OUT_OF_BOUNDS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_PREVIOUS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OUT_OF_BOUNDS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00811() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_PREVIOUS;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_PREVIOUS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00812() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_PREVIOUS;
        int resultCode = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_PREVIOUS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00813() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_PREVIOUS;
        int resultCode = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_PREVIOUS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00814() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_NEXT;
        int resultCode = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_NEXT, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00815() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_NEXT;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OUT_OF_BOUNDS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_NEXT, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OUT_OF_BOUNDS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00816() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_NEXT;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_NEXT, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00817() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_NEXT;
        int resultCode = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_NEXT, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00818() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_NEXT;
        int resultCode = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_NEXT, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00819() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_GO_TO;
        int resultCode = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00820() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_GO_TO;
        int resultCode = ObjectListControlPoint.RESULT_CODE_INVALID_PARAMETER;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00821() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_GO_TO;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OBJECT_ID_NOT_FOUND;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OBJECT_ID_NOT_FOUND, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00822() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_GO_TO;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00823() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_GO_TO;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00824() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_GO_TO;
        int resultCode = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00825() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_GO_TO;
        int resultCode = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_GO_TO, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00826() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_ORDER;
        int resultCode = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00827() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_ORDER;
        int resultCode = ObjectListControlPoint.RESULT_CODE_INVALID_PARAMETER;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00828() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_ORDER;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00829() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_ORDER;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00830() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_ORDER;
        int resultCode = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00831() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_ORDER;
        int resultCode = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_ORDER, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00832() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS;
        int resultCode = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        int totalNumberOfObjects = 1;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertEquals(totalNumberOfObjects, result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_constructor_2_00833() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00834() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00835() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS;
        int resultCode = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00836() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS;
        int resultCode = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_REQUEST_NUMBER_OF_OBJECTS, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00837() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_CLEAR_MARKING;
        int resultCode = ObjectListControlPoint.RESULT_CODE_SUCCESS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_CLEAR_MARKING, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_SUCCESS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00838() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_CLEAR_MARKING;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_CLEAR_MARKING, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00839() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_CLEAR_MARKING;
        int resultCode = ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_CLEAR_MARKING, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00840() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_CLEAR_MARKING;
        int resultCode = ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_CLEAR_MARKING, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_TOO_MANY_OBJECTS, result1.getResultCode());
    }

    @Test
    public void test_constructor_2_00841() {
        int opCode = ObjectListControlPoint.OP_CODE_RESPONSE_CODE;
        long objectId = 0;
        int listSortOrder = 0;
        int requestOpCode = ObjectListControlPoint.OP_CODE_CLEAR_MARKING;
        int resultCode = ObjectListControlPoint.RESULT_CODE_NO_OBJECT;
        int totalNumberOfObjects = 0;

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(opCode, objectId, listSortOrder, requestOpCode,
                resultCode, totalNumberOfObjects);
        assertEquals(ObjectListControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertFalse(result1.isOpCodeFirst(result1.getOpCode()));
        assertFalse(result1.isOpCodeLast(result1.getOpCode()));
        assertFalse(result1.isOpCodePrevious(result1.getOpCode()));
        assertFalse(result1.isOpCodeNext(result1.getOpCode()));
        assertFalse(result1.isOpCodeGoTo(result1.getOpCode()));
        assertFalse(result1.isOpCodeOrder(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestNumberOfObjects(result1.getOpCode()));
        assertFalse(result1.isOpCodeClearMarking(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(ObjectListControlPoint.OP_CODE_CLEAR_MARKING, result1.getRequestOpCode());
        assertEquals(ObjectListControlPoint.RESULT_CODE_NO_OBJECT, result1.getResultCode());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00502() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00503() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00504() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00505() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00506() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00507() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00508() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00509() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00510() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00801() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00802() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00803() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00804() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00805() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00806() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00807() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00808() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00809() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00810() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00811() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00812() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00813() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00814() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00815() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00816() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00817() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00818() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00819() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00820() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00821() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00822() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00823() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00824() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00825() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00826() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00827() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00828() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00829() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00830() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00831() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00832() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00833() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00834() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00835() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00836() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00837() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00838() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00839() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00840() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_1_00841() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getObjectId(), result1.getObjectId());
        assertEquals(result2.getListSortOrder(), result1.getListSortOrder());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResultCode(), result1.getResultCode());
        assertEquals(result2.getTotalNumberOfObjects(), result1.getTotalNumberOfObjects());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00503() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00504() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00505() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00506() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00507() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00508() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00509() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00510() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00801() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00802() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00803() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00804() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00805() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00806() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00807() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00808() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00809() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00810() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00811() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00812() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00813() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00814() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00815() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00816() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00817() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00818() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00819() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00820() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00821() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00822() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00823() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00824() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00825() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00826() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00827() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00828() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00829() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00830() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00831() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00832() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00833() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00834() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00835() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00836() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00837() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00838() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00839() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00840() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00841() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00503() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00504() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00505() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00506() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00507() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00508() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00509() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00510() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00802() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00803() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00804() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00805() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00806() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00807() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00808() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00809() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00810() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00811() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00812() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00813() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00814() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00815() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00816() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00817() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00818() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00819() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00820() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00821() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00822() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00823() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00824() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00825() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00826() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00827() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00828() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00829() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00830() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00831() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00832() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00833() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00834() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00835() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00836() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00837() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00838() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00839() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00840() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00841() {
        byte[] data = getData();

        ObjectListControlPointAndroid result1 = new ObjectListControlPointAndroid(data);
        ObjectListControlPointAndroid result2 = ObjectListControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
