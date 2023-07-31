package org.im97mori.ble.characteristic.u2af3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Energy In A Period Of Day (Characteristics UUID: 0x2AF3)
 */
@SuppressWarnings({"WeakerAccess"})
public class EnergyInAPeriodOfDayAndroid extends EnergyInAPeriodOfDay implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EnergyInAPeriodOfDayAndroid> CREATOR = new ByteArrayCreator<EnergyInAPeriodOfDayAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EnergyInAPeriodOfDayAndroid createFromParcel(@NonNull Parcel in) {
            return new EnergyInAPeriodOfDayAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EnergyInAPeriodOfDayAndroid[] newArray(int size) {
            return new EnergyInAPeriodOfDayAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EnergyInAPeriodOfDayAndroid createFromByteArray(@NonNull byte[] values) {
            return new EnergyInAPeriodOfDayAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF3
     */
    @Deprecated
    public EnergyInAPeriodOfDayAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public EnergyInAPeriodOfDayAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param energyValue mEnergyValue
     * @param startTime   mStartTime
     * @param endTime     mEndTime
     */
    public EnergyInAPeriodOfDayAndroid(int energyValue, int startTime, int endTime) {
        super(energyValue, startTime, endTime);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EnergyInAPeriodOfDayAndroid(@NonNull Parcel in) {
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
