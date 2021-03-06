package org.im97mori.ble.characteristic.u2b01;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.LUMINOUS_INTENSITY_CHARACTERISTIC;

/**
 * Luminous Intensity (Characteristics UUID: 0x2B01)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class LuminousIntensityAndroid extends LuminousIntensity implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LuminousIntensityAndroid> CREATOR = new ByteArrayCreater<LuminousIntensityAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousIntensityAndroid createFromParcel(@NonNull Parcel in) {
            return new LuminousIntensityAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousIntensityAndroid[] newArray(int size) {
            return new LuminousIntensityAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LuminousIntensityAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LUMINOUS_INTENSITY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LuminousIntensityAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B01
     */
    public LuminousIntensityAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LuminousIntensityAndroid(@NonNull Parcel in) {
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
