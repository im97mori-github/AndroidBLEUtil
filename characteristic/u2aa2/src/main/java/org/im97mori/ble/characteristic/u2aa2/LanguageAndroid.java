package org.im97mori.ble.characteristic.u2aa2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LANGUAGE_CHARACTERISTIC;

/**
 * Language (Characteristics UUID: 0x2AA2)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class LanguageAndroid extends Language implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LanguageAndroid> CREATOR = new ByteArrayCreater<LanguageAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LanguageAndroid createFromParcel(@NonNull Parcel in) {
            return new LanguageAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LanguageAndroid[] newArray(int size) {
            return new LanguageAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LanguageAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LANGUAGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LanguageAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA2
     */
    public LanguageAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param language Language
     */
    public LanguageAndroid(@NonNull String language) {
        super(language);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private LanguageAndroid(@NonNull Parcel in) {
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
