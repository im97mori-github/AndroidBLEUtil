package org.im97mori.ble.characteristic.u2a87;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.core.MultiplePacketCreator;
import org.im97mori.ble.characteristic.u2b37.RegisteredUser;

import java.util.Objects;

/**
 * Email Address (Characteristics UUID: 0x2A87)
 */
@SuppressWarnings({"WeakerAccess"})
public class EmailAddressAndroid extends EmailAddress implements Parcelable {

    /**
     * @see MultiplePacketCreator
     */
    public static final MultiplePacketCreator<EmailAddressAndroid, RegisteredUser> CREATOR = new MultiplePacketCreator<EmailAddressAndroid, RegisteredUser>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EmailAddressAndroid createFromParcel(@NonNull Parcel in) {
            return new EmailAddressAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EmailAddressAndroid[] newArray(int size) {
            return new EmailAddressAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public EmailAddressAndroid createFromMultiplePacketArray(@NonNull RegisteredUser[] multiplePacketArray) {
            return new EmailAddressAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from RegisteredUser array
     *
     * @param registeredUsers first to last Registered User Data array
     */
    public EmailAddressAndroid(@NonNull RegisteredUser... registeredUsers) {
        super(registeredUsers);
    }

    /**
     * Constructor from parameters
     *
     * @param emailAddress Email Address
     */
    public EmailAddressAndroid(@NonNull String emailAddress) {
        super(emailAddress);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EmailAddressAndroid(@NonNull Parcel in) {
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
