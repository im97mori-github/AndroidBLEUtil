package org.im97mori.ble.sample.lolipop.blp;

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

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.BloodPressureMeasurementUtils;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;
import org.im97mori.ble.characteristic.u2a35.BloodPressureMeasurement;
import org.im97mori.ble.characteristic.u2a36.IntermediateCuffPressure;
import org.im97mori.ble.characteristic.u2a49.BloodPressureFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.profile.blp.peripheral.BloodPressureProfileMockCallback;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.Calendar;
import java.util.LinkedList;

public class BlpPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private BloodPressureProfileMockCallback mBloodPressureProfileMockCallback;

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

        Calendar calendar = Calendar.getInstance();

        mBloodPressureProfileMockCallback = new BlpCallbackSample.Builder(this, this)
                .addManufacturerNameString("Manufacturer Name String data blp")
                .addModelNumberString("Model Number String data blp")
                .addBloodPressureMeasurement(new BloodPressureMeasurement(BloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG | BloodPressureMeasurementUtils.FLAG_TIME_STAMP_PRESENT | BloodPressureMeasurementUtils.FLAG_PULSE_RATE_PRESENT | BloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT | BloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                                , new IEEE_11073_20601_SFLOAT(new byte[]{0x6e, 0x00}, 0)
                                , new IEEE_11073_20601_SFLOAT(new byte[]{0x5a, 0x00}, 0)
                                , new IEEE_11073_20601_SFLOAT(new byte[]{0x64, 0x00}, 0)
                                , new IEEE_11073_20601_SFLOAT(new byte[2], 0)
                                , new IEEE_11073_20601_SFLOAT(new byte[2], 0)
                                , new IEEE_11073_20601_SFLOAT(new byte[2], 0)
                                , calendar.get(Calendar.YEAR)
                                , calendar.get(Calendar.MONTH) + 1
                                , calendar.get(Calendar.DAY_OF_MONTH)
                                , calendar.get(Calendar.HOUR)
                                , calendar.get(Calendar.MINUTE)
                                , calendar.get(Calendar.SECOND)
                                , new IEEE_11073_20601_SFLOAT(new byte[]{(byte) 0x96, 0}, 0)
                                , 0
                                , new byte[2]
                        )
                        , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addIntermediateCuffPressure(new IntermediateCuffPressure(
                                BloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_KPA | BloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT | BloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT | BloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT | BloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                                , new IEEE_11073_20601_SFLOAT(new byte[2], 0)
                                , new IEEE_11073_20601_SFLOAT(new byte[]{0x6e, 0x00}, 0)
                                , new IEEE_11073_20601_SFLOAT(new byte[]{(byte) BLEUtils.SFLOAT_NAN, (byte) (BLEUtils.SFLOAT_NAN >> 8)}, 0)
                                , new IEEE_11073_20601_SFLOAT(new byte[]{(byte) BLEUtils.SFLOAT_NAN, (byte) (BLEUtils.SFLOAT_NAN >> 8)}, 0)
                                , 0
                                , 0
                                , 0
                                , 0
                                , 0
                                , 0
                                , new IEEE_11073_20601_SFLOAT(new byte[2], 0)
                                , 0
                                , new byte[2])
                        , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addBloodPressureFeature(new BloodPressureFeature(false, false, false, false, false, false, false, false, false))
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
        if (mBloodPressureProfileMockCallback != null) {
            mBloodPressureProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    protected void updateLayout() {
        if (mBloodPressureProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mBloodPressureProfileMockCallback.isStarted()) {
                mBloodPressureProfileMockCallback.quit();
            } else {
                mBloodPressureProfileMockCallback.start();
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
                mBloodPressureProfileMockCallback.stopAdvertising();
            }
        });
    }
}
