package org.im97mori.ble.characteristic.u2acc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.FITNESS_MACHINE_FEATURE_CHARACTERISTIC;

/**
 * Fitness Machine Feature (Characteristics UUID: 0x2ACC)
 */
@SuppressWarnings({"WeakerAccess"})
public class FitnessMachineFeatureAndroid extends FitnessMachineFeature implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FitnessMachineFeatureAndroid> CREATOR = new ByteArrayCreator<FitnessMachineFeatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineFeatureAndroid createFromParcel(@NonNull Parcel in) {
            return new FitnessMachineFeatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineFeatureAndroid[] newArray(int size) {
            return new FitnessMachineFeatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FitnessMachineFeatureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FitnessMachineFeatureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ACC
     */
    public FitnessMachineFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param fitnessMachineFeatures Fitness Machine Features
     * @param targetSettingFeatures  Target Setting Features
     */
    public FitnessMachineFeatureAndroid(@NonNull byte[] fitnessMachineFeatures, @NonNull byte[] targetSettingFeatures) {
        super(fitnessMachineFeatures, targetSettingFeatures);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FitnessMachineFeatureAndroid(@NonNull Parcel in) {
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
