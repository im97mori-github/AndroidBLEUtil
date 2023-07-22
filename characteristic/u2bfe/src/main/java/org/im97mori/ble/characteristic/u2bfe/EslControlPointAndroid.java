package org.im97mori.ble.characteristic.u2bfe;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ESL_CONTROL_POINT_CHARACTERISTIC;

/**
 * ESL Control Point (Characteristics UUID: 0x2BFE)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class EslControlPointAndroid extends EslControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EslControlPointAndroid> CREATOR = new ByteArrayCreator<EslControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EslControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new EslControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EslControlPointAndroid[] newArray(int size) {
            return new EslControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EslControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ESL_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new EslControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BFE
     */
    public EslControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EslControlPointAndroid(@NonNull Parcel in) {
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
