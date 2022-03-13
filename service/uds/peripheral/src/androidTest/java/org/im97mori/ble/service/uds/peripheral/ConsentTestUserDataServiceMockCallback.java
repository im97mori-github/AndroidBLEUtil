package org.im97mori.ble.service.uds.peripheral;

import android.bluetooth.BluetoothDevice;

import androidx.annotation.NonNull;

import org.im97mori.ble.ServiceData;

class ConsentTestUserDataServiceMockCallback extends UserDataServiceMockCallback {

    public ConsentTestUserDataServiceMockCallback(@NonNull ServiceData serviceData, boolean isFallback) {
        super(serviceData, isFallback);
    }

    public void setConsent(@NonNull BluetoothDevice bluetoothDevice, @NonNull Integer userIndex) {
        mCurrentUserMap.put(bluetoothDevice, userIndex);
    }
}
