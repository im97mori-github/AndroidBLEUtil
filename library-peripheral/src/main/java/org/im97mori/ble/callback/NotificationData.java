package org.im97mori.ble.callback;

import android.bluetooth.BluetoothDevice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.UUID;

/**
 * Notification data class
 */
public class NotificationData {

    /**
     * {@link BluetoothDevice} instance
     */
    public final BluetoothDevice bluetoothDevice;

    /**
     * Service's {@link UUID} instance
     */
    public final UUID serviceUUID;

    /**
     * Service's instance id
     */
    public final int serviceInstanceId;

    /**
     * Characteristic's {@link UUID} instance
     */
    public final UUID characteristicUUID;

    /**
     * Characteristic's instance id
     */
    public final int characteristicInstanceId;

    /**
     * @param bluetoothDevice          {@link BluetoothDevice} instance
     * @param serviceUUID              Service's {@link UUID} instance
     * @param serviceInstanceId        Service's instance id
     * @param characteristicUUID       Characteristic's {@link UUID} instance
     * @param characteristicInstanceId Characteristic's instance id
     */
    public NotificationData(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId) {
        this.bluetoothDevice = bluetoothDevice;
        this.serviceUUID = serviceUUID;
        this.serviceInstanceId = serviceInstanceId;
        this.characteristicUUID = characteristicUUID;
        this.characteristicInstanceId = characteristicInstanceId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return bluetoothDevice.hashCode()
                ^ serviceUUID.hashCode()
                ^ Integer.valueOf(serviceInstanceId).hashCode()
                ^ characteristicUUID.hashCode()
                ^ Integer.valueOf(characteristicInstanceId).hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof NotificationData) {
            NotificationData target = (NotificationData) obj;
            result = bluetoothDevice.equals(target.bluetoothDevice)
                    && serviceUUID.equals(target.serviceUUID)
                    && serviceInstanceId == target.serviceInstanceId
                    && characteristicUUID.equals(target.characteristicUUID)
                    && characteristicInstanceId == target.characteristicInstanceId;
        }
        return result;
    }

}
