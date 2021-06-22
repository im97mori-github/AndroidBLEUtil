package org.im97mori.ble.descriptor.u2902;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;

/**
 * Client Characteristic Configuration (Descriptor UUID: 0x2902)
 */
@SuppressWarnings({"WeakerAccess"})
public class ClientCharacteristicConfigurationAndroid extends ClientCharacteristicConfiguration implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ClientCharacteristicConfigurationAndroid> CREATOR = new ByteArrayCreater<ClientCharacteristicConfigurationAndroid>() {

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
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2902
     */
    public ClientCharacteristicConfigurationAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ClientCharacteristicConfigurationAndroid(@NonNull Parcel in) {
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
