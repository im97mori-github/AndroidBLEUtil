package org.im97mori.ble.characteristic.u2adb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.MESH_PROVISIONING_DATA_IN_CHARACTERISTIC;

/**
 * Mesh Provisioning Data In (Characteristics UUID: 0x2ADB)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class MeshProvisioningDataInAndroid extends MeshProvisioningDataIn implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MeshProvisioningDataInAndroid> CREATOR = new ByteArrayCreator<MeshProvisioningDataInAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MeshProvisioningDataInAndroid createFromParcel(@NonNull Parcel in) {
            return new MeshProvisioningDataInAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MeshProvisioningDataInAndroid[] newArray(int size) {
            return new MeshProvisioningDataInAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MeshProvisioningDataInAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MESH_PROVISIONING_DATA_IN_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MeshProvisioningDataInAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ADB
     */
    public MeshProvisioningDataInAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MeshProvisioningDataInAndroid(@NonNull Parcel in) {
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
