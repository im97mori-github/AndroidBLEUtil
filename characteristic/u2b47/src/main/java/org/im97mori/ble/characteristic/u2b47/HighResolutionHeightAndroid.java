package org.im97mori.ble.characteristic.u2b47;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.HIGH_RESOLUTION_HEIGHT_CHARACTERISTIC;

/**
 * High Resolution Height (Characteristics UUID: 0x2B47)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class HighResolutionHeightAndroid extends HighResolutionHeight implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HighResolutionHeightAndroid> CREATOR = new ByteArrayCreater<HighResolutionHeightAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HighResolutionHeightAndroid createFromParcel(@NonNull Parcel in) {
            return new HighResolutionHeightAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HighResolutionHeightAndroid[] newArray(int size) {
            return new HighResolutionHeightAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HighResolutionHeightAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HIGH_RESOLUTION_HEIGHT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HighResolutionHeightAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B47
     */
    public HighResolutionHeightAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HighResolutionHeightAndroid(@NonNull Parcel in) {
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
