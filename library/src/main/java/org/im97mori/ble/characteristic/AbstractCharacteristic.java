package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;

/**
 * Characteristic base class
 */
public abstract class AbstractCharacteristic {

    /**
     * Create byte array for {@link BluetoothGattCharacteristic#setValue(byte[])}
     *
     * @return byte array
     */
    public abstract byte[] getBytes();

}
