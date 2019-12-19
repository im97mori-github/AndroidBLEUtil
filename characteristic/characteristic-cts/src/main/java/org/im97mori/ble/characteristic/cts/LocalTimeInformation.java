package org.im97mori.ble.characteristic.cts;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LOCAL_TIME_INFORMATION_CHARACTERISTIC;

/**
 * Local Time Information (Characteristics UUID: 0x2A0F)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class LocalTimeInformation implements ByteArrayInterface, Parcelable {

    /**
     * 255(0xff): time zone offset is not known
     */
    public static final int TIME_ZONE_IS_NOT_KNOWN = -128;

    /**
     * TimeZone unit(min)
     */
    public static final int TIME_ZONE_UNIT = 15;

    /**
     * 0(0min): Standard Time
     */
    public static final int DST_OFFSET_STANDARD_TIME = 0;

    /**
     * 2(30min): Half An Hour Daylight Time (+0.5h)
     */
    public static final int DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME = 2;

    /**
     * 4(60min): Daylight Time (+1h)
     */
    public static final int DST_OFFSET_DAYLIGHT_TIME = 4;

    /**
     * 8(120min): Double Daylight Time (+2h)
     */
    public static final int DST_OFFSET_DOUBLE_DAYLIGHT_TIME = 8;

    /**
     * 255(0xff): DST is not known
     */
    public static final int DST_OFFSET_IS_NOT_KNOWN = 255;

    /**
     * DST unit(min)
     */
    public static final int DST_OFFSET_UNIT = 15;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LocalTimeInformation> CREATOR = new ByteArrayCreater<LocalTimeInformation>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocalTimeInformation createFromParcel(@NonNull Parcel in) {
            return new LocalTimeInformation(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocalTimeInformation[] newArray(int size) {
            return new LocalTimeInformation[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LocalTimeInformation createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LocalTimeInformation(bluetoothGattCharacteristic);
        }

    };

    /**
     * Time Zone
     */
    private final int mTimeZone;

    /**
     * DST Offset
     */
    private final int mDstOffset;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A0F
     */
    public LocalTimeInformation(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mTimeZone = BLEUtils.createSInt8(values, 0);
        mDstOffset = (values[1] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LocalTimeInformation(@NonNull Parcel in) {
        mTimeZone = in.readInt();
        mDstOffset = in.readInt();
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
        dest.writeInt(mTimeZone);
        dest.writeInt(mDstOffset);
    }

    /**
     * @return Time Zone
     */
    public int getTimeZone() {
        return mTimeZone;
    }

    /**
     * @return {@code true}:time zone offset is not known, {@code false}:has time zone offset information
     * @see #TIME_ZONE_IS_NOT_KNOWN
     */
    public boolean isTimeZoneNotKnown() {
        return TIME_ZONE_IS_NOT_KNOWN == mTimeZone;
    }

    /**
     * @return Time Zone offset(mins)
     */
    public int getTimeZoneOffsetMin() {
        return TIME_ZONE_UNIT * mTimeZone;
    }

    /**
     * @return Time Zone offset(millis)
     */
    public long getTimeZoneOffsetMillis() {
        return getTimeZoneOffsetMin() * 1000L;
    }

    /**
     * @return DST Offset
     */
    public int getDstOffset() {
        return mDstOffset;
    }

    /**
     * @return {@code true}:Standard Time, {@code false}:not Standard Time
     * @see #DST_OFFSET_STANDARD_TIME
     */
    public boolean isDstOffsetStandardTime() {
        return DST_OFFSET_STANDARD_TIME == mDstOffset;
    }

    /**
     * @return {@code true}:Half An Hour Daylight Time, {@code false}:not Half An Hour Daylight Time
     * @see #DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME
     */
    public boolean isDstOffsetHalfAnHourDaylightTime() {
        return DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME == mDstOffset;
    }

    /**
     * @return {@code true}:Daylight Time, {@code false}:not Daylight Time
     * @see #DST_OFFSET_DAYLIGHT_TIME
     */
    public boolean isDstOffsetDaylightTime() {
        return DST_OFFSET_DAYLIGHT_TIME == mDstOffset;
    }

    /**
     * @return {@code true}:Double Daylight Time, {@code false}:not Double Daylight Time
     * @see #DST_OFFSET_DOUBLE_DAYLIGHT_TIME
     */
    public boolean isDstOffsetDoubleDaylightTime() {
        return DST_OFFSET_DOUBLE_DAYLIGHT_TIME == mDstOffset;
    }

    /**
     * @return {@code true}:DST is not known, {@code false}:has DST information
     * @see #DST_OFFSET_IS_NOT_KNOWN
     */
    public boolean isDstNotKnown() {
        return (DST_OFFSET_IS_NOT_KNOWN & mDstOffset) == DST_OFFSET_IS_NOT_KNOWN;
    }

    /**
     * @return DST Offset(mins)
     */
    public int getDstOffsetMin() {
        return DST_OFFSET_UNIT * mDstOffset;
    }

    /**
     * @return DST Offset(millis)
     */
    public long getDstOffsetMillis() {
        return getDstOffsetMin() * 1000L;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mTimeZone);
        byteBuffer.put((byte) mDstOffset);
        return data;
    }

}
