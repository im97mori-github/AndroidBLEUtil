package org.im97mori.ble.characteristic.u2a90;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.core.MultiplePacketCreator;
import org.im97mori.ble.characteristic.u2b37.RegisteredUser;

import java.util.Objects;

/**
 * Last Name (Characteristics UUID: 0x2A90)
 */
@SuppressWarnings({"WeakerAccess"})
public class LastNameAndroid extends LastName implements Parcelable {

    /**
     * @see MultiplePacketCreator
     */
    public static final MultiplePacketCreator<LastNameAndroid, RegisteredUser> CREATOR = new MultiplePacketCreator<LastNameAndroid, RegisteredUser>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LastNameAndroid createFromParcel(@NonNull Parcel in) {
            return new LastNameAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LastNameAndroid[] newArray(int size) {
            return new LastNameAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public LastNameAndroid createFromMultiplePacketArray(@NonNull RegisteredUser[] multiplePacketArray) {
            return new LastNameAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from RegisteredUser array
     *
     * @param registeredUsers first to last Registered User Data array
     */
    public LastNameAndroid(@NonNull RegisteredUser... registeredUsers) {
        super(registeredUsers);
    }

    /**
     * Constructor from parameters
     *
     * @param lastName Last Name
     */
    public LastNameAndroid(@NonNull String lastName) {
        super(lastName);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LastNameAndroid(@NonNull Parcel in) {
        super(new RegisteredUser(Objects.requireNonNull(in.createByteArray())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeByteArray(getBytes());
    }

}
