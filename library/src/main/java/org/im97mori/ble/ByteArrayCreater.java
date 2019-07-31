package org.im97mori.ble;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcelable;

/**
 * Byte array Creator
 *
 * @param <T> T must have constructor with {@link BluetoothGattCharacteristic}
 */
public interface ByteArrayCreater<T> extends Parcelable.Creator<T> {

    /**
     * Create instance from byte array
     *
     * @param values from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @return {@link T} instance
     */
    T createFromByteArray(byte[] values);

}
