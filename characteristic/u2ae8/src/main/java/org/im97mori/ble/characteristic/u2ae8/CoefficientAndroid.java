package org.im97mori.ble.characteristic.u2ae8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.COEFFICIENT_CHARACTERISTIC;

/**
 * Coefficient (Characteristics UUID: 0x2AE8)
 */
@SuppressWarnings({"WeakerAccess"})
public class CoefficientAndroid extends Coefficient implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CoefficientAndroid> CREATOR = new ByteArrayCreator<CoefficientAndroid>() {

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
     * Constructor from parameters
     *
     * @param coefficient coefficient
     */
    public CoefficientAndroid(@NonNull Double coefficient) {
        super(coefficient);
    }

    /**
     * Constructor from parameters
     *
     * @param isNres {@code true}:ISO/IEEE Std. 11073-20601™-2008 FLOAT NRes (Not at this Resolution), {@code false}:ISO/IEEE Std. 11073-20601™-2008 FLOAT Reserved for future use
     */
    public CoefficientAndroid(boolean isNres) {
        super(isNres);
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
