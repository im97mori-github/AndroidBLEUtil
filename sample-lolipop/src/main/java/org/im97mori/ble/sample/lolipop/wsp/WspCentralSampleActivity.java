package org.im97mori.ble.sample.lolipop.wsp;

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
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.wsp.central.WeightScaleProfile;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;

import static org.im97mori.ble.BLEConstants.ErrorCodes.UNKNOWN;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class WspCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private WspCallbackSample mWspCallbackSample;
    private WeightScaleProfile mWeightScaleProfile;
    BluetoothDevice mBluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mWspCallbackSample = new WspCallbackSample(this, this);
        mWeightScaleProfile = new WeightScaleProfile(this, mWspCallbackSample);
        mWeightScaleProfile.start();

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
        if (mWeightScaleProfile != null) {
            mWeightScaleProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.wsp_central, menu);
        return true;
    }

//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        if (mWeightScaleProfile != null && mWeightScaleProfile.isConnected()) {
//            menu.setGroupEnabled(R.id.pre_connected, false);
//            menu.setGroupEnabled(R.id.connected, true);
//        } else {
//            menu.setGroupEnabled(R.id.pre_connected, true);
//            menu.setGroupEnabled(R.id.connected, false);
//        }
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.load_bonded_device == item.getItemId()) {
            Set<BluetoothDevice> bluetoothDeviceSet = mWeightScaleProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mWeightScaleProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.has_body_composition_service == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.hasBodyCompositionService();
            if (result == null) {
                text = "null";
            } else {
                text = result.toString();
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
            updateLayout();
        } else if (R.id.has_user_data_service == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.hasUserDataService();
            if (result == null) {
                text = "hasUserDataService\nnull";
            } else {
                text = "hasUserDataService\n" + result.toString();
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
            updateLayout();
        } else if (R.id.has_battery_service == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.hasBatteryService();
            if (result == null) {
                text = "hasBatteryService\nnull";
            } else {
                text = "hasBatteryService\n" + result.toString();
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
            updateLayout();
        } else if (R.id.has_current_time_service == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.hasCurrentTimeService();
            if (result == null) {
                text = "hasCurrentTimeService\nnull";
            } else {
                text = "hasCurrentTimeService\n" + result.toString();
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
            updateLayout();
        }

        return true;
    }

    private void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled()) {
            BLEUtilsAndroid.bluetoothEnable();
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);
            if (mWeightScaleProfile.isConnected()) {
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
            if (mWeightScaleProfile == null) {
                mWeightScaleProfile = new WeightScaleProfile(this, mWspCallbackSample);
                mWeightScaleProfile.start();
            }
            if (mWeightScaleProfile.isConnected()) {
                mWeightScaleProfile.disconnect();
                mWspCallbackSample.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, UNKNOWN, null);
                mBluetoothDevice = null;
            } else {
                if (mBluetoothDevice == null) {
                    mWeightScaleProfile.findWeightScaleProfileDevices(null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mWeightScaleProfile.connect(mBluetoothDevice);
                    } else {
                        mWeightScaleProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
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
