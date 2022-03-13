package org.im97mori.ble.characteristic.u2b42;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.SLEEP_ACTIVITY_SUMMARY_DATA_CHARACTERISTIC;

/**
 * Sleep Activity Summary Data (Characteristics UUID: 0x2B42)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SleepActivitySummaryDataAndroid extends SleepActivitySummaryData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SleepActivitySummaryDataAndroid> CREATOR = new ByteArrayCreator<SleepActivitySummaryDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SleepActivitySummaryDataAndroid createFromParcel(@NonNull Parcel in) {
            return new SleepActivitySummaryDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SleepActivitySummaryDataAndroid[] newArray(int size) {
            return new SleepActivitySummaryDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SleepActivitySummaryDataAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SLEEP_ACTIVITY_SUMMARY_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SleepActivitySummaryDataAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B42
     */
    public SleepActivitySummaryDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SleepActivitySummaryDataAndroid(@NonNull Parcel in) {
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
