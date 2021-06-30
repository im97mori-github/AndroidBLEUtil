package org.im97mori.ble.characteristic.u2bc0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TERMINATION_REASON_CHARACTERISTIC;

/**
 * Termination Reason (Characteristics UUID: 0x2BC0)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TerminationReasonAndroid extends TerminationReason implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TerminationReasonAndroid> CREATOR = new ByteArrayCreater<TerminationReasonAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TerminationReasonAndroid createFromParcel(@NonNull Parcel in) {
            return new TerminationReasonAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TerminationReasonAndroid[] newArray(int size) {
            return new TerminationReasonAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TerminationReasonAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TERMINATION_REASON_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TerminationReasonAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC0
     */
    public TerminationReasonAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TerminationReasonAndroid(@NonNull Parcel in) {
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
