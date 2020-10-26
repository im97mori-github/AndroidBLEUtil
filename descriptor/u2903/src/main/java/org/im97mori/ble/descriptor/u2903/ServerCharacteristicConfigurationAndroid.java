package org.im97mori.ble.descriptor.u2903;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.SERVER_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;

/**
 * Server Characteristic Configuration (Descriptor UUID: 0x2903)
 */
@SuppressWarnings({"WeakerAccess"})
public class ServerCharacteristicConfigurationAndroid extends ServerCharacteristicConfiguration implements Parcelable {

    /**
     * Properties:Broadcasts disabled
     */
    public static final int PROPERTIES_BROADCASTS_DISABLED = 0x00;

    /**
     * Properties:Broadcasts enabled
     */
    public static final int PROPERTIES_BROADCASTS_ENABLED = 0x01;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ServerCharacteristicConfigurationAndroid> CREATOR = new ByteArrayCreater<ServerCharacteristicConfigurationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ServerCharacteristicConfigurationAndroid createFromParcel(@NonNull Parcel in) {
            return new ServerCharacteristicConfigurationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ServerCharacteristicConfigurationAndroid[] newArray(int size) {
            return new ServerCharacteristicConfigurationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ServerCharacteristicConfigurationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(SERVER_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new ServerCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2903
     */
    public ServerCharacteristicConfigurationAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ServerCharacteristicConfigurationAndroid(@NonNull Parcel in) {
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
