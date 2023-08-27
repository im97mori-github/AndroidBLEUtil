package org.im97mori.ble.profile.lnp.peripheral;

import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2a19.BatteryLevel;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a67.LocationAndSpeed;
import org.im97mori.ble.characteristic.u2a68.Navigation;
import org.im97mori.ble.characteristic.u2a69.PositionQuality;
import org.im97mori.ble.characteristic.u2a6a.LNFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormat;
import org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class LocationAndNavigationProfileMockCallbackBuilderTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(deviceInformationServiceMockCallbackBuilder, baseBuilder.mDeviceInformationServiceMockCallbackBuilder);
        assertEquals(batteryServiceMockCallbackBuilder, baseBuilder.mBatteryServiceMockCallbackBuilder);
        assertEquals(locationAndNavigationServiceMockCallbackBuilder, baseBuilder.mLocationAndNavigationServiceMockCallbackBuilder);
    }

    @Test
    public void test_addLNFeature_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final LNFeature lnFeature = new LNFeature(new byte[]{0, 0, 0, 0});

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback>() {
            @NonNull
            @Override
            public LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> addLNFeature(int ResponseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(lnFeature.getBytes(), value);
                atomicBoolean.set(true);
                return super.addLNFeature(ResponseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addLNFeature(lnFeature));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addLNFeature_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final LNFeature lnFeature = new LNFeature(new byte[]{0, 0, 0, 0});

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback>() {
            @NonNull
            @Override
            public LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> addLNFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(lnFeature.getBytes(), value);
                atomicBoolean.set(true);
                return super.addLNFeature(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addLNFeature(originalResponseCode, originalDelay, lnFeature.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeLNFeature_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback>() {

            @NonNull
            @Override
            public LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> removeLNFeature() {
                atomicBoolean.set(true);
                return super.removeLNFeature();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeLNFeature());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addLocationAndSpeed_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[]{0, 0});
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback>() {

            @NonNull
            @Override
            public LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> addLocationAndSpeed(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(locationAndSpeed.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addLocationAndSpeed(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addLocationAndSpeed(locationAndSpeed, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addLocationAndSpeed_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[]{0, 0});
        final int originalNotificationCount = 3;
        final int originalDescriptorResponseCode = 4;
        final long originalDescriptorDelay = 5;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback>() {

            @NonNull
            @Override
            public LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> addLocationAndSpeed(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertArrayEquals(locationAndSpeed.getBytes(), characteristicValue);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addLocationAndSpeed(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addLocationAndSpeed(originalCharacteristicResponseCode, originalCharacteristicDelay, locationAndSpeed.getBytes(), originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, clientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeLocationAndSpeed_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback>() {

            @NonNull
            @Override
            public LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> removeLocationAndSpeed() {
                atomicBoolean.set(true);
                return super.removeLocationAndSpeed();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeLocationAndSpeed());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addPositionQuality_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final PositionQuality positionQuality = new PositionQuality(new byte[]{0, 0});

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback>() {

            @NonNull
            @Override
            public LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> addPositionQuality(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(positionQuality.getBytes(), value);
                atomicBoolean.set(true);
                return super.addPositionQuality(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addPositionQuality(positionQuality));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addPositionQuality_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final PositionQuality positionQuality = new PositionQuality(new byte[]{0, 0});
        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback>() {

            @NonNull
            @Override
            public LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> addPositionQuality(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(positionQuality.getBytes(), value);
                atomicBoolean.set(true);
                return super.addPositionQuality(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addPositionQuality(originalResponseCode, originalDelay, positionQuality.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removePositionQuality_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback>() {

            @NonNull
            @Override
            public LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> removePositionQuality() {
                atomicBoolean.set(true);
                return super.removePositionQuality();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removePositionQuality());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addLNControlPoint_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicResponseCode = 0;
        final long originalCharacteristicDelay = 1;
        final int originalSetCumulativeValueResponseValue = 4;
        final int originalMaskLocationAndSpeedCharacteristicContentResponseValue = 5;
        final int originalNavigationControlResponseValue = 6;
        final int originalRequestNumberOfRoutesResponseValue = 7;
        final @NonNull byte[] originalRequestNumberOfRoutesResponseParameter = new byte[]{8};
        final int originalRequestNameOfRouteResponseValue = 9;
        final @NonNull byte[] originalRequestNameOfRouteResponseParameter = new byte[]{10};
        final int originalSelectRouteResponseValue = 11;
        final int originalSetFixRateResponseValue = 12;
        final int originalSetElevationResponseValue = 13;
        final int originalDescriptorResponseCode = 14;
        final long originalDescriptorDelay = 15;
        final @NonNull byte[] originalDescriptorValue = new byte[]{16};
        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback>() {

            @NonNull
            @Override
            public LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> addLNControlPoint(int characteristicResponseCode, long characteristicDelay, int setCumulativeValueResponseValue, int maskLocationAndSpeedCharacteristicContentResponseValue, int navigationControlResponseValue, int requestNumberOfRoutesResponseValue, @NonNull byte[] requestNumberOfRoutesResponseParameter, int requestNameOfRouteResponseValue, @NonNull byte[] requestNameOfRouteResponseParameter, int selectRouteResponseValue, int setFixRateResponseValue, int setElevationResponseValue, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalSetCumulativeValueResponseValue, setCumulativeValueResponseValue);
                assertEquals(originalMaskLocationAndSpeedCharacteristicContentResponseValue, maskLocationAndSpeedCharacteristicContentResponseValue);
                assertEquals(originalNavigationControlResponseValue, navigationControlResponseValue);
                assertEquals(originalRequestNumberOfRoutesResponseValue, requestNumberOfRoutesResponseValue);
                assertArrayEquals(originalRequestNumberOfRoutesResponseParameter, requestNumberOfRoutesResponseParameter);
                assertEquals(originalRequestNameOfRouteResponseValue, requestNameOfRouteResponseValue);
                assertArrayEquals(originalRequestNameOfRouteResponseParameter, requestNameOfRouteResponseParameter);
                assertEquals(originalSelectRouteResponseValue, selectRouteResponseValue);
                assertEquals(originalSetFixRateResponseValue, setFixRateResponseValue);
                assertEquals(originalSetElevationResponseValue, setElevationResponseValue);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addLNControlPoint(characteristicResponseCode, characteristicDelay, setCumulativeValueResponseValue, maskLocationAndSpeedCharacteristicContentResponseValue, navigationControlResponseValue, requestNumberOfRoutesResponseValue, requestNumberOfRoutesResponseParameter, requestNameOfRouteResponseValue, requestNameOfRouteResponseParameter, selectRouteResponseValue, setFixRateResponseValue, setElevationResponseValue, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addLNControlPoint(originalCharacteristicResponseCode
                , originalCharacteristicDelay
                , originalSetCumulativeValueResponseValue
                , originalMaskLocationAndSpeedCharacteristicContentResponseValue
                , originalNavigationControlResponseValue
                , originalRequestNumberOfRoutesResponseValue
                , originalRequestNumberOfRoutesResponseParameter
                , originalRequestNameOfRouteResponseValue
                , originalRequestNameOfRouteResponseParameter
                , originalSelectRouteResponseValue
                , originalSetFixRateResponseValue
                , originalSetElevationResponseValue
                , originalDescriptorResponseCode
                , originalDescriptorDelay
                , originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeLNControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback>() {

            @NonNull
            @Override
            public LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> removeLNControlPoint() {
                atomicBoolean.set(true);
                return super.removeLNControlPoint();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeLNControlPoint());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addNavigation_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Navigation navigation = new Navigation(new byte[]{0, 0, 0, 0, 0, 0});
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback>() {

            @NonNull
            @Override
            public LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> addNavigation(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(navigation.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addNavigation(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addNavigation(navigation, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addNavigation_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final Navigation navigation = new Navigation(new byte[]{0, 0, 0, 0, 0, 0});
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        final int originalNotificationCount = 3;
        final int originalDescriptorResponseCode = 4;
        final long originalDescriptorDelay = 5;

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback>() {

            @NonNull
            @Override
            public LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> addNavigation(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertArrayEquals(navigation.getBytes(), characteristicValue);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addNavigation(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addNavigation(originalCharacteristicResponseCode, originalCharacteristicDelay, navigation.getBytes(), originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, clientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeNavigation_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback>() {

            @NonNull
            @Override
            public LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> removeNavigation() {
                atomicBoolean.set(true);
                return super.removeNavigation();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeNavigation());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(manufacturerName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(manufacturerName));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";
        ManufacturerNameString manufacturerNameString = new ManufacturerNameString(manufacturerName);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(manufacturerName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(manufacturerNameString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, null, batteryServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addManufacturerNameString(originalResponseCode, originalDelay, originalValue);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeManufacturerNameString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {

            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeManufacturerNameString() {
                atomicBoolean.set(true);
                return super.removeManufacturerNameString();
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeManufacturerNameString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeManufacturerNameString_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, null, batteryServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.removeManufacturerNameString();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addModelNumberString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String modelNumber = "modelNumber";

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(modelNumber.getBytes(), value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(modelNumber));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String modelNumber = "modelNumber";
        ModelNumberString modelNumberString = new ModelNumberString(modelNumber);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(modelNumber.getBytes(), value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(modelNumberString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = "modelNumber".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "modelNumber".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "modelNumber".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, null, batteryServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addModelNumberString(originalResponseCode, originalDelay, originalValue);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeModelNumberString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {

            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeModelNumberString() {
                atomicBoolean.set(true);
                return super.removeModelNumberString();
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeModelNumberString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeModelNumberString_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, null, batteryServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.removeModelNumberString();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addBatteryLevel_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final BatteryLevel batteryLevel = new BatteryLevel(1);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> addBatteryLevel(int index, int property, int responseCode, long delay, @NonNull byte[] value, int notificationCount) {
                assertEquals(originalIndex, index);
                assertArrayEquals(batteryLevel.getBytes(), value);
                atomicBoolean.set(true);
                return super.addBatteryLevel(index, property, responseCode, delay, value, notificationCount);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addBatteryLevel(originalIndex, batteryLevel));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addBatteryLevel_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalProperty = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final BatteryLevel batteryLevel = new BatteryLevel(4);
        final int originalNotificationCount = 5;

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> addBatteryLevel(int index, int property, int responseCode, long delay, @NonNull byte[] value, int notificationCount) {
                assertEquals(originalIndex, index);
                assertEquals(originalProperty, property);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(batteryLevel.getBytes(), value);
                assertEquals(originalNotificationCount, notificationCount);
                atomicBoolean.set(true);
                return super.addBatteryLevel(index, property, responseCode, delay, value, notificationCount);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addBatteryLevel(originalIndex, originalProperty, originalResponseCode, originalDelay, batteryLevel.getBytes(), originalNotificationCount));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addBatteryLevel_00101() {
        final int originalIndex = 0;
        final int originalProperty = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final BatteryLevel batteryLevel = new BatteryLevel(4);
        final int originalNotificationCount = 5;

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            baseBuilder.addBatteryLevel(originalIndex, originalProperty, originalResponseCode, originalDelay, batteryLevel.getBytes(), originalNotificationCount);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeBatteryLevel_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> removeBatteryLevel(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeBatteryLevel(index);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeBatteryLevel(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBatteryLevel_00101() {
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            baseBuilder.removeBatteryLevel(originalIndex);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_setBatteryLevelCharacteristicPresentationFormat_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(new byte[]{1, 2, 3, 4, 5, 6, 7});

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> setBatteryLevelCharacteristicPresentationFormat(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(characteristicPresentationFormat.getBytes(), value);
                atomicBoolean.set(true);
                return super.setBatteryLevelCharacteristicPresentationFormat(index, responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setBatteryLevelCharacteristicPresentationFormat(originalIndex, characteristicPresentationFormat));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setBatteryLevelCharacteristicPresentationFormat_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(new byte[]{3, 4, 5, 6, 7, 8, 9});

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> setBatteryLevelCharacteristicPresentationFormat(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(characteristicPresentationFormat.getBytes(), value);
                atomicBoolean.set(true);
                return super.setBatteryLevelCharacteristicPresentationFormat(index, responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setBatteryLevelCharacteristicPresentationFormat(originalIndex, originalResponseCode, originalDelay, characteristicPresentationFormat.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setBatteryLevelCharacteristicPresentationFormat_00101() {
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(new byte[]{3, 4, 5, 6, 7, 8, 9});

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            baseBuilder.setBatteryLevelCharacteristicPresentationFormat(originalIndex, originalResponseCode, originalDelay, characteristicPresentationFormat.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeBatteryLevelCharacteristicPresentationFormat_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> removeBatteryLevelCharacteristicPresentationFormat(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeBatteryLevelCharacteristicPresentationFormat(index);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeBatteryLevelCharacteristicPresentationFormat(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBatteryLevelCharacteristicPresentationFormat_00101() {
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            baseBuilder.removeBatteryLevelCharacteristicPresentationFormat(originalIndex);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_setBatteryLevelClientCharacteristicConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> setBatteryLevelClientCharacteristicConfiguration(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), value);
                atomicBoolean.set(true);
                return super.setBatteryLevelClientCharacteristicConfiguration(index, responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setBatteryLevelClientCharacteristicConfiguration(originalIndex, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setBatteryLevelClientCharacteristicConfiguration_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {


            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> setBatteryLevelClientCharacteristicConfiguration(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), value);
                atomicBoolean.set(true);
                return super.setBatteryLevelClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setBatteryLevelClientCharacteristicConfiguration(originalIndex, originalResponseCode, originalDelay, clientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setBatteryLevelClientCharacteristicConfiguration_00101() {
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            baseBuilder.setBatteryLevelClientCharacteristicConfiguration(originalIndex, originalResponseCode, originalDelay, clientCharacteristicConfiguration.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeBatteryLevelClientCharacteristicConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> removeBatteryLevelClientCharacteristicConfiguration(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeBatteryLevelClientCharacteristicConfiguration(index);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeBatteryLevelClientCharacteristicConfiguration(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBatteryLevelClientCharacteristicConfiguration_00101() {
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        LocationAndNavigationServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder = new LocationAndNavigationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            baseBuilder.removeBatteryLevelClientCharacteristicConfiguration(originalIndex);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00001() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new LocationAndNavigationServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>()
                    , new BatteryServiceMockCallback.Builder<>())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no LN Feature data", exception.getMessage());
    }

    @Test
    public void test_build_00002() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new LocationAndNavigationServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>()
                    , new BatteryServiceMockCallback.Builder<>())
                    .addLNFeature(new LNFeature(new byte[4]))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Location and Speed data", exception.getMessage());
    }

    @Test
    public void test_build_00003() {
        LocationAndNavigationProfileMockCallback callback = new BaseBuilder(ApplicationProvider.getApplicationContext()
                , new LocationAndNavigationServiceMockCallback.Builder<>()
                , new DeviceInformationServiceMockCallback.Builder<>()
                , new BatteryServiceMockCallback.Builder<>())
                .addLNFeature(new LNFeature(new byte[4]))
                .addLocationAndSpeed(new LocationAndSpeed(new byte[2]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();

        assertNotNull(callback);
    }

}
