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
 * Last Name (Characteristics UUID: 0x2A90)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class LastName implements Parcelable {

    /**
     * @see MultiplePacketCreater
     */
    public static final MultiplePacketCreater<LastName, RegisteredUser> CREATOR = new MultiplePacketCreater<LastName, RegisteredUser>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LastName createFromParcel(@NonNull Parcel in) {
            return new LastName(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LastName[] newArray(int size) {
            return new LastName[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public LastName createFromMultiplePacketArray(@NonNull RegisteredUser[] multiplePacketArray) {
            return new LastName(multiplePacketArray);
        }

    };

    /**
     * Last Name
     */
    private final String mLastName;

    /**
     * Constructor from RegisteredUser array
     *
     * @param registeredUsers first to last Registered User Data array
     */
    public LastName(@NonNull RegisteredUser[] registeredUsers) {
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

        mLastName = new String(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LastName(@NonNull Parcel in) {
        mLastName = in.readString();
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
        dest.writeString(mLastName);
    }

    /**
     * @return Last Name
     */
    public String getLastName() {
        return mLastName;
    }

}
