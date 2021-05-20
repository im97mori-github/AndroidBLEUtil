package org.im97mori.ble.characteristic.u2a2c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_DECLINATION_CHARACTERISTIC;

/**
 * Magnetic Declination (Characteristics UUID: 0x2A2C)
 */
@SuppressWarnings({"WeakerAccess"})
public class MagneticDeclinationAndroid extends MagneticDeclination implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MagneticDeclinationAndroid> CREATOR = new ByteArrayCreater<MagneticDeclinationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MagneticDeclinationAndroid createFromParcel(@NonNull Parcel in) {
            return new MagneticDeclinationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MagneticDeclinationAndroid[] newArray(int size) {
            return new MagneticDeclinationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MagneticDeclinationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MagneticDeclinationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A2C
     */
    public MagneticDeclinationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param magneticDeclination Magnetic Declination
     */
    public MagneticDeclinationAndroid(int magneticDeclination) {
        super(magneticDeclination);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MagneticDeclinationAndroid(@NonNull Parcel in) {
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
