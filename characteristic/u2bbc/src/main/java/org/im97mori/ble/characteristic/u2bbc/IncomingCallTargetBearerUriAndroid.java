package org.im97mori.ble.characteristic.u2bbc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.INCOMING_CALL_TARGET_BEARER_URI_CHARACTERISTIC;

/**
 * Incoming Call Target Bearer URI (Characteristics UUID: 0x2BBC)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IncomingCallTargetBearerUriAndroid extends IncomingCallTargetBearerUri implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IncomingCallTargetBearerUriAndroid> CREATOR = new ByteArrayCreater<IncomingCallTargetBearerUriAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INCOMING_CALL_TARGET_BEARER_URI_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IncomingCallTargetBearerUriAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BBC
     */
    public IncomingCallTargetBearerUriAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IncomingCallTargetBearerUriAndroid(@NonNull Parcel in) {
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
