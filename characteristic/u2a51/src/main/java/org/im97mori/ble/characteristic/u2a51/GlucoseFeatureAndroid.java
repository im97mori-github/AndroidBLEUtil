package org.im97mori.ble.characteristic.u2a51;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.GLUCOSE_FEATURE_CHARACTERISTIC;

/**
 * Glucose Feature (Characteristics UUID: 0x2A51)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class GlucoseFeatureAndroid extends GlucoseFeature implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<GlucoseFeatureAndroid> CREATOR = new ByteArrayCreater<GlucoseFeatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GlucoseFeatureAndroid createFromParcel(@NonNull Parcel in) {
            return new GlucoseFeatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GlucoseFeatureAndroid[] newArray(int size) {
            return new GlucoseFeatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GlucoseFeatureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GLUCOSE_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new GlucoseFeatureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A51
     */
    public GlucoseFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private GlucoseFeatureAndroid(@NonNull Parcel in) {
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
