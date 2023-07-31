package org.im97mori.ble.characteristic.u2b08;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Relative Runtime In A Generic Level Range (Characteristics UUID: 0x2B08)
 */
@SuppressWarnings({"WeakerAccess"})
public class RelativeRuntimeInAGenericLevelRangeAndroid extends RelativeRuntimeInAGenericLevelRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RelativeRuntimeInAGenericLevelRangeAndroid> CREATOR = new ByteArrayCreator<RelativeRuntimeInAGenericLevelRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeRuntimeInAGenericLevelRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new RelativeRuntimeInAGenericLevelRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeRuntimeInAGenericLevelRangeAndroid[] newArray(int size) {
            return new RelativeRuntimeInAGenericLevelRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RelativeRuntimeInAGenericLevelRangeAndroid createFromByteArray(@NonNull byte[] values) {
            return new RelativeRuntimeInAGenericLevelRangeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B08
     */
    @Deprecated
    public RelativeRuntimeInAGenericLevelRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RelativeRuntimeInAGenericLevelRangeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param relativeValue       Relative Value
     * @param minimumGenericLevel Minimum Generic Level
     * @param maximumGenericLevel Maximum Generic Level
     */
    public RelativeRuntimeInAGenericLevelRangeAndroid(int relativeValue, int minimumGenericLevel, int maximumGenericLevel) {
        super(relativeValue, minimumGenericLevel, maximumGenericLevel);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RelativeRuntimeInAGenericLevelRangeAndroid(@NonNull Parcel in) {
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
