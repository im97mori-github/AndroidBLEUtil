package org.im97mori.ble.characteristic.u2ae5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CHROMATICITYIN_CCT_AND_DUV_VALUES_CHARACTERISTIC;

/**
 * Chromaticity in CCT And Duv Values (Characteristics UUID: 0x2AE5)
 */
@SuppressWarnings({"WeakerAccess"})
public class ChromaticityinCctAndDuvValuesAndroid extends ChromaticityinCctAndDuvValues implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ChromaticityinCctAndDuvValuesAndroid> CREATOR = new ByteArrayCreater<ChromaticityinCctAndDuvValuesAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChromaticityinCctAndDuvValuesAndroid createFromParcel(@NonNull Parcel in) {
            return new ChromaticityinCctAndDuvValuesAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChromaticityinCctAndDuvValuesAndroid[] newArray(int size) {
            return new ChromaticityinCctAndDuvValuesAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ChromaticityinCctAndDuvValuesAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CHROMATICITYIN_CCT_AND_DUV_VALUES_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ChromaticityinCctAndDuvValuesAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE5
     */
    public ChromaticityinCctAndDuvValuesAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param correlatedColorTemperature        Correlated Color Temperature
     * @param chromaticityDistanceFromPlanckian Chromaticity Distance from Planckian
     */
    public ChromaticityinCctAndDuvValuesAndroid(int correlatedColorTemperature, int chromaticityDistanceFromPlanckian) {
        super(correlatedColorTemperature, chromaticityDistanceFromPlanckian);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ChromaticityinCctAndDuvValuesAndroid(@NonNull Parcel in) {
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
