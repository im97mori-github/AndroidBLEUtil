package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;

/**
 * <p>
 * List of 128-bit Service Solicitation UUIDs
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings("WeakerAccess")
public class ListOf128BitServiceSolicitationUUIDs extends AbstractAdvertisingData {

    /**
     * @see Creator
     */
    public static final Creator<ListOf128BitServiceSolicitationUUIDs> CREATOR = new Creator<ListOf128BitServiceSolicitationUUIDs>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ListOf128BitServiceSolicitationUUIDs createFromParcel(Parcel in) {
            return new ListOf128BitServiceSolicitationUUIDs(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ListOf128BitServiceSolicitationUUIDs[] newArray(int size) {
            return new ListOf128BitServiceSolicitationUUIDs[size];
        }

    };

    /**
     * UUID list
     */
    private final List<UUID> mUuidList;

    /**
     * Constructor for List of 128-bit Service Solicitation UUIDs
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public ListOf128BitServiceSolicitationUUIDs(byte[] data, int offset, int length) {
        super(length);

        ByteBuffer bb;
        List<UUID> uuidList = new ArrayList<>();
        for (int i = offset + 2; i < offset + length + 1; i += 16) {
            bb = ByteBuffer.wrap(data, i, 16).order(ByteOrder.LITTLE_ENDIAN);
            long lsb = bb.getLong();
            long msb = bb.getLong();
            uuidList.add(new UUID(msb, lsb));
        }
        mUuidList = Collections.synchronizedList(Collections.unmodifiableList(uuidList));
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("unchecked")
    private ListOf128BitServiceSolicitationUUIDs(Parcel in) {
        super(in.readInt());
        mUuidList = Collections.synchronizedList(in.readArrayList(this.getClass().getClassLoader()));
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
        dest.writeList(mUuidList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
    }

    /**
     * UUID list
     *
     * @return {@link List<UUID>}
     */
    public List<UUID> getUuidList() {
        return mUuidList;
    }

}
