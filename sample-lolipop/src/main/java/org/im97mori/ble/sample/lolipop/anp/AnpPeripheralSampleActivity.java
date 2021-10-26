package org.im97mori.ble.sample.lolipop.anp;

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
import org.im97mori.ble.characteristic.core.AlertCategoryIdBitMaskUtils;
import org.im97mori.ble.characteristic.u2a47.SupportedNewAlertCategory;
import org.im97mori.ble.characteristic.u2a48.SupportedUnreadAlertCategory;
import org.im97mori.ble.profile.anp.peripheral.AlertNotificationProfileMockCallback;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;

public class AnpPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private AlertNotificationProfileMockCallback mAlertNotificationProfileMockCallback;

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

        mAlertNotificationProfileMockCallback = new AnpCallbackSample.Builder(this, this)
                .addSupportedNewAlertCategory(new SupportedNewAlertCategory(
                        AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_SUPPORTED
                                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_SUPPORTED
                                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_SUPPORTED
                                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_SUPPORTED
                                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_SUPPORTED
                                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_SUPPORTED
                                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_SUPPORTED
                                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_SUPPORTED
                        , true
                        , AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_SUPPORTED
                        | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_SUPPORTED))
                .addNewAlert(1
                        , "simpleAlertTextStringInformation"
                        , 2
                        , "emailTextStringInformation"
                        , 3
                        , "newsTextStringInformation"
                        , 4
                        , "callTextStringInformation"
                        , 5
                        , "missedCallTextStringInformation"
                        , 6
                        , "smsMmsTextStringInformation"
                        , 7
                        , "voiceMailTextStringInformation"
                        , 8
                        , "scheduleTextStringInformation"
                        , 9
                        , "highPrioritizedAlertTextStringInformation"
                        , 10
                        , "instantMessageTextStringInformation"
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_SUPPORTED
                        | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_SUPPORTED
                        | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_SUPPORTED
                        | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_SUPPORTED
                        | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_SUPPORTED
                        | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_SUPPORTED
                        | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_SUPPORTED
                        | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_SUPPORTED
                        , true
                        , AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_SUPPORTED
                        | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_SUPPORTED))
                .addUnreadAlertStatus(101
                        , 102
                        , 103
                        , 104
                        , 105
                        , 106
                        , 107
                        , 108
                        , 109
                        , 110
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                        , BluetoothGatt.GATT_SUCCESS
                        , BluetoothGatt.GATT_SUCCESS
                        , BluetoothGatt.GATT_SUCCESS
                        , BluetoothGatt.GATT_SUCCESS
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
        if (mAlertNotificationProfileMockCallback != null) {
            mAlertNotificationProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else if (mAlertNotificationProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mAlertNotificationProfileMockCallback.isStarted()) {
                mAlertNotificationProfileMockCallback.quit();
            } else {
                mAlertNotificationProfileMockCallback.start();
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
                mAlertNotificationProfileMockCallback.stopAdvertising();
            }
        });
    }
}
