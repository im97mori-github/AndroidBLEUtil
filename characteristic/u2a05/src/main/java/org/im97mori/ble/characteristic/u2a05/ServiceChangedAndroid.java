package org.im97mori.ble.characteristic.u2a05;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SERVICE_CHANGED_CHARACTERISTIC;

/**
 * Service Changed (Characteristics UUID: 0x2A05)
 */
@SuppressWarnings({"WeakerAccess"})
public class ServiceChangedAndroid extends ServiceChanged implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ServiceChangedAndroid> CREATOR = new ByteArrayCreater<ServiceChangedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceChangedAndroid createFromParcel(@NonNull Parcel in) {
            return new ServiceChangedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceChangedAndroid[] newArray(int size) {
            return new ServiceChangedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ServiceChangedAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SERVICE_CHANGED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ServiceChangedAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A05
     */
    public ServiceChangedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param startOfAffectedAttributeHandleRange Start of Affected Attribute Handle Range
     * @param endOfAffectedAttributeHandleRange   End of Affected Attribute Handle Range
     */
    public ServiceChangedAndroid(int startOfAffectedAttributeHandleRange, int endOfAffectedAttributeHandleRange) {
        super(startOfAffectedAttributeHandleRange, endOfAffectedAttributeHandleRange);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private ServiceChangedAndroid(@NonNull Parcel in) {
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
