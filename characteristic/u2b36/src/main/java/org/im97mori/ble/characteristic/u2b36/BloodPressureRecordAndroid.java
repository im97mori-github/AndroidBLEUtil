package org.im97mori.ble.characteristic.u2b36;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.BLOOD_PRESSURE_RECORD_CHARACTERISTIC;

/**
 * Blood Pressure Record (Characteristics UUID: 0x2B36)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BloodPressureRecordAndroid extends BloodPressureRecord implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BloodPressureRecordAndroid> CREATOR = new ByteArrayCreater<BloodPressureRecordAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureRecordAndroid createFromParcel(@NonNull Parcel in) {
            return new BloodPressureRecordAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureRecordAndroid[] newArray(int size) {
            return new BloodPressureRecordAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BloodPressureRecordAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BLOOD_PRESSURE_RECORD_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BloodPressureRecordAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B36
     */
    public BloodPressureRecordAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BloodPressureRecordAndroid(@NonNull Parcel in) {
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
