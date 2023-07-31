package org.im97mori.ble.characteristic.u2a6b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * LN Control Point (Characteristics UUID: 0x2A6B)
 */
@SuppressWarnings({"WeakerAccess"})
public class LNControlPointAndroid extends LNControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LNControlPointAndroid> CREATOR = new ByteArrayCreator<LNControlPointAndroid>() {

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
            return new LNControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A6B
     */
    @Deprecated
    public LNControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LNControlPointAndroid(@NonNull byte[] values) {
        super(values);
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
