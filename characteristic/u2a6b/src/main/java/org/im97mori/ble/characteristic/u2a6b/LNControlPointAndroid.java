package org.im97mori.ble.characteristic.u2a6b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LN_CONTROL_POINT_CHARACTERISTIC;

/**
 * LN Control Point (Characteristics UUID: 0x2A6B)
 */
@SuppressWarnings({"WeakerAccess"})
public class LNControlPointAndroid extends LNControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LNControlPointAndroid> CREATOR = new ByteArrayCreater<LNControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LNControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new LNControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LNControlPointAndroid[] newArray(int size) {
            return new LNControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LNControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LN_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LNControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A6B
     */
    public LNControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param opCodes           Op Codes
     * @param parameterValue    Parameter Value
     * @param requestOpCode     Request Op Code
     * @param responseValue     Response Value
     * @param responseParameter Response Parameter
     */
    public LNControlPointAndroid(int opCodes, @NonNull byte[] parameterValue, int requestOpCode, int responseValue, @NonNull byte[] responseParameter) {
        super(opCodes, parameterValue, requestOpCode, responseValue, responseParameter);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LNControlPointAndroid(@NonNull Parcel in) {
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
