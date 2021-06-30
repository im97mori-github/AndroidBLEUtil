package org.im97mori.ble.characteristic.u2a34;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.GLUCOSE_MEASUREMENT_CONTEXT_CHARACTERISTIC;

/**
 * Glucose Measurement Context (Characteristics UUID: 0x2A34)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class GlucoseMeasurementContextAndroid extends GlucoseMeasurementContext implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<GlucoseMeasurementContextAndroid> CREATOR = new ByteArrayCreater<GlucoseMeasurementContextAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GlucoseMeasurementContextAndroid createFromParcel(@NonNull Parcel in) {
            return new GlucoseMeasurementContextAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GlucoseMeasurementContextAndroid[] newArray(int size) {
            return new GlucoseMeasurementContextAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GlucoseMeasurementContextAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GLUCOSE_MEASUREMENT_CONTEXT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new GlucoseMeasurementContextAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A34
     */
    public GlucoseMeasurementContextAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private GlucoseMeasurementContextAndroid(@NonNull Parcel in) {
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
