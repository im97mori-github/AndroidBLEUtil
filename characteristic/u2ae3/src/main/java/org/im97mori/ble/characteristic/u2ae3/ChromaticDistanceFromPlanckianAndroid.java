package org.im97mori.ble.characteristic.u2ae3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.CHROMATIC_DISTANCE_FROM_PLANCKIAN_CHARACTERISTIC;

/**
 * Chromatic Distance From Planckian (Characteristics UUID: 0x2AE3)
 */
@SuppressWarnings({"WeakerAccess"})
public class ChromaticDistanceFromPlanckianAndroid extends ChromaticDistanceFromPlanckian implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ChromaticDistanceFromPlanckianAndroid> CREATOR = new ByteArrayCreator<ChromaticDistanceFromPlanckianAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChromaticDistanceFromPlanckianAndroid createFromParcel(@NonNull Parcel in) {
            return new ChromaticDistanceFromPlanckianAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChromaticDistanceFromPlanckianAndroid[] newArray(int size) {
            return new ChromaticDistanceFromPlanckianAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ChromaticDistanceFromPlanckianAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CHROMATIC_DISTANCE_FROM_PLANCKIAN_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ChromaticDistanceFromPlanckianAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE3
     */
    public ChromaticDistanceFromPlanckianAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param distanceFromPlanckian Distance From Planckian
     */
    public ChromaticDistanceFromPlanckianAndroid(int distanceFromPlanckian) {
        super(distanceFromPlanckian);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ChromaticDistanceFromPlanckianAndroid(@NonNull Parcel in) {
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
