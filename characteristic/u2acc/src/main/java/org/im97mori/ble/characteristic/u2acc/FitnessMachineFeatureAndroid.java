package org.im97mori.ble.characteristic.u2acc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

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
            return new FitnessMachineFeatureAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ACC
     */
    @Deprecated
    public FitnessMachineFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public FitnessMachineFeatureAndroid(@NonNull byte[] values) {
        super(values);
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
        super(Objects.requireNonNull(in.createByteArray()));
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
