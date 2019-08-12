package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_PUBLIC_TARGET_ADDRESS;

/**
 * <p>
 * Public Target Address
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings("WeakerAccess")
public class PublicTargetAddress extends AbstractAdvertisingData {

    /**
     * @see Creator
     */
    public static final Creator<PublicTargetAddress> CREATOR = new Creator<PublicTargetAddress>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public PublicTargetAddress createFromParcel(Parcel in) {
            return new PublicTargetAddress(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public PublicTargetAddress[] newArray(int size) {
            return new PublicTargetAddress[size];
        }

    };

    /**
     * Public Target Address list
     */
    private final List<byte[]> mAddressList;

    /**
     * Constructor for Public Target Address
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public PublicTargetAddress(byte[] data, int offset, int length) {
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
    @SuppressWarnings("unchecked")
    private PublicTargetAddress(Parcel in) {
        super(in.readInt());
        mAddressList = Collections.synchronizedList(in.readArrayList(this.getClass().getClassLoader()));
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mLength);
        dest.writeList(mAddressList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_PUBLIC_TARGET_ADDRESS;
    }

    /**
     * @return Public Target Address list
     */
    public List<byte[]> getAddressList() {
        return mAddressList;
    }

}
