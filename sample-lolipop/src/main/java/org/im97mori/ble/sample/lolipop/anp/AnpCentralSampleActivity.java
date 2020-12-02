package org.im97mori.ble.sample.lolipop.anp;

import android.bluetooth.BluetoothDevice;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
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
import org.im97mori.ble.characteristic.u2a44.AlertNotificationControlPoint;
import org.im97mori.ble.profile.anp.central.AlertNotificationProfile;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;
import org.im97mori.ble.service.ans.AlertNotificationCategoryIdUtils;

import java.util.LinkedList;
import java.util.Set;

import static org.im97mori.ble.BLEConstants.ErrorCodes.UNKNOWN;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class AnpCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private AnpCallbackSample mAnpCallbackSample;
    private AlertNotificationProfile mAlertNotificationProfile;
    BluetoothDevice mBluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAnpCallbackSample = new AnpCallbackSample(this, this);
        mAlertNotificationProfile = new AlertNotificationProfile(this, mAnpCallbackSample);
        mAlertNotificationProfile.start();

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
        if (mAlertNotificationProfile != null) {
            mAlertNotificationProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.anp_central, menu);
        return true;
    }

//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        if (mAlertNotificationProfile != null && mAlertNotificationProfile.isConnected()) {
//            menu.setGroupEnabled(R.id.pre_connected, false);
//            menu.setGroupEnabled(R.id.connected, true);
//        } else {
//            menu.setGroupEnabled(R.id.pre_connected, true);
//            menu.setGroupEnabled(R.id.connected, false);
//        }
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.load_bonded_device == item.getItemId()) {
            Set<BluetoothDevice> bluetoothDeviceSet = mAlertNotificationProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mAlertNotificationProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.read_supported_new_alert_category == item.getItemId()) {
            mAlertNotificationProfile.getSupportedNewAlertCategory();
        } else if (R.id.get_new_alert_client_characteristic_configuration == item.getItemId()) {
            mAlertNotificationProfile.getNewAlertClientCharacteristicConfiguration();
        } else if (R.id.start_new_alert_notification == item.getItemId()) {
            mAlertNotificationProfile.startNewAlertNotification();
        } else if (R.id.stop_new_alert_notification == item.getItemId()) {
            mAlertNotificationProfile.stopNewAlertNotification();
        } else if (R.id.read_supported_unread_alert_category == item.getItemId()) {
            mAlertNotificationProfile.getSupportedUnreadAlertCategory();
        } else if (R.id.get_unread_alert_status_client_characteristic_configuration == item.getItemId()) {
            mAlertNotificationProfile.getUnreadAlertStatusClientCharacteristicConfiguration();
        } else if (R.id.start_unread_alert_status_notification == item.getItemId()) {
            mAlertNotificationProfile.startUnreadAlertStatusNotification();
        } else if (R.id.stop_unread_alert_status_notification == item.getItemId()) {
            mAlertNotificationProfile.stopUnreadAlertStatusNotification();

        } else if (R.id.enable_new_alert_simple_alert == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        } else if (R.id.enable_new_alert_email == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_EMAIL));
        } else if (R.id.enable_new_alert_news == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_NEWS));
        } else if (R.id.enable_new_alert_call == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_CALL));
        } else if (R.id.enable_new_alert_missed_call == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        } else if (R.id.enable_new_alert_sms_mms == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        } else if (R.id.enable_new_alert_voice_mail == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        } else if (R.id.enable_new_alert_schedule == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        } else if (R.id.enable_new_alert_high_prioritized == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        } else if (R.id.enable_new_alert_instant_message == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
        } else if (R.id.enable_new_alert_all == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL));

        } else if (R.id.disable_new_alert_simple_alert == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        } else if (R.id.disable_new_alert_email == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_EMAIL));
        } else if (R.id.disable_new_alert_news == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_NEWS));
        } else if (R.id.disable_new_alert_call == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_CALL));
        } else if (R.id.disable_new_alert_missed_call == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        } else if (R.id.disable_new_alert_sms_mms == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        } else if (R.id.disable_new_alert_voice_mail == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        } else if (R.id.disable_new_alert_schedule == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        } else if (R.id.disable_new_alert_high_prioritized == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        } else if (R.id.disable_new_alert_instant_message == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
        } else if (R.id.disable_new_alert_all == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_NEW_IMCOMING_ALERT_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL));

        } else if (R.id.enable_unread_alert_status_simple_alert == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        } else if (R.id.enable_unread_alert_status_email == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_EMAIL));
        } else if (R.id.enable_unread_alert_status_news == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_NEWS));
        } else if (R.id.enable_unread_alert_status_call == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_CALL));
        } else if (R.id.enable_unread_alert_status_missed_call == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        } else if (R.id.enable_unread_alert_status_sms_mms == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        } else if (R.id.enable_unread_alert_status_voice_mail == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        } else if (R.id.enable_unread_alert_status_schedule == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        } else if (R.id.enable_unread_alert_status_high_prioritized == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        } else if (R.id.enable_unread_alert_status_instant_message == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
        } else if (R.id.enable_unread_alert_status_all == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL));

        } else if (R.id.disable_unread_alert_status_simple_alert == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        } else if (R.id.disable_unread_alert_status_email == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_EMAIL));
        } else if (R.id.disable_unread_alert_status_email == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_EMAIL));
        } else if (R.id.disable_unread_alert_status_news == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_NEWS));
        } else if (R.id.disable_unread_alert_status_call == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_CALL));
        } else if (R.id.disable_unread_alert_status_missed_call == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        } else if (R.id.enable_unread_alert_status_sms_mms == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        } else if (R.id.disable_unread_alert_status_voice_mail == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        } else if (R.id.disable_unread_alert_status_schedule == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        } else if (R.id.disable_unread_alert_status_high_prioritized == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        } else if (R.id.disable_unread_alert_status_instant_message == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
        } else if (R.id.disable_unread_alert_status_all == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_DISABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL));

        } else if (R.id.notify_new_alert_simple_alert == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_NEW_INCOMING_ALERT_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        } else if (R.id.notify_new_alert_email == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_NEW_INCOMING_ALERT_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_EMAIL));
        } else if (R.id.notify_new_alert_news == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_NEW_INCOMING_ALERT_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_NEWS));
        } else if (R.id.notify_new_alert_call == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_NEW_INCOMING_ALERT_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_CALL));
        } else if (R.id.notify_new_alert_missed_call == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_NEW_INCOMING_ALERT_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        } else if (R.id.notify_new_alert_sms_mms == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_NEW_INCOMING_ALERT_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        } else if (R.id.notify_new_alert_voice_mail == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_NEW_INCOMING_ALERT_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        } else if (R.id.notify_new_alert_schedule == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_NEW_INCOMING_ALERT_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        } else if (R.id.notify_new_alert_high_prioritized == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_NEW_INCOMING_ALERT_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        } else if (R.id.notify_new_alert_instant_message == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_NEW_INCOMING_ALERT_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
        } else if (R.id.notify_new_alert_all == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_NEW_INCOMING_ALERT_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL));

        } else if (R.id.notify_unread_alert_status_simple_alert == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_UNREAD_CATEGORY_STATUS_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        } else if (R.id.notify_unread_alert_status_email == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_UNREAD_CATEGORY_STATUS_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_EMAIL));
        } else if (R.id.notify_unread_alert_status_news == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_UNREAD_CATEGORY_STATUS_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_NEWS));
        } else if (R.id.notify_unread_alert_status_call == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_UNREAD_CATEGORY_STATUS_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_CALL));
        } else if (R.id.notify_unread_alert_status_missed_call == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_UNREAD_CATEGORY_STATUS_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        } else if (R.id.notify_unread_alert_status_sms_mms == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_UNREAD_CATEGORY_STATUS_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        } else if (R.id.notify_unread_alert_status_voice_mail == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_UNREAD_CATEGORY_STATUS_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        } else if (R.id.notify_unread_alert_status_schedule == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_UNREAD_CATEGORY_STATUS_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        } else if (R.id.notify_unread_alert_status_high_prioritized == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_UNREAD_CATEGORY_STATUS_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        } else if (R.id.notify_unread_alert_status_instant_message == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_UNREAD_CATEGORY_STATUS_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
        } else if (R.id.notify_unread_alert_status_all == item.getItemId()) {
            mAlertNotificationProfile.setAlertNotificationControlPoint(new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_NOTIFY_UNREAD_CATEGORY_STATUS_IMMEDIATELY
                    , AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL));
        }
        return true;
    }

    private void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled()) {
            BLEUtilsAndroid.bluetoothEnable();
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);
            if (mAlertNotificationProfile.isConnected()) {
                mConnectDisconnectButton.setText(R.string.disconnect);
            } else if (mBluetoothDevice != null) {
                if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                    mConnectDisconnectButton.setText(R.string.connect);
                } else {
                    mConnectDisconnectButton.setText(R.string.bond);
                }
            } else {
                mConnectDisconnectButton.setText(R.string.scan_start);
            }
        }
        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mAlertNotificationProfile == null) {
                mAlertNotificationProfile = new AlertNotificationProfile(this, mAnpCallbackSample);
                mAlertNotificationProfile.start();
            }
            if (mAlertNotificationProfile.isConnected()) {
                mAlertNotificationProfile.disconnect();
                mAnpCallbackSample.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, UNKNOWN, null);
                mBluetoothDevice = null;
            } else {
                if (mBluetoothDevice == null) {
                    mAlertNotificationProfile.findAlertNotificationProfileDevices(null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mAlertNotificationProfile.connect(mBluetoothDevice);
                    } else {
                        mAlertNotificationProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
                    }
                }
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
            }
        });
    }

}
