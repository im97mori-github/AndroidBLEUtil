package org.im97mori.ble.characteristic.u2b40;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.STEP_COUNTER_ACTIVITY_SUMMARY_DATA_CHARACTERISTIC;

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STEP_COUNTER_ACTIVITY_SUMMARY_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new StepCounterActivitySummaryDataAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B40
     */
    public StepCounterActivitySummaryDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private StepCounterActivitySummaryDataAndroid(@NonNull Parcel in) {
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
