package org.im97mori.ble.characteristic.u2a71;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRUE_WIND_DIRECTION_CHARACTERISTIC;

/**
 * True Wind Direction (Characteristics UUID: 0x2A71)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TrueWindDirectionAndroid extends TrueWindDirection implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TrueWindDirectionAndroid> CREATOR = new ByteArrayCreater<TrueWindDirectionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrueWindDirectionAndroid createFromParcel(@NonNull Parcel in) {
            return new TrueWindDirectionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrueWindDirectionAndroid[] newArray(int size) {
            return new TrueWindDirectionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrueWindDirectionAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_DIRECTION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TrueWindDirectionAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A71
     */
    public TrueWindDirectionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private TrueWindDirectionAndroid(@NonNull Parcel in) {
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
