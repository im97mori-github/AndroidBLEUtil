package org.im97mori.ble.characteristic.ndcs;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.im97mori.ble.BLEUtils;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TIME_WITH_DST_CHARACTERISTIC;

/**
 * Time with DST (Characteristics UUID: 0x2A11)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TimeWithDst implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TimeWithDst> CREATOR = new ByteArrayCreater<TimeWithDst>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeWithDst createFromParcel(@NonNull Parcel in) {
            return new TimeWithDst(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeWithDst[] newArray(int size) {
            return new TimeWithDst[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeWithDst createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_WITH_DST_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeWithDst(bluetoothGattCharacteristic);
        }

    };

    /**
     * Year
     */
    private final int mYear;

    /**
     * Month
     */
    private final int mMonth;

    /**
     * Day
     */
    private final int mDay;

    /**
     * Hours
     */
    private final int mHours;

    /**
     * Minutes
     */
    private final int mMinutes;

    /**
     * Seconds
     */
    private final int mSeconds;

    /**
     * DST Offset
     */
    private final int mDstOffset;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A11
     */
    public TimeWithDst(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mYear = BLEUtils.createUInt16(values, 0);
        mMonth = (values[2] & 0xff);
        mDay = (values[3] & 0xff);
        mHours = (values[4] & 0xff);
        mMinutes = (values[5] & 0xff);
        mSeconds = (values[6] & 0xff);
        mDstOffset = (values[7] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeWithDst(@NonNull Parcel in) {
        mYear = in.readInt();
        mMonth = in.readInt();
        mDay = in.readInt();
        mHours = in.readInt();
        mMinutes = in.readInt();
        mSeconds = in.readInt();
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
        dest.writeInt(mYear);
        dest.writeInt(mMonth);
        dest.writeInt(mDay);
        dest.writeInt(mHours);
        dest.writeInt(mMinutes);
        dest.writeInt(mSeconds);
        dest.writeInt(mDstOffset);
    }

    /**
     * @return Year
     */
    public int getYear() {
        return mYear;
    }

    /**
     * @return Month
     */
    public int getMonth() {
        return mMonth;
    }

    /**
     * @return Day
     */
    public int getDay() {
        return mDay;
    }

    /**
     * @return Hours
     */
    public int getHours() {
        return mHours;
    }

    /**
     * @return Minutes
     */
    public int getMinutes() {
        return mMinutes;
    }

    /**
     * @return Seconds
     */
    public int getSeconds() {
        return mSeconds;
    }

    /**
     * @return DST Offset
     */
    public int getDstOffset() {
        return mDstOffset;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[8];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mYear);
        byteBuffer.put((byte) mMonth);
        byteBuffer.put((byte) mDay);
        byteBuffer.put((byte) mHours);
        byteBuffer.put((byte) mMinutes);
        byteBuffer.put((byte) mSeconds);
        byteBuffer.put((byte) mDstOffset);
        return data;
    }

}
