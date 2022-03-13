package org.im97mori.ble.callback;

import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.platform.app.InstrumentationRegistry;

import com.google.gson.Gson;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.test.peripheral.AbstractPeripheralTest;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

public class AssetCallbackTest extends AbstractPeripheralTest {

    static class InnerAssetCallback extends AssetCallback {

        InnerAssetCallback(Context context) throws IOException {
            super(context, "ble_server_connection_test.json", false);
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
        public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {

        }

        @Override
        public void onAdvertisingStartFailed(@Nullable Integer errorCode) {

        }

        @Override
        public void onAdvertisingFinished() {

        }
    }

    @Test
    public void test_constructor_00001() {
        MockData result1 = null;
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        try {
            result1 = new Gson().fromJson(new InputStreamReader(context.getAssets().open("ble_server_connection_test.json")), MockData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(result1);

        final List<ServiceData> serviceDataList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskServiceDataList(serviceDataList);
        InnerAssetCallback innerAssetCallback = null;
        try {
            innerAssetCallback = new InnerAssetCallback(context);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(innerAssetCallback);

        innerAssetCallback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertArrayEquals(result1.serviceDataList.toArray(), serviceDataList.toArray());
    }
}
