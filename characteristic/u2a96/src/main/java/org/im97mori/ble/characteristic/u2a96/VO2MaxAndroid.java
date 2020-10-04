package org.im97mori.ble.characteristic.u2a96;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.VO2_MAX_CHARACTERISTIC;

/**
 * VO2 Max (Characteristics UUID: 0x2A96)
 */
@SuppressWarnings({"WeakerAccess"})
public class VO2MaxAndroid extends VO2Max implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<VO2MaxAndroid> CREATOR = new ByteArrayCreater<VO2MaxAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VO2MaxAndroid createFromParcel(@NonNull Parcel in) {
            return new VO2MaxAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VO2MaxAndroid[] newArray(int size) {
            return new VO2MaxAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VO2MaxAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(VO2_MAX_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new VO2MaxAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A96
     */
    public VO2MaxAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param vo2Max VO2 Max
     */
    public VO2MaxAndroid(int vo2Max) {
        super(vo2Max);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private VO2MaxAndroid(@NonNull Parcel in) {
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
