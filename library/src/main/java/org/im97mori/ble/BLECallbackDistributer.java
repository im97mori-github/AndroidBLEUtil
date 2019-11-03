package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * BLECallback wrapper for distribute
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BLECallbackDistributer implements BLECallback {

    /**
     * Subscriber interface
     */
    public interface SubscriberInterface {

        /**
         * get Subscriber's callback instance {@link Set}
         * must thread safe
         *
         * @return Subscriber's callback instance {@link Set}
         */
        Set<BLECallback> getSubscriberCallbackSet();
    }

    /**
     * wrap original argument
     *
     * @param argument    original argument
     * @param bleCallback callback instance for get callback id
     * @return wrapped argument(original argument and callback id)
     */
    @NonNull
    public static Bundle wrapArgument(@Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Bundle wrap = new Bundle();
        if (bleCallback != null) {
            wrap.putInt(KEY_CALLBACK_ID, bleCallback.hashCode());
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
    public BLECallbackDistributer(@NonNull SubscriberInterface subscriberInterface) {
        mSubscriberInterface = subscriberInterface;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onBLEConnected(taskId, bluetoothDevice, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onBLEConnected(taskId, bluetoothDevice, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onBLEConnectFailed(taskId, bluetoothDevice, status, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onBLEConnectFailed(taskId, bluetoothDevice, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onBLEConnectTimeout(taskId, bluetoothDevice, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onBLEConnectTimeout(taskId, bluetoothDevice, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onBLEDisconnected(taskId, bluetoothDevice, status, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onBLEDisconnected(taskId, bluetoothDevice, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDiscoverServiceFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onDiscoverServiceFailed(taskId, bluetoothDevice, status, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onDiscoverServiceFailed(taskId, bluetoothDevice, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDiscoverServiceTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onDiscoverServiceTimeout(taskId, bluetoothDevice, timeout, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onDiscoverServiceTimeout(taskId, bluetoothDevice, timeout, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onRequestMtuSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int mtu, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onRequestMtuSuccess(taskId, bluetoothDevice, mtu, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onRequestMtuSuccess(taskId, bluetoothDevice, mtu, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onRequestMtuFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onRequestMtuFailed(taskId, bluetoothDevice, status, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onRequestMtuFailed(taskId, bluetoothDevice, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onRequestMtuTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onRequestMtuTimeout(taskId, bluetoothDevice, timeout, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onRequestMtuTimeout(taskId, bluetoothDevice, timeout, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, values, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, values, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, status, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, timeout, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, timeout, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, values, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, values, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, status, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, timeout, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, timeout, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, values, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, values, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, status, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, timeout, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, timeout, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, values, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, values, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, status, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, timeout, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, timeout, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values) {
        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                bleCallback.onCharacteristicNotified(bluetoothDevice, serviceUUID, characteristicUUID, values);
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onReadPhySuccess(taskId, bluetoothDevice, txPhy, rxPhy, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onReadPhySuccess(taskId, bluetoothDevice, txPhy, rxPhy, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onReadPhyFailed(taskId, bluetoothDevice, status, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onReadPhyFailed(taskId, bluetoothDevice, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onReadPhyTimeout(taskId, bluetoothDevice, timeout, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onReadPhyTimeout(taskId, bluetoothDevice, timeout, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetPreferredPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, int phyOptions, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onSetPreferredPhySuccess(taskId, bluetoothDevice, txPhy, rxPhy, phyOptions, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onSetPreferredPhySuccess(taskId, bluetoothDevice, txPhy, rxPhy, phyOptions, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onSetPreferredPhyFailed(taskId, bluetoothDevice, status, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onSetPreferredPhyFailed(taskId, bluetoothDevice, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetPreferredPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onSetPreferredPhyTimeout(taskId, bluetoothDevice, timeout, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onSetPreferredPhyTimeout(taskId, bluetoothDevice, timeout, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadRemoteRssiSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int rssi, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onReadRemoteRssiSuccess(taskId, bluetoothDevice, rssi, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onReadRemoteRssiSuccess(taskId, bluetoothDevice, rssi, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadRemoteRssiFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onReadRemoteRssiFailed(taskId, bluetoothDevice, status, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onReadRemoteRssiFailed(taskId, bluetoothDevice, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadRemoteRssiTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onReadRemoteRssiTimeout(taskId, bluetoothDevice, timeout, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onReadRemoteRssiTimeout(taskId, bluetoothDevice, timeout, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBeginReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onBeginReliableWriteSuccess(taskId, bluetoothDevice, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onBeginReliableWriteSuccess(taskId, bluetoothDevice, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBeginReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onBeginReliableWriteFailed(taskId, bluetoothDevice, status, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onBeginReliableWriteFailed(taskId, bluetoothDevice, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onExecuteReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onExecuteReliableWriteSuccess(taskId, bluetoothDevice, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onExecuteReliableWriteSuccess(taskId, bluetoothDevice, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onExecuteReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onExecuteReliableWriteFailed(taskId, bluetoothDevice, status, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onExecuteReliableWriteFailed(taskId, bluetoothDevice, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onExecuteReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onExecuteReliableWriteTimeout(taskId, bluetoothDevice, timeout, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onExecuteReliableWriteTimeout(taskId, bluetoothDevice, timeout, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAbortReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onAbortReliableWriteSuccess(taskId, bluetoothDevice, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onAbortReliableWriteSuccess(taskId, bluetoothDevice, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAbortReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onAbortReliableWriteFailed(taskId, bluetoothDevice, status, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onAbortReliableWriteFailed(taskId, bluetoothDevice, status, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAbortReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        Integer callbackId;
        if (argument.containsKey(KEY_CALLBACK_ID)) {
            callbackId = argument.getInt(KEY_CALLBACK_ID);
        } else {
            callbackId = null;
        }
        Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

        for (BLECallback bleCallback : mSubscriberInterface.getSubscriberCallbackSet()) {
            try {
                if (callbackId == null) {
                    bleCallback.onAbortReliableWriteTimeout(taskId, bluetoothDevice, timeout, originalArgument);
                } else if (bleCallback.hashCode() == callbackId) {
                    bleCallback.onAbortReliableWriteTimeout(taskId, bluetoothDevice, timeout, originalArgument);
                    break;
                }
            } catch (Exception e) {
                BLELogUtils.stackLog(e);
            }
        }
    }

}
