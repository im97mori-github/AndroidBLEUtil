package org.im97mori.ble.sample.lolipop;

import static org.im97mori.ble.sample.lolipop.SampleMockData.SAMPLE_NOTIFY_CHARACTERISTIC;
import static org.im97mori.ble.sample.lolipop.SampleMockData.SAMPLE_PRIMARY_SERVICE_1;

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

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.task.NotifyTask;
import org.im97mori.ble.task.ReadPhyPeripheralTask;
import org.im97mori.ble.task.SetPreferredPhyPeripheralTask;

import java.util.LinkedList;

public class PeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

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
        BluetoothDevice bluetoothDevice = mLatestConnectedBluetoothDevice;
        if (bluetoothDevice == null) return false;
        if (R.id.notification == item.getItemId()) {
            Integer serviceInstanceId = mLatestNotifyServiceInstanceId;
            Integer characteristicInstanceId = mLatestNotifyCharacteristicInstanceId;
            if (serviceInstanceId != null && characteristicInstanceId != null) {
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
            Integer serviceInstanceId = mLatestNotifyServiceInstanceId;
            Integer characteristicInstanceId = mLatestNotifyCharacteristicInstanceId;
            if (serviceInstanceId != null && characteristicInstanceId != null) {
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
        } else if (R.id.readPhyPeripheral == item.getItemId()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                mBLEServerConnection.createReadPhyTask(bluetoothDevice
                        , ReadPhyPeripheralTask.TIMEOUT_MILLIS
                        , null
                        , null);
            }
        } else if (R.id.setPreferredPhyPeripheral == item.getItemId()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                mBLEServerConnection.createSetPreferredPhyTask(bluetoothDevice
                        , BluetoothDevice.PHY_LE_1M_MASK | BluetoothDevice.PHY_LE_2M_MASK
                        , BluetoothDevice.PHY_LE_1M_MASK | BluetoothDevice.PHY_LE_2M_MASK
                        , BluetoothDevice.PHY_OPTION_S2
                        , SetPreferredPhyPeripheralTask.TIMEOUT_MILLIS
                        , null
                        , null);
            }
        }
        return true;
    }

    protected void updateLayout() {
        if (mBLEServerConnection.isStarted()) {
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
