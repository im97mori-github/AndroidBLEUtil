package org.im97mori.ble.characteristic.uds;

import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * Registered User Data array Creator
 *
 * @param <T> T must have constructor with {@link RegisteredUser} array
 */
public interface RegisteredUserCreater<T> extends Parcelable.Creator<T> {

    /**
     * Create instance from Registered User Data array
     *
     * @param registeredUsers first to last Registered User Data array
     * @return T instance
     */
    @NonNull
    T createFromRegisteredUsersArray(@NonNull RegisteredUser[] registeredUsers);

}
