package org.im97mori.ble.characteristic.u2b50;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CALORIC_INTAKE_CHARACTERISTIC;

/**
 * Caloric Intake (Characteristics UUID: 0x2B50)
 */
@SuppressWarnings({"WeakerAccess"})
public class CaloricIntakeAndroid extends CaloricIntake implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CaloricIntakeAndroid> CREATOR = new ByteArrayCreater<CaloricIntakeAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CALORIC_INTAKE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CaloricIntakeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B50
     */
    public CaloricIntakeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
