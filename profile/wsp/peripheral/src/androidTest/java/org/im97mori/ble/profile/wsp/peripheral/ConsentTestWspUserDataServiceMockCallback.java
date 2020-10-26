package org.im97mori.ble.profile.wsp.peripheral;

import android.bluetooth.BluetoothDevice;

import androidx.annotation.NonNull;

import org.im97mori.ble.MockData;

class ConsentTestWspUserDataServiceMockCallback extends WspUserDataServiceMockCallback {

    public ConsentTestWspUserDataServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

    public void setConsent(@NonNull BluetoothDevice bluetoothDevice, @NonNull Integer userIndex) {
        mCurrentUserMap.put(bluetoothDevice, userIndex);
    }
}
