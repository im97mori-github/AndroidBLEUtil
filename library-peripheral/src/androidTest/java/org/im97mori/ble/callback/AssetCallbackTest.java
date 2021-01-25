package org.im97mori.ble.callback;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import com.google.gson.Gson;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.MockBLEServerConnection;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

public class AssetCallbackTest {

    static class InnerAssetCallback extends AssetCallback {

        InnerAssetCallback(Context context) throws IOException {
            super(context, "ble_server_connection_test.json", false);
        }

        @Override
        public void onServerStarted() {

        }

        @Override
        public void onDeviceConnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {

        }

        @Override
        public void onDeviceDisconnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {

        }

        @Override
        public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {

        }

        @Override
        public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {

        }

        @Override
        public void onServiceRemoveFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {

        }

        @Override
        public void onServiceRemoveTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {

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
        public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {

        }

        @Override
        public void onAdvertisingStartFailed(Integer errorCode) {

        }

        @Override
        public void onAdvertisingFinished() {

        }
    }

    @Test
    public void test_constructor_00001() {
        MockData result1 = null;
        Context context = ApplicationProvider.getApplicationContext();
        try {
            result1 = new Gson().fromJson(new InputStreamReader(context.getAssets().open("ble_server_connection_test.json")), MockData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(result1);

        final List<ServiceData> serviceDataList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                @SuppressWarnings("ConstantConditions") ServiceData serviceData = argument.getParcelable("KEY_SERVICE_DATA");
                serviceDataList.add(serviceData);
                return null;
            }
        };

        InnerAssetCallback innerAssetCallback = null;
        try {
            innerAssetCallback = new InnerAssetCallback(context);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(innerAssetCallback);

        innerAssetCallback.setup(mockBLEServerConnection);

        assertArrayEquals(result1.serviceDataList.toArray(), serviceDataList.toArray());
    }
}
