package org.im97mori.ble;

import androidx.annotation.NonNull;

@SuppressWarnings("unused")
public interface ByteArrayInterface {

    /**
     * Create byte array for {@link android.bluetooth.BluetoothGattCharacteristic#setValue(byte[])} or {@link android.bluetooth.BluetoothGattDescriptor#setValue(byte[])}
     *
     * @return byte array
     */
    @NonNull
    byte[] getBytes();

}
