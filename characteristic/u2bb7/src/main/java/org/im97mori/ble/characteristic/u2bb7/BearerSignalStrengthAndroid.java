package org.im97mori.ble.characteristic.u2bb7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.BEARER_SIGNAL_STRENGTH_CHARACTERISTIC;

/**
 * Bearer Signal Strength (Characteristics UUID: 0x2BB7)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BearerSignalStrengthAndroid extends BearerSignalStrength implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BearerSignalStrengthAndroid> CREATOR = new ByteArrayCreator<BearerSignalStrengthAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerSignalStrengthAndroid createFromParcel(@NonNull Parcel in) {
            return new BearerSignalStrengthAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerSignalStrengthAndroid[] newArray(int size) {
            return new BearerSignalStrengthAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BearerSignalStrengthAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BEARER_SIGNAL_STRENGTH_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BearerSignalStrengthAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB7
     */
    public BearerSignalStrengthAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BearerSignalStrengthAndroid(@NonNull Parcel in) {
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
