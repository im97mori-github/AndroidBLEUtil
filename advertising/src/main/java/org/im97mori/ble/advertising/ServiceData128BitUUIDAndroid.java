package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.UUID;

/**
 * <p>
 * Service Data - 128-bit UUID
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class ServiceData128BitUUIDAndroid extends ServiceData128BitUUID implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ServiceData128BitUUIDAndroid> CREATOR = new ByteArrayCreator<ServiceData128BitUUIDAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData128BitUUIDAndroid createFromParcel(@NonNull Parcel in) {
            return new ServiceData128BitUUIDAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData128BitUUIDAndroid[] newArray(int size) {
            return new ServiceData128BitUUIDAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ServiceData128BitUUIDAndroid createFromByteArray(@NonNull byte[] values) {
            return new ServiceData128BitUUIDAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #ServiceData128BitUUIDAndroid(byte[], int, int)
     */
    public ServiceData128BitUUIDAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Service Data - 128-bit UUID
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public ServiceData128BitUUIDAndroid(@NonNull byte[] data
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
    public ServiceData128BitUUIDAndroid(@NonNull UUID uuid, @NonNull byte[] additionalServiceData) {
        super(uuid, additionalServiceData);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ServiceData128BitUUIDAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(in.createByteArray(), 0, in.readInt());
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
