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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WEIGHT_CHARACTERISTIC;

/**
 * Weight (Characteristics UUID: 0x2A98)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Weight implements ByteArrayInterface, Parcelable {

    /**
     * Weight Unit 0.005 (kilogram)
     */
    public static final double WEIGHT_RESOLUTION = 0.005;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Weight> CREATOR = new ByteArrayCreater<Weight>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Weight createFromParcel(@NonNull Parcel in) {
            return new Weight(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Weight[] newArray(int size) {
            return new Weight[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Weight createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WEIGHT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Weight(bluetoothGattCharacteristic);
        }

    };

    /**
     * Weight
     */
    private final int mWeight;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A98
     */
    public Weight(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mWeight = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Weight(@NonNull Parcel in) {
        mWeight = in.readInt();
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
        dest.writeInt(mWeight);
    }

    /**
     * @return Weight
     */
    public int getWeight() {
        return mWeight;
    }

    /**
     * @return Weight(kg)
     */
    public double getWeightKg() {
        return WEIGHT_RESOLUTION * mWeight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mWeight);
        return data;
    }

}
