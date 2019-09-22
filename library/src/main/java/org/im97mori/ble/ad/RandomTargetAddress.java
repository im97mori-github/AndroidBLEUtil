package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_RANDOM_TARGET_ADDRESS;

/**
 * <p>
 * Random Target Address
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings("WeakerAccess")
public class RandomTargetAddress extends AbstractAdvertisingData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<RandomTargetAddress> CREATOR = new Creator<RandomTargetAddress>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RandomTargetAddress createFromParcel(@NonNull Parcel in) {
            return new RandomTargetAddress(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RandomTargetAddress[] newArray(int size) {
            return new RandomTargetAddress[size];
        }

    };

    /**
     * Random Target Address list
     */
    private final List<byte[]> mAddressList;

    /**
     * Constructor for Random Target Address
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public RandomTargetAddress(@NonNull byte[] data, int offset, int length) {
        super(length);

        List<byte[]> addressList = new ArrayList<>();
        byte[] address;
        for (int i = offset + 2; i < offset + length - 1; i += 6) {
            address = new byte[6];
            System.arraycopy(data, i, address, 0, 6);
            addressList.add(address);
        }
        mAddressList = Collections.synchronizedList(Collections.unmodifiableList(addressList));
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RandomTargetAddress(@NonNull Parcel in) {
        super(in.readInt());

        List<byte[]> list = new ArrayList<>();
        in.readList(list, this.getClass().getClassLoader());
        mAddressList = Collections.synchronizedList(Collections.unmodifiableList(list));
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
        dest.writeInt(mLength);
        dest.writeList(mAddressList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_RANDOM_TARGET_ADDRESS;
    }

    /**
     * @return Random Target Address list
     */
    @NonNull
    public List<byte[]> getAddressList() {
        return mAddressList;
    }

}
