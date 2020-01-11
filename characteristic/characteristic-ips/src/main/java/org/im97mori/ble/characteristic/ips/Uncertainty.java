package org.im97mori.ble.characteristic.ips;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.UNCERTAINTY_CHARACTERISTIC;

/**
 * Uncertainty (Characteristics UUID: 0x2AB4)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Uncertainty implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Uncertainty> CREATOR = new ByteArrayCreater<Uncertainty>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Uncertainty createFromParcel(@NonNull Parcel in) {
            return new Uncertainty(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Uncertainty[] newArray(int size) {
            return new Uncertainty[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Uncertainty createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UNCERTAINTY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Uncertainty(bluetoothGattCharacteristic);
        }

    };

    /**
     * Uncertainty
     */
    private final int mUncertainty;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB4
     */
    public Uncertainty(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mUncertainty = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Uncertainty(@NonNull Parcel in) {
        mUncertainty = in.readInt();
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
        dest.writeInt(mUncertainty);
    }

    /**
     * @return Uncertainty
     */
    public int getUncertainty() {
        return mUncertainty;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mUncertainty);
        return data;
    }

}
