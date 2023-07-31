package org.im97mori.ble.characteristic.u2a9b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Body Composition Feature (Characteristics UUID: 0x2A9B)
 */
@SuppressWarnings({"WeakerAccess"})
public class BodyCompositionFeatureAndroid extends BodyCompositionFeature implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BodyCompositionFeatureAndroid> CREATOR = new ByteArrayCreator<BodyCompositionFeatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionFeatureAndroid createFromParcel(@NonNull Parcel in) {
            return new BodyCompositionFeatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionFeatureAndroid[] newArray(int size) {
            return new BodyCompositionFeatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BodyCompositionFeatureAndroid createFromByteArray(@NonNull byte[] values) {
            return new BodyCompositionFeatureAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A9B
     */
    @Deprecated
    public BodyCompositionFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BodyCompositionFeatureAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BodyCompositionFeatureAndroid(@NonNull Parcel in) {
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
