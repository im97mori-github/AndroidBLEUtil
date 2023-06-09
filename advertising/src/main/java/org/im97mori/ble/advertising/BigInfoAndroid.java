package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreator;

/**
 * <p>
 * BIGInfo
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class BigInfoAndroid extends BigInfo implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BigInfoAndroid> CREATOR = new ByteArrayCreator<BigInfoAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BigInfoAndroid createFromParcel(@NonNull Parcel in) {
            return new BigInfoAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BigInfoAndroid[] newArray(int size) {
            return new BigInfoAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public BigInfoAndroid createFromByteArray(@NonNull byte[] values) {
            return new BigInfoAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #BigInfoAndroid(byte[], int, int)
     */
    public BigInfoAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for BIGInfo
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public BigInfoAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param bigOffset         BIG_Offset
     * @param bigOffsetUnits    BIG_Offset_Units
     * @param isoInterval       ISO_Interval
     * @param numBis            Num_BIS
     * @param nse               NSE
     * @param bn                Bn
     * @param subInterval       Sub_Interval
     * @param pto               PTO
     * @param bisSpacing        BIS_Spacing
     * @param irc               IRC
     * @param maxPdu            Max_PDU
     * @param rfu               RFU
     * @param seedAccessAddress SeedAccessAddress
     * @param sduInterval       SDU_Interval
     * @param maxSdu            Max_SDU
     * @param baseCrcInit       BaseCRCInit
     * @param chm               ChM
     * @param phy               PHY
     * @param bisPayloadCount   bisPayloadCount
     * @param framing           Framing
     * @param giv               GIV
     * @param gskd              GSKD
     */
    public BigInfoAndroid(int bigOffset
            , int bigOffsetUnits
            , int isoInterval
            , int numBis
            , int nse
            , int bn
            , int subInterval
            , int pto
            , int bisSpacing
            , int irc
            , int maxPdu
            , int rfu
            , long seedAccessAddress
            , int sduInterval
            , int maxSdu
            , int baseCrcInit
            , long chm
            , int phy
            , long bisPayloadCount
            , int framing
            , @Nullable byte[] giv
            , @Nullable byte[] gskd) {
        super(bigOffset
                , bigOffsetUnits
                , isoInterval
                , numBis
                , nse
                , bn
                , subInterval
                , pto
                , bisSpacing
                , irc
                , maxPdu
                , rfu
                , seedAccessAddress
                , sduInterval
                , maxSdu
                , baseCrcInit
                , chm
                , phy
                , bisPayloadCount
                , framing
                , giv
                , gskd);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BigInfoAndroid(@NonNull Parcel in) {
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
