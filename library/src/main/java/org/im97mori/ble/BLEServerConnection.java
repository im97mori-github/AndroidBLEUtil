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
import android.text.format.DateUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;

import static android.bluetooth.le.AdvertiseSettings.ADVERTISE_MODE_LOW_LATENCY;

/**
 * BLE Connection(peripheral role)
 */
@SuppressWarnings("WeakerAccess")
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class BLEServerConnection extends BluetoothGattServerCallback {

    /**
     * Default server setting
     */
    public static class DefaultServerSetting implements BLEServerCallback {

        /**
         * Default response message
         */
        public static final String MESSAGE_SUCCESS = "MESSAGE_SUCCESS";

        // UUID for service / characteristic / descriptor

        /**
         * DEFAULT_SERVICE
         */
        public static final UUID DEFAULT_SERVICE_UUID = UUID.fromString("00000000-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * UNDEFINED_SERVICE (for test)
         */
        public static final UUID UNDIFINED_SERVICE_UUID = UUID.fromString("ffffffff-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * READABLE_CHARACTERICTIS
         */
        public static final UUID READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT = UUID.fromString("00000001-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * READABLE_CHARACTERICTIS (10sec wait)
         */
        public static final UUID READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S = UUID.fromString("00000002-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * READABLE_ERROR_CHARACTERISTIC
         *
         * @see org.im97mori.ble.BLEConstants.ErrorCodes#REQUEST_NOT_SUPPORTED
         */
        public static final UUID READABLE_CHARACTERISTIC_UUID_WITH_ERROR = UUID.fromString("00000003-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * WRITABLE_CHARACTERISTIC
         */
        public static final UUID WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT = UUID.fromString("00000004-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * WRITABLE_CHARACTERISTIC (10sec wait)
         */
        public static final UUID WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S = UUID.fromString("00000005-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * WRITABLE_ERROR_CHARACTERISTIC
         *
         * @see org.im97mori.ble.BLEConstants.ErrorCodes#REQUEST_NOT_SUPPORTED
         */
        public static final UUID WRITABLE_CHARACTERISTIC_UUID_WITH_ERROR = UUID.fromString("00000006-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * WRITABLE_NO_RESPONSE_CHARACTERISTIC
         *
         * @see BluetoothGattCharacteristic#WRITE_TYPE_NO_RESPONSE
         */
        public static final UUID WRITABLE_NO_RESPONSE_CHARACTERISTIC_UUID = UUID.fromString("00000007-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * UNDEFINED_CHARACTERISTIC (for test)
         */
        public static final UUID UNDIFINED_CHARACTERISTIC_UUID = UUID.fromString("fffffffe-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * READABLE_DESCRIPTOR
         */
        public static final UUID READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT = UUID.fromString("00000008-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * READABLE_DESCRIPTOR (10sec wait)
         */
        public static final UUID READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S = UUID.fromString("00000009-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * READABLE_ERROR_DESCRIPTOR
         *
         * @see org.im97mori.ble.BLEConstants.ErrorCodes#REQUEST_NOT_SUPPORTED
         */
        public static final UUID READABLE_DESCRIPTOR_UUID_WITH_ERROR = UUID.fromString("0000000a-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * WRITABLE_DESCRIPTOR
         */
        public static final UUID WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT = UUID.fromString("0000000b-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * WRITABLE_DESCRIPTOR (10sec wait)
         */
        public static final UUID WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S = UUID.fromString("0000000c-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * WRITABLE_ERROR_DESCRIPTOR
         *
         * @see org.im97mori.ble.BLEConstants.ErrorCodes#REQUEST_NOT_SUPPORTED
         */
        public static final UUID WRITABLE_DESCRIPTOR_UUID_WITH_ERROR = UUID.fromString("0000000d-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * UNDEFINED_DESCRIPTOR (for test)
         */
        public static final UUID UNDIFINED_DESCRIPTOR_UUID = UUID.fromString("fffffffd-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * {@inheritDoc}
         */
        public List<BluetoothGattService> getBluetoothGattServiceList() {
            BluetoothGattService bluetoothGattService;
            BluetoothGattCharacteristic bluetoothGattCharacteristic;
            BluetoothGattDescriptor bluetoothGattDescriptor;
            List<BluetoothGattService> list = new LinkedList<>();

            bluetoothGattService = new BluetoothGattService(DEFAULT_SERVICE_UUID, BluetoothGattService.SERVICE_TYPE_PRIMARY);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(READABLE_DESCRIPTOR_UUID_WITH_ERROR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(READABLE_DESCRIPTOR_UUID_WITH_ERROR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(READABLE_CHARACTERISTIC_UUID_WITH_ERROR, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_WRITE);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(WRITABLE_DESCRIPTOR_UUID_WITH_ERROR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_WRITE);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(WRITABLE_DESCRIPTOR_UUID_WITH_ERROR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WRITABLE_CHARACTERISTIC_UUID_WITH_ERROR, BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_WRITE);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WRITABLE_NO_RESPONSE_CHARACTERISTIC_UUID, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, BluetoothGattCharacteristic.PERMISSION_WRITE);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            list.add(bluetoothGattService);
            return list;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean onCharacteristicReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, int offset, BluetoothGattCharacteristic characteristic) {
            boolean result = false;
            if (READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT.equals(characteristic.getUuid())) {
                result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, MESSAGE_SUCCESS.getBytes());
            } else if (READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S.equals(characteristic.getUuid())) {
                long end = SystemClock.elapsedRealtime() + DateUtils.SECOND_IN_MILLIS * 10;
                do {
                    try {
                        Thread.sleep(end - SystemClock.elapsedRealtime());
                    } catch (InterruptedException e) {
                        BLELogUtils.stackLog(e);
                    }
                } while (end > SystemClock.elapsedRealtime());
                result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, MESSAGE_SUCCESS.getBytes());
            } else if (READABLE_CHARACTERISTIC_UUID_WITH_ERROR.equals(characteristic.getUuid())) {
                result = bluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.VALUE_NOT_ALLOWED, offset, null);
            }
            return result;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean onCharacteristicWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, BluetoothGattCharacteristic characteristic, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
            boolean result = false;
            if (WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT.equals(characteristic.getUuid())) {
                result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, null);
            } else if (WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S.equals(characteristic.getUuid())) {
                long end = SystemClock.elapsedRealtime() + DateUtils.SECOND_IN_MILLIS * 10;
                do {
                    try {
                        Thread.sleep(end - SystemClock.elapsedRealtime());
                    } catch (InterruptedException e) {
                        BLELogUtils.stackLog(e);
                    }
                } while (end > SystemClock.elapsedRealtime());
                result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, null);
            } else if (WRITABLE_CHARACTERISTIC_UUID_WITH_ERROR.equals(characteristic.getUuid())) {
                result = bluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.VALUE_NOT_ALLOWED, offset, null);
            }
            return result;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean onDescriptorReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, int offset, BluetoothGattDescriptor descriptor) {
            boolean result = false;
            if (READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT.equals(descriptor.getUuid())) {
                result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, MESSAGE_SUCCESS.getBytes());
            } else if (READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S.equals(descriptor.getUuid())) {
                long end = SystemClock.elapsedRealtime() + DateUtils.SECOND_IN_MILLIS * 10;
                do {
                    try {
                        Thread.sleep(end - SystemClock.elapsedRealtime());
                    } catch (InterruptedException e) {
                        BLELogUtils.stackLog(e);
                    }
                } while (end > SystemClock.elapsedRealtime());
                result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, MESSAGE_SUCCESS.getBytes());
            } else if (READABLE_DESCRIPTOR_UUID_WITH_ERROR.equals(descriptor.getUuid())) {
                result = bluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.VALUE_NOT_ALLOWED, offset, null);
            }
            return result;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean onDescriptorWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
            boolean result = false;
            if (WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT.equals(descriptor.getUuid())) {
                result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, null);
            } else if (WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S.equals(descriptor.getUuid())) {
                long end = SystemClock.elapsedRealtime() + DateUtils.SECOND_IN_MILLIS * 10;
                do {
                    try {
                        Thread.sleep(end - SystemClock.elapsedRealtime());
                    } catch (InterruptedException e) {
                        BLELogUtils.stackLog(e);
                    }
                } while (end > SystemClock.elapsedRealtime());
                result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, null);
            } else if (WRITABLE_DESCRIPTOR_UUID_WITH_ERROR.equals(descriptor.getUuid())) {
                result = bluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.VALUE_NOT_ALLOWED, offset, null);
            }
            return result;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onServerStarted() {
            // do nothing
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onServerStopped() {
            // do nothing
        }

    }

    /**
     * SERVICE_UUID for Advertising
     *
     * @see org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes#DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS
     */
    public static final UUID CONTROL_SERVICE_UUID = UUID.fromString("00000000-a087-4fa3-add4-3b8a7d5d491f");

    /**
     * TODO
     */
    public static final UUID CONTROL_CHARACTERISTIC_UUID = UUID.fromString("00000001-a087-4fa3-add4-3b8a7d5d491f");

    /**
     * {@link Context} instance
     */
    private final Context mContext;

    /**
     * {@link BluetoothManager} instance
     */
    private final BluetoothManager mBluetoothManager;

    /**
     * {@link BluetoothAdapter} instance
     */
    private final BluetoothAdapter mBluetoothAdapter;

    /**
     * {@link BLEServerCallback} instance
     */
    private BLEServerCallback mBLEServerCallback;

    /**
     * {@link BluetoothGattServer} instance
     */
    private BluetoothGattServer mBluetoothGattServer;

    /**
     * temporary service list for {@link BluetoothGattServer#addService(BluetoothGattService)} loop
     */
    private Queue<BluetoothGattService> mWorkBluetoothGattServiceList;

    /**
     * {@link AdvertiseCallback} instance
     */
    private AdvertiseCallback mAdvertiseCallback;

    /**
     * {@link BluetoothLeAdvertiser} instance
     */
    private BluetoothLeAdvertiser mBluetoothLeAdvertiser;

    /**
     * TODO
     */
    private long mLastUpdate;

    /**
     * @param context           {@link Context} instance
     * @param bleServerCallback {@link BLEServerCallback} instance
     */
    public BLEServerConnection(Context context, BLEServerCallback bleServerCallback) {
        mContext = context;
        mBluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = mBluetoothManager.getAdapter();
        mBLEServerCallback = bleServerCallback;
    }

    /**
     * check server status
     *
     * @return {@code true}:{@link BluetoothGattServer} and {@link BluetoothLeAdvertiser} started, {@code false}: server stopped
     */
    public boolean isStarted() {
        return mAdvertiseCallback != null;
    }

    /**
     * start {@link BluetoothGattServer} and {@link BluetoothLeAdvertiser}
     */
    public synchronized void start() {
        if (mBluetoothGattServer == null) {
            mBluetoothGattServer = mBluetoothManager.openGattServer(mContext, this);

            mWorkBluetoothGattServiceList = new LinkedList<>(mBLEServerCallback.getBluetoothGattServiceList());
            BluetoothGattService bluetoothGattService = new BluetoothGattService(CONTROL_SERVICE_UUID, BluetoothGattService.SERVICE_TYPE_PRIMARY);
            bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(
                    CONTROL_CHARACTERISTIC_UUID
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
            ));
            mBluetoothGattServer.addService(bluetoothGattService);

            // TODO
            mLastUpdate = SystemClock.elapsedRealtime();
        }
    }

    /**
     * <p>
     * update server response callback
     *
     * <b>Warning</b> change peripheral's service / characteristic / descriptor setting after bonded, central's {@link android.bluetooth.BluetoothGattCallback#onConnectionStateChange(BluetoothGatt, int, int)} return 133 error.
     * if you change peripheral's service / characteristic / descriptor setting, need re-bonding.
     * </p>
     *
     * @param bleServerCallback new server response callback
     */
    public synchronized void updateServerCallback(BLEServerCallback bleServerCallback) {
        mBLEServerCallback = bleServerCallback;
    }

    /**
     * stop {@link BluetoothGattServer} and {@link BluetoothLeAdvertiser}
     */
    public synchronized void quit() {
        if (mBluetoothLeAdvertiser != null) {
            mBluetoothLeAdvertiser.stopAdvertising(mAdvertiseCallback);
            mAdvertiseCallback = null;
            mBluetoothLeAdvertiser = null;
        }

        if (mBluetoothGattServer != null) {
            mBluetoothGattServer.close();
            mBluetoothGattServer = null;
            mBLEServerCallback.onServerStopped();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onConnectionStateChange(BluetoothDevice device, int status, int newState) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onServiceAdded(int status, BluetoothGattService service) {
        if (mBluetoothGattServer != null) {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                BluetoothGattService next = mWorkBluetoothGattServiceList.poll();
                if (next == null) {
                    // add finished, start advertising
                    if (mAdvertiseCallback == null) {
                        AdvertiseSettings.Builder asBuilder = new AdvertiseSettings.Builder();
                        asBuilder.setConnectable(true);
                        asBuilder.setAdvertiseMode(ADVERTISE_MODE_LOW_LATENCY);
                        AdvertiseData.Builder adBuilder = new AdvertiseData.Builder();
                        adBuilder.setIncludeDeviceName(false);
                        adBuilder.addServiceUuid(new ParcelUuid(CONTROL_SERVICE_UUID));
                        mAdvertiseCallback = new AdvertiseCallback() {

                            /**
                             * {@inheritDoc}
                             */
                            @Override
                            public void onStartSuccess(AdvertiseSettings settingsInEffect) {
                                mBLEServerCallback.onServerStarted();
                            }

                            /**
                             * {@inheritDoc}
                             */
                            @Override
                            public void onStartFailure(int errorCode) {
                                quit();
                            }

                        };
                        mBluetoothLeAdvertiser = mBluetoothAdapter.getBluetoothLeAdvertiser();
                        mBluetoothLeAdvertiser.startAdvertising(asBuilder.build(), adBuilder.build(), mAdvertiseCallback);
                    }
                } else {
                    // add next service

                    mBluetoothGattServer.addService(next);
                }
            } else {
                quit();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadRequest(BluetoothDevice device, int requestId, int offset, BluetoothGattCharacteristic characteristic) {
        boolean result = false;
        if (CONTROL_CHARACTERISTIC_UUID.equals(characteristic.getUuid())) {
            characteristic.setValue(String.valueOf(mLastUpdate));
            result = mBluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, String.valueOf(mLastUpdate).getBytes());
        } else {
            if (mBLEServerCallback != null) {
                result = mBLEServerCallback.onCharacteristicReadRequest(mBluetoothGattServer, device, requestId, offset, characteristic);
            }
        }

        // fallback response
        // if you dont response, cause 133 error
        if (!result) {
            mBluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.REQUEST_NOT_SUPPORTED, offset, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteRequest(BluetoothDevice device, int requestId, BluetoothGattCharacteristic characteristic, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
        boolean result = false;
        if (CONTROL_CHARACTERISTIC_UUID.equals(characteristic.getUuid())) {
            // TODO
        } else {
            if (mBLEServerCallback != null) {
                result = mBLEServerCallback.onCharacteristicWriteRequest(mBluetoothGattServer, device, requestId, characteristic, preparedWrite, responseNeeded, offset, value);
            }
        }

        // fallback response
        // if you dont response, cause 133 error
        if (responseNeeded && !result) {
            mBluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.REQUEST_NOT_SUPPORTED, offset, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadRequest(BluetoothDevice device, int requestId, int offset, BluetoothGattDescriptor descriptor) {
        boolean result = false;
        if (mBLEServerCallback != null) {
            result = mBLEServerCallback.onDescriptorReadRequest(mBluetoothGattServer, device, requestId, offset, descriptor);
        }

        // fallback response
        // if you dont response, cause 133 error
        if (!result) {
            mBluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.REQUEST_NOT_SUPPORTED, offset, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteRequest(BluetoothDevice device, int requestId, BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
        boolean result = false;
        if (mBLEServerCallback != null) {
            result = mBLEServerCallback.onDescriptorWriteRequest(mBluetoothGattServer, device, requestId, descriptor, preparedWrite, responseNeeded, offset, value);
        }

        // fallback response
        // if you dont response, cause 133 error
        if (responseNeeded && !result) {
            mBluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.REQUEST_NOT_SUPPORTED, offset, null);
        }
    }

}
