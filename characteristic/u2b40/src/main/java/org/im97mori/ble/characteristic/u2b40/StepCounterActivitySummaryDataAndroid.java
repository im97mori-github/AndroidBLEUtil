package org.im97mori.ble.characteristic.u2b40;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Step Counter Activity Summary Data (Characteristics UUID: 0x2B40)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class StepCounterActivitySummaryDataAndroid extends StepCounterActivitySummaryData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<StepCounterActivitySummaryDataAndroid> CREATOR = new ByteArrayCreator<StepCounterActivitySummaryDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StepCounterActivitySummaryDataAndroid createFromParcel(@NonNull Parcel in) {
            return new StepCounterActivitySummaryDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StepCounterActivitySummaryDataAndroid[] newArray(int size) {
            return new StepCounterActivitySummaryDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public StepCounterActivitySummaryDataAndroid createFromByteArray(@NonNull byte[] values) {
            return new StepCounterActivitySummaryDataAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B40
     */
    @Deprecated
    public StepCounterActivitySummaryDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public StepCounterActivitySummaryDataAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private StepCounterActivitySummaryDataAndroid(@NonNull Parcel in) {
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
