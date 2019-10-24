package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;
import android.util.Pair;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_FLAGS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.FlagsDataType;
import static org.im97mori.ble.ad.AdvertisingDataConstants.FlagsDataType.FLAG_BR_EDR_NOT_SUPPORTED;
import static org.im97mori.ble.ad.AdvertisingDataConstants.FlagsDataType.FLAG_LE_GENERAL_DISCOVERABLE_MODE;
import static org.im97mori.ble.ad.AdvertisingDataConstants.FlagsDataType.FLAG_LE_LIMITED_DISCOVERABLE_MODE;
import static org.im97mori.ble.ad.AdvertisingDataConstants.FlagsDataType.FLAG_SIMULTANEOUS_LE_AND_BR_EDR_TO_SAME_DEVICE_CAPABLE_CONTROLLER;
import static org.im97mori.ble.ad.AdvertisingDataConstants.FlagsDataType.FLAG_SIMULTANEOUS_LE_AND_BR_EDR_TO_SAME_DEVICE_CAPABLE_HOST;

/**
 * <p>
 * Flags
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Flags extends AbstractAdvertisingData {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Flags> CREATOR = new ByteArrayCreater<Flags>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Flags createFromParcel(@NonNull Parcel in) {
            return new Flags(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Flags[] newArray(int size) {
            return new Flags[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public Flags createFromByteArray(@NonNull byte[] values) {
            return new Flags(values, 0, values.length - 1);
        }

    };

    /**
     * Flags list
     */
    private final List<Integer> mFlagsList;

    /**
     * Constructor for Flags
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public Flags(@NonNull byte[] data, int offset, int length) {
        super(length);

        List<Integer> flagsList = new ArrayList<>();
        for (int i = offset + 2; i < offset + length + 1; i++) {
            flagsList.add(data[i] & 0xff);
        }
        mFlagsList = Collections.synchronizedList(Collections.unmodifiableList(flagsList));
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Flags(@NonNull Parcel in) {
        super(in.readInt());

        List<Integer> list = new ArrayList<>();
        in.readList(list, this.getClass().getClassLoader());
        mFlagsList = Collections.synchronizedList(Collections.unmodifiableList(list));
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
        dest.writeList(mFlagsList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_FLAGS;
    }

    /**
     * @return Flags list
     */
    @NonNull
    public List<Integer> getFlagsList() {
        return mFlagsList;
    }

    /**
     * check LE Limited Discoverable Mode
     *
     * @return {@code true}:LE Limited Discoverable Mode bit is 1, {@code false}:bit is 0;
     */
    public boolean isLeLimitedDiscoverableMode() {
        return check(FLAG_LE_LIMITED_DISCOVERABLE_MODE);
    }

    /**
     * check LE General Discoverable Mode
     *
     * @return {@code true}:LE General Discoverable Mode bit is 1, {@code false}:bit is 0;
     */
    public boolean isLeGeneralDiscoverableMode() {
        return check(FLAG_LE_GENERAL_DISCOVERABLE_MODE);
    }

    /**
     * check LE BR/EDR Not Supported
     *
     * @return {@code true}:BR/EDR Not Supported bit is 1, {@code false}:bit is 0;
     */
    public boolean isBrEdrNotSupported() {
        return check(FLAG_BR_EDR_NOT_SUPPORTED);
    }

    /**
     * check Simultaneous LE and BR/EDR to Same Device Capable (Controller)
     *
     * @return {@code true}:Simultaneous LE and BR/EDR to Same Device Capable (Controller) bit is 1, {@code false}:bit is 0;
     */
    public boolean isSimultaneousController() {
        return check(FLAG_SIMULTANEOUS_LE_AND_BR_EDR_TO_SAME_DEVICE_CAPABLE_CONTROLLER);
    }

    /**
     * check Simultaneous LE and BR/EDR to Same Device Capable (Host)
     *
     * @return {@code true}:Simultaneous LE and BR/EDR to Same Device Capable (Host) bit is 1, {@code false}:bit is 0;
     */
    public boolean isSimultaneousHost() {
        return check(FLAG_SIMULTANEOUS_LE_AND_BR_EDR_TO_SAME_DEVICE_CAPABLE_HOST);
    }

    /**
     * check flag
     *
     * @param target one of {@link FlagsDataType}
     * @return {@code true}:target bit is 1, {@code false}:target bit is 0
     */
    private boolean check(@NonNull Pair<Integer, Integer> target) {
        boolean result;
        int index = target.first;
        if (mFlagsList.size() > index) {
            result = (mFlagsList.get(index) & target.second) != 0;
        } else {
            result = false;
        }
        return result;
    }
}
