package org.im97mori.ble.characteristic.u2b8d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

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
            return new CosineOfTheAngleAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B8D
     */
    @Deprecated
    public CosineOfTheAngleAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CosineOfTheAngleAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CosineOfTheAngleAndroid(@NonNull Parcel in) {
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
