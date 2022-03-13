package org.im97mori.ble.characteristic.u2a65;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_FEATURE_CHARACTERISTIC;

/**
 * Cycling Power Feature (Characteristics UUID: 0x2A65)
 */
@SuppressWarnings({"WeakerAccess"})
public class CyclingPowerFeatureAndroid extends CyclingPowerFeature implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CyclingPowerFeatureAndroid> CREATOR = new ByteArrayCreator<CyclingPowerFeatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerFeatureAndroid createFromParcel(@NonNull Parcel in) {
            return new CyclingPowerFeatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerFeatureAndroid[] newArray(int size) {
            return new CyclingPowerFeatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CyclingPowerFeatureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CyclingPowerFeatureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A65
     */
    public CyclingPowerFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CyclingPowerFeatureAndroid(@NonNull Parcel in) {
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
