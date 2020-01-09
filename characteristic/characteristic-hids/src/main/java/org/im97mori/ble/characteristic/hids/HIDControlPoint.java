package org.im97mori.ble.characteristic.hids;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HID_CONTROL_POINT_CHARACTERISTIC;

/**
 * HID Control Point (Characteristics UUID: 0x2A4C)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HIDControlPoint implements ByteArrayInterface, Parcelable {

    /**
     * 0: Suspend
     */
    public static final int HID_CONTROL_POINT_COMMAND_SUSPEND = 0;

    /**
     * 1: Exit Suspend
     */
    public static final int HID_CONTROL_POINT_COMMAND_EXIT_SUSPEND = 1;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HIDControlPoint> CREATOR = new ByteArrayCreater<HIDControlPoint>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HIDControlPoint createFromParcel(@NonNull Parcel in) {
            return new HIDControlPoint(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HIDControlPoint[] newArray(int size) {
            return new HIDControlPoint[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HIDControlPoint createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HID_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HIDControlPoint(bluetoothGattCharacteristic);
        }

    };

    /**
     * HID Control Point Command
     */
    private final int mHidControlPointCommand;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4C
     */
    public HIDControlPoint(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mHidControlPointCommand = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HIDControlPoint(@NonNull Parcel in) {
        mHidControlPointCommand = in.readInt();
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
        dest.writeInt(mHidControlPointCommand);
    }

    /**
     * @return HID Control Point Command
     */
    public int getHidControlPointCommand() {
        return mHidControlPointCommand;
    }

    /**
     * @return {@code true}:Suspend, {@code false}:not Suspend
     */
    public boolean isHidControlPointCommandSuspend() {
        return HID_CONTROL_POINT_COMMAND_SUSPEND == mHidControlPointCommand;
    }

    /**
     * @return {@code true}:Exit Suspend, {@code false}:not Exit Suspend
     */
    public boolean isHidControlPointCommandExitSuspend() {
        return HID_CONTROL_POINT_COMMAND_EXIT_SUSPEND == mHidControlPointCommand;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mHidControlPointCommand);
        return data;
    }

}
