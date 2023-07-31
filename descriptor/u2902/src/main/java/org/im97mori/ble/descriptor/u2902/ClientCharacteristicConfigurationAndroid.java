package org.im97mori.ble.descriptor.u2902;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Client Characteristic Configuration (Descriptor UUID: 0x2902)
 */
@SuppressWarnings({"WeakerAccess"})
public class ClientCharacteristicConfigurationAndroid extends ClientCharacteristicConfiguration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ClientCharacteristicConfigurationAndroid> CREATOR = new ByteArrayCreator<ClientCharacteristicConfigurationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ClientCharacteristicConfigurationAndroid createFromParcel(@NonNull Parcel in) {
            return new ClientCharacteristicConfigurationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ClientCharacteristicConfigurationAndroid[] newArray(int size) {
            return new ClientCharacteristicConfigurationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ClientCharacteristicConfigurationAndroid createFromByteArray(@NonNull byte[] values) {
            return new ClientCharacteristicConfigurationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2902
     */
    @Deprecated
    public ClientCharacteristicConfigurationAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public ClientCharacteristicConfigurationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ClientCharacteristicConfigurationAndroid(@NonNull Parcel in) {
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
