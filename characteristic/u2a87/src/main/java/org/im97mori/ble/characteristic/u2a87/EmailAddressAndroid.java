package org.im97mori.ble.characteristic.u2a87;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.core.MultiplePacketCreater;
import org.im97mori.ble.characteristic.core.RegisteredUser;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;

/**
 * Email Address (Characteristics UUID: 0x2A87)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class EmailAddressAndroid extends EmailAddress implements Parcelable {

    /**
     * @see MultiplePacketCreater
     */
    public static final MultiplePacketCreater<EmailAddressAndroid, RegisteredUser> CREATOR = new MultiplePacketCreater<EmailAddressAndroid, RegisteredUser>() {

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
    public EmailAddressAndroid(@NonNull RegisteredUser[] registeredUsers) {
        super(registeredUsers);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private EmailAddressAndroid(@NonNull Parcel in) {
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
