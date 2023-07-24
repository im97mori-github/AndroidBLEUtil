package org.im97mori.ble.sample.lolipop.rcp;

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

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.characteristic.u2aa4.BondManagementControlPoint;
import org.im97mori.ble.characteristic.u2b1f.ReconnectionConfigurationControlPoint;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.rcp.central.ReconnectionConfigurationProfile;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;

public class RcpCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private RcpCallbackSample mRcpCallbackSample;
    private ReconnectionConfigurationProfile mReconnectionConfigurationProfile;
    BluetoothDevice mBluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRcpCallbackSample = new RcpCallbackSample(this, this);
        mReconnectionConfigurationProfile = new ReconnectionConfigurationProfile(this, mRcpCallbackSample);
        mReconnectionConfigurationProfile.start();

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
        if (mReconnectionConfigurationProfile != null) {
            mReconnectionConfigurationProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rcp_central, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (mReconnectionConfigurationProfile != null && mReconnectionConfigurationProfile.isConnected()) {
            menu.setGroupEnabled(R.id.pre_connected, false);
            menu.setGroupEnabled(R.id.connected, true);
        } else {
            menu.setGroupEnabled(R.id.pre_connected, true);
            menu.setGroupEnabled(R.id.connected, false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.load_bonded_device == item.getItemId()) {
            Set<BluetoothDevice> bluetoothDeviceSet = mReconnectionConfigurationProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mReconnectionConfigurationProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.has_bond_management_service == item.getItemId()) {
            String text;
            Boolean result = mReconnectionConfigurationProfile.hasBondManagementService();
            if (result == null) {
                text = "hasBondManagementService\nnull";
            } else {
                text = "hasBondManagementService\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
            updateLayout();
        } else if (R.id.has_rc_settings == item.getItemId()) {
            String text;
            Boolean result = mReconnectionConfigurationProfile.isRCSettingsCharacteristicSupported();
            if (result == null) {
                text = "isRCSettingsCharacteristicSupported\nnull";
            } else {
                text = "isRCSettingsCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
            updateLayout();
        } else if (R.id.can_rc_settings_notify == item.getItemId()) {
            String text;
            Boolean result = mReconnectionConfigurationProfile.isRCSettingsCharacteristicNotifySupported();
            if (result == null) {
                text = "isRCSettingsCharacteristicNotifySupported\nnull";
            } else {
                text = "isRCSettingsCharacteristicNotifySupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
            updateLayout();
        } else if (R.id.has_reconnection_configuration_control_point == item.getItemId()) {
            String text;
            Boolean result = mReconnectionConfigurationProfile.isReconnectionConfigurationControlPointCharacteristicSupported();
            if (result == null) {
                text = "isReconnectionConfigurationControlPointCharacteristicSupported\nnull";
            } else {
                text = "isReconnectionConfigurationControlPointCharacteristicSupported\n" + result;
            }
            mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
            mListView.smoothScrollToPosition(mAdapter.getCount());
            updateLayout();
        } else if (R.id.read_rc_feature == item.getItemId()) {
            mReconnectionConfigurationProfile.getRCFeature();
        } else if (R.id.read_rc_settings == item.getItemId()) {
            mReconnectionConfigurationProfile.getRCSettings();
        } else if (R.id.get_rc_settings_characteristic_configuration == item.getItemId()) {
            mReconnectionConfigurationProfile.getRCSettingsClientCharacteristicConfiguration();
        } else if (R.id.notify_rc_settings_start == item.getItemId()) {
            mReconnectionConfigurationProfile.startRCSettingsNotification();
        } else if (R.id.notify_rc_settings_stop == item.getItemId()) {
            mReconnectionConfigurationProfile.stopRCSettingsNotification();
        } else if (R.id.write_reconnection_configuration_control_point == item.getItemId()) {
            byte[] data = new byte[]{
                    ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                    , 0x03, 0x00/*, (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8)*/
                    , 0x06, 0x00/*, (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8)*/
                    , 0x07, 0x00/*, (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8)*/
                    , 0x04, 0x00/*, (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8)*/
                    , 0x0c, 0x00/*, (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8)*/
                    , 0x30, 0x00/*, (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8)*/
                    , 0x0d, 0x00/*, (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8)*/
                    , 0x0e, 0x00/*, (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED >> 8)*/
            };
            ByteBuffer byteBuffer = ByteBuffer.allocate(data.length + 2).order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.put(data);
            byteBuffer.putShort((short) BLEUtils.createCrc(data, 0, data.length));
            data = byteBuffer.array();
            mReconnectionConfigurationProfile.setReconnectionConfigurationControlPoint(
                    new ReconnectionConfigurationControlPoint(data));
        } else if (R.id.get_reconnection_configuration_control_point_characteristic_configuration == item.getItemId()) {
            mReconnectionConfigurationProfile.getReconnectionConfigurationControlPointClientCharacteristicConfiguration();
        } else if (R.id.indicate_reconnection_configuration_control_point_start == item.getItemId()) {
            mReconnectionConfigurationProfile.startReconnectionConfigurationControlPointIndication();
        } else if (R.id.indicate_reconnection_configuration_control_point_stop == item.getItemId()) {
            mReconnectionConfigurationProfile.stopReconnectionConfigurationControlPointIndication();
        } else if (R.id.indicate_client_parameter_indication == item.getItemId()) {
            byte[] data = new byte[]{
                    ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS
            };
            ByteBuffer byteBuffer = ByteBuffer.allocate(data.length + 2).order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.put(data);
            byteBuffer.putShort((short) BLEUtils.createCrc(data, 0, data.length));
            data = byteBuffer.array();
            mReconnectionConfigurationProfile.setReconnectionConfigurationControlPoint(new ReconnectionConfigurationControlPoint(data));
        } else if (R.id.read_bond_management_features == item.getItemId()) {
            mReconnectionConfigurationProfile.getBondManagementFeatures();
        } else if (R.id.write_bond_management_control_point == item.getItemId()) {
            mReconnectionConfigurationProfile.setBondManagementControlPoint(
                    new BondManagementControlPoint(BondManagementControlPoint.OP_CODE_DELETE_ALL_BUT_THE_ACTIVIE_BOND_ON_SERVER_LE
                            , "19"));
        }
        return true;
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);
            if (mReconnectionConfigurationProfile.isConnected()) {
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
            if (mReconnectionConfigurationProfile == null) {
                mReconnectionConfigurationProfile = new ReconnectionConfigurationProfile(this, mRcpCallbackSample);
                mReconnectionConfigurationProfile.start();
            }
            if (mReconnectionConfigurationProfile.isConnected()) {
                mReconnectionConfigurationProfile.disconnect();
                mRcpCallbackSample.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, STATUS_MANUAL_DISCONNECT, null);
                mBluetoothDevice = null;
            } else {
                if (mBluetoothDevice == null) {
                    mReconnectionConfigurationProfile.findDevices(null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mReconnectionConfigurationProfile.connect(mBluetoothDevice);
                    } else {
                        mReconnectionConfigurationProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
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
