package org.im97mori.ble.sample.lolipop;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
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
import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.CompleteListOf128BitServiceUUIDsAndroid;
import org.im97mori.ble.advertising.FlagsAndroid;
import org.im97mori.ble.advertising.filter.AdvertisingDataFilter;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.advertising.filter.FlagsFilter;
import org.im97mori.ble.advertising.filter.OrFilter;
import org.im97mori.ble.service.bas.cental.BatteryService;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.im97mori.ble.BLEServerConnection.MOCK_CONTROL_SERVICE_UUID;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class BasCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private static final String KEY_LATEST_DEVICE = "KEY_LATEST_DEVICE";

    private static class TestScanCallback extends FilteredScanCallback {

        private static class Builder extends FilteredScanCallback.Builder {

            private final BasCentralSampleActivity mActivity;

            Builder(@NonNull BasCentralSampleActivity activity) {
                mActivity = activity;
            }

            @NonNull
            @Override
            public FilteredScanCallback build() {
                return new BasCentralSampleActivity.TestScanCallback(mFilterList, mAdvertisingDataParser, mScanCallback, mActivity);
            }

        }

        final BasCentralSampleActivity mActivity;

        private TestScanCallback(@NonNull List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> filterList, @Nullable AdvertisingDataParser parser, @Nullable ScanCallback scanCallback, @NonNull BasCentralSampleActivity advertisingDataSampleActivity) {
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
                            if (mActivity.mTestScanCallback != null) {
                                mActivity.mBluetoothLeScanner.stopScan(BasCentralSampleActivity.TestScanCallback.this);
                                mActivity.mTestScanCallback = null;
                                BluetoothDevice device = scanResult.getDevice();
                                if (BluetoothDevice.BOND_BONDED == device.getBondState()) {
                                    BLEConnection bleConnection = BLEConnectionHolder.getInstance(device);
                                    if (bleConnection == null) {
                                        bleConnection = new BLEConnection(mActivity, device, null);
                                        BLEConnectionHolder.addInstance(bleConnection, true);
                                        mActivity.mBatteryService = new BatteryService(bleConnection, mActivity.mBasMockCallbackSample, mActivity.mBasMockCallbackSample);
                                    }
                                    mActivity.mBatteryService.start();
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
                                                        mActivity.getPreferences(Context.MODE_PRIVATE).edit().putString(KEY_LATEST_DEVICE, scanResult.getDevice().getAddress()).apply();
                                                        BLEConnection bleConnection = BLEConnectionHolder.getInstance(scanResult.getDevice());
                                                        if (bleConnection == null) {
                                                            bleConnection = new BLEConnection(mActivity, scanResult.getDevice(), null);
                                                            BLEConnectionHolder.addInstance(bleConnection, true);
                                                            mActivity.mBatteryService = new BatteryService(bleConnection, mActivity.mBasMockCallbackSample, mActivity.mBasMockCallbackSample);
                                                        }
                                                        mActivity.mBatteryService.start();
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

    private FilteredScanCallback mTestScanCallback;

    private BatteryService mBatteryService;
    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private BasMockCallbackSample mBasMockCallbackSample;

    private BroadcastReceiver mReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBasMockCallbackSample = new BasMockCallbackSample.Builder(this).build();

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
        if (mBatteryService != null) {
            mBatteryService.quit();
        }
        if (mReceiver != null) {
            unregisterReceiver(mReceiver);
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bas_central, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            menuItem.setEnabled(mBatteryService != null && mBatteryService.isStarted());
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.read_battery_level == item.getItemId()) {
            mBatteryService.getBatteryLevel();
        } else if (R.id.start_notify_battery_level == item.getItemId()) {
            mBatteryService.startNotification();
        } else if (R.id.stop_notify_battery_level == item.getItemId()) {
            mBatteryService.stopNotification();
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

            if (mBatteryService == null) {
                mConnectDisconnectButton.setText(R.string.connect);
            } else {
                if (mBatteryService.isStarted()) {
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
            if (mBatteryService == null) {
                BluetoothDevice target = findDevice();
                if (target == null) {
                    if (mBluetoothLeScanner != null) {
                        if (mTestScanCallback == null) {
                            if (mReceiver == null) {
                                if (hasPermission()) {
                                    if (mBatteryService != null) {
                                        mBatteryService.quit();
                                        mBatteryService = null;
                                    }

                                    byte[] bytes = new byte[18];
                                    ByteBuffer bb = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
                                    bb.position(2);
                                    bb.putLong(MOCK_CONTROL_SERVICE_UUID.getLeastSignificantBits());
                                    bb.putLong(MOCK_CONTROL_SERVICE_UUID.getMostSignificantBits());
                                    mTestScanCallback = new TestScanCallback.Builder(BasCentralSampleActivity.this)
                                            .addFilter(new OrFilter<>(
                                                    new FlagsFilter(FlagsAndroid.CREATOR.createFromByteArray(new byte[]{0, 0, 1}))
                                                    , new FlagsFilter(FlagsAndroid.CREATOR.createFromByteArray(new byte[]{0, 0, 2}))))
                                            .addCompleteListOf128BitServiceUUIDsFilter(CompleteListOf128BitServiceUUIDsAndroid.CREATOR.createFromByteArray(bytes))
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
                    if (mBatteryService == null) {
                        BLEConnection bleConnection = new BLEConnection(this, target, null);
                        BLEConnectionHolder.addInstance(bleConnection, true);
                        mBatteryService = new BatteryService(bleConnection, mBasMockCallbackSample, mBasMockCallbackSample);
                    }
                    if (!mBatteryService.isStarted()) {
                        mBatteryService.start();
                    }
                }
            } else {
                if (mBatteryService.isStarted()) {
                    mBatteryService.quit();
                } else {
                    mBatteryService.start();
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
        String latestAddress = getPreferences(MODE_PRIVATE).getString(KEY_LATEST_DEVICE, null);
        if (latestAddress != null) {
            Set<BluetoothDevice> bluetoothDeviceSet = mBluetoothAdapter.getBondedDevices();
            if (bluetoothDeviceSet != null) {
                for (BluetoothDevice device : bluetoothDeviceSet) {
                    if (latestAddress.equals(device.getAddress())) {
                        target = device;
                        break;
                    }
                }
            }
        }
        return target;
    }

}
