package org.im97mori.ble.characteristic.u2bbc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Incoming Call Target Bearer URI (Characteristics UUID: 0x2BBC)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IncomingCallTargetBearerUriAndroid extends IncomingCallTargetBearerUri implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IncomingCallTargetBearerUriAndroid> CREATOR = new ByteArrayCreator<IncomingCallTargetBearerUriAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IncomingCallTargetBearerUriAndroid createFromParcel(@NonNull Parcel in) {
            return new IncomingCallTargetBearerUriAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IncomingCallTargetBearerUriAndroid[] newArray(int size) {
            return new IncomingCallTargetBearerUriAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IncomingCallTargetBearerUriAndroid createFromByteArray(@NonNull byte[] values) {
            return new IncomingCallTargetBearerUriAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BBC
     */
    @Deprecated
    public IncomingCallTargetBearerUriAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public IncomingCallTargetBearerUriAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IncomingCallTargetBearerUriAndroid(@NonNull Parcel in) {
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
