package org.im97mori.ble.characteristic.u2aff;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.LUMINOUS_FLUX_CHARACTERISTIC;

/**
 * Luminous Flux (Characteristics UUID: 0x2AFF)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class LuminousFluxAndroid extends LuminousFlux implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LuminousFluxAndroid> CREATOR = new ByteArrayCreater<LuminousFluxAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousFluxAndroid createFromParcel(@NonNull Parcel in) {
            return new LuminousFluxAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousFluxAndroid[] newArray(int size) {
            return new LuminousFluxAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LuminousFluxAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LUMINOUS_FLUX_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LuminousFluxAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AFF
     */
    public LuminousFluxAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LuminousFluxAndroid(@NonNull Parcel in) {
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
