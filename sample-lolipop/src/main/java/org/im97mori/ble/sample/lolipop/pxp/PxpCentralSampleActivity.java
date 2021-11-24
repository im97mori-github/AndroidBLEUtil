package org.im97mori.ble.sample.lolipop.pxp;

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
import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.pxp.central.ProximityProfile;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;
import java.util.Set;

public class PxpCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private PxpCallbackSample mPxpCallbackSample;
    private ProximityProfile mProximityProfile;
    BluetoothDevice mBluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPxpCallbackSample = new PxpCallbackSample(this, this);
        mProximityProfile = new ProximityProfile(this, mPxpCallbackSample);
        mProximityProfile.start();

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
        if (mProximityProfile != null) {
            mProximityProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pxp_central, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (mProximityProfile != null && mProximityProfile.isConnected()) {
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
            Set<BluetoothDevice> bluetoothDeviceSet = mProximityProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mProximityProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.read_alert_level == item.getItemId()) {
            mProximityProfile.getAlertLevel();
        } else if (R.id.write_lls_alert_level_no == item.getItemId()) {
            mProximityProfile.setLinkLossServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_NO_ALERT));
        } else if (R.id.write_lls_alert_level_mild == item.getItemId()) {
            mProximityProfile.setLinkLossServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_MILD_ALERT));
        } else if (R.id.write_lls_alert_level_high == item.getItemId()) {
            mProximityProfile.setLinkLossServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT));
        } else if (R.id.write_ias_alert_level_no == item.getItemId()) {
            mProximityProfile.setImmediateAlertServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_NO_ALERT));
        } else if (R.id.write_ias_alert_level_mild == item.getItemId()) {
            mProximityProfile.setImmediateAlertServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_MILD_ALERT));
        } else if (R.id.write_ias_alert_level_high == item.getItemId()) {
            mProximityProfile.setImmediateAlertServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT));
        } else if (R.id.read_tx_power_level == item.getItemId()) {
            mProximityProfile.getTxPowerLevel();
        }
        return true;
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);
            if (mProximityProfile.isConnected()) {
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
            if (mProximityProfile == null) {
                mProximityProfile = new ProximityProfile(this, mPxpCallbackSample);
                mProximityProfile.start();
            }
            if (mProximityProfile.isConnected()) {
                mProximityProfile.disconnect();
                mPxpCallbackSample.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, STATUS_MANUAL_DISCONNECT, null);
                mBluetoothDevice = null;
            } else {
                if (mBluetoothDevice == null) {
                    mProximityProfile.findDevices(null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mProximityProfile.connect(mBluetoothDevice);
                    } else {
                        mProximityProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
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
        runOnUiThread(() -> {
            mAdapter.add(log);
            mListView.smoothScrollToPosition(mAdapter.getCount());

            updateLayout();
        });
    }

}
