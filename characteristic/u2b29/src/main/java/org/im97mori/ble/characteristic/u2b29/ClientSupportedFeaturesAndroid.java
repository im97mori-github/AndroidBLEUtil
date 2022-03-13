package org.im97mori.ble.characteristic.u2b29;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;

/**
 * Client Supported Features (Characteristics UUID: 0x2B29)
 */
@SuppressWarnings({"WeakerAccess"})
public class ClientSupportedFeaturesAndroid extends ClientSupportedFeatures implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ClientSupportedFeaturesAndroid> CREATOR = new ByteArrayCreator<ClientSupportedFeaturesAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ClientSupportedFeaturesAndroid createFromParcel(@NonNull Parcel in) {
            return new ClientSupportedFeaturesAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ClientSupportedFeaturesAndroid[] newArray(int size) {
            return new ClientSupportedFeaturesAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ClientSupportedFeaturesAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ClientSupportedFeaturesAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B29
     */
    public ClientSupportedFeaturesAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ClientSupportedFeaturesAndroid(@NonNull Parcel in) {
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
