package org.im97mori.ble.characteristic.u2b03;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.PERCEIVED_LIGHTNESS_CHARACTERISTIC;

/**
 * Perceived Lightness (Characteristics UUID: 0x2B03)
 */
@SuppressWarnings({"WeakerAccess"})
public class PerceivedLightnessAndroid extends PerceivedLightness implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PerceivedLightnessAndroid> CREATOR = new ByteArrayCreator<PerceivedLightnessAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PerceivedLightnessAndroid createFromParcel(@NonNull Parcel in) {
            return new PerceivedLightnessAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PerceivedLightnessAndroid[] newArray(int size) {
            return new PerceivedLightnessAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PerceivedLightnessAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PERCEIVED_LIGHTNESS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PerceivedLightnessAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B03
     */
    public PerceivedLightnessAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param perceivedLightness Perceived Lightness
     */
    public PerceivedLightnessAndroid(int perceivedLightness) {
        super(perceivedLightness);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PerceivedLightnessAndroid(@NonNull Parcel in) {
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
