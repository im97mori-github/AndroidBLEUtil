package org.im97mori.ble.sample.lolipop.pasp;

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

import org.im97mori.ble.characteristic.u2a40.RingerControlPoint;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.pasp.central.PhoneAlertStatusProfile;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;
import java.util.Set;

public class PaspCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private PaspCallbackSample mPaspCallbackSample;
    private PhoneAlertStatusProfile mPhoneAlertStatusProfile;
    BluetoothDevice mBluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPaspCallbackSample = new PaspCallbackSample(this, this);
        mPhoneAlertStatusProfile = new PhoneAlertStatusProfile(this, mPaspCallbackSample);
        mPhoneAlertStatusProfile.start();

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
        if (mPhoneAlertStatusProfile != null) {
            mPhoneAlertStatusProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pasp_central, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (mPhoneAlertStatusProfile != null && mPhoneAlertStatusProfile.isConnected()) {
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
            Set<BluetoothDevice> bluetoothDeviceSet = mPhoneAlertStatusProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mPhoneAlertStatusProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.read_alert_status == item.getItemId()) {
            mPhoneAlertStatusProfile.getAlertStatus();
        } else if (R.id.read_alert_status_characteristic_configuration == item.getItemId()) {
            mPhoneAlertStatusProfile.getAlertStatusClientCharacteristicConfiguration();
        } else if (R.id.start_notify_alert_status == item.getItemId()) {
            mPhoneAlertStatusProfile.startAlertStatusNotification();
        } else if (R.id.stop_notify_alert_status == item.getItemId()) {
            mPhoneAlertStatusProfile.stopAlertStatusNotification();
        } else if (R.id.read_ringer_setting == item.getItemId()) {
            mPhoneAlertStatusProfile.getRingerSetting();
        } else if (R.id.read_ringer_setting_characteristic_configuration == item.getItemId()) {
            mPhoneAlertStatusProfile.getRingerSettingClientCharacteristicConfiguration();
        } else if (R.id.start_notify_ringer_setting == item.getItemId()) {
            mPhoneAlertStatusProfile.startRingerSettingNotification();
        } else if (R.id.stop_notify_ringer_setting == item.getItemId()) {
            mPhoneAlertStatusProfile.stopRingerSettingNotification();
        } else if (R.id.write_ringer_control_point_1 == item.getItemId()) {
            mPhoneAlertStatusProfile.setRingerControlPoint(new RingerControlPoint(RingerControlPoint.RINGER_CONTROL_POINT_SILENT_MODE));
        } else if (R.id.write_ringer_control_point_2 == item.getItemId()) {
            mPhoneAlertStatusProfile.setRingerControlPoint(new RingerControlPoint(RingerControlPoint.RINGER_CONTROL_POINT_MUTE_ONCE));
        } else if (R.id.write_ringer_control_point_3 == item.getItemId()) {
            mPhoneAlertStatusProfile.setRingerControlPoint(new RingerControlPoint(RingerControlPoint.RINGER_CONTROL_POINT_CANCEL_SILENT_MODE));
        }

        return true;
    }

    protected void updateLayout() {
        mConnectDisconnectButton.setVisibility(View.VISIBLE);
        if (mPhoneAlertStatusProfile.isConnected()) {
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
        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mPhoneAlertStatusProfile == null) {
                mPhoneAlertStatusProfile = new PhoneAlertStatusProfile(this, mPaspCallbackSample);
                mPhoneAlertStatusProfile.start();
            }
            if (mPhoneAlertStatusProfile.isConnected()) {
                mPhoneAlertStatusProfile.disconnect();
                mPaspCallbackSample.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, STATUS_MANUAL_DISCONNECT, null);
                mBluetoothDevice = null;
            } else {
                if (mBluetoothDevice == null) {
                    mPhoneAlertStatusProfile.findDevices(null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mPhoneAlertStatusProfile.connect(mBluetoothDevice);
                    } else {
                        mPhoneAlertStatusProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
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
