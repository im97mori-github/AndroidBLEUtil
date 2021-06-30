package org.im97mori.ble.characteristic.u2b02;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.MASS_FLOW_CHARACTERISTIC;

/**
 * Mass Flow (Characteristics UUID: 0x2B02)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class MassFlowAndroid extends MassFlow implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MassFlowAndroid> CREATOR = new ByteArrayCreater<MassFlowAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MassFlowAndroid createFromParcel(@NonNull Parcel in) {
            return new MassFlowAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MassFlowAndroid[] newArray(int size) {
            return new MassFlowAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MassFlowAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MASS_FLOW_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MassFlowAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B02
     */
    public MassFlowAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MassFlowAndroid(@NonNull Parcel in) {
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
