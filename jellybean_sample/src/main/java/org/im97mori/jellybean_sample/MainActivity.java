package org.im97mori.jellybean_sample;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import org.im97mori.ble.BLELogUtils;
import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.AdvertisingInterval;
import org.im97mori.ble.ad.Appearance;
import org.im97mori.ble.ad.ChannelMapUpdateIndication;
import org.im97mori.ble.ad.CompleteListOf128BitServiceUUIDs;
import org.im97mori.ble.ad.CompleteListOf16BitServiceUUIDs;
import org.im97mori.ble.ad.CompleteListOf32BitServiceUUIDs;
import org.im97mori.ble.ad.CompleteLocalName;
import org.im97mori.ble.ad.Flags;
import org.im97mori.ble.ad.IncompleteListOf128BitServiceUUIDs;
import org.im97mori.ble.ad.IncompleteListOf16BitServiceUUIDs;
import org.im97mori.ble.ad.IncompleteListOf32BitServiceUUIDs;
import org.im97mori.ble.ad.LeSupportedFeatures;
import org.im97mori.ble.ad.ListOf128BitServiceSolicitationUUIDs;
import org.im97mori.ble.ad.ListOf16BitServiceSolicitationUUIDs;
import org.im97mori.ble.ad.ListOf32BitServiceSolicitationUUIDs;
import org.im97mori.ble.ad.ManufacturerSpecificData;
import org.im97mori.ble.ad.PublicTargetAddress;
import org.im97mori.ble.ad.RandomTargetAddress;
import org.im97mori.ble.ad.ServiceData128BitUUID;
import org.im97mori.ble.ad.ServiceData16BitUUID;
import org.im97mori.ble.ad.ServiceData32BitUUID;
import org.im97mori.ble.ad.ShortenedLocalName;
import org.im97mori.ble.ad.SlaveConnectionIntervalRange;
import org.im97mori.ble.ad.TxPowerLevel;
import org.im97mori.ble.ad.UniformRsourceIdentifier;
import org.im97mori.ble.ad.filter.FilteredLeScanCallback;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class MainActivity extends FragmentActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback {

    private static final int REQUEST_PERMISSION_COARSE_LOCATION = 0;
    private static final String FRAGMENT_TAG_ALERT_DIALOG = "FRAGMENT_TAG_ALERT_DIALOG";

    private static final class TestLeScanCallback implements BluetoothAdapter.LeScanCallback {

        final MainActivity mMainActivity;
        final AdvertisingDataParser mAdvertisingDataParser;


        private TestLeScanCallback(MainActivity mainActivity) {
            mMainActivity = mainActivity;
            AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
            mAdvertisingDataParser = builder.build();
        }

        @Override
        public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US);
            String now = format.format(new Date());

            AdvertisingDataParser.AdvertisingDataParseResult result = mAdvertisingDataParser.parse(scanRecord);
            final StringBuilder sb = new StringBuilder();

            sb.append("data count:");
            sb.append(result.getResultList().size());
            sb.append('\n');
            sb.append('\n');

            IncompleteListOf16BitServiceUUIDs incompleteListOf16BitServiceUUIDs = result.getIncompleteListOf16BitServiceUUIDs();
            if (incompleteListOf16BitServiceUUIDs != null) {
                sb.append("Incomplete List of 16-bit Service Class UUIDs");
                sb.append("\nuuid list\n");
                sb.append(Arrays.toString(incompleteListOf16BitServiceUUIDs.getUuidList().toArray()));
                sb.append('\n');
                sb.append('\n');
            }

            CompleteListOf16BitServiceUUIDs completeListOf16BitServiceUUIDs = result.getCompleteListOf16BitServiceUUIDs();
            if (completeListOf16BitServiceUUIDs != null) {
                sb.append("Complete List of 16-bit Service Class UUIDs");
                sb.append("\nuuid list\n");
                sb.append(Arrays.toString(completeListOf16BitServiceUUIDs.getUuidList().toArray()));
                sb.append('\n');
                sb.append('\n');
            }

            IncompleteListOf32BitServiceUUIDs incompleteListOf32BitServiceUUIDs = result.getIncompleteListOf32BitServiceUUIDs();
            if (incompleteListOf32BitServiceUUIDs != null) {
                sb.append("Incomplete List of 32-bit Service Class UUIDs");
                sb.append("\nuuid list\n");
                sb.append(Arrays.toString(incompleteListOf32BitServiceUUIDs.getUuidList().toArray()));
                sb.append('\n');
                sb.append('\n');
            }

            CompleteListOf32BitServiceUUIDs completeListOf32BitServiceUUIDs = result.getCompleteListOf32BitServiceUUIDs();
            if (completeListOf32BitServiceUUIDs != null) {
                sb.append("Complete List of 32-bit Service Class UUIDs");
                sb.append("\nuuid list\n");
                sb.append(Arrays.toString(completeListOf32BitServiceUUIDs.getUuidList().toArray()));
                sb.append('\n');
                sb.append('\n');
            }

            IncompleteListOf128BitServiceUUIDs incompleteListOf128BitServiceUUIDs = result.getIncompleteListOf128BitServiceUUIDs();
            if (incompleteListOf128BitServiceUUIDs != null) {
                sb.append("Incomplete List of 128-bit Service Class UUIDs");
                sb.append("\nuuid list\n");
                sb.append(Arrays.toString(incompleteListOf128BitServiceUUIDs.getUuidList().toArray()));
                sb.append('\n');
                sb.append('\n');
            }

            CompleteListOf128BitServiceUUIDs completeListOf128BitServiceUUIDs = result.getCompleteListOf128BitServiceUUIDs();
            if (completeListOf128BitServiceUUIDs != null) {
                sb.append("Complete List of 128-bit Service Class UUIDs");
                sb.append("\nuuid list\n");
                sb.append(Arrays.toString(completeListOf128BitServiceUUIDs.getUuidList().toArray()));
                sb.append('\n');
                sb.append('\n');
            }

            ShortenedLocalName shortenedLocalName = result.getShortenedLocalName();
            if (shortenedLocalName != null) {
                sb.append("Shortened Local Name");
                sb.append('\n');
                sb.append(shortenedLocalName.getShortenedLocalName());
                sb.append('\n');
                sb.append('\n');
            }

            CompleteLocalName completeLocalName = result.getCompleteLocalName();
            if (completeLocalName != null) {
                sb.append("Complete Local Name");
                sb.append('\n');
                sb.append(completeLocalName.getCompleteLocalName());
                sb.append('\n');
                sb.append('\n');
            }

            Flags flags = result.getFlags();
            if (flags != null) {
                sb.append("Flags");
                sb.append("\nflag list\n");
                sb.append(Arrays.toString(flags.getFlagsList().toArray()));
                sb.append('\n');
                sb.append('\n');
            }

            ManufacturerSpecificData manufacturerSpecificData = result.getManufacturerSpecificData();
            if (manufacturerSpecificData != null) {
                sb.append("Manufacturer Specific Data");
                sb.append("\nCompany Identifier Code\n");
                sb.append(manufacturerSpecificData.getCompanyIdentifier());
                sb.append("\nCompany Name\n");
                sb.append(manufacturerSpecificData.getCompanyName());
                sb.append("\nManufacturer Specific Data size\n");
                sb.append(manufacturerSpecificData.getManufacturerSpecificData().length);
                sb.append("\nManufacturer Specific Data list\n");
                sb.append(Arrays.toString(manufacturerSpecificData.getManufacturerSpecificData()));
                sb.append('\n');
                sb.append('\n');
            }

            TxPowerLevel txPowerLevel = result.getTxPowerLevel();
            if (txPowerLevel != null) {
                sb.append("Tx Power Level");
                sb.append('\n');
                sb.append(txPowerLevel.getTxPowerLevel());
                sb.append('\n');
                sb.append('\n');
            }

            SlaveConnectionIntervalRange slaveConnectionIntervalRange = result.getSlaveConnectionIntervalRange();
            if (slaveConnectionIntervalRange != null) {
                sb.append("Slave Connection Interval Range");
                if (slaveConnectionIntervalRange.hasMaximum()) {
                    sb.append("\nhas maximum\n");
                    sb.append(slaveConnectionIntervalRange.getMaximumValueMillis());
                }
                if (slaveConnectionIntervalRange.hasMinimum()) {
                    sb.append("\nhas minimum\n");
                    sb.append(slaveConnectionIntervalRange.getMinimumValueMillis());
                }
                sb.append('\n');
                sb.append('\n');
            }

            ListOf16BitServiceSolicitationUUIDs listOf16BitServiceSolicitationUUIDs = result.getListOf16BitServiceSolicitationUUIDs();
            if (listOf16BitServiceSolicitationUUIDs != null) {
                sb.append("List of 16-bit Service Solicitation UUIDs");
                sb.append("\nuuid list\n");
                sb.append(Arrays.toString(listOf16BitServiceSolicitationUUIDs.getUuidList().toArray()));
                sb.append('\n');
                sb.append('\n');
            }

            ListOf32BitServiceSolicitationUUIDs listOf32BitServiceSolicitationUUIDs = result.getListOf32BitServiceSolicitationUUIDs();
            if (listOf32BitServiceSolicitationUUIDs != null) {
                sb.append("List of 32-bit Service Solicitation UUIDs");
                sb.append("\nuuid list\n");
                sb.append(Arrays.toString(listOf32BitServiceSolicitationUUIDs.getUuidList().toArray()));
                sb.append('\n');
                sb.append('\n');
            }

            ListOf128BitServiceSolicitationUUIDs listOf128BitServiceSolicitationUUIDs = result.getListOf128BitServiceSolicitationUUIDs();
            if (listOf128BitServiceSolicitationUUIDs != null) {
                sb.append("List of 128-bit Service Solicitation UUIDs");
                sb.append("\nuuid list\n");
                sb.append(Arrays.toString(listOf128BitServiceSolicitationUUIDs.getUuidList().toArray()));
                sb.append('\n');
                sb.append('\n');
            }

            ServiceData16BitUUID serviceData16BitUUID = result.getServiceData16BitUUID();
            if (serviceData16BitUUID != null) {
                sb.append("Service Data - 16-bit UUID");
                sb.append("\nuuid\n");
                sb.append(serviceData16BitUUID.getUuid());
                sb.append("\nAdditional service data size\n");
                sb.append(serviceData16BitUUID.getAdditionalServiceData().length);
                sb.append("\nAdditional service data list\n");
                sb.append(Arrays.toString(serviceData16BitUUID.getAdditionalServiceData()));
                sb.append('\n');
                sb.append('\n');
            }

            ServiceData32BitUUID serviceData32BitUUID = result.getServiceData32BitUUID();
            if (serviceData32BitUUID != null) {
                sb.append("Service Data - 32-bit UUID");
                sb.append("\nuuid\n");
                sb.append(serviceData32BitUUID.getUuid());
                sb.append("\nAdditional service data size\n");
                sb.append(serviceData32BitUUID.getAdditionalServiceData().length);
                sb.append("\nAdditional service data list\n");
                sb.append(Arrays.toString(serviceData32BitUUID.getAdditionalServiceData()));
                sb.append('\n');
                sb.append('\n');
            }

            ServiceData128BitUUID serviceData128BitUUID = result.getServiceData128BitUUID();
            if (serviceData128BitUUID != null) {
                sb.append("Service Data - 128-bit UUID");
                sb.append("\nuuid\n");
                sb.append(serviceData128BitUUID.getUuid());
                sb.append("\nAdditional service data size\n");
                sb.append(serviceData128BitUUID.getAdditionalServiceData().length);
                sb.append("\nAdditional service data list\n");
                sb.append(Arrays.toString(serviceData128BitUUID.getAdditionalServiceData()));
                sb.append('\n');
                sb.append('\n');
            }

            Appearance appearance = result.getAppearance();
            if (appearance != null) {
                sb.append("Appearance");
                sb.append("\nkey\n");
                sb.append(appearance.getAppearanceKey());
                sb.append("\nvalue\n");
                sb.append(appearance.getAppearanceValue());
                sb.append("\ndescription\n");
                sb.append(appearance.getAppearanceDescription());
                sb.append('\n');
                sb.append('\n');
            }

            PublicTargetAddress publicTargetAddress = result.getPublicTargetAddress();
            if (publicTargetAddress != null) {
                sb.append("Public Target Address");
                sb.append("\nPublic Target Address list\n");
                sb.append(Arrays.toString(publicTargetAddress.getAddressList().toArray()));
                sb.append('\n');
                sb.append('\n');
            }

            RandomTargetAddress randomTargetAddress = result.getRandomTargetAddress();
            if (randomTargetAddress != null) {
                sb.append("Random Target Address");
                sb.append("\nRandom Target Address list\n");
                sb.append(Arrays.toString(randomTargetAddress.getAddressList().toArray()));
                sb.append('\n');
                sb.append('\n');
            }

            AdvertisingInterval advertisingInterval = result.getAdvertisingInterval();
            if (advertisingInterval != null) {
                sb.append("Advertising Interval");
                sb.append('\n');
                sb.append(advertisingInterval.getAdvertisingInterval());
                sb.append("\nAdvertising Interval(millis)\n");
                sb.append(advertisingInterval.getAdvertisingIntervalMillis());
                sb.append('\n');
                sb.append('\n');
            }

            UniformRsourceIdentifier uniformRsourceIdentifier = result.getUniformRsourceIdentifier();
            if (uniformRsourceIdentifier != null) {
                sb.append("URI");
                sb.append('\n');
                sb.append(uniformRsourceIdentifier.getUri());
                sb.append("\nURI text\n");
                sb.append(uniformRsourceIdentifier.getUriString());
                sb.append('\n');
                sb.append('\n');
            }

            LeSupportedFeatures leSupportedFeatures = result.getLeSupportedFeatures();
            if (leSupportedFeatures != null) {
                sb.append("LE Supported Features");
                sb.append("\nLE Supported Features size\n");
                sb.append(leSupportedFeatures.getLeSupportedFeaturesList().size());
                sb.append("\nLE Supported Features list\n");
                sb.append(Arrays.toString(leSupportedFeatures.getLeSupportedFeaturesList().toArray()));
                if (leSupportedFeatures.isLeEncryptionSupported()) {
                    sb.append("LE Encryption\n");
                }
                if (leSupportedFeatures.isConnectionParametersRequestProcedureSupported()) {
                    sb.append("Connection Parameters Request Procedure\n");
                }
                if (leSupportedFeatures.isExtendedRejectIndicationSupported()) {
                    sb.append("Extended Reject Indication\n");
                }
                if (leSupportedFeatures.isSlaveInitiatedFeaturesExchangeSupported()) {
                    sb.append("Slave-initiated Features Exchange\n");
                }
                if (leSupportedFeatures.isLePingSupported()) {
                    sb.append("LE Ping\n");
                }
                if (leSupportedFeatures.isLeDataPacketLengthExtensionSupported()) {
                    sb.append("LE Data Packet Length Extension\n");
                }
                if (leSupportedFeatures.isLlPrivacySupported()) {
                    sb.append("LL Privacy\n");
                }
                if (leSupportedFeatures.isExtendedScannerFilterPoliciesSupported()) {
                    sb.append("Extended Scanner Filter Policies\n");
                }
                if (leSupportedFeatures.isLe2mPhySupported()) {
                    sb.append("LE 2M PHY\n");
                }
                if (leSupportedFeatures.isStableModulationIndexTransmitterSupported()) {
                    sb.append("Stable Modulation Index - Transmitter\n");
                }
                if (leSupportedFeatures.isStableModulationIndexReceiverSupported()) {
                    sb.append("Stable Modulation Index - Receiver\n");
                }
                if (leSupportedFeatures.isLeCodedPhySupported()) {
                    sb.append("LE Coded PHY\n");
                }
                if (leSupportedFeatures.isLeExtendedAdvertisingSupported()) {
                    sb.append("LE Extended Advertising\n");
                }
                if (leSupportedFeatures.isLePeriodicAdvertisingSupported()) {
                    sb.append("LE Periodic Advertising\n");
                }
                if (leSupportedFeatures.isChannelSelectionAlgorithm2Supported()) {
                    sb.append("Channel Selection Algorithm #2\n");
                }
                if (leSupportedFeatures.isLePowerClass1Supported()) {
                    sb.append("LE Power Class 1\n");
                }
                if (leSupportedFeatures.isMinimumNumberOfUsedChannelsProcedureSupported()) {
                    sb.append("Minimum Number of Used Channels Procedure\n");
                }
                if (leSupportedFeatures.isConnectionCteRequestSupported()) {
                    sb.append("Connection CTE Request\n");
                }
                if (leSupportedFeatures.isConnectionCteResponseSupported()) {
                    sb.append("Connection CTE Response\n");
                }
                if (leSupportedFeatures.isConnectionlessCteTransmitterSupported()) {
                    sb.append("Connectionless CTE Transmitter\n");
                }
                if (leSupportedFeatures.isConnectionlessCteReceiverSupported()) {
                    sb.append("Connectionless CTE Receiver\n");
                }
                if (leSupportedFeatures.isAntennaSwitchingDuringCteTransmissionAodSupported()) {
                    sb.append("Antenna Switching During CTE Transmission (AoD)\n");
                }
                if (leSupportedFeatures.isAntennaSwitchingDuringCteReceptionAoaSupported()) {
                    sb.append("Antenna Switching During CTE Reception (AoA)\n");
                }
                if (leSupportedFeatures.isReceivingConstantToneExtensionsSupported()) {
                    sb.append("Receiving Constant Tone Extensions\n");
                }
                if (leSupportedFeatures.isPeriodicAdvertisingSyncTransferSenderSupported()) {
                    sb.append("Periodic Advertising Sync Transfer - Sender\n");
                }
                if (leSupportedFeatures.isPeriodicAdvertisingSyncTransferRecipientSupported()) {
                    sb.append("Periodic Advertising Sync Transfer - Recipient\n");
                }
                if (leSupportedFeatures.isSleepClockAccuracyUpdatesSupported()) {
                    sb.append("Sleep Clock Accuracy Updates\n");
                }
                if (leSupportedFeatures.isRemotePublicKeyValidationSupported()) {
                    sb.append("Remote Public Key Validation\n");
                }
                sb.append('\n');
                sb.append('\n');
            }

            ChannelMapUpdateIndication channelMapUpdateIndication = result.getChannelMapUpdateIndication();
            if (channelMapUpdateIndication != null) {
                sb.append("Channel Map Update Indication");
                sb.append("\nChM size\n");
                sb.append(channelMapUpdateIndication.getChmList().size());
                sb.append("\nChM list\n");
                sb.append(Arrays.toString(channelMapUpdateIndication.getChmList().toArray()));
                sb.append("\nunused PHY Channel size\n");
                sb.append(channelMapUpdateIndication.getUnusedPhyChannelList().size());
                sb.append("\nunused PHY Channel list\n");
                sb.append(Arrays.toString(channelMapUpdateIndication.getUnusedPhyChannelList().toArray()));
                sb.append("\nunused RF Center Frequency(MHz) size\n");
                sb.append(channelMapUpdateIndication.getUnusedPhyChannelRfCenterFrequencyList().size());
                sb.append("\nunused RF Center Frequency(MHz) list\n");
                sb.append(Arrays.toString(channelMapUpdateIndication.getUnusedPhyChannelRfCenterFrequencyList().toArray()));
                sb.append("\nInstant\n");
                sb.append(channelMapUpdateIndication.getInstant());
                sb.append('\n');
                sb.append('\n');
            }

            final Pair<String, String> log = Pair.create(now, sb.toString());

            mMainActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        mMainActivity.mAdapter.add(log);
                        mMainActivity.mListView.smoothScrollToPosition(mMainActivity.mAdapter.getCount());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private Button mGetPermissionButton;
    private Button mConnectDisconnectButton;
    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    private FilteredLeScanCallback mFilteredLeScanCallback;

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BLELogUtils.verbose();

        setContentView(R.layout.gatt_sample);

        mFragmentManager = getSupportFragmentManager();

        mGetPermissionButton = findViewById(R.id.getPermissionButton);

        mConnectDisconnectButton = findViewById(R.id.connectDisconnectButton);
        mAdapter = new ArrayAdapter<Pair<String, String>>(this, R.layout.list_child, new LinkedList<Pair<String, String>>()) {
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

        mGetPermissionButton.setOnClickListener(this);
        mConnectDisconnectButton.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        if (mFilteredLeScanCallback != null) {
            mBluetoothAdapter.stopLeScan(mFilteredLeScanCallback);
            mFilteredLeScanCallback = null;
        }
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();

        hasPermission();

        updateLayout();
    }

    @Override
    public void onClick(View v) {
        if (R.id.getPermissionButton == v.getId()) {
            hasPermission();
        } else if (R.id.connectDisconnectButton == v.getId()) {
            if (mBluetoothAdapter != null) {
                if (mFilteredLeScanCallback == null) {
                    if (hasPermission()) {
                        mConnectDisconnectButton.setText(R.string.scan_stop);
                        mFilteredLeScanCallback = new FilteredLeScanCallback.Builder().setScanCallback(new TestLeScanCallback(this)).build();
                        mBluetoothAdapter.startLeScan(mFilteredLeScanCallback);
                    }
                } else {
                    mConnectDisconnectButton.setText(R.string.scan_start);
                    mBluetoothAdapter.stopLeScan(mFilteredLeScanCallback);
                    mFilteredLeScanCallback = null;
                }
            }
            updateLayout();
        }
    }

    private void updateLayout() {
        if (mBluetoothAdapter != null && !mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.enable();
        } else if (mBluetoothAdapter == null) {
            mAdapter.clear();
            mAdapter.notifyDataSetChanged();
        } else if (mFilteredLeScanCallback == null) {
            mConnectDisconnectButton.setText(R.string.scan_start);
        } else {
            mConnectDisconnectButton.setText(R.string.scan_stop);
        }
    }

    @Override
    public void onOk() {
        try {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCancel() {
        Fragment fragment = mFragmentManager.findFragmentByTag(FRAGMENT_TAG_ALERT_DIALOG);
        if (fragment instanceof AlertDialogFragment) {
            ((AlertDialogFragment) fragment).dismissAllowingStateLoss();
        }
    }

    private boolean hasPermission() {
        boolean result = true;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (PackageManager.PERMISSION_DENIED == checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                result = false;
                if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                    if (mFragmentManager.findFragmentByTag(FRAGMENT_TAG_ALERT_DIALOG) == null) {
                        AlertDialogFragment fragment = new AlertDialogFragment();
                        fragment.show(mFragmentManager, FRAGMENT_TAG_ALERT_DIALOG);
                    }
                } else {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_PERMISSION_COARSE_LOCATION);
                }
            }
        }
        if (result) {
            mGetPermissionButton.setVisibility(View.GONE);
        } else {
            mGetPermissionButton.setVisibility(View.VISIBLE);
        }
        return result;
    }
}
