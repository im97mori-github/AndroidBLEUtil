package org.im97mori.ble.characteristic.u2bb4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.BEARER_UCI_CHARACTERISTIC;

/**
 * Bearer UCI (Characteristics UUID: 0x2BB4)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BearerUciAndroid extends BearerUci implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BearerUciAndroid> CREATOR = new ByteArrayCreater<BearerUciAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerUciAndroid createFromParcel(@NonNull Parcel in) {
            return new BearerUciAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerUciAndroid[] newArray(int size) {
            return new BearerUciAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BearerUciAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BEARER_UCI_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BearerUciAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB4
     */
    public BearerUciAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BearerUciAndroid(@NonNull Parcel in) {
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
