package org.im97mori.ble.sample.lolipop.cpp;

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
import org.im97mori.ble.characteristic.core.DateTimeUtils;
import org.im97mori.ble.characteristic.core.SensorLocationUtils;
import org.im97mori.ble.characteristic.u2a5d.SensorLocation;
import org.im97mori.ble.characteristic.u2a63.CyclingPowerMeasurement;
import org.im97mori.ble.characteristic.u2a64.CyclingPowerVector;
import org.im97mori.ble.characteristic.u2a65.CyclingPowerFeature;
import org.im97mori.ble.characteristic.u2a66.CyclingPowerControlPoint;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.profile.cpp.peripheral.CyclingPowerProfileMockCallback;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;

public class CppPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private CyclingPowerProfileMockCallback mCyclingPowerProfileMockCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        int featureFlags = CyclingPowerFeature.CYCLING_POWER_FEATURE_ACCUMULATED_TORQUE_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_CHAIN_LENGTH_ADJUSTMENT_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_CHAIN_WEIGHT_ADJUSTMENT_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_SPAN_LENGTH_ADJUSTMENT_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_PEDAL_POWER_BALANCE_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_EXTREME_MAGNITUDES_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_EXTREME_ANGLES_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_TOP_AND_BOTTOM_DEAD_SPOT_ANGLES_SUPPORTED_TRUE
                | CyclingPowerFeature.CYCLING_POWER_FEATURE_ACCUMULATED_ENERGY_SUPPORTED_TRUE;

        int measurementFlags = CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_TRUE
                | CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_TRUE;
        byte[] measurementData = new byte[]{(byte) measurementFlags
                , (byte) (measurementFlags >> 8)

                , 1 // Instantaneous Power
                , 2

                , 3 // Pedal Power Balance

                , 4 // Accumulated Torque
                , 5

                , 6 // Wheel Revolution Data - Cumulative Wheel Revolutions
                , 7
                , 8
                , 9

                , 10 // Wheel Revolution Data - Last Wheel Event Time
                , 11

                , 12 // Crank Revolution Data- Cumulative Crank Revolutions
                , 13

                , 14 // Crank Revolution Data- Last Crank Event Time
                , 15

                , 16 // Extreme Force Magnitudes - Maximum Force Magnitude
                , 17

                , 18 // Extreme Force Magnitudes - Minimum Force Magnitude
                , 19

                , 20 // Extreme Torque Magnitudes- Maximum Torque Magnitude
                , 21

                , 22 // Extreme Torque Magnitudes- Minimum Torque Magnitude
                , 23

                , 24 // Extreme Angles - Maximum Angle, Extreme Angles - Minimum Angle
                , 25
                , 26

                , 27 // Top Dead Spot Angle
                , 28

                , 29 // Bottom Dead Spot Angle
                , 30

                , 31 // Accumulated Energy
                , 32
        };
        mCyclingPowerProfileMockCallback = new CppCallbackSample.Builder(this, this, false, false)
                .addCyclingPowerFeature(new CyclingPowerFeature(new byte[]{(byte) featureFlags
                        , (byte) (featureFlags >> 8)
                        , (byte) (featureFlags >> 16)
                        , (byte) (featureFlags >> 24)}))
                .addCyclingPowerMeasurement(BluetoothGatt.GATT_SUCCESS
                        , 0
                        , measurementData
                        , 1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                .addCyclingPowerControlPoint(BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , new byte[]{
                                SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE
                                , SensorLocationUtils.SENSOR_LOCATION_OTHER
                        }
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , new byte[]{0, 1}
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , new byte[]{2, 3}
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , new byte[]{4, 5}
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , new byte[]{6, 7}
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , new byte[]{8, 9}
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , new byte[]{10}
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , new byte[]{DateTimeUtils.YEAR_IS_NOT_KNOWN
                                , DateTimeUtils.YEAR_IS_NOT_KNOWN >> 8
                                , DateTimeUtils.MONTH_IS_NOT_KNOWN
                                , DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN
                                , 23
                                , 59
                                , 58}
                        , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                        , new byte[]{11, 12})
                .addCyclingPowerVector(new CyclingPowerVector(new byte[1])
                        , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
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
        if (mCyclingPowerProfileMockCallback != null) {
            mCyclingPowerProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    private void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled()) {
            BLEUtilsAndroid.bluetoothEnable();
        } else if (mCyclingPowerProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mCyclingPowerProfileMockCallback.isStarted()) {
                mCyclingPowerProfileMockCallback.quit();
            } else {
                mCyclingPowerProfileMockCallback.start();
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
                    mCyclingPowerProfileMockCallback.stopAdvertising();
                }
            }
        });
    }
}
