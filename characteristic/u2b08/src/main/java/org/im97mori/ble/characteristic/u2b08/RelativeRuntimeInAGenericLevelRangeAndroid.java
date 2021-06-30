package org.im97mori.ble.characteristic.u2b08;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.RELATIVE_RUNTIME_IN_A_GENERIC_LEVEL_RANGE_CHARACTERISTIC;

/**
 * Relative Runtime In A Generic Level Range (Characteristics UUID: 0x2B08)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class RelativeRuntimeInAGenericLevelRangeAndroid extends RelativeRuntimeInAGenericLevelRange implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RelativeRuntimeInAGenericLevelRangeAndroid> CREATOR = new ByteArrayCreater<RelativeRuntimeInAGenericLevelRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeRuntimeInAGenericLevelRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new RelativeRuntimeInAGenericLevelRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeRuntimeInAGenericLevelRangeAndroid[] newArray(int size) {
            return new RelativeRuntimeInAGenericLevelRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RelativeRuntimeInAGenericLevelRangeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RELATIVE_RUNTIME_IN_A_GENERIC_LEVEL_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RelativeRuntimeInAGenericLevelRangeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B08
     */
    public RelativeRuntimeInAGenericLevelRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RelativeRuntimeInAGenericLevelRangeAndroid(@NonNull Parcel in) {
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
