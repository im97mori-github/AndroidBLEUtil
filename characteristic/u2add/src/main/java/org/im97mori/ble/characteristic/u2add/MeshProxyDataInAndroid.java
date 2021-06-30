package org.im97mori.ble.characteristic.u2add;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.MESH_PROXY_DATA_IN_CHARACTERISTIC;

/**
 * Mesh Proxy Data In (Characteristics UUID: 0x2ADD)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class MeshProxyDataInAndroid extends MeshProxyDataIn implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MeshProxyDataInAndroid> CREATOR = new ByteArrayCreater<MeshProxyDataInAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MESH_PROXY_DATA_IN_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MeshProxyDataInAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ADD
     */
    public MeshProxyDataInAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MeshProxyDataInAndroid(@NonNull Parcel in) {
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
