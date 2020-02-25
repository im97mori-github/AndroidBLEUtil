package org.im97mori.ble.characteristic.u2aa3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;

/**
 * Barometric Pressure Trend (Characteristics UUID: 0x2AA3)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BarometricPressureTrendAndroid extends BarometricPressureTrend implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BarometricPressureTrendAndroid> CREATOR = new ByteArrayCreater<BarometricPressureTrendAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BarometricPressureTrendAndroid createFromParcel(@NonNull Parcel in) {
            return new BarometricPressureTrendAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BarometricPressureTrendAndroid[] newArray(int size) {
            return new BarometricPressureTrendAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BarometricPressureTrendAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA3
     */
    public BarometricPressureTrendAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private BarometricPressureTrendAndroid(@NonNull Parcel in) {
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
