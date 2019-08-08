package org.im97mori.test_peripheral;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.im97mori.ble.BLEConstants;
import org.im97mori.ble.BLEServerStatusCallback;
import org.im97mori.ble.BLEServerConnection;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class PeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, BLEServerStatusCallback {


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

        BluetoothGattService bluetoothGattService;
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        BluetoothGattDescriptor bluetoothGattDescriptor;
        List<BluetoothGattService> list = new LinkedList<>();
        int index = 0;

        bluetoothGattService = new BluetoothGattService(createUUID(index++), BluetoothGattService.SERVICE_TYPE_PRIMARY);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(createUUID(index++), BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(createUUID(index++), BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_WRITE);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(createUUID(index++), BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, BluetoothGattCharacteristic.PERMISSION_WRITE);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(createUUID(index++), BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(createUUID(index++), BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        list.add(bluetoothGattService);

        mBLEServerConnection = new BLEServerConnection(this, list, this);
    }

    private UUID createUUID(long delta) {
        return new UUID(BLEServerConnection.MOST_SIGNIFICANT | (delta << 32), BLEServerConnection.LEAST_SIGNIFICANT);
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

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
//        for (int i = 0; i < menu.size(); i++) {
//            menu.getItem(i).setEnabled(mBleConnection != null && mBleConnection.isConnected());
//        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return true;
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
    }

    @Override
    public void onServerStarted() {

    }

    @Override
    public void onServerStopped() {

    }
}
