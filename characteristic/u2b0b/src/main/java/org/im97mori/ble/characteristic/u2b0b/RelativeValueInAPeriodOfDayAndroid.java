package org.im97mori.ble.characteristic.u2b0b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.RELATIVE_VALUE_IN_A_PERIOD_OF_DAY_CHARACTERISTIC;

/**
 * Relative Value In A Period Of Day (Characteristics UUID: 0x2B0B)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class RelativeValueInAPeriodOfDayAndroid extends RelativeValueInAPeriodOfDay implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RelativeValueInAPeriodOfDayAndroid> CREATOR = new ByteArrayCreater<RelativeValueInAPeriodOfDayAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeValueInAPeriodOfDayAndroid createFromParcel(@NonNull Parcel in) {
            return new RelativeValueInAPeriodOfDayAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeValueInAPeriodOfDayAndroid[] newArray(int size) {
            return new RelativeValueInAPeriodOfDayAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RelativeValueInAPeriodOfDayAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RELATIVE_VALUE_IN_A_PERIOD_OF_DAY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RelativeValueInAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B0B
     */
    public RelativeValueInAPeriodOfDayAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RelativeValueInAPeriodOfDayAndroid(@NonNull Parcel in) {
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
