package org.im97mori.ble.characteristic.u2a40;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Ringer Control point (Characteristics UUID: 0x2A40)
 */
@SuppressWarnings({"WeakerAccess"})
public class RingerControlPointAndroid extends RingerControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RingerControlPointAndroid> CREATOR = new ByteArrayCreator<RingerControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RingerControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new RingerControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RingerControlPointAndroid[] newArray(int size) {
            return new RingerControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RingerControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new RingerControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A40
     */
    @Deprecated
    public RingerControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RingerControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param ringerControlPoint Ringer Control Point
     */
    public RingerControlPointAndroid(int ringerControlPoint) {
        super(ringerControlPoint);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RingerControlPointAndroid(@NonNull Parcel in) {
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
