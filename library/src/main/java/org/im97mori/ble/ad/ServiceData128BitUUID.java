package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_128_BIT_UUID;

/**
 * <p>
 * Service Data - 128-bit UUID
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings("WeakerAccess")
public class ServiceData128BitUUID extends AbstractAdvertisingData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<ServiceData128BitUUID> CREATOR = new Creator<ServiceData128BitUUID>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData128BitUUID createFromParcel(@NonNull Parcel in) {
            return new ServiceData128BitUUID(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData128BitUUID[] newArray(int size) {
            return new ServiceData128BitUUID[size];
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
     * Constructor for Service Data - 128-bit UUID
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public ServiceData128BitUUID(@NonNull byte[] data, int offset, int length) {
        super(length);

        ByteBuffer bb = ByteBuffer.wrap(data, offset + 2, 16).order(ByteOrder.LITTLE_ENDIAN);
        long lsb = bb.getLong();
        long msb = bb.getLong();
        mUuid = new UUID(msb, lsb);

        // Additional service data
        mAdditionalServiceData = new byte[length - 17];
        if (mAdditionalServiceData.length > 0) {
            System.arraycopy(data, offset + 18, mAdditionalServiceData, 0, length - 17);
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ServiceData128BitUUID(@NonNull Parcel in) {
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
        return DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
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
