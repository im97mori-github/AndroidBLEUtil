package org.im97mori.ble.characteristic.u2a5e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.PLX_SPOT_CHECK_MEASUREMENT_CHARACTERISTIC;

/**
 * PLX Spot-Check Measurement (Characteristics UUID: 0x2A5E)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PlxSpotCheckMeasurementAndroid extends PlxSpotCheckMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PlxSpotCheckMeasurementAndroid> CREATOR = new ByteArrayCreator<PlxSpotCheckMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlxSpotCheckMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new PlxSpotCheckMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlxSpotCheckMeasurementAndroid[] newArray(int size) {
            return new PlxSpotCheckMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PlxSpotCheckMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PLX_SPOT_CHECK_MEASUREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PlxSpotCheckMeasurementAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A5E
     */
    public PlxSpotCheckMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PlxSpotCheckMeasurementAndroid(@NonNull Parcel in) {
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
