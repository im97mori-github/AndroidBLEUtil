package org.im97mori.ble.characteristic.u2b1f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Reconnection Configuration Control Point (Characteristics UUID: 0x2B1F)
 */

@SuppressWarnings("WeakerAccess")
public class ReconnectionConfigurationControlPointAndroid extends ReconnectionConfigurationControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ReconnectionConfigurationControlPointAndroid> CREATOR = new ByteArrayCreator<ReconnectionConfigurationControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionConfigurationControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new ReconnectionConfigurationControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionConfigurationControlPointAndroid[] newArray(int size) {
            return new ReconnectionConfigurationControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ReconnectionConfigurationControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new ReconnectionConfigurationControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B1F
     */
    @Deprecated
    public ReconnectionConfigurationControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ReconnectionConfigurationControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param opcode          Opcode
     * @param operand         Operand
     * @param e2eCrc          E2E-CRC
     * @param requestOpcodes  Request Opcode
     * @param resultCode      Result Codes
     * @param resultParameter Result Parameter
     */
    public ReconnectionConfigurationControlPointAndroid(int opcode, @NonNull byte[] operand, @Nullable Integer e2eCrc, int requestOpcodes, int resultCode, @NonNull byte[] resultParameter) {
        super(opcode, operand, e2eCrc, requestOpcodes, resultCode, resultParameter);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ReconnectionConfigurationControlPointAndroid(@NonNull Parcel in) {
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
