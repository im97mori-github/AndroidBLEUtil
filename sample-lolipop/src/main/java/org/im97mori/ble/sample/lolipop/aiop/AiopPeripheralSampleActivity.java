package org.im97mori.ble.sample.lolipop.aiop;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Build;
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
import androidx.annotation.RequiresApi;

import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.characteristic.core.AutomationIoUtils;
import org.im97mori.ble.characteristic.u2a56.Digital;
import org.im97mori.ble.characteristic.u2a58.Analog;
import org.im97mori.ble.descriptor.u2900.CharacteristicExtendedProperties;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormat;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.descriptor.u2909.NumberOfDigitals;
import org.im97mori.ble.descriptor.u290a.ValueTriggerSetting;
import org.im97mori.ble.descriptor.u290e.TimeTriggerSetting;
import org.im97mori.ble.profile.aiop.peripheral.AutomationIOProfileMockCallback;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;

public class AiopPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private AutomationIOProfileMockCallback mAutomationIOProfileMockCallback;

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

        mAutomationIOProfileMockCallback = new AiopCallbackSample.Builder(this, this)
                .addDigital(0
                        , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE/* | BluetoothGattCharacteristic.PROPERTY_NOTIFY*/
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new Digital(new byte[]{AutomationIoUtils.DIGITAL_ACTIVE | AutomationIoUtils.DIGITAL_ACTIVE << 2 | AutomationIoUtils.DIGITAL_ACTIVE << 4 | AutomationIoUtils.DIGITAL_ACTIVE << 6, AutomationIoUtils.DIGITAL_OUTPUT_STATE}).getBytes())
                .addDigitalClientCharacteristicConfiguration(0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addDigitalCharacteristicPresentationFormat(0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                , 0
                                , 0
                                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                , new byte[]{0x01, 0x02}).getBytes())
                .addDigitalCharacteristicUserDescription(0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new CharacteristicUserDescription("CharacteristicUserDescription 0".getBytes()).getBytes())
                .addDigitalCharacteristicExtendedProperties(0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new CharacteristicExtendedProperties(false, true).getBytes())
                .addDigitalValueTriggerSetting(0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0).getBytes())
                .addDigitalTimeTriggerSetting(0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0).getBytes())
                .addDigitalNumberOfDigitals(0, BluetoothGatt.GATT_SUCCESS, 0, new NumberOfDigitals(5).getBytes())


                .addDigital(1
                        , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE/* | BluetoothGattCharacteristic.PROPERTY_INDICATE*/
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new Digital(new byte[]{AutomationIoUtils.DIGITAL_TRI_STATE | AutomationIoUtils.DIGITAL_OUTPUT_STATE << 2}).getBytes())
                .addDigitalClientCharacteristicConfiguration(1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addDigitalCharacteristicPresentationFormat(1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                , 0
                                , 0
                                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                , new byte[]{0x03, 0x04}).getBytes())
                .addDigitalCharacteristicUserDescription(1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new CharacteristicUserDescription("CharacteristicUserDescription 1".getBytes()).getBytes())
                .addDigitalCharacteristicExtendedProperties(1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new CharacteristicExtendedProperties(true, true).getBytes())
                .addDigitalValueTriggerSetting(1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0).getBytes())
                .addDigitalTimeTriggerSetting(1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0).getBytes())
                .addDigitalNumberOfDigitals(1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new NumberOfDigitals(2).getBytes())


                .addAnalog(0
                        , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE /*| BluetoothGattCharacteristic.PROPERTY_NOTIFY*/
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new Analog(new byte[]{(byte) 0xfd, (byte) 0xfe}).getBytes())
                .addAnalogClientCharacteristicConfiguration(0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addAnalogCharacteristicPresentationFormat(0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                , 0
                                , 0
                                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                , new byte[]{0x01, 0x02}).getBytes())
                .addAnalogCharacteristicUserDescription(0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new CharacteristicUserDescription("CharacteristicUserDescription 0".getBytes()).getBytes())
                .addAnalogCharacteristicExtendedProperties(0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new CharacteristicExtendedProperties(false, true).getBytes())
                .addAnalogValueTriggerSetting(0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0).getBytes())
                .addAnalogTimeTriggerSetting(0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NOT_INDICATED_OR_NOTIFIED_MORE_OFTEN_THAN_A_SETTABLE_TIME, 0, 10, 0).getBytes())
                .addAnalogValidRange(0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new ValidRange(new byte[]{0x00, 0x00}, new byte[]{(byte) 0xff, (byte) 0xff}).getBytes())


                .addAnalog(1
                        , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE/* | BluetoothGattCharacteristic.PROPERTY_INDICATE*/
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new Analog(new byte[]{0x01, 0x01}).getBytes())
                .addAnalogClientCharacteristicConfiguration(1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addAnalogCharacteristicPresentationFormat(1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                , 0
                                , 0
                                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                , new byte[]{0x03, 0x04}).getBytes())
                .addAnalogCharacteristicUserDescription(1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new CharacteristicUserDescription("CharacteristicUserDescription 1".getBytes()).getBytes())
                .addAnalogCharacteristicExtendedProperties(1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new CharacteristicExtendedProperties(true, true).getBytes())
                .addAnalogValueTriggerSetting(1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0).getBytes())
                .addAnalogTimeTriggerSetting(1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0).getBytes())
                .addAnalogValidRange(1
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , new ValidRange(new byte[]{0x01, 0x01}, new byte[]{0x03, 0x01}).getBytes())

                .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ/* | BluetoothGattCharacteristic.PROPERTY_NOTIFY*/ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                        , BluetoothGatt.GATT_SUCCESS
                        , 0)
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
        if (mAutomationIOProfileMockCallback != null) {
            mAutomationIOProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else if (mAutomationIOProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mAutomationIOProfileMockCallback.isStarted()) {
                mAutomationIOProfileMockCallback.quit();
            } else {
                mAutomationIOProfileMockCallback.start();
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
                mAutomationIOProfileMockCallback.stopAdvertising();
            }
        });
    }
}
