package org.im97mori.ble.characteristic.u2a49;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BLOOD_PRESSURE_FEATURE_CHARACTERISTIC;

/**
 * Blood Pressure Feature (Characteristics UUID: 0x2A49)
 */
@SuppressWarnings({"WeakerAccess"})
public class BloodPressureFeatureAndroid extends BloodPressureFeature implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BloodPressureFeatureAndroid> CREATOR = new ByteArrayCreater<BloodPressureFeatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureFeatureAndroid createFromParcel(@NonNull Parcel in) {
            return new BloodPressureFeatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureFeatureAndroid[] newArray(int size) {
            return new BloodPressureFeatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BloodPressureFeatureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BLOOD_PRESSURE_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A49
     */
    public BloodPressureFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BloodPressureFeatureAndroid(@NonNull Parcel in) {
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
