package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;
import java.util.UUID;

/**
 * <p>
 * Service Data - 32-bit UUID
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class ServiceData32BitUUIDAndroid extends ServiceData32BitUUID implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ServiceData32BitUUIDAndroid> CREATOR = new ByteArrayCreator<ServiceData32BitUUIDAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData32BitUUIDAndroid createFromParcel(@NonNull Parcel in) {
            return new ServiceData32BitUUIDAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData32BitUUIDAndroid[] newArray(int size) {
            return new ServiceData32BitUUIDAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ServiceData32BitUUIDAndroid createFromByteArray(@NonNull byte[] values) {
            return new ServiceData32BitUUIDAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #ServiceData32BitUUIDAndroid(byte[], int, int)
     */
    public ServiceData32BitUUIDAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Service Data - 32-bit UUID
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public ServiceData32BitUUIDAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param uuid                  UUID
     * @param additionalServiceData byte array of Additional service data
     */
    public ServiceData32BitUUIDAndroid(@NonNull UUID uuid, @NonNull byte[] additionalServiceData) {
        super(uuid, additionalServiceData);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ServiceData32BitUUIDAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()), 0, in.readInt());
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
        dest.writeInt(getLength());
    }

}
