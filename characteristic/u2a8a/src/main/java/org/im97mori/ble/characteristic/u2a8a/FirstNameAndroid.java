package org.im97mori.ble.characteristic.u2a8a;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.core.MultiplePacketCreater;
import org.im97mori.ble.characteristic.core.RegisteredUser;

/**
 * First Name (Characteristics UUID: 0x2A8A)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FirstNameAndroid extends FirstName implements Parcelable {

    /**
     * @see MultiplePacketCreater
     */
    public static final MultiplePacketCreater<FirstNameAndroid, RegisteredUser> CREATOR = new MultiplePacketCreater<FirstNameAndroid, RegisteredUser>() {

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
    public FirstNameAndroid(@NonNull RegisteredUser[] registeredUsers) {
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
    @SuppressWarnings("ConstantConditions")
    private FirstNameAndroid(@NonNull Parcel in) {
        super(new RegisteredUser[]{new RegisteredUser(in.createByteArray())});
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
