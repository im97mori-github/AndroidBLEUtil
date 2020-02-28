package org.im97mori.ble.characteristic.u2a8f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HIP_CIRCUMFERENCE_CHARACTERISTIC;

/**
 * Hip Circumference (Characteristics UUID: 0x2A8F)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HipCircumferenceAndroid extends HipCircumference implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HipCircumferenceAndroid> CREATOR = new ByteArrayCreater<HipCircumferenceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HipCircumferenceAndroid createFromParcel(@NonNull Parcel in) {
            return new HipCircumferenceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HipCircumferenceAndroid[] newArray(int size) {
            return new HipCircumferenceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HipCircumferenceAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HipCircumferenceAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A8F
     */
    public HipCircumferenceAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private HipCircumferenceAndroid(@NonNull Parcel in) {
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
