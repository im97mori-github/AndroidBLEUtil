package org.im97mori.ble.characteristic.u2bd9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC;

/**
 * Sulfur Hexafluoride Concentration (Characteristics UUID: 0x2BD9)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SulfurHexafluorideConcentrationAndroid extends SulfurHexafluorideConcentration implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SulfurHexafluorideConcentrationAndroid> CREATOR = new ByteArrayCreater<SulfurHexafluorideConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SulfurHexafluorideConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new SulfurHexafluorideConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SulfurHexafluorideConcentrationAndroid[] newArray(int size) {
            return new SulfurHexafluorideConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SulfurHexafluorideConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SulfurHexafluorideConcentrationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD9
     */
    public SulfurHexafluorideConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SulfurHexafluorideConcentrationAndroid(@NonNull Parcel in) {
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
