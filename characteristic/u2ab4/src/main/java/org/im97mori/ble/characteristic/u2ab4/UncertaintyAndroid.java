package org.im97mori.ble.characteristic.u2ab4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.UNCERTAINTY_CHARACTERISTIC;

/**
 * Uncertainty (Characteristics UUID: 0x2AB4)
 */
@SuppressWarnings({"WeakerAccess"})
public class UncertaintyAndroid extends Uncertainty implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<UncertaintyAndroid> CREATOR = new ByteArrayCreater<UncertaintyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UncertaintyAndroid createFromParcel(@NonNull Parcel in) {
            return new UncertaintyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UncertaintyAndroid[] newArray(int size) {
            return new UncertaintyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public UncertaintyAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UNCERTAINTY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new UncertaintyAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB4
     */
    public UncertaintyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param uncertainty Uncertainty
     */
    public UncertaintyAndroid(int uncertainty) {
        super(uncertainty);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UncertaintyAndroid(@NonNull Parcel in) {
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
