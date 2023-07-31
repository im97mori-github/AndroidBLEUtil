package org.im97mori.ble.characteristic.u2a19;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Battery Level (Characteristics UUID: 0x2A19)
 */
@SuppressWarnings({"WeakerAccess"})
public class BatteryLevelAndroid extends BatteryLevel implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BatteryLevelAndroid> CREATOR = new ByteArrayCreator<BatteryLevelAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryLevelAndroid createFromParcel(@NonNull Parcel in) {
            return new BatteryLevelAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryLevelAndroid[] newArray(int size) {
            return new BatteryLevelAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BatteryLevelAndroid createFromByteArray(@NonNull byte[] values) {
            return new BatteryLevelAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A19
     */
    @Deprecated
    public BatteryLevelAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BatteryLevelAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param level Level
     */
    public BatteryLevelAndroid(int level) {
        super(level);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BatteryLevelAndroid(@NonNull Parcel in) {
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
