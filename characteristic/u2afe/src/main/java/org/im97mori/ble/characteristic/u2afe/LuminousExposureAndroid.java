package org.im97mori.ble.characteristic.u2afe;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.LUMINOUS_EXPOSURE_CHARACTERISTIC;

/**
 * Luminous Exposure (Characteristics UUID: 0x2AFE)
 */
@SuppressWarnings({"WeakerAccess"})
public class LuminousExposureAndroid extends LuminousExposure implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LuminousExposureAndroid> CREATOR = new ByteArrayCreator<LuminousExposureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousExposureAndroid createFromParcel(@NonNull Parcel in) {
            return new LuminousExposureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousExposureAndroid[] newArray(int size) {
            return new LuminousExposureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LuminousExposureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LUMINOUS_EXPOSURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LuminousExposureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AFE
     */
    public LuminousExposureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param luminousExposure Luminous Exposure
     */
    public LuminousExposureAndroid(int luminousExposure) {
        super(luminousExposure);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LuminousExposureAndroid(@NonNull Parcel in) {
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
