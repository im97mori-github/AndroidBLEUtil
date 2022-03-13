package org.im97mori.ble.characteristic.u2bc7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.BROADCAST_AUDIO_SCAN_CONTROL_POINT_CHARACTERISTIC;

/**
 * Broadcast Audio Scan Control Point  (Characteristics UUID: 0x2BC7)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BroadcastAudioScanControlPointAndroid extends BroadcastAudioScanControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BroadcastAudioScanControlPointAndroid> CREATOR = new ByteArrayCreator<BroadcastAudioScanControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BroadcastAudioScanControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new BroadcastAudioScanControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BroadcastAudioScanControlPointAndroid[] newArray(int size) {
            return new BroadcastAudioScanControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BroadcastAudioScanControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BROADCAST_AUDIO_SCAN_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BroadcastAudioScanControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC7
     */
    public BroadcastAudioScanControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BroadcastAudioScanControlPointAndroid(@NonNull Parcel in) {
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
