package org.im97mori.characteristiccharacteristic_aios;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DIGITAL_CHARACTERISTIC;

/**
 * Digital (Characteristics UUID: 0x2A56)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Digital implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Digital> CREATOR = new ByteArrayCreater<Digital>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Digital createFromParcel(@NonNull Parcel in) {
            return new Digital(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Digital[] newArray(int size) {
            return new Digital[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Digital createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DIGITAL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Digital(bluetoothGattCharacteristic);
        }

    };

    /**
     * Digital
     */
    private final byte[] mDigital;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A56
     */
    public Digital(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mDigital = bluetoothGattCharacteristic.getValue();
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Digital(@NonNull Parcel in) {
        mDigital = in.createByteArray();
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
        dest.writeByteArray(mDigital);
    }

    /**
     * @return Digital
     */
    @NonNull
    public byte[] getDigital() {
        return mDigital;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[mDigital.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mDigital);
        return data;
    }

}
