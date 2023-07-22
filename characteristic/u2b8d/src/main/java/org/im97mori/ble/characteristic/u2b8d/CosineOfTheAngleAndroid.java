package org.im97mori.ble.characteristic.u2b8d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.COSINE_OF_THE_ANGLE_CHARACTERISTIC;

/**
 * Cosine of the Angle (Characteristics UUID: 0x2B8D)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CosineOfTheAngleAndroid extends CosineOfTheAngle implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CosineOfTheAngleAndroid> CREATOR = new ByteArrayCreator<CosineOfTheAngleAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CosineOfTheAngleAndroid createFromParcel(@NonNull Parcel in) {
            return new CosineOfTheAngleAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CosineOfTheAngleAndroid[] newArray(int size) {
            return new CosineOfTheAngleAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CosineOfTheAngleAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(COSINE_OF_THE_ANGLE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CosineOfTheAngleAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B8D
     */
    public CosineOfTheAngleAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CosineOfTheAngleAndroid(@NonNull Parcel in) {
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
