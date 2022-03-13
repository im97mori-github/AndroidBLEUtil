package org.im97mori.ble.characteristic.u2afc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.LUMINOUS_EFFICACY_CHARACTERISTIC;

/**
 * Luminous Efficacy (Characteristics UUID: 0x2AFC)
 */
@SuppressWarnings({"WeakerAccess"})
public class LuminousEfficacyAndroid extends LuminousEfficacy implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LuminousEfficacyAndroid> CREATOR = new ByteArrayCreator<LuminousEfficacyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousEfficacyAndroid createFromParcel(@NonNull Parcel in) {
            return new LuminousEfficacyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousEfficacyAndroid[] newArray(int size) {
            return new LuminousEfficacyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LuminousEfficacyAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LUMINOUS_EFFICACY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LuminousEfficacyAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AFC
     */
    public LuminousEfficacyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param luminousEfficacy Luminous Efficacy
     */
    public LuminousEfficacyAndroid(int luminousEfficacy) {
        super(luminousEfficacy);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LuminousEfficacyAndroid(@NonNull Parcel in) {
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
