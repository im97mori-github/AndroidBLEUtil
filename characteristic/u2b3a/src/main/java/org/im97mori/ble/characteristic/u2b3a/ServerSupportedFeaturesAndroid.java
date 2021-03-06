package org.im97mori.ble.characteristic.u2b3a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.SERVER_SUPPORTED_FEATURES_CHARACTERISTIC;

/**
 * Server Supported Features (Characteristics UUID: 0x2B3A)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ServerSupportedFeaturesAndroid extends ServerSupportedFeatures implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ServerSupportedFeaturesAndroid> CREATOR = new ByteArrayCreater<ServerSupportedFeaturesAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServerSupportedFeaturesAndroid createFromParcel(@NonNull Parcel in) {
            return new ServerSupportedFeaturesAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServerSupportedFeaturesAndroid[] newArray(int size) {
            return new ServerSupportedFeaturesAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ServerSupportedFeaturesAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SERVER_SUPPORTED_FEATURES_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ServerSupportedFeaturesAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B3A
     */
    public ServerSupportedFeaturesAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ServerSupportedFeaturesAndroid(@NonNull Parcel in) {
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
