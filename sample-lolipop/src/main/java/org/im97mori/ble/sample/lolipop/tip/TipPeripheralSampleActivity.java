package org.im97mori.ble.sample.lolipop.tip;

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
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a11.TimeWithDst;
import org.im97mori.ble.characteristic.u2a14.ReferenceTimeInformation;
import org.im97mori.ble.characteristic.u2a16.TimeUpdateControlPoint;
import org.im97mori.ble.characteristic.u2a17.TimeUpdateState;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;
import org.im97mori.ble.service.tip.peripheral.TimeProfileMockCallback;

import java.util.LinkedList;

public class TipPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private TimeProfileMockCallback mTimeProfileMockCallback;

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

        mTimeProfileMockCallback = new TipCallbackSample.Builder(this, this, true, true)

                .addCurrentTime(new CurrentTime(2020, 10, 18, 19, 45, 50, 0, 0, 0), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addLocalTimeInformation(true, BluetoothGatt.GATT_SUCCESS, 0, new LocalTimeInformation(1, 1).getBytes())
                .addReferenceTimeInformation(new ReferenceTimeInformation(ReferenceTimeInformation.TIME_SOURCE_UNKNOWN
                        , ReferenceTimeInformation.ACCURACY_UNKNOWN
                        , 100
                        , 200))

                .addTimeWithDst(new TimeWithDst(2020, 10, 18, 19, 45, 50, 1))

                .addTimeUpdateControlPoint(new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE))
                .addTimeUpdateState(new TimeUpdateState(TimeUpdateState.CURRENT_STATE_IDLE, TimeUpdateState.RESULT_UPDATE_NOT_ATTEMPTED_AFTER_RESET))

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
        if (mTimeProfileMockCallback != null) {
            mTimeProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else if (mTimeProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mTimeProfileMockCallback.isStarted()) {
                mTimeProfileMockCallback.quit();
            } else {
                mTimeProfileMockCallback.start();
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

            if ("onDeviceConnected".equals(log.first)) {
                mTimeProfileMockCallback.stopAdvertising();
            }
        });
    }
}
