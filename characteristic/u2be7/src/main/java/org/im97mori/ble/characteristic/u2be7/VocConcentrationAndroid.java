package org.im97mori.ble.characteristic.u2be7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.VOC_CONCENTRATION_CHARACTERISTIC;

/**
 * VOC Concentration (Characteristics UUID: 0x2BE7)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class VocConcentrationAndroid extends VocConcentration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<VocConcentrationAndroid> CREATOR = new ByteArrayCreator<VocConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VocConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new VocConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VocConcentrationAndroid[] newArray(int size) {
            return new VocConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VocConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(VOC_CONCENTRATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new VocConcentrationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE7
     */
    public VocConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VocConcentrationAndroid(@NonNull Parcel in) {
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
