package org.im97mori.ble.characteristic.u2b45;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.PHYSICAL_ACTIVITY_SESSION_DESCRIPTOR_CHARACTERISTIC;

/**
 * Session (Characteristics UUID: 0x2B45)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PhysicalActivitySessionDescriptorAndroid extends PhysicalActivitySessionDescriptor implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PhysicalActivitySessionDescriptorAndroid> CREATOR = new ByteArrayCreator<PhysicalActivitySessionDescriptorAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PhysicalActivitySessionDescriptorAndroid createFromParcel(@NonNull Parcel in) {
            return new PhysicalActivitySessionDescriptorAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PhysicalActivitySessionDescriptorAndroid[] newArray(int size) {
            return new PhysicalActivitySessionDescriptorAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PhysicalActivitySessionDescriptorAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PHYSICAL_ACTIVITY_SESSION_DESCRIPTOR_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PhysicalActivitySessionDescriptorAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B45
     */
    public PhysicalActivitySessionDescriptorAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PhysicalActivitySessionDescriptorAndroid(@NonNull Parcel in) {
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
