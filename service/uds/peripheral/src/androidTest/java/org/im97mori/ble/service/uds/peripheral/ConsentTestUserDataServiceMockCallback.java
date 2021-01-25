package org.im97mori.ble.service.uds.peripheral;

import android.bluetooth.BluetoothDevice;

import androidx.annotation.NonNull;

import org.im97mori.ble.MockData;

class ConsentTestUserDataServiceMockCallback extends UserDataServiceMockCallback {

    public ConsentTestUserDataServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

    public void setConsent(@NonNull BluetoothDevice bluetoothDevice, @NonNull Integer userIndex) {
        mCurrentUserMap.put(bluetoothDevice, userIndex);
    }
}
