package org.im97mori.ble.characteristic.u2bd6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.PARTICULATE_MATTER_PM25_CONCENTRATION_CHARACTERISTIC;

/**
 * Particulate Matter - PM2.5 Concentration (Characteristics UUID: 0x2BD6)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ParticulateMatterPm25ConcentrationAndroid extends ParticulateMatterPm25Concentration implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ParticulateMatterPm25ConcentrationAndroid> CREATOR = new ByteArrayCreater<ParticulateMatterPm25ConcentrationAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM25_CONCENTRATION_CHARACTERISTIC, 0, 0);
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