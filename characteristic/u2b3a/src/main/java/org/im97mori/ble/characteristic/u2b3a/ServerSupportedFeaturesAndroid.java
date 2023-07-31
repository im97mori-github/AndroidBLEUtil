package org.im97mori.ble.characteristic.u2b3a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.List;
import java.util.Objects;

/**
 * Server Supported Features (Characteristics UUID: 0x2B3A)
 */
@SuppressWarnings({"WeakerAccess"})
public class ServerSupportedFeaturesAndroid extends ServerSupportedFeatures implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ServerSupportedFeaturesAndroid> CREATOR = new ByteArrayCreator<ServerSupportedFeaturesAndroid>() {

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
            return new ServerSupportedFeaturesAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B3A
     */
    @Deprecated
    public ServerSupportedFeaturesAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ServerSupportedFeaturesAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param serverSupportedFeaturesList Server Supported Features List
     */
    public ServerSupportedFeaturesAndroid(@NonNull List<Integer> serverSupportedFeaturesList) {
        super(serverSupportedFeaturesList);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ServerSupportedFeaturesAndroid(@NonNull Parcel in) {
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
