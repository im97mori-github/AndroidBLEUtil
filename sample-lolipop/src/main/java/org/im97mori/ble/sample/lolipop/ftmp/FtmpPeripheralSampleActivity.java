package org.im97mori.ble.sample.lolipop.ftmp;

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
import org.im97mori.ble.characteristic.core.CrossTrainerDataUtils;
import org.im97mori.ble.characteristic.core.IndoorBikeDataUtils;
import org.im97mori.ble.characteristic.core.RowerDataUtils;
import org.im97mori.ble.characteristic.core.StairClimberDataUtils;
import org.im97mori.ble.characteristic.core.StepClimberDataUtils;
import org.im97mori.ble.characteristic.core.TreadmillDataUtils;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.characteristic.u2acc.FitnessMachineFeature;
import org.im97mori.ble.characteristic.u2acd.TreadmillData;
import org.im97mori.ble.characteristic.u2acd.TreadmillDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ace.CrossTrainerData;
import org.im97mori.ble.characteristic.u2ace.CrossTrainerDataPacketAndroid;
import org.im97mori.ble.characteristic.u2acf.StepClimberData;
import org.im97mori.ble.characteristic.u2acf.StepClimberDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ad0.StairClimberData;
import org.im97mori.ble.characteristic.u2ad0.StairClimberDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ad1.RowerData;
import org.im97mori.ble.characteristic.u2ad1.RowerDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ad2.IndoorBikeData;
import org.im97mori.ble.characteristic.u2ad2.IndoorBikeDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ad3.TrainingStatus;
import org.im97mori.ble.characteristic.u2ad4.SupportedSpeedRange;
import org.im97mori.ble.characteristic.u2ad5.SupportedInclinationRange;
import org.im97mori.ble.characteristic.u2ad6.SupportedResistanceLevelRange;
import org.im97mori.ble.characteristic.u2ad7.SupportedHeartRateRange;
import org.im97mori.ble.characteristic.u2ad8.SupportedPowerRange;
import org.im97mori.ble.characteristic.u2ad9.FitnessMachineControlPoint;
import org.im97mori.ble.characteristic.u2ada.FitnessMachineStatus;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.profile.ftmp.peripheral.FitnessMachineProfileMockCallback;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;

@SuppressWarnings("ConstantConditions")
public class FtmpPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private FitnessMachineProfileMockCallback mFitnessMachineProfileMockCallback;

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

        byte[] fitnessMachineFeatures = new byte[]{
                0, 0, 0, 0};
        int targetSettingFeatureFlags = FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STEP_NUMBER_CONFIGRATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_DISTANCE_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_SPIN_DOWN_CONTROL_SUPPORTED_TRUE
                | FitnessMachineFeature.TARGET_SETTING_FEATURES_TARGETED_CADENCE_CONFIGURATION_SUPPORTED_TRUE;
        byte[] targetSettingFeatures = new byte[]{
                (byte) (targetSettingFeatureFlags)
                , (byte) (targetSettingFeatureFlags >> 8)
                , (byte) (targetSettingFeatureFlags >> 16)
                , (byte) (targetSettingFeatureFlags >> 24)
        };

        TreadmillDataPacketAndroid[] treadmillData = new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(new byte[]{(byte) (TreadmillDataUtils.FLAGS_MORE_DATA_FALSE)
                , (byte) (TreadmillDataUtils.FLAGS_MORE_DATA_FALSE >> 8)
                , 1
                , 0})};
        CrossTrainerDataPacketAndroid[] crossTrainerData = new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(new byte[]{(byte) (CrossTrainerDataUtils.FLAGS_MORE_DATA_FALSE)
                , (byte) (CrossTrainerDataUtils.FLAGS_MORE_DATA_FALSE >> 8)
                , (byte) (CrossTrainerDataUtils.FLAGS_MORE_DATA_FALSE >> 16)
                , 2
                , 0})};
        StepClimberDataPacketAndroid[] stepClimberData = new StepClimberDataPacketAndroid[]{StepClimberDataPacketAndroid.CREATOR.createFromByteArray(new byte[]{(byte) (StepClimberDataUtils.FLAGS_MORE_DATA_FALSE)
                , (byte) (StepClimberDataUtils.FLAGS_MORE_DATA_FALSE >> 8)
                , 3
                , 0
                , 0
                , 0})};
        StairClimberDataPacketAndroid[] stairClimberData = new StairClimberDataPacketAndroid[]{StairClimberDataPacketAndroid.CREATOR.createFromByteArray(new byte[]{(byte) (StairClimberDataUtils.FLAGS_MORE_DATA_FALSE)
                , (byte) (StairClimberDataUtils.FLAGS_MORE_DATA_FALSE >> 8)
                , 4
                , 0})};
        RowerDataPacketAndroid[] rowerData = new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(new byte[]{(byte) (RowerDataUtils.FLAGS_MORE_DATA_FALSE)
                , (byte) (RowerDataUtils.FLAGS_MORE_DATA_FALSE >> 8)
                , 5
                , 0
                , 0})};
        IndoorBikeDataPacketAndroid[] indoorBikeData = new IndoorBikeDataPacketAndroid[]{IndoorBikeDataPacketAndroid.CREATOR.createFromByteArray(new byte[]{(byte) (IndoorBikeDataUtils.FLAGS_MORE_DATA_FALSE)
                , (byte) (IndoorBikeDataUtils.FLAGS_MORE_DATA_FALSE >> 8)
                , 6
                , 0
                , 0})};

        mFitnessMachineProfileMockCallback = new FtmpCallbackSample.Builder(this, this, true, false)
                .addFitnessMachineFeature(new FitnessMachineFeature(fitnessMachineFeatures, targetSettingFeatures))

                .addTreadmillData(new TreadmillData(treadmillData)
                        , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addCrossTrainerData(new CrossTrainerData(crossTrainerData)
                        , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addStepClimberData(new StepClimberData(stepClimberData)
                        , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addStairClimberData(new StairClimberData(stairClimberData)
                        , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addRowerData(new RowerData(rowerData)
                        , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addIndoorBikeData(new IndoorBikeData(indoorBikeData)
                        , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addTrainingStatus(new TrainingStatus(new byte[]{TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                                , TrainingStatus.TRANING_STATUS_OTHER})
                        , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addSupportedSpeedRange(new SupportedSpeedRange(7
                        , 8
                        , 9))
                .addSupportedInclinationRange(new SupportedInclinationRange(10
                        , 11
                        , 12))
                .addSupportedResistanceLevelRange(new SupportedResistanceLevelRange(13
                        , 14
                        , 15))
                .addSupportedPowerRange(new SupportedPowerRange(16
                        , 17
                        , 18))
                .addSupportedHeartRateRange(new SupportedHeartRateRange(19
                        , 20
                        , 21))
                .addFitnessMachineControlPoint(0
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                        , new byte[]{22, 23, 24, 25}
                        , FitnessMachineControlPoint.RESULT_CODE_SUCCESS)
                .addFitnessMachineStatus(FitnessMachineStatus.SPIN_DOWN_STATUS_SPIN_DOWN_REQUESTED
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)

                .addFirstName("first name fmtp")
                .addWeight(1)
                .addGender(Gender.GENDER_UNSPECIFIED)
                .addHeight(2)
                .addAge(3)
                .addDateOfBirth(4, 5, 6)
                .addHeartRateMax(7)
                .addRestingHeartRate(8)
                .addMaximumRecommendedHeartRate(9)
                .addVO2Max(10)
                .addLanguage("language fmtp")
                .addTwoZoneHeartRateLimit(11)
                .addThreeZoneHeartRateLimits(12, 13)
                .addFiveZoneHeartRateLimits(14, 15, 16, 17)

                .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addUserIndex()
                .addUserControlPoint(0
                        , UserControlPoint.RESPONSE_VALUE_SUCCESS
                        , UserControlPoint.RESPONSE_VALUE_SUCCESS
                        , UserControlPoint.RESPONSE_VALUE_SUCCESS
                        , BluetoothGatt.GATT_SUCCESS
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)

                .addManufacturerNameString("Manufacturer Name String data ftmp")
                .addModelNumberString("Model Number String data ftmp")

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
        if (mFitnessMachineProfileMockCallback != null) {
            mFitnessMachineProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else if (mFitnessMachineProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mFitnessMachineProfileMockCallback.isStarted()) {
                mFitnessMachineProfileMockCallback.quit();
            } else {
                mFitnessMachineProfileMockCallback.start();
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
                mFitnessMachineProfileMockCallback.stopAdvertising();
            }
        });
    }
}
