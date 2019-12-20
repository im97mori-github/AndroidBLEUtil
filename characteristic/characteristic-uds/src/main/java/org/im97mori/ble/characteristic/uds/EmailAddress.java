package org.im97mori.ble.characteristic.uds;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;

/**
 * Email Address (Characteristics UUID: 0x2A87)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class EmailAddress implements Parcelable {

    /**
     * @see RegisteredUserCreater
     */
    public static final RegisteredUserCreater<EmailAddress> CREATOR = new RegisteredUserCreater<EmailAddress>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EmailAddress createFromParcel(@NonNull Parcel in) {
            return new EmailAddress(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EmailAddress[] newArray(int size) {
            return new EmailAddress[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public EmailAddress createFromRegisteredUsersArray(@NonNull RegisteredUser[] registeredUsers) {
            return new EmailAddress(registeredUsers);
        }

    };

    /**
     * Email Address
     */
    private final String mEmailAddress;

    /**
     * Constructor from RegisteredUser array
     *
     * @param registeredUsers first to last Registered User Data array
     */
    public EmailAddress(@NonNull RegisteredUser[] registeredUsers) {
        List<byte[]> dataList = new LinkedList<>();
        int length = 0;
        for (RegisteredUser registeredUser : registeredUsers) {
            dataList.add(registeredUser.getRegisteredUserData());
            length += dataList.get(dataList.size() - 1).length;
        }
        byte[] values = new byte[length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(values).order(ByteOrder.LITTLE_ENDIAN);
        for (byte[] data : dataList) {
            byteBuffer.put(data);
        }

        mEmailAddress = new String(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EmailAddress(@NonNull Parcel in) {
        mEmailAddress = in.readString();
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
        dest.writeString(mEmailAddress);
    }

    /**
     * @return Email Address
     */
    public String getEmailAddress() {
        return mEmailAddress;
    }

}
