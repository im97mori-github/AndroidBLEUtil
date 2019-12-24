package org.im97mori.ble.characteristic.uds;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;

/**
 * First Name (Characteristics UUID: 0x2A8A)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FirstName implements Parcelable {

    /**
     * @see MultiplePacketCreater
     */
    public static final MultiplePacketCreater<FirstName, RegisteredUser> CREATOR = new MultiplePacketCreater<FirstName, RegisteredUser>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FirstName createFromParcel(@NonNull Parcel in) {
            return new FirstName(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FirstName[] newArray(int size) {
            return new FirstName[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public FirstName createFromMultiplePacketArray(@NonNull RegisteredUser[] multiplePacketArray) {
            return new FirstName(multiplePacketArray);
        }

    };

    /**
     * First Name
     */
    private final String mFirstName;

    /**
     * Constructor from RegisteredUser array
     *
     * @param registeredUsers first to last Registered User Data array
     */
    public FirstName(@NonNull RegisteredUser[] registeredUsers) {
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

        mFirstName = new String(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FirstName(@NonNull Parcel in) {
        mFirstName = in.readString();
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
        dest.writeString(mFirstName);
    }

    /**
     * @return First Name
     */
    public String getFirstName() {
        return mFirstName;
    }

}
