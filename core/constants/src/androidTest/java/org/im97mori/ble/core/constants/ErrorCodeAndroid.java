package org.im97mori.ble.core.constants;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

import org.im97mori.ble.constants.ErrorCode;

/**
 * Error Code
 */
public class ErrorCodeAndroid extends ErrorCode {

    /**
     * error in task
     */
    public static final int UNKNOWN = 0xffffffff;

    /**
     * task canceled
     */
    public static final int CANCEL = 0xfffffffe;

    /**
     * error at read / write
     *
     * @see android.bluetooth.BluetoothGatt#readCharacteristic(BluetoothGattCharacteristic)
     * @see android.bluetooth.BluetoothGatt#writeCharacteristic(BluetoothGattCharacteristic)
     * @see android.bluetooth.BluetoothGatt#readDescriptor(BluetoothGattDescriptor)
     * @see android.bluetooth.BluetoothGatt#writeDescriptor(BluetoothGattDescriptor)
     */
    public static final int BUSY = 0xfffffffd;

}
