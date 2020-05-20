package org.im97mori.ble.characteristic.u2abc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TDS_CONTROL_POINT_CHARACTERISTIC;

/**
 * TDS Control Point Indication (Characteristics UUID: 0x2ABC)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TDSControlPointIndicationAndroid extends TDSControlPointIndication implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TDSControlPointIndicationAndroid> CREATOR = new ByteArrayCreater<TDSControlPointIndicationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TDSControlPointIndicationAndroid createFromParcel(@NonNull Parcel in) {
            return new TDSControlPointIndicationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TDSControlPointIndicationAndroid[] newArray(int size) {
            return new TDSControlPointIndicationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TDSControlPointIndicationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TDSControlPointIndicationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ABC
     */
    public TDSControlPointIndicationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param requestedOpCode   Requested Op Code
     * @param resultCode        Result Code
     * @param responseParameter Response Parameter
     */
    public TDSControlPointIndicationAndroid(int requestedOpCode, int resultCode, @NonNull byte[] responseParameter) {
        super(requestedOpCode, resultCode, responseParameter);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private TDSControlPointIndicationAndroid(@NonNull Parcel in) {
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
