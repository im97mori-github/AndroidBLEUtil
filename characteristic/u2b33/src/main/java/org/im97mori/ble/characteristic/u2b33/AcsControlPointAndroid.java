package org.im97mori.ble.characteristic.u2b33;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ACS_CONTROL_POINT_CHARACTERISTIC;

/**
 * ACS Control Point (Characteristics UUID: 0x2B33)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AcsControlPointAndroid extends AcsControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AcsControlPointAndroid> CREATOR = new ByteArrayCreator<AcsControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AcsControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new AcsControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AcsControlPointAndroid[] newArray(int size) {
            return new AcsControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AcsControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ACS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AcsControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B33
     */
    public AcsControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AcsControlPointAndroid(@NonNull Parcel in) {
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
