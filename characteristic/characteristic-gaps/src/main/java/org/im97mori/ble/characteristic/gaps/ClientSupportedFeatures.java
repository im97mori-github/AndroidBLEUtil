package org.im97mori.ble.characteristic.gaps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;

/**
 * Client Supported Features (Characteristics UUID: 0x2B29)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ClientSupportedFeatures implements ByteArrayInterface, Parcelable {

    /**
     * octet: The client supports robust caching
     */
    public static final int CLIENT_FEATYRES_ROBUST_CACHING_OCTET = 0;

    /**
     * bit: The client supports robust caching
     */
    public static final int CLIENT_FEATYRES_ROBUST_CACHING_BIT = 0b00000000_00000000_00000000_00000001;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ClientSupportedFeatures> CREATOR = new ByteArrayCreater<ClientSupportedFeatures>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ClientSupportedFeatures createFromParcel(@NonNull Parcel in) {
            return new ClientSupportedFeatures(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ClientSupportedFeatures[] newArray(int size) {
            return new ClientSupportedFeatures[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ClientSupportedFeatures createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ClientSupportedFeatures(bluetoothGattCharacteristic);
        }

    };

    /**
     * Client Features
     */
    private final byte[] mClientFeatures;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B29
     */
    public ClientSupportedFeatures(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mClientFeatures = bluetoothGattCharacteristic.getValue();
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ClientSupportedFeatures(@NonNull Parcel in) {
        mClientFeatures = in.createByteArray();
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
        dest.writeByteArray(mClientFeatures);
    }

    /**
     * @return Client Features
     */
    public byte[] getClientFeatures() {
        return mClientFeatures;
    }

    /**
     * @return {@code true}:The client supports robust caching supported
     */
    public boolean isClientFeatresRobustCachingSuppreted() {
        boolean result = false;
        if (CLIENT_FEATYRES_ROBUST_CACHING_OCTET < mClientFeatures.length) {
            result = (mClientFeatures[CLIENT_FEATYRES_ROBUST_CACHING_OCTET] & CLIENT_FEATYRES_ROBUST_CACHING_BIT) != 0;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[mClientFeatures.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mClientFeatures);
        return data;
    }

}
