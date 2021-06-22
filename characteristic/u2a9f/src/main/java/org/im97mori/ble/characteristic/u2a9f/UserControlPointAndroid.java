package org.im97mori.ble.characteristic.u2a9f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.USER_CONTROL_POINT_CHARACTERISTIC;

/**
 * User Control Point (Characteristics UUID: 0x2A9F)
 */
@SuppressWarnings({"WeakerAccess"})
public class UserControlPointAndroid extends UserControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<UserControlPointAndroid> CREATOR = new ByteArrayCreater<UserControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new UserControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserControlPointAndroid[] newArray(int size) {
            return new UserControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public UserControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(USER_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new UserControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A95
     */
    public UserControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param opCode        Op Code
     * @param userIndex     User Index
     * @param consentCode   Consent Code
     * @param requestOpCode Request Op Code
     * @param responseValue Response Value
     * @param numberOfUsers Number of users
     */
    public UserControlPointAndroid(int opCode, int userIndex, int consentCode, int requestOpCode, int responseValue, int numberOfUsers) {
        super(opCode, userIndex, consentCode, requestOpCode, responseValue, numberOfUsers);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UserControlPointAndroid(@NonNull Parcel in) {
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
