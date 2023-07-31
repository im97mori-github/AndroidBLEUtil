package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * Periodic Advertising Response Timing Information
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class PeriodicAdvertisingResponseTimingInformationAndroid extends PeriodicAdvertisingResponseTimingInformation implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PeriodicAdvertisingResponseTimingInformationAndroid> CREATOR = new ByteArrayCreator<PeriodicAdvertisingResponseTimingInformationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeriodicAdvertisingResponseTimingInformationAndroid createFromParcel(@NonNull Parcel in) {
            return new PeriodicAdvertisingResponseTimingInformationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeriodicAdvertisingResponseTimingInformationAndroid[] newArray(int size) {
            return new PeriodicAdvertisingResponseTimingInformationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public PeriodicAdvertisingResponseTimingInformationAndroid createFromByteArray(@NonNull byte[] values) {
            return new PeriodicAdvertisingResponseTimingInformationAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #PeriodicAdvertisingResponseTimingInformationAndroid(byte[], int, int)
     */
    public PeriodicAdvertisingResponseTimingInformationAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Encrypted Data
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public PeriodicAdvertisingResponseTimingInformationAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param rspAa               RspAA
     * @param numSubevents        numSubevents
     * @param subeventInterval    subeventInterval
     * @param responseSlotDelay   responseSlotDelay
     * @param responseSlotSpacing responseSlotSpacing
     */
    public PeriodicAdvertisingResponseTimingInformationAndroid(@NonNull byte[] rspAa, int numSubevents, int subeventInterval,
                                                               int responseSlotDelay, int responseSlotSpacing) {
        super(rspAa, numSubevents, subeventInterval, responseSlotDelay, responseSlotSpacing);

    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PeriodicAdvertisingResponseTimingInformationAndroid(@NonNull Parcel in) {
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
