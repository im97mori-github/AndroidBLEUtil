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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HIP_CIRCUMFERENCE_CHARACTERISTIC;

/**
 * Hip Circumference (Characteristics UUID: 0x2A8F)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HipCircumference implements ByteArrayInterface, Parcelable {

    /**
     * Hip Circumference Unit 0.01 meters
     */
    public static final double HIP_CIRCUMFERENCE_RESOLUTION = 0.01d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HipCircumference> CREATOR = new ByteArrayCreater<HipCircumference>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HipCircumference createFromParcel(@NonNull Parcel in) {
            return new HipCircumference(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HipCircumference[] newArray(int size) {
            return new HipCircumference[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HipCircumference createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HipCircumference(bluetoothGattCharacteristic);
        }

    };

    /**
     * Hip Circumference
     */
    private final int mHipCircumference;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A8F
     */
    public HipCircumference(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mHipCircumference = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HipCircumference(@NonNull Parcel in) {
        mHipCircumference = in.readInt();
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
        dest.writeInt(mHipCircumference);
    }

    /**
     * @return Hip Circumference
     */
    public int getHipCircumference() {
        return mHipCircumference;
    }

    /**
     * @return Hip Circumference(meters)
     */
    public double getHipCircumferenceMeters() {
        return HIP_CIRCUMFERENCE_RESOLUTION * mHipCircumference;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mHipCircumference);
        return data;
    }

}
