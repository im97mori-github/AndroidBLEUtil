package org.im97mori.ble.characteristic.hids;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PROTOCOL_MODE_CHARACTERISTIC;

/**
 * Protocol Mode (Characteristics UUID: 0x2A4E)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ProtocolMode implements ByteArrayInterface, Parcelable {

    /**
     * 0: Boot Protocol Mode
     */
    public static final int PROTOCOL_MODE_VALUE_BOOT_PROTOCOL_MODE = 0;

    /**
     * 1: Report Protocol Mode
     */
    public static final int PROTOCOL_MODE_VALUE_REPORT_PROTOCOL_MODE = 1;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ProtocolMode> CREATOR = new ByteArrayCreater<ProtocolMode>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ProtocolMode createFromParcel(@NonNull Parcel in) {
            return new ProtocolMode(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ProtocolMode[] newArray(int size) {
            return new ProtocolMode[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ProtocolMode createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PROTOCOL_MODE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ProtocolMode(bluetoothGattCharacteristic);
        }

    };

    /**
     * Protocol Mode Value
     */
    private final int mProtocolModeValue;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4E
     */
    public ProtocolMode(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mProtocolModeValue = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ProtocolMode(@NonNull Parcel in) {
        mProtocolModeValue = in.readInt();
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
        dest.writeInt(mProtocolModeValue);
    }

    /**
     * @return Protocol Mode Value
     */
    public int getProtocolModeValue() {
        return mProtocolModeValue;
    }

    /**
     * @return {@code true}:Boot Protocol Mode, {@code false}:not Boot Protocol Mode
     */
    public boolean isProtocolModeValueBootProtocolMode() {
        return PROTOCOL_MODE_VALUE_BOOT_PROTOCOL_MODE == mProtocolModeValue;
    }

    /**
     * @return {@code true}:Report Protocol Mode, {@code false}:not Report Protocol Mode
     */
    public boolean isProtocolModeValueReportProtocolMode() {
        return PROTOCOL_MODE_VALUE_REPORT_PROTOCOL_MODE == mProtocolModeValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mProtocolModeValue);
        return data;
    }

}
