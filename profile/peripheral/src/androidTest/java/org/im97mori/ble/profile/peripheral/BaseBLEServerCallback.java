package org.im97mori.ble.profile.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.BLEServerConnection;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class BaseBLEServerCallback implements BLEServerCallback {

    public final AtomicBoolean result = new AtomicBoolean(false);

    public final CountDownLatch tearDownLatch = new CountDownLatch(1);

    @Override
    public void onServerStarted() {
    }

    @Override
    public void onServerStopped() {
        tearDownLatch.countDown();
    }

    @Override
    public void onDeviceConnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {

    }

    @Override
    public void onDeviceDisconnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {

    }

    @Override
    public boolean onServiceAddSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {
        return false;
    }

    @Override
    public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {

    }

    @Override
    public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {

    }

    @Override
    public void onServiceRemoveSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {

    }

    @Override
    public void onServiceRemoveFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {

    }

    @Override
    public void onServiceRemoveTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {

    }

    @Override
    public boolean onCharacteristicReadRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean force) {
        return false;
    }

    @Override
    public boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
        return false;
    }

    @Override
    public boolean onDescriptorReadRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, boolean force) {
        return false;
    }

    @Override
    public boolean onDescriptorWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
        return false;
    }

    @Override
    public void onNotificationSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull byte[] value, @Nullable Bundle argument) {
    }

    @Override
    public void onNotificationFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int status, @Nullable Bundle argument) {
    }

    @Override
    public void onNotificationTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, long timeout, @Nullable Bundle argument) {
    }

    @Override
    public boolean onExecuteWrite(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, boolean execute, boolean force) {
        return false;
    }

    @Override
    public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {

    }

    @Override
    public void onMtuChanged(@NonNull BluetoothDevice device, int mtu) {

    }

    @Override
    public void onPhyReadSuccess(@NonNull Integer integer, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice bluetoothDevice, int i, int i1, @Nullable Bundle bundle) {

    }

    @Override
    public void onPhyReadFailed(@NonNull Integer integer, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice bluetoothDevice, int i, @Nullable Bundle bundle) {

    }

    @Override
    public void onPhyReadTimeout(@NonNull Integer integer, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice bluetoothDevice, long l, @Nullable Bundle bundle) {

    }

    @Override
    public void onSetPreferredPhySuccess(@NonNull Integer integer, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice bluetoothDevice, int i, int i1, int i2, @Nullable Bundle bundle) {

    }

    @Override
    public void onSetPreferredPhyFailed(@NonNull Integer integer, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice bluetoothDevice, int i, @Nullable Bundle bundle) {

    }

    @Override
    public void onSetPreferredPhyTimeout(@NonNull Integer integer, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice bluetoothDevice, long l, @Nullable Bundle bundle) {

    }

    @Override
    public void onAdvertisingStartFailed(Integer errorCode) {

    }

    @Override
    public void onAdvertisingFinished() {

    }

    @Override
    public void setup(@NonNull BLEServerConnection bleServerConnection) {

    }

    @Override
    public void tearDown(@NonNull BLEServerConnection bleServerConnection) {

    }

    @Override
    public boolean isFallback() {
        return false;
    }
}
