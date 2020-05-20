package org.im97mori.ble.characteristic.u2a97;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WAIST_CIRCUMFERENCE_CHARACTERISTIC;

/**
 * Waist Circumference (Characteristics UUID: 0x2A97)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class WaistCircumferenceAndroid extends WaistCircumference implements Parcelable {

    /**
     * Waist Circumference Unit 0.01 meters
     */
    public static final double WAIST_CIRCUMFERENCE_RESOLUTION = 0.01;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<WaistCircumferenceAndroid> CREATOR = new ByteArrayCreater<WaistCircumferenceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WaistCircumferenceAndroid createFromParcel(@NonNull Parcel in) {
            return new WaistCircumferenceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WaistCircumferenceAndroid[] newArray(int size) {
            return new WaistCircumferenceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public WaistCircumferenceAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new WaistCircumferenceAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A97
     */
    public WaistCircumferenceAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param waistCircumference Waist Circumference
     */
    public WaistCircumferenceAndroid(int waistCircumference) {
        super(waistCircumference);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private WaistCircumferenceAndroid(@NonNull Parcel in) {
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
