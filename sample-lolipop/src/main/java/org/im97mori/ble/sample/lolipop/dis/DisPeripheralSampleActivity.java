package org.im97mori.ble.sample.lolipop.dis;

import android.bluetooth.BluetoothAdapter;
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

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.characteristic.u2a2a.IEEE_11073_20601_RegulatoryCertificationDataList;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;

import java.util.LinkedList;

public class DisPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private BluetoothAdapter mBluetoothAdapter;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private BLEServerConnection mBLEServerConnection;

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

                Pair<String, String > item = getItem(position);
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

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        mBLEServerConnection = new BLEServerConnection(this);
        DeviceInformationServiceMockCallback deviceInformationServiceMockCallback
                = new DisCallbackSample.Builder(this)
                .addManufacturerNameString("ManufacturerNameString")
                .addModelNumberString("ModelNumberString")
                .addSerialNumberString("SerialNumberString")
                .addHardwareRevisionString("HardwareRevisionString")
                .addFirmwareRevisionString("FirmwareRevisionString")
                .addSoftwareRevisionString("SoftwareRevisionString")
                .addSystemId(1, 2)
                .addIEEE_11073_20601_RegulatoryCertificationDataList(new IEEE_11073_20601_RegulatoryCertificationDataList(new byte[]{3}))
                .addPnpId(4, 5, 6, 7)
                .build();
        mBLEServerConnection.attach(deviceInformationServiceMockCallback);
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
    public void onCallbacked(final Pair<String, String> log) {
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
