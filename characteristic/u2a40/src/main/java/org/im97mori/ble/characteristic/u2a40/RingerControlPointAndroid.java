package org.im97mori.ble.characteristic.u2a40;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.RINGER_CONTROL_POINT_CHARACTERISTIC;

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RINGER_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RingerControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A40
     */
    public RingerControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
