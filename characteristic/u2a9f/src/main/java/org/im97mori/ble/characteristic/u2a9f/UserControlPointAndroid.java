package org.im97mori.ble.characteristic.u2a9f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * User Control Point (Characteristics UUID: 0x2A9F)
 */
@SuppressWarnings({"WeakerAccess"})
public class UserControlPointAndroid extends UserControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<UserControlPointAndroid> CREATOR = new ByteArrayCreator<UserControlPointAndroid>() {

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
            return new UserControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A95
     */
    @Deprecated
    public UserControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public UserControlPointAndroid(@NonNull byte[] values) {
        super(values);
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
