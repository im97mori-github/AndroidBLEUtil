package org.im97mori.ble.sample.lolipop;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.im97mori.ble_peripheral.BLEServerCallback;
import org.im97mori.ble_peripheral.BLEServerConnection;
import org.im97mori.ble_peripheral.characteristic.MockControl;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class PeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private BluetoothAdapter mBluetoothAdapter;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private BLEServerConnection mBLEServerConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mConnectDisconnectButton = findViewById(R.id.connectDisconnectButton);
        mAdapter = new ArrayAdapter<Pair<String, String>>(this, R.layout.list_child, new LinkedList<Pair<String, String>>()) {
            @SuppressWarnings("ConstantConditions")
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View child = convertView;
                if (child == null) {
                    child = getLayoutInflater().inflate(R.layout.list_child, parent, false);
                }
                TextView textView = child.findViewById(R.id.time);
                textView.setText(getItem(position).first);
                textView = child.findViewById(R.id.body);
                textView.setText(getItem(position).second);
                return child;
            }
        };
        mListView = findViewById(android.R.id.list);
        mListView.setAdapter(mAdapter);

        mConnectDisconnectButton.setOnClickListener(this);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        mBLEServerConnection = new BLEServerConnection(this, new BLECallbackSample(this));
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
        mBLEServerConnection.quit();
        super.onDestroy();
    }

    private void updateLayout() {
        if (mBluetoothAdapter != null && !mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.enable();
        } else if (mBLEServerConnection.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();

    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mBLEServerConnection.isStarted()) {
                mBLEServerConnection.quit();
            } else {
                mBLEServerConnection.start();
            }
            updateLayout();
        } else {
            super.onClick(v);
        }
        mBLEServerConnection.updateServerCallback(new BLEServerCallback() {
            @Override
            public void onServerStarted() {

            }

            @Override
            public void onServerStopped() {

            }

            @Override
            public void onDeviceConnected(BluetoothDevice device) {

            }

            @Override
            public void onDeviceDisconnected(BluetoothDevice device) {

            }

            @Override
            public List<BluetoothGattService> getBluetoothGattServiceList() {
                return null;
            }

            @Override
            public boolean onCharacteristicReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, int offset, BluetoothGattCharacteristic characteristic) {
                return false;
            }

            @Override
            public boolean onCharacteristicWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, BluetoothGattCharacteristic characteristic, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
                return false;
            }

            @Override
            public boolean onDescriptorReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, int offset, BluetoothGattDescriptor descriptor) {
                return false;
            }

            @Override
            public boolean onDescriptorWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
                return false;
            }

            @Override
            public void onNotificationSuccess(long taskId, BluetoothGattServer bluetoothGattServer, BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] value, Bundle argument) {

            }

            @Override
            public void onNotificationFailed(long taskId, BluetoothGattServer bluetoothGattServer, BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {

            }

            @Override
            public void onClientCharacteristicConfigurationUpdated(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] value) {

            }

            @Override
            public void onMockUpdated(BluetoothDevice device, MockControl mockControl) {

            }
        });
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
