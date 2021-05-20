package org.im97mori.ble.service.rcs.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.u2b1d.RCFeature;
import org.im97mori.ble.characteristic.u2b1e.RCSettings;
import org.im97mori.ble.characteristic.u2b1f.ReconnectionConfigurationControlPoint;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RC_SETTINGS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.RECONNECTION_CONFIGURATION_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@SuppressWarnings("ConstantConditions")
public class ReconnectionConfigurationServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RC Feature data", exception.getMessage());
    }

    @Test
    public void test_exception_00002() {
        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, new byte[3]))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00003() {
        int featureFlag = RCFeature.RC_FEATURES_E2E_CRC_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("RC Feature CRC not matched", exception.getMessage());
    }

    @Test
    public void test_exception_00004() {
        int featureFlag = RCFeature.RC_FEATURES_E2E_CRC_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(BLEUtils.createCrc(featureData, 0, featureData.length)
                            , featureData))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00101() {
        int featureFlag = RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RC Settings data", exception.getMessage());
    }

    @Test
    public void test_exception_00102() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RC Settings data", exception.getMessage());
    }

    @Test
    public void test_exception_00103() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};


        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RC Settings data", exception.getMessage());
    }

    @Test
    public void test_exception_00104() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RC Settings data", exception.getMessage());
    }

    @Test
    public void test_exception_00105() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RC Settings data", exception.getMessage());
    }

    @Test
    public void test_exception_00106() {
        int featureFlag = RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RC Settings data", exception.getMessage());
    }

    @Test
    public void test_exception_00107() {
        int featureFlag = RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};


        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RC Settings data", exception.getMessage());
    }

    @Test
    public void test_exception_00108() {
        int featureFlag = RCFeature.RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};


        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RC Settings data", exception.getMessage());
    }

    @Test
    public void test_exception_00110() {
        int featureFlag = 0;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("RC Settings not supported", exception.getMessage());
    }

    @Test
    public void test_exception_00111() {
        int featureFlag = RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00112() {
        int featureFlag = RCFeature.RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00113() {
        int featureFlag = RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00114() {
        int featureFlag = RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00115() {
        int featureFlag = RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00116() {
        int featureFlag = RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00117() {
        int featureFlag = RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00118() {
        int featureFlag = RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00119() {
        int featureFlag = RCFeature.RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00120() {
        int featureFlag = RCFeature.RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00121() {
        int featureFlag = RCFeature.RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00122() {
        int featureFlag = RCFeature.RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00123() {
        int featureFlag = RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00124() {
        int featureFlag = RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00125() {
        int featureFlag = RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00126() {
        int featureFlag = RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00127() {
        int featureFlag = RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00128() {
        int featureFlag = RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00129() {
        int featureFlag = RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00130() {
        int featureFlag = RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00131() {
        int featureFlag = RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RC Settings Client Characteristic Descriptor data", exception.getMessage());
    }

    @Test
    public void test_exception_00132() {
        int featureFlag = RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_FALSE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED, featureData))
                    .addRCSettings(true
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("RC Settings notification not supported", exception.getMessage());
    }

    @Test
    public void test_exception_00133() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_E2E_CRC_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(BLEUtils.createCrc(featureData, 0, featureData.length)
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("RC Settings CRC not matched", exception.getMessage());
    }

    @Test
    public void test_exception_00134() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_E2E_CRC_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{5
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};
        long settingsCrc = BLEUtils.createCrc(settingsData, 0, settingsData.length);
        settingsData = new byte[]{settingsData[0]
                , settingsData[1]
                , settingsData[2]
                , (byte) settingsCrc
                , (byte) (settingsCrc >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(BLEUtils.createCrc(featureData, 0, featureData.length)
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00135() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_LESC_ONLY_TRUE;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Upgrade to LESC Only not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00136() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_USE_OOB_PAIRING_TRUE;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Next Pairing OOB not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00137() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_READY_FOR_DISCONNECT_TRUE;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Ready for Disconnect not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00138() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_LIMITED_ACCESS_TRUE;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Limited Access Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00139() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 1 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00140() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_2;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 2 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00141() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_3;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 3 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00142() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_4;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Configuration 4 not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00201() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(true
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00202() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_PROPOSE_RECONNECTION_TIMEOUT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00203() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00204() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_PROPOSE_SLAVE_LATENCY_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00205() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_PROPOSE_SUPERVISION_TIMEOUT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00206() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_PROPOSE_ADVERTISEMENT_INTERVAL_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00207() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_PROPOSE_ADVERTISEMENT_COUNT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00208() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_PROPOSE_ADVERTISEMENT_REPETITION_TIME_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00209() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00210() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_2;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00211() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_3;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00212() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_4;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00213() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00214() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00215() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00216() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00217() {
        int featureFlag = 0;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Configuration Control Point not supported", exception.getMessage());
    }

    @Test
    public void test_exception_00218() {
        int featureFlag = RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00219() {
        int featureFlag = RCFeature.RC_FEATURES_PROPOSE_RECONNECTION_TIMEOUT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00220() {
        int featureFlag = RCFeature.RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00221() {
        int featureFlag = RCFeature.RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00222() {
        int featureFlag = RCFeature.RC_FEATURES_PROPOSE_ADVERTISEMENT_COUNT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00223() {
        int featureFlag = RCFeature.RC_FEATURES_PROPOSE_SUPERVISION_TIMEOUT_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00224() {
        int featureFlag = RCFeature.RC_FEATURES_PROPOSE_ADVERTISEMENT_INTERVAL_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00225() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = 0;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00226() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_2;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00227() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_3;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00228() {
        int featureFlag = RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_4;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00229() {
        int featureFlag = RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00230() {
        int featureFlag = RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_2;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00231() {
        int featureFlag = RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_3;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00232() {
        int featureFlag = RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_4;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00233() {
        int featureFlag = RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00234() {
        int featureFlag = RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_2;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00235() {
        int featureFlag = RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_3;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00236() {
        int featureFlag = RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_4;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00237() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00238() {
        int featureFlag = RCFeature.RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00239() {
        int featureFlag = RCFeature.RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_2;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00240() {
        int featureFlag = RCFeature.RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_3;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00241() {
        int featureFlag = RCFeature.RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE
                | RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int settingsFlag = RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_4;
        byte[] settingsData = new byte[]{3
                , (byte) settingsFlag
                , (byte) (settingsFlag >> 8)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addRCSettings(false
                            , 0
                            , 0
                            , settingsData
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00242() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , 0x05, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Minimum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00243() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x81, 0x0c
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Minimum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00244() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , 0x05, 0x00
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Maximum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00245() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x81, 0x0c
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Maximum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00246() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf4, 0x01
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Slave Latency is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00247() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , 0x09, 0x00
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Supervision Timeout multiplier is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00248() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x81, 0x0c
                , 0, 0
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Supervision Timeout multiplier is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00249() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x1f, 0x00
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00250() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x01, 0x40
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00251() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , 0, 0
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Count is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00252() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe9, 0x03
                , 0, 0};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Count is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00253() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x11, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[16];
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Repetition Time is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00254() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0x21, 0x4e
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00255() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , 0x05, 0x00
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Minimum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00256() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x81, 0x0c
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Minimum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00257() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , 0x05, 0x00
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Maximum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00258() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x81, 0x0c
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Maximum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00259() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf5, 0x01
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Slave Latency is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00260() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , 0x09, 0x00
                , 0, 0
                , 0, 0
                , 0, 0};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Supervision Timeout multiplier is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00261() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x81, 0x0c
                , 0, 0
                , 0, 0
                , 0, 0};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Supervision Timeout multiplier is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00262() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x1f, 0x00
                , 0, 0
                , 0, 0};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00263() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x01, 0x40
                , 0, 0
                , 0, 0};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00264() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , 0, 0
                , 0, 0};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Count is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00265() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe9, 0x03
                , 0, 0};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Count is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00266() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x11, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Repetition Time is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00267() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{(byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00268() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{(byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00269() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Minimum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00270() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Minimum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00271() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Maximum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00272() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Maximum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00273() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Slave Latency is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00274() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Slave Latency is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00275() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Supervision Timeout multiplier is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00276() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Supervision Timeout multiplier is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00277() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00278() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00279() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Count is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00280() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Count is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00281() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Repetition Time is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00282() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{0, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , (byte) ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED, (byte) (ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED >> 8)};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[16];
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Repetition Time is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00283() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00284() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{2, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Reconnection Timeout is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00285() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x7f, 0x0c
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Minimum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00286() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x81, 0x0c
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Minimum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00287() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7e, 0x0c
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Maximum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00288() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x80, 0x0c
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Maximum Connection Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00289() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf2, 0x01
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Slave Latency is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00290() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x80, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf4, 0x01
                , 0, 0
                , 0, 0
                , 0, 0
                , 0, 0};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Slave Latency is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00291() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7d, 0x0c
                , 0, 0
                , 0, 0
                , 0, 0};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Supervision Timeout multiplier is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00292() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7f, 0x0c
                , 0, 0
                , 0, 0
                , 0, 0};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Supervision Timeout multiplier is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00293() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , (byte) 0xff, 0x3f
                , 0, 0
                , 0, 0};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00294() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x41
                , 0, 0
                , 0, 0};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Interval is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00295() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe7, 0x03
                , 0, 0};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Count is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00296() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe9, 0x03
                , 0, 0};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Count is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00297() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[12];
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x0f, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Advertisement Repetition Time is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00298() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[]{1, 0, 0, 0
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("White List Timer is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_00299() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[]{4, 0, 0, 0
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("White List Timer is Out of Range", exception.getMessage());
    }

    @Test
    public void test_exception_0029a() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[]{ReconnectionConfigurationControlPoint.WHITE_LIST_DISABLED
                , ReconnectionConfigurationControlPoint.WHITE_LIST_DISABLED >> 8
                , ReconnectionConfigurationControlPoint.WHITE_LIST_DISABLED >> 16
                , ReconnectionConfigurationControlPoint.WHITE_LIST_DISABLED >> 24
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_0029b() {
        int featureFlag = RCFeature.RC_FEATURES_USE_OF_WHITE_LIST_SUPPORTED_TRUE;
        byte[] featureData = new byte[]{(byte) featureFlag
                , (byte) (featureFlag >> 8)
                , (byte) (featureFlag >> 16)};

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[]{(byte) ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 8)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 16)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 24)
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(new RCFeature(RCFeature.E2E_CRC_NOT_SUPPORTED
                            , featureData))
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addRCFeature_00001() {
        RCFeature rcFeature = new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED, (byte) RCFeature.E2E_CRC_NOT_SUPPORTED >> 8, 0, 0, 0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            ReconnectionConfigurationServiceMockCallback callback = new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(rcFeature)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RC_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RC_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(rcFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addRCFeature_00002() {
        RCFeature rcFeature = new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED, (byte) RCFeature.E2E_CRC_NOT_SUPPORTED >> 8, 0, 0, 0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            ReconnectionConfigurationServiceMockCallback callback = new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(rcFeature.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RC_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RC_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(rcFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addRCFeature_00003() {
        RCFeature rcFeature = new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED, (byte) RCFeature.E2E_CRC_NOT_SUPPORTED >> 8, 0, 0, 0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            ReconnectionConfigurationServiceMockCallback callback = new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(BluetoothGatt.GATT_SUCCESS, 0, rcFeature.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RC_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RC_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(rcFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeRCFeature_00001() {
        RCFeature rcFeature = new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED, (byte) RCFeature.E2E_CRC_NOT_SUPPORTED >> 8, 0, 0, 0});

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(rcFeature)
                    .removeRCFeature()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RC Feature data", exception.getMessage());
    }

    @Test
    public void test_addRCSettings_00001() {
        RCFeature rcFeature = new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED
                , (byte) RCFeature.E2E_CRC_NOT_SUPPORTED >> 8
                , (byte) (RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE)
                , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE) >> 8)
                , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE) >> 16)});

        RCSettings rcSettings = new RCSettings(3
                , RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1
                , 0);
        byte[] rcSettingsDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(rcSettingsDescriptorValue);

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[]{(byte) ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 8)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 16)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 24)
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            ReconnectionConfigurationServiceMockCallback callback = new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(rcFeature)
                    .addRCSettings(rcSettings, clientCharacteristicConfiguration)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RC_SETTINGS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RC_SETTINGS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(rcSettings.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addRCSettings_00002() {
        RCFeature rcFeature = new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED
                , (byte) RCFeature.E2E_CRC_NOT_SUPPORTED >> 8
                , (byte) RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
                , (byte) (RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE >> 8)
                , (byte) (RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE >> 16)});

        RCSettings rcSettings = new RCSettings(3
                , RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1
                , 0);
        byte[] rcSettingsDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(rcSettingsDescriptorValue);

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[]{(byte) ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 8)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 16)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 24)
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            ReconnectionConfigurationServiceMockCallback callback = new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(rcFeature)
                    .addRCSettings(rcSettings, clientCharacteristicConfiguration)
                    .addRCSettings(false
                            , 0
                            , 0
                            , rcSettings.getBytes()
                            , 0
                            , 0
                            , 0
                            , clientCharacteristicConfiguration.getBytes())
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RC_SETTINGS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RC_SETTINGS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(rcSettings.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_addRCSettings_00003() {
        RCFeature rcFeature = new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED
                , (byte) RCFeature.E2E_CRC_NOT_SUPPORTED >> 8
                , (byte) (RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE)
                , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE) >> 8)
                , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE) >> 16)});

        RCSettings rcSettings = new RCSettings(3
                , RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1
                , 0);
        byte[] rcSettingsDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(rcSettingsDescriptorValue);

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[]{(byte) ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 8)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 16)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 24)
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            ReconnectionConfigurationServiceMockCallback callback = new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(rcFeature)
                    .addRCSettings(rcSettings, clientCharacteristicConfiguration)
                    .addRCSettings(true
                            , 0
                            , 0
                            , rcSettings.getBytes()
                            , 0
                            , 0
                            , 0
                            , clientCharacteristicConfiguration.getBytes())
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RC_SETTINGS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RC_SETTINGS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(rcSettings.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeRCSettings_00001() {
        RCFeature rcFeature = new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED
                , (byte) RCFeature.E2E_CRC_NOT_SUPPORTED >> 8
                , (byte) (RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE)
                , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE) >> 8)
                , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE) >> 16)});

        RCSettings rcSettings = new RCSettings(3
                , RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1
                , 0);
        byte[] rcSettingsDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(rcSettingsDescriptorValue);

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[]{(byte) ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 8)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 16)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 24)
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(rcFeature)
                    .addRCSettings(rcSettings, clientCharacteristicConfiguration)
                    .removeRCSettings()
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RC Settings data", exception.getMessage());
    }

    @Test
    public void test_addReconnectionConfigurationControlPoint_00001() {
        RCFeature rcFeature = new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED
                , (byte) RCFeature.E2E_CRC_NOT_SUPPORTED >> 8
                , (byte) (RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE)
                , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE) >> 8)
                , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE) >> 16)});

        RCSettings rcSettings = new RCSettings(3
                , RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1
                , 0);
        byte[] rcSettingsDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(rcSettingsDescriptorValue);

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[]{(byte) ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 8)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 16)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 24)
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            ReconnectionConfigurationServiceMockCallback callback = new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(rcFeature)
                    .addRCSettings(rcSettings, clientCharacteristicConfiguration)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0,
                currentSetting).getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(descriptorValue, bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeReconnectionConfigurationControlPoint_00001() {
        RCFeature rcFeature = new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED
                , (byte) RCFeature.E2E_CRC_NOT_SUPPORTED >> 8
                , (byte) (RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE)
                , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE) >> 8)
                , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE) >> 16)});

        RCSettings rcSettings = new RCSettings(3
                , RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1
                , 0);
        byte[] rcSettingsDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(rcSettingsDescriptorValue);

        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 0;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[]{(byte) ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 8)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 16)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 24)
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new ReconnectionConfigurationServiceMockCallback.Builder<>()
                    .addRCFeature(rcFeature)
                    .addRCSettings(rcSettings, clientCharacteristicConfiguration)
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
                            , characteristicDelay
                            , descriptorResponseCode
                            , descriptorDelay
                            , descriptorValue
                            , enableDisconnectResultCodes
                            , getActualCommunicationParametersResultCodes
                            , proposeSettingsResultCodes
                            , proposeSettingsError
                            , activateStoredSettingsResultCodes
                            , getMaxValuesResultCodes
                            , maxValues
                            , getMinValuesResultCodes
                            , minValues
                            , getStoredValuesResultCodes
                            , getStoredValuesOperand
                            , setWhiteListTimerResultCodes
                            , getWhiteListTimerResultCodes
                            , getWhiteListTimerOperand
                            , setAdvertisementConfigurationResultCodes
                            , upgradeToLescOnlyResultCodes
                            , switchOobPairingResultCodes
                            , limitedAccessResultCodes
                            , currentSetting
                            , isRcFeaturesE2eCrcSupported)
                    .removeReconnectionConfigurationControlPoint()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Reconnection Configuration Control Point data", exception.getMessage());
    }

}
