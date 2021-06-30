package org.im97mori.ble.characteristic.u2a0c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.EXACT_TIME_256_CHARACTERISTIC;

/**
 * Exact Time 256 (Characteristics UUID: 0x2A0C)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ExactTime_256Android extends ExactTime_256 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ExactTime_256Android> CREATOR = new ByteArrayCreater<ExactTime_256Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ExactTime_256Android createFromParcel(@NonNull Parcel in) {
            return new ExactTime_256Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ExactTime_256Android[] newArray(int size) {
            return new ExactTime_256Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ExactTime_256Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(EXACT_TIME_256_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ExactTime_256Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A0C
     */
    public ExactTime_256Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ExactTime_256Android(@NonNull Parcel in) {
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
