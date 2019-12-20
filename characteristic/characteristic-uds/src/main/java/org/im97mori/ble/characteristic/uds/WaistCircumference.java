package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WAIST_CIRCUMFERENCE_CHARACTERISTIC;

/**
 * Waist Circumference (Characteristics UUID: 0x2A97)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class WaistCircumference implements ByteArrayInterface, Parcelable {

    /**
     * Waist Circumference Unit 0.01 meters
     */
    public static final double WAIST_CIRCUMFERENCE_RESOLUTION = 0.01;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<WaistCircumference> CREATOR = new ByteArrayCreater<WaistCircumference>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WaistCircumference createFromParcel(@NonNull Parcel in) {
            return new WaistCircumference(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WaistCircumference[] newArray(int size) {
            return new WaistCircumference[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public WaistCircumference createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new WaistCircumference(bluetoothGattCharacteristic);
        }

    };

    /**
     * Waist Circumference
     */
    private final int mWaistCircumference;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A97
     */
    public WaistCircumference(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mWaistCircumference = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private WaistCircumference(@NonNull Parcel in) {
        mWaistCircumference = in.readInt();
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
        dest.writeInt(mWaistCircumference);
    }

    /**
     * @return Waist Circumference
     */
    public int getWaistCircumference() {
        return mWaistCircumference;
    }

    /**
     * @return Waist Circumference(meters)
     */
    public double getWaistCircumferenceMeters() {
        return WAIST_CIRCUMFERENCE_RESOLUTION * mWaistCircumference;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mWaistCircumference);
        return data;
    }

}
