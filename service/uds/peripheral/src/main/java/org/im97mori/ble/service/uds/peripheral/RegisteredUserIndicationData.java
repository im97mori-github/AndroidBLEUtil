package org.im97mori.ble.service.uds.peripheral;

import android.bluetooth.BluetoothDevice;

import androidx.annotation.NonNull;

/**
 * list all users indication data class
 */
public class RegisteredUserIndicationData {

    /**
     * request id for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 2nd parameter
     */
    public final int requestId;

    /**
     * offset for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 4th parameter
     */
    public final int offset;

    /**
     * return value for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
     */
    public final byte[] returnValue;

    /**
     * timeout duration
     */
    public final long timeout;

    /**
     * indication count
     */
    public final int count;

    /**
     * indicated count
     */
    public int indicatedCount;

    /**
     * @param requestId   request id for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 2nd parameter
     * @param offset      offset for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 4th parameter
     * @param returnValue return value for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
     * @param timeout     timeout duration
     * @param count       indication count
     */
    RegisteredUserIndicationData(int requestId, int offset, @NonNull byte[] returnValue, long timeout, int count) {
        this.requestId = requestId;
        this.offset = offset;
        this.returnValue = returnValue;
        this.timeout = timeout;
        this.count = count;
    }

}
