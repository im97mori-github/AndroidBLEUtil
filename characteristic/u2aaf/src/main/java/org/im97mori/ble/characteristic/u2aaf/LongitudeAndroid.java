package org.im97mori.ble.characteristic.u2aaf;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.LONGITUDE_CHARACTERISTIC;

/**
 * Longitude (Characteristics UUID: 0x2AAF)
 */
@SuppressWarnings({"WeakerAccess"})
public class LongitudeAndroid extends Longitude implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LongitudeAndroid> CREATOR = new ByteArrayCreator<LongitudeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LongitudeAndroid createFromParcel(@NonNull Parcel in) {
            return new LongitudeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LongitudeAndroid[] newArray(int size) {
            return new LongitudeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LongitudeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LONGITUDE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LongitudeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AAF
     */
    public LongitudeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param longitude Longitude
     */
    public LongitudeAndroid(int longitude) {
        super(longitude);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LongitudeAndroid(@NonNull Parcel in) {
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
