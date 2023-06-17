package org.im97mori.ble.characteristic.u2ae5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.CHROMATICITY_IN_CCT_AND_DUV_VALUES_CHARACTERISTIC;

/**
 * Chromaticity In CCT And Duv Values (Characteristics UUID: 0x2AE5)
 */
@SuppressWarnings({"WeakerAccess"})
public class ChromaticityInCctAndDuvValuesAndroid extends ChromaticityInCctAndDuvValues implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ChromaticityInCctAndDuvValuesAndroid> CREATOR = new ByteArrayCreator<ChromaticityInCctAndDuvValuesAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChromaticityInCctAndDuvValuesAndroid createFromParcel(@NonNull Parcel in) {
            return new ChromaticityInCctAndDuvValuesAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChromaticityInCctAndDuvValuesAndroid[] newArray(int size) {
            return new ChromaticityInCctAndDuvValuesAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ChromaticityInCctAndDuvValuesAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CHROMATICITY_IN_CCT_AND_DUV_VALUES_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ChromaticityInCctAndDuvValuesAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE5
     */
    public ChromaticityInCctAndDuvValuesAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param correlatedColorTemperature        Correlated Color Temperature
     * @param chromaticityDistanceFromPlanckian Chromaticity Distance from Planckian
     */
    public ChromaticityInCctAndDuvValuesAndroid(int correlatedColorTemperature, int chromaticityDistanceFromPlanckian) {
        super(correlatedColorTemperature, chromaticityDistanceFromPlanckian);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ChromaticityInCctAndDuvValuesAndroid(@NonNull Parcel in) {
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
