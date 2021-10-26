package org.im97mori.ble.test;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.ParcelUuid;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@SuppressWarnings({"unused", "JavaReflectionMemberAccess"})
public class BLETestUtilsAndroid {

    public static final BluetoothDevice MOCK_DEVICE_0 = ((BluetoothManager) ApplicationProvider.getApplicationContext().getSystemService(Context.BLUETOOTH_SERVICE)).getAdapter().getRemoteDevice("00:11:22:33:AA:BB");

    public static final BluetoothDevice MOCK_DEVICE_1 = ((BluetoothManager) ApplicationProvider.getApplicationContext().getSystemService(Context.BLUETOOTH_SERVICE)).getAdapter().getRemoteDevice("00:11:22:33:AA:CC");

    public static BluetoothGattService createBluetoothGattService(@NonNull UUID serviceUUID, int instanceId, int serviceType, @NonNull List<BluetoothGattCharacteristic> characteristics) {
        BluetoothGattService bluetoothGattService = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Parcel parcel = Parcel.obtain();
            parcel.writeParcelable(new ParcelUuid(serviceUUID), 0);
            parcel.writeInt(instanceId);
            parcel.writeInt(serviceType);
            parcel.writeTypedList(characteristics);
            parcel.writeTypedList(Collections.emptyList());
            parcel.setDataPosition(0);
            bluetoothGattService = BluetoothGattService.CREATOR.createFromParcel(parcel);
            parcel.recycle();
        } else {
            try {
                Constructor<BluetoothGattService> constructor = BluetoothGattService.class.getDeclaredConstructor(BluetoothDevice.class, UUID.class, int.class, int.class);
                constructor.setAccessible(true);
                bluetoothGattService = constructor.newInstance(null, serviceUUID, instanceId, serviceType);
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                    bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return bluetoothGattService;
    }

    public static BluetoothGattCharacteristic createBluetoothCharacteristic(@NonNull UUID characteristicUUID, int instanceId, int properties, int permissions, int keySize, int writeType, @NonNull List<BluetoothGattDescriptor> descriptors) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Parcel parcel = Parcel.obtain();
            parcel.writeParcelable(new ParcelUuid(characteristicUUID), 0);
            parcel.writeInt(instanceId);
            parcel.writeInt(properties);
            parcel.writeInt(permissions);
            parcel.writeInt(keySize);
            parcel.writeInt(writeType);
            parcel.writeTypedList(descriptors);
            parcel.setDataPosition(0);
            bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
            parcel.recycle();
        } else {
            try {
                Constructor<BluetoothGattCharacteristic> constructor = BluetoothGattCharacteristic.class.getDeclaredConstructor(BluetoothGattService.class, UUID.class, int.class, int.class, int.class);
                constructor.setAccessible(true);
                bluetoothGattCharacteristic = constructor.newInstance(null, characteristicUUID, instanceId, properties, permissions);
                for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                    bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return bluetoothGattCharacteristic;
    }

    public static BluetoothGattDescriptor createBluetoothDescriptor(@NonNull UUID descriptorUUID, int instanceId, int permissions) {
        BluetoothGattDescriptor bluetoothGattDescriptor = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Parcel parcel = Parcel.obtain();
            parcel.writeParcelable(new ParcelUuid(descriptorUUID), 0);
            parcel.writeInt(instanceId);
            parcel.writeInt(permissions);
            parcel.setDataPosition(0);
            bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);
            parcel.recycle();
        } else if (Build.VERSION_CODES.KITKAT <= Build.VERSION.SDK_INT) {
            try {
                Constructor<BluetoothGattDescriptor> constructor = BluetoothGattDescriptor.class.getDeclaredConstructor(BluetoothGattCharacteristic.class, UUID.class, int.class, int.class);
                constructor.setAccessible(true);
                bluetoothGattDescriptor = constructor.newInstance(null, descriptorUUID, instanceId, permissions);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Constructor<BluetoothGattDescriptor> constructor = BluetoothGattDescriptor.class.getDeclaredConstructor(BluetoothGattCharacteristic.class, UUID.class, int.class);
                constructor.setAccessible(true);
                bluetoothGattDescriptor = constructor.newInstance(null, descriptorUUID, permissions);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return bluetoothGattDescriptor;
    }

}
