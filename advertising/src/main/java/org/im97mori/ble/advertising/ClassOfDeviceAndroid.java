package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Class of Device
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class ClassOfDeviceAndroid extends ClassOfDevice implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ClassOfDeviceAndroid> CREATOR = new ByteArrayCreator<ClassOfDeviceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ClassOfDeviceAndroid createFromParcel(@NonNull Parcel in) {
            return new ClassOfDeviceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ClassOfDeviceAndroid[] newArray(int size) {
            return new ClassOfDeviceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ClassOfDeviceAndroid createFromByteArray(@NonNull byte[] values) {
            return new ClassOfDeviceAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #ClassOfDeviceAndroid(byte[], int, int)
     */
    public ClassOfDeviceAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Tx Power Level
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public ClassOfDeviceAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param classOfDevice Class of Device
     */
    public ClassOfDeviceAndroid(int classOfDevice) {
        super(classOfDevice);

    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ClassOfDeviceAndroid(@NonNull Parcel in) {
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
