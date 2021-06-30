package org.im97mori.ble.characteristic.u2ae8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.COEFFICIENT_CHARACTERISTIC;

/**
 * Coefficient (Characteristics UUID: 0x2AE8)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CoefficientAndroid extends Coefficient implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CoefficientAndroid> CREATOR = new ByteArrayCreater<CoefficientAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CoefficientAndroid createFromParcel(@NonNull Parcel in) {
            return new CoefficientAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CoefficientAndroid[] newArray(int size) {
            return new CoefficientAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CoefficientAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(COEFFICIENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CoefficientAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE8
     */
    public CoefficientAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CoefficientAndroid(@NonNull Parcel in) {
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
