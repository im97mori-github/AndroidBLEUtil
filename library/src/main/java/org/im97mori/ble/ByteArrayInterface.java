package org.im97mori.ble;

public interface ByteArrayInterface {

    /**
     * Create byte array for {@link android.bluetooth.BluetoothGattCharacteristic#setValue(byte[])} or {@link android.bluetooth.BluetoothGattDescriptor#setValue(byte[])}
     *
     * @return byte array
     */
    byte[] getBytes();

}
