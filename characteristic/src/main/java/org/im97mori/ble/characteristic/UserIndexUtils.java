package org.im97mori.ble.characteristic;

/**
 * Utility for org.bluetooth.characteristic.user_index(0x2A9A) characteristic
 */
@SuppressWarnings("WeakerAccess")
public class UserIndexUtils {

    /**
     * 255(0xff): The special value of 0xFF (255 Decimal) for User ID represents “unknown user”.
     */
    public static final int USER_ID_UNKNOWN_USER = 0xff;

    /**
     * @param userIndex org.bluetooth.characteristic.user_index
     * @return {@code true}:unknown user, {@code false}:not unknown user
     * @see #USER_ID_UNKNOWN_USER
     */
    public static boolean isUserIdUnknownUser(int userIndex) {
        return USER_ID_UNKNOWN_USER == userIndex;
    }

}
