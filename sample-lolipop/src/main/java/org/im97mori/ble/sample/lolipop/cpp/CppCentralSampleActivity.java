package org.im97mori.ble.sample.lolipop.cpp;

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
import org.im97mori.ble.characteristic.core.SensorLocationUtils;
import org.im97mori.ble.characteristic.u2a66.CyclingPowerControlPoint;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.cpp.central.CyclingPowerProfile;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;
import java.util.Set;

import static org.im97mori.ble.constants.ErrorCodeAndroid.UNKNOWN;

public class CppCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private CppCallbackSample mCppCallbackSample;
    private CyclingPowerProfile mCyclingPowerProfile;
    BluetoothDevice mBluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCppCallbackSample = new CppCallbackSample(this, this);
        mCyclingPowerProfile = new CyclingPowerProfile(this, mCppCallbackSample);
        mCyclingPowerProfile.start();

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
        if (mCyclingPowerProfile != null) {
            mCyclingPowerProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cpp_central, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (mCyclingPowerProfile != null && mCyclingPowerProfile.isConnected()) {
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
            Set<BluetoothDevice> bluetoothDeviceSet = mCyclingPowerProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mCyclingPowerProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.has_device_information_service == item.getItemId()) {
            addRow("hasDeviceInformationService", mCyclingPowerProfile.hasDeviceInformationService());
        } else if (R.id.has_battery_service == item.getItemId()) {
            addRow("hasBatteryService", mCyclingPowerProfile.hasBatteryService());
        } else if (R.id.is_cycling_power_control_point_characteristic_supported == item.getItemId()) {
            addRow("isCyclingPowerControlPointCharacteristicSupported", mCyclingPowerProfile.isCyclingPowerControlPointCharacteristicSupported());
        } else if (R.id.is_cycling_power_vector_characteristic_supported == item.getItemId()) {
            addRow("isCyclingPowerVectorCharacteristicSupported", mCyclingPowerProfile.isCyclingPowerVectorCharacteristicSupported());

        } else if (R.id.read_cycling_power_feature == item.getItemId()) {
            mCyclingPowerProfile.getCyclingPowerFeature();

        } else if (R.id.read_cycling_power_measurement_characteristic_configuration == item.getItemId()) {
            mCyclingPowerProfile.getCyclingPowerMeasurementClientCharacteristicConfiguration();
        } else if (R.id.start_notificate_cycling_power_measurement == item.getItemId()) {
            mCyclingPowerProfile.startCyclingPowerMeasurementNotification();
        } else if (R.id.stop_notificate_cycling_power_measurement == item.getItemId()) {
            mCyclingPowerProfile.stopCyclingPowerMeasurementNotification();

        } else if (R.id.read_sensor_location == item.getItemId()) {
            mCyclingPowerProfile.getSensorLocation();

        } else if (R.id.write_cycling_power_control_point_1 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE
                    , 15
                    , 16
                    , 17
                    , 18}));
        } else if (R.id.write_cycling_power_control_point_2 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_UPDATE_SENSOR_LOCATION
                    , SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE}));
        } else if (R.id.write_cycling_power_control_point_3 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_REQUEST_SUPPORTED_SENSOR_LOCATION}));
        } else if (R.id.write_cycling_power_control_point_4 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_SET_CRANK_LENGTH
                    , 100
                    , 101}));
        } else if (R.id.write_cycling_power_control_point_5 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_REQUEST_CRANK_LENGTH}));
        } else if (R.id.write_cycling_power_control_point_6 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_SET_CHAIN_LENGTH
                    , 102
                    , 103}));
        } else if (R.id.write_cycling_power_control_point_7 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_LENGTH}));
        } else if (R.id.write_cycling_power_control_point_8 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_SET_CHAIN_WEIGHT
                    , 104
                    , 105}));
        } else if (R.id.write_cycling_power_control_point_9 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_WEIGHT}));
        } else if (R.id.write_cycling_power_control_point_10 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_SET_SPAN_LENGTH
                    , 106
                    , 107}));
        } else if (R.id.write_cycling_power_control_point_11 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_REQUEST_SPAN_LENGTH}));
        } else if (R.id.write_cycling_power_control_point_12 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_START_OFFSET_COMPENSATION}));
        } else if (R.id.write_cycling_power_control_point_13_off == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT
                    , (byte) 0b11111111
                    , (byte) 0b00000001}));
        } else if (R.id.write_cycling_power_control_point_13_on == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT
                    , (byte) 0b00000000
                    , (byte) 0b00000000}));
        } else if (R.id.write_cycling_power_control_point_14 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_REQUEST_SAMPLING_RATE}));
        } else if (R.id.write_cycling_power_control_point_15 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_REQUEST_FACTORY_CALIBRATION_DATE}));
        } else if (R.id.write_cycling_power_control_point_16 == item.getItemId()) {
            mCyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                    CyclingPowerControlPoint.OP_CODES_START_ENHANCED_OFFSET_COMPENSATION
                    , 1}));

        } else if (R.id.read_cycling_power_control_point_characteristic_configuration == item.getItemId()) {
            mCyclingPowerProfile.getCyclingPowerControlPointClientCharacteristicConfiguration();
        } else if (R.id.start_indicate_cycling_power_control_point == item.getItemId()) {
            mCyclingPowerProfile.startCyclingPowerControlPointIndication();
        } else if (R.id.stop_indicate_cycling_power_control_point == item.getItemId()) {
            mCyclingPowerProfile.stopCyclingPowerControlPointIndication();
        } else if (R.id.read_cycling_power_vector_characteristic_configuration == item.getItemId()) {
            mCyclingPowerProfile.getCyclingPowerVectorClientCharacteristicConfiguration();
        } else if (R.id.start_notificate_cycling_power_vector == item.getItemId()) {
            mCyclingPowerProfile.startCyclingPowerVectorNotification();
        } else if (R.id.stop_notificate_cycling_power_vector == item.getItemId()) {
            mCyclingPowerProfile.stopCyclingPowerVectorNotification();
        } else if (R.id.read_manufacturer_name == item.getItemId()) {
            mCyclingPowerProfile.getManufacturerNameString();
        } else if (R.id.read_model_number == item.getItemId()) {
            mCyclingPowerProfile.getModelNumberString();
        } else if (R.id.read_battery_level_1 == item.getItemId()) {
            mCyclingPowerProfile.getBatteryLevel(0);
        } else if (R.id.read_battery_level_2 == item.getItemId()) {
            mCyclingPowerProfile.getBatteryLevel(1);
        } else if (R.id.start_notify_battery_level == item.getItemId()) {
            mCyclingPowerProfile.startBatteryLevelNotification(1);
        } else if (R.id.stop_notify_battery_level == item.getItemId()) {
            mCyclingPowerProfile.stopBatteryLevelNotification(1);
        }

        return true;
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);
            if (mCyclingPowerProfile.isConnected()) {
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
            if (mCyclingPowerProfile == null) {
                mCyclingPowerProfile = new CyclingPowerProfile(this, mCppCallbackSample);
                mCyclingPowerProfile.start();
            }
            if (mCyclingPowerProfile.isConnected()) {
                mCyclingPowerProfile.disconnect();
                mCppCallbackSample.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, UNKNOWN, null);
                mBluetoothDevice = null;
            } else {
                if (mBluetoothDevice == null) {
                    mCyclingPowerProfile.findDevices(null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mCyclingPowerProfile.connect(mBluetoothDevice);
                    } else {
                        mCyclingPowerProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
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
