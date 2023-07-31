package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * LE Supported Features
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * Core Specification v5.1 Vol 6 Part B 4.6
 * </p>
 */
public class LeSupportedFeaturesAndroid extends LeSupportedFeatures implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LeSupportedFeaturesAndroid> CREATOR = new ByteArrayCreator<LeSupportedFeaturesAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LeSupportedFeaturesAndroid createFromParcel(@NonNull Parcel in) {
            return new LeSupportedFeaturesAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LeSupportedFeaturesAndroid[] newArray(int size) {
            return new LeSupportedFeaturesAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public LeSupportedFeaturesAndroid createFromByteArray(@NonNull byte[] values) {
            return new LeSupportedFeaturesAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #LeSupportedFeaturesAndroid(byte[], int, int)
     */
    public LeSupportedFeaturesAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for LE Supported Features
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public LeSupportedFeaturesAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param leSupportedFeaturesList LE Supported Features list
     */
    public LeSupportedFeaturesAndroid(@NonNull List<Integer> leSupportedFeaturesList) {
        super(leSupportedFeaturesList);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LeSupportedFeaturesAndroid(Parcel in) {
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
