package org.im97mori.ble.sample.lolipop.bls;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
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
import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.MockData;
import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.CompleteListOf128BitServiceUUIDsAndroid;
import org.im97mori.ble.advertising.FlagsAndroid;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallbackInterface;
import org.im97mori.ble.advertising.filter.FlagsFilter;
import org.im97mori.ble.advertising.filter.OrFilter;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;
import org.im97mori.ble.service.bls.central.BloodPressureService;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.im97mori.ble.BLEServerConnection.MOCK_CONTROL_SERVICE_UUID;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class BlsCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback, FilteredScanCallbackInterface {

    private static final String KEY_LATEST_DEVICE = "KEY_LATEST_DEVICE";

    private Button mConnectDisconnectButton;

    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeScanner mBluetoothLeScanner;

    private FilteredScanCallback mFilteredScanCallback;

    private BloodPressureService mBloodPressureService;
    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private BlsCallbackSample mBlsCallbackSample;

    private BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBlsCallbackSample = new BlsCallbackSample(new MockData(), this);

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
        if (mBluetoothLeScanner != null && mFilteredScanCallback != null) {
            mBluetoothLeScanner.stopScan(mFilteredScanCallback);
            mFilteredScanCallback = null;
        }
        if (mBloodPressureService != null) {
            mBloodPressureService.quit();
        }
        if (mReceiver != null) {
            unregisterReceiver(mReceiver);
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bls_central, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            menuItem.setEnabled(mBloodPressureService != null && mBloodPressureService.isStarted());
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.start_indicate_blood_pressure_mesurement == item.getItemId()) {
            mBloodPressureService.startBloodPressureMeasurementIndication();
        } else if (R.id.stop_indicate_blood_pressure_mesurement == item.getItemId()) {
            mBloodPressureService.stopBloodPressureMeasurementIndication();
        } else if (R.id.start_notificate_intermediate_cuff_pressure == item.getItemId()) {
            mBloodPressureService.startIntermediateCuffPressureNotification();
        } else if (R.id.stop_notificate_intermediate_cuff_pressure == item.getItemId()) {
            mBloodPressureService.stopIntermediateCuffPressureNotification();
        } else if (R.id.read_blood_pressure_feature == item.getItemId()) {
            mBloodPressureService.getBloodPressureFeature();
        }
        return true;
    }


    private void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled()) {
            BLEUtilsAndroid.bluetoothEnable();
        } else if (mBluetoothLeScanner == null) {
            mConnectDisconnectButton.setVisibility(View.GONE);
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);

            if (mBloodPressureService == null) {
                mConnectDisconnectButton.setText(R.string.connect);
            } else {
                if (mBloodPressureService.isStarted()) {
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
            if (mBloodPressureService == null) {
                BluetoothDevice target = findDevice();
                if (target == null) {
                    if (mBluetoothLeScanner != null) {
                        if (mFilteredScanCallback == null) {
                            if (mReceiver == null) {
                                if (hasPermission()) {
                                    if (mBloodPressureService != null) {
                                        mBloodPressureService.quit();
                                        mBloodPressureService = null;
                                    }

                                    byte[] bytes = new byte[18];
                                    ByteBuffer bb = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
                                    bb.position(2);
                                    bb.putLong(MOCK_CONTROL_SERVICE_UUID.getLeastSignificantBits());
                                    bb.putLong(MOCK_CONTROL_SERVICE_UUID.getMostSignificantBits());
                                    mFilteredScanCallback = new FilteredScanCallback.Builder(this, null)
                                            .addFilter(new OrFilter<>(
                                                    new FlagsFilter(FlagsAndroid.CREATOR.createFromByteArray(new byte[]{0, 0, 1}))
                                                    , new FlagsFilter(FlagsAndroid.CREATOR.createFromByteArray(new byte[]{0, 0, 2}))))
                                            .addCompleteListOf128BitServiceUUIDsFilter(CompleteListOf128BitServiceUUIDsAndroid.CREATOR.createFromByteArray(bytes))
                                            .build();
                                    mBluetoothLeScanner.startScan(mFilteredScanCallback);
                                }
                            } else {
                                unregisterReceiver(mReceiver);
                                mReceiver = null;
                            }
                        } else {
                            mBluetoothLeScanner.stopScan(mFilteredScanCallback);
                            mFilteredScanCallback = null;
                        }
                    }
                } else {
                    if (mBloodPressureService == null) {
                        BLEConnection bleConnection = new BLEConnection(this, target, null);
                        BLEConnectionHolder.addInstance(bleConnection, true);
                        mBloodPressureService = new BloodPressureService(bleConnection, mBlsCallbackSample, mBlsCallbackSample);
                    }
                    if (!mBloodPressureService.isStarted()) {
                        mBloodPressureService.start();
                    }
                }
            } else {
                if (mBloodPressureService.isStarted()) {
                    mBloodPressureService.quit();
                } else {
                    mBloodPressureService.start();
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

    private void parse(@NonNull final ScanResult scanResult) {
        BLELogUtils.stackLog(scanResult);
        if (scanResult.getScanRecord() != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (mFilteredScanCallback != null) {
                            mBluetoothLeScanner.stopScan(BlsCentralSampleActivity.this.mFilteredScanCallback);
                            mFilteredScanCallback = null;
                            BluetoothDevice device = scanResult.getDevice();
                            if (BluetoothDevice.BOND_BONDED == device.getBondState()) {
                                BLEConnection bleConnection = BLEConnectionHolder.getInstance(device);
                                if (bleConnection == null) {
                                    bleConnection = new BLEConnection(BlsCentralSampleActivity.this, device, null);
                                    BLEConnectionHolder.addInstance(bleConnection, true);
                                    BlsCentralSampleActivity.this.mBloodPressureService = new BloodPressureService(bleConnection, BlsCentralSampleActivity.this.mBlsCallbackSample, BlsCentralSampleActivity.this.mBlsCallbackSample);
                                }
                                BlsCentralSampleActivity.this.mBloodPressureService.start();
                            } else {
                                BlsCentralSampleActivity.this.mReceiver = new BroadcastReceiver() {
                                    @Override
                                    public void onReceive(Context context, Intent intent) {
                                        try {
                                            String action = intent.getAction();
                                            BLELogUtils.stackLog(action, intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE));
                                            if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)) {
                                                int state = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE);
                                                if (BluetoothDevice.BOND_BONDED == state) {
                                                    BlsCentralSampleActivity.this.getPreferences(Context.MODE_PRIVATE).edit().putString(KEY_LATEST_DEVICE, scanResult.getDevice().getAddress()).apply();
                                                    BLEConnection bleConnection = BLEConnectionHolder.getInstance(scanResult.getDevice());
                                                    if (bleConnection == null) {
                                                        bleConnection = new BLEConnection(BlsCentralSampleActivity.this, scanResult.getDevice(), null);
                                                        BLEConnectionHolder.addInstance(bleConnection, true);
                                                        BlsCentralSampleActivity.this.mBloodPressureService = new BloodPressureService(bleConnection, BlsCentralSampleActivity.this.mBlsCallbackSample, BlsCentralSampleActivity.this.mBlsCallbackSample);
                                                    }
                                                    BlsCentralSampleActivity.this.mBloodPressureService.start();
                                                    BlsCentralSampleActivity.this.unregisterReceiver(BlsCentralSampleActivity.this.mReceiver);
                                                    BlsCentralSampleActivity.this.mReceiver = null;
                                                }
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    }
                                };
                                IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
                                BlsCentralSampleActivity.this.registerReceiver(BlsCentralSampleActivity.this.mReceiver, intentFilter);
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
