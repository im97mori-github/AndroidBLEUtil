package org.im97mori.ble.characteristic.u2b50;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Caloric Intake (Characteristics UUID: 0x2B50)
 */
@SuppressWarnings({"WeakerAccess"})
public class CaloricIntakeAndroid extends CaloricIntake implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CaloricIntakeAndroid> CREATOR = new ByteArrayCreator<CaloricIntakeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CaloricIntakeAndroid createFromParcel(@NonNull Parcel in) {
            return new CaloricIntakeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CaloricIntakeAndroid[] newArray(int size) {
            return new CaloricIntakeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CaloricIntakeAndroid createFromByteArray(@NonNull byte[] values) {
            return new CaloricIntakeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B50
     */
    @Deprecated
    public CaloricIntakeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CaloricIntakeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param caloricIntake Caloric Intake
     */
    public CaloricIntakeAndroid(int caloricIntake) {
        super(caloricIntake);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CaloricIntakeAndroid(@NonNull Parcel in) {
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
