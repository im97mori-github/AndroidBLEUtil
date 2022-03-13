package org.im97mori.ble.characteristic.u2bc4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.SINK_ASE_CHARACTERISTIC;

/**
 * Sink ASE (Characteristics UUID: 0x2BC4)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SinkAseAndroid extends SinkAse implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SinkAseAndroid> CREATOR = new ByteArrayCreator<SinkAseAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SinkAseAndroid createFromParcel(@NonNull Parcel in) {
            return new SinkAseAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SinkAseAndroid[] newArray(int size) {
            return new SinkAseAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SinkAseAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SINK_ASE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SinkAseAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC4
     */
    public SinkAseAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SinkAseAndroid(@NonNull Parcel in) {
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
