package org.im97mori.ble.sample.lolipop.hrp;

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

import org.im97mori.ble.characteristic.u2a37.HeartRateMeasurement;
import org.im97mori.ble.characteristic.u2a38.BodySensorLocation;
import org.im97mori.ble.characteristic.u2a39.HeartRateControlPoint;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.profile.hrp.peripheral.HeartRateProfileMockCallback;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;

public class HrpPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private HeartRateProfileMockCallback mHeartRateProfileMockCallback;

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

                Pair<String, String > item = getItem(position);
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

        mHeartRateProfileMockCallback = new HrpCallbackSample.Builder(this, this)
                .addManufacturerNameString("Manufacturer Name String hrp")
                .addHeartRateMeasurement(new HeartRateMeasurement(
                                HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8 | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                                , 1
                                , 0
                                , 2
                                , new int[2])
                        , ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addBodySensorLocation(new BodySensorLocation(BodySensorLocation.BODY_SENSOR_LOCATION_OTHER))
                .addHeartRateControlPoint(new HeartRateControlPoint(~HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED))
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
        if (mHeartRateProfileMockCallback != null) {
            mHeartRateProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    protected void updateLayout() {
        if (mHeartRateProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mHeartRateProfileMockCallback.isStarted()) {
                mHeartRateProfileMockCallback.quit();
            } else {
                mHeartRateProfileMockCallback.start();
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
                mHeartRateProfileMockCallback.stopAdvertising();
            }
        });
    }
}
