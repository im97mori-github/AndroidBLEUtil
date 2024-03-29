package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;
import java.util.UUID;

/**
 * <p>
 * Service Data - 16-bit UUID
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class ServiceData16BitUUIDAndroid extends ServiceData16BitUUID implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ServiceData16BitUUIDAndroid> CREATOR = new ByteArrayCreator<ServiceData16BitUUIDAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData16BitUUIDAndroid createFromParcel(@NonNull Parcel in) {
            return new ServiceData16BitUUIDAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData16BitUUIDAndroid[] newArray(int size) {
            return new ServiceData16BitUUIDAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ServiceData16BitUUIDAndroid createFromByteArray(@NonNull byte[] values) {
            return new ServiceData16BitUUIDAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #ServiceData16BitUUIDAndroid(byte[], int, int)
     */
    public ServiceData16BitUUIDAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Service Data - 16-bit UUID
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public ServiceData16BitUUIDAndroid(@NonNull byte[] data
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
    public ServiceData16BitUUIDAndroid(@NonNull UUID uuid, @NonNull byte[] additionalServiceData) {
        super(uuid, additionalServiceData);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ServiceData16BitUUIDAndroid(@NonNull Parcel in) {
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
