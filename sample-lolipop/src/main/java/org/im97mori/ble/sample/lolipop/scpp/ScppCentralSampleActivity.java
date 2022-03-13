package org.im97mori.ble.sample.lolipop.scpp;

import static org.im97mori.ble.constants.ServiceUUID.SCAN_PARAMETERS_SERVICE;
import static org.im97mori.ble.task.DisconnectTask.STATUS_MANUAL_DISCONNECT;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.characteristic.u2a4f.ScanIntervalWindow;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.scpp.central.ScanParametersProfile;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;
import java.util.Set;

public class ScppCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ScppCallbackSample mScppCallbackSample;
    private ScanParametersProfile mScanParametersProfile;
    BluetoothDevice mBluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mScppCallbackSample = new ScppCallbackSample(this, this);
        mScanParametersProfile = new ScanParametersProfile(this, mScppCallbackSample, SCAN_PARAMETERS_SERVICE);
        mScanParametersProfile.start();

        mConnectDisconnectButton = findViewById(R.id.connectDisconnectButton);
        mAdapter = new ArrayAdapter<Pair<String, String>>(this, R.layout.list_child, new LinkedList<>()) {
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
        if (mScanParametersProfile != null) {
            mScanParametersProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.scpp_central, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (mScanParametersProfile != null && mScanParametersProfile.isConnected()) {
            menu.setGroupEnabled(R.id.pre_connected, false);
            menu.setGroupEnabled(R.id.connected, true);
        } else {
            menu.setGroupEnabled(R.id.pre_connected, true);
            menu.setGroupEnabled(R.id.connected, false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.load_bonded_device == item.getItemId()) {
            Set<BluetoothDevice> bluetoothDeviceSet = mScanParametersProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mScanParametersProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.has_scan_refresh == item.getItemId()) {
            addRow("isScanRefreshCharacteristicSupported", mScanParametersProfile.isScanRefreshCharacteristicSupported());
        } else if (R.id.write_scan_interval_window == item.getItemId()) {
            mScanParametersProfile.setScanIntervalWindow(new ScanIntervalWindow(3, 4));
        } else if (R.id.read_scan_refresh_characteristic_configuration == item.getItemId()) {
            mScanParametersProfile.getScanRefreshClientCharacteristicConfiguration();
        } else if (R.id.notify_scan_refresh_start == item.getItemId()) {
            mScanParametersProfile.startScanRefreshNotification();
        } else if (R.id.notify_scan_refresh_stop == item.getItemId()) {
            mScanParametersProfile.stopScanRefreshNotification();
        }
        return true;
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);
            if (mScanParametersProfile.isConnected()) {
                mConnectDisconnectButton.setText(R.string.disconnect);
            } else if (mBluetoothDevice != null) {
                if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                    mConnectDisconnectButton.setText(R.string.connect);
                } else {
                    mConnectDisconnectButton.setText(R.string.bond);
                }
            } else {
                mConnectDisconnectButton.setText(R.string.scan_start);
            }
        }
        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mScanParametersProfile == null) {
                mScanParametersProfile = new ScanParametersProfile(this, mScppCallbackSample, SCAN_PARAMETERS_SERVICE);
                mScanParametersProfile.start();
            }
            if (mScanParametersProfile.isConnected()) {
                mScanParametersProfile.disconnect();
                mScppCallbackSample.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, STATUS_MANUAL_DISCONNECT, null);
                mBluetoothDevice = null;
            } else {
                if (mBluetoothDevice == null) {
                    mScanParametersProfile.findDevices(null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mScanParametersProfile.connect(mBluetoothDevice);
                    } else {
                        mScanParametersProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
                    }
                }
            }
            updateLayout();
        } else {
            super.onClick(v);
        }
    }

    @Override
    public void onCallback(final Pair<String, String> log) {
        runOnUiThread(() -> {
            mAdapter.add(log);
            mListView.smoothScrollToPosition(mAdapter.getCount());

            updateLayout();
        });
    }

}
