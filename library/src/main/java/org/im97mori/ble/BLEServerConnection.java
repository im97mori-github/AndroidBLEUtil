package org.im97mori.ble;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Context;
import android.os.Build;
import android.os.ParcelUuid;
import android.os.SystemClock;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;

import static android.bluetooth.le.AdvertiseSettings.ADVERTISE_MODE_LOW_LATENCY;
import static android.bluetooth.le.AdvertiseSettings.ADVERTISE_TX_POWER_HIGH;

/**
 * BLE Connection(peripheral role)
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class BLEServerConnection extends BluetoothGattServerCallback {

    public static final long MOST_SIGNIFICANT = 2693222307L;
    public static final long LEAST_SIGNIFICANT = -5921042144090568417L;

    public static final UUID AD_SERVICE_UUID = new UUID(MOST_SIGNIFICANT, LEAST_SIGNIFICANT);
    public static final UUID GATT_CHARACTERISTIC_UUID = new UUID(MOST_SIGNIFICANT + 1, LEAST_SIGNIFICANT);

    private final Context mContext;
    private final BluetoothManager mBluetoothManager;
    private final BluetoothAdapter mBluetoothAdapter;
    private final BluetoothLeAdvertiser mBluetoothLeAdvertiser;
    private final Queue<BluetoothGattService> mBluetoothGattServiceList;
    private Queue<BluetoothGattService> mWorkBluetoothGattServiceList;

    private BluetoothGattServer mBluetoothGattServer;
    private AdvertiseCallback mAdvertiseCallback;
    private long mLastUpdate;

    private BLEServerStatusCallback mBLEServerStatusCallback;
    private BLEServerCallback mBLEServerCallback;

    public BLEServerConnection(Context context, List<BluetoothGattService> bluetoothGattServiceList, BLEServerStatusCallback bleServerStatusCallback) {
        mContext = context;
        mBluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = mBluetoothManager.getAdapter();
        mBluetoothLeAdvertiser = mBluetoothAdapter.getBluetoothLeAdvertiser();
        mBluetoothGattServiceList = new LinkedList<>(bluetoothGattServiceList);
        mBLEServerStatusCallback = bleServerStatusCallback;
    }

    public boolean isStarted() {
        return mBluetoothGattServer != null;
    }

    public synchronized void start() {
        if (mAdvertiseCallback == null) {
            AdvertiseSettings.Builder asBuilder = new AdvertiseSettings.Builder();
            asBuilder.setConnectable(true);
            asBuilder.setTxPowerLevel(ADVERTISE_TX_POWER_HIGH);
            asBuilder.setTimeout(180000);
            asBuilder.setAdvertiseMode(ADVERTISE_MODE_LOW_LATENCY);
            AdvertiseData.Builder adBuilder = new AdvertiseData.Builder();
            adBuilder.setIncludeDeviceName(false);
            adBuilder.addServiceUuid(new ParcelUuid(AD_SERVICE_UUID));
            mAdvertiseCallback = new AdvertiseCallback() {
                @Override
                public void onStartSuccess(AdvertiseSettings settingsInEffect) {
                    BLELogUtils.stackLog(settingsInEffect);
                }

                @Override
                public void onStartFailure(int errorCode) {
                    BLELogUtils.stackLog(errorCode);
                }
            };
            mBluetoothLeAdvertiser.startAdvertising(asBuilder.build(), adBuilder.build(), mAdvertiseCallback);
            mBluetoothGattServer = mBluetoothManager.openGattServer(mContext, this);

            BluetoothGattService bluetoothGattService = new BluetoothGattService(AD_SERVICE_UUID, BluetoothGattService.SERVICE_TYPE_PRIMARY);
            bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(
                    GATT_CHARACTERISTIC_UUID
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
            ));
            mBluetoothGattServer.addService(bluetoothGattService);
            mWorkBluetoothGattServiceList = new LinkedList<>(mBluetoothGattServiceList);

            mLastUpdate = SystemClock.elapsedRealtime();
        }
    }

    public synchronized void quit() {
        if (mBluetoothLeAdvertiser != null) {
            mBluetoothLeAdvertiser.stopAdvertising(mAdvertiseCallback);
            mAdvertiseCallback = null;
            mBluetoothGattServer.close();
            mBluetoothGattServer = null;
            mBLEServerStatusCallback.onServerStopped();
        }
    }

    @Override
    public void onConnectionStateChange(BluetoothDevice device, int status, int newState) {
        BLELogUtils.stackLog(device, status, newState);
    }

    @Override
    public void onServiceAdded(int status, BluetoothGattService service) {
        BLELogUtils.stackLog(status, service.getUuid());
        if (BluetoothGatt.GATT_SUCCESS == status) {
            BluetoothGattService next = mWorkBluetoothGattServiceList.poll();
            if (next == null) {
                mBLEServerStatusCallback.onServerStarted();
            } else {
                mBluetoothGattServer.addService(next);
            }
        } else {
            quit();
        }
    }

    @Override
    public void onCharacteristicReadRequest(BluetoothDevice device, int requestId, int offset, BluetoothGattCharacteristic characteristic) {
        UUID uuid = characteristic.getUuid();
        BLELogUtils.stackLog(device, requestId, offset, uuid);
        if (GATT_CHARACTERISTIC_UUID.equals(uuid)) {
            characteristic.setValue(String.valueOf(mLastUpdate));
            mBluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, String.valueOf(mLastUpdate).getBytes());
        } else {
            boolean result = false;
            if (mBLEServerCallback != null) {
                result = mBLEServerCallback.onCharacteristicReadRequest(mBluetoothGattServer, device, requestId, offset, characteristic);
            }

            if (!result) {
                mBluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.REQUEST_NOT_SUPPORTED, offset, new byte[0]);
            }
        }
    }

    @Override
    public void onCharacteristicWriteRequest(BluetoothDevice device, int requestId, BluetoothGattCharacteristic characteristic, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
        UUID uuid = characteristic.getUuid();
        BLELogUtils.stackLog(device, requestId, uuid, preparedWrite, responseNeeded, offset, Arrays.toString(value));
        if (GATT_CHARACTERISTIC_UUID.equals(uuid)) {

        } else {
            boolean result = false;
            if (mBLEServerCallback != null) {
                result = mBLEServerCallback.onCharacteristicWriteRequest(mBluetoothGattServer, device, requestId, characteristic, preparedWrite, responseNeeded, offset, value);
            }

            if (responseNeeded && !result) {
                mBluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.REQUEST_NOT_SUPPORTED, offset, new byte[0]);
            }
        }
    }

    @Override
    public void onDescriptorReadRequest(BluetoothDevice device, int requestId, int offset, BluetoothGattDescriptor descriptor) {
        UUID uuid = descriptor.getUuid();
        BLELogUtils.stackLog(device, requestId, uuid, Arrays.toString(descriptor.getValue()));

        boolean result = false;
        if (mBLEServerCallback != null) {
            result = mBLEServerCallback.onDescriptorReadRequest(mBluetoothGattServer, device, requestId, offset, descriptor);
        }

        if (!result) {
            mBluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.REQUEST_NOT_SUPPORTED, offset, new byte[0]);
        }
    }

    @Override
    public void onDescriptorWriteRequest(BluetoothDevice device, int requestId, BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
        UUID uuid = descriptor.getUuid();
        BLELogUtils.stackLog(device, requestId, uuid, preparedWrite, responseNeeded, offset, Arrays.toString(value));

        boolean result = false;
        if (mBLEServerCallback != null) {
            result = mBLEServerCallback.onDescriptorWriteRequest(mBluetoothGattServer, device, requestId, descriptor, preparedWrite, responseNeeded, offset, value);
        }

        if (responseNeeded && !result) {
            mBluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.REQUEST_NOT_SUPPORTED, offset, new byte[0]);
        }

    }

}
