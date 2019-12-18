package org.im97mori.characteristic.cts;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.REFERENCE_TIME_INFORMATION_CHARACTERISTIC;

/**
 * Reference Time Information (Characteristics UUID: 0x2A14)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ReferenceTimeInformation implements ByteArrayInterface, Parcelable {

    /**
     * 0: Unknown
     */
    public static final int TIME_SOURCE_UNKNOWN = 0;

    /**
     * 1: Network Time Protocol
     */
    public static final int TIME_SOURCE_NETWORK_TIME_PROTOCOL = 1;

    /**
     * 2: GPS
     */
    public static final int TIME_SOURCE_GPS = 2;

    /**
     * 3: Radio Time Signal
     */
    public static final int TIME_SOURCE_RADIO_TIME_SIGNAL = 3;

    /**
     * 4: Manual
     */
    public static final int TIME_SOURCE_MANUAL = 4;

    /**
     * 5: Atomic Clock
     */
    public static final int TIME_SOURCE_ATOMIC_CLOCK = 5;

    /**
     * 6: Cellular Network
     */
    public static final int TIME_SOURCE_CELLULAR_NETWORK = 6;

    /**
     * 254: Accuracy out of range
     */
    public static final int ACCURACY_OUT_OF_RANGE = 254;

    /**
     * 255(0xff): Accuracy Unknown
     */
    public static final int ACCURACY_UNKNOWN = 255;

    /**
     * Accuracy unit 125ms(Fractions256 does supported in CurrentTime)
     */
    public static final int ACCURACY_UNIT_FRACTIONS256_SUPPORTED_MILLIS = 125;

    /**
     * Accuracy unit 100ms(Fractions256 does not supported in CurrentTime)
     */
    public static final int ACCURACY_UNIT_FRACTIONS256_NOT_SUPPORTED_MILLIS = 1000;

    /**
     * 255: 255 or more days
     */
    public static final int DAYS_SINCE_UPDATE_255_OR_MORE_DAYS = 255;

    /**
     * 255: 255 or more hours
     */
    public static final int DAYS_SINCE_UPDATE_255_OR_MORE_HOURS = 255;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ReferenceTimeInformation> CREATOR = new ByteArrayCreater<ReferenceTimeInformation>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReferenceTimeInformation createFromParcel(@NonNull Parcel in) {
            return new ReferenceTimeInformation(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReferenceTimeInformation[] newArray(int size) {
            return new ReferenceTimeInformation[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ReferenceTimeInformation createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ReferenceTimeInformation(bluetoothGattCharacteristic);
        }

    };

    /**
     * Time Source
     */
    private final int mTimeSource;

    /**
     * Accuracy
     */
    private final int mAccuracy;

    /**
     * Days Since Update
     */
    private final int mDaysSinceUpdate;

    /**
     * Hours Since Update
     */
    private final int mHoursSinceUpdate;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A14
     */
    public ReferenceTimeInformation(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mTimeSource = values[0];
        mAccuracy = (values[1] & 0xff);
        mDaysSinceUpdate = (values[2] & 0xff);
        mHoursSinceUpdate = (values[3] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ReferenceTimeInformation(@NonNull Parcel in) {
        mTimeSource = in.readInt();
        mAccuracy = in.readInt();
        mDaysSinceUpdate = in.readInt();
        mHoursSinceUpdate = in.readInt();
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
        dest.writeInt(mTimeSource);
        dest.writeInt(mAccuracy);
        dest.writeInt(mDaysSinceUpdate);
        dest.writeInt(mHoursSinceUpdate);
    }

    /**
     * @return Time Source
     */
    public int getTimeSource() {
        return mTimeSource;
    }

    /**
     * @return {@code true}:Time Source is Unknown, {@code false}:has Time Source information
     * @see #TIME_SOURCE_UNKNOWN
     */
    public boolean isTimeSourceNotKnown() {
        return TIME_SOURCE_UNKNOWN == mTimeSource;
    }

    /**
     * @return {@code true}:Time Source is Network Time Protocol, {@code false}:not Network Time Protocol
     * @see #TIME_SOURCE_NETWORK_TIME_PROTOCOL
     */
    public boolean isTimeSourceNetworkTimeProtocol() {
        return TIME_SOURCE_NETWORK_TIME_PROTOCOL == mTimeSource;
    }

    /**
     * @return {@code true}:Time Source is GPS, {@code false}:not GPS
     * @see #TIME_SOURCE_GPS
     */
    public boolean isTimeSourceGps() {
        return TIME_SOURCE_GPS == mTimeSource;
    }

    /**
     * @return {@code true}:Time Source is Radio Time Signal, {@code false}:not Radio Time Signal
     * @see #TIME_SOURCE_RADIO_TIME_SIGNAL
     */
    public boolean isTimeSourceRadioTimeSignal() {
        return TIME_SOURCE_RADIO_TIME_SIGNAL == mTimeSource;
    }

    /**
     * @return {@code true}:Time Source is Manual, {@code false}:not Manual
     * @see #TIME_SOURCE_MANUAL
     */
    public boolean isTimeSourceManual() {
        return TIME_SOURCE_MANUAL == mTimeSource;
    }

    /**
     * @return {@code true}:Time Source is Atomic Clock, {@code false}:not Atomic Clock
     * @see #TIME_SOURCE_ATOMIC_CLOCK
     */
    public boolean isTimeSourceAtomicClock() {
        return TIME_SOURCE_ATOMIC_CLOCK == mTimeSource;
    }

    /**
     * @return {@code true}:Time Source is Cellular Network, {@code false}:not Cellular Network
     * @see #TIME_SOURCE_CELLULAR_NETWORK
     */
    public boolean isTimeSourceCellularNetwork() {
        return TIME_SOURCE_CELLULAR_NETWORK == mTimeSource;
    }

    /**
     * @return Accuracy
     */
    public int getAccuracy() {
        return mAccuracy;
    }

    /**
     * @return {@code true}:Accuracy out of range, {@code false}:not Accuracy out of range
     * @see #ACCURACY_OUT_OF_RANGE
     */
    public boolean isAccuracyOutOfRange() {
        return ACCURACY_OUT_OF_RANGE == mAccuracy;
    }

    /**
     * @return {@code true}:Accuracy Unknown, {@code false}:has Accuracy information
     * @see #ACCURACY_UNKNOWN
     */
    public boolean isAccuracyUnknown() {
        return (ACCURACY_UNKNOWN & mAccuracy) == ACCURACY_UNKNOWN;
    }

    /**
     * @return Accuracy(millis) with fractions256 supported
     * @see #ACCURACY_UNIT_FRACTIONS256_SUPPORTED_MILLIS
     * @see CurrentTime#isFractions256Supported()
     */
    public int getAccuracyFraction256SupportedMillis() {
        return ACCURACY_UNIT_FRACTIONS256_SUPPORTED_MILLIS * mAccuracy;
    }

    /**
     * @return Accuracy(millis) with fractions256 not supported
     * @see #ACCURACY_UNIT_FRACTIONS256_NOT_SUPPORTED_MILLIS
     * @see CurrentTime#isFractions256Supported()
     */
    public long getAccuracyFraction256NotSupportedMillis() {
        return ACCURACY_UNIT_FRACTIONS256_NOT_SUPPORTED_MILLIS * mAccuracy;
    }

    /**
     * @return Days Since Update
     */
    public int getDaysSinceUpdate() {
        return mDaysSinceUpdate;
    }

    /**
     * @return {@code true}:last update was more than 254 days and 23 hours ago, {@code false}: last update within 255 days
     */
    public boolean isDaysSinceUpdate255OrMoreDays() {
        return (DAYS_SINCE_UPDATE_255_OR_MORE_DAYS & mDaysSinceUpdate) == DAYS_SINCE_UPDATE_255_OR_MORE_DAYS;
    }

    /**
     * @return Hours Since Update
     */
    public int getHoursSinceUpdate() {
        return mHoursSinceUpdate;
    }

    /**
     * @return {@code true}:last update was more than 254 days and 23 hours ago, {@code false}: last update within 255 days
     */
    public boolean isHoursSinceUpdate255OrMoreHours() {
        return (DAYS_SINCE_UPDATE_255_OR_MORE_HOURS & mHoursSinceUpdate) == DAYS_SINCE_UPDATE_255_OR_MORE_HOURS;
    }

    /**
     * @return time since update(millis)
     */
    public long getTimeFromUpdateMillis() {
        return DateUtils.DAY_IN_MILLIS * mDaysSinceUpdate + DateUtils.HOUR_IN_MILLIS * mHoursSinceUpdate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[4];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mTimeSource);
        byteBuffer.put((byte) mAccuracy);
        byteBuffer.put((byte) mDaysSinceUpdate);
        byteBuffer.put((byte) mHoursSinceUpdate);
        return data;
    }

}
