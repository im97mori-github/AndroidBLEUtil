package org.im97mori.ble.characteristic.u2ade;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.MESH_PROXY_DATA_OUT_CHARACTERISTIC;

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MESH_PROXY_DATA_OUT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MeshProxyDataOutAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ADE
     */
    public MeshProxyDataOutAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MeshProxyDataOutAndroid(@NonNull Parcel in) {
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
