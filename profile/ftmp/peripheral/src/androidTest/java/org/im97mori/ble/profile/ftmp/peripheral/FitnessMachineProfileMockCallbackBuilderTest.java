package org.im97mori.ble.profile.ftmp.peripheral;

import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.core.CrossTrainerDataUtils;
import org.im97mori.ble.characteristic.core.IndoorBikeDataUtils;
import org.im97mori.ble.characteristic.core.RowerDataUtils;
import org.im97mori.ble.characteristic.core.StairClimberDataUtils;
import org.im97mori.ble.characteristic.core.StepClimberDataUtils;
import org.im97mori.ble.characteristic.core.TreadmillDataUtils;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8b.FiveZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8d.HeartRateMax;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a91.MaximumRecommendedHeartRate;
import org.im97mori.ble.characteristic.u2a92.RestingHeartRate;
import org.im97mori.ble.characteristic.u2a94.ThreeZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a95.TwoZoneHeartRateLimit;
import org.im97mori.ble.characteristic.u2a96.VO2Max;
import org.im97mori.ble.characteristic.u2a98.Weight;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.characteristic.u2aa2.Language;
import org.im97mori.ble.characteristic.u2acc.FitnessMachineFeature;
import org.im97mori.ble.characteristic.u2acd.TreadmillData;
import org.im97mori.ble.characteristic.u2acd.TreadmillDataAndroid;
import org.im97mori.ble.characteristic.u2acd.TreadmillDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ace.CrossTrainerData;
import org.im97mori.ble.characteristic.u2ace.CrossTrainerDataAndroid;
import org.im97mori.ble.characteristic.u2ace.CrossTrainerDataPacketAndroid;
import org.im97mori.ble.characteristic.u2acf.StepClimberData;
import org.im97mori.ble.characteristic.u2acf.StepClimberDataAndroid;
import org.im97mori.ble.characteristic.u2acf.StepClimberDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ad0.StairClimberData;
import org.im97mori.ble.characteristic.u2ad0.StairClimberDataAndroid;
import org.im97mori.ble.characteristic.u2ad0.StairClimberDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ad1.RowerData;
import org.im97mori.ble.characteristic.u2ad1.RowerDataAndroid;
import org.im97mori.ble.characteristic.u2ad1.RowerDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ad2.IndoorBikeData;
import org.im97mori.ble.characteristic.u2ad2.IndoorBikeDataAndroid;
import org.im97mori.ble.characteristic.u2ad2.IndoorBikeDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ad3.TrainingStatus;
import org.im97mori.ble.characteristic.u2ad4.SupportedSpeedRange;
import org.im97mori.ble.characteristic.u2ad5.SupportedInclinationRange;
import org.im97mori.ble.characteristic.u2ad6.SupportedResistanceLevelRange;
import org.im97mori.ble.characteristic.u2ad7.SupportedHeartRateRange;
import org.im97mori.ble.characteristic.u2ad8.SupportedPowerRange;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback;
import org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class FitnessMachineProfileMockCallbackBuilderTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(fitnessMachineServiceMockCallbackBuilder, baseBuilder.mFitnessMachineServiceMockCallbackBuilder);
        assertEquals(ftmpUserDataServiceMockCallbackBuilder, baseBuilder.mFtmpUserDataServiceMockCallbackBuilder);
        assertEquals(deviceInformationServiceMockCallbackBuilder, baseBuilder.mDeviceInformationServiceMockCallbackBuilder);
    }

    @Test
    public void test_addFitnessMachineFeature_00001() {
        final AtomicBoolean atomicBoolean1 = new AtomicBoolean(false);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        final FitnessMachineFeature fitnessMachineFeature = new FitnessMachineFeature(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addFitnessMachineFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(fitnessMachineFeature.getBytes(), value);
                atomicBoolean1.set(true);
                return super.addFitnessMachineFeature(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {
            @NonNull
            @Override
            public FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> setFitnessMachineFeature(@Nullable byte[] value) {
                assertArrayEquals(fitnessMachineFeature.getBytes(), value);
                atomicBoolean2.set(true);
                return super.setFitnessMachineFeature(value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addFitnessMachineFeature(fitnessMachineFeature));

        assertTrue(atomicBoolean1.get());
        assertTrue(atomicBoolean2.get());
    }

    @Test
    public void test_addFitnessMachineFeature_00002() {
        final AtomicBoolean atomicBoolean1 = new AtomicBoolean(false);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        final FitnessMachineFeature fitnessMachineFeature = new FitnessMachineFeature(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addFitnessMachineFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(fitnessMachineFeature.getBytes(), value);
                atomicBoolean1.set(true);
                return super.addFitnessMachineFeature(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {
            @NonNull
            @Override
            public FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> setFitnessMachineFeature(@Nullable byte[] value) {
                assertArrayEquals(fitnessMachineFeature.getBytes(), value);
                atomicBoolean2.set(true);
                return super.setFitnessMachineFeature(value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addFitnessMachineFeature(fitnessMachineFeature.getBytes()));

        assertTrue(atomicBoolean1.get());
        assertTrue(atomicBoolean2.get());
    }

    @Test
    public void test_addFitnessMachineFeature_00003() {
        final AtomicBoolean atomicBoolean1 = new AtomicBoolean(false);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = new byte[]{3, 4, 5, 6, 7, 8, 9, 10};
        final FitnessMachineFeature fitnessMachineFeature = new FitnessMachineFeature(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addFitnessMachineFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(fitnessMachineFeature.getBytes(), value);
                atomicBoolean1.set(true);
                return super.addFitnessMachineFeature(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {
            @NonNull
            @Override
            public FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> setFitnessMachineFeature(@Nullable byte[] value) {
                assertArrayEquals(fitnessMachineFeature.getBytes(), value);
                atomicBoolean2.set(true);
                return super.setFitnessMachineFeature(value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addFitnessMachineFeature(originalResponseCode, originalDelay, fitnessMachineFeature.getBytes()));

        assertTrue(atomicBoolean1.get());
        assertTrue(atomicBoolean2.get());
    }

    @Test
    public void test_removeFitnessMachineFeature_00001() {
        final AtomicBoolean atomicBoolean1 = new AtomicBoolean(false);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeFitnessMachineFeature() {
                atomicBoolean1.set(true);
                return super.removeFitnessMachineFeature();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {
            @NonNull
            @Override
            public FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> setFitnessMachineFeature(@Nullable byte[] value) {
                assertNull(value);
                atomicBoolean2.set(true);
                return super.setFitnessMachineFeature(value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeFitnessMachineFeature());

        assertTrue(atomicBoolean1.get());
        assertTrue(atomicBoolean2.get());
    }

    @Test
    public void test_removeFitnessMachineFeature_00101() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeFitnessMachineFeature() {
                atomicBoolean.set(true);
                return super.removeFitnessMachineFeature();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeFitnessMachineFeature());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTreadmillData_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{TreadmillDataUtils.FLAGS_MORE_DATA_TRUE, TreadmillDataUtils.FLAGS_MORE_DATA_TRUE >> 8};
        final TreadmillData treadmillData = TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(originalValue)});

        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(originalDescriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addTreadmillData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(originalValue, characteristicValue);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addTreadmillData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTreadmillData(treadmillData, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTreadmillData_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalValue = new byte[2];
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final int originalNotificationCount = 3;
        final int originalDescriptorResponseCode = 4;
        final long originalDescriptorDelay = 5;

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addTreadmillData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertArrayEquals(originalValue, characteristicValue);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addTreadmillData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTreadmillData(originalCharacteristicResponseCode, originalCharacteristicDelay, originalValue, originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeTreadmillData_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {

            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeTreadmillData() {
                atomicBoolean.set(true);
                return super.removeTreadmillData();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeTreadmillData());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addCrossTrainerData_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE, CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE >> 8, CrossTrainerDataUtils.FLAGS_MORE_DATA_TRUE >> 16};
        final CrossTrainerData crossTrainerData = CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(originalValue)});

        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(originalDescriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addCrossTrainerData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(originalValue, characteristicValue);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addCrossTrainerData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCrossTrainerData(crossTrainerData, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addCrossTrainerData_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalValue = new byte[3];
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final int originalNotificationCount = 3;
        final int originalDescriptorResponseCode = 4;
        final long originalDescriptorDelay = 5;

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addCrossTrainerData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertArrayEquals(originalValue, characteristicValue);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addCrossTrainerData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCrossTrainerData(originalCharacteristicResponseCode, originalCharacteristicDelay, originalValue, originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeCrossTrainerData_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {

            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeCrossTrainerData() {
                atomicBoolean.set(true);
                return super.removeCrossTrainerData();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeCrossTrainerData());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addStepClimberData_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{StepClimberDataUtils.FLAGS_MORE_DATA_TRUE, StepClimberDataUtils.FLAGS_MORE_DATA_TRUE >> 8};
        final StepClimberData stepClimberData = StepClimberDataAndroid.CREATOR.createFromMultiplePacketArray(new StepClimberDataPacketAndroid[]{StepClimberDataPacketAndroid.CREATOR.createFromByteArray(originalValue)});

        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(originalDescriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addStepClimberData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(originalValue, characteristicValue);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addStepClimberData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addStepClimberData(stepClimberData, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addStepClimberData_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalValue = new byte[2];
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final int originalNotificationCount = 3;
        final int originalDescriptorResponseCode = 4;
        final long originalDescriptorDelay = 5;

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addStepClimberData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertArrayEquals(originalValue, characteristicValue);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addStepClimberData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addStepClimberData(originalCharacteristicResponseCode, originalCharacteristicDelay, originalValue, originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeStepClimberData_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {

            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeStepClimberData() {
                atomicBoolean.set(true);
                return super.removeStepClimberData();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeStepClimberData());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addStairClimberData_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{StairClimberDataUtils.FLAGS_MORE_DATA_TRUE, StairClimberDataUtils.FLAGS_MORE_DATA_TRUE >> 8};
        final StairClimberData stepClimberData = StairClimberDataAndroid.CREATOR.createFromMultiplePacketArray(new StairClimberDataPacketAndroid[]{StairClimberDataPacketAndroid.CREATOR.createFromByteArray(originalValue)});

        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(originalDescriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addStairClimberData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(originalValue, characteristicValue);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addStairClimberData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addStairClimberData(stepClimberData, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addStairClimberData_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalValue = new byte[2];
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final int originalNotificationCount = 3;
        final int originalDescriptorResponseCode = 4;
        final long originalDescriptorDelay = 5;

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addStairClimberData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertArrayEquals(originalValue, characteristicValue);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addStairClimberData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addStairClimberData(originalCharacteristicResponseCode, originalCharacteristicDelay, originalValue, originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeStairClimberData_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {

            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeStairClimberData() {
                atomicBoolean.set(true);
                return super.removeStairClimberData();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeStairClimberData());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addRowerData_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{RowerDataUtils.FLAGS_MORE_DATA_TRUE, RowerDataUtils.FLAGS_MORE_DATA_TRUE >> 8};
        final RowerData rowerData = RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(originalValue)});

        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(originalDescriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addRowerData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(originalValue, characteristicValue);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addRowerData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRowerData(rowerData, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addRowerData_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalValue = new byte[2];
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final int originalNotificationCount = 3;
        final int originalDescriptorResponseCode = 4;
        final long originalDescriptorDelay = 5;

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addRowerData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertArrayEquals(originalValue, characteristicValue);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addRowerData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRowerData(originalCharacteristicResponseCode, originalCharacteristicDelay, originalValue, originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeRowerData_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {

            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeRowerData() {
                atomicBoolean.set(true);
                return super.removeRowerData();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeRowerData());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addIndoorBikeData_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE, IndoorBikeDataUtils.FLAGS_MORE_DATA_TRUE >> 8};
        final IndoorBikeData rowerData = IndoorBikeDataAndroid.CREATOR.createFromMultiplePacketArray(new IndoorBikeDataPacketAndroid[]{IndoorBikeDataPacketAndroid.CREATOR.createFromByteArray(originalValue)});

        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(originalDescriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addIndoorBikeData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(originalValue, characteristicValue);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addIndoorBikeData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addIndoorBikeData(rowerData, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addIndoorBikeData_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalValue = new byte[2];
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final int originalNotificationCount = 3;
        final int originalDescriptorResponseCode = 4;
        final long originalDescriptorDelay = 5;

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addIndoorBikeData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertArrayEquals(originalValue, characteristicValue);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addIndoorBikeData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addIndoorBikeData(originalCharacteristicResponseCode, originalCharacteristicDelay, originalValue, originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeIndoorBikeData_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {

            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeIndoorBikeData() {
                atomicBoolean.set(true);
                return super.removeIndoorBikeData();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeIndoorBikeData());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTrainingStatus_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[2];
        final TrainingStatus rowerData = new TrainingStatus(originalValue);

        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(originalDescriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addTrainingStatus(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(originalValue, characteristicValue);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addTrainingStatus(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTrainingStatus(rowerData, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTrainingStatus_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalValue = new byte[2];
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final int originalNotificationCount = 3;
        final int originalDescriptorResponseCode = 4;
        final long originalDescriptorDelay = 5;

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addTrainingStatus(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertArrayEquals(originalValue, characteristicValue);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addTrainingStatus(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTrainingStatus(originalCharacteristicResponseCode, originalCharacteristicDelay, originalValue, originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeTrainingStatus_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {

            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeTrainingStatus() {
                atomicBoolean.set(true);
                return super.removeTrainingStatus();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeTrainingStatus());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedSpeedRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2, 3, 4, 5, 6};
        final SupportedSpeedRange supportedSpeedRange = new SupportedSpeedRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedSpeedRange(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(supportedSpeedRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedSpeedRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedSpeedRange(supportedSpeedRange));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedSpeedRange_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2, 3, 4, 5, 6};
        final SupportedSpeedRange supportedSpeedRange = new SupportedSpeedRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedSpeedRange(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(supportedSpeedRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedSpeedRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedSpeedRange(supportedSpeedRange.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedSpeedRange_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = new byte[]{3, 4, 5, 6, 7, 8};
        final SupportedSpeedRange supportedSpeedRange = new SupportedSpeedRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedSpeedRange(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(supportedSpeedRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedSpeedRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedSpeedRange(originalResponseCode, originalDelay, supportedSpeedRange.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeSupportedSpeedRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeSupportedSpeedRange() {
                atomicBoolean.set(true);
                return super.removeSupportedSpeedRange();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeSupportedSpeedRange());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedInclinationRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2, 3, 4, 5, 6};
        final SupportedInclinationRange supportedInclinationRange = new SupportedInclinationRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedInclinationRange(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(supportedInclinationRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedInclinationRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedInclinationRange(supportedInclinationRange));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedInclinationRange_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2, 3, 4, 5, 6};
        final SupportedInclinationRange supportedInclinationRange = new SupportedInclinationRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedInclinationRange(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(supportedInclinationRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedInclinationRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedInclinationRange(supportedInclinationRange.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedInclinationRange_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = new byte[]{3, 4, 5, 6, 7, 8};
        final SupportedInclinationRange supportedInclinationRange = new SupportedInclinationRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedInclinationRange(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(supportedInclinationRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedInclinationRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedInclinationRange(originalResponseCode, originalDelay, supportedInclinationRange.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeSupportedInclinationRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeSupportedInclinationRange() {
                atomicBoolean.set(true);
                return super.removeSupportedInclinationRange();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeSupportedInclinationRange());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedResistanceLevelRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2, 3, 4, 5, 6};
        final SupportedResistanceLevelRange supportedResistanceLevelRange = new SupportedResistanceLevelRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedResistanceLevelRange(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(supportedResistanceLevelRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedResistanceLevelRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedResistanceLevelRange(supportedResistanceLevelRange));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedResistanceLevelRange_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2, 3, 4, 5, 6};
        final SupportedResistanceLevelRange supportedResistanceLevelRange = new SupportedResistanceLevelRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedResistanceLevelRange(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(supportedResistanceLevelRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedResistanceLevelRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedResistanceLevelRange(supportedResistanceLevelRange.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedResistanceLevelRange_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = new byte[]{3, 4, 5, 6, 7, 8};
        final SupportedResistanceLevelRange supportedResistanceLevelRange = new SupportedResistanceLevelRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedResistanceLevelRange(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(supportedResistanceLevelRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedResistanceLevelRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedResistanceLevelRange(originalResponseCode, originalDelay, supportedResistanceLevelRange.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeSupportedResistanceLevelRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeSupportedResistanceLevelRange() {
                atomicBoolean.set(true);
                return super.removeSupportedResistanceLevelRange();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeSupportedResistanceLevelRange());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedPowerRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2, 3, 4, 5, 6};
        final SupportedPowerRange supportedPowerRange = new SupportedPowerRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedPowerRange(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(supportedPowerRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedPowerRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedPowerRange(supportedPowerRange));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedPowerRange_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2, 3, 4, 5, 6};
        final SupportedPowerRange supportedPowerRange = new SupportedPowerRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedPowerRange(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(supportedPowerRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedPowerRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedPowerRange(supportedPowerRange.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedPowerRange_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = new byte[]{3, 4, 5, 6, 7, 8};
        final SupportedPowerRange supportedPowerRange = new SupportedPowerRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedPowerRange(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(supportedPowerRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedPowerRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedPowerRange(originalResponseCode, originalDelay, supportedPowerRange.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeSupportedPowerRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeSupportedPowerRange() {
                atomicBoolean.set(true);
                return super.removeSupportedPowerRange();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeSupportedPowerRange());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedHeartRateRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2, 3};
        final SupportedHeartRateRange supportedHeartRateRange = new SupportedHeartRateRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedHeartRateRange(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(supportedHeartRateRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedHeartRateRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedHeartRateRange(supportedHeartRateRange));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedHeartRateRange_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2, 3};
        final SupportedHeartRateRange supportedHeartRateRange = new SupportedHeartRateRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedHeartRateRange(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(supportedHeartRateRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedHeartRateRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedHeartRateRange(supportedHeartRateRange.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedHeartRateRange_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = new byte[]{3, 4, 5};
        final SupportedHeartRateRange supportedHeartRateRange = new SupportedHeartRateRange(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addSupportedHeartRateRange(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(supportedHeartRateRange.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedHeartRateRange(responseCode, delay, value);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedHeartRateRange(originalResponseCode, originalDelay, supportedHeartRateRange.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeSupportedHeartRateRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeSupportedHeartRateRange() {
                atomicBoolean.set(true);
                return super.removeSupportedHeartRateRange();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeSupportedHeartRateRange());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addFitnessMachineControlPoint_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final long originalCharacteristicDelay = 1;
        final int originalDescriptorResponseCode = 2;
        final long originalDescriptorDelay = 3;
        final @NonNull byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final int originalRequestControlResultCode = 4;
        final int originalResetResultCode = 5;
        final int originalSetTargetSpeedResultCode = 6;
        final int originalSetTargetInclinationResultCode = 7;
        final int originalSetTargetResistanceLevelResultCode = 8;
        final int originalSetTargetPowerResultCode = 9;
        final int originalSetTargetHeartRateResultCode = 10;
        final int originalStartOrResumeResultCode = 11;
        final int originalStopOrPauseResultCode = 12;
        final int originalSetTargetedExpendedEnergyResultCode = 13;
        final int originalSetTargetedNumberOfStepsResultCode = 14;
        final int originalSetTargetedNumberOfStridesResultCode = 15;
        final int originalSetTargetedDistanceResultCode = 16;
        final int originalSetTargetedTrainingTimeResultCode = 17;
        final int originalSetTargetedTimeInTwoHeartRateZonesResultCode = 18;
        final int originalSetTargetedTimeInThreeHeartRateZonesResultCode = 19;
        final int originalSetTargetedTimeInFiveHeartRateZonesResultCode = 20;
        final int originalSetIndoorBikeSimulationParametersResultCode = 21;
        final int originalSetWheelCircumferenceResultCode = 22;
        final int originalSpinDownControlResultCode = 23;
        final @NonNull byte[] originalSpinDownControlResultParameter = new byte[]{24};
        final int originalSetTargetedCadenceResultCode = 25;

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {

            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addFitnessMachineControlPoint(long characteristicDelay
                    , int descriptorResponseCode
                    , long descriptorDelay
                    , @NonNull byte[] descriptorValue
                    , int requestControlResultCode
                    , int resetResultCode
                    , int setTargetSpeedResultCode
                    , int setTargetInclinationResultCode
                    , int setTargetResistanceLevelResultCode
                    , int setTargetPowerResultCode
                    , int setTargetHeartRateResultCode
                    , int startOrResumeResultCode
                    , int stopOrPauseResultCode
                    , int setTargetedExpendedEnergyResultCode
                    , int setTargetedNumberOfStepsResultCode
                    , int setTargetedNumberOfStridesResultCode
                    , int setTargetedDistanceResultCode
                    , int setTargetedTrainingTimeResultCode
                    , int setTargetedTimeInTwoHeartRateZonesResultCode
                    , int setTargetedTimeInThreeHeartRateZonesResultCode
                    , int setTargetedTimeInFiveHeartRateZonesResultCode
                    , int setIndoorBikeSimulationParametersResultCode
                    , int setWheelCircumferenceResultCode
                    , int spinDownControlResultCode
                    , @NonNull byte[] spinDownControlResultParameter
                    , int setTargetedCadenceResultCode) {
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(descriptorValue, descriptorValue);
                assertEquals(originalRequestControlResultCode, requestControlResultCode);
                assertEquals(originalResetResultCode, resetResultCode);
                assertEquals(originalSetTargetSpeedResultCode, setTargetSpeedResultCode);
                assertEquals(originalSetTargetInclinationResultCode, setTargetInclinationResultCode);
                assertEquals(originalSetTargetResistanceLevelResultCode, setTargetResistanceLevelResultCode);
                assertEquals(originalSetTargetPowerResultCode, setTargetPowerResultCode);
                assertEquals(originalSetTargetHeartRateResultCode, setTargetHeartRateResultCode);
                assertEquals(originalStartOrResumeResultCode, startOrResumeResultCode);
                assertEquals(originalStopOrPauseResultCode, stopOrPauseResultCode);
                assertEquals(originalSetTargetedExpendedEnergyResultCode, setTargetedExpendedEnergyResultCode);
                assertEquals(originalSetTargetedNumberOfStepsResultCode, setTargetedNumberOfStepsResultCode);
                assertEquals(originalSetTargetedNumberOfStridesResultCode, setTargetedNumberOfStridesResultCode);
                assertEquals(originalSetTargetedDistanceResultCode, setTargetedDistanceResultCode);
                assertEquals(originalSetTargetedTrainingTimeResultCode, setTargetedTrainingTimeResultCode);
                assertEquals(originalSetTargetedTimeInTwoHeartRateZonesResultCode, setTargetedTimeInTwoHeartRateZonesResultCode);
                assertEquals(originalSetTargetedTimeInThreeHeartRateZonesResultCode, setTargetedTimeInThreeHeartRateZonesResultCode);
                assertEquals(originalSetTargetedTimeInFiveHeartRateZonesResultCode, setTargetedTimeInFiveHeartRateZonesResultCode);
                assertEquals(originalSetIndoorBikeSimulationParametersResultCode, setIndoorBikeSimulationParametersResultCode);
                assertEquals(originalSetWheelCircumferenceResultCode, setWheelCircumferenceResultCode);
                assertEquals(originalSpinDownControlResultCode, spinDownControlResultCode);
                assertArrayEquals(originalSpinDownControlResultParameter, spinDownControlResultParameter);
                assertEquals(originalSetTargetedCadenceResultCode, setTargetedCadenceResultCode);
                atomicBoolean.set(true);
                return super.addFitnessMachineControlPoint(characteristicDelay, descriptorResponseCode, descriptorDelay, descriptorValue, requestControlResultCode, resetResultCode, setTargetSpeedResultCode, setTargetInclinationResultCode, setTargetResistanceLevelResultCode, setTargetPowerResultCode, setTargetHeartRateResultCode, startOrResumeResultCode, stopOrPauseResultCode, setTargetedExpendedEnergyResultCode, setTargetedNumberOfStepsResultCode, setTargetedNumberOfStridesResultCode, setTargetedDistanceResultCode, setTargetedTrainingTimeResultCode, setTargetedTimeInTwoHeartRateZonesResultCode, setTargetedTimeInThreeHeartRateZonesResultCode, setTargetedTimeInFiveHeartRateZonesResultCode, setIndoorBikeSimulationParametersResultCode, setWheelCircumferenceResultCode, spinDownControlResultCode, spinDownControlResultParameter, setTargetedCadenceResultCode);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addFitnessMachineControlPoint(originalCharacteristicDelay
                , originalDescriptorResponseCode
                , originalDescriptorDelay
                , descriptorValue
                , originalRequestControlResultCode
                , originalResetResultCode
                , originalSetTargetSpeedResultCode
                , originalSetTargetInclinationResultCode
                , originalSetTargetResistanceLevelResultCode
                , originalSetTargetPowerResultCode
                , originalSetTargetHeartRateResultCode
                , originalStartOrResumeResultCode
                , originalStopOrPauseResultCode
                , originalSetTargetedExpendedEnergyResultCode
                , originalSetTargetedNumberOfStepsResultCode
                , originalSetTargetedNumberOfStridesResultCode
                , originalSetTargetedDistanceResultCode
                , originalSetTargetedTrainingTimeResultCode
                , originalSetTargetedTimeInTwoHeartRateZonesResultCode
                , originalSetTargetedTimeInThreeHeartRateZonesResultCode
                , originalSetTargetedTimeInFiveHeartRateZonesResultCode
                , originalSetIndoorBikeSimulationParametersResultCode
                , originalSetWheelCircumferenceResultCode
                , originalSpinDownControlResultCode
                , originalSpinDownControlResultParameter
                , originalSetTargetedCadenceResultCode
        ));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeFitnessMachineControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeFitnessMachineControlPoint() {
                atomicBoolean.set(true);
                return super.removeFitnessMachineControlPoint();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeFitnessMachineControlPoint());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addFitnessMachineStatus_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);


        final int originalSpinDownStatusValue = 1;
        final int originalDescriptorResponseCode = 2;
        final long originalDescriptorDelay = 3;
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {

            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> addFitnessMachineStatus(int spinDownStatusValue, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalSpinDownStatusValue, spinDownStatusValue);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addFitnessMachineStatus(spinDownStatusValue, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addFitnessMachineStatus(originalSpinDownStatusValue, originalDescriptorResponseCode, originalDescriptorDelay, originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeFitnessMachineStatus_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback>() {
            @NonNull
            @Override
            public FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> removeFitnessMachineStatus() {
                atomicBoolean.set(true);
                return super.removeFitnessMachineStatus();
            }
        };
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeFitnessMachineStatus());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addFirstName_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String firstNameString = "firstNameString";
        final FirstName firstName = new FirstName(firstNameString);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {
            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addFirstName(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(firstName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addFirstName(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addFirstName(firstNameString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addFirstName_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String firstNameString = "firstNameString";
        final FirstName firstName = new FirstName(firstNameString);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {
            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addFirstName(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(firstName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addFirstName(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addFirstName(firstName));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addFirstName_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String firstNameString = "firstNameString";
        final FirstName firstName = new FirstName(firstNameString);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {
            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addFirstName(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(firstName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addFirstName(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addFirstName(firstName.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addFirstName_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final String firstNameString = "firstNameString";
        final FirstName firstName = new FirstName(firstNameString);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {
            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addFirstName(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(firstName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addFirstName(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addFirstName(originalResponseCode, originalDelay, firstName.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addFirstName_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final String firstNameString = "firstNameString";
        final FirstName firstName = new FirstName(firstNameString);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addFirstName(originalResponseCode, originalDelay, firstName.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeFirstName_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeFirstName() {
                atomicBoolean.set(true);
                return super.removeFirstName();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeFirstName());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeFirstName_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        Exception exception = null;
        try {
            baseBuilder.removeFirstName();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addWeight_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final Weight weight = new Weight(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addWeight(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(weight.getBytes(), value);
                atomicBoolean.set(true);
                return super.addWeight(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addWeight(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addWeight_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final Weight weight = new Weight(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addWeight(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(weight.getBytes(), value);
                atomicBoolean.set(true);
                return super.addWeight(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addWeight(weight));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addWeight_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final Weight weight = new Weight(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addWeight(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(weight.getBytes(), value);
                atomicBoolean.set(true);
                return super.addWeight(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addWeight(weight.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addWeight_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final Weight weight = new Weight(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addWeight(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(weight.getBytes(), value);
                atomicBoolean.set(true);
                return super.addWeight(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addWeight(originalResponseCode, originalDelay, weight.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addWeight_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final String firstNameString = "firstNameString";
        final FirstName firstName = new FirstName(firstNameString);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addWeight(originalResponseCode, originalDelay, firstName.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeWeight_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeWeight() {
                atomicBoolean.set(true);
                return super.removeWeight();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeWeight());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeWeight_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        Exception exception = null;
        try {
            baseBuilder.removeWeight();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addGender_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final Gender gender = new Gender(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addGender(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(gender.getBytes(), value);
                atomicBoolean.set(true);
                return super.addGender(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addGender(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addGender_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final Gender gender = new Gender(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addGender(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(gender.getBytes(), value);
                atomicBoolean.set(true);
                return super.addGender(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addGender(gender));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addGender_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final Gender gender = new Gender(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addGender(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(gender.getBytes(), value);
                atomicBoolean.set(true);
                return super.addGender(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addGender(gender.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addGender_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final Gender gender = new Gender(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addGender(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(gender.getBytes(), value);
                atomicBoolean.set(true);
                return super.addGender(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addGender(originalResponseCode, originalDelay, gender.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addGender_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final Gender gender = new Gender(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addGender(originalResponseCode, originalDelay, gender.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeGender_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeGender() {
                atomicBoolean.set(true);
                return super.removeGender();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeGender());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeGender_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        Exception exception = null;
        try {
            baseBuilder.removeGender();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addHeight_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final Height height = new Height(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addHeight(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(height.getBytes(), value);
                atomicBoolean.set(true);
                return super.addHeight(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addHeight(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addHeight_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final Height height = new Height(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addHeight(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(height.getBytes(), value);
                atomicBoolean.set(true);
                return super.addHeight(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addHeight(height));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addHeight_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final Height height = new Height(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addHeight(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(height.getBytes(), value);
                atomicBoolean.set(true);
                return super.addHeight(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addHeight(height.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addHeight_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final Height height = new Height(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addHeight(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(height.getBytes(), value);
                atomicBoolean.set(true);
                return super.addHeight(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addHeight(originalResponseCode, originalDelay, height.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addHeight_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final Height height = new Height(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addHeight(originalResponseCode, originalDelay, height.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeHeight_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeHeight() {
                atomicBoolean.set(true);
                return super.removeHeight();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeHeight());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeHeight_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        Exception exception = null;
        try {
            baseBuilder.removeHeight();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addAge_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final Age age = new Age(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addAge(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(age.getBytes(), value);
                atomicBoolean.set(true);
                return super.addAge(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAge(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAge_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final Age age = new Age(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addAge(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(age.getBytes(), value);
                atomicBoolean.set(true);
                return super.addAge(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAge(age));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAge_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final Age age = new Age(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addAge(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(age.getBytes(), value);
                atomicBoolean.set(true);
                return super.addAge(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAge(age.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAge_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final Age age = new Age(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addAge(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(age.getBytes(), value);
                atomicBoolean.set(true);
                return super.addAge(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAge(originalResponseCode, originalDelay, age.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAge_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final Age age = new Age(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addAge(originalResponseCode, originalDelay, age.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeAge_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeAge() {
                atomicBoolean.set(true);
                return super.removeAge();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeAge());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeAge_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        Exception exception = null;
        try {
            baseBuilder.removeAge();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addDateOfBirth_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalYear = 1;
        final int originalMonth = 2;
        final int originalDay = 3;
        final DateOfBirth dateOfBirth = new DateOfBirth(originalYear, originalMonth, originalDay);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addDateOfBirth(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(dateOfBirth.getBytes(), value);
                atomicBoolean.set(true);
                return super.addDateOfBirth(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDateOfBirth(originalYear, originalMonth, originalDay));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addDateOfBirth_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalYear = 1;
        final int originalMonth = 2;
        final int originalDay = 3;
        final DateOfBirth dateOfBirth = new DateOfBirth(originalYear, originalMonth, originalDay);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addDateOfBirth(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(dateOfBirth.getBytes(), value);
                atomicBoolean.set(true);
                return super.addDateOfBirth(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDateOfBirth(dateOfBirth));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addDateOfBirth_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalYear = 1;
        final int originalMonth = 2;
        final int originalDay = 3;
        final DateOfBirth dateOfBirth = new DateOfBirth(originalYear, originalMonth, originalDay);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addDateOfBirth(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(dateOfBirth.getBytes(), value);
                atomicBoolean.set(true);
                return super.addDateOfBirth(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDateOfBirth(dateOfBirth.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addDateOfBirth_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalYear = 3;
        final int originalMonth = 4;
        final int originalDay = 5;
        final DateOfBirth dateOfBirth = new DateOfBirth(originalYear, originalMonth, originalDay);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addDateOfBirth(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(dateOfBirth.getBytes(), value);
                atomicBoolean.set(true);
                return super.addDateOfBirth(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDateOfBirth(originalResponseCode, originalDelay, dateOfBirth.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addDateOfBirth_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalYear = 3;
        final int originalMonth = 4;
        final int originalDay = 5;
        final DateOfBirth dateOfBirth = new DateOfBirth(originalYear, originalMonth, originalDay);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addDateOfBirth(originalResponseCode, originalDelay, dateOfBirth.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeDateOfBirth_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeDateOfBirth() {
                atomicBoolean.set(true);
                return super.removeDateOfBirth();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeDateOfBirth());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeDateOfBirth_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        Exception exception = null;
        try {
            baseBuilder.removeDateOfBirth();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addHeartRateMax_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final HeartRateMax heartRateMax = new HeartRateMax(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addHeartRateMax(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(heartRateMax.getBytes(), value);
                atomicBoolean.set(true);
                return super.addHeartRateMax(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addHeartRateMax(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addHeartRateMax_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final HeartRateMax heartRateMax = new HeartRateMax(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addHeartRateMax(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(heartRateMax.getBytes(), value);
                atomicBoolean.set(true);
                return super.addHeartRateMax(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addHeartRateMax(heartRateMax));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addHeartRateMax_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final HeartRateMax heartRateMax = new HeartRateMax(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addHeartRateMax(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(heartRateMax.getBytes(), value);
                atomicBoolean.set(true);
                return super.addHeartRateMax(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addHeartRateMax(heartRateMax.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addHeartRateMax_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final HeartRateMax heartRateMax = new HeartRateMax(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addHeartRateMax(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(heartRateMax.getBytes(), value);
                atomicBoolean.set(true);
                return super.addHeartRateMax(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addHeartRateMax(originalResponseCode, originalDelay, heartRateMax.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addHeartRateMax_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final HeartRateMax heartRateMax = new HeartRateMax(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addHeartRateMax(originalResponseCode, originalDelay, heartRateMax.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeHeartRateMax_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeHeartRateMax() {
                atomicBoolean.set(true);
                return super.removeHeartRateMax();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeHeartRateMax());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeHeartRateMax_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        Exception exception = null;
        try {
            baseBuilder.removeHeartRateMax();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addRestingHeartRate_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final RestingHeartRate restingHeartRate = new RestingHeartRate(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addRestingHeartRate(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(restingHeartRate.getBytes(), value);
                atomicBoolean.set(true);
                return super.addRestingHeartRate(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRestingHeartRate(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addRestingHeartRate_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final RestingHeartRate restingHeartRate = new RestingHeartRate(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addRestingHeartRate(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(restingHeartRate.getBytes(), value);
                atomicBoolean.set(true);
                return super.addRestingHeartRate(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRestingHeartRate(restingHeartRate));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addRestingHeartRate_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final RestingHeartRate restingHeartRate = new RestingHeartRate(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addRestingHeartRate(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(restingHeartRate.getBytes(), value);
                atomicBoolean.set(true);
                return super.addRestingHeartRate(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRestingHeartRate(restingHeartRate.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addRestingHeartRate_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final RestingHeartRate restingHeartRate = new RestingHeartRate(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addRestingHeartRate(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(restingHeartRate.getBytes(), value);
                atomicBoolean.set(true);
                return super.addRestingHeartRate(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRestingHeartRate(originalResponseCode, originalDelay, restingHeartRate.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addRestingHeartRate_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final RestingHeartRate restingHeartRate = new RestingHeartRate(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addRestingHeartRate(originalResponseCode, originalDelay, restingHeartRate.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeRestingHeartRate_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeRestingHeartRate() {
                atomicBoolean.set(true);
                return super.removeRestingHeartRate();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeRestingHeartRate());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeRestingHeartRate_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        Exception exception = null;
        try {
            baseBuilder.removeRestingHeartRate();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addMaximumRecommendedHeartRate_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addMaximumRecommendedHeartRate(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(maximumRecommendedHeartRate.getBytes(), value);
                atomicBoolean.set(true);
                return super.addMaximumRecommendedHeartRate(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addMaximumRecommendedHeartRate(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addMaximumRecommendedHeartRate_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addMaximumRecommendedHeartRate(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(maximumRecommendedHeartRate.getBytes(), value);
                atomicBoolean.set(true);
                return super.addMaximumRecommendedHeartRate(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addMaximumRecommendedHeartRate(maximumRecommendedHeartRate));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addMaximumRecommendedHeartRate_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addMaximumRecommendedHeartRate(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(maximumRecommendedHeartRate.getBytes(), value);
                atomicBoolean.set(true);
                return super.addMaximumRecommendedHeartRate(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addMaximumRecommendedHeartRate(maximumRecommendedHeartRate.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addMaximumRecommendedHeartRate_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addMaximumRecommendedHeartRate(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(maximumRecommendedHeartRate.getBytes(), value);
                atomicBoolean.set(true);
                return super.addMaximumRecommendedHeartRate(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addMaximumRecommendedHeartRate(originalResponseCode, originalDelay, maximumRecommendedHeartRate.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addMaximumRecommendedHeartRate_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addMaximumRecommendedHeartRate(originalResponseCode, originalDelay, maximumRecommendedHeartRate.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeMaximumRecommendedHeartRate_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeMaximumRecommendedHeartRate() {
                atomicBoolean.set(true);
                return super.removeMaximumRecommendedHeartRate();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeMaximumRecommendedHeartRate());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeMaximumRecommendedHeartRate_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        Exception exception = null;
        try {
            baseBuilder.removeMaximumRecommendedHeartRate();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addVO2Max_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final VO2Max vo2Max = new VO2Max(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addVO2Max(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(vo2Max.getBytes(), value);
                atomicBoolean.set(true);
                return super.addVO2Max(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addVO2Max(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addVO2Max_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final VO2Max vo2Max = new VO2Max(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addVO2Max(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(vo2Max.getBytes(), value);
                atomicBoolean.set(true);
                return super.addVO2Max(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addVO2Max(vo2Max));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addVO2Max_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final VO2Max vo2Max = new VO2Max(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addVO2Max(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(vo2Max.getBytes(), value);
                atomicBoolean.set(true);
                return super.addVO2Max(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addVO2Max(vo2Max.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addVO2Max_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final VO2Max vo2Max = new VO2Max(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addVO2Max(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(vo2Max.getBytes(), value);
                atomicBoolean.set(true);
                return super.addVO2Max(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addVO2Max(originalResponseCode, originalDelay, vo2Max.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addVO2Max_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final VO2Max vo2Max = new VO2Max(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addVO2Max(originalResponseCode, originalDelay, vo2Max.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeVO2Max_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeVO2Max() {
                atomicBoolean.set(true);
                return super.removeVO2Max();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeVO2Max());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeVO2Max_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        Exception exception = null;
        try {
            baseBuilder.removeVO2Max();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addLanguage_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String languageString = "firstLanguage";
        final Language language = new Language(languageString);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {
            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addLanguage(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(language.getBytes(), value);
                atomicBoolean.set(true);
                return super.addLanguage(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addLanguage(languageString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addLanguage_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String languageString = "firstLanguage";
        final Language language = new Language(languageString);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {
            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addLanguage(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(language.getBytes(), value);
                atomicBoolean.set(true);
                return super.addLanguage(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addLanguage(language));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addLanguage_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String languageString = "firstLanguage";
        final Language language = new Language(languageString);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {
            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addLanguage(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(language.getBytes(), value);
                atomicBoolean.set(true);
                return super.addLanguage(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addLanguage(language.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addLanguage_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final String languageString = "firstLanguage";
        final Language language = new Language(languageString);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {
            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addLanguage(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(language.getBytes(), value);
                atomicBoolean.set(true);
                return super.addLanguage(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addLanguage(originalResponseCode, originalDelay, language.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addLanguage_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final String languageString = "firstLanguage";
        final Language language = new Language(languageString);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addLanguage(originalResponseCode, originalDelay, language.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeLanguage_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeLanguage() {
                atomicBoolean.set(true);
                return super.removeLanguage();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeLanguage());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeLanguage_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        Exception exception = null;
        try {
            baseBuilder.removeLanguage();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addTwoZoneHeartRateLimit_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addTwoZoneHeartRateLimit(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(twoZoneHeartRateLimit.getBytes(), value);
                atomicBoolean.set(true);
                return super.addTwoZoneHeartRateLimit(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTwoZoneHeartRateLimit(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTwoZoneHeartRateLimit_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addTwoZoneHeartRateLimit(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(twoZoneHeartRateLimit.getBytes(), value);
                atomicBoolean.set(true);
                return super.addTwoZoneHeartRateLimit(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTwoZoneHeartRateLimit(twoZoneHeartRateLimit));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTwoZoneHeartRateLimit_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalValue = 1;
        final TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addTwoZoneHeartRateLimit(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(twoZoneHeartRateLimit.getBytes(), value);
                atomicBoolean.set(true);
                return super.addTwoZoneHeartRateLimit(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTwoZoneHeartRateLimit(twoZoneHeartRateLimit.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTwoZoneHeartRateLimit_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addTwoZoneHeartRateLimit(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(twoZoneHeartRateLimit.getBytes(), value);
                atomicBoolean.set(true);
                return super.addTwoZoneHeartRateLimit(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTwoZoneHeartRateLimit(originalResponseCode, originalDelay, twoZoneHeartRateLimit.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTwoZoneHeartRateLimit_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addTwoZoneHeartRateLimit(originalResponseCode, originalDelay, twoZoneHeartRateLimit.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeTwoZoneHeartRateLimit_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeTwoZoneHeartRateLimit() {
                atomicBoolean.set(true);
                return super.removeTwoZoneHeartRateLimit();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeTwoZoneHeartRateLimit());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeTwoZoneHeartRateLimit_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        Exception exception = null;
        try {
            baseBuilder.removeTwoZoneHeartRateLimit();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addThreeZoneHeartRateLimits_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit = 1;
        final int originalThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit = 2;
        final ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(originalThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit
                , originalThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addThreeZoneHeartRateLimits(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(threeZoneHeartRateLimits.getBytes(), value);
                atomicBoolean.set(true);
                return super.addThreeZoneHeartRateLimits(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addThreeZoneHeartRateLimits(originalThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit
                , originalThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addThreeZoneHeartRateLimits_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit = 1;
        final int originalThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit = 2;
        final ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(originalThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit
                , originalThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addThreeZoneHeartRateLimits(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(threeZoneHeartRateLimits.getBytes(), value);
                atomicBoolean.set(true);
                return super.addThreeZoneHeartRateLimits(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addThreeZoneHeartRateLimits(threeZoneHeartRateLimits));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addThreeZoneHeartRateLimits_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit = 1;
        final int originalThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit = 2;
        final ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(originalThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit
                , originalThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addThreeZoneHeartRateLimits(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(threeZoneHeartRateLimits.getBytes(), value);
                atomicBoolean.set(true);
                return super.addThreeZoneHeartRateLimits(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addThreeZoneHeartRateLimits(threeZoneHeartRateLimits.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addThreeZoneHeartRateLimits_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit = 3;
        final int originalThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit = 4;
        final ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(originalThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit
                , originalThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addThreeZoneHeartRateLimits(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(threeZoneHeartRateLimits.getBytes(), value);
                atomicBoolean.set(true);
                return super.addThreeZoneHeartRateLimits(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addThreeZoneHeartRateLimits(originalResponseCode, originalDelay, threeZoneHeartRateLimits.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addThreeZoneHeartRateLimits_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalValue = 3;
        final TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addThreeZoneHeartRateLimits(originalResponseCode, originalDelay, twoZoneHeartRateLimit.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeThreeZoneHeartRateLimits_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeThreeZoneHeartRateLimits() {
                atomicBoolean.set(true);
                return super.removeThreeZoneHeartRateLimits();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeThreeZoneHeartRateLimits());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeThreeZoneHeartRateLimits_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        Exception exception = null;
        try {
            baseBuilder.removeThreeZoneHeartRateLimits();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addFiveZoneHeartRateLimits_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalFiveZoneHeartRateLimitsVeryLightLightLimit = 1;
        final int originalFiveZoneHeartRateLimitsLightModerateLimit = 2;
        final int originalFiveZoneHeartRateLimitsModerateHardLimit = 3;
        final int originalFiveZoneHeartRateLimitsHardMaximumLimit = 4;
        final FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(originalFiveZoneHeartRateLimitsVeryLightLightLimit
                , originalFiveZoneHeartRateLimitsLightModerateLimit
                , originalFiveZoneHeartRateLimitsModerateHardLimit
                , originalFiveZoneHeartRateLimitsHardMaximumLimit);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addFiveZoneHeartRateLimits(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(fiveZoneHeartRateLimits.getBytes(), value);
                atomicBoolean.set(true);
                return super.addFiveZoneHeartRateLimits(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addFiveZoneHeartRateLimits(originalFiveZoneHeartRateLimitsVeryLightLightLimit
                , originalFiveZoneHeartRateLimitsLightModerateLimit
                , originalFiveZoneHeartRateLimitsModerateHardLimit
                , originalFiveZoneHeartRateLimitsHardMaximumLimit));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addFiveZoneHeartRateLimits_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalFiveZoneHeartRateLimitsVeryLightLightLimit = 1;
        final int originalFiveZoneHeartRateLimitsLightModerateLimit = 2;
        final int originalFiveZoneHeartRateLimitsModerateHardLimit = 3;
        final int originalFiveZoneHeartRateLimitsHardMaximumLimit = 4;
        final FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(originalFiveZoneHeartRateLimitsVeryLightLightLimit
                , originalFiveZoneHeartRateLimitsLightModerateLimit
                , originalFiveZoneHeartRateLimitsModerateHardLimit
                , originalFiveZoneHeartRateLimitsHardMaximumLimit);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addFiveZoneHeartRateLimits(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(fiveZoneHeartRateLimits.getBytes(), value);
                atomicBoolean.set(true);
                return super.addFiveZoneHeartRateLimits(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addFiveZoneHeartRateLimits(fiveZoneHeartRateLimits));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addFiveZoneHeartRateLimits_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalFiveZoneHeartRateLimitsVeryLightLightLimit = 1;
        final int originalFiveZoneHeartRateLimitsLightModerateLimit = 2;
        final int originalFiveZoneHeartRateLimitsModerateHardLimit = 3;
        final int originalFiveZoneHeartRateLimitsHardMaximumLimit = 4;
        final FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(originalFiveZoneHeartRateLimitsVeryLightLightLimit
                , originalFiveZoneHeartRateLimitsLightModerateLimit
                , originalFiveZoneHeartRateLimitsModerateHardLimit
                , originalFiveZoneHeartRateLimitsHardMaximumLimit);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addFiveZoneHeartRateLimits(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(fiveZoneHeartRateLimits.getBytes(), value);
                atomicBoolean.set(true);
                return super.addFiveZoneHeartRateLimits(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addFiveZoneHeartRateLimits(fiveZoneHeartRateLimits.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addFiveZoneHeartRateLimits_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalFiveZoneHeartRateLimitsVeryLightLightLimit = 1;
        final int originalFiveZoneHeartRateLimitsLightModerateLimit = 2;
        final int originalFiveZoneHeartRateLimitsModerateHardLimit = 3;
        final int originalFiveZoneHeartRateLimitsHardMaximumLimit = 4;
        final FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(originalFiveZoneHeartRateLimitsVeryLightLightLimit
                , originalFiveZoneHeartRateLimitsLightModerateLimit
                , originalFiveZoneHeartRateLimitsModerateHardLimit
                , originalFiveZoneHeartRateLimitsHardMaximumLimit);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addFiveZoneHeartRateLimits(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(fiveZoneHeartRateLimits.getBytes(), value);
                atomicBoolean.set(true);
                return super.addFiveZoneHeartRateLimits(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addFiveZoneHeartRateLimits(originalResponseCode, originalDelay, fiveZoneHeartRateLimits.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addFiveZoneHeartRateLimits_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final int originalFiveZoneHeartRateLimitsVeryLightLightLimit = 3;
        final int originalFiveZoneHeartRateLimitsLightModerateLimit = 4;
        final int originalFiveZoneHeartRateLimitsModerateHardLimit = 5;
        final int originalFiveZoneHeartRateLimitsHardMaximumLimit = 6;
        final FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(originalFiveZoneHeartRateLimitsVeryLightLightLimit
                , originalFiveZoneHeartRateLimitsLightModerateLimit
                , originalFiveZoneHeartRateLimitsModerateHardLimit
                , originalFiveZoneHeartRateLimitsHardMaximumLimit);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addFiveZoneHeartRateLimits(originalResponseCode, originalDelay, fiveZoneHeartRateLimits.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeFiveZoneHeartRateLimits_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeFiveZoneHeartRateLimits() {
                atomicBoolean.set(true);
                return super.removeFiveZoneHeartRateLimits();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeFiveZoneHeartRateLimits());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeFiveZoneHeartRateLimits_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        Exception exception = null;
        try {
            baseBuilder.removeFiveZoneHeartRateLimits();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addDatabaseChangeIncrement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(originalDescriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addDatabaseChangeIncrement(int characteristicResponseCode, long characteristicDelay, boolean canNotify, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addDatabaseChangeIncrement(characteristicResponseCode, characteristicDelay, canNotify, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDatabaseChangeIncrement(clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addDatabaseChangeIncrement_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final boolean originalCanNotify = false;
        final int originalDescriptorResponseCode = 4;
        final long originalDescriptorDelay = 5;

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addDatabaseChangeIncrement(int characteristicResponseCode, long characteristicDelay, boolean canNotify, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalCanNotify, canNotify);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addDatabaseChangeIncrement(characteristicResponseCode, characteristicDelay, canNotify, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDatabaseChangeIncrement(originalCharacteristicResponseCode, originalCharacteristicDelay, originalCanNotify, originalDescriptorResponseCode, originalDescriptorDelay, originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addDatabaseChangeIncrement_00101() {
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final boolean originalCanNotify = false;
        final int originalDescriptorResponseCode = 4;
        final long originalDescriptorDelay = 5;

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDatabaseChangeIncrement(originalCharacteristicResponseCode, originalCharacteristicDelay, originalCanNotify, originalDescriptorResponseCode, originalDescriptorDelay, originalDescriptorValue));

        Exception exception = null;
        try {
            baseBuilder.addDatabaseChangeIncrement(originalCharacteristicResponseCode, originalCharacteristicDelay, originalCanNotify, originalDescriptorResponseCode, originalDescriptorDelay, originalDescriptorValue);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeDatabaseChangeIncrement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeDatabaseChangeIncrement() {
                atomicBoolean.set(true);
                return super.removeDatabaseChangeIncrement();
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeDatabaseChangeIncrement());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeDatabaseChangeIncrement_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeDatabaseChangeIncrement());

        Exception exception = null;
        try {
            baseBuilder.removeDatabaseChangeIncrement();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addUserIndex_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addUserIndex(int responseCode, long delay) {
                atomicBoolean.set(true);
                return super.addUserIndex(responseCode, delay);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addUserIndex());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addUserIndex_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final int originalResponseCode = 1;
        final long originalDelay = 2;

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addUserIndex(int responseCode, long delay) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                atomicBoolean.set(true);
                return super.addUserIndex(responseCode, delay);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addUserIndex(originalResponseCode, originalDelay));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addUserIndex_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addUserIndex(originalResponseCode, originalDelay);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeUserIndex_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeUserIndex() {
                atomicBoolean.set(true);
                return super.removeUserIndex();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeUserIndex());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeUserIndex_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeUserIndex());

        Exception exception = null;
        try {
            baseBuilder.removeUserIndex();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addUserControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final long originalCharacteristicDelay = 1;
        final int originalRegisterNewUserResponseValue = 2;
        final int originalConsentResponseValue = 3;
        final int originalDeleteUserDataResponseValue = 4;
        final int originalDescriptorResponseCode = 5;
        final long originalDescriptorDelay = 6;
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> addUserControlPoint(long characteristicDelay, int registerNewUserResponseValue, int consentResponseValue, int deleteUserDataResponseValue, int listAllUsersResponseValue, int deleteUsersResponseValue, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalRegisterNewUserResponseValue, registerNewUserResponseValue);
                assertEquals(originalConsentResponseValue, consentResponseValue);
                assertEquals(originalDeleteUserDataResponseValue, deleteUserDataResponseValue);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addUserControlPoint(characteristicDelay, registerNewUserResponseValue, consentResponseValue, deleteUserDataResponseValue, listAllUsersResponseValue, deleteUsersResponseValue, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);

        assertEquals(baseBuilder, baseBuilder.addUserControlPoint(originalCharacteristicDelay
                , originalRegisterNewUserResponseValue
                , originalConsentResponseValue
                , originalDeleteUserDataResponseValue
                , originalDescriptorResponseCode
                , originalDescriptorDelay
                , originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addUserControlPoint_00101() {
        final long originalCharacteristicDelay = 1;
        final int originalRegisterNewUserResponseValue = 2;
        final int originalConsentResponseValue = 3;
        final int originalDeleteUserDataResponseValue = 4;
        final int originalDescriptorResponseCode = 5;
        final long originalDescriptorDelay = 6;
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addUserControlPoint(originalCharacteristicDelay
                    , originalRegisterNewUserResponseValue
                    , originalConsentResponseValue
                    , originalDeleteUserDataResponseValue
                    , originalDescriptorResponseCode
                    , originalDescriptorDelay
                    , originalDescriptorValue);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeUserControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback>() {

            @NonNull
            @Override
            public UserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> removeUserControlPoint() {
                atomicBoolean.set(true);
                return super.removeUserIndex();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , ftmpUserDataServiceMockCallbackBuilder
                , deviceInformationServiceMockCallbackBuilder);

        assertEquals(baseBuilder, baseBuilder.removeUserControlPoint());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeUserControlPoint_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , fitnessMachineServiceMockCallbackBuilder
                , null
                , deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeUserControlPoint());

        Exception exception = null;
        try {
            baseBuilder.removeUserControlPoint();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addManufacturerNameString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(manufacturerName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(manufacturerName));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";
        ManufacturerNameString manufacturerNameString = new ManufacturerNameString(manufacturerName);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(manufacturerName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(manufacturerNameString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
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
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(originalResponseCode, originalDelay, originalValue));
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeManufacturerNameString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeManufacturerNameString() {
                atomicBoolean.set(true);
                return super.removeManufacturerNameString();
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeManufacturerNameString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeManufacturerNameString_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            assertEquals(baseBuilder, baseBuilder.removeManufacturerNameString());
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
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(modelNumber.getBytes(), value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(modelNumber));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String modelNumber = "modelNumber";
        ModelNumberString modelNumberString = new ModelNumberString(modelNumber);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(modelNumber.getBytes(), value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(modelNumberString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = "modelNumber".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
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
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "modelNumber".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            assertEquals(baseBuilder, baseBuilder.addModelNumberString(originalResponseCode, originalDelay, originalValue));
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeModelNumberString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeModelNumberString() {
                atomicBoolean.set(true);
                return super.removeModelNumberString();
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeModelNumberString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeModelNumberString_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        FitnessMachineServiceMockCallback.Builder<FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder = new FitnessMachineServiceMockCallback.Builder<>();
        FtmpUserDataServiceMockCallback.Builder<FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder = new FtmpUserDataServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            assertEquals(baseBuilder, baseBuilder.removeModelNumberString());
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
                    , new FitnessMachineServiceMockCallback.Builder<>()
                    , new FtmpUserDataServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Fitness Machine Feature data", exception.getMessage());
    }

    @Test
    public void test_build_00002() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new FitnessMachineServiceMockCallback.Builder<>()
                    , new FtmpUserDataServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>())
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("At least one UDS Characteristic shall be exposed", exception.getMessage());
    }

    @Test
    public void test_build_00003() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new FitnessMachineServiceMockCallback.Builder<>()
                    , new FtmpUserDataServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>())
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addAge(1)
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Database Change Increment data", exception.getMessage());
    }

    @Test
    public void test_build_00004() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new FitnessMachineServiceMockCallback.Builder<>()
                    , new FtmpUserDataServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>())
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addAge(1)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no User Index data", exception.getMessage());
    }

    @Test
    public void test_build_00005() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new FitnessMachineServiceMockCallback.Builder<>()
                    , new FtmpUserDataServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>())
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addAge(1)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no User Control Point data", exception.getMessage());
    }

    @Test
    public void test_build_00006() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new FitnessMachineServiceMockCallback.Builder<>()
                    , new FtmpUserDataServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>())
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addAge(1)
                    .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addUserIndex()
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no User Control Point data", exception.getMessage());
    }

    @Test
    public void test_build_00007() {
        FitnessMachineProfileMockCallback callback = new BaseBuilder(ApplicationProvider.getApplicationContext()
                , new FitnessMachineServiceMockCallback.Builder<>()
                , new FtmpUserDataServiceMockCallback.Builder<>()
                , new DeviceInformationServiceMockCallback.Builder<>())
                .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                .addAge(1)
                .addDatabaseChangeIncrement(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addUserIndex()
                .addUserControlPoint(0
                        , UserControlPoint.RESPONSE_VALUE_SUCCESS
                        , UserControlPoint.RESPONSE_VALUE_SUCCESS
                        , UserControlPoint.RESPONSE_VALUE_SUCCESS
                        , 0
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .build();

        assertNotNull(callback);
    }

}
