package org.im97mori.ble.sample.lolipop;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.characteristic.AbstractCharacteristic;
import org.im97mori.ble.descriptor.ClientCharacteristicConfiguration;
import org.im97mori.ble.task.ConnectTask;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR;

public class ConnectSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private static class TestScanCallback extends ScanCallback {

        final ConnectSampleActivity mActivity;

        private TestScanCallback(ConnectSampleActivity advertisingDataSampleActivity) {
            mActivity = advertisingDataSampleActivity;
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

        private void parse(final ScanResult result) {
            if (result.getDevice() != null && "Rbt".equals(result.getDevice().getName())) {
                ScanRecord record = result.getScanRecord();
                if (record != null) {
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                mActivity.mBleConnection = new BLEConnection(mActivity, result.getDevice(), mActivity.mBLECallbackSample);
                                mActivity.mBluetoothLeScanner.stopScan(ConnectSampleActivity.TestScanCallback.this);
                                mActivity.mTestScanCallback = null;
                                mActivity.mBleConnection.connect(ConnectTask.TIMEOUT_MILLIS);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
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
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.connect, menu);
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
        if (R.id.read_led_setting_normal_state == item.getItemId()) {
            mBleConnection.createReadCharacteristicTask(UUID.fromString("ab705110-0a3a-11e8-ba89-0ed5f89f718b")
                    , UUID.fromString("ab705111-0a3a-11e8-ba89-0ed5f89f718b")
                    , ReadCharacteristicTask.TIMEOUT_MILLIS);
        } else if (R.id.write_led_setting_normal_state == item.getItemId()) {
            mBleConnection.createWriteCharacteristicTask(UUID.fromString("ab705110-0a3a-11e8-ba89-0ed5f89f718b")
                    , UUID.fromString("ab705111-0a3a-11e8-ba89-0ed5f89f718b")
                    , new AbstractCharacteristic() {
                        @Override
                        public byte[] getBytes() {
                            return new byte[]{0x00, 0x00, 0x00, 0x00, 0x00};
                        }
                    }
                    , WriteCharacteristicTask.TIMEOUT_MILLIS);
        } else if (R.id.read_cccd_latest_sensing_data == item.getItemId()) {
            mBleConnection.createReadDescriptorTask(UUID.fromString("ab705010-0a3a-11e8-ba89-0ed5f89f718b")
                    , UUID.fromString("ab705012-0a3a-11e8-ba89-0ed5f89f718b")
                    , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                    , ReadDescriptorTask.TIMEOUT_MILLIS);
        } else if (R.id.write_cccd_latest_sensing_data == item.getItemId()) {
            mBleConnection.createWriteDescriptorTask(UUID.fromString("ab705010-0a3a-11e8-ba89-0ed5f89f718b")
                    , UUID.fromString("ab705012-0a3a-11e8-ba89-0ed5f89f718b")
                    , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                    , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE)
                    , WriteDescriptorTask.TIMEOUT_MILLIS);
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
                if (mBluetoothLeScanner != null) {
                    if (mTestScanCallback == null) {
                        if (hasPermission()) {
                            if (mBleConnection != null) {
                                mBleConnection.quit();
                                mBleConnection = null;
                            }
                            mTestScanCallback = new TestScanCallback(this);
                            mBluetoothLeScanner.startScan(mTestScanCallback);
                        }
                    } else {
                        mBluetoothLeScanner.stopScan(mTestScanCallback);
                        mTestScanCallback = null;
                    }
                }
            } else {
                if (mBleConnection.isConnected()) {
                    mBleConnection.quit();
                } else {
                    mBleConnection.connect(ConnectTask.TIMEOUT_MILLIS);
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
