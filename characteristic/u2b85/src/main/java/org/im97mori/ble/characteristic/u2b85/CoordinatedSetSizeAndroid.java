package org.im97mori.ble.characteristic.u2b85;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.COORDINATED_SET_SIZE_CHARACTERISTIC;

/**
 * Coordinated Set Size (Characteristics UUID: 0x2B85)
 */
@SuppressWarnings({"WeakerAccess"})
public class CoordinatedSetSizeAndroid extends CoordinatedSetSize implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CoordinatedSetSizeAndroid> CREATOR = new ByteArrayCreator<CoordinatedSetSizeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CoordinatedSetSizeAndroid createFromParcel(@NonNull Parcel in) {
            return new CoordinatedSetSizeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CoordinatedSetSizeAndroid[] newArray(int size) {
            return new CoordinatedSetSizeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CoordinatedSetSizeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(COORDINATED_SET_SIZE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CoordinatedSetSizeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B85
     */
    public CoordinatedSetSizeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param coordinatedSetSize Coordinated Set Size
     */
    public CoordinatedSetSizeAndroid(int coordinatedSetSize) {
        super(coordinatedSetSize);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CoordinatedSetSizeAndroid(@NonNull Parcel in) {
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
