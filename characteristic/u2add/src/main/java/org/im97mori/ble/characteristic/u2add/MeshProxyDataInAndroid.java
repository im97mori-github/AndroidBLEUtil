package org.im97mori.ble.characteristic.u2add;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Mesh Proxy Data In (Characteristics UUID: 0x2ADD)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class MeshProxyDataInAndroid extends MeshProxyDataIn implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MeshProxyDataInAndroid> CREATOR = new ByteArrayCreator<MeshProxyDataInAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MeshProxyDataInAndroid createFromParcel(@NonNull Parcel in) {
            return new MeshProxyDataInAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MeshProxyDataInAndroid[] newArray(int size) {
            return new MeshProxyDataInAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MeshProxyDataInAndroid createFromByteArray(@NonNull byte[] values) {
            return new MeshProxyDataInAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ADD
     */
    @Deprecated
    public MeshProxyDataInAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public MeshProxyDataInAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MeshProxyDataInAndroid(@NonNull Parcel in) {
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
