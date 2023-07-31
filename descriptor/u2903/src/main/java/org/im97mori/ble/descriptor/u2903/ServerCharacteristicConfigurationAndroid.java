package org.im97mori.ble.descriptor.u2903;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

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
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ServerCharacteristicConfigurationAndroid> CREATOR = new ByteArrayCreator<ServerCharacteristicConfigurationAndroid>() {

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
            return new ServerCharacteristicConfigurationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2903
     */
    @Deprecated
    public ServerCharacteristicConfigurationAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public ServerCharacteristicConfigurationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ServerCharacteristicConfigurationAndroid(@NonNull Parcel in) {
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
