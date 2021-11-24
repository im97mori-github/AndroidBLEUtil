package org.im97mori.ble.sample.jellybean.htp;

import static org.im97mori.ble.task.DisconnectTask.STATUS_MANUAL_DISCONNECT;

import android.bluetooth.BluetoothDevice;
import android.os.Build;
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
import androidx.annotation.RequiresApi;

import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.characteristic.u2a21.MeasurementInterval;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.htp.central.HealthThermometerProfile;
import org.im97mori.ble.sample.jellybean.AlertDialogFragment;
import org.im97mori.ble.sample.jellybean.BaseActivity;
import org.im97mori.ble.sample.jellybean.R;
import org.im97mori.ble.sample.jellybean.SampleCallback;

import java.util.LinkedList;
import java.util.Set;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class HtpCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private HtpCallbackSample mHtpCallbackSample;
    private HealthThermometerProfile mHealthThermometerProfile;
    BluetoothDevice mBluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHtpCallbackSample = new HtpCallbackSample(this);
        mHealthThermometerProfile = new HealthThermometerProfile(this, mHtpCallbackSample);
        mHealthThermometerProfile.start();

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
        if (mHealthThermometerProfile != null) {
            mHealthThermometerProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.htp_central, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (mHealthThermometerProfile != null && mHealthThermometerProfile.isConnected()) {
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
            Set<BluetoothDevice> bluetoothDeviceSet = mHealthThermometerProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mHealthThermometerProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.read_manufacturer_name == item.getItemId()) {
            mHealthThermometerProfile.getManufacturerNameString();
        } else if (R.id.read_model_number == item.getItemId()) {
            mHealthThermometerProfile.getModelNumberString();
        } else if (R.id.read_read_system_id == item.getItemId()) {
            mHealthThermometerProfile.getSystemId();
        } else if (R.id.start_indicate_temperature_measurement == item.getItemId()) {
            mHealthThermometerProfile.startTemperatureMeasurementIndication();
        } else if (R.id.stop_indicate_temperature_measurement == item.getItemId()) {
            mHealthThermometerProfile.stopHeartRateMeasurementIndication();
        } else if (R.id.read_temperature_type == item.getItemId()) {
            mHealthThermometerProfile.getTemperatureType();
        } else if (R.id.start_notify_intermediate_temperature == item.getItemId()) {
            mHealthThermometerProfile.startIntermediateTemperatureNotification();
        } else if (R.id.stop_notify_intermediate_temperature == item.getItemId()) {
            mHealthThermometerProfile.stopIntermediateTemperaturNotification();
        } else if (R.id.read_measurement_interval == item.getItemId()) {
            mHealthThermometerProfile.getMeasurementInterval();
        } else if (R.id.write_measurement_interval_0 == item.getItemId()) {
            mHealthThermometerProfile.setMeasurementInterval(new MeasurementInterval(0));
        } else if (R.id.write_measurement_interval_1 == item.getItemId()) {
            mHealthThermometerProfile.setMeasurementInterval(new MeasurementInterval(1));
        } else if (R.id.write_measurement_interval_5 == item.getItemId()) {
            mHealthThermometerProfile.setMeasurementInterval(new MeasurementInterval(5));
        } else if (R.id.write_measurement_interval_10 == item.getItemId()) {
            mHealthThermometerProfile.setMeasurementInterval(new MeasurementInterval(10));
        } else if (R.id.start_indicate_measurement_interval == item.getItemId()) {
            mHealthThermometerProfile.startMeasurementIntervalInidication();
        } else if (R.id.stop_indicate_measurement_interval == item.getItemId()) {
            mHealthThermometerProfile.stopMeasurementIntervalInidication();
        } else if (R.id.read_measurement_interval_valid_range == item.getItemId()) {
            mHealthThermometerProfile.getMeasurementIntervalValidRange();
        }
        return true;
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);
            if (mHealthThermometerProfile.isConnected()) {
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
            if (mHealthThermometerProfile == null) {
                mHealthThermometerProfile = new HealthThermometerProfile(this, mHtpCallbackSample);
                mHealthThermometerProfile.start();
            }
            if (mHealthThermometerProfile.isConnected()) {
                mHealthThermometerProfile.disconnect();
                mHtpCallbackSample.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, STATUS_MANUAL_DISCONNECT, null);
                mBluetoothDevice = null;
            } else {
                if (mBluetoothDevice == null) {
                    mHealthThermometerProfile.findDevices(null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mHealthThermometerProfile.connect(mBluetoothDevice);
                    } else {
                        mHealthThermometerProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
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
