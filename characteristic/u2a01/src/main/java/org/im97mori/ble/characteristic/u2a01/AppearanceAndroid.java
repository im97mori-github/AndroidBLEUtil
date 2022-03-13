package org.im97mori.ble.characteristic.u2a01;

import static org.im97mori.ble.constants.CharacteristicUUID.APPEARANCE_CHARACTERISTIC;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

/**
 * Appearance (Characteristics UUID: 0x2A01)
 */
@SuppressWarnings({"WeakerAccess"})
public class AppearanceAndroid extends Appearance implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AppearanceAndroid> CREATOR = new ByteArrayCreator<AppearanceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AppearanceAndroid createFromParcel(@NonNull Parcel in) {
            return new AppearanceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AppearanceAndroid[] newArray(int size) {
            return new AppearanceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AppearanceAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPEARANCE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AppearanceAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A01
     */
    public AppearanceAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param appearanceValue Appearance Value
     */
    public AppearanceAndroid(int appearanceValue) {
        super(appearanceValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AppearanceAndroid(@NonNull Parcel in) {
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
