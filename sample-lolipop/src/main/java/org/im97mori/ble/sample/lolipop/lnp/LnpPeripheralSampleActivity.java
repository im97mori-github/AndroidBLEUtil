package org.im97mori.ble.sample.lolipop.lnp;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
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
import org.im97mori.ble.characteristic.u2a19.BatteryLevel;
import org.im97mori.ble.characteristic.u2a67.LocationAndSpeed;
import org.im97mori.ble.characteristic.u2a68.Navigation;
import org.im97mori.ble.characteristic.u2a69.PositionQuality;
import org.im97mori.ble.characteristic.u2a6a.LNFeature;
import org.im97mori.ble.characteristic.u2a6b.LNControlPoint;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormat;
import org.im97mori.ble.profile.lnp.peripheral.LocationAndNavigationProfileMockCallback;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;

import static org.im97mori.ble.constants.UnitUUID.PERCENTAGE_UNIT;

public class LnpPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private LocationAndNavigationProfileMockCallback mLocationAndNavigationProfileMockCallback;

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

        mLocationAndNavigationProfileMockCallback = new LnpCallbackSample.Builder(this, this)
                .addManufacturerNameString("Manufacturer Name String data lnp")
                .addModelNumberString("Model Number String data lnp")
                .addBatteryLevel(0, new BatteryLevel(10))
                .addBatteryLevel(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new BatteryLevel(20).getBytes(), -1)
                .setBatteryLevelCharacteristicPresentationFormat(0, new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_8_BIT_INTEGER, 0, PERCENTAGE_UNIT, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{0x01}))
                .setBatteryLevelCharacteristicPresentationFormat(1, new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_8_BIT_INTEGER, 0, PERCENTAGE_UNIT, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{0x02}))
                .setBatteryLevelClientCharacteristicConfiguration(0, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .setBatteryLevelClientCharacteristicConfiguration(1, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addLNFeature(new LNFeature(new byte[]{1, 2, 3, 4}))
                .addLocationAndSpeed(new LocationAndSpeed(new byte[]{0, 0}), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addPositionQuality(new PositionQuality(new byte[]{0, 0}))
                .addLNControlPoint(BluetoothGatt.GATT_SUCCESS
                        , 0
                        , LNControlPoint.RESPONSE_VALUE_SUCCESS
                        , LNControlPoint.RESPONSE_VALUE_SUCCESS
                        , LNControlPoint.RESPONSE_VALUE_SUCCESS
                        , LNControlPoint.RESPONSE_VALUE_SUCCESS
                        , new byte[]{9, 10}
                        , LNControlPoint.RESPONSE_VALUE_SUCCESS
                        , "name of route 1".getBytes()
                        , LNControlPoint.RESPONSE_VALUE_SUCCESS
                        , LNControlPoint.RESPONSE_VALUE_SUCCESS
                        , LNControlPoint.RESPONSE_VALUE_SUCCESS
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                )
                .addNavigation(new Navigation(new byte[]{0, 0, 0, 0, 0, 0}), ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
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
        if (mLocationAndNavigationProfileMockCallback != null) {
            mLocationAndNavigationProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled()) {
            BLEUtilsAndroid.bluetoothEnable();
        } else if (mLocationAndNavigationProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mLocationAndNavigationProfileMockCallback.isStarted()) {
                mLocationAndNavigationProfileMockCallback.quit();
            } else {
                mLocationAndNavigationProfileMockCallback.start();
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
                mLocationAndNavigationProfileMockCallback.stopAdvertising();
            }
        });
    }
}
