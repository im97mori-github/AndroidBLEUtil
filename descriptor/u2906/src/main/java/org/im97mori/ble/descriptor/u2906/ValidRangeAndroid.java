package org.im97mori.ble.descriptor.u2906;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;

/**
 * Valid Range (Descriptor UUID: 0x2906)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ValidRangeAndroid extends ValidRange implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ValidRangeAndroid> CREATOR = new ByteArrayCreater<ValidRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ValidRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new ValidRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ValidRangeAndroid[] newArray(int size) {
            return new ValidRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ValidRangeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new ValidRangeAndroid(bluetoothGattDescriptor);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2906
     */
    public ValidRangeAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param lowerInclusiveValue Lower inclusive value
     * @param upperInclusiveValue Upper inclusive value
     */
    public ValidRangeAndroid(@NonNull byte[] lowerInclusiveValue, @NonNull byte[] upperInclusiveValue) {
        super(lowerInclusiveValue, upperInclusiveValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private ValidRangeAndroid(@NonNull Parcel in) {
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
