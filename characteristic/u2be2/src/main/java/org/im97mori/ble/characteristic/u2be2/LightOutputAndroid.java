package org.im97mori.ble.characteristic.u2be2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.LIGHT_OUTPUT_CHARACTERISTIC;

/**
 * Light Output (Characteristics UUID: 0x2BE2)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class LightOutputAndroid extends LightOutput implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LightOutputAndroid> CREATOR = new ByteArrayCreator<LightOutputAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LightOutputAndroid createFromParcel(@NonNull Parcel in) {
            return new LightOutputAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LightOutputAndroid[] newArray(int size) {
            return new LightOutputAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LightOutputAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LIGHT_OUTPUT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LightOutputAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE2
     */
    public LightOutputAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LightOutputAndroid(@NonNull Parcel in) {
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
