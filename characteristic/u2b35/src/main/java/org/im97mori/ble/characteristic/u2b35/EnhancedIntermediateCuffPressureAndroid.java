package org.im97mori.ble.characteristic.u2b35;

import static org.im97mori.ble.constants.CharacteristicUUID.ENHANCED_INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ENHANCED_INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new EnhancedIntermediateCuffPressureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B35
     */
    public EnhancedIntermediateCuffPressureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
