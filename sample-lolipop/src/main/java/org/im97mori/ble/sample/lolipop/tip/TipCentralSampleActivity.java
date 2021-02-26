package org.im97mori.ble.sample.lolipop.tip;

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
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a16.TimeUpdateControlPoint;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.tip.central.TimeProfile;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;

import static org.im97mori.ble.BLEConstants.ErrorCodes.UNKNOWN;
import static org.im97mori.ble.BLEConstants.ServiceUUID.CURRENT_TIME_SERVICE;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class TipCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private TipCallbackSample mTipCallbackSample;
    private TimeProfile mTimeProfile;
    BluetoothDevice mBluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTipCallbackSample = new TipCallbackSample(this, this);
        mTimeProfile = new TimeProfile(this, mTipCallbackSample);
        mTimeProfile.start();

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
        if (mTimeProfile != null) {
            mTimeProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tip_central, menu);
        return true;
    }

//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        if (mAlertNotificationProfile != null && mAlertNotificationProfile.isConnected()) {
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
            Set<BluetoothDevice> bluetoothDeviceSet = mTimeProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mTimeProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.has_next_dst_change_service == item.getItemId()) {
            String text;
            Boolean result = mTimeProfile.hasNextDstChangeService();
            if (result == null) {
                text = "hasNextDstChangeService\nnull";
            } else {
                text = "hasNextDstChangeService\n" + result.toString();
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
            updateLayout();
        } else if (R.id.has_reference_time_update_service == item.getItemId()) {
            String text;
            Boolean result = mTimeProfile.hasReferenceTimeUpdateService();
            if (result == null) {
                text = "hasReferenceTimeUpdateService\nnull";
            } else {
                text = "hasReferenceTimeUpdateService\n" + result.toString();
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
            updateLayout();
        } else if (R.id.read_current_time == item.getItemId()) {
            mTimeProfile.getCurrentTime();
        } else if (R.id.is_current_time_writable == item.getItemId()) {
            String text;
            Boolean result = mTimeProfile.isCurrentTimeCharacteristicWritable();
            if (result == null) {
                text = "isCurrentTimeCharacteristicWritable\nnull";
            } else {
                text = "isCurrentTimeCharacteristicWritable\n" + result.toString();
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.write_current_time == item.getItemId()) {
            Calendar calendar = Calendar.getInstance();
            mTimeProfile.setCurrentTime(new CurrentTime(calendar.get(Calendar.YEAR)
                    , calendar.get(Calendar.MONTH) + 1
                    , calendar.get(Calendar.DAY_OF_MONTH)
                    , calendar.get(Calendar.HOUR_OF_DAY)
                    , calendar.get(Calendar.MINUTE)
                    , calendar.get(Calendar.SECOND)
                    , CurrentTime.DAY_OF_WEEK_IS_NOT_KNOWN
                    , CurrentTime.FRACTIONS_256_NOT_SUPPORTED
                    , CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE));
        } else if (R.id.notify_current_time_start == item.getItemId()) {
            mTimeProfile.startCurrentTimeNotification();
        } else if (R.id.notify_current_time_stop == item.getItemId()) {
            mTimeProfile.stopCurrentTimeNotification();
        } else if (R.id.has_local_time_information == item.getItemId()) {
            String text;
            Boolean result = mTimeProfile.isLocalTimeInformationCharacteristicSupporeted();
            if (result == null) {
                text = "isLocalTimeInformationCharacteristicSupporeted\nnull";
            } else {
                text = "isLocalTimeInformationCharacteristicSupporeted\n" + result.toString();
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.read_local_time_information == item.getItemId()) {
            mTimeProfile.getLocalTimeInformation();
        } else if (R.id.is_local_time_information_writable == item.getItemId()) {
            String text;
            Boolean result = mTimeProfile.isLocalTimeInformationCharacteristicWritable();
            if (result == null) {
                text = "isLocalTimeInformationCharacteristicWritable\nnull";
            } else {
                text = "isLocalTimeInformationCharacteristicWritable\n" + result.toString();
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.write_local_time_information == item.getItemId()) {
            mTimeProfile.setLocalTimeInformation(new LocalTimeInformation(LocalTimeInformation.TIME_ZONE_IS_NOT_KNOWN, 2));
        } else if (R.id.menu_has_reference_time_information == item.getItemId()) {
            String text;
            Boolean result = mTimeProfile.isReferenceTimeInformationCharacteristicSupporeted();
            if (result == null) {
                text = "isReferenceTimeInformationCharacteristicSupporeted\nnull";
            } else {
                text = "isReferenceTimeInformationCharacteristicSupporeted\n" + result.toString();
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.read_reference_time_information == item.getItemId()) {
            mTimeProfile.getReferenceTimeInformation();
        } else if (R.id.read_time_with_dst == item.getItemId()) {
            mTimeProfile.getTimeWithDst();
        } else if (R.id.write_time_update_control_point == item.getItemId()) {
            mTimeProfile.setTimeUpdateControlPoint(new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE));
        } else if (R.id.read_time_update_state == item.getItemId()) {
            mTimeProfile.getTimeUpdateState();
        }
        return true;
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled()) {
            BLEUtilsAndroid.bluetoothEnable();
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);
            if (mTimeProfile.isConnected()) {
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
            if (mTimeProfile == null) {
                mTimeProfile = new TimeProfile(this, mTipCallbackSample);
                mTimeProfile.start();
            }
            if (mTimeProfile.isConnected()) {
                mTimeProfile.disconnect();
                mTipCallbackSample.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, UNKNOWN, null);
                mBluetoothDevice = null;
            } else {
                if (mBluetoothDevice == null) {
                    mTimeProfile.findTimeProfileDevices(CURRENT_TIME_SERVICE, null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mTimeProfile.connect(mBluetoothDevice);
                    } else {
                        mTimeProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
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
