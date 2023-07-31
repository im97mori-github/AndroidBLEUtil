package org.im97mori.ble.characteristic.u2aac;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * CGM Specific Ops Control Point (Characteristics UUID: 0x2AAC)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CgmSpecificOpsControlPointAndroid extends CgmSpecificOpsControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CgmSpecificOpsControlPointAndroid> CREATOR = new ByteArrayCreator<CgmSpecificOpsControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CgmSpecificOpsControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new CgmSpecificOpsControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CgmSpecificOpsControlPointAndroid[] newArray(int size) {
            return new CgmSpecificOpsControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CgmSpecificOpsControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new CgmSpecificOpsControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AAC
     */
    @Deprecated
    public CgmSpecificOpsControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CgmSpecificOpsControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CgmSpecificOpsControlPointAndroid(@NonNull Parcel in) {
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
