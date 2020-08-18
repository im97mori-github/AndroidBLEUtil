package org.im97mori.ble.sample.lolipop;

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
import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.profile.pxp.peripheral.ProximityProfileMockCallback;

import java.util.LinkedList;

public class PxpPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private ProximityProfileMockCallback mProximityProfileMockCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mConnectDisconnectButton = findViewById(R.id.connectDisconnectButton);
        mAdapter = new ArrayAdapter<Pair<String, String>>(this, R.layout.list_child, new LinkedList<Pair<String, String>>()) {
            @SuppressWarnings("ConstantConditions")
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View child = convertView;
                if (child == null) {
                    child = getLayoutInflater().inflate(R.layout.list_child, parent, false);
                }
                TextView textView = child.findViewById(R.id.time);
                textView.setText(getItem(position).first);
                textView = child.findViewById(R.id.body);
                textView.setText(getItem(position).second);
                return child;
            }
        };
        mListView = findViewById(android.R.id.list);
        mListView.setAdapter(mAdapter);

        mConnectDisconnectButton.setOnClickListener(this);

        mProximityProfileMockCallback = new PxpCallbackSample.Builder(this, this)
                .addLinkLossServiceAlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT)
                .addImmediateAlertServiceAlertLevel(AlertLevel.ALERT_LEVEL_MILD_ALERT)
                .addTxPowerLevel(5)
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
        if (mProximityProfileMockCallback != null) {
            mProximityProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    private void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled()) {
            BLEUtilsAndroid.bluetoothEnable();
        } else if (mProximityProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mProximityProfileMockCallback.isStarted()) {
                mProximityProfileMockCallback.quit();
            } else {
                mProximityProfileMockCallback.start();
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

                if ("onDeviceConnected".equals(log.first)) {
                    mProximityProfileMockCallback.stopAdvertising();
                }
            }
        });
    }
}
