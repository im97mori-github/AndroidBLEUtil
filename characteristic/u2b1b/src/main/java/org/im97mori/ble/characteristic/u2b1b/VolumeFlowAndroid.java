package org.im97mori.ble.characteristic.u2b1b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.VOLUME_FLOW_CHARACTERISTIC;

/**
 * Volume Flow (Characteristics UUID: 0x2B1B)
 */
@SuppressWarnings({"WeakerAccess"})
public class VolumeFlowAndroid extends VolumeFlow implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<VolumeFlowAndroid> CREATOR = new ByteArrayCreator<VolumeFlowAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VolumeFlowAndroid createFromParcel(@NonNull Parcel in) {
            return new VolumeFlowAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VolumeFlowAndroid[] newArray(int size) {
            return new VolumeFlowAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VolumeFlowAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(VOLUME_FLOW_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new VolumeFlowAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B1B
     */
    public VolumeFlowAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param volumeFlow Volume Flow
     */
    public VolumeFlowAndroid(int volumeFlow) {
        super(volumeFlow);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VolumeFlowAndroid(@NonNull Parcel in) {
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
