package org.im97mori.ble.test.peripheral;

import android.bluetooth.BluetoothGattService;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.ServiceData;

import java.util.List;
import java.util.UUID;

public class MockBLEServerConnection extends BLEServerConnection {

    protected List<BluetoothGattService> mCreateAddServiceTaskBluetoothGattServiceList;

    protected List<BluetoothGattService> mCreateRemoveServiceTaskBluetoothGattServiceList;

    protected List<ServiceData> mCreateAddServiceTaskServiceDataList;

    protected boolean mStartAdvertisingIncludeDeviceName;

    protected boolean mStartAdvertisingIncludeUUID;

    protected UUID mStartAdvertisingServiceUUID;

    public MockBLEServerConnection() {
        super(ApplicationProvider.getApplicationContext());
    }

    public void setCreateAddServiceTaskBluetoothGattServiceList(@Nullable List<BluetoothGattService> createAddServiceTaskBluetoothGattServiceList) {
        mCreateAddServiceTaskBluetoothGattServiceList = createAddServiceTaskBluetoothGattServiceList;
    }

    public void setCreateAddServiceTaskServiceDataList(@Nullable List<ServiceData> createAddServiceTaskServiceDataList) {
        mCreateAddServiceTaskServiceDataList = createAddServiceTaskServiceDataList;
    }

    @Override
    public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
        if (mCreateAddServiceTaskBluetoothGattServiceList != null) {
            mCreateAddServiceTaskBluetoothGattServiceList.add(bluetoothGattService);
        }
        if (mCreateAddServiceTaskServiceDataList != null && argument != null) {
            ServiceData serviceData;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                serviceData = argument.getParcelable("KEY_SERVICE_DATA", ServiceData.class);
            } else {
                serviceData = argument.getParcelable("KEY_SERVICE_DATA");
            }
            mCreateAddServiceTaskServiceDataList.add(serviceData);
        }
        return super.createAddServiceTask(bluetoothGattService, timeout, argument, bleServerCallback);
    }

    public void setCreateRemoveServiceTaskBluetoothGattServiceList(@Nullable List<BluetoothGattService> createRemoveServiceTaskBluetoothGattServiceList) {
        mCreateRemoveServiceTaskBluetoothGattServiceList = createRemoveServiceTaskBluetoothGattServiceList;
    }

    @Override
    public synchronized Integer createRemoveServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
        if (mCreateRemoveServiceTaskBluetoothGattServiceList != null) {
            mCreateRemoveServiceTaskBluetoothGattServiceList.add(bluetoothGattService);
        }
        return super.createRemoveServiceTask(bluetoothGattService, timeout, argument, bleServerCallback);
    }

    public boolean getStartAdvertisingIncludeDeviceName() {
        return mStartAdvertisingIncludeDeviceName;
    }

    public void setStartAdvertisingIncludeDeviceName(boolean includeDeviceName) {
        mStartAdvertisingIncludeDeviceName = includeDeviceName;
    }

    public boolean getStartAdvertisingIncludeUUID() {
        return mStartAdvertisingIncludeUUID;
    }

    public void setStartAdvertisingIncludeUUID(boolean includeUUID) {
        mStartAdvertisingIncludeUUID = includeUUID;
    }

    @Nullable
    public UUID getStartAdvertisingServiceUUID() {
        return mStartAdvertisingServiceUUID;
    }

    public void setStartAdvertisingServiceUUID(@Nullable UUID serviceUUID) {
        mStartAdvertisingServiceUUID = serviceUUID;
    }

    @Override
    public synchronized boolean startAdvertising(boolean includeDeviceName, boolean includeUUID, @Nullable UUID serviceUUID) {
        mStartAdvertisingIncludeDeviceName = includeDeviceName;
        mStartAdvertisingIncludeUUID = includeUUID;
        mStartAdvertisingServiceUUID = serviceUUID;
        return super.startAdvertising(includeDeviceName, includeUUID, serviceUUID);
    }

}
