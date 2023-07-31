package org.im97mori.ble.characteristic.u2ac5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * object action control point (Characteristics UUID: 0x2AC5)
 */
@SuppressWarnings({"WeakerAccess"})
public class ObjectActionControlPointAndroid extends ObjectActionControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ObjectActionControlPointAndroid> CREATOR = new ByteArrayCreator<ObjectActionControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectActionControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new ObjectActionControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectActionControlPointAndroid[] newArray(int size) {
            return new ObjectActionControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ObjectActionControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new ObjectActionControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AC5
     */
    @Deprecated
    public ObjectActionControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ObjectActionControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param opCode            Op Code
     * @param size              Size
     * @param type              Type
     * @param offset            Offset
     * @param length            Length
     * @param parameter         Parameter
     * @param mode              Mode
     * @param requestOpCode     Request Op Code
     * @param resultCode        Result Code
     * @param checksum          Checksum
     * @param responseParameter Response Parameter
     */
    public ObjectActionControlPointAndroid(int opCode, long size, @NonNull byte[] type, long offset, long length,
                                           @NonNull byte[] parameter, int mode, int requestOpCode, int resultCode, int checksum,
                                           @NonNull byte[] responseParameter) {
        super(opCode, size, type, offset, length, parameter, mode, requestOpCode, resultCode, checksum, responseParameter);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ObjectActionControlPointAndroid(@NonNull Parcel in) {
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
