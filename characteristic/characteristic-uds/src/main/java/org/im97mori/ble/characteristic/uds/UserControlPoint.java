package org.im97mori.ble.characteristic.uds;

/**
 * User Control Point (Characteristics UUID: 0x2A9F)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class UserControlPoint {

    /**
     * 0x01: Register New User
     */
    public static final int OP_CODE_REGISTER_NEW_USER = 0x01;

    /**
     * 0x02: Consent
     */
    public static final int OP_CODE_CONSENT = 0x02;

    /**
     * 0x03: Delete User Data
     */
    public static final int OP_CODE_DELETE_USER_DATA = 0x03;

    /**
     * 0x04: List All Users
     */
    public static final int OP_CODE_LIST_ALL_USERS = 0x04;

    /**
     * 0x05: Delete User(s)
     */
    public static final int OP_CODE_DELETE_USERS = 0x05;

    /**
     * 0x20: Response Code
     */
    public static final int OP_CODE_RESPONSE_CODE = 0x20;

}
