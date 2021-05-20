package org.im97mori.ble.sample.lolipop.htp;

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
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_FLOAT;
import org.im97mori.ble.characteristic.core.TemperatureMeasurementUtils;
import org.im97mori.ble.characteristic.core.TemperatureTypeUtils;
import org.im97mori.ble.characteristic.u2a1c.TemperatureMeasurement;
import org.im97mori.ble.characteristic.u2a1d.TemperatureType;
import org.im97mori.ble.characteristic.u2a1e.IntermediateTemperature;
import org.im97mori.ble.characteristic.u2a21.MeasurementInterval;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.profile.htp.peripheral.HealthThermometerProfileMockCallback;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;

public class HtpPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private HealthThermometerProfileMockCallback mHealthThermometerProfileMockCallback;

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

        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT IntermediateTemperatureValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{30, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        mHealthThermometerProfileMockCallback = new HtpCallbackSample.Builder(this, this)
                .addManufacturerNameString("Manufacturer Name String htp")
                .addModelNumberString("Model Number String htp")
                .addSystemId(1, 2)
                .addTemperatureMeasurement(new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                                , temperatureMeasurementValueCelsius
                                , valueFahrenheit
                                , 0, 0, 0, 0, 0, 0
                                , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL)
                        , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addTemperatureType(new TemperatureType(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL))
                .addIntermediateTemperature(new IntermediateTemperature(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                                , IntermediateTemperatureValueCelsius
                                , valueFahrenheit
                                , 0, 0, 0, 0, 0, 0
                                , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL)
                        , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addMeasurementInterval(new MeasurementInterval(1)
                        , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                        , new ValidRange(new byte[]{1, 0}, new byte[]{5, 0}))
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
        if (mHealthThermometerProfileMockCallback != null) {
            mHealthThermometerProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled()) {
            BLEUtilsAndroid.bluetoothEnable();
        } else if (mHealthThermometerProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mHealthThermometerProfileMockCallback.isStarted()) {
                mHealthThermometerProfileMockCallback.quit();
            } else {
                mHealthThermometerProfileMockCallback.start();
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
                mHealthThermometerProfileMockCallback.stopAdvertising();
            }
        });
    }
}
