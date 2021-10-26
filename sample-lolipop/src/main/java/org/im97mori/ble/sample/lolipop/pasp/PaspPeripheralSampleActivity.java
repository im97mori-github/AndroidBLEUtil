package org.im97mori.ble.sample.lolipop.pasp;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.characteristic.u2a3f.AlertStatus;
import org.im97mori.ble.characteristic.u2a40.RingerControlPoint;
import org.im97mori.ble.characteristic.u2a41.RingerSetting;
import org.im97mori.ble.profile.pasp.peripheral.PhoneAlertStatusProfileMockCallback;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;

public class PaspPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private PhoneAlertStatusProfileMockCallback mPhoneAlertStatusProfileMockCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        int alertStatus = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        mPhoneAlertStatusProfileMockCallback = new PaspCallbackSample.Builder(this, this)
                .addAlertStatus(BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new AlertStatus(alertStatus).getBytes()
                        , 1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addRingerSetting(BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new RingerSetting(RingerSetting.RINGER_SETTING_NORMAL).getBytes()
                        , 1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addRingerControlPoint(new RingerControlPoint(RingerControlPoint.RINGER_CONTROL_POINT_MUTE_ONCE))
                .build();
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
        if (mPhoneAlertStatusProfileMockCallback != null) {
            mPhoneAlertStatusProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else if (mPhoneAlertStatusProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mPhoneAlertStatusProfileMockCallback.isStarted()) {
                mPhoneAlertStatusProfileMockCallback.quit();
            } else {
                mPhoneAlertStatusProfileMockCallback.start();
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

            if ("onDeviceConnected".equals(log.first)) {
                mPhoneAlertStatusProfileMockCallback.stopAdvertising();
            }
        });
    }
}
