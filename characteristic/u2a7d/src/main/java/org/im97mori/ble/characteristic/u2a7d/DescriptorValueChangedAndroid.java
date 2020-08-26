package org.im97mori.ble.characteristic.u2a7d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC;

/**
 * Descriptor Value Changed (Characteristics UUID: 0x2A7D)
 */
@SuppressWarnings({"WeakerAccess"})
public class DescriptorValueChangedAndroid extends DescriptorValueChanged implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DescriptorValueChangedAndroid> CREATOR = new ByteArrayCreater<DescriptorValueChangedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DescriptorValueChangedAndroid createFromParcel(@NonNull Parcel in) {
            return new DescriptorValueChangedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DescriptorValueChangedAndroid[] newArray(int size) {
            return new DescriptorValueChangedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DescriptorValueChangedAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DescriptorValueChangedAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A7D
     */
    public DescriptorValueChangedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param flags              Flags
     * @param characteristicUUID Characteristic UUID
     */
    public DescriptorValueChangedAndroid(int flags, @NonNull byte[] characteristicUUID) {
        super(flags, characteristicUUID);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private DescriptorValueChangedAndroid(@NonNull Parcel in) {
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
