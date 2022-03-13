package org.im97mori.ble.characteristic.u2adc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.MESH_PROVISIONING_DATA_OUT_CHARACTERISTIC;

/**
 * Mesh Provisioning Data Out (Characteristics UUID: 0x2ADC)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class MeshProvisioningDataOutAndroid extends MeshProvisioningDataOut implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MeshProvisioningDataOutAndroid> CREATOR = new ByteArrayCreator<MeshProvisioningDataOutAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MeshProvisioningDataOutAndroid createFromParcel(@NonNull Parcel in) {
            return new MeshProvisioningDataOutAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MeshProvisioningDataOutAndroid[] newArray(int size) {
            return new MeshProvisioningDataOutAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MeshProvisioningDataOutAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MESH_PROVISIONING_DATA_OUT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MeshProvisioningDataOutAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ADC
     */
    public MeshProvisioningDataOutAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MeshProvisioningDataOutAndroid(@NonNull Parcel in) {
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
