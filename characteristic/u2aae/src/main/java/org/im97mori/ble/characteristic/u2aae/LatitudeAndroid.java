package org.im97mori.ble.characteristic.u2aae;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LATITUDE_CHARACTERISTIC;

/**
 * Latitude (Characteristics UUID: 0x2AAE)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class LatitudeAndroid extends Latitude implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LatitudeAndroid> CREATOR = new ByteArrayCreater<LatitudeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LatitudeAndroid createFromParcel(@NonNull Parcel in) {
            return new LatitudeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LatitudeAndroid[] newArray(int size) {
            return new LatitudeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LatitudeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LATITUDE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LatitudeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AAE
     */
    public LatitudeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private LatitudeAndroid(@NonNull Parcel in) {
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
