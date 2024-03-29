package org.im97mori.ble.characteristic.u2b48;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.core.MultiplePacketCreator;
import org.im97mori.ble.characteristic.u2b37.RegisteredUser;

import java.util.Objects;

/**
 * Middle Name (Characteristics UUID: 0x2B48)
 */
@SuppressWarnings({"WeakerAccess"})
public class MiddleNameAndroid extends MiddleName implements Parcelable {

    /**
     * @see MultiplePacketCreator
     */
    public static final MultiplePacketCreator<MiddleNameAndroid, RegisteredUser> CREATOR = new MultiplePacketCreator<MiddleNameAndroid, RegisteredUser>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MiddleNameAndroid createFromParcel(@NonNull Parcel in) {
            return new MiddleNameAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MiddleNameAndroid[] newArray(int size) {
            return new MiddleNameAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public MiddleNameAndroid createFromMultiplePacketArray(@NonNull RegisteredUser[] multiplePacketArray) {
            return new MiddleNameAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from RegisteredUser array
     *
     * @param registeredUsers first to last Registered User Data array
     */
    public MiddleNameAndroid(@NonNull RegisteredUser... registeredUsers) {
        super(registeredUsers);
    }

    /**
     * Constructor from parameters
     *
     * @param middleName Middle Name
     */
    public MiddleNameAndroid(@NonNull String middleName) {
        super(middleName);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MiddleNameAndroid(@NonNull Parcel in) {
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
