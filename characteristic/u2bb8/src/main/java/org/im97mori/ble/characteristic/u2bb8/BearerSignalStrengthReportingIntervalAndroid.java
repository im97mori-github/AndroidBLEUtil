package org.im97mori.ble.characteristic.u2bb8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.BEARER_SIGNAL_STRENGTH_REPORTING_INTERVAL_CHARACTERISTIC;

/**
 * Bearer Signal Strength Reporting Interval (Characteristics UUID: 0x2BB8)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BearerSignalStrengthReportingIntervalAndroid extends BearerSignalStrengthReportingInterval implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BearerSignalStrengthReportingIntervalAndroid> CREATOR = new ByteArrayCreater<BearerSignalStrengthReportingIntervalAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerSignalStrengthReportingIntervalAndroid createFromParcel(@NonNull Parcel in) {
            return new BearerSignalStrengthReportingIntervalAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerSignalStrengthReportingIntervalAndroid[] newArray(int size) {
            return new BearerSignalStrengthReportingIntervalAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BearerSignalStrengthReportingIntervalAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BEARER_SIGNAL_STRENGTH_REPORTING_INTERVAL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BearerSignalStrengthReportingIntervalAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB8
     */
    public BearerSignalStrengthReportingIntervalAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BearerSignalStrengthReportingIntervalAndroid(@NonNull Parcel in) {
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
