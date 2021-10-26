package org.im97mori.ble.sample.jellybean.rscp;

import static org.im97mori.ble.constants.ErrorCodeAndroid.UNKNOWN;

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
import org.im97mori.ble.characteristic.core.SensorLocationUtils;
import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.rscp.central.RunningSpeedAndCadenceProfile;
import org.im97mori.ble.sample.jellybean.AlertDialogFragment;
import org.im97mori.ble.sample.jellybean.BaseActivity;
import org.im97mori.ble.sample.jellybean.R;
import org.im97mori.ble.sample.jellybean.SampleCallback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class RscpCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private RscpCallbackSample mRscpCallbackSample;
    private RunningSpeedAndCadenceProfile mRunningSpeedAndCadenceProfile;
    BluetoothDevice mBluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRscpCallbackSample = new RscpCallbackSample( this);
        mRunningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(this, mRscpCallbackSample);
        mRunningSpeedAndCadenceProfile.start();

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
        if (mRunningSpeedAndCadenceProfile != null) {
            mRunningSpeedAndCadenceProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rscp_central, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (mRunningSpeedAndCadenceProfile != null && mRunningSpeedAndCadenceProfile.isConnected()) {
            menu.setGroupEnabled(R.id.pre_connected, false);
            menu.setGroupEnabled(R.id.connected, true);
        } else {
            menu.setGroupEnabled(R.id.pre_connected, true);
            menu.setGroupEnabled(R.id.connected, false);
        }
        return true;
    }

    protected void addRow(@NonNull String prefix, @Nullable Object result) {
        String text;
        if (result == null) {
            text = prefix + "\nnull";
        } else {
            text = prefix + "\n" + result.toString();
        }
        mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
        mListView.smoothScrollToPosition(mAdapter.getCount());
        updateLayout();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.load_bonded_device == item.getItemId()) {
            Set<BluetoothDevice> bluetoothDeviceSet = mRunningSpeedAndCadenceProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.has_device_information_service == item.getItemId()) {
            addRow("hasDeviceInformationService", mRunningSpeedAndCadenceProfile.hasDeviceInformationService());
        } else if (R.id.is_sensor_location_characteristic_supported == item.getItemId()) {
            addRow("isSensorLocationCharacteristicSupported", mRunningSpeedAndCadenceProfile.isSensorLocationCharacteristicSupported());
        } else if (R.id.is_sc_control_point_characteristic_supported == item.getItemId()) {
            addRow("isSCControlPointCharacteristicSupported", mRunningSpeedAndCadenceProfile.isSCControlPointCharacteristicSupported());
        } else if (R.id.read_rsc_feature == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.getRSCFeature();
        } else if (R.id.read_rsc_measurement_characteristic_configuration == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.getRSCMeasurementClientCharacteristicConfiguration();
        } else if (R.id.start_notificate_rsc_measurement == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.startRSCMeasurementNotification();
        } else if (R.id.stop_notificate_rsc_measurement == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.stopRSCMeasurementNotification();
        } else if (R.id.read_sensor_location == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.getSensorLocation();
        } else if (R.id.write_sc_control_point_1 == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.setSCControlPoint(new SCControlPoint(SCControlPoint.OP_CODE_SET_CUMULATIVE_VALUE
                    , 100
                    , 0
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_sc_control_point_4 == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.setSCControlPoint(new SCControlPoint(SCControlPoint.OP_CODE_START_SENSOR_CALIBRATION
                    , 0
                    , 0
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_sc_control_point_2 == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.setSCControlPoint(new SCControlPoint(SCControlPoint.OP_CODE_UPDATE_SENSOR_LOCATION
                    , 0
                    , SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_sc_control_point_3 == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.setSCControlPoint(new SCControlPoint(SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS
                    , 0
                    , 0
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.read_sc_control_point_characteristic_configuration == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.getSCControlPointClientCharacteristicConfiguration();
        } else if (R.id.start_indicate_sc_control_point == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.startSCControlPointIndication();
        } else if (R.id.stop_indicate_sc_control_point == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.startSCControlPointIndication();
        } else if (R.id.read_manufacturer_name == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.getManufacturerNameString();
        } else if (R.id.read_model_number == item.getItemId()) {
            mRunningSpeedAndCadenceProfile.getModelNumberString();
        }

        return true;
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);
            if (mRunningSpeedAndCadenceProfile.isConnected()) {
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
            if (mRunningSpeedAndCadenceProfile == null) {
                mRunningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(this, mRscpCallbackSample);
                mRunningSpeedAndCadenceProfile.start();
            }
            if (mRunningSpeedAndCadenceProfile.isConnected()) {
                mRunningSpeedAndCadenceProfile.disconnect();
                mRscpCallbackSample.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, UNKNOWN, null);
                mBluetoothDevice = null;
            } else {
                if (mBluetoothDevice == null) {
                    mRunningSpeedAndCadenceProfile.findDevices(null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mRunningSpeedAndCadenceProfile.connect(mBluetoothDevice);
                    } else {
                        mRunningSpeedAndCadenceProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
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
