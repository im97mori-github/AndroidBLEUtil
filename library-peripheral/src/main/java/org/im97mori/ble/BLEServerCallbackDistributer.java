package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * BLEServerCallback wrapper for distribute
 */
@SuppressWarnings({"WeakerAccess"})
public class BLEServerCallbackDistributer implements BLEServerCallback {

    /**
     * Subscriber interface
     */
    public interface SubscriberInterface {

        /**
         * get Subscriber's callback instance {@link List}
         * must thread safe
         *
         * @return Subscriber's callback instance {@link List}
         */
        List<BLEServerCallback> getSubscriberCallbackList();
    }

    /**
     * wrap original argument
     *
     * @param argument          original argument
     * @param bleServerCallback callback instance for get callback id
     * @return wrapped argument(original argument and callback id)
     */
    @NonNull
    public static Bundle wrapArgument(@Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
        Bundle wrap = new Bundle();
        if (bleServerCallback != null) {
            wrap.putInt(KEY_CALLBACK_ID, bleServerCallback.hashCode());
        }
        if (argument != null) {
            wrap.putBundle(KEY_WRAPPED_ARGUMENT, argument);
        }
        return wrap;
    }

    /**
     * KEY:CALLBACK_ID
     */
    public static final String KEY_CALLBACK_ID = "KEY_CALLBACK_ID";

    /**
     * KEY:WRAPPED_ARGUMENT
     */
    public static final String KEY_WRAPPED_ARGUMENT = "KEY_WRAPPED_ARGUMENT";

    /**
     * {@link SubscriberInterface}
     */
    protected final SubscriberInterface mSubscriberInterface;

    /**
     * @param subscriberInterface {@link SubscriberInterface}
     */
    public BLEServerCallbackDistributer(@NonNull SubscriberInterface subscriberInterface) {
        mSubscriberInterface = subscriberInterface;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServerStarted() {
        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                bleServerCallback.onServerStarted();
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServerStopped() {
        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                bleServerCallback.onServerStopped();
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDeviceConnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {
        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                bleServerCallback.onDeviceConnected(bleServerConnection, device);
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDeviceDisconnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {
        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                bleServerCallback.onDeviceDisconnected(bleServerConnection, device);
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onServiceAddSuccess(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattService bluetoothGattService
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        boolean result = false;

        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                if (callbackId == null) {
                    result |= bleServerCallback.onServiceAddSuccess(taskId, bleServerConnection, bluetoothGattService, originalArgument);
                } else if (bleServerCallback.hashCode() == callbackId) {
                    result = bleServerCallback.onServiceAddSuccess(taskId, bleServerConnection, bluetoothGattService, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddFailed(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattService bluetoothGattService
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                if (callbackId == null) {
                    bleServerCallback.onServiceAddFailed(taskId, bleServerConnection, bluetoothGattService, status, originalArgument);
                } else if (bleServerCallback.hashCode() == callbackId) {
                    bleServerCallback.onServiceAddFailed(taskId, bleServerConnection, bluetoothGattService, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddTimeout(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattService bluetoothGattService
            , long timeout
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                if (callbackId == null) {
                    bleServerCallback.onServiceAddTimeout(taskId, bleServerConnection, bluetoothGattService, timeout, originalArgument);
                } else if (bleServerCallback.hashCode() == callbackId) {
                    bleServerCallback.onServiceAddTimeout(taskId, bleServerConnection, bluetoothGattService, timeout, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveSuccess(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattService bluetoothGattService
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                if (callbackId == null) {
                    bleServerCallback.onServiceRemoveSuccess(taskId, bleServerConnection, bluetoothGattService, originalArgument);
                } else if (bleServerCallback.hashCode() == callbackId) {
                    bleServerCallback.onServiceRemoveSuccess(taskId, bleServerConnection, bluetoothGattService, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveFailed(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattService bluetoothGattService
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                if (callbackId == null) {
                    bleServerCallback.onServiceRemoveFailed(taskId, bleServerConnection, bluetoothGattService, status, originalArgument);
                } else if (bleServerCallback.hashCode() == callbackId) {
                    bleServerCallback.onServiceRemoveFailed(taskId, bleServerConnection, bluetoothGattService, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveTimeout(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattService bluetoothGattService
            , long timeout
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                if (callbackId == null) {
                    bleServerCallback.onServiceRemoveTimeout(taskId, bleServerConnection, bluetoothGattService, timeout, originalArgument);
                } else if (bleServerCallback.hashCode() == callbackId) {
                    bleServerCallback.onServiceRemoveTimeout(taskId, bleServerConnection, bluetoothGattService, timeout, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCharacteristicReadRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , int offset
            , @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic
            , boolean force) {
        boolean result = false;

        List<BLEServerCallback> handleUnregisteredServiceCallbackList = new LinkedList<>();
        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                result = bleServerCallback.onCharacteristicReadRequest(bleServerConnection, device, requestId, offset, bluetoothGattCharacteristic, false);
                if (result) {
                    break;
                } else if (bleServerCallback.isFallback()) {
                    handleUnregisteredServiceCallbackList.add(bleServerCallback);
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
        if (!result && force) {
            for (BLEServerCallback bleServerCallback : handleUnregisteredServiceCallbackList) {
                try {
                    if (bleServerCallback.isFallback()) {
                        result = bleServerCallback.onCharacteristicReadRequest(bleServerConnection, device, requestId, offset, bluetoothGattCharacteristic, true);
                        if (result) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    BLEPeripheralLogUtils.stackLog(e);
                }
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic
            , boolean preparedWrite
            , boolean responseNeeded
            , int offset
            , @NonNull byte[] value
            , boolean force) {
        boolean result = false;

        List<BLEServerCallback> handleUnregisteredServiceCallbackList = new LinkedList<>();
        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                result = bleServerCallback.onCharacteristicWriteRequest(bleServerConnection, device, requestId, bluetoothGattCharacteristic, preparedWrite, responseNeeded, offset, value, false);
                if (result) {
                    break;
                } else if (bleServerCallback.isFallback()) {
                    handleUnregisteredServiceCallbackList.add(bleServerCallback);
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
        if (!result && force) {
            for (BLEServerCallback bleServerCallback : handleUnregisteredServiceCallbackList) {
                try {
                    if (bleServerCallback.isFallback()) {
                        result = bleServerCallback.onCharacteristicWriteRequest(bleServerConnection, device, requestId, bluetoothGattCharacteristic, preparedWrite, responseNeeded, offset, value, true);
                        if (result) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    BLEPeripheralLogUtils.stackLog(e);
                }
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onDescriptorReadRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, boolean force) {
        boolean result = false;

        List<BLEServerCallback> handleUnregisteredServiceCallbackList = new LinkedList<>();
        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                result = bleServerCallback.onDescriptorReadRequest(bleServerConnection, device, requestId, offset, bluetoothGattDescriptor, false);
                if (result) {
                    break;
                } else if (bleServerCallback.isFallback()) {
                    handleUnregisteredServiceCallbackList.add(bleServerCallback);
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
        if (!result && force) {
            for (BLEServerCallback bleServerCallback : handleUnregisteredServiceCallbackList) {
                try {
                    if (bleServerCallback.isFallback()) {
                        result = bleServerCallback.onDescriptorReadRequest(bleServerConnection, device, requestId, offset, bluetoothGattDescriptor, true);
                        if (result) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    BLEPeripheralLogUtils.stackLog(e);
                }
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onDescriptorWriteRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , @NonNull BluetoothGattDescriptor bluetoothGattDescriptor
            , boolean preparedWrite
            , boolean responseNeeded
            , int offset
            , @NonNull byte[] value
            , boolean force) {
        boolean result = false;

        List<BLEServerCallback> handleUnregisteredServiceCallbackList = new LinkedList<>();
        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                result = bleServerCallback.onDescriptorWriteRequest(bleServerConnection, device, requestId, bluetoothGattDescriptor, preparedWrite, responseNeeded, offset, value, false);
                if (result) {
                    break;
                } else if (bleServerCallback.isFallback()) {
                    handleUnregisteredServiceCallbackList.add(bleServerCallback);
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
        if (!result && force) {
            for (BLEServerCallback bleServerCallback : handleUnregisteredServiceCallbackList) {
                try {
                    if (bleServerCallback.isFallback()) {
                        result = bleServerCallback.onDescriptorWriteRequest(bleServerConnection, device, requestId, bluetoothGattDescriptor, preparedWrite, responseNeeded, offset, value, true);
                        if (result) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    BLEPeripheralLogUtils.stackLog(e);
                }
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onNotificationSuccess(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , @NonNull byte[] value
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                if (callbackId == null) {
                    bleServerCallback.onNotificationSuccess(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, value, originalArgument);
                } else if (bleServerCallback.hashCode() == callbackId) {
                    bleServerCallback.onNotificationSuccess(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, value, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onNotificationFailed(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                if (callbackId == null) {
                    bleServerCallback.onNotificationFailed(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, originalArgument);
                } else if (bleServerCallback.hashCode() == callbackId) {
                    bleServerCallback.onNotificationFailed(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onNotificationTimeout(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , long timeout
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                if (callbackId == null) {
                    bleServerCallback.onNotificationTimeout(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, originalArgument);
                } else if (bleServerCallback.hashCode() == callbackId) {
                    bleServerCallback.onNotificationTimeout(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onExecuteWrite(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , boolean execute
            , boolean force) {
        boolean result = false;
        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                result = bleServerCallback.onExecuteWrite(bleServerConnection, device, requestId, execute, false);
                if (result) {
                    break;
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
        if (!result && force) {
            for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
                try {
                    if (bleServerCallback.isFallback()) {
                        result = bleServerCallback.onExecuteWrite(bleServerConnection, device, requestId, execute, true);
                        if (result) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    BLEPeripheralLogUtils.stackLog(e);
                }
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                bleServerCallback.onAdvertisingStartSuccess(advertiseSettings);
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param errorCode
     */
    @Override
    public void onAdvertisingStartFailed(Integer errorCode) {
        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                bleServerCallback.onAdvertisingStartFailed(errorCode);
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingFinished() {
        for (BLEServerCallback bleServerCallback : mSubscriberInterface.getSubscriberCallbackList()) {
            try {
                bleServerCallback.onAdvertisingFinished();
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setup(@NonNull BLEServerConnection bleServerConnection) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void tearDown(@NonNull BLEServerConnection bleServerConnection) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFallback() {
        return false;
    }

}
