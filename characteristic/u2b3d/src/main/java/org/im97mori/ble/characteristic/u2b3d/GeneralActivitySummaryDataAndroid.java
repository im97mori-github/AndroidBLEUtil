package org.im97mori.ble.characteristic.u2b3d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.GENERAL_ACTIVITY_SUMMARY_DATA_CHARACTERISTIC;

/**
 * General Activity Summary Data (Characteristics UUID: 0x2B3D)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class GeneralActivitySummaryDataAndroid extends GeneralActivitySummaryData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<GeneralActivitySummaryDataAndroid> CREATOR = new ByteArrayCreater<GeneralActivitySummaryDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GeneralActivitySummaryDataAndroid createFromParcel(@NonNull Parcel in) {
            return new GeneralActivitySummaryDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GeneralActivitySummaryDataAndroid[] newArray(int size) {
            return new GeneralActivitySummaryDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GeneralActivitySummaryDataAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GENERAL_ACTIVITY_SUMMARY_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new GeneralActivitySummaryDataAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B3D
     */
    public GeneralActivitySummaryDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private GeneralActivitySummaryDataAndroid(@NonNull Parcel in) {
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
