package org.im97mori.ble.characteristic.u2ba8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ENERGY_32_CHARACTERISTIC;

/**
 * Energy 32 (Characteristics UUID: 0x2BA8)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class Energy32Android extends Energy32 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<Energy32Android> CREATOR = new ByteArrayCreator<Energy32Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Energy32Android createFromParcel(@NonNull Parcel in) {
            return new Energy32Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Energy32Android[] newArray(int size) {
            return new Energy32Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Energy32Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ENERGY_32_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Energy32Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BA8
     */
    public Energy32Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Energy32Android(@NonNull Parcel in) {
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
