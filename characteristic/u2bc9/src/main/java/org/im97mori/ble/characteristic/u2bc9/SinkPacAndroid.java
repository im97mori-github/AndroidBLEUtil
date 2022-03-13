package org.im97mori.ble.characteristic.u2bc9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.SINK_PAC_CHARACTERISTIC;

/**
 * Sink PAC (Characteristics UUID: 0x2BC9)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SinkPacAndroid extends SinkPac implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SinkPacAndroid> CREATOR = new ByteArrayCreator<SinkPacAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SinkPacAndroid createFromParcel(@NonNull Parcel in) {
            return new SinkPacAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SinkPacAndroid[] newArray(int size) {
            return new SinkPacAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SinkPacAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SINK_PAC_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SinkPacAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC9
     */
    public SinkPacAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SinkPacAndroid(@NonNull Parcel in) {
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
