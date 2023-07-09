package org.im97mori.ble.characteristic.u2bd6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import static org.im97mori.ble.constants.CharacteristicUUID.PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC;

/**
 * Particulate Matter - PM2.5 Concentration (Characteristics UUID: 0x2BD6)
 */
@SuppressWarnings({"WeakerAccess"})
public class ParticulateMatterPm25ConcentrationAndroid extends ParticulateMatterPm25Concentration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ParticulateMatterPm25ConcentrationAndroid> CREATOR = new ByteArrayCreator<ParticulateMatterPm25ConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ParticulateMatterPm25ConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new ParticulateMatterPm25ConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ParticulateMatterPm25ConcentrationAndroid[] newArray(int size) {
            return new ParticulateMatterPm25ConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ParticulateMatterPm25ConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ParticulateMatterPm25ConcentrationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD6
     */
    public ParticulateMatterPm25ConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param particulateMatterPm25Concentration Particulate Matter - PM2.5
     *                                           Concentration
     */
    public ParticulateMatterPm25ConcentrationAndroid(@NonNull IEEE_11073_20601_SFLOAT particulateMatterPm25Concentration) {
        super(particulateMatterPm25Concentration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ParticulateMatterPm25ConcentrationAndroid(@NonNull Parcel in) {
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
