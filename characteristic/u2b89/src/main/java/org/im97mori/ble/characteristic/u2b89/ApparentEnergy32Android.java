package org.im97mori.ble.characteristic.u2b89;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.APPARENT_ENERGY_32_CHARACTERISTIC;

/**
 * Apparent Energy 32 (Characteristics UUID: 0x2B89)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ApparentEnergy32Android extends ApparentEnergy32 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ApparentEnergy32Android> CREATOR = new ByteArrayCreator<ApparentEnergy32Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentEnergy32Android createFromParcel(@NonNull Parcel in) {
            return new ApparentEnergy32Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentEnergy32Android[] newArray(int size) {
            return new ApparentEnergy32Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ApparentEnergy32Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_ENERGY_32_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ApparentEnergy32Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B89
     */
    public ApparentEnergy32Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ApparentEnergy32Android(@NonNull Parcel in) {
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
