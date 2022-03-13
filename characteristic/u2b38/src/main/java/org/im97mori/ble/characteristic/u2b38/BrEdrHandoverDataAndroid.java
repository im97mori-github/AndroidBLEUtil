package org.im97mori.ble.characteristic.u2b38;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.BR_EDR_HANDOVER_DATA_CHARACTERISTIC;

/**
 * BR-EDR Handover Data (Characteristics UUID: 0x2B38)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BrEdrHandoverDataAndroid extends BrEdrHandoverData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BrEdrHandoverDataAndroid> CREATOR = new ByteArrayCreator<BrEdrHandoverDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BrEdrHandoverDataAndroid createFromParcel(@NonNull Parcel in) {
            return new BrEdrHandoverDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BrEdrHandoverDataAndroid[] newArray(int size) {
            return new BrEdrHandoverDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BrEdrHandoverDataAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BR_EDR_HANDOVER_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BrEdrHandoverDataAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B38
     */
    public BrEdrHandoverDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BrEdrHandoverDataAndroid(@NonNull Parcel in) {
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
