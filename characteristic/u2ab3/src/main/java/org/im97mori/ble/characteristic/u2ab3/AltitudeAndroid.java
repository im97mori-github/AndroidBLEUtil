package org.im97mori.ble.characteristic.u2ab3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ALTITUDE_CHARACTERISTIC;

/**
 * Altitude (Characteristics UUID: 0x2AB3)
 */
@SuppressWarnings({"WeakerAccess"})
public class AltitudeAndroid extends Altitude implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AltitudeAndroid> CREATOR = new ByteArrayCreater<AltitudeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AltitudeAndroid createFromParcel(@NonNull Parcel in) {
            return new AltitudeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AltitudeAndroid[] newArray(int size) {
            return new AltitudeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AltitudeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ALTITUDE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AltitudeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB3
     */
    public AltitudeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param altitude Altitude
     */
    public AltitudeAndroid(int altitude) {
        super(altitude);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private AltitudeAndroid(@NonNull Parcel in) {
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
