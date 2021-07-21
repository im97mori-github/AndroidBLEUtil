package org.im97mori.ble.characteristic.u2b00;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.LUMINOUS_FLUX_RANGE_CHARACTERISTIC;

/**
 * Luminous Flux Range (Characteristics UUID: 0x2B00)
 */
@SuppressWarnings({"WeakerAccess"})
public class LuminousFluxRangeAndroid extends LuminousFluxRange implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LuminousFluxRangeAndroid> CREATOR = new ByteArrayCreater<LuminousFluxRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousFluxRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new LuminousFluxRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousFluxRangeAndroid[] newArray(int size) {
            return new LuminousFluxRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LuminousFluxRangeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LUMINOUS_FLUX_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LuminousFluxRangeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B00
     */
    public LuminousFluxRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param minimumLuminousFlux Minimum Luminous Flux
     * @param maximumLuminousFlux Maximum Luminous Flux
     */
    public LuminousFluxRangeAndroid(int minimumLuminousFlux, int maximumLuminousFlux) {
        super(minimumLuminousFlux, maximumLuminousFlux);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LuminousFluxRangeAndroid(@NonNull Parcel in) {
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
