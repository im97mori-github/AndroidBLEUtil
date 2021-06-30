package org.im97mori.ble.characteristic.u2b0a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.RELATIVE_VALUE_IN_AN_ILLUMINANCE_RANGE_CHARACTERISTIC;

/**
 * Relative Value In An Illuminance Range (Characteristics UUID: 0x2B0A)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class RelativeValueInAnIlluminanceRangeAndroid extends RelativeValueInAnIlluminanceRange implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RelativeValueInAnIlluminanceRangeAndroid> CREATOR = new ByteArrayCreater<RelativeValueInAnIlluminanceRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeValueInAnIlluminanceRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new RelativeValueInAnIlluminanceRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeValueInAnIlluminanceRangeAndroid[] newArray(int size) {
            return new RelativeValueInAnIlluminanceRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RelativeValueInAnIlluminanceRangeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RELATIVE_VALUE_IN_AN_ILLUMINANCE_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RelativeValueInAnIlluminanceRangeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B0A
     */
    public RelativeValueInAnIlluminanceRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RelativeValueInAnIlluminanceRangeAndroid(@NonNull Parcel in) {
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
