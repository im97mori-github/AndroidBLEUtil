package org.im97mori.ble.characteristic.u2aca;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.UNSPECIFIED_CHARACTERISTIC;

/**
 * Unspecified (Characteristics UUID: 0x2ACA)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class UnspecifiedAndroid extends Unspecified implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<UnspecifiedAndroid> CREATOR = new ByteArrayCreater<UnspecifiedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UnspecifiedAndroid createFromParcel(@NonNull Parcel in) {
            return new UnspecifiedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UnspecifiedAndroid[] newArray(int size) {
            return new UnspecifiedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public UnspecifiedAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UNSPECIFIED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new UnspecifiedAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ACA
     */
    public UnspecifiedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UnspecifiedAndroid(@NonNull Parcel in) {
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
