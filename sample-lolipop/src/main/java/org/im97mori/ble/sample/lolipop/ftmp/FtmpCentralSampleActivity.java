package org.im97mori.ble.sample.lolipop.ftmp;

import static org.im97mori.ble.task.DisconnectTask.STATUS_MANUAL_DISCONNECT;

import android.bluetooth.BluetoothDevice;
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

import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8b.FiveZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8d.HeartRateMax;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a91.MaximumRecommendedHeartRate;
import org.im97mori.ble.characteristic.u2a92.RestingHeartRate;
import org.im97mori.ble.characteristic.u2a94.ThreeZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a95.TwoZoneHeartRateLimit;
import org.im97mori.ble.characteristic.u2a96.VO2Max;
import org.im97mori.ble.characteristic.u2a98.Weight;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrement;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.characteristic.u2aa2.Language;
import org.im97mori.ble.characteristic.u2ad9.FitnessMachineControlPoint;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.ftmp.central.FitnessMachineProfile;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;

public class FtmpCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private FtmpCallbackSample mFtmpCallbackSample;
    private FitnessMachineProfile mFitnessMachineProfile;
    BluetoothDevice mBluetoothDevice;

    Integer mLastRegisteredUserIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFtmpCallbackSample = new FtmpCallbackSample(this, this);
        mFtmpCallbackSample.mFtmpCentralSampleActivity = this;
        mFitnessMachineProfile = new FitnessMachineProfile(this, mFtmpCallbackSample);
        mFitnessMachineProfile.start();

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
        if (mFitnessMachineProfile != null) {
            mFitnessMachineProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ftmp_central, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (mFitnessMachineProfile != null && mFitnessMachineProfile.isConnected()) {
            menu.setGroupEnabled(R.id.pre_connected, false);
            menu.setGroupEnabled(R.id.connected, true);
        } else {
            menu.setGroupEnabled(R.id.pre_connected, true);
            menu.setGroupEnabled(R.id.connected, false);
        }
        return true;
    }

    protected void addRow(@NonNull String prefix, @Nullable Object result) {
        String text;
        if (result == null) {
            text = prefix + "\nnull";
        } else {
            text = prefix + "\n" + result;
        }
        mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
        mListView.smoothScrollToPosition(mAdapter.getCount());
        updateLayout();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.load_bonded_device == item.getItemId()) {
            Set<BluetoothDevice> bluetoothDeviceSet = mFitnessMachineProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mFitnessMachineProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.has_user_data_service == item.getItemId()) {
            addRow("hasUserDataService", mFitnessMachineProfile.hasUserDataService());
        } else if (R.id.has_device_information_service == item.getItemId()) {
            addRow("hasDeviceInformationService", mFitnessMachineProfile.hasDeviceInformationService());
        } else if (R.id.is_treadmill_data_characteristic_supported == item.getItemId()) {
            addRow("isTreadmillDataCharacteristicSupported", mFitnessMachineProfile.isTreadmillDataCharacteristicSupported());
        } else if (R.id.is_cross_trainer_data_characteristic_supported == item.getItemId()) {
            addRow("isCrossTrainerDataCharacteristicSupported", mFitnessMachineProfile.isCrossTrainerDataCharacteristicSupported());
        } else if (R.id.is_step_climber_data_characteristic_supported == item.getItemId()) {
            addRow("isStepClimberDataCharacteristicSupported", mFitnessMachineProfile.isStepClimberDataCharacteristicSupported());
        } else if (R.id.is_stair_climber_data_characteristic_supported == item.getItemId()) {
            addRow("isStairClimberDataCharacteristicSupported", mFitnessMachineProfile.isStairClimberDataCharacteristicSupported());
        } else if (R.id.is_rower_data_characteristic_supported == item.getItemId()) {
            addRow("isRowerDataCharacteristicSupported", mFitnessMachineProfile.isRowerDataCharacteristicSupported());
        } else if (R.id.is_indoor_bike_data_characteristic_supported == item.getItemId()) {
            addRow("isIndoorBikeDataCharacteristicSupported", mFitnessMachineProfile.isIndoorBikeDataCharacteristicSupported());
        } else if (R.id.is_training_status_characteristic_supported == item.getItemId()) {
            addRow("isTrainingStatusCharacteristicSupported", mFitnessMachineProfile.isTrainingStatusCharacteristicSupported());
        } else if (R.id.is_supported_speed_range_characteristic_supported == item.getItemId()) {
            addRow("isSupportedSpeedRangeCharacteristicSupported", mFitnessMachineProfile.isSupportedSpeedRangeCharacteristicSupported());
        } else if (R.id.is_supported_inclination_range_characteristic_supported == item.getItemId()) {
            addRow("isSupportedInclinationRangeCharacteristicSupported", mFitnessMachineProfile.isSupportedInclinationRangeCharacteristicSupported());
        } else if (R.id.is_supported_resistance_level_range_characteristic_supported == item.getItemId()) {
            addRow("isSupportedResistanceLevelRangeCharacteristicSupported", mFitnessMachineProfile.isSupportedResistanceLevelRangeCharacteristicSupported());
        } else if (R.id.is_supported_power_range_characteristic_supported == item.getItemId()) {
            addRow("isSupportedPowerRangeCharacteristicSupported", mFitnessMachineProfile.isSupportedPowerRangeCharacteristicSupported());
        } else if (R.id.is_supported_heart_rate_range_characteristic_supported == item.getItemId()) {
            addRow("isSupportedHeartRateRangeCharacteristicSupported", mFitnessMachineProfile.isSupportedHeartRateRangeCharacteristicSupported());
        } else if (R.id.is_fitness_machine_control_point_characteristic_supported == item.getItemId()) {
            addRow("isFitnessMachineControlPointCharacteristicSupported", mFitnessMachineProfile.isFitnessMachineControlPointCharacteristicSupported());
        } else if (R.id.is_fitness_machine_status_characteristic_supported == item.getItemId()) {
            addRow("isFitnessMachineStatusCharacteristicSupported", mFitnessMachineProfile.isFitnessMachineStatusCharacteristicSupported());
        } else if (R.id.read_fitness_machine_feature == item.getItemId()) {
            mFitnessMachineProfile.getFitnessMachineFeature();
        } else if (R.id.read_treadmill_data_characteristic_configuration == item.getItemId()) {
            mFitnessMachineProfile.getTreadmillDataClientCharacteristicConfiguration();
        } else if (R.id.start_notify_treadmill_data == item.getItemId()) {
            mFitnessMachineProfile.startTreadmillDataNotification();
        } else if (R.id.stop_notify_treadmill_data == item.getItemId()) {
            mFitnessMachineProfile.stopTreadmillDataNotification();

        } else if (R.id.read_cross_trainer_data_characteristic_configuration == item.getItemId()) {
            mFitnessMachineProfile.getCrossTrainerDataClientCharacteristicConfiguration();
        } else if (R.id.start_notify_cross_trainer_data == item.getItemId()) {
            mFitnessMachineProfile.startCrossTrainerDataNotification();
        } else if (R.id.stop_notify_cross_trainer_data == item.getItemId()) {
            mFitnessMachineProfile.stopCrossTrainerDataNotification();

        } else if (R.id.read_step_climber_data_characteristic_configuration == item.getItemId()) {
            mFitnessMachineProfile.getStepClimberDataClientCharacteristicConfiguration();
        } else if (R.id.start_notify_step_climber_data == item.getItemId()) {
            mFitnessMachineProfile.startStepClimberDataNotification();
        } else if (R.id.stop_notify_step_climber_data == item.getItemId()) {
            mFitnessMachineProfile.stopStepClimberDataNotification();

        } else if (R.id.read_stair_climber_data_characteristic_configuration == item.getItemId()) {
            mFitnessMachineProfile.getStairClimberDataClientCharacteristicConfiguration();
        } else if (R.id.start_notify_stair_climber_data == item.getItemId()) {
            mFitnessMachineProfile.startStairClimberDataNotification();
        } else if (R.id.stop_notify_stair_climber_data == item.getItemId()) {
            mFitnessMachineProfile.stopStairClimberDataNotification();

        } else if (R.id.read_rower_data_characteristic_configuration == item.getItemId()) {
            mFitnessMachineProfile.getRowerDataClientCharacteristicConfiguration();
        } else if (R.id.start_notify_rower_data == item.getItemId()) {
            mFitnessMachineProfile.startRowerDataNotification();
        } else if (R.id.stop_notify_rower_data == item.getItemId()) {
            mFitnessMachineProfile.stopRowerDataNotification();

        } else if (R.id.read_indoor_bike_data_characteristic_configuration == item.getItemId()) {
            mFitnessMachineProfile.getIndoorBikeDataClientCharacteristicConfiguration();
        } else if (R.id.start_notify_indoor_bike_data == item.getItemId()) {
            mFitnessMachineProfile.startIndoorBikeDataNotification();
        } else if (R.id.stop_notify_indoor_bike_data == item.getItemId()) {
            mFitnessMachineProfile.stopIndoorBikeDataNotification();

        } else if (R.id.read_training_status == item.getItemId()) {
            mFitnessMachineProfile.getTrainingStatus();
        } else if (R.id.read_training_status_characteristic_configuration == item.getItemId()) {
            mFitnessMachineProfile.getTrainingStatusClientCharacteristicConfiguration();
        } else if (R.id.start_notify_training_status == item.getItemId()) {
            mFitnessMachineProfile.startTrainingStatusNotification();
        } else if (R.id.stop_notify_training_status == item.getItemId()) {
            mFitnessMachineProfile.stopTrainingStatusNotification();

        } else if (R.id.read_supported_speed_range == item.getItemId()) {
            mFitnessMachineProfile.getSupportedSpeedRange();
        } else if (R.id.read_supported_inclination_range == item.getItemId()) {
            mFitnessMachineProfile.getSupportedInclinationRange();
        } else if (R.id.read_supported_resistance_level_range == item.getItemId()) {
            mFitnessMachineProfile.getSupportedResistanceLevelRange();
        } else if (R.id.read_supported_power_range == item.getItemId()) {
            mFitnessMachineProfile.getSupportedPowerRange();
        } else if (R.id.read_supported_heart_rate_range == item.getItemId()) {
            mFitnessMachineProfile.getSupportedHeartRateRange();

        } else if (R.id.write_fitness_machine_control_point_request_control == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL
                    , new byte[0]
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_reset == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESET
                    , new byte[0]
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_target_speed == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED
                    , new byte[]{8, 0}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_target_inclination == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION
                    , new byte[]{10, 0}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_target_resistance_level == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL
                    , new byte[]{13}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_target_power == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER
                    , new byte[]{16, 0}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_target_heart_rate == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE
                    , new byte[]{19}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_start_or_resume == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_START_OR_RESUME
                    , new byte[0]
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_stop_or_pause == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE
                    , new byte[]{FitnessMachineControlPoint.STOP_OR_PAUSE_STOP}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_targeted_expended_energy == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY
                    , new byte[]{20, 21}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_targeted_number_of_steps == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS
                    , new byte[]{22, 23}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_targeted_number_of_strides == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES
                    , new byte[]{24, 25}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_targeted_distance == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE
                    , new byte[]{26, 27, 28}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_targeted_training_time == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME
                    , new byte[]{29, 30}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_targeted_time_in_two_heart_rate_zones == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES
                    , new byte[]{31, 32, 33, 34}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_targeted_time_in_three_zone_heart_rate == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES
                    , new byte[]{33, 34, 35, 36, 37, 38}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_targeted_time_in_five_zone_heart_rate == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES
                    , new byte[]{39, 40, 41, 42, 43, 44, 45, 46, 47, 48}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_indoor_bike_simulation_parameters == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES
                    , new byte[]{49, 50, 51, 52, 53, 54}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_wheel_circumference == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE
                    , new byte[]{55, 56}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_spin_down_control == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL
                    , new byte[]{FitnessMachineControlPoint.SPIN_DOWN_START}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.write_fitness_machine_control_point_set_targeted_cadence == item.getItemId()) {
            mFitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE
                    , new byte[]{57, 58}
                    , 0
                    , 0
                    , new byte[0]));
        } else if (R.id.read_fitness_machine_control_point_characteristic_configuration == item.getItemId()) {
            mFitnessMachineProfile.getFitnessMachineControlPointClientCharacteristicConfiguration();
        } else if (R.id.start_indicate_fitness_machine_control_point == item.getItemId()) {
            mFitnessMachineProfile.startFitnessMachineControlPointIndication();
        } else if (R.id.stop_indicate_fitness_machine_control_point == item.getItemId()) {
            mFitnessMachineProfile.stopFitnessMachineControlPointIndication();
        } else if (R.id.read_fitness_machine_status_characteristic_configuration == item.getItemId()) {
            mFitnessMachineProfile.getFitnessMachineStatusClientCharacteristicConfiguration();
        } else if (R.id.start_notify_fitness_machine_status == item.getItemId()) {
            mFitnessMachineProfile.startFitnessMachineStatusNotification();
        } else if (R.id.stop_notify_fitness_machine_status == item.getItemId()) {
            mFitnessMachineProfile.stopFitnessMachineStatusNotification();

        } else if (R.id.has_first_name == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isFirstNameCharacteristicSupported();
            if (result == null) {
                text = "isFirstNameCharacteristicSupported\nnull";
            } else {
                text = "isFirstNameCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.has_weight == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isWeightCharacteristicSupported();
            if (result == null) {
                text = "isWeightCharacteristicSupported\nnull";
            } else {
                text = "isWeightCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.has_gender == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isGenderCharacteristicSupported();
            if (result == null) {
                text = "isGenderCharacteristicSupported\nnull";
            } else {
                text = "isGenderCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.has_height == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isHeightCharacteristicSupported();
            if (result == null) {
                text = "isHeightCharacteristicSupported\nnull";
            } else {
                text = "isHeightCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.has_age == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isAgeCharacteristicSupported();
            if (result == null) {
                text = "isAgeCharacteristicSupported\nnull";
            } else {
                text = "isAgeCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.has_date_of_birth == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isDateOfBirthCharacteristicSupported();
            if (result == null) {
                text = "isDateOfBirthCharacteristicSupported\nnull";
            } else {
                text = "isDateOfBirthCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.has_heart_rate_max == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isHeartRateMaxCharacteristicSupported();
            if (result == null) {
                text = "isHeartRateMaxCharacteristicSupported\nnull";
            } else {
                text = "isHeartRateMaxCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.has_resting_heart_rate == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isRestingHeartRateCharacteristicSupported();
            if (result == null) {
                text = "isRestingHeartRateCharacteristicSupported\nnull";
            } else {
                text = "isRestingHeartRateCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.has_maximum_recommended_heart_rate == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isMaximumRecommendedHeartRateCharacteristicSupported();
            if (result == null) {
                text = "isMaximumRecommendedHeartRateCharacteristicSupported\nnull";
            } else {
                text = "isMaximumRecommendedHeartRateCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.has_vo2_max == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isVO2MaxCharacteristicSupported();
            if (result == null) {
                text = "isVO2MaxCharacteristicSupported\nnull";
            } else {
                text = "isVO2MaxCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.has_language == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isLanguageCharacteristicSupported();
            if (result == null) {
                text = "isLanguageCharacteristicSupported\nnull";
            } else {
                text = "isLanguageCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.has_two_zone_heart_rate_limits == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isTwoZoneHeartRateLimitCharacteristicSupported();
            if (result == null) {
                text = "isTwoZoneHeartRateLimitCharacteristicSupported\nnull";
            } else {
                text = "isTwoZoneHeartRateLimitCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.has_three_zone_heart_rate_limits == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isThreeZoneHeartRateLimitsCharacteristicSupported();
            if (result == null) {
                text = "isThreeZoneHeartRateLimitsCharacteristicSupported\nnull";
            } else {
                text = "isThreeZoneHeartRateLimitsCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.has_five_zone_heart_rate_limits == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isFiveZoneHeartRateLimitsCharacteristicSupported();
            if (result == null) {
                text = "isFiveZoneHeartRateLimitsCharacteristicSupported\nnull";
            } else {
                text = "isFiveZoneHeartRateLimitsCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());

        } else if (R.id.read_first_name == item.getItemId()) {
            mFitnessMachineProfile.getFirstName();
        } else if (R.id.write_first_name == item.getItemId()) {
            mFitnessMachineProfile.setFirstName(new FirstName("first name ftmp 2"));
        } else if (R.id.read_weight == item.getItemId()) {
            mFitnessMachineProfile.getWeight();
        } else if (R.id.write_weight == item.getItemId()) {
            mFitnessMachineProfile.setWeight(new Weight(101));
        } else if (R.id.read_gender == item.getItemId()) {
            mFitnessMachineProfile.getGender();
        } else if (R.id.write_gender == item.getItemId()) {
            mFitnessMachineProfile.setGender(new Gender(Gender.GENDER_FEMALE));
        } else if (R.id.read_height == item.getItemId()) {
            mFitnessMachineProfile.getHeight();
        } else if (R.id.write_height == item.getItemId()) {
            mFitnessMachineProfile.setHeight(new Height(102));
        } else if (R.id.read_age == item.getItemId()) {
            mFitnessMachineProfile.getAge();
        } else if (R.id.write_age == item.getItemId()) {
            mFitnessMachineProfile.setAge(new Age(103));
        } else if (R.id.read_date_of_birth == item.getItemId()) {
            mFitnessMachineProfile.getDateOfBirth();
        } else if (R.id.write_date_of_birth == item.getItemId()) {
            mFitnessMachineProfile.setDateOfBirth(new DateOfBirth(104, 105, 106));
        } else if (R.id.read_heart_rate_max == item.getItemId()) {
            mFitnessMachineProfile.getHeartRateMax();
        } else if (R.id.write_heart_rate_max == item.getItemId()) {
            mFitnessMachineProfile.setHeartRateMax(new HeartRateMax(107));
        } else if (R.id.read_resting_heart_rate == item.getItemId()) {
            mFitnessMachineProfile.getRestingHeartRate();
        } else if (R.id.write_resting_heart_rate == item.getItemId()) {
            mFitnessMachineProfile.setRestingHeartRate(new RestingHeartRate(108));
        } else if (R.id.read_maximum_recommended_heart_rate == item.getItemId()) {
            mFitnessMachineProfile.getMaximumRecommendedHeartRate();
        } else if (R.id.write_maximum_recommended_heart_rate == item.getItemId()) {
            mFitnessMachineProfile.setMaximumRecommendedHeartRate(new MaximumRecommendedHeartRate(109));
        } else if (R.id.read_vo2_max == item.getItemId()) {
            mFitnessMachineProfile.getVO2Max();
        } else if (R.id.write_vo2_max == item.getItemId()) {
            mFitnessMachineProfile.setVO2Max(new VO2Max(110));
        } else if (R.id.read_language == item.getItemId()) {
            mFitnessMachineProfile.getLanguage();
        } else if (R.id.write_language == item.getItemId()) {
            mFitnessMachineProfile.setLanguage(new Language("language ftmp 2"));
        } else if (R.id.read_two_zone_heart_rate_limits == item.getItemId()) {
            mFitnessMachineProfile.getTwoZoneHeartRateLimit();
        } else if (R.id.write_two_zone_heart_rate_limits == item.getItemId()) {
            mFitnessMachineProfile.setTwoZoneHeartRateLimit(new TwoZoneHeartRateLimit(111));
        } else if (R.id.read_three_zone_heart_rate_limits == item.getItemId()) {
            mFitnessMachineProfile.getThreeZoneHeartRateLimits();
        } else if (R.id.write_three_zone_heart_rate_limits == item.getItemId()) {
            mFitnessMachineProfile.setThreeZoneHeartRateLimits(new ThreeZoneHeartRateLimits(112, 113));
        } else if (R.id.read_five_zone_heart_rate_limits == item.getItemId()) {
            mFitnessMachineProfile.getFiveZoneHeartRateLimits();
        } else if (R.id.write_five_zone_heart_rate_limits == item.getItemId()) {
            mFitnessMachineProfile.setFiveZoneHeartRateLimits(new FiveZoneHeartRateLimits(114, 115, 116, 117));

        } else if (R.id.write_user_control_point_register_new_user == item.getItemId()) {
            mFitnessMachineProfile.setUserControlPoint(new UserControlPoint(UserControlPoint.OP_CODE_REGISTER_NEW_USER
                    , 0
                    , 1
                    , 0
                    , 0
                    , 0));
        } else if (R.id.write_user_control_point_consent == item.getItemId()) {
            if (mLastRegisteredUserIndex != null) {
                mFitnessMachineProfile.setUserControlPoint(new UserControlPoint(UserControlPoint.OP_CODE_CONSENT
                        , mLastRegisteredUserIndex
                        , 1
                        , 0
                        , 0
                        , 0));
            }
        } else if (R.id.write_user_control_point_delete_user_data == item.getItemId()) {
            mFitnessMachineProfile.setUserControlPoint(new UserControlPoint(UserControlPoint.OP_CODE_DELETE_USER_DATA
                    , 0
                    , 0
                    , 0
                    , 0
                    , 0));
        } else if (R.id.read_user_control_point_characteristic_configuration == item.getItemId()) {
            mFitnessMachineProfile.getUserControlPointClientCharacteristicConfiguration();
        } else if (R.id.indicate_user_control_point_start == item.getItemId()) {
            mFitnessMachineProfile.startUserControlPointIndication();
        } else if (R.id.indicate_user_control_point_stop == item.getItemId()) {
            mFitnessMachineProfile.stopUserControlPointIndication();
        } else if (R.id.can_database_change_increment_notify == item.getItemId()) {
            String text;
            Boolean result = mFitnessMachineProfile.isDatabaseChangeIncrementCharacteristicNotifySupported();
            if (result == null) {
                text = "isDatabaseChangeIncrementCharacteristicNotifySupported\nnull";
            } else {
                text = "isDatabaseChangeIncrementCharacteristicNotifySupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
        } else if (R.id.read_database_change_increment == item.getItemId()) {
            mFitnessMachineProfile.getDatabaseChangeIncrement();
        } else if (R.id.write_database_change_increment == item.getItemId()) {
            mFitnessMachineProfile.setDatabaseChangeIncrement(new DatabaseChangeIncrement(2));
        } else if (R.id.read_database_change_increment_characteristic_configuration == item.getItemId()) {
            mFitnessMachineProfile.getDatabaseChangeIncrementClientCharacteristicConfiguration();
        } else if (R.id.notify_menu_database_change_increment_start == item.getItemId()) {
            mFitnessMachineProfile.startDatabaseChangeIncrementNotification();
        } else if (R.id.notify_menu_database_change_increment_stop == item.getItemId()) {
            mFitnessMachineProfile.stopDatabaseChangeIncrementNotification();
        } else if (R.id.read_user_index == item.getItemId()) {
            mFitnessMachineProfile.getUserIndex();

        } else if (R.id.has_manufacturer_name == item.getItemId()) {
            addRow("hasManufacturerNameString", mFitnessMachineProfile.hasManufacturerNameString());
        } else if (R.id.read_manufacturer_name == item.getItemId()) {
            mFitnessMachineProfile.getManufacturerNameString();
        } else if (R.id.has_model_number == item.getItemId()) {
            addRow("hasModelNumberString", mFitnessMachineProfile.hasModelNumberString());
        } else if (R.id.read_model_number == item.getItemId()) {
            mFitnessMachineProfile.getModelNumberString();
        }


        return true;
    }

    protected void updateLayout() {
        mConnectDisconnectButton.setVisibility(View.VISIBLE);
        if (mFitnessMachineProfile.isConnected()) {
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
        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mFitnessMachineProfile == null) {
                mFitnessMachineProfile = new FitnessMachineProfile(this, mFtmpCallbackSample);
                mFitnessMachineProfile.start();
            }
            if (mFitnessMachineProfile.isConnected()) {
                mFitnessMachineProfile.disconnect();
                mFtmpCallbackSample.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, STATUS_MANUAL_DISCONNECT, null);
                mBluetoothDevice = null;
                mLastRegisteredUserIndex = null;
            } else {
                if (mBluetoothDevice == null) {
                    mFitnessMachineProfile.findDevices(null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mFitnessMachineProfile.connect(mBluetoothDevice);
                    } else {
                        mFitnessMachineProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
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
