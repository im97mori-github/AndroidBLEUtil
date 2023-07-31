package org.im97mori.ble;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * Byte array Creator
 *
 * @param <T> T must have constructor with {@link BluetoothGattCharacteristic}
 * @noinspection unused
 */
public interface ByteArrayCreator<T> extends Parcelable.Creator<T> {

    /**
     * Create instance from byte array
     *
     * @param values from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @return T instance
     */
    @NonNull
    T createFromByteArray(@NonNull byte[] values);

}
