package org.im97mori.ble.sample.lolipop.cscp;

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

import org.im97mori.ble.characteristic.core.SensorLocationUtils;
import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.im97mori.ble.characteristic.u2a5b.CSCMeasurement;
import org.im97mori.ble.characteristic.u2a5c.CSCFeature;
import org.im97mori.ble.characteristic.u2a5d.SensorLocation;
import org.im97mori.ble.profile.cscp.peripheral.CyclingSpeedAndCadenceProfileMockCallback;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;

@SuppressWarnings("ConstantConditions")
public class CscpPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private CyclingSpeedAndCadenceProfileMockCallback mCyclingSpeedAndCadenceProfileMockCallback;

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

        int featureFlags = CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE
                | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE
                | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE;

        int measurementFlags = CSCMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_TRUE
                | CSCMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE;
        byte[] measurementData = new CSCMeasurement(new byte[]{(byte) measurementFlags
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
        }).getBytes();
        mCyclingSpeedAndCadenceProfileMockCallback = new CscpCallbackSample.Builder(this, this, true)
                .addCSCFeature(new CSCFeature(new byte[]{(byte) featureFlags
                        , (byte) (featureFlags >> 8)}))
                .addCSCMeasurement(BluetoothGatt.GATT_SUCCESS
                        , 0
                        , measurementData
                        , -1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                        , SCControlPoint.RESPONSE_VALUE_SUCCESS
                        , SCControlPoint.RESPONSE_VALUE_SUCCESS
                        , SCControlPoint.RESPONSE_VALUE_SUCCESS
                        , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER
                                , SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE})

                .addManufacturerNameString("Manufacturer Name String data cscp")
                .addModelNumberString("Model Number String data cscp")

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
        if (mCyclingSpeedAndCadenceProfileMockCallback != null) {
            mCyclingSpeedAndCadenceProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    protected void updateLayout() {
        if (mCyclingSpeedAndCadenceProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mCyclingSpeedAndCadenceProfileMockCallback.isStarted()) {
                mCyclingSpeedAndCadenceProfileMockCallback.quit();
            } else {
                mCyclingSpeedAndCadenceProfileMockCallback.start();
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
                mCyclingSpeedAndCadenceProfileMockCallback.stopAdvertising();
            }
        });
    }
}
