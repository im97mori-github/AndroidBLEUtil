package org.im97mori.ble.characteristic.u2bc5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.SOURCE_ASE_CHARACTERISTIC;

/**
 * Source ASE (Characteristics UUID: 0x2BC5)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SourceAseAndroid extends SourceAse implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SourceAseAndroid> CREATOR = new ByteArrayCreater<SourceAseAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SourceAseAndroid createFromParcel(@NonNull Parcel in) {
            return new SourceAseAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SourceAseAndroid[] newArray(int size) {
            return new SourceAseAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SourceAseAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SOURCE_ASE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SourceAseAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC5
     */
    public SourceAseAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SourceAseAndroid(@NonNull Parcel in) {
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
