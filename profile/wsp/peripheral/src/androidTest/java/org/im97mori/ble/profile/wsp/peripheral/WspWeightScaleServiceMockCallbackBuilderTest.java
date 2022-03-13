package org.im97mori.ble.profile.wsp.peripheral;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.bluetooth.BluetoothGattDescriptor;

import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a9d.WeightMeasurement;
import org.im97mori.ble.characteristic.u2a9e.WeightScaleFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback;
import org.junit.Test;

public class WspWeightScaleServiceMockCallbackBuilderTest {

    @Test
    public void test_setUserDataServiceMockCallback_00001() {
        Exception exception = null;
        try {
            new WspWeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(new WeightScaleFeature(false
                            , false
                            , false
                            , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                            , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED))
                    .addWeightMeasurement(new WeightMeasurement(new byte[3]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no UserDataServiceMockCallback instance", exception.getMessage());
    }

    @Test
    public void test_setUserDataServiceMockCallback_00002() {
        Exception exception = null;
        try {
            new WspWeightScaleServiceMockCallback.Builder<>()
                    .setUserDataServiceMockCallback(new UserDataServiceMockCallback(new ServiceData(), false))
                    .addWeightScaleFeature(new WeightScaleFeature(false
                            , false
                            , false
                            , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                            , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED))
                    .addWeightMeasurement(new WeightMeasurement(new byte[3]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeUserDataServiceMockCallback_00001() {
        Exception exception = null;
        try {
            new WspWeightScaleServiceMockCallback.Builder<>()
                    .setUserDataServiceMockCallback(new UserDataServiceMockCallback(new ServiceData(), false))
                    .removeUserDataServiceMockCallback()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no UserDataServiceMockCallback instance", exception.getMessage());
    }

}
