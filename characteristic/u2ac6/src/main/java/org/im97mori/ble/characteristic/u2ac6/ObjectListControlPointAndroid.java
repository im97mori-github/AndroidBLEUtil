package org.im97mori.ble.characteristic.u2ac6;

import static org.im97mori.ble.constants.CharacteristicUUID.OBJECT_LIST_CONTROL_POINT_CHARACTERISTIC;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

/**
 * object list control point (Characteristics UUID: 0x2AC6)
 */
@SuppressWarnings({"WeakerAccess"})
public class ObjectListControlPointAndroid extends ObjectListControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ObjectListControlPointAndroid> CREATOR = new ByteArrayCreator<ObjectListControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectListControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new ObjectListControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectListControlPointAndroid[] newArray(int size) {
            return new ObjectListControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ObjectListControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(OBJECT_LIST_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ObjectListControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AC6
     */
    public ObjectListControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param opCode               Op Code
     * @param objectId             Object ID
     * @param listSortOrder        List Sort Order
     * @param requestOpCode        Request Op Code
     * @param resultCode           Result Code
     * @param totalNumberOfObjects Total Number of Objects
     */
    public ObjectListControlPointAndroid(int opCode, long objectId, int listSortOrder, int requestOpCode, int resultCode,
                                         int totalNumberOfObjects) {
        super(opCode, objectId, listSortOrder, requestOpCode, resultCode, totalNumberOfObjects);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ObjectListControlPointAndroid(@NonNull Parcel in) {
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
