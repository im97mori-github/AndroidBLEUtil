package org.im97mori.ble.sample.lolipop;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.BLELogUtils;
import org.im97mori.ble.BLESyncConnection;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.CompleteListOf128BitServiceUUIDs;
import org.im97mori.ble.ad.Flags;
import org.im97mori.ble.ad.filter.AdvertisingDataFilter;
import org.im97mori.ble.ad.filter.FilteredScanCallback;
import org.im97mori.ble.ad.filter.FlagsFilter;
import org.im97mori.ble.ad.filter.OrFilter;
import org.im97mori.ble.descriptor.ClientCharacteristicConfiguration;
import org.im97mori.ble.task.ConnectTask;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;
import org.im97mori.ble_peripheral.characteristic.MockControl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_FAILED;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_SUCCESS;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_TIMEOUT;
import static org.im97mori.ble_peripheral.BLEServerConnection.DefaultServerSetting.DEFAULT_SERVICE_UUID;
import static org.im97mori.ble_peripheral.BLEServerConnection.DefaultServerSetting.INDICATABLE_CHARACTERISTIC_UUID;
import static org.im97mori.ble_peripheral.BLEServerConnection.DefaultServerSetting.NOTIFICATABLE_CHARACTERISTIC_UUID;
import static org.im97mori.ble_peripheral.BLEServerConnection.DefaultServerSetting.READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT;
import static org.im97mori.ble_peripheral.BLEServerConnection.DefaultServerSetting.WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT;
import static org.im97mori.ble_peripheral.BLEServerConnection.MOCK_CONTROL_CHARACTERISTIC_UUID;
import static org.im97mori.ble_peripheral.BLEServerConnection.MOCK_CONTROL_SERVICE_UUID;
import static org.im97mori.ble_peripheral.BLEServerConnection.MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class CentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private static class TestScanCallback extends FilteredScanCallback {

        private static class Builder extends FilteredScanCallback.Builder {

            private final CentralSampleActivity mActivity;

            Builder(@NonNull CentralSampleActivity activity) {
                mActivity = activity;
            }

            @NonNull
            @Override
            public FilteredScanCallback build() {
                return new TestScanCallback(mFilterList, mAdvertisingDataParser, mScanCallback, mActivity);
            }

        }

        final CentralSampleActivity mActivity;

        private TestScanCallback(@NonNull List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> filterList, @Nullable AdvertisingDataParser parser, @Nullable ScanCallback scanCallback, @NonNull CentralSampleActivity advertisingDataSampleActivity) {
            super(filterList, parser, scanCallback);
            mActivity = advertisingDataSampleActivity;
        }


        @Override
        public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {
            parse(result);
        }

        @Override
        public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {
            for (ScanResult result : results) {
                parse(result);
            }
        }

        @Override
        public void onScanFailed(int errorCode) {
            BLELogUtils.stackLog(errorCode);
        }

        private void parse(@NonNull final ScanResult scanResult) {
            BLELogUtils.stackLog(scanResult);
            if (scanResult.getScanRecord() != null) {
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            mActivity.mBluetoothLeScanner.stopScan(CentralSampleActivity.TestScanCallback.this);
                            mActivity.mTestScanCallback = null;
                            BluetoothDevice device = scanResult.getDevice();
                            if (BluetoothDevice.BOND_BONDED == device.getBondState()) {
                                mActivity.mBleConnection = BLEConnectionHolder.getInstance(device);
                                if (mActivity.mBleConnection == null) {
                                    mActivity.mBleConnection = new BLEConnection(mActivity, device, null);
                                    BLEConnectionHolder.addInstance(mActivity.mBleConnection, true);
                                }
                                mActivity.mBleConnection.attach(mActivity.mBLECallbackSample);
                                mActivity.mBleConnection.connect(ConnectTask.TIMEOUT_MILLIS);
                            } else {
                                mActivity.mReceiver = new BroadcastReceiver() {
                                    @Override
                                    public void onReceive(Context context, Intent intent) {
                                        try {
                                            String action = intent.getAction();
                                            BLELogUtils.stackLog(action, intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE));
                                            if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)) {
                                                int state = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE);
                                                if (BluetoothDevice.BOND_BONDED == state) {
                                                    mActivity.mBleConnection = BLEConnectionHolder.getInstance(scanResult.getDevice());
                                                    if (mActivity.mBleConnection == null) {
                                                        mActivity.mBleConnection = new BLEConnection(mActivity, scanResult.getDevice(), null);
                                                        BLEConnectionHolder.addInstance(mActivity.mBleConnection, true);
                                                    }
                                                    mActivity.mBleConnection.attach(mActivity.mBLECallbackSample);
                                                    mActivity.mBleConnection.connect(ConnectTask.TIMEOUT_MILLIS);
                                                    mActivity.unregisterReceiver(mActivity.mReceiver);
                                                    mActivity.mReceiver = null;
                                                }
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    }
                                };
                                IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
                                mActivity.registerReceiver(mActivity.mReceiver, intentFilter);
                                device.createBond();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
//                }
            }
        }

    }

    private Button mConnectDisconnectButton;

    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeScanner mBluetoothLeScanner;

    private FilteredScanCallback mTestScanCallback;

    private BLEConnection mBleConnection;
    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private BLECallbackSample mBLECallbackSample;

    private BroadcastReceiver mReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBLECallbackSample = new BLECallbackSample(this);

        mConnectDisconnectButton = findViewById(R.id.connectDisconnectButton);
        mAdapter = new ArrayAdapter<Pair<String, String>>(this, R.layout.list_child, new LinkedList<Pair<String, String>>()) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View child = convertView;
                if (child == null) {
                    child = getLayoutInflater().inflate(R.layout.list_child, parent, false);
                }
                Pair<String, String> item = getItem(position);
                if (item != null) {
                    TextView textView = child.findViewById(R.id.time);
                    textView.setText(item.first);
                    textView = child.findViewById(R.id.body);
                    textView.setText(item.second);
                }
                return child;
            }
        };
        mListView = findViewById(android.R.id.list);
        mListView.setAdapter(mAdapter);

        mConnectDisconnectButton.setOnClickListener(this);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter != null) {
            mBluetoothLeScanner = mBluetoothAdapter.getBluetoothLeScanner();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.gatt_sample;
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateLayout();
    }

    @Override
    protected void onDestroy() {
        if (mBluetoothLeScanner != null && mTestScanCallback != null) {
            mBluetoothLeScanner.stopScan(mTestScanCallback);
            mTestScanCallback = null;
        }
        if (mBleConnection != null) {
            mBleConnection.detach(mBLECallbackSample);
            mBleConnection = null;
        }
        if (mReceiver != null) {
            unregisterReceiver(mReceiver);
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.central, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            int menuItemId = menuItem.getItemId();
            if (R.id.read_characteristic_sync != menuItemId && R.id.write_characteristic_sync != menuItemId) {
                menuItem.setEnabled(mBleConnection != null && mBleConnection.isConnected());
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.read_characteristic == item.getItemId()) {
            mBleConnection.createReadCharacteristicTask(DEFAULT_SERVICE_UUID
                    , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                    , ReadCharacteristicTask.TIMEOUT_MILLIS);
        } else if (R.id.write_characteristc == item.getItemId()) {
            mBleConnection.createWriteCharacteristicTask(DEFAULT_SERVICE_UUID
                    , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                    , new ByteArrayInterface() {
                        @Override
                        @NonNull
                        public byte[] getBytes() {
                            return new byte[]{0x00, 0x00, 0x00, 0x00, 0x00};
                        }
                    }
                    , WriteCharacteristicTask.TIMEOUT_MILLIS);
        } else if (R.id.write_notification == item.getItemId()) {
            BluetoothGattDescriptor descriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR, 0);
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            mBleConnection.createWriteDescriptorTask(
                    DEFAULT_SERVICE_UUID
                    , NOTIFICATABLE_CHARACTERISTIC_UUID
                    , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                    , new ClientCharacteristicConfiguration(descriptor)
                    , WriteDescriptorTask.TIMEOUT_MILLIS
            );
        } else if (R.id.write_indication == item.getItemId()) {
            BluetoothGattDescriptor descriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR, 0);
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
            mBleConnection.createWriteDescriptorTask(
                    DEFAULT_SERVICE_UUID
                    , INDICATABLE_CHARACTERISTIC_UUID
                    , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                    , new ClientCharacteristicConfiguration(descriptor)
                    , WriteDescriptorTask.TIMEOUT_MILLIS
            );
        } else if (R.id.write_notification_stop == item.getItemId()) {
            BluetoothGattDescriptor descriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR, 0);
            descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            mBleConnection.createWriteDescriptorTask(
                    DEFAULT_SERVICE_UUID
                    , NOTIFICATABLE_CHARACTERISTIC_UUID
                    , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                    , new ClientCharacteristicConfiguration(descriptor)
                    , WriteDescriptorTask.TIMEOUT_MILLIS
            );
        } else if (R.id.write_indication_stop == item.getItemId()) {
            BluetoothGattDescriptor descriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR, 0);
            descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            mBleConnection.createWriteDescriptorTask(
                    DEFAULT_SERVICE_UUID
                    , INDICATABLE_CHARACTERISTIC_UUID
                    , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                    , new ClientCharacteristicConfiguration(descriptor)
                    , WriteDescriptorTask.TIMEOUT_MILLIS
            );
        } else if (R.id.read_characteristic_sync == item.getItemId()) {
            new Thread() {
                @Override
                public void run() {
                    BLEConnection target = mBleConnection;
                    if (target != null) {
                        BLESyncConnection.BLEResult result = BLESyncConnection.createReadCharacteristicTask(target
                                , DEFAULT_SERVICE_UUID
                                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                                , ReadCharacteristicTask.TIMEOUT_MILLIS
                                , ReadCharacteristicTask.TIMEOUT_MILLIS
                                , null
                                , false);

                        byte[] value = result.getValues();
                        if (RESULT_SUCCESS == result.getResultCode() && value != null) {
                            mBLECallbackSample.onCharacteristicReadSuccess(0, target.getBluetoothDevice(), DEFAULT_SERVICE_UUID, READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, value, result.getArgument());
                        } else if (RESULT_FAILED == result.getResultCode()) {
                            mBLECallbackSample.onCharacteristicReadFailed(0, target.getBluetoothDevice(), DEFAULT_SERVICE_UUID, READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, result.getStatus(), result.getArgument());
                        } else if (RESULT_TIMEOUT == result.getResultCode()) {
                            mBLECallbackSample.onCharacteristicReadTimeout(0, target.getBluetoothDevice(), DEFAULT_SERVICE_UUID, READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, ReadCharacteristicTask.TIMEOUT_MILLIS, result.getArgument());
                        }

                    }
                }
            }.start();
        } else if (R.id.write_characteristic_sync == item.getItemId()) {
            new Thread() {
                @Override
                public void run() {
                    BLEConnection target = mBleConnection;
                    if (target != null) {

                        final byte[] value = new byte[]{0x00, 0x00, 0x00, 0x00, 0x00};
                        BLESyncConnection.BLEResult result = BLESyncConnection.createWriteCharacteristicTask(target,
                                DEFAULT_SERVICE_UUID
                                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                                , new ByteArrayInterface() {
                                    @Override
                                    @NonNull
                                    public byte[] getBytes() {
                                        return value;
                                    }
                                }
                                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                                , WriteCharacteristicTask.TIMEOUT_MILLIS
                                , WriteCharacteristicTask.TIMEOUT_MILLIS
                                , null
                                , false);

                        if (RESULT_SUCCESS == result.getResultCode()) {
                            mBLECallbackSample.onCharacteristicWriteSuccess(0, target.getBluetoothDevice(), DEFAULT_SERVICE_UUID, WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, value, result.getArgument());
                        } else if (RESULT_FAILED == result.getResultCode()) {
                            mBLECallbackSample.onCharacteristicWriteFailed(0, target.getBluetoothDevice(), DEFAULT_SERVICE_UUID, WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, result.getStatus(), result.getArgument());
                        } else if (RESULT_TIMEOUT == result.getResultCode()) {
                            mBLECallbackSample.onCharacteristicWriteTimeout(0, target.getBluetoothDevice(), DEFAULT_SERVICE_UUID, WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, WriteCharacteristicTask.TIMEOUT_MILLIS, result.getArgument());
                        }

                    }
                }
            }.start();
        } else if (R.id.mock_characteristic == item.getItemId()) {
            mBleConnection.createWriteCharacteristicTask(MOCK_CONTROL_SERVICE_UUID
                    , MOCK_CONTROL_CHARACTERISTIC_UUID
                    , new MockControl(
                            DEFAULT_SERVICE_UUID
                            , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                            , MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID
                            , MockControl.TARGET_TYPE_CHARACTERISTIC
                            , BluetoothGatt.GATT_SUCCESS
                            , "Mocked!".getBytes()
                    )
                    , WriteCharacteristicTask.TIMEOUT_MILLIS);
        } else if (R.id.clear == item.getItemId()) {
            mBleConnection.clear();
        }
        return true;
    }


    private void updateLayout() {
        if (mBluetoothAdapter != null && !mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.enable();
        } else if (mBluetoothLeScanner == null) {
            mConnectDisconnectButton.setVisibility(View.GONE);
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);

            if (mBleConnection == null) {
                mConnectDisconnectButton.setText(R.string.connect);
            } else {
                if (mBleConnection.isConnected()) {
                    if (mBleConnection.isAttached(mBLECallbackSample)) {
                        mConnectDisconnectButton.setText(R.string.disconnect);
                    } else {
                        mConnectDisconnectButton.setText(R.string.connect);
                    }
                } else {
                    mConnectDisconnectButton.setText(R.string.connect);
                }
            }
        }
        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mBleConnection == null) {
                BluetoothDevice target = findDevice();
                if (target == null) {
                    if (mBluetoothLeScanner != null) {
                        if (mTestScanCallback == null) {
                            if (mReceiver == null) {
                                if (hasPermission()) {
                                    if (mBleConnection != null) {
                                        mBleConnection.quit();
                                        mBleConnection = null;
                                    }

                                    byte[] bytes = new byte[18];
                                    ByteBuffer bb = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
                                    bb.position(2);
                                    bb.putLong(MOCK_CONTROL_SERVICE_UUID.getLeastSignificantBits());
                                    bb.putLong(MOCK_CONTROL_SERVICE_UUID.getMostSignificantBits());
                                    mTestScanCallback = new TestScanCallback.Builder(CentralSampleActivity.this)
                                            .addFilter(new OrFilter<>(
                                                    new FlagsFilter(Flags.CREATOR.createFromByteArray(new byte[]{0, 0, 1}))
                                                    , new FlagsFilter(Flags.CREATOR.createFromByteArray(new byte[]{0, 0, 2}))))
                                            .addCompleteListOf128BitServiceUUIDsFilter(CompleteListOf128BitServiceUUIDs.CREATOR.createFromByteArray(bytes))
                                            .build();
                                    mBluetoothLeScanner.startScan(mTestScanCallback);
                                }
                            } else {
                                unregisterReceiver(mReceiver);
                                mReceiver = null;
                            }
                        } else {
                            mBluetoothLeScanner.stopScan(mTestScanCallback);
                            mTestScanCallback = null;
                        }
                    }
                } else {
                    mBleConnection = BLEConnectionHolder.getInstance(target);
                    if (mBleConnection == null) {
                        mBleConnection = new BLEConnection(this, target, null);
                        BLEConnectionHolder.addInstance(mBleConnection, true);
                    }
                    mBleConnection.attach(mBLECallbackSample);
                    if (mBleConnection.isConnected()) {
                        mBLECallbackSample.onBLEConnected(0, target, null);
                    } else {
                        mBleConnection.connect(ConnectTask.TIMEOUT_MILLIS);
                    }
                }
            } else {
                if (mBleConnection.isConnected()) {
                    if (mBleConnection.isAttached(mBLECallbackSample)) {
                        mBleConnection.detach(mBLECallbackSample);
                        mBLECallbackSample.onBLEDisconnected(0, mBleConnection.getBluetoothDevice(), BluetoothGatt.GATT_SUCCESS, null);
                    } else {
                        mBleConnection.attach(mBLECallbackSample);
                        mBLECallbackSample.onBLEConnected(0, mBleConnection.getBluetoothDevice(), null);
                    }
                } else {
                    if (mBleConnection.isAttached(mBLECallbackSample)) {
                        mBleConnection.detach(mBLECallbackSample);
                    } else {
                        mBleConnection.attach(mBLECallbackSample);
                        mBleConnection.connect(ConnectTask.TIMEOUT_MILLIS, null);
                    }
                }
            }

            updateLayout();
        } else {
            super.onClick(v);
        }
    }


    @Override
    public void onCallbacked(final Pair<String, String> log) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.add(log);
                mListView.smoothScrollToPosition(mAdapter.getCount());

                updateLayout();
            }
        });
    }

    private BluetoothDevice findDevice() {
        BluetoothDevice target = null;
        Set<BluetoothDevice> bluetoothDeviceSet = mBluetoothAdapter.getBondedDevices();
        if (bluetoothDeviceSet != null) {
            for (BluetoothDevice device : bluetoothDeviceSet) {
                ParcelUuid[] parcelUuids = device.getUuids();
                if (parcelUuids != null) {
                    for (ParcelUuid parcelUuid : parcelUuids) {
                        if (MOCK_CONTROL_SERVICE_UUID.equals(parcelUuid.getUuid())) {
                            target = device;
                            break;
                        }
                    }
                }
            }
        }
        return target;
    }
}
