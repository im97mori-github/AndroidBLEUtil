package org.im97mori.ble.sample.lolipop.wsp;

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

import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a14.ReferenceTimeInformation;
import org.im97mori.ble.characteristic.u2a19.BatteryLevel;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a9d.WeightMeasurement;
import org.im97mori.ble.characteristic.u2a9e.WeightScaleFeature;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
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

        mWeightScaleProfileMockCallback = new WspCallbackSample
                .Builder(this, this, true, true, true, true)

                .addWeightScaleFeature(new WeightScaleFeature(false, true, false, WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED, WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED))
                .addWeightMeasurement(new WeightMeasurement(WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))

                .addManufacturerNameString("ManufacturerNameString wsp")
                .addModelNumberString("ModelNumberString wsp")
                .addSystemId(1, 2)

                .addBatteryLevel(0, new BatteryLevel(50))

                .addCurrentTime(new CurrentTime(2020, 10, 18, 19, 45, 50, 0, 0, 0), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addLocalTimeInformation(true, BluetoothGatt.GATT_SUCCESS, 0, new LocalTimeInformation(1, 1).getBytes())
                .addReferenceTimeInformation(new ReferenceTimeInformation(ReferenceTimeInformation.TIME_SOURCE_UNKNOWN
                        , ReferenceTimeInformation.ACCURACY_UNKNOWN
                        , 100
                        , 200))

                .addAge(new Age(1))
                .addDateOfBirth(3, 4, 5)
                .addFirstName("firstname wsp")
                .addHeight(6)
                .addGender(Gender.GENDER_UNSPECIFIED)
                .addDatabaseChangeIncrement(BluetoothGatt.GATT_SUCCESS, 0, true, BluetoothGatt.GATT_SUCCESS, 0, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE).getBytes())
                .addUserIndex()
                .addUserControlPoint(0
                        , UserControlPoint.RESPONSE_VALUE_SUCCESS
                        , UserControlPoint.RESPONSE_VALUE_SUCCESS
                        , UserControlPoint.RESPONSE_VALUE_SUCCESS
                        , UserControlPoint.RESPONSE_VALUE_SUCCESS
                        , UserControlPoint.RESPONSE_VALUE_SUCCESS
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))

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

    protected void updateLayout() {
        if (mWeightScaleProfileMockCallback.isStarted()) {
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
    public void onCallback(final Pair<String, String> log) {
        runOnUiThread(() -> {
            mAdapter.add(log);
            mListView.smoothScrollToPosition(mAdapter.getCount());

            updateLayout();

            if ("onDeviceConnected".equals(log.first)) {
                mWeightScaleProfileMockCallback.stopAdvertising();
            }
        });
    }
}
