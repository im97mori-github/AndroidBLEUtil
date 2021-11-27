package org.im97mori.ble.characteristic.u2bd4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import static org.im97mori.ble.constants.CharacteristicUUID.OZONE_CONCENTRATION_CHARACTERISTIC;

/**
 * Ozone Concentration (Characteristics UUID: 0x2BD4)
 */
@SuppressWarnings({"WeakerAccess"})
public class OzoneConcentrationAndroid extends OzoneConcentration implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<OzoneConcentrationAndroid> CREATOR = new ByteArrayCreater<OzoneConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public OzoneConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new OzoneConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public OzoneConcentrationAndroid[] newArray(int size) {
            return new OzoneConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public OzoneConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(OZONE_CONCENTRATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new OzoneConcentrationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD4
     */
    public OzoneConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param ozoneConcentration Ozone Concentration
     */
    public OzoneConcentrationAndroid(@NonNull IEEE_11073_20601_SFLOAT ozoneConcentration) {
        super(ozoneConcentration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private OzoneConcentrationAndroid(@NonNull Parcel in) {
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
