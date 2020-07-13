package org.im97mori.ble.profile.central;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Bond state BroadcastReceiver
 */
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class BondStateReceiver extends BroadcastReceiver {

    /**
     * @return {@link IntentFilter} with {@link BluetoothDevice#ACTION_BOND_STATE_CHANGED}
     */
    public static IntentFilter createIntentFilter() {
        return new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
    }

    /**
     * {@link AbstractCentralProfile} instance
     */
    private final AbstractCentralProfile mAbstractCentralProfile;

    /**
     * bond target {@link BluetoothDevice} instance
     */
    private final BluetoothDevice mTargetBluetoothDevice;

    /**
     * @param abstractCentralProfile {@link AbstractCentralProfile} instance
     * @param targetBluetoothDevice  bond target {@link BluetoothDevice} instance
     */
    public BondStateReceiver(@NonNull AbstractCentralProfile abstractCentralProfile, @NonNull BluetoothDevice targetBluetoothDevice) {
        mAbstractCentralProfile = abstractCentralProfile;
        mTargetBluetoothDevice = targetBluetoothDevice;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)) {
            BluetoothDevice bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            if (mTargetBluetoothDevice.equals(bluetoothDevice)) {
                int state = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE);
                if (BluetoothDevice.BOND_NONE == state) {
                    int previousState = intent.getIntExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE, BluetoothDevice.BOND_NONE);
                    if (BluetoothDevice.BOND_BONDING == previousState) {
                        mAbstractCentralProfile.onBondFailed(mTargetBluetoothDevice);
                    } else if (BluetoothDevice.BOND_BONDED == previousState) {
                        mAbstractCentralProfile.onBondFailed(mTargetBluetoothDevice);
                    }
                } else if (BluetoothDevice.BOND_BONDED == state) {
                    mAbstractCentralProfile.onBondSuccess(mTargetBluetoothDevice);
                    BondedDeviceDatabaseHelper bondedDeviceDatabaseHelper = mAbstractCentralProfile.getDatabaseHelper();
                    if (bondedDeviceDatabaseHelper != null) {
                        bondedDeviceDatabaseHelper.addHistory(mTargetBluetoothDevice);
                    }
                }
            }
        }
    }
}
