package org.im97mori.ble.characteristic.u2afa;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.GLOBAL_TRADE_ITEM_NUMBER_CHARACTERISTIC;

/**
 * Global Trade Item Number (Characteristics UUID: 0x2AFA)
 */
@SuppressWarnings({"WeakerAccess"})
public class GlobalTradeItemNumberAndroid extends GlobalTradeItemNumber implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<GlobalTradeItemNumberAndroid> CREATOR = new ByteArrayCreator<GlobalTradeItemNumberAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GlobalTradeItemNumberAndroid createFromParcel(@NonNull Parcel in) {
            return new GlobalTradeItemNumberAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GlobalTradeItemNumberAndroid[] newArray(int size) {
            return new GlobalTradeItemNumberAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GlobalTradeItemNumberAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GLOBAL_TRADE_ITEM_NUMBER_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new GlobalTradeItemNumberAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AFA
     */
    public GlobalTradeItemNumberAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param globalTradeItemNumber Global Trade Item Number
     */
    public GlobalTradeItemNumberAndroid(long globalTradeItemNumber) {
        super(globalTradeItemNumber);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private GlobalTradeItemNumberAndroid(@NonNull Parcel in) {
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
