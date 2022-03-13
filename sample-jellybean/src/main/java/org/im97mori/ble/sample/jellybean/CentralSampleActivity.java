package org.im97mori.ble.sample.jellybean;

import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_FAILED;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_SUCCESS;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_TIMEOUT;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.BLELogUtils;
import org.im97mori.ble.BLESyncConnection;
import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.CompleteListOf128BitServiceUUIDsAndroid;
import org.im97mori.ble.advertising.FlagsAndroid;
import org.im97mori.ble.advertising.filter.FilteredLeScanCallback;
import org.im97mori.ble.advertising.filter.FilteredLeScanCallbackInterface;
import org.im97mori.ble.advertising.filter.FlagsFilter;
import org.im97mori.ble.advertising.filter.OrFilter;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.task.AbortReliableWriteTask;
import org.im97mori.ble.task.ConnectTask;
import org.im97mori.ble.task.DiscoverServiceTask;
import org.im97mori.ble.task.ExecuteReliableWriteTask;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.ReadPhyTask;
import org.im97mori.ble.task.ReadRemoteRssiTask;
import org.im97mori.ble.task.RequestMtuTask;
import org.im97mori.ble.task.SetPreferredPhyTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class CentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback, FilteredLeScanCallbackInterface {

    public static final UUID MOCK_CONTROL_SERVICE_UUID = UUID.fromString("00000000-a087-4fa3-add4-3b8a7d5d491f");

    public static final UUID SAMPLE_PRIMARY_SERVICE_1 = UUID.fromString("00000001-a087-4fa3-add4-3b8a7d5d4921");

    public static final UUID SAMPLE_READABLE_CHARACTERISTIC = UUID.fromString("00000010-a087-4fa3-add4-3b8a7d5d4921");

    public static final UUID SAMPLE_READABLE_DESCRIPTOR = UUID.fromString("00000100-a087-4fa3-add4-3b8a7d5d4921");

    public static final UUID SAMPLE_WRITABLE_CHARACTERISTIC = UUID.fromString("00000020-a087-4fa3-add4-3b8a7d5d4921");

//    public static final UUID SAMPLE_WRITABLE_DESCRIPTOR = UUID.fromString("00000200-a087-4fa3-add4-3b8a7d5d4921");

    public static final UUID SAMPLE_NOTIFICATABLE_CHARACTERISTIC = UUID.fromString("00000030-a087-4fa3-add4-3b8a7d5d4921");

    public static final UUID SAMPLE_INDICATABLE_CHARACTERISTIC = UUID.fromString("00000040-a087-4fa3-add4-3b8a7d5d4921");

//    public static final UUID SAMPLE_WRITE_CHARACTERISTIC_RELIABLE = UUID.fromString("00000050-a087-4fa3-add4-3b8a7d5d4921");

    public static final UUID SAMPLE_PRIMARY_SERVICE_2 = UUID.fromString("00000002-a087-4fa3-add4-3b8a7d5d4922");

    public static final UUID SAMPLE_READABLE_CHARACTERISTIC_2 = UUID.fromString("00000060-a087-4fa3-add4-3b8a7d5d4921");

    private static final String KEY_LATEST_DEVICE = "KEY_LATEST_DEVICE";

    private Button mConnectDisconnectButton;

    private BluetoothAdapter mBluetoothAdapter;

    private FilteredLeScanCallback mFilteredLeScanCallback;

    private BLEConnection mBleConnection;

    private BLECallbackSample mBLECallbackSample;

    private BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBLECallbackSample = new BLECallbackSample(this);

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
        if (mBluetoothAdapter != null && mFilteredLeScanCallback != null) {
            mBluetoothAdapter.stopLeScan(mFilteredLeScanCallback);
            mFilteredLeScanCallback = null;
        }
        if (mBleConnection != null) {
            mBleConnection.detach(mBLECallbackSample);
            mBleConnection = null;
        }
        if (mReceiver != null) {
            unregisterReceiver(mReceiver);
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.central, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            int menuItemId = menuItem.getItemId();
            if (R.id.read_characteristic_sync != menuItemId && R.id.write_characteristic_sync != menuItemId) {
                menuItem.setEnabled(mBleConnection != null && mBleConnection.isConnected());
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.discover_service == item.getItemId()) {
            mBleConnection.createDiscoverServiceTask(DiscoverServiceTask.TIMEOUT_MILLIS, null, null);
        } else if (R.id.discover_service_sync == item.getItemId()) {
            new Thread() {
                @Override
                public void run() {
                    BLEConnection target = mBleConnection;
                    if (target != null) {
                        BLESyncConnection.BLEResult result = BLESyncConnection.createDiscoverServiceTask(target
                                , DiscoverServiceTask.TIMEOUT_MILLIS
                                , DiscoverServiceTask.TIMEOUT_MILLIS
                                , null
                                , false);

                        if (result == null) {
                            mBLECallbackSample.onDiscoverServiceFailed(0, target.getBluetoothDevice(), BLESyncConnection.BLEResult.RESULT_FAILED, null);
                        } else {
                            if (RESULT_SUCCESS == result.getResultCode()) {
                                mBLECallbackSample.onDiscoverServiceSuccess(0, target.getBluetoothDevice(), Objects.requireNonNull(result.getServiceList()), result.getArgument());
                            } else if (RESULT_FAILED == result.getResultCode()) {
                                mBLECallbackSample.onDiscoverServiceFailed(0, target.getBluetoothDevice(), result.getStatus(), result.getArgument());
                            } else if (RESULT_TIMEOUT == result.getResultCode()) {
                                mBLECallbackSample.onDiscoverServiceTimeout(0, target.getBluetoothDevice(), DiscoverServiceTask.TIMEOUT_MILLIS, result.getArgument());
                            }
                        }
                    }
                }
            }.start();
        } else if (R.id.request_mtu == item.getItemId()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mBleConnection.createRequestMtuTask(RequestMtuTask.MAXIMUM_MTU / 2, DiscoverServiceTask.TIMEOUT_MILLIS, null, null);
            }
        } else if (R.id.request_mtu_sync == item.getItemId()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                new Thread() {
                    @Override
                    public void run() {
                        BLEConnection target = mBleConnection;
                        if (target != null) {
                            BLESyncConnection.BLEResult result = BLESyncConnection.createRequestMtuTask(target
                                    , 100
                                    , RequestMtuTask.TIMEOUT_MILLIS
                                    , RequestMtuTask.TIMEOUT_MILLIS
                                    , null
                                    , false);

                            if (result == null) {
                                mBLECallbackSample.onRequestMtuFailed(0, target.getBluetoothDevice(), BLESyncConnection.BLEResult.RESULT_FAILED, null);
                            } else {
                                if (RESULT_SUCCESS == result.getResultCode()) {
                                    mBLECallbackSample.onRequestMtuSuccess(0, target.getBluetoothDevice(), result.getMtu(), result.getArgument());
                                } else if (RESULT_FAILED == result.getResultCode()) {
                                    mBLECallbackSample.onRequestMtuFailed(0, target.getBluetoothDevice(), result.getStatus(), result.getArgument());
                                } else if (RESULT_TIMEOUT == result.getResultCode()) {
                                    mBLECallbackSample.onRequestMtuTimeout(0, target.getBluetoothDevice(), RequestMtuTask.TIMEOUT_MILLIS, result.getArgument());
                                }
                            }
                        }
                    }
                }.start();
            }
        } else if (R.id.read_phy == item.getItemId()) {
            if (Build.VERSION_CODES.O <= Build.VERSION.SDK_INT) {
                mBleConnection.createReadPhyTask(ReadPhyTask.TIMEOUT_MILLIS, null, null);
            }
        } else if (R.id.read_phy_sync == item.getItemId()) {
            if (Build.VERSION_CODES.O <= Build.VERSION.SDK_INT) {
                new Thread() {
                    @Override
                    public void run() {
                        BLEConnection target = mBleConnection;
                        if (target != null) {
                            BLESyncConnection.BLEResult result = BLESyncConnection.createReadPhyTask(target
                                    , ReadPhyTask.TIMEOUT_MILLIS
                                    , ReadPhyTask.TIMEOUT_MILLIS
                                    , null
                                    , false);

                            if (result == null) {
                                mBLECallbackSample.onReadPhyFailed(0, target.getBluetoothDevice(), BLESyncConnection.BLEResult.RESULT_FAILED, null);
                            } else {
                                if (RESULT_SUCCESS == result.getResultCode()) {
                                    mBLECallbackSample.onReadPhySuccess(0, target.getBluetoothDevice(), result.getTxPhy(), result.getRxPhy(), result.getArgument());
                                } else if (RESULT_FAILED == result.getResultCode()) {
                                    mBLECallbackSample.onReadPhyFailed(0, target.getBluetoothDevice(), result.getStatus(), result.getArgument());
                                } else if (RESULT_TIMEOUT == result.getResultCode()) {
                                    mBLECallbackSample.onReadPhyTimeout(0, target.getBluetoothDevice(), RequestMtuTask.TIMEOUT_MILLIS, result.getArgument());
                                }
                            }
                        }
                    }
                }.start();
            }
        } else if (R.id.set_preferred_phy == item.getItemId()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                mBleConnection.createSetPreferredPhyTask(
                        BluetoothDevice.PHY_LE_1M_MASK | BluetoothDevice.PHY_LE_2M_MASK | BluetoothDevice.PHY_LE_CODED_MASK
                        , BluetoothDevice.PHY_LE_1M_MASK | BluetoothDevice.PHY_LE_2M_MASK | BluetoothDevice.PHY_LE_CODED_MASK
                        , BluetoothDevice.PHY_OPTION_NO_PREFERRED
                        , SetPreferredPhyTask.TIMEOUT_MILLIS, null, null);
            }
        } else if (R.id.set_preferred_phy_sync == item.getItemId()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                new Thread() {
                    @Override
                    public void run() {
                        BLEConnection target = mBleConnection;
                        if (target != null) {
                            BLESyncConnection.BLEResult result = BLESyncConnection.createSetPreferredPhyTask(target
                                    , BluetoothDevice.PHY_LE_1M_MASK | BluetoothDevice.PHY_LE_2M_MASK | BluetoothDevice.PHY_LE_CODED_MASK
                                    , BluetoothDevice.PHY_LE_1M_MASK | BluetoothDevice.PHY_LE_2M_MASK | BluetoothDevice.PHY_LE_CODED_MASK
                                    , BluetoothDevice.PHY_OPTION_NO_PREFERRED
                                    , SetPreferredPhyTask.TIMEOUT_MILLIS
                                    , SetPreferredPhyTask.TIMEOUT_MILLIS
                                    , null
                                    , false);

                            if (result == null) {
                                mBLECallbackSample.onSetPreferredPhyFailed(0, target.getBluetoothDevice(), BLESyncConnection.BLEResult.RESULT_FAILED, null);
                            } else {
                                if (RESULT_SUCCESS == result.getResultCode()) {
                                    mBLECallbackSample.onSetPreferredPhySuccess(0, target.getBluetoothDevice(), result.getTxPhy(), result.getRxPhy(), result.getPhyOptions(), result.getArgument());
                                } else if (RESULT_FAILED == result.getResultCode()) {
                                    mBLECallbackSample.onSetPreferredPhyFailed(0, target.getBluetoothDevice(), result.getStatus(), result.getArgument());
                                } else if (RESULT_TIMEOUT == result.getResultCode()) {
                                    mBLECallbackSample.onSetPreferredPhyTimeout(0, target.getBluetoothDevice(), RequestMtuTask.TIMEOUT_MILLIS, result.getArgument());
                                }
                            }
                        }
                    }
                }.start();
            }
        } else if (R.id.read_remote_rssi == item.getItemId()) {
            mBleConnection.createReadRemoteRssiTask(ReadRemoteRssiTask.TIMEOUT_MILLIS, null, null);
        } else if (R.id.read_remote_rssi_sync == item.getItemId()) {
            new Thread() {
                @Override
                public void run() {
                    BLEConnection target = mBleConnection;
                    if (target != null) {
                        BLESyncConnection.BLEResult result = BLESyncConnection.createReadRemoteRssiTask(target
                                , ReadRemoteRssiTask.TIMEOUT_MILLIS
                                , ReadRemoteRssiTask.TIMEOUT_MILLIS
                                , null
                                , false);

                        if (result == null) {
                            mBLECallbackSample.onReadRemoteRssiFailed(0, target.getBluetoothDevice(), BLESyncConnection.BLEResult.RESULT_FAILED, null);
                        } else {
                            if (RESULT_SUCCESS == result.getResultCode()) {
                                mBLECallbackSample.onReadRemoteRssiSuccess(0, target.getBluetoothDevice(), result.getRssi(), result.getArgument());
                            } else if (RESULT_FAILED == result.getResultCode()) {
                                mBLECallbackSample.onReadRemoteRssiFailed(0, target.getBluetoothDevice(), result.getStatus(), result.getArgument());
                            } else if (RESULT_TIMEOUT == result.getResultCode()) {
                                mBLECallbackSample.onReadRemoteRssiTimeout(0, target.getBluetoothDevice(), ReadRemoteRssiTask.TIMEOUT_MILLIS, result.getArgument());
                            }
                        }
                    }
                }
            }.start();
        } else if (R.id.read_characteristic == item.getItemId()) {
            mBleConnection.createReadCharacteristicTask(SAMPLE_PRIMARY_SERVICE_1
                    , SAMPLE_READABLE_CHARACTERISTIC
                    , ReadCharacteristicTask.TIMEOUT_MILLIS);
        } else if (R.id.write_characteristic == item.getItemId()) {
            mBleConnection.createWriteCharacteristicTask(SAMPLE_PRIMARY_SERVICE_1
                    , SAMPLE_WRITABLE_CHARACTERISTIC
                    , () -> new byte[]{0x00, 0x00, 0x00, 0x00, 0x00}
                    , WriteCharacteristicTask.TIMEOUT_MILLIS);
        } else if (R.id.read_descriptor == item.getItemId()) {
            mBleConnection.createReadDescriptorTask(SAMPLE_PRIMARY_SERVICE_1
                    , SAMPLE_READABLE_CHARACTERISTIC
                    , SAMPLE_READABLE_DESCRIPTOR
                    , ReadDescriptorTask.TIMEOUT_MILLIS);
        } else if (R.id.write_notification == item.getItemId()) {
            BluetoothGattDescriptor descriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0);
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            mBleConnection.createWriteDescriptorTask(
                    SAMPLE_PRIMARY_SERVICE_1
                    , SAMPLE_NOTIFICATABLE_CHARACTERISTIC
                    , CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , new ClientCharacteristicConfigurationAndroid(descriptor)
                    , WriteDescriptorTask.TIMEOUT_MILLIS
            );
        } else if (R.id.write_indication == item.getItemId()) {
            BluetoothGattDescriptor descriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0);
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
            mBleConnection.createWriteDescriptorTask(
                    SAMPLE_PRIMARY_SERVICE_1
                    , SAMPLE_INDICATABLE_CHARACTERISTIC
                    , CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , new ClientCharacteristicConfigurationAndroid(descriptor)
                    , WriteDescriptorTask.TIMEOUT_MILLIS
            );
        } else if (R.id.write_notification_stop == item.getItemId()) {
            BluetoothGattDescriptor descriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0);
            descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            mBleConnection.createWriteDescriptorTask(
                    SAMPLE_PRIMARY_SERVICE_1
                    , SAMPLE_NOTIFICATABLE_CHARACTERISTIC
                    , CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , new ClientCharacteristicConfigurationAndroid(descriptor)
                    , WriteDescriptorTask.TIMEOUT_MILLIS
            );
        } else if (R.id.write_indication_stop == item.getItemId()) {
            BluetoothGattDescriptor descriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0);
            descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            mBleConnection.createWriteDescriptorTask(
                    SAMPLE_PRIMARY_SERVICE_1
                    , SAMPLE_INDICATABLE_CHARACTERISTIC
                    , CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , new ClientCharacteristicConfigurationAndroid(descriptor)
                    , WriteDescriptorTask.TIMEOUT_MILLIS
            );
        } else if (R.id.read_characteristic_sync == item.getItemId()) {
            new Thread() {
                @Override
                public void run() {
                    BLEConnection target = mBleConnection;
                    if (target != null) {
                        BLESyncConnection.BLEResult result = BLESyncConnection.createReadCharacteristicTask(target
                                , SAMPLE_PRIMARY_SERVICE_1
                                , null
                                , SAMPLE_READABLE_CHARACTERISTIC
                                , null
                                , ReadCharacteristicTask.TIMEOUT_MILLIS
                                , ReadCharacteristicTask.TIMEOUT_MILLIS
                                , null
                                , false);

                        if (result == null) {
                            mBLECallbackSample.onCharacteristicReadFailed(0
                                    , target.getBluetoothDevice()
                                    , SAMPLE_PRIMARY_SERVICE_1
                                    , null
                                    , SAMPLE_READABLE_CHARACTERISTIC
                                    , null
                                    , BLESyncConnection.BLEResult.RESULT_FAILED
                                    , null);
                        } else {
                            byte[] value = result.getValues();
                            if (RESULT_SUCCESS == result.getResultCode() && value != null) {
                                mBLECallbackSample.onCharacteristicReadSuccess(0
                                        , target.getBluetoothDevice()
                                        , SAMPLE_PRIMARY_SERVICE_1
                                        , Objects.requireNonNull(result.getServiceInstanceId())
                                        , SAMPLE_READABLE_CHARACTERISTIC
                                        , Objects.requireNonNull(result.getCharacteristicInstanceId())
                                        , value
                                        , result.getArgument());
                            } else if (RESULT_FAILED == result.getResultCode()) {
                                mBLECallbackSample.onCharacteristicReadFailed(0
                                        , target.getBluetoothDevice()
                                        , SAMPLE_PRIMARY_SERVICE_1
                                        , result.getServiceInstanceId()
                                        , SAMPLE_READABLE_CHARACTERISTIC
                                        , result.getServiceInstanceId()
                                        , result.getStatus()
                                        , result.getArgument());
                            } else if (RESULT_TIMEOUT == result.getResultCode()) {
                                mBLECallbackSample.onCharacteristicReadTimeout(0
                                        , target.getBluetoothDevice()
                                        , SAMPLE_PRIMARY_SERVICE_1
                                        , result.getServiceInstanceId()
                                        , SAMPLE_READABLE_CHARACTERISTIC
                                        , result.getServiceInstanceId()
                                        , ReadCharacteristicTask.TIMEOUT_MILLIS
                                        , result.getArgument());
                            }
                        }
                    }
                }
            }.start();
        } else if (R.id.write_characteristic_sync == item.getItemId()) {
            new Thread() {
                @Override
                public void run() {
                    BLEConnection target = mBleConnection;
                    if (target != null) {

                        final byte[] value = new byte[]{0x00, 0x00, 0x00, 0x00, 0x00};
                        BLESyncConnection.BLEResult result = BLESyncConnection.createWriteCharacteristicTask(target,
                                SAMPLE_PRIMARY_SERVICE_1
                                , null, SAMPLE_WRITABLE_CHARACTERISTIC
                                , null, () -> value
                                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                                , WriteCharacteristicTask.TIMEOUT_MILLIS
                                , WriteCharacteristicTask.TIMEOUT_MILLIS
                                , null
                                , false);

                        if (result == null) {
                            mBLECallbackSample.onCharacteristicWriteFailed(0, target.getBluetoothDevice(), SAMPLE_PRIMARY_SERVICE_1, null, SAMPLE_WRITABLE_CHARACTERISTIC, null, BLESyncConnection.BLEResult.RESULT_FAILED, null);
                        } else {
                            if (RESULT_SUCCESS == result.getResultCode()) {
                                mBLECallbackSample.onCharacteristicWriteSuccess(0, target.getBluetoothDevice(), SAMPLE_PRIMARY_SERVICE_1, Objects.requireNonNull(result.getServiceInstanceId()), SAMPLE_WRITABLE_CHARACTERISTIC, Objects.requireNonNull(result.getCharacteristicInstanceId()), value, result.getArgument());
                            } else if (RESULT_FAILED == result.getResultCode()) {
                                mBLECallbackSample.onCharacteristicWriteFailed(0, target.getBluetoothDevice(), SAMPLE_PRIMARY_SERVICE_1, result.getServiceInstanceId(), SAMPLE_WRITABLE_CHARACTERISTIC, result.getCharacteristicInstanceId(), result.getStatus(), result.getArgument());
                            } else if (RESULT_TIMEOUT == result.getResultCode()) {
                                mBLECallbackSample.onCharacteristicWriteTimeout(0, target.getBluetoothDevice(), SAMPLE_PRIMARY_SERVICE_1, result.getServiceInstanceId(), SAMPLE_WRITABLE_CHARACTERISTIC, result.getCharacteristicInstanceId(), WriteCharacteristicTask.TIMEOUT_MILLIS, result.getArgument());
                            }
                        }
                    }
                }
            }.start();
        } else if (R.id.write_notification_sync == item.getItemId()) {
            new Thread() {
                @Override
                public void run() {
                    BLEConnection target = mBleConnection;
                    if (target != null) {
                        List<byte[]> valueList = BLESyncConnection.listen(target
                                , SAMPLE_PRIMARY_SERVICE_1
                                , SAMPLE_INDICATABLE_CHARACTERISTIC
                                , WriteDescriptorTask.TIMEOUT_MILLIS);

                        if (valueList != null) {
                            for (byte[] value : valueList) {
                                mBLECallbackSample.onCharacteristicNotified(mBleConnection.getBluetoothDevice(), SAMPLE_PRIMARY_SERVICE_1, 1, SAMPLE_NOTIFICATABLE_CHARACTERISTIC, 2, value);
                            }
                        }
                    }
                }
            }.start();
        } else if (R.id.write_characteristic_reliable == item.getItemId()) {
            mBleConnection.createBeginReliableWriteTask(null, null);
            mBleConnection.createWriteCharacteristicTask(SAMPLE_PRIMARY_SERVICE_1
                    , SAMPLE_WRITABLE_CHARACTERISTIC
                    , () -> new byte[]{0x00, 0x00, 0x00, 0x00, 0x00}
                    , WriteCharacteristicTask.TIMEOUT_MILLIS);
            mBleConnection.createExecuteReliableWriteTask(ExecuteReliableWriteTask.TIMEOUT_MILLIS, null, null);
        } else if (R.id.write_characteristic_reliable_abort == item.getItemId()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                mBleConnection.createBeginReliableWriteTask(null, null);
                mBleConnection.createWriteCharacteristicTask(SAMPLE_PRIMARY_SERVICE_1
                        , SAMPLE_WRITABLE_CHARACTERISTIC
                        , () -> new byte[]{0x00, 0x00, 0x00, 0x00, 0x00}
                        , WriteCharacteristicTask.TIMEOUT_MILLIS);
                mBleConnection.createAbortReliableWriteTask(AbortReliableWriteTask.TIMEOUT_MILLIS, null, null);
            }
        } else if (R.id.read_multi_instance_characteristic == item.getItemId()) {
            new Thread() {
                @Override
                public void run() {
                    BLEConnection target = mBleConnection;
                    if (target != null) {
                        BLESyncConnection.BLEResult result = BLESyncConnection.createDiscoverServiceTask(target
                                , DiscoverServiceTask.TIMEOUT_MILLIS
                                , DiscoverServiceTask.TIMEOUT_MILLIS
                                , null
                                , false);

                        if (result != null && RESULT_SUCCESS == result.getResultCode()) {
                            List<BluetoothGattService> bluetoothGattServiceList = Objects.requireNonNull(result.getServiceList());
                            for (BluetoothGattService bluetoothGattService : bluetoothGattServiceList) {
                                if (SAMPLE_PRIMARY_SERVICE_2.equals(bluetoothGattService.getUuid())) {
                                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                                        if (SAMPLE_READABLE_CHARACTERISTIC_2.equals(bluetoothGattCharacteristic.getUuid())) {
                                            result = BLESyncConnection.createReadCharacteristicTask(target
                                                    , bluetoothGattService.getUuid()
                                                    , bluetoothGattService.getInstanceId()
                                                    , bluetoothGattCharacteristic.getUuid()
                                                    , bluetoothGattCharacteristic.getInstanceId()
                                                    , ReadCharacteristicTask.TIMEOUT_MILLIS, ReadCharacteristicTask.TIMEOUT_MILLIS, null, true);
                                            if (result != null && RESULT_SUCCESS == result.getResultCode()) {
                                                byte[] value = result.getValues();
                                                mBLECallbackSample.onCharacteristicReadSuccess(0
                                                        , target.getBluetoothDevice()
                                                        , SAMPLE_PRIMARY_SERVICE_2
                                                        , Objects.requireNonNull(result.getServiceInstanceId())
                                                        , SAMPLE_READABLE_CHARACTERISTIC_2
                                                        , Objects.requireNonNull(result.getCharacteristicInstanceId())
                                                        , Objects.requireNonNull(value)
                                                        , result.getArgument());

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }.start();
//        } else if (R.id.mock_characteristic == item.getItemId()) {
//            mBleConnection.createWriteCharacteristicTask(MOCK_CONTROL_SERVICE_UUID
//                    , MOCK_CONTROL_CHARACTERISTIC_UUID
//                    , new MockControl(
//                            DEFAULT_SERVICE_UUID
//                            , null
//                            , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
//                            , null
//                            , MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID
//                            , MockControl.TARGET_TYPE_CHARACTERISTIC
//                            , BluetoothGatt.GATT_SUCCESS
//                            , "Mocked!".getBytes()
//                    )
//                    , WriteCharacteristicTask.TIMEOUT_MILLIS);
        } else if (R.id.set_notification_on == item.getItemId()) {
            mBleConnection.createSetNotificationTask(SAMPLE_PRIMARY_SERVICE_1
                    , null
                    , SAMPLE_NOTIFICATABLE_CHARACTERISTIC
                    , null
                    , true
                    , null
                    , null);
        } else if (R.id.set_notification_off == item.getItemId()) {
            mBleConnection.createSetNotificationTask(SAMPLE_PRIMARY_SERVICE_1
                    , null
                    , SAMPLE_NOTIFICATABLE_CHARACTERISTIC
                    , null
                    , false
                    , null
                    , null);
        } else if (R.id.set_notification_on_sync == item.getItemId()) {
            new Thread() {
                @Override
                public void run() {
                    BLEConnection target = mBleConnection;
                    if (target != null) {
                        BLESyncConnection.BLEResult result = BLESyncConnection.createSetNotificationTask(target
                                , SAMPLE_PRIMARY_SERVICE_1
                                , null
                                , SAMPLE_NOTIFICATABLE_CHARACTERISTIC
                                , null
                                , ReadCharacteristicTask.TIMEOUT_MILLIS
                                , true
                                , null
                                , false);

                        if (result == null) {
                            mBLECallbackSample.onSetNotificationFailed(0
                                    , target.getBluetoothDevice()
                                    , SAMPLE_PRIMARY_SERVICE_1
                                    , null
                                    , SAMPLE_NOTIFICATABLE_CHARACTERISTIC
                                    , null
                                    , true
                                    , BLESyncConnection.BLEResult.RESULT_FAILED
                                    , null);
                        } else {
                            if (RESULT_SUCCESS == result.getResultCode()) {
                                mBLECallbackSample.onSetNotificationSuccess(0
                                        , target.getBluetoothDevice()
                                        , SAMPLE_PRIMARY_SERVICE_1
                                        , Objects.requireNonNull(result.getServiceInstanceId())
                                        , SAMPLE_NOTIFICATABLE_CHARACTERISTIC
                                        , Objects.requireNonNull(result.getCharacteristicInstanceId())
                                        , result.getNotificationStatus()
                                        , result.getArgument());
                            } else if (RESULT_FAILED == result.getResultCode()) {
                                mBLECallbackSample.onSetNotificationFailed(0
                                        , target.getBluetoothDevice()
                                        , SAMPLE_PRIMARY_SERVICE_1
                                        , result.getServiceInstanceId()
                                        , SAMPLE_NOTIFICATABLE_CHARACTERISTIC
                                        , result.getServiceInstanceId()
                                        , result.getNotificationStatus()
                                        , result.getStatus()
                                        , result.getArgument());
                            }
                        }
                    }
                }
            }.start();
        } else if (R.id.set_notification_off_sync == item.getItemId()) {
            new Thread() {
                @Override
                public void run() {
                    BLEConnection target = mBleConnection;
                    if (target != null) {
                        BLESyncConnection.BLEResult result = BLESyncConnection.createSetNotificationTask(target
                                , SAMPLE_PRIMARY_SERVICE_1
                                , null
                                , SAMPLE_NOTIFICATABLE_CHARACTERISTIC
                                , null
                                , ReadCharacteristicTask.TIMEOUT_MILLIS
                                , false
                                , null
                                , false);

                        if (result == null) {
                            mBLECallbackSample.onSetNotificationFailed(0
                                    , target.getBluetoothDevice()
                                    , SAMPLE_PRIMARY_SERVICE_1
                                    , null
                                    , SAMPLE_NOTIFICATABLE_CHARACTERISTIC
                                    , null
                                    , true
                                    , BLESyncConnection.BLEResult.RESULT_FAILED
                                    , null);
                        } else {
                            if (RESULT_SUCCESS == result.getResultCode()) {
                                mBLECallbackSample.onSetNotificationSuccess(0
                                        , target.getBluetoothDevice()
                                        , SAMPLE_PRIMARY_SERVICE_1
                                        , Objects.requireNonNull(result.getServiceInstanceId())
                                        , SAMPLE_NOTIFICATABLE_CHARACTERISTIC
                                        , Objects.requireNonNull(result.getCharacteristicInstanceId())
                                        , result.getNotificationStatus()
                                        , result.getArgument());
                            } else if (RESULT_FAILED == result.getResultCode()) {
                                mBLECallbackSample.onSetNotificationFailed(0
                                        , target.getBluetoothDevice()
                                        , SAMPLE_PRIMARY_SERVICE_1
                                        , result.getServiceInstanceId()
                                        , SAMPLE_NOTIFICATABLE_CHARACTERISTIC
                                        , result.getServiceInstanceId()
                                        , result.getNotificationStatus()
                                        , result.getStatus()
                                        , result.getArgument());
                            }
                        }
                    }
                }
            }.start();
        } else if (R.id.menu_add_task_sync == item.getItemId()) {
            new Thread() {
                @Override
                public void run() {
                    BLEConnection target = mBleConnection;
                    if (target != null) {
                        BLESyncConnection bleSyncConnection = new BLESyncConnection(CentralSampleActivity.this, target.getBluetoothDevice(), target);
                        Bundle bundle = BLESyncConnection.wrapArgument(null, bleSyncConnection);
                        ReadRemoteRssiTask task = new ReadRemoteRssiTask(target, target.getBluetoothGatt(), target.getTaskHandler(), ReadRemoteRssiTask.TIMEOUT_MILLIS, bundle);
                        BLESyncConnection.BLEResult result = bleSyncConnection.createTask(task
                                , ReadRemoteRssiTask.TIMEOUT_MILLIS
                                , bundle);

                        if (result == null) {
                            mBLECallbackSample.onReadRemoteRssiFailed(0, target.getBluetoothDevice(), BLESyncConnection.BLEResult.RESULT_FAILED, null);
                        } else {
                            if (RESULT_SUCCESS == result.getResultCode()) {
                                mBLECallbackSample.onReadRemoteRssiSuccess(0, target.getBluetoothDevice(), result.getRssi(), result.getArgument());
                            } else if (RESULT_FAILED == result.getResultCode()) {
                                mBLECallbackSample.onReadRemoteRssiFailed(0, target.getBluetoothDevice(), result.getStatus(), result.getArgument());
                            } else if (RESULT_TIMEOUT == result.getResultCode()) {
                                mBLECallbackSample.onReadRemoteRssiTimeout(0, target.getBluetoothDevice(), ReadRemoteRssiTask.TIMEOUT_MILLIS, result.getArgument());
                            }
                        }
                    }
                }
            }.start();
        } else if (R.id.clear == item.getItemId()) {
            mBleConnection.clear();
            mAdapter.clear();
        }
        return true;
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else if (mBluetoothAdapter == null) {
            mConnectDisconnectButton.setVisibility(View.GONE);
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);

            if (mBleConnection == null) {
                mConnectDisconnectButton.setText(R.string.connect);
            } else {
                if (mBleConnection.isConnected()) {
                    if (mBleConnection.isAttached(mBLECallbackSample)) {
                        mConnectDisconnectButton.setText(R.string.disconnect);
                    } else {
                        mConnectDisconnectButton.setText(R.string.connect);
                    }
                } else {
                    mConnectDisconnectButton.setText(R.string.connect);
                }
            }
        }
        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mBleConnection == null) {
                BluetoothDevice target = findDevice();
                if (target == null) {
                    if (mBluetoothAdapter != null) {
                        if (mFilteredLeScanCallback == null) {
                            if (mReceiver == null) {
                                if (hasPermission()) {
                                    if (mBleConnection != null) {
                                        mBleConnection.quit();
                                        mBleConnection = null;
                                    }

                                    byte[] bytes = new byte[18];
                                    ByteBuffer bb = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
                                    bb.position(2);
                                    bb.putLong(MOCK_CONTROL_SERVICE_UUID.getLeastSignificantBits());
                                    bb.putLong(MOCK_CONTROL_SERVICE_UUID.getMostSignificantBits());
                                    mFilteredLeScanCallback = new FilteredLeScanCallback.Builder(this, null)
                                            .addFilter(new OrFilter<>(
                                                    new FlagsFilter(FlagsAndroid.CREATOR.createFromByteArray(new byte[]{0, 0, 1}))
                                                    , new FlagsFilter(FlagsAndroid.CREATOR.createFromByteArray(new byte[]{0, 0, 2}))))
                                            .addCompleteListOf128BitServiceUUIDsFilter(CompleteListOf128BitServiceUUIDsAndroid.CREATOR.createFromByteArray(bytes))
//                                            .setAdvertisingDataParser()
                                            .build();
                                    mBluetoothAdapter.startLeScan(mFilteredLeScanCallback);
                                }
                            } else {
                                unregisterReceiver(mReceiver);
                                mReceiver = null;
                            }
                        } else {
                            mBluetoothAdapter.stopLeScan(mFilteredLeScanCallback);
                            mFilteredLeScanCallback = null;
                        }
                    }
                } else {
                    mBleConnection = BLEConnectionHolder.getInstance(target);
                    if (mBleConnection == null) {
                        mBleConnection = new BLEConnection(this, target, null);
                        BLEConnectionHolder.addInstance(mBleConnection, true);
                    }
                    mBleConnection.attach(mBLECallbackSample);
                    if (mBleConnection.isConnected()) {
                        mBLECallbackSample.onBLEConnected(0, target, null);
                    } else {
                        mBleConnection.connect(ConnectTask.TIMEOUT_MILLIS);
                    }
                }
            } else {
                if (mBleConnection.isConnected()) {
                    if (mBleConnection.isAttached(mBLECallbackSample)) {
                        mBleConnection.detach(mBLECallbackSample);
                        mBLECallbackSample.onBLEDisconnected(0, mBleConnection.getBluetoothDevice(), BluetoothGatt.GATT_SUCCESS, null);
                    } else {
                        mBleConnection.attach(mBLECallbackSample);
                        mBLECallbackSample.onBLEConnected(0, mBleConnection.getBluetoothDevice(), null);
                    }
                } else {
                    if (mBleConnection.isAttached(mBLECallbackSample)) {
                        mBleConnection.detach(mBLECallbackSample);
                    }
                    mBleConnection.attach(mBLECallbackSample);
                    mBleConnection.connect(ConnectTask.TIMEOUT_MILLIS, null);
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

    private BluetoothDevice findDevice() {
        BluetoothDevice target = null;
        String latestAddress = getPreferences(MODE_PRIVATE).getString(KEY_LATEST_DEVICE, null);
        if (latestAddress != null) {
            Set<BluetoothDevice> bluetoothDeviceSet = mBluetoothAdapter.getBondedDevices();
            if (bluetoothDeviceSet != null) {
                for (BluetoothDevice device : bluetoothDeviceSet) {
                    if (latestAddress.equals(device.getAddress())) {
                        target = device;
                        break;
                    }
                }
            }
        }
        return target;
    }

    private void parse(@NonNull final BluetoothDevice device) {
        BLELogUtils.stackLog(device);
        runOnUiThread(() -> {
            try {
                CentralSampleActivity.this.mBluetoothAdapter.stopLeScan(CentralSampleActivity.this.mFilteredLeScanCallback);
                CentralSampleActivity.this.mFilteredLeScanCallback = null;
                if (BluetoothDevice.BOND_BONDED == device.getBondState()) {
                    CentralSampleActivity.this.mBleConnection = BLEConnectionHolder.getInstance(device);
                    if (CentralSampleActivity.this.mBleConnection == null) {
                        CentralSampleActivity.this.mBleConnection = new BLEConnection(CentralSampleActivity.this, device, null);
                        BLEConnectionHolder.addInstance(CentralSampleActivity.this.mBleConnection, true);
                    }
                    CentralSampleActivity.this.mBleConnection.attach(CentralSampleActivity.this.mBLECallbackSample);
                    CentralSampleActivity.this.mBleConnection.connect(ConnectTask.TIMEOUT_MILLIS);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        CentralSampleActivity.this.mReceiver = new BroadcastReceiver() {
                            @Override
                            public void onReceive(Context context, Intent intent) {
                                try {
                                    String action = intent.getAction();
                                    BLELogUtils.stackLog(action, intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE));
                                    if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)) {
                                        int state = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE);
                                        if (BluetoothDevice.BOND_BONDED == state) {
                                            CentralSampleActivity.this.getPreferences(Context.MODE_PRIVATE).edit().putString(KEY_LATEST_DEVICE, device.getAddress()).apply();
                                            CentralSampleActivity.this.mBleConnection = BLEConnectionHolder.getInstance(device);
                                            if (CentralSampleActivity.this.mBleConnection == null) {
                                                CentralSampleActivity.this.mBleConnection = new BLEConnection(CentralSampleActivity.this, device, null);
                                                BLEConnectionHolder.addInstance(CentralSampleActivity.this.mBleConnection, true);
                                            }
                                            CentralSampleActivity.this.mBleConnection.attach(CentralSampleActivity.this.mBLECallbackSample);
                                            CentralSampleActivity.this.mBleConnection.connect(ConnectTask.TIMEOUT_MILLIS);
                                            CentralSampleActivity.this.unregisterReceiver(CentralSampleActivity.this.mReceiver);
                                            CentralSampleActivity.this.mReceiver = null;
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        };
                        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
                        CentralSampleActivity.this.registerReceiver(CentralSampleActivity.this.mReceiver, intentFilter);
                        device.createBond();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void onFilteredLeScan(@NonNull BluetoothDevice device, int rssi, @NonNull byte[] scanRecord, @NonNull AdvertisingDataParser.AdvertisingDataParseResult result) {
        parse(device);
    }
}
