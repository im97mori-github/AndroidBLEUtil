package org.im97mori.ble.sample.lolipop;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
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

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.task.NotifyTask;

import java.util.LinkedList;

import static org.im97mori.ble.sample.lolipop.SampleMockData.SAMPLE_NOTIFY_CHARACTERISTIC;
import static org.im97mori.ble.sample.lolipop.SampleMockData.SAMPLE_PRIMARY_SERVICE_1;

public class PeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private BluetoothAdapter mBluetoothAdapter;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private BLEServerConnection mBLEServerConnection;

    BluetoothDevice mLatestConnectedBluetoothDevice;
    Integer mLatestNotifyServiceInstanceId;
    Integer mLatestNotifyCharacteristicInstanceId;

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

        mBluetoothAdapter = ((BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE)).getAdapter();

        mBLEServerConnection = new BLEServerConnection(this);
        mBLEServerConnection.attach(new BLECallbackSample(this, this));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.peripheral, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (R.id.notification == item.getItemId()) {
            BluetoothDevice bluetoothDevice = mLatestConnectedBluetoothDevice;
            Integer serviceInstanceId = mLatestNotifyServiceInstanceId;
            Integer characteristicInstanceId = mLatestNotifyCharacteristicInstanceId;
            if (bluetoothDevice != null && serviceInstanceId != null && characteristicInstanceId != null) {
                mBLEServerConnection.createNotifyTask(bluetoothDevice
                        , SAMPLE_PRIMARY_SERVICE_1
                        , serviceInstanceId
                        , SAMPLE_NOTIFY_CHARACTERISTIC
                        , characteristicInstanceId
                        , () -> new byte[]{1, 2, 3, 4}
                        , false
                        , NotifyTask.TIMEOUT_MILLIS
                        , 0
                        , null
                        , null);
            }
        } else if (R.id.indication == item.getItemId()) {
            BluetoothDevice bluetoothDevice = mLatestConnectedBluetoothDevice;
            Integer serviceInstanceId = mLatestNotifyServiceInstanceId;
            Integer characteristicInstanceId = mLatestNotifyCharacteristicInstanceId;
            if (bluetoothDevice != null && serviceInstanceId != null && characteristicInstanceId != null) {
                mBLEServerConnection.createNotifyTask(bluetoothDevice
                        , SAMPLE_PRIMARY_SERVICE_1
                        , serviceInstanceId
                        , SAMPLE_NOTIFY_CHARACTERISTIC
                        , characteristicInstanceId
                        , () -> new byte[]{1, 2, 3, 4}
                        , true
                        , NotifyTask.TIMEOUT_MILLIS
                        , 0
                        , null
                        , null);
            }
        }
        return true;
    }

    protected void updateLayout() {
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
                mBLEServerConnection.startAdvertising();
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
                mBLEServerConnection.stopAdvertising();
            }
        });
    }
}
