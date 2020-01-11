package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.IndoorPositioningUtils;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INDOOR_POSITIONING;

/**
 * <p>
 * Indoor Positioning
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings({"unused"})
public class IndoorPositioning extends AbstractAdvertisingData {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IndoorPositioning> CREATOR = new ByteArrayCreater<IndoorPositioning>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorPositioning createFromParcel(@NonNull Parcel in) {
            return new IndoorPositioning(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorPositioning[] newArray(int size) {
            return new IndoorPositioning[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public IndoorPositioning createFromByteArray(@NonNull byte[] values) {
            return new IndoorPositioning(values, 0, values.length - 1);
        }

    };

    /**
     * Indoor Positioning Configuration
     */
    private final int mIndoorPositioningConfiguration;

    /**
     * Global Coordinates (Latitude)
     */
    private final int mGlobalCoorinatesLatitude;

    /**
     * Global Coordinates (Longitude)
     */
    private final int mGlobalCoorinatesLongitude;

    /**
     * Local Coordinates (North)
     */
    private final int mLocalCoordinatesNorth;

    /**
     * Local Coordinates (East)
     */
    private final int mLocalCoordinatesEast;

    /**
     * Tx Power
     */
    private final int mTxPower;

    /**
     * Floor Number
     */
    private final int mFloorNumber;

    /**
     * Altitude
     */
    private final int mAltitude;

    /**
     * Uncertainty
     */
    private final int mUncertainty;

    /**
     * Constructor for Indoor Positioning
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public IndoorPositioning(@NonNull byte[] data
            , int offset
            , int length) {
        super(length);
        int index = offset + 2;
        if (length > 1) {
            mIndoorPositioningConfiguration = (data[index++] & 0xff);
        } else {
            mIndoorPositioningConfiguration = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(mIndoorPositioningConfiguration)) {
            if (IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(mIndoorPositioningConfiguration)) {
                mGlobalCoorinatesLatitude = BLEUtils.createSInt32(data, index);
                index += 4;
                mGlobalCoorinatesLongitude = BLEUtils.createSInt32(data, index);
                index += 4;
                mLocalCoordinatesNorth = 0;
                mLocalCoordinatesEast = 0;
            } else {
                mGlobalCoorinatesLatitude = 0;
                mGlobalCoorinatesLongitude = 0;
                mLocalCoordinatesNorth = BLEUtils.createSInt16(data, index);
                index += 2;
                mLocalCoordinatesEast = BLEUtils.createSInt16(data, index);
                index += 2;
            }
        } else {
            mGlobalCoorinatesLatitude = 0;
            mGlobalCoorinatesLongitude = 0;
            mLocalCoordinatesNorth = 0;
            mLocalCoordinatesEast = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(mIndoorPositioningConfiguration)) {
            mTxPower = BLEUtils.createSInt8(data, index++);
        } else {
            mTxPower = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(mIndoorPositioningConfiguration)) {
            mFloorNumber = BLEUtils.createUInt8(data, index++);
        } else {
            mFloorNumber = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(mIndoorPositioningConfiguration)) {
            mAltitude = BLEUtils.createUInt16(data, index);
            index += 2;
        } else {
            mAltitude = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(mIndoorPositioningConfiguration)) {
            mUncertainty = BLEUtils.createUInt8(data, index);
        } else {
            mUncertainty = 0;
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IndoorPositioning(@NonNull Parcel in) {
        super(in.readInt());

        mIndoorPositioningConfiguration = in.readInt();
        mGlobalCoorinatesLatitude = in.readInt();
        mGlobalCoorinatesLongitude = in.readInt();
        mLocalCoordinatesNorth = in.readInt();
        mLocalCoordinatesEast = in.readInt();
        mTxPower = in.readInt();
        mFloorNumber = in.readInt();
        mAltitude = in.readInt();
        mUncertainty = in.readInt();
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
        dest.writeInt(mIndoorPositioningConfiguration);
        dest.writeInt(mGlobalCoorinatesLatitude);
        dest.writeInt(mGlobalCoorinatesLongitude);
        dest.writeInt(mLocalCoordinatesNorth);
        dest.writeInt(mLocalCoordinatesEast);
        dest.writeInt(mTxPower);
        dest.writeInt(mFloorNumber);
        dest.writeInt(mAltitude);
        dest.writeInt(mUncertainty);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_INDOOR_POSITIONING;
    }

    /**
     * @return Indoor Positioning Configuration
     */
    public int getIndoorPositioningConfiguration() {
        return mIndoorPositioningConfiguration;
    }

    /**
     * @return Global Coordinates (Latitude)
     */
    public int getGlobalCoorinatesLatitude() {
        return mGlobalCoorinatesLatitude;
    }

    /**
     * @return Global Coordinates (Longitude)
     */
    public int getGlobalCoorinatesLongitude() {
        return mGlobalCoorinatesLongitude;
    }

    /**
     * @return Local Coordinates (North)
     */
    public int getLocalCoordinatesNorth() {
        return mLocalCoordinatesNorth;
    }

    /**
     * @return Local Coordinates (East)
     */
    public int getLocalCoordinatesEast() {
        return mLocalCoordinatesEast;
    }

    /**
     * @return Tx Power
     */
    public int getTxPower() {
        return mTxPower;
    }

    /**
     * @return Floor Number
     */
    public int getFloorNumber() {
        return mFloorNumber;
    }

    /**
     * @return Altitude
     */
    public int getAltitude() {
        return mAltitude;
    }

    /**
     * @return Uncertainty
     */
    public int getUncertainty() {
        return mUncertainty;
    }

}
