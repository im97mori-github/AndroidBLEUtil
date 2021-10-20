package org.im97mori.ble.characteristic.u2bcb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.SOURCE_PAC_CHARACTERISTIC;

/**
 * Source PAC (Characteristics UUID: 0x2BCB)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SourcePacAndroid extends SourcePac implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SourcePacAndroid> CREATOR = new ByteArrayCreater<SourcePacAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SourcePacAndroid createFromParcel(@NonNull Parcel in) {
            return new SourcePacAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SourcePacAndroid[] newArray(int size) {
            return new SourcePacAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SourcePacAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SOURCE_PAC_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SourcePacAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BCB
     */
    public SourcePacAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SourcePacAndroid(@NonNull Parcel in) {
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
