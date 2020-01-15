package org.im97mori.ble.characteristic.tds;

@SuppressWarnings("WeakerAccess")
public class TDSControlPointUtils {

    /**
     * 0x01: Activate Transport
     */
    public static final int OP_CODE_ACTIVATE_TRANSPORT = 0x01;

    /**
     * 0x00: Success
     */
    public static final int RESULT_CODE_SUCCESS = 0x00;

    /**
     * 0x01: Op Code Not Supported
     */
    public static final int RESULT_CODE_OP_CODE_NOT_SUPPORTED = 0x01;

    /**
     * 0x02: Invalid Parameter
     */
    public static final int RESULT_CODE_INVALID_PARAMETER = 0x02;

    /**
     * 0x03: Unsupported Organization ID
     */
    public static final int RESULT_CODE_UNSUPPORTED_ORGANIZATION_ID = 0x03;

    /**
     * 0x04: Operation Failed
     */
    public static final int RESULT_CODE_OPERATION_FAILED = 0x04;

    /**
     * @param opCode Op Code
     * @return {@code true}:Activate Transport, {@code false}:not Activate Transport
     */
    public static boolean isOpCodeActivateTransport(int opCode) {
        return OP_CODE_ACTIVATE_TRANSPORT == opCode;
    }

    /**
     * @param resultCode Result Code
     * @return {@code true}:Success, {@code false}:not Success
     */
    public static boolean isResultCodeSuccess(int resultCode) {
        return RESULT_CODE_SUCCESS == resultCode;
    }

    /**
     * @param resultCode Result Code
     * @return {@code true}:Op Code Not Supported, {@code false}:not Op Code Not Supported
     */
    public static boolean isResultCodeOpCodeNotSupported(int resultCode) {
        return RESULT_CODE_OP_CODE_NOT_SUPPORTED == resultCode;
    }

    /**
     * @param resultCode Result Code
     * @return {@code true}:Invalid Parameter, {@code false}:not Invalid Parameter
     */
    public static boolean isResultCodeInvalidParameter(int resultCode) {
        return RESULT_CODE_INVALID_PARAMETER == resultCode;
    }

    /**
     * @param resultCode Result Code
     * @return {@code true}:Unsupported Organization ID, {@code false}:not Unsupported Organization ID
     */
    public static boolean isResultCodeUnsupportedOrganizationId(int resultCode) {
        return RESULT_CODE_UNSUPPORTED_ORGANIZATION_ID == resultCode;
    }

    /**
     * @param resultCode Result Code
     * @return {@code true}:Operation Failed, {@code false}:not Operation Failed
     */
    public static boolean isResultCodeOperationFailed(int resultCode) {
        return RESULT_CODE_OPERATION_FAILED == resultCode;
    }

}
