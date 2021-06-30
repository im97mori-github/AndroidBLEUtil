package org.im97mori.ble.characteristic.u2b35;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.ENHANCED_INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC;

/**
 * Enhanced Intermediate Cuff Pressure (Characteristics UUID: 0x2B35)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class EnhancedIntermediateCuffPressureAndroid extends EnhancedIntermediateCuffPressure implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<EnhancedIntermediateCuffPressureAndroid> CREATOR = new ByteArrayCreater<EnhancedIntermediateCuffPressureAndroid>() {

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
