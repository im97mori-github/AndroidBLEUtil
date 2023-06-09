package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

/**
 * <p>
 * Indoor Positioning
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class IndoorPositioningAndroid extends IndoorPositioning implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IndoorPositioningAndroid> CREATOR = new ByteArrayCreator<IndoorPositioningAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorPositioningAndroid createFromParcel(@NonNull Parcel in) {
            return new IndoorPositioningAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorPositioningAndroid[] newArray(int size) {
            return new IndoorPositioningAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public IndoorPositioningAndroid createFromByteArray(@NonNull byte[] values) {
            return new IndoorPositioningAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #IndoorPositioningAndroid(byte[], int, int)
     */
    public IndoorPositioningAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Indoor Positioning
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public IndoorPositioningAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     * @param globalCoordinatesLatitude       Global Coordinates (Latitude)
     * @param globalCoordinatesLongitude      Global Coordinates (Longitude)
     * @param localCoordinatesNorth          Local Coordinates (North)
     * @param localCoordinatesEast           Local Coordinates (East)
     * @param txPower                        Tx Power
     * @param floorNumber                    Floor Number
     * @param altitude                       Altitude
     * @param uncertainty                    Uncertainty
     */
    public IndoorPositioningAndroid(int indoorPositioningConfiguration
            , int globalCoordinatesLatitude
            , int globalCoordinatesLongitude
            , int localCoordinatesNorth
            , int localCoordinatesEast
            , int txPower
            , int floorNumber
            , int altitude
            , int uncertainty) {
        super(indoorPositioningConfiguration
                , globalCoordinatesLatitude
                , globalCoordinatesLongitude
                , localCoordinatesNorth
                , localCoordinatesEast
                , txPower
                , floorNumber
                , altitude
                , uncertainty);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IndoorPositioningAndroid(@NonNull Parcel in) {
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
