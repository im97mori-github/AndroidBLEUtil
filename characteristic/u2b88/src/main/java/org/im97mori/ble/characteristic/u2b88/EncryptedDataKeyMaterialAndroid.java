package org.im97mori.ble.characteristic.u2b88;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ENCRYPTED_DATA_KEY_MATERIAL_CHARACTERISTIC;

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ENCRYPTED_DATA_KEY_MATERIAL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new EncryptedDataKeyMaterialAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B88
     */
    public EncryptedDataKeyMaterialAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
