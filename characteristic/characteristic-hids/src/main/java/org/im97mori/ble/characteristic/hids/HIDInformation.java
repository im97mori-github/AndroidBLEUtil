package org.im97mori.ble.characteristic.hids;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HID_INFORMATION_CHARACTERISTIC;

/**
 * HID Information (Characteristics UUID: 0x2A4A)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HIDInformation implements ByteArrayInterface, Parcelable {

    /**
     * @see #FLAGS_REMOTE_WAKE_FALSE
     * @see #FLAGS_REMOTE_WAKE_TRUE
     */
    public static final int FLAGS_REMOTE_WAKE_MASK = 0b00000001;

    /**
     * 0: RemoteWake False
     */
    public static final int FLAGS_REMOTE_WAKE_FALSE = 0b00000000;

    /**
     * 1: RemoteWake True
     */
    public static final int FLAGS_REMOTE_WAKE_TRUE = 0b00000001;

    /**
     * @see #FLAGS_NORMALLY_CONNECTABLE_FALSE
     * @see #FLAGS_NORMALLY_CONNECTABLE_TRUE
     */
    public static final int FLAGS_NORMALLY_CONNECTABLE_MASK = 0b00000010;

    /**
     * 0: NormallyConnectable False
     */
    public static final int FLAGS_NORMALLY_CONNECTABLE_FALSE = 0b00000000;

    /**
     * 1: NormallyConnectable True
     */
    public static final int FLAGS_NORMALLY_CONNECTABLE_TRUE = 0b00000010;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HIDInformation> CREATOR = new ByteArrayCreater<HIDInformation>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HIDInformation createFromParcel(@NonNull Parcel in) {
            return new HIDInformation(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HIDInformation[] newArray(int size) {
            return new HIDInformation[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HIDInformation createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HID_INFORMATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HIDInformation(bluetoothGattCharacteristic);
        }

    };

    /**
     * bcdHID
     */
    private final int mBcdhid;

    /**
     * bCountryCode
     */
    private final int mBcountrycode;

    /**
     * Flags
     */
    private final int mFlags;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4A
     */
    public HIDInformation(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mBcdhid = BLEUtils.createUInt16(values, 0);
        mBcountrycode = values[2];
        mFlags = values[3];
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HIDInformation(@NonNull Parcel in) {
        mBcdhid = in.readInt();
        mBcountrycode = in.readInt();
        mFlags = in.readInt();
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
        dest.writeInt(mBcdhid);
        dest.writeInt(mBcountrycode);
        dest.writeInt(mFlags);
    }

    /**
     * @return bcdHID
     */
    public int getBcdhid() {
        return mBcdhid;
    }

    /**
     * @return bCountryCode
     */
    public int getBcountrycode() {
        return mBcountrycode;
    }

    /**
     * @return Flags
     */
    public int getFlags() {
        return mFlags;
    }

    /**
     * @return {@code true}:RemoteWake False, {@code false}:RemoteWake True
     */
    public boolean isFlagsRemoteWakeFalse() {
        return isFlagsMatched(FLAGS_REMOTE_WAKE_MASK, FLAGS_REMOTE_WAKE_FALSE);
    }

    /**
     * @return {@code true}:RemoteWake True, {@code false}:RemoteWake False
     */
    public boolean isFlagsRemoteWakeTrue() {
        return isFlagsMatched(FLAGS_REMOTE_WAKE_MASK, FLAGS_REMOTE_WAKE_TRUE);
    }

    /**
     * @return {@code true}:NormallyConnectable False, {@code false}:NormallyConnectable True
     */
    public boolean isFlagsNormallyConnectableFalse() {
        return isFlagsMatched(FLAGS_NORMALLY_CONNECTABLE_MASK, FLAGS_NORMALLY_CONNECTABLE_FALSE);
    }

    /**
     * @return {@code true}:NormallyConnectable True, {@code false}:NormallyConnectable False
     */
    public boolean isFlagsNormallyConnectableTrue() {
        return isFlagsMatched(FLAGS_NORMALLY_CONNECTABLE_MASK, FLAGS_NORMALLY_CONNECTABLE_TRUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[4];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mBcdhid);
        byteBuffer.put((byte) mBcountrycode);
        byteBuffer.put((byte) mFlags);
        return data;
    }

    /**
     * check Flags
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #FLAGS_REMOTE_WAKE_FALSE}
     *               , {@link #FLAGS_REMOTE_WAKE_TRUE}
     *               , {@link #FLAGS_NORMALLY_CONNECTABLE_FALSE}
     *               , {@link #FLAGS_NORMALLY_CONNECTABLE_TRUE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFlagsMatched(int mask, int expect) {
        return (mask & mFlags) == expect;
    }

}
