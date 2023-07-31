package org.im97mori.ble.characteristic.u2a8a;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.core.MultiplePacketCreator;
import org.im97mori.ble.characteristic.u2b37.RegisteredUser;

import java.util.Objects;

/**
 * First Name (Characteristics UUID: 0x2A8A)
 */
@SuppressWarnings({"WeakerAccess"})
public class FirstNameAndroid extends FirstName implements Parcelable {

    /**
     * @see MultiplePacketCreator
     */
    public static final MultiplePacketCreator<FirstNameAndroid, RegisteredUser> CREATOR = new MultiplePacketCreator<FirstNameAndroid, RegisteredUser>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FirstNameAndroid createFromParcel(@NonNull Parcel in) {
            return new FirstNameAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FirstNameAndroid[] newArray(int size) {
            return new FirstNameAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public FirstNameAndroid createFromMultiplePacketArray(@NonNull RegisteredUser[] multiplePacketArray) {
            return new FirstNameAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from RegisteredUser array
     *
     * @param registeredUsers first to last Registered User Data array
     */
    public FirstNameAndroid(@NonNull RegisteredUser... registeredUsers) {
        super(registeredUsers);
    }

    /**
     * Constructor from parameters
     *
     * @param firstName First Name
     */
    public FirstNameAndroid(@NonNull String firstName) {
        super(firstName);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FirstNameAndroid(@NonNull Parcel in) {
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
