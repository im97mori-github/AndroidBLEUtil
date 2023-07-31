package org.im97mori.ble.characteristic.u2aa2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Language (Characteristics UUID: 0x2AA2)
 */
@SuppressWarnings({"WeakerAccess"})
public class LanguageAndroid extends Language implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LanguageAndroid> CREATOR = new ByteArrayCreator<LanguageAndroid>() {

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
            return new LanguageAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA2
     */
    @Deprecated
    public LanguageAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LanguageAndroid(@NonNull byte[] values) {
        super(values);
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
    private LanguageAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()));
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
