package org.im97mori.ble.sample.lolipop.rcp;

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

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.characteristic.u2aa5.BondManagementFeatures;
import org.im97mori.ble.characteristic.u2b1d.RCFeature;
import org.im97mori.ble.characteristic.u2b1e.RCSettings;
import org.im97mori.ble.characteristic.u2b1f.ReconnectionConfigurationControlPoint;
import org.im97mori.ble.profile.rcp.peripheral.ReconnectionConfigurationProfileMockCallback;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

@SuppressWarnings("ConstantConditions")
public class RcpPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private ReconnectionConfigurationProfileMockCallback mReconnectionConfigurationProfileMockCallback;

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

        int rcFeatureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_E2E_CRC_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_PROPOSE_RECONNECTION_TIMEOUT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_PROPOSE_SLAVE_LATENCY_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_PROPOSE_SUPERVISION_TIMEOUT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_PROPOSE_ADVERTISEMENT_INTERVAL_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_PROPOSE_ADVERTISEMENT_COUNT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_PROPOSE_ADVERTISEMENT_REPETITION_TIME_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE;
        byte[] rcFeatureData = new byte[]{(byte) rcFeatureFlag
                , (byte) (rcFeatureFlag >> 8)
                , (byte) (rcFeatureFlag >> 16)};
        int crc = BLEUtils.createCrc(rcFeatureData, 0, rcFeatureData.length);

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1;

        byte[] settingsData = new byte[]{5
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};
        ByteBuffer byteBuffer = ByteBuffer.allocate(settingsData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(settingsData);
        byteBuffer.putShort((short) BLEUtils.createCrc(settingsData, 0, 3));
        settingsData = byteBuffer.array();

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        int getActualCommunicationParametersResultCodes = 0;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        int proposeSettingsError = 8;
        int activateStoredSettingsResultCodes = 0;
        int getMaxValuesResultCodes = 0;
        byte[] maxValues = new byte[]{0x1f, 0x4e
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = 0;
        byte[] minValues = new byte[]{2, 0
                , (byte) 0x06, 0x00
                , (byte) 0x07, 0x00
                , (byte) 0x03, 0x00
                , (byte) 0x0a, 0x00
                , 0x20, 0x00
                , (byte) 0x04, 0x00
                , 0x05, 0x00};
        int getStoredValuesResultCodes = 0;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        int getWhiteListTimerResultCodes = 0;
        byte[] getWhiteListTimerOperand = new byte[]{ReconnectionConfigurationControlPoint.WHITE_LIST_DISABLED
                , ReconnectionConfigurationControlPoint.WHITE_LIST_DISABLED >> 8
                , ReconnectionConfigurationControlPoint.WHITE_LIST_DISABLED >> 16
                , ReconnectionConfigurationControlPoint.WHITE_LIST_DISABLED >> 24
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        byte[] currentSetting = new byte[]{2, 0
                , (byte) 0x08, 0x00
                , (byte) 0x09, 0x00
                , (byte) 0x0a, 0x00
                , (byte) 0x0b, 0x00
                , 0x21, 0x00
                , (byte) 0x04, 0x00
                , 0x05, 0x00};
        boolean isRcFeaturesE2eCrcSupported = true;

        int bondFeatureFlag = BondManagementFeatures.BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_SUPPORTED_TRUE
                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE

                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_SUPPORTED_TRUE
                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE

                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_SUPPORTED_TRUE
                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_AUTHORIZATION_CODE_REQUIRED_TRUE

                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_SUPPORTED_TRUE
                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE

                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_SUPPORTED_TRUE
                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE

                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_SUPPORTED_TRUE
                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_TRUE

                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_SUPPORTED_TRUE
                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE

                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_SUPPORTED_TRUE
                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE

                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_SUPPORTED_TRUE
                | BondManagementFeatures.BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_TRUE;
        byte[] bondFeatureData = new byte[]{
                (byte) bondFeatureFlag
                , (byte) (bondFeatureFlag >> 8)
                , (byte) (bondFeatureFlag >> 16)
        };

        mReconnectionConfigurationProfileMockCallback = new RcpCallbackSample.Builder(this, this, true)
                .addRCFeature(new RCFeature(crc, rcFeatureData))
                .addRCSettings(true
                        , 0
                        , 0
                        , settingsData
                        , 0
                        , 0
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addReconnectionConfigurationControlPoint(characteristicResponseCode
                        , characteristicDelay
                        , descriptorResponseCode
                        , descriptorDelay
                        , descriptorValue
                        , enableDisconnectResultCodes
                        , getActualCommunicationParametersResultCodes
                        , proposeSettingsResultCodes
                        , proposeSettingsError
                        , activateStoredSettingsResultCodes
                        , getMaxValuesResultCodes
                        , maxValues
                        , getMinValuesResultCodes
                        , minValues
                        , getStoredValuesResultCodes
                        , getStoredValuesOperand
                        , setWhiteListTimerResultCodes
                        , getWhiteListTimerResultCodes
                        , getWhiteListTimerOperand
                        , setAdvertisementConfigurationResultCodes
                        , upgradeToLescOnlyResultCodes
                        , switchOobPairingResultCodes
                        , limitedAccessResultCodes
                        , currentSetting
                        , isRcFeaturesE2eCrcSupported)
                .addBondManagementFeatures(new BondManagementFeatures(bondFeatureData))
                .addBondManagementControlPoint(0
                        , BluetoothGatt.GATT_SUCCESS
                        , "2"
                        , BluetoothGatt.GATT_SUCCESS
                        , "4"
                        , BluetoothGatt.GATT_SUCCESS
                        , "6"
                        , BluetoothGatt.GATT_SUCCESS
                        , "8"
                        , BluetoothGatt.GATT_SUCCESS
                        , "11"
                        , BluetoothGatt.GATT_SUCCESS
                        , "13"
                        , BluetoothGatt.GATT_SUCCESS
                        , "15"
                        , BluetoothGatt.GATT_SUCCESS
                        , "17"
                        , BluetoothGatt.GATT_SUCCESS
                        , "19")
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
        if (mReconnectionConfigurationProfileMockCallback != null) {
            mReconnectionConfigurationProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled()) {
            BLEUtilsAndroid.bluetoothEnable();
        } else if (mReconnectionConfigurationProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mReconnectionConfigurationProfileMockCallback.isStarted()) {
                mReconnectionConfigurationProfileMockCallback.quit();
            } else {
                mReconnectionConfigurationProfileMockCallback.start();
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
                mReconnectionConfigurationProfileMockCallback.stopAdvertising();
            }
        });
    }
}
