package org.im97mori.ble.characteristic.u2a9c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC;

/**
 * Body Composition Measurement packet (Characteristics UUID: 0x2A9C)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BodyCompositionMeasurementPacketAndroid extends BodyCompositionMeasurementPacket implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BodyCompositionMeasurementPacketAndroid> CREATOR = new ByteArrayCreater<BodyCompositionMeasurementPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionMeasurementPacketAndroid createFromParcel(@NonNull Parcel in) {
            return new BodyCompositionMeasurementPacketAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionMeasurementPacketAndroid[] newArray(int size) {
            return new BodyCompositionMeasurementPacketAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BodyCompositionMeasurementPacketAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A9C
     */
    public BodyCompositionMeasurementPacketAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private BodyCompositionMeasurementPacketAndroid(@NonNull Parcel in) {
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
