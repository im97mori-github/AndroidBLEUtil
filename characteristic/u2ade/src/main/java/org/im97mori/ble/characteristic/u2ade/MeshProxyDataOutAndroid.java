package org.im97mori.ble.characteristic.u2ade;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Mesh Proxy Data Out (Characteristics UUID: 0x2ADE)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class MeshProxyDataOutAndroid extends MeshProxyDataOut implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MeshProxyDataOutAndroid> CREATOR = new ByteArrayCreator<MeshProxyDataOutAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MeshProxyDataOutAndroid createFromParcel(@NonNull Parcel in) {
            return new MeshProxyDataOutAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MeshProxyDataOutAndroid[] newArray(int size) {
            return new MeshProxyDataOutAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MeshProxyDataOutAndroid createFromByteArray(@NonNull byte[] values) {
            return new MeshProxyDataOutAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ADE
     */
    @Deprecated
    public MeshProxyDataOutAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public MeshProxyDataOutAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MeshProxyDataOutAndroid(@NonNull Parcel in) {
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
