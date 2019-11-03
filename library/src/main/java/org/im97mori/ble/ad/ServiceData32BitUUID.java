package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import java.util.UUID;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
import static org.im97mori.ble.ad.AdvertisingDataConstants.BASE_UUID;

/**
 * <p>
 * Service Data - 32-bit UUID
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class ServiceData32BitUUID extends AbstractAdvertisingData {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ServiceData32BitUUID> CREATOR = new ByteArrayCreater<ServiceData32BitUUID>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData32BitUUID createFromParcel(@NonNull Parcel in) {
            return new ServiceData32BitUUID(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData32BitUUID[] newArray(int size) {
            return new ServiceData32BitUUID[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ServiceData32BitUUID createFromByteArray(@NonNull byte[] values) {
            return new ServiceData32BitUUID(values, 0, values.length - 1);
        }

    };

    /**
     * UUID
     */
    private final UUID mUuid;

    /**
     * byte array of Additional service data
     */
    private final byte[] mAdditionalServiceData;

    /**
     * Constructor for Service Data - 32-bit UUID
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public ServiceData32BitUUID(@NonNull byte[] data
            , int offset
            , int length) {
        super(length);

        long target = data[offset + 2] & 0xff;
        target |= (data[offset + 3] & 0xff) << 8;
        target |= (data[offset + 4] & 0xff) << 16;
        target |= (data[offset + 5] & 0xff) << 24;
        target = target << 32;
        mUuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        mAdditionalServiceData = new byte[length - 5];
        if (mAdditionalServiceData.length > 0) {
            System.arraycopy(data, offset + 6, mAdditionalServiceData, 0, length - 5);
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ServiceData32BitUUID(@NonNull Parcel in) {
        super(in.readInt());
        mUuid = (UUID) in.readSerializable();
        mAdditionalServiceData = in.createByteArray();
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
        dest.writeSerializable(mUuid);
        dest.writeByteArray(mAdditionalServiceData);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
    }

    /**
     * @return {@link UUID}
     */
    @NonNull
    public UUID getUuid() {
        return mUuid;
    }

    /**
     * @return byte array of Manufacturer Specific Data
     */
    @NonNull
    public byte[] getAdditionalServiceData() {
        return mAdditionalServiceData;
    }

}
