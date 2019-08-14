package org.im97mori.ble.sample.lolipop;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLELogUtils;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.descriptor.ClientCharacteristicConfiguration;
import org.im97mori.ble.task.ConnectTask;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.DEFAULT_SERVICE_UUID;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.INDICATABLE_CHARACTERISTIC_UUID;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.NOTIFICATABLE_CHARACTERISTIC_UUID;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_FLAGS;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class CentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private static class TestScanCallback extends ScanCallback {

        final AdvertisingDataParser mAdvertisingDataParser;
        final CentralSampleActivity mActivity;

        private TestScanCallback(CentralSampleActivity advertisingDataSampleActivity) {
            mActivity = advertisingDataSampleActivity;
            AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(false).include(DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS).include(DATA_TYPE_FLAGS);
            mAdvertisingDataParser = builder.build();
        }

        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            parse(result);
        }

        @Override
        public void onBatchScanResults(List<ScanResult> results) {
            for (ScanResult result : results) {
                parse(result);
            }
        }

        @Override
        public void onScanFailed(int errorCode) {

        }

        private void parse(final ScanResult scanResult) {
            BLELogUtils.stackLog(scanResult);
            AdvertisingDataParser.AdvertisingDataParseResult result = mAdvertisingDataParser.parse(scanResult.getScanRecord().getBytes());
            if (result.getFlags() != null
                    && (result.getFlags().isLeLimitedDiscoverableMode() || result.getFlags().isLeGeneralDiscoverableMode())
                    && result.getCompleteListOf128BitServiceUUIDs() != null
                    && !result.getCompleteListOf128BitServiceUUIDs().getUuidList().isEmpty()
                    && BLEServerConnection.CONTROL_SERVICE_UUID.equals(result.getCompleteListOf128BitServiceUUIDs().getUuidList().get(0))) {
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            mActivity.mBluetoothLeScanner.stopScan(CentralSampleActivity.TestScanCallback.this);
                            mActivity.mTestScanCallback = null;
                            BluetoothDevice device = scanResult.getDevice();
                            if (BluetoothDevice.BOND_BONDED == device.getBondState()) {
                                mActivity.mBleConnection = new BLEConnection(mActivity, device, mActivity.mBLECallbackSample);
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
                                                    mActivity.mBleConnection = new BLEConnection(mActivity, scanResult.getDevice(), mActivity.mBLECallbackSample);
                                                    mActivity.mBleConnection.connect(ConnectTask.TIMEOUT_MILLIS);
                                                    mActivity.unregisterReceiver(mActivity.mReceiver);
                                                    mActivity.mReceiver = null;
                                                }
                                            }
                                        } catch (Exception e) {
                                            BLELogUtils.stackLog(e);
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
            }
        }
    }

    private Button mConnectDisconnectButton;

    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeScanner mBluetoothLeScanner;

    private TestScanCallback mTestScanCallback;

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
                TextView textView = child.findViewById(R.id.time);
                textView.setText(getItem(position).first);
                textView = child.findViewById(R.id.body);
                textView.setText(getItem(position).second);
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
            mBleConnection.quit();
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
            menu.getItem(i).setEnabled(mBleConnection != null && mBleConnection.isConnected());
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.read == item.getItemId()) {
            mBleConnection.createReadCharacteristicTask(DEFAULT_SERVICE_UUID
                    , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                    , ReadCharacteristicTask.TIMEOUT_MILLIS);
        } else if (R.id.write == item.getItemId()) {
//            mBleConnection.createWriteCharacteristicTask(UUID.fromString("ab705110-0a3a-11e8-ba89-0ed5f89f718b")
//                    , UUID.fromString("ab705111-0a3a-11e8-ba89-0ed5f89f718b")
//                    , new AbstractCharacteristic() {
//                        @Override
//                        public byte[] getBytes() {
//                            return new byte[]{0x00, 0x00, 0x00, 0x00, 0x00};
//                        }
//                    }
//                    , WriteCharacteristicTask.TIMEOUT_MILLIS);
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
                    mConnectDisconnectButton.setText(R.string.disconnect);
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

                BluetoothDevice target = null;
                Set<BluetoothDevice> bluetoothDeviceSet = mBluetoothAdapter.getBondedDevices();
                if (bluetoothDeviceSet != null) {
                    for (BluetoothDevice device : bluetoothDeviceSet) {
                        ParcelUuid[] parcelUuids = device.getUuids();
                        if (parcelUuids != null) {
                            for (ParcelUuid parcelUuid : parcelUuids) {
                                if (BLEServerConnection.CONTROL_SERVICE_UUID.equals(parcelUuid.getUuid())) {
                                    target = device;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (target == null) {
                    if (mBluetoothLeScanner != null) {
                        if (mTestScanCallback == null) {
                            if (mReceiver == null) {
                                if (hasPermission()) {
                                    if (mBleConnection != null) {
                                        mBleConnection.quit();
                                        mBleConnection = null;
                                    }
                                    mTestScanCallback = new TestScanCallback(this);
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
                    mBleConnection = new BLEConnection(this, target, mBLECallbackSample);
                    mBleConnection.connect(ConnectTask.TIMEOUT_MILLIS);
                }
            } else {
                if (mBleConnection.isConnected()) {
                    mBleConnection.quit();
                    mBleConnection = null;
                } else {
                    mBleConnection.connect(ConnectTask.TIMEOUT_MILLIS, null);
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

}
