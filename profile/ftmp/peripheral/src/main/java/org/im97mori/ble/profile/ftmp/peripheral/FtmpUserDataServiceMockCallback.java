package org.im97mori.ble.profile.ftmp.peripheral;

import android.bluetooth.BluetoothDevice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.MockData;
import org.im97mori.ble.characteristic.u2acc.FitnessMachineFeature;
import org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback;

/**
 * Fitness Machine Profile specific {@link UserDataServiceMockCallback}
 */
public class FtmpUserDataServiceMockCallback extends UserDataServiceMockCallback {

    /**
     * Builder for {@link FtmpUserDataServiceMockCallback}
     *
     * @param <T> subclass of {@link FtmpUserDataServiceMockCallback}
     */
    public static class Builder<T extends FtmpUserDataServiceMockCallback> extends UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> {

        /**
         * @see FitnessMachineFeature#getBytes()
         */
        private byte[] mFitnessMachineFeatureData;

        /**
         * set {@link FitnessMachineFeature} data
         *
         * @param value FitnessMachineFeature#getBytes()
         * @return {@link FtmpUserDataServiceMockCallback.Builder} instance
         */
        @NonNull
        public Builder<T> setFitnessMachineFeature(@Nullable byte[] value) {
            mFitnessMachineFeatureData = value;
            return this;
        }

        /**
         * @return {@link FitnessMachineFeature#isFitnessMachineFeaturesUserDataRetentionSupported()}
         */
        protected boolean isUserDataRetentionFeatureSupported() {
            boolean isUserDataRetentionFeatureSupported = false;
            if (mFitnessMachineFeatureData != null) {
                FitnessMachineFeature fitnessMachineFeature = new FitnessMachineFeature(mFitnessMachineFeatureData);
                isUserDataRetentionFeatureSupported = fitnessMachineFeature.isFitnessMachineFeaturesUserDataRetentionSupported();
            }
            return isUserDataRetentionFeatureSupported;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public FtmpUserDataServiceMockCallback build() {
            return new FtmpUserDataServiceMockCallback(createMockData(), false, isUserDataRetentionFeatureSupported());
        }
    }

    /**
     * @see FitnessMachineFeature#isFitnessMachineFeaturesUserDataRetentionSupported()
     */
    protected final boolean mIsUserDataRetentionFeatureSupported;

    /**
     * @param mockData                            {@link MockData} instance
     * @param isFallback                          fallback flag
     * @param isUserDataRetentionFeatureSupported {@link FitnessMachineFeature#isFitnessMachineFeaturesUserDataRetentionSupported()}
     */
    public FtmpUserDataServiceMockCallback(@NonNull MockData mockData, boolean isFallback, boolean isUserDataRetentionFeatureSupported) {
        super(mockData, isFallback);
        mIsUserDataRetentionFeatureSupported = isUserDataRetentionFeatureSupported;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDeviceDisconnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {
        if (mIsUserDataRetentionFeatureSupported) {
            Integer userIndex = mCurrentUserMap.get(device);
            if (userIndex != null) {
                deleteUsers(userIndex);
            }
        }
        super.onDeviceDisconnected(bleServerConnection, device);
    }

}
