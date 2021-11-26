package org.im97mori.ble.characteristic.u2b49;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.STRIDE_LENGTH_CHARACTERISTIC;

/**
 * Stride Length (Characteristics UUID: 0x2B49)
 */
@SuppressWarnings({"WeakerAccess"})
public class StrideLengthAndroid extends StrideLength implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<StrideLengthAndroid> CREATOR = new ByteArrayCreater<StrideLengthAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StrideLengthAndroid createFromParcel(@NonNull Parcel in) {
            return new StrideLengthAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StrideLengthAndroid[] newArray(int size) {
            return new StrideLengthAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public StrideLengthAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STRIDE_LENGTH_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new StrideLengthAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B49
     */
    public StrideLengthAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param strideLength Stride Length
     */
    public StrideLengthAndroid(int strideLength) {
        super(strideLength);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private StrideLengthAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(in.createByteArray());
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
        dest.writeByteArray(getBytes());
    }

}
