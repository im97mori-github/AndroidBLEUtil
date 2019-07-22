package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.BASE_UUID;

/**
 * <p>
 * Incomplete List of 16-bit Service Class UUIDs
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings("WeakerAccess")
public class IncompleteListOf16BitServiceUUIDs extends AbstractAdvertisingData implements Parcelable {

    /**
     * @see Creator
     */
    public static final Creator<IncompleteListOf16BitServiceUUIDs> CREATOR = new Creator<IncompleteListOf16BitServiceUUIDs>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public IncompleteListOf16BitServiceUUIDs createFromParcel(Parcel in) {
            return new IncompleteListOf16BitServiceUUIDs(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public IncompleteListOf16BitServiceUUIDs[] newArray(int size) {
            return new IncompleteListOf16BitServiceUUIDs[size];
        }

    };

    /**
     * UUID list
     */
    private final List<UUID> mUuidList;

    /**
     * Constructor for Incomplete List of 16-bit Service Class UUIDs
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public IncompleteListOf16BitServiceUUIDs(byte[] data, int offset, int length) {
        super(length);

        // combine with BASE UUID
        long lsb = BASE_UUID.getLeastSignificantBits();
        long msb = BASE_UUID.getMostSignificantBits();
        List<UUID> uuidList = new ArrayList<>();
        for (int i = offset + 2; i < offset + length + 1; i += 2) {
            long target = data[i] & 0xff;
            target |= (data[i + 1] & 0xff) << 8;
            target = target << 32;
            uuidList.add(new UUID(msb | target, lsb));
        }
        mUuidList = Collections.synchronizedList(Collections.unmodifiableList(uuidList));
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("unchecked")
    private IncompleteListOf16BitServiceUUIDs(Parcel in) {
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
        return DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
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
