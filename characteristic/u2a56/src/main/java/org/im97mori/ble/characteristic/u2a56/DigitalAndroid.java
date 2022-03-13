package org.im97mori.ble.characteristic.u2a56;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.DIGITAL_CHARACTERISTIC;

/**
 * Digital (Characteristics UUID: 0x2A56)
 */
@SuppressWarnings({"WeakerAccess"})
public class DigitalAndroid extends Digital implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DigitalAndroid> CREATOR = new ByteArrayCreator<DigitalAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DigitalAndroid createFromParcel(@NonNull Parcel in) {
            return new DigitalAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DigitalAndroid[] newArray(int size) {
            return new DigitalAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DigitalAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DIGITAL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DigitalAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A56
     */
    public DigitalAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DigitalAndroid(@NonNull Parcel in) {
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
