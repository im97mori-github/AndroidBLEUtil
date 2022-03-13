package org.im97mori.ble.characteristic.u2a7a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.HEAT_INDEX_CHARACTERISTIC;

/**
 * Heat Index (Characteristics UUID: 0x2A7A)
 */
@SuppressWarnings({"WeakerAccess"})
public class HeatIndexAndroid extends HeatIndex implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HeatIndexAndroid> CREATOR = new ByteArrayCreator<HeatIndexAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeatIndexAndroid createFromParcel(@NonNull Parcel in) {
            return new HeatIndexAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeatIndexAndroid[] newArray(int size) {
            return new HeatIndexAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HeatIndexAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HeatIndexAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A7A
     */
    public HeatIndexAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param heatIndex Heat Index
     */
    public HeatIndexAndroid(int heatIndex) {
        super(heatIndex);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HeatIndexAndroid(@NonNull Parcel in) {
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
