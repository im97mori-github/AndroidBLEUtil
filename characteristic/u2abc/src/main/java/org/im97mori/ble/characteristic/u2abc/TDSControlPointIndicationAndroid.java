package org.im97mori.ble.characteristic.u2abc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * TDS Control Point Indication (Characteristics UUID: 0x2ABC)
 */
@SuppressWarnings({"WeakerAccess"})
public class TDSControlPointIndicationAndroid extends TDSControlPointIndication implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TDSControlPointIndicationAndroid> CREATOR = new ByteArrayCreator<TDSControlPointIndicationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TDSControlPointIndicationAndroid createFromParcel(@NonNull Parcel in) {
            return new TDSControlPointIndicationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TDSControlPointIndicationAndroid[] newArray(int size) {
            return new TDSControlPointIndicationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TDSControlPointIndicationAndroid createFromByteArray(@NonNull byte[] values) {
            return new TDSControlPointIndicationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ABC
     */
    @Deprecated
    public TDSControlPointIndicationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TDSControlPointIndicationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param requestedOpCode   Requested Op Code
     * @param resultCode        Result Code
     * @param responseParameter Response Parameter
     */
    public TDSControlPointIndicationAndroid(int requestedOpCode, int resultCode, @NonNull byte[] responseParameter) {
        super(requestedOpCode, resultCode, responseParameter);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TDSControlPointIndicationAndroid(@NonNull Parcel in) {
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
