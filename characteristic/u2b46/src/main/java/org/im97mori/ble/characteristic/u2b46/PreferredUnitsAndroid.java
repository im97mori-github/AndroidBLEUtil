package org.im97mori.ble.characteristic.u2b46;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.PREFERRED_UNITS_CHARACTERISTIC;

/**
 * Preferred Units (Characteristics UUID: 0x2B46)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PreferredUnitsAndroid extends PreferredUnits implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PreferredUnitsAndroid> CREATOR = new ByteArrayCreater<PreferredUnitsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PreferredUnitsAndroid createFromParcel(@NonNull Parcel in) {
            return new PreferredUnitsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PreferredUnitsAndroid[] newArray(int size) {
            return new PreferredUnitsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PreferredUnitsAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PREFERRED_UNITS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PreferredUnitsAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B46
     */
    public PreferredUnitsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PreferredUnitsAndroid(@NonNull Parcel in) {
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
