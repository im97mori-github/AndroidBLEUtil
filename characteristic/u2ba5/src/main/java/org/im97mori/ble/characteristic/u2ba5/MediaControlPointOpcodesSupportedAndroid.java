package org.im97mori.ble.characteristic.u2ba5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.MEDIA_CONTROL_POINT_OPCODES_SUPPORTED_CHARACTERISTIC;

/**
 * Media Control Point Opcodes Supported (Characteristics UUID: 0x2BA5)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class MediaControlPointOpcodesSupportedAndroid extends MediaControlPointOpcodesSupported implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MediaControlPointOpcodesSupportedAndroid> CREATOR = new ByteArrayCreater<MediaControlPointOpcodesSupportedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MediaControlPointOpcodesSupportedAndroid createFromParcel(@NonNull Parcel in) {
            return new MediaControlPointOpcodesSupportedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MediaControlPointOpcodesSupportedAndroid[] newArray(int size) {
            return new MediaControlPointOpcodesSupportedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MediaControlPointOpcodesSupportedAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MEDIA_CONTROL_POINT_OPCODES_SUPPORTED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MediaControlPointOpcodesSupportedAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BA5
     */
    public MediaControlPointOpcodesSupportedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MediaControlPointOpcodesSupportedAndroid(@NonNull Parcel in) {
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
