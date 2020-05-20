package org.im97mori.ble.characteristic.u2a74;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.GUST_FACTOR_CHARACTERISTIC;

/**
 * Gust Factor (Characteristics UUID: 0x2A74)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class GustFactorAndroid extends GustFactor implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<GustFactorAndroid> CREATOR = new ByteArrayCreater<GustFactorAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GustFactorAndroid createFromParcel(@NonNull Parcel in) {
            return new GustFactorAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GustFactorAndroid[] newArray(int size) {
            return new GustFactorAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GustFactorAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new GustFactorAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A74
     */
    public GustFactorAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param gustFactor Gust Factor
     */
    public GustFactorAndroid(int gustFactor) {
        super(gustFactor);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private GustFactorAndroid(@NonNull Parcel in) {
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
