package org.im97mori.ble.characteristic.u2be3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.LIGHT_SOURCE_TYPE_CHARACTERISTIC;

/**
 * Light Source Type (Characteristics UUID: 0x2BE3)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class LightSourceTypeAndroid extends LightSourceType implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LightSourceTypeAndroid> CREATOR = new ByteArrayCreator<LightSourceTypeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LightSourceTypeAndroid createFromParcel(@NonNull Parcel in) {
            return new LightSourceTypeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LightSourceTypeAndroid[] newArray(int size) {
            return new LightSourceTypeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LightSourceTypeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LIGHT_SOURCE_TYPE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LightSourceTypeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE3
     */
    public LightSourceTypeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LightSourceTypeAndroid(@NonNull Parcel in) {
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
