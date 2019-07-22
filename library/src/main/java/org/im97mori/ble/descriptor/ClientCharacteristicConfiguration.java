package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * Client Characteristic Configuration (Descriptor UUID: 0x2902)
 */
@SuppressWarnings("WeakerAccess")
public class ClientCharacteristicConfiguration implements Parcelable {

    /**
     * @see Creator
     */
    public static final Creator<ClientCharacteristicConfiguration> CREATOR = new Creator<ClientCharacteristicConfiguration>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ClientCharacteristicConfiguration createFromParcel(Parcel in) {
            return new ClientCharacteristicConfiguration(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ClientCharacteristicConfiguration[] newArray(int size) {
            return new ClientCharacteristicConfiguration[size];
        }

    };

    /**
     * <p>
     * Configuration
     *
     * @see BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE
     * @see BluetoothGattDescriptor#ENABLE_INDICATION_VALUE
     * @see BluetoothGattDescriptor#DISABLE_NOTIFICATION_VALUE
     * </p>
     */
    private final byte[] mConfiguration;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2902
     */
    public ClientCharacteristicConfiguration(BluetoothGattDescriptor bluetoothGattDescriptor) {
        mConfiguration = bluetoothGattDescriptor.getValue();
    }

    public ClientCharacteristicConfiguration(byte[] configration) {
        mConfiguration = configration;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ClientCharacteristicConfiguration(Parcel in) {
        mConfiguration = in.createByteArray();
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByteArray(mConfiguration);
    }

    /**
     * @return Configuration
     */
    public byte[] getConfiguration() {
        return mConfiguration;
    }

    /**
     * @return {@code true}:current configuration is {@link BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE}, {@code false}:not {@link BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE}
     */
    public boolean isNotification() {
        return Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, mConfiguration);
    }

    /**
     * @return {@code true}:current configuration is {@link BluetoothGattDescriptor#ENABLE_INDICATION_VALUE}, {@code false}:not {@link BluetoothGattDescriptor#ENABLE_INDICATION_VALUE}
     */
    public boolean isIndication() {
        return Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, mConfiguration);
    }

}
