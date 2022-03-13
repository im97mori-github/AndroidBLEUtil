package org.im97mori.ble.sample.jellybean.wsp;

import static org.im97mori.ble.task.DisconnectTask.STATUS_MANUAL_DISCONNECT;

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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.characteristic.core.DayOfWeekUtils;
import org.im97mori.ble.characteristic.core.ExactTime256Utils;
import org.im97mori.ble.characteristic.core.TimeZoneUtils;
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrement;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.wsp.central.WeightScaleProfile;
import org.im97mori.ble.sample.jellybean.AlertDialogFragment;
import org.im97mori.ble.sample.jellybean.BaseActivity;
import org.im97mori.ble.sample.jellybean.R;
import org.im97mori.ble.sample.jellybean.SampleCallback;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class WspCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private WspCallbackSample mWspCallbackSample;
    private WeightScaleProfile mWeightScaleProfile;
    BluetoothDevice mBluetoothDevice;

    Integer mLastRegisteredUserIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mWspCallbackSample = new WspCallbackSample(this);

        mWeightScaleProfile = new WeightScaleProfile(this, mWspCallbackSample);
        mWeightScaleProfile.start();

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
        if (mWeightScaleProfile != null) {
            mWeightScaleProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.wsp_central, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.load_bonded_device == item.getItemId()) {
            Set<BluetoothDevice> bluetoothDeviceSet = mWeightScaleProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mWeightScaleProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.has_body_composition_service == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.hasBodyCompositionService();
            if (result == null) {
                text = "hasBodyCompositionService\nnull";
            } else {
                text = "hasBodyCompositionService\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
            updateLayout();
        } else if (R.id.has_user_data_service == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.hasUserDataService();
            if (result == null) {
                text = "hasUserDataService\nnull";
            } else {
                text = "hasUserDataService\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
            updateLayout();
        } else if (R.id.has_battery_service == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.hasBatteryService();
            if (result == null) {
                text = "hasBatteryService\nnull";
            } else {
                text = "hasBatteryService\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
            updateLayout();
        } else if (R.id.has_current_time_service == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.hasCurrentTimeService();
            if (result == null) {
                text = "hasCurrentTimeService\nnull";
            } else {
                text = "hasCurrentTimeService\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
            updateLayout();
        } else if (R.id.read_weight_scale_feature == item.getItemId()) {
            mWeightScaleProfile.getWeightScaleFeature();
        } else if (R.id.start_indicate_weight_measurement == item.getItemId()) {
            mWeightScaleProfile.startWeightMeasurementIndication();
        } else if (R.id.stop_indicate_weight_measurement == item.getItemId()) {
            mWeightScaleProfile.stopWeightMeasurementIndication();
        } else if (R.id.read_manufacturer_name == item.getItemId()) {
            mWeightScaleProfile.getManufacturerNameString();
        } else if (R.id.read_model_number == item.getItemId()) {
            mWeightScaleProfile.getModelNumberString();
        } else if (R.id.has_system_id == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.hasSystemId();
            if (result == null) {
                text = "hasSystemId\nnull";
            } else {
                text = "hasSystemId\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.read_system_id == item.getItemId()) {
            mWeightScaleProfile.getSystemId();
        } else if (R.id.read_current_time == item.getItemId()) {
            mWeightScaleProfile.getCurrentTime();
        } else if (R.id.is_current_time_writable == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.isCurrentTimeCharacteristicWritable();
            if (result == null) {
                text = "isCurrentTimeCharacteristicWritable\nnull";
            } else {
                text = "isCurrentTimeCharacteristicWritable\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.write_current_time == item.getItemId()) {
            Calendar calendar = Calendar.getInstance();
            mWeightScaleProfile.setCurrentTime(new CurrentTime(calendar.get(Calendar.YEAR)
                    , calendar.get(Calendar.MONTH) + 1
                    , calendar.get(Calendar.DAY_OF_MONTH)
                    , calendar.get(Calendar.HOUR_OF_DAY)
                    , calendar.get(Calendar.MINUTE)
                    , calendar.get(Calendar.SECOND)
                    , DayOfWeekUtils.DAY_OF_WEEK_IS_NOT_KNOWN
                    , ExactTime256Utils.FRACTIONS_256_NOT_SUPPORTED
                    , CurrentTime.ADJUST_REASON_MANUAL_TIME_UPDATE));
        } else if (R.id.notify_current_time_start == item.getItemId()) {
            mWeightScaleProfile.startCurrentTimeNotification();
        } else if (R.id.notify_current_time_stop == item.getItemId()) {
            mWeightScaleProfile.stopCurrentTimeNotification();
        } else if (R.id.has_local_time_information == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.isLocalTimeInformationCharacteristicSupported();
            if (result == null) {
                text = "isLocalTimeInformationCharacteristicSupported\nnull";
            } else {
                text = "isLocalTimeInformationCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.read_local_time_information == item.getItemId()) {
            mWeightScaleProfile.getLocalTimeInformation();
        } else if (R.id.is_local_time_information_writable == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.isLocalTimeInformationCharacteristicWritable();
            if (result == null) {
                text = "isLocalTimeInformationCharacteristicWritable\nnull";
            } else {
                text = "isLocalTimeInformationCharacteristicWritable\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.write_local_time_information == item.getItemId()) {
            mWeightScaleProfile.setLocalTimeInformation(new LocalTimeInformation(TimeZoneUtils.TIME_ZONE_IS_NOT_KNOWN, 2));
        } else if (R.id.menu_has_reference_time_information == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.isReferenceTimeInformationCharacteristicSupported();
            if (result == null) {
                text = "isReferenceTimeInformationCharacteristicSupported\nnull";
            } else {
                text = "isReferenceTimeInformationCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.read_reference_time_information == item.getItemId()) {
            mWeightScaleProfile.getReferenceTimeInformation();
        } else if (R.id.read_reference_time_information == item.getItemId()) {
            mWeightScaleProfile.getReferenceTimeInformation();
        } else if (R.id.has_age == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.isAgeCharacteristicSupported();
            if (result == null) {
                text = "isAgeCharacteristicSupported\nnull";
            } else {
                text = "isAgeCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.write_user_control_point_register_new_user == item.getItemId()) {
            mWeightScaleProfile.setUserControlPoint(new UserControlPoint(UserControlPoint.OP_CODE_REGISTER_NEW_USER
                    , 0
                    , 1
                    , 0
                    , 0
                    , 0));
        } else if (R.id.write_user_control_point_consent == item.getItemId()) {
            if (mLastRegisteredUserIndex != null) {
                mWeightScaleProfile.setUserControlPoint(new UserControlPoint(UserControlPoint.OP_CODE_CONSENT
                        , mLastRegisteredUserIndex
                        , 1
                        , 0
                        , 0
                        , 0));
            }
        } else if (R.id.write_user_control_point_delete_user_data == item.getItemId()) {
            mWeightScaleProfile.setUserControlPoint(new UserControlPoint(UserControlPoint.OP_CODE_DELETE_USER_DATA
                    , 0
                    , 0
                    , 0
                    , 0
                    , 0));
        } else if (R.id.write_user_control_point_list_all_users == item.getItemId()) {
            mWeightScaleProfile.setUserControlPoint(new UserControlPoint(UserControlPoint.OP_CODE_LIST_ALL_USERS
                    , 0
                    , 0
                    , 0
                    , 0
                    , 0));
        } else if (R.id.write_user_control_point_delete_users == item.getItemId()) {
            if (mLastRegisteredUserIndex != null) {
                mWeightScaleProfile.setUserControlPoint(new UserControlPoint(UserControlPoint.OP_CODE_DELETE_USERS
                        , mLastRegisteredUserIndex
                        , 0
                        , 0
                        , 0
                        , 0));
            }
        } else if (R.id.indicate_user_control_point_start == item.getItemId()) {
            mWeightScaleProfile.startUserControlPointIndication();
        } else if (R.id.indicate_user_control_point_stop == item.getItemId()) {
            mWeightScaleProfile.stopUserControlPointIndication();
        } else if (R.id.indicate_registered_user_start == item.getItemId()) {
            mWeightScaleProfile.startRegisteredUserIndication();
        } else if (R.id.indicate_registered_user_stop == item.getItemId()) {
            mWeightScaleProfile.stopRegisteredUserIndication();
        } else if (R.id.is_database_change_increment_notificatable == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.isDatabaseChangeIncrementCharacteristicNotifySupported();
            if (result == null) {
                text = "isDatabaseChangeIncrementCharacteristicNotifySupported\nnull";
            } else {
                text = "isDatabaseChangeIncrementCharacteristicNotifySupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.read_database_change_increment == item.getItemId()) {
            mWeightScaleProfile.getDatabaseChangeIncrement();
        } else if (R.id.write_database_change_increment == item.getItemId()) {
            mWeightScaleProfile.setDatabaseChangeIncrement(new DatabaseChangeIncrement(2));
        } else if (R.id.notify_menu_database_change_increment_start == item.getItemId()) {
            mWeightScaleProfile.startDatabaseChangeIncrementNotification();
        } else if (R.id.notify_menu_database_change_increment_stop == item.getItemId()) {
            mWeightScaleProfile.stopDatabaseChangeIncrementNotification();
        } else if (R.id.read_user_index == item.getItemId()) {
            mWeightScaleProfile.getUserIndex();
        } else if (R.id.read_age == item.getItemId()) {
            mWeightScaleProfile.getAge();
        } else if (R.id.write_age == item.getItemId()) {
            mWeightScaleProfile.setAge(new Age(2));
        } else if (R.id.has_date_of_birth == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.isDateOfBirthCharacteristicSupported();
            if (result == null) {
                text = "isDateOfBirthCharacteristicSupported\nnull";
            } else {
                text = "isDateOfBirthCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.read_date_of_birth == item.getItemId()) {
            mWeightScaleProfile.getDateOfBirth();
        } else if (R.id.write_date_of_birth == item.getItemId()) {
            mWeightScaleProfile.setDateOfBirth(new DateOfBirth(6, 7, 8));
        } else if (R.id.has_first_name == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.isFirstNameCharacteristicSupported();
            if (result == null) {
                text = "isFirstNameCharacteristicSupported\nnull";
            } else {
                text = "isFirstNameCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
        } else if (R.id.read_first_name == item.getItemId()) {
            mWeightScaleProfile.getFirstName();
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.write_first_name == item.getItemId()) {
            mWeightScaleProfile.setFirstName(new FirstName("firstname wsp 2"));
        } else if (R.id.write_date_of_birth == item.getItemId()) {
            mWeightScaleProfile.setDateOfBirth(new DateOfBirth(6, 7, 8));
        } else if (R.id.has_height == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.isHeightCharacteristicSupported();
            if (result == null) {
                text = "isHeightCharacteristicSupported\nnull";
            } else {
                text = "isHeightCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.read_height == item.getItemId()) {
            mWeightScaleProfile.getHeight();
        } else if (R.id.write_height == item.getItemId()) {
            mWeightScaleProfile.setHeight(new Height(66));
        } else if (R.id.has_gender == item.getItemId()) {
            String text;
            Boolean result = mWeightScaleProfile.isGenderCharacteristicSupported();
            if (result == null) {
                text = "isGenderCharacteristicSupported\nnull";
            } else {
                text = "isGenderCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.read_gender == item.getItemId()) {
            mWeightScaleProfile.getGender();
        } else if (R.id.write_gender == item.getItemId()) {
            mWeightScaleProfile.setGender(new Gender(Gender.GENDER_FEMALE));
        }

        return true;
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);
            if (mWeightScaleProfile.isConnected()) {
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
            if (mWeightScaleProfile == null) {
                mWeightScaleProfile = new WeightScaleProfile(this, mWspCallbackSample);
                mWeightScaleProfile.start();
            }
            if (mWeightScaleProfile.isConnected()) {
                mWeightScaleProfile.disconnect();
                mWspCallbackSample.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, STATUS_MANUAL_DISCONNECT, null);
                mBluetoothDevice = null;
                mLastRegisteredUserIndex = null;
            } else {
                if (mBluetoothDevice == null) {
                    mWeightScaleProfile.findDevices(null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mWeightScaleProfile.connect(mBluetoothDevice);
                    } else {
                        mWeightScaleProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
                    }
                }
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
        });
    }

}
