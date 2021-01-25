package org.im97mori.ble.profile.ftmp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;

import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.characteristic.u2acc.FitnessMachineFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FtmpUserDataServiceMockCallbackBuilderTest {

    @Test
    public void test_isUserDataRetentionFeatureSupported_00001() {
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> builder = new FtmpUserDataServiceMockCallback.Builder<>();

        assertFalse(builder.isUserDataRetentionFeatureSupported());
    }

    @Test
    public void test_isUserDataRetentionFeatureSupported_00002() {
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> builder = new FtmpUserDataServiceMockCallback.Builder<>()
                .setFitnessMachineFeature(new FitnessMachineFeature(new byte[8]).getBytes());

        assertFalse(builder.isUserDataRetentionFeatureSupported());
    }

    @Test
    public void test_isUserDataRetentionFeatureSupported_00003() {
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> builder = new FtmpUserDataServiceMockCallback.Builder<>()
                .setFitnessMachineFeature(new FitnessMachineFeature(new byte[]{(byte) FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_TRUE
                        , (byte) (FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_TRUE >> 8)
                        , (byte) (FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_TRUE >> 16)
                        , (byte) (FitnessMachineFeature.FITNESS_MACHINE_FEATURES_USER_DATA_RETENTION_SUPPORTED_TRUE >> 24)}
                        , new byte[4]).getBytes());

        assertTrue(builder.isUserDataRetentionFeatureSupported());
    }

    @Test
    public void test_build_00001() {
        FtmpUserDataServiceMockCallback ftmpUserDataServiceMockCallback = (FtmpUserDataServiceMockCallback) new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {
            @Override
            protected boolean isUserDataRetentionFeatureSupported() {
                return false;
            }
        }
                .addAge(1)
                .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addUserIndex()
                .addUserControlPoint(0, UserControlPoint.RESPONSE_VALUE_SUCCESS, UserControlPoint.RESPONSE_VALUE_SUCCESS, UserControlPoint.RESPONSE_VALUE_SUCCESS, UserControlPoint.RESPONSE_VALUE_SUCCESS, UserControlPoint.RESPONSE_VALUE_SUCCESS, BluetoothGatt.GATT_SUCCESS, 0, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();

        assertFalse(ftmpUserDataServiceMockCallback.mIsUserDataRetentionFeatureSupported);
    }

    @Test
    public void test_build_00002() {
        FtmpUserDataServiceMockCallback ftmpUserDataServiceMockCallback = (FtmpUserDataServiceMockCallback) new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {
            @Override
            protected boolean isUserDataRetentionFeatureSupported() {
                return true;
            }
        }
                .addAge(1)
                .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addUserIndex()
                .addUserControlPoint(0, UserControlPoint.RESPONSE_VALUE_SUCCESS, UserControlPoint.RESPONSE_VALUE_SUCCESS, UserControlPoint.RESPONSE_VALUE_SUCCESS, UserControlPoint.RESPONSE_VALUE_SUCCESS, UserControlPoint.RESPONSE_VALUE_SUCCESS, BluetoothGatt.GATT_SUCCESS, 0, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addRegisteredUser(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();

        assertTrue(ftmpUserDataServiceMockCallback.mIsUserDataRetentionFeatureSupported);
    }

}
