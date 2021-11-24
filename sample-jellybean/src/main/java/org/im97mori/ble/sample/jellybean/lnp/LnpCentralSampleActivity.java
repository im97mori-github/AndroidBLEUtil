package org.im97mori.ble.sample.jellybean.lnp;

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
import org.im97mori.ble.characteristic.u2a6b.LNControlPoint;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.lnp.central.LocationAndNavigationProfile;
import org.im97mori.ble.sample.jellybean.AlertDialogFragment;
import org.im97mori.ble.sample.jellybean.BaseActivity;
import org.im97mori.ble.sample.jellybean.R;
import org.im97mori.ble.sample.jellybean.SampleCallback;

import java.util.LinkedList;
import java.util.Set;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class LnpCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private LnpCallbackSample mLnpCallbackSample;
    private LocationAndNavigationProfile mLocationAndNavigationProfile;
    BluetoothDevice mBluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLnpCallbackSample = new LnpCallbackSample(this);
        mLocationAndNavigationProfile = new LocationAndNavigationProfile(this, mLnpCallbackSample);
        mLocationAndNavigationProfile.start();

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
        if (mLocationAndNavigationProfile != null) {
            mLocationAndNavigationProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lnp_central, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (mLocationAndNavigationProfile != null && mLocationAndNavigationProfile.isConnected()) {
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
            Set<BluetoothDevice> bluetoothDeviceSet = mLocationAndNavigationProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mLocationAndNavigationProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.read_manufacturer_name == item.getItemId()) {
            mLocationAndNavigationProfile.getManufacturerNameString();
        } else if (R.id.read_model_number == item.getItemId()) {
            mLocationAndNavigationProfile.getModelNumberString();
        } else if (R.id.read_battery_level_1 == item.getItemId()) {
            mLocationAndNavigationProfile.getBatteryLevel(0);
        } else if (R.id.read_battery_level_2 == item.getItemId()) {
            mLocationAndNavigationProfile.getBatteryLevel(1);
        } else if (R.id.start_notify_battery_level == item.getItemId()) {
            mLocationAndNavigationProfile.startBatteryLevelNotification(1);
        } else if (R.id.stop_notify_battery_level == item.getItemId()) {
            mLocationAndNavigationProfile.stopBatteryLevelNotification(1);
        } else if (R.id.read_ln_feature == item.getItemId()) {
            mLocationAndNavigationProfile.getLNFeature();
        } else if (R.id.start_location_and_speed == item.getItemId()) {
            mLocationAndNavigationProfile.startLocationAndSpeedNotification();
        } else if (R.id.stop_location_and_speed == item.getItemId()) {
            mLocationAndNavigationProfile.stopLocationAndSpeedNotification();
        } else if (R.id.read_position_quality == item.getItemId()) {
            mLocationAndNavigationProfile.getPositionQuality();
        } else if (R.id.write_ln_control_point_1 == item.getItemId()) {
            mLocationAndNavigationProfile.setLNControlPoint(new LNControlPoint(
                    LNControlPoint.OP_CODES_SET_CUMULATIVE_VALUE
                    , new byte[]{1, 2, 3}
                    , 0
                    , 0
                    , new byte[0]
            ));
        } else if (R.id.write_ln_control_point_2 == item.getItemId()) {
            mLocationAndNavigationProfile.setLNControlPoint(new LNControlPoint(
                    LNControlPoint.OP_CODES_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT
                    , new byte[]{4, 5}
                    , 0
                    , 0
                    , new byte[0]
            ));
        } else if (R.id.write_ln_control_point_3 == item.getItemId()) {
            mLocationAndNavigationProfile.setLNControlPoint(new LNControlPoint(
                    LNControlPoint.OP_CODES_NAVIGATION_CONTROL
                    , new byte[]{6}
                    , 0
                    , 0
                    , new byte[0]
            ));
        } else if (R.id.write_ln_control_point_4 == item.getItemId()) {
            mLocationAndNavigationProfile.setLNControlPoint(new LNControlPoint(
                    LNControlPoint.OP_CODES_REQUEST_NUMBER_OF_ROUTES
                    , new byte[]{7, 8}
                    , 0
                    , 0
                    , new byte[0]
            ));
        } else if (R.id.write_ln_control_point_5 == item.getItemId()) {
            mLocationAndNavigationProfile.setLNControlPoint(new LNControlPoint(
                    LNControlPoint.OP_CODES_REQUEST_NAME_OF_ROUTE
                    , new byte[]{9, 10}
                    , 0
                    , 0
                    , new byte[0]
            ));
        } else if (R.id.write_ln_control_point_6 == item.getItemId()) {
            mLocationAndNavigationProfile.setLNControlPoint(new LNControlPoint(
                    LNControlPoint.OP_CODES_SELECT_ROUTE
                    , new byte[]{11, 12}
                    , 0
                    , 0
                    , new byte[0]
            ));
        } else if (R.id.write_ln_control_point_7 == item.getItemId()) {
            mLocationAndNavigationProfile.setLNControlPoint(new LNControlPoint(
                    LNControlPoint.OP_CODES_SET_FIX_RATE
                    , new byte[]{13}
                    , 0
                    , 0
                    , new byte[0]
            ));
        } else if (R.id.write_ln_control_point_8 == item.getItemId()) {
            mLocationAndNavigationProfile.setLNControlPoint(new LNControlPoint(
                    LNControlPoint.OP_CODES_SET_ELEVATION
                    , new byte[]{14, 15, 16}
                    , 0
                    , 0
                    , new byte[0]
            ));
        } else if (R.id.get_ln_control_point_client_characteristic_configuration == item.getItemId()) {
            mLocationAndNavigationProfile.getLNControlPointClientCharacteristicConfiguration();
        } else if (R.id.start_ln_control_point == item.getItemId()) {
            mLocationAndNavigationProfile.startLNControlPointIndication();
        } else if (R.id.stop_ln_control_point == item.getItemId()) {
            mLocationAndNavigationProfile.stopLNControlPointIndication();
        } else if (R.id.start_navigation == item.getItemId()) {
            mLocationAndNavigationProfile.startNavigationNotification();
        } else if (R.id.stop_navigation == item.getItemId()) {
            mLocationAndNavigationProfile.stopNavigationNotification();
        }
        return true;
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);
            if (mLocationAndNavigationProfile.isConnected()) {
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
            if (mLocationAndNavigationProfile == null) {
                mLocationAndNavigationProfile = new LocationAndNavigationProfile(this, mLnpCallbackSample);
                mLocationAndNavigationProfile.start();
            }
            if (mLocationAndNavigationProfile.isConnected()) {
                mLocationAndNavigationProfile.disconnect();
                mLnpCallbackSample.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, STATUS_MANUAL_DISCONNECT, null);
                mBluetoothDevice = null;
            } else {
                if (mBluetoothDevice == null) {
                    mLocationAndNavigationProfile.findDevices(null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mLocationAndNavigationProfile.connect(mBluetoothDevice);
                    } else {
                        mLocationAndNavigationProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
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
