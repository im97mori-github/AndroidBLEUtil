package org.im97mori.ble.sample.lolipop.wsp;

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
import org.im97mori.ble.characteristic.u2a9b.BodyCompositionFeature;
import org.im97mori.ble.characteristic.u2a9c.BodyCompositionMeasurement;
import org.im97mori.ble.characteristic.u2a9d.WeightMeasurement;
import org.im97mori.ble.characteristic.u2a9e.WeightScaleFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.profile.wsp.peripheral.WeightScaleProfileMockCallback;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;

public class WspPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private WeightScaleProfileMockCallback mWeightScaleProfileMockCallback;

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

        mWeightScaleProfileMockCallback = new WspCallbackSample
//                .Builder(this, this, false, false)
                .Builder(this, this,  false, false)
//                .Builder(this, this, true, false)
//                .Builder(this, this, false, true)
                .addWeightScaleFeature(new WeightScaleFeature(false, false, false, WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED, WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED))
                .addWeightMeasurement(new WeightMeasurement(0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addManufacturerNameString("ManufacturerNameString wsp")
                .addModelNumberString("ModelNumberString wsp")
//                .addBatteryLevel(0, new BatteryLevel(50))
//                .addCurrentTime(new CurrentTime(2020, 10, 18, 19, 45, 50, 0, 0, 0), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))

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
        if (mWeightScaleProfileMockCallback != null) {
            mWeightScaleProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    private void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled()) {
            BLEUtilsAndroid.bluetoothEnable();
        } else if (mWeightScaleProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mWeightScaleProfileMockCallback.isStarted()) {
                mWeightScaleProfileMockCallback.quit();
            } else {
                mWeightScaleProfileMockCallback.start();
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
                    mWeightScaleProfileMockCallback.stopAdvertising();
                }
            }
        });
    }
}
