package org.im97mori.ble.characteristic.u2b1d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.RC_FEATURE_CHARACTERISTIC;

/**
 * RC Feature (Characteristics UUID: 0x2B1D)
 */
@SuppressWarnings("WeakerAccess")
public class RCFeatureAndroid extends RCFeature implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RCFeatureAndroid> CREATOR = new ByteArrayCreator<RCFeatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RCFeatureAndroid createFromParcel(@NonNull Parcel in) {
            return new RCFeatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RCFeatureAndroid[] newArray(int size) {
            return new RCFeatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RCFeatureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RC_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RCFeatureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B1D
     */
    public RCFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param e2eCrc     E2E-CRC
     * @param rcFeatures RC Features
     */
    public RCFeatureAndroid(int e2eCrc, @NonNull byte[] rcFeatures) {
        super(e2eCrc, rcFeatures);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RCFeatureAndroid(@NonNull Parcel in) {
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
