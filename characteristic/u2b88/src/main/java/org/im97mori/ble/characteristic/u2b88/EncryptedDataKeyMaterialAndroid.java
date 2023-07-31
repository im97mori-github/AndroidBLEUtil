package org.im97mori.ble.characteristic.u2b88;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Encrypted Data Key Material (Characteristics UUID: 0x2B88)
 */
@SuppressWarnings({"WeakerAccess"})
public class EncryptedDataKeyMaterialAndroid extends EncryptedDataKeyMaterial implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EncryptedDataKeyMaterialAndroid> CREATOR = new ByteArrayCreator<EncryptedDataKeyMaterialAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EncryptedDataKeyMaterialAndroid createFromParcel(@NonNull Parcel in) {
            return new EncryptedDataKeyMaterialAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EncryptedDataKeyMaterialAndroid[] newArray(int size) {
            return new EncryptedDataKeyMaterialAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EncryptedDataKeyMaterialAndroid createFromByteArray(@NonNull byte[] values) {
            return new EncryptedDataKeyMaterialAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B88
     */
    @Deprecated
    public EncryptedDataKeyMaterialAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public EncryptedDataKeyMaterialAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param sessionKey Session Key
     * @param iv         IV
     */
    public EncryptedDataKeyMaterialAndroid(byte[] sessionKey, byte[] iv) {
        super(sessionKey, iv);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EncryptedDataKeyMaterialAndroid(@NonNull Parcel in) {
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
