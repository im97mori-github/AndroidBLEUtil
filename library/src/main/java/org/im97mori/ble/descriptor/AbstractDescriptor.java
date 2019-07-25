package org.im97mori.ble.descriptor;

/**
 * Descriptor base class
 */
public abstract class AbstractDescriptor {

    /**
     * Create byte array for {@link android.bluetooth.BluetoothGattDescriptor#setValue(byte[])}
     *
     * @return byte array
     */
    public abstract byte[] getBytes();

}
