package org.im97mori.ble.characteristic.u2b8a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.APPARENT_POWER_CHARACTERISTIC;

/**
 * Apparent Power (Characteristics UUID: 0x2B8A)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ApparentPowerAndroid extends ApparentPower implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ApparentPowerAndroid> CREATOR = new ByteArrayCreator<ApparentPowerAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentPowerAndroid createFromParcel(@NonNull Parcel in) {
            return new ApparentPowerAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentPowerAndroid[] newArray(int size) {
            return new ApparentPowerAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ApparentPowerAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_POWER_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ApparentPowerAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B8A
     */
    public ApparentPowerAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ApparentPowerAndroid(@NonNull Parcel in) {
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
