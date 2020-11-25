package org.im97mori.ble.service.aios.central;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.ParcelUuid;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.UUID;

abstract class AbstractAutomationIOServiceTest {

    @NonNull
    protected Parcel createBluetoothCharacteristicParcel(@NonNull UUID characteristicUUID, int instanceId, int properties, int permissions, int keySize, int writeType, @NonNull List<BluetoothGattDescriptor> descriptors) {
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(characteristicUUID), 0);
        parcel.writeInt(instanceId);
        parcel.writeInt(properties);
        parcel.writeInt(permissions);
        parcel.writeInt(keySize);
        parcel.writeInt(writeType);
        parcel.writeTypedList(descriptors);
        parcel.setDataPosition(0);
        return parcel;
    }

}
