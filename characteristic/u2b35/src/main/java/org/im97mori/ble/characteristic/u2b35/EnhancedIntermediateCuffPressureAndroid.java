package org.im97mori.ble.characteristic.u2b35;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import java.util.Objects;

/**
 * Enhanced Intermediate Cuff Pressure (Characteristics UUID: 0x2B35)
 */
@SuppressWarnings({"WeakerAccess"})
public class EnhancedIntermediateCuffPressureAndroid extends EnhancedIntermediateCuffPressure implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EnhancedIntermediateCuffPressureAndroid> CREATOR = new ByteArrayCreator<EnhancedIntermediateCuffPressureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EnhancedIntermediateCuffPressureAndroid createFromParcel(@NonNull Parcel in) {
            return new EnhancedIntermediateCuffPressureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EnhancedIntermediateCuffPressureAndroid[] newArray(int size) {
            return new EnhancedIntermediateCuffPressureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EnhancedIntermediateCuffPressureAndroid createFromByteArray(@NonNull byte[] values) {
            return new EnhancedIntermediateCuffPressureAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B35
     */
    @Deprecated
    public EnhancedIntermediateCuffPressureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public EnhancedIntermediateCuffPressureAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                             Flags
     * @param intermediateCuffPressureValueMmhg Intermediate Cuff Pressure Value
     *                                          (mmHg)
     * @param intermediateCuffPressureValueKpa  Intermediate Cuff Pressure Value
     *                                          (kPa) Value - Systolic (kPa)
     * @param timeStamp                         Time Stamp
     * @param pulseRate                         Pulse Rate
     * @param userId                            User ID
     * @param measurementStatus                 Measurement Status
     * @param userFacingTime                    User Facing
     */
    public EnhancedIntermediateCuffPressureAndroid(int flags,
                                            @NonNull IEEE_11073_20601_SFLOAT intermediateCuffPressureValueMmhg,
                                            @NonNull IEEE_11073_20601_SFLOAT intermediateCuffPressureValueKpa, long timeStamp,
                                            @NonNull IEEE_11073_20601_SFLOAT pulseRate, int userId, @NonNull byte[] measurementStatus,
                                            long userFacingTime) {
        super(flags, intermediateCuffPressureValueMmhg, intermediateCuffPressureValueKpa, timeStamp, pulseRate, userId, measurementStatus, userFacingTime);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EnhancedIntermediateCuffPressureAndroid(@NonNull Parcel in) {
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
