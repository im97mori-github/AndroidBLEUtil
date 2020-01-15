package org.im97mori.ble.characteristic.tds;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused"})
public class TDSControlPointUtilsTest {

    @Test
    public void test_00001() {
        assertTrue(TDSControlPointUtils.isOpCodeActivateTransport(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT));
    }

    @Test
    public void test_00101() {
        assertTrue(TDSControlPointUtils.isResultCodeSuccess(TDSControlPointUtils.RESULT_CODE_SUCCESS));
        assertFalse(TDSControlPointUtils.isResultCodeOpCodeNotSupported(TDSControlPointUtils.RESULT_CODE_SUCCESS));
        assertFalse(TDSControlPointUtils.isResultCodeInvalidParameter(TDSControlPointUtils.RESULT_CODE_SUCCESS));
        assertFalse(TDSControlPointUtils.isResultCodeUnsupportedOrganizationId(TDSControlPointUtils.RESULT_CODE_SUCCESS));
        assertFalse(TDSControlPointUtils.isResultCodeOperationFailed(TDSControlPointUtils.RESULT_CODE_SUCCESS));
    }

    @Test
    public void test_00102() {
        assertFalse(TDSControlPointUtils.isResultCodeSuccess(TDSControlPointUtils.RESULT_CODE_OP_CODE_NOT_SUPPORTED));
        assertTrue(TDSControlPointUtils.isResultCodeOpCodeNotSupported(TDSControlPointUtils.RESULT_CODE_OP_CODE_NOT_SUPPORTED));
        assertFalse(TDSControlPointUtils.isResultCodeInvalidParameter(TDSControlPointUtils.RESULT_CODE_OP_CODE_NOT_SUPPORTED));
        assertFalse(TDSControlPointUtils.isResultCodeUnsupportedOrganizationId(TDSControlPointUtils.RESULT_CODE_OP_CODE_NOT_SUPPORTED));
        assertFalse(TDSControlPointUtils.isResultCodeOperationFailed(TDSControlPointUtils.RESULT_CODE_OP_CODE_NOT_SUPPORTED));
    }

    @Test
    public void test_00103() {
        assertFalse(TDSControlPointUtils.isResultCodeSuccess(TDSControlPointUtils.RESULT_CODE_INVALID_PARAMETER));
        assertFalse(TDSControlPointUtils.isResultCodeOpCodeNotSupported(TDSControlPointUtils.RESULT_CODE_INVALID_PARAMETER));
        assertTrue(TDSControlPointUtils.isResultCodeInvalidParameter(TDSControlPointUtils.RESULT_CODE_INVALID_PARAMETER));
        assertFalse(TDSControlPointUtils.isResultCodeUnsupportedOrganizationId(TDSControlPointUtils.RESULT_CODE_INVALID_PARAMETER));
        assertFalse(TDSControlPointUtils.isResultCodeOperationFailed(TDSControlPointUtils.RESULT_CODE_INVALID_PARAMETER));
    }

    @Test
    public void test_00104() {
        assertFalse(TDSControlPointUtils.isResultCodeSuccess(TDSControlPointUtils.RESULT_CODE_UNSUPPORTED_ORGANIZATION_ID));
        assertFalse(TDSControlPointUtils.isResultCodeOpCodeNotSupported(TDSControlPointUtils.RESULT_CODE_UNSUPPORTED_ORGANIZATION_ID));
        assertFalse(TDSControlPointUtils.isResultCodeInvalidParameter(TDSControlPointUtils.RESULT_CODE_UNSUPPORTED_ORGANIZATION_ID));
        assertTrue(TDSControlPointUtils.isResultCodeUnsupportedOrganizationId(TDSControlPointUtils.RESULT_CODE_UNSUPPORTED_ORGANIZATION_ID));
        assertFalse(TDSControlPointUtils.isResultCodeOperationFailed(TDSControlPointUtils.RESULT_CODE_UNSUPPORTED_ORGANIZATION_ID));
    }

    @Test
    public void test_00105() {
        assertFalse(TDSControlPointUtils.isResultCodeSuccess(TDSControlPointUtils.RESULT_CODE_OPERATION_FAILED));
        assertFalse(TDSControlPointUtils.isResultCodeOpCodeNotSupported(TDSControlPointUtils.RESULT_CODE_OPERATION_FAILED));
        assertFalse(TDSControlPointUtils.isResultCodeInvalidParameter(TDSControlPointUtils.RESULT_CODE_OPERATION_FAILED));
        assertFalse(TDSControlPointUtils.isResultCodeUnsupportedOrganizationId(TDSControlPointUtils.RESULT_CODE_OPERATION_FAILED));
        assertTrue(TDSControlPointUtils.isResultCodeOperationFailed(TDSControlPointUtils.RESULT_CODE_OPERATION_FAILED));
    }

}
