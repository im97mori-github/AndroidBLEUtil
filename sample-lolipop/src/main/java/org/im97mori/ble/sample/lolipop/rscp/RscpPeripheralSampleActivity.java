package org.im97mori.ble.sample.lolipop.rscp;

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
import org.im97mori.ble.characteristic.core.SensorLocationUtils;
import org.im97mori.ble.characteristic.u2a53.RSCMeasurement;
import org.im97mori.ble.characteristic.u2a54.RSCFeature;
import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.im97mori.ble.characteristic.u2a5d.SensorLocation;
import org.im97mori.ble.profile.rscp.peripheral.RunningSpeedAndCadenceProfileMockCallback;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;

@SuppressWarnings("ConstantConditions")
public class RscpPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private RunningSpeedAndCadenceProfileMockCallback mRunningSpeedAndCadenceProfileMockCallback;

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

        int featureFlags = RSCFeature.RSC_FEATURE_INSTANTANEOUS_STRIDE_LENGTH_MEASUREMENT_SUPPORTED_TRUE
                | RSCFeature.RSC_FEATURE_TOTAL_DISTANCE_MEASUREMENT_SUPPORTED_TRUE
                | RSCFeature.RSC_FEATURE_WALKING_OR_RUNNING_STATUS_SUPPORTED_TRUE
                | RSCFeature.RSC_FEATURE_CALIBRATION_PROCEDURE_SUPPORTED_TRUE
                | RSCFeature.RSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE;

        int measurementFlags = RSCMeasurement.FLAGS_INSTANTANEOUS_STRIDE_LENGTH_PRESENT_TRUE
                | RSCMeasurement.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | RSCMeasurement.FLAGS_WALKING_OR_RUNNING_STATUS_BITS_RUNNING;
        byte[] measurementData = new RSCMeasurement(new byte[]{(byte) measurementFlags
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
        }).getBytes();
        mRunningSpeedAndCadenceProfileMockCallback = new RscpCallbackSample.Builder(this, this, true)
                .addRSCFeature(new RSCFeature(new byte[]{(byte) featureFlags
                        , (byte) (featureFlags >> 8)}))
                .addRSCMeasurement(BluetoothGatt.GATT_SUCCESS
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
                        , SCControlPoint.RESPONSE_VALUE_SUCCESS
                        , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER
                                , SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE})

                .addManufacturerNameString("Manufacturer Name String data rscp")
                .addModelNumberString("Model Number String data rscp")

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
        if (mRunningSpeedAndCadenceProfileMockCallback != null) {
            mRunningSpeedAndCadenceProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else if (mRunningSpeedAndCadenceProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mRunningSpeedAndCadenceProfileMockCallback.isStarted()) {
                mRunningSpeedAndCadenceProfileMockCallback.quit();
            } else {
                mRunningSpeedAndCadenceProfileMockCallback.start();
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
                mRunningSpeedAndCadenceProfileMockCallback.stopAdvertising();
            }
        });
    }
}
