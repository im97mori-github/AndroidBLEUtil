package org.im97mori.ble.profile.blp.peripheral;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;
import org.im97mori.ble.characteristic.u2a23.SystemId;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a35.BloodPressureMeasurement;
import org.im97mori.ble.characteristic.u2a36.IntermediateCuffPressure;
import org.im97mori.ble.characteristic.u2a49.BloodPressureFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.bls.peripheral.BloodPressureServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class BloodPressureProfileMockCallbackBuilderTest {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(deviceInformationServiceMockCallbackBuilder, baseBuilder.mDeviceInformationServiceMockCallbackBuilder);
        assertEquals(bloodPressureServiceMockCallbackBuilder, baseBuilder.mBloodPressureServiceMockCallbackBuilder);
    }

    @Test
    public void test_addManufacturerNameString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(manufacturerName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(manufacturerName));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";
        ManufacturerNameString manufacturerNameString = new ManufacturerNameString(manufacturerName);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(manufacturerName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(manufacturerNameString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
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
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00101() {
        final String manufacturerName = "manufacturerName";

        Context context = ApplicationProvider.getApplicationContext();
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            baseBuilder.addManufacturerNameString(manufacturerName);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeManufacturerNameString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {

            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeManufacturerNameString() {
                atomicBoolean.set(true);
                return super.removeManufacturerNameString();
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeManufacturerNameString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeManufacturerNameString_00101() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {

            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeManufacturerNameString() {
                atomicBoolean.set(true);
                return super.removeManufacturerNameString();
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);

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
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(modelNumber.getBytes(), value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(modelNumber));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String modelNumber = "modelNumber";
        ModelNumberString modelNumberString = new ModelNumberString(modelNumber);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(modelNumber.getBytes(), value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(modelNumberString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = "modelNumber".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
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
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00101() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String modelNumber = "modelNumber";

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(modelNumber.getBytes(), value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addModelNumberString(modelNumber);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeModelNumberString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {

            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeModelNumberString() {
                atomicBoolean.set(true);
                return super.removeModelNumberString();
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeModelNumberString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeModelNumberString_00101() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {

            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeManufacturerNameString() {
                atomicBoolean.set(true);
                return super.removeManufacturerNameString();
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.removeModelNumberString();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addSystemId_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final long originalManufacturerIdentifier = 1;
        final int originalOrganizationallyUniqueIdentifier = 2;
        final SystemId originalSystemId = new SystemId(originalManufacturerIdentifier, originalOrganizationallyUniqueIdentifier);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addSystemId(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalSystemId.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSystemId(responseCode, delay, value);
            }

        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSystemId(originalManufacturerIdentifier, originalOrganizationallyUniqueIdentifier));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSystemId_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final long originalManufacturerIdentifier = 1;
        final int originalOrganizationallyUniqueIdentifier = 2;
        final SystemId originalSystemId = new SystemId(originalManufacturerIdentifier, originalOrganizationallyUniqueIdentifier);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addSystemId(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalSystemId.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSystemId(responseCode, delay, value);
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSystemId(originalSystemId));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSystemId_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final long originalManufacturerIdentifier = 1;
        final int originalOrganizationallyUniqueIdentifier = 2;
        final SystemId originalSystemId = new SystemId(originalManufacturerIdentifier, originalOrganizationallyUniqueIdentifier);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addSystemId(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalSystemId.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSystemId(responseCode, delay, value);
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSystemId(originalSystemId.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSystemId_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final long originalManufacturerIdentifier = 1;
        final int originalOrganizationallyUniqueIdentifier = 2;
        final SystemId originalSystemId = new SystemId(originalManufacturerIdentifier, originalOrganizationallyUniqueIdentifier);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addSystemId(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalSystemId.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSystemId(responseCode, delay, value);
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSystemId(originalResponseCode, originalDelay, originalSystemId.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSystemId_00101() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final long originalManufacturerIdentifier = 1;
        final int originalOrganizationallyUniqueIdentifier = 2;
        final SystemId originalSystemId = new SystemId(originalManufacturerIdentifier, originalOrganizationallyUniqueIdentifier);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addSystemId(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalSystemId.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSystemId(responseCode, delay, value);
            }

        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.addSystemId(originalSystemId);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeSystemId_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {

            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeSystemId() {
                atomicBoolean.set(true);
                return super.removeSystemId();
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeSystemId());

        assertTrue(atomicBoolean.get());
    }


    @Test
    public void test_removeSystemId_00101() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {

            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeManufacturerNameString() {
                atomicBoolean.set(true);
                return super.removeManufacturerNameString();
            }
        };
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            baseBuilder.removeSystemId();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addBloodPressureMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        int bpmFlags = 1;
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int bpmYear = 14;
        int bpmMonth = 15;
        int bpmDay = 16;
        int bpmHours = 17;
        int bpmMinutes = 18;
        int bpmSeconds = 19;
        IEEE_11073_20601_SFLOAT bpmPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int bpmUserId = 22;
        byte[] bpmMeasurementStatus = new byte[]{23};
        final BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(bpmFlags, bpmBloodPressureMeasurementCompoundValueSystolicMmhg, bpmBloodPressureMeasurementCompoundValueDiastolicMmhg, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bpmBloodPressureMeasurementCompoundValueSystolicKpa, bpmBloodPressureMeasurementCompoundValueDiastolicKpa, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa, bpmYear, bpmMonth, bpmDay, bpmHours, bpmMinutes, bpmSeconds, bpmPulseRate, bpmUserId, bpmMeasurementStatus);

        byte[] bpmDescriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        final ClientCharacteristicConfiguration bpmclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(bpmDescriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback>() {
            @NonNull
            @Override
            public BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> addBloodPressureMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(bloodPressureMeasurement.getBytes(), characteristicValue);
                assertArrayEquals(bpmclientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addBloodPressureMeasurement(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addBloodPressureMeasurement(bloodPressureMeasurement, bpmclientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addBloodPressureMeasurement_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        int bpmFlags = 1;
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int bpmYear = 14;
        int bpmMonth = 15;
        int bpmDay = 16;
        int bpmHours = 17;
        int bpmMinutes = 18;
        int bpmSeconds = 19;
        IEEE_11073_20601_SFLOAT bpmPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int bpmUserId = 22;
        byte[] bpmMeasurementStatus = new byte[]{23};
        final BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(bpmFlags, bpmBloodPressureMeasurementCompoundValueSystolicMmhg, bpmBloodPressureMeasurementCompoundValueDiastolicMmhg, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bpmBloodPressureMeasurementCompoundValueSystolicKpa, bpmBloodPressureMeasurementCompoundValueDiastolicKpa, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa, bpmYear, bpmMonth, bpmDay, bpmHours, bpmMinutes, bpmSeconds, bpmPulseRate, bpmUserId, bpmMeasurementStatus);

        byte[] bpmDescriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        final ClientCharacteristicConfiguration bpmclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(bpmDescriptorValue);

        final int originalCharacteristicResponseCode = 38;
        final long originalCharacteristicDelay = 39;
        final int originalNotificationCount = 40;
        final int originalDescriptorResponseCode = 41;
        final long originalDescriptorDelay = 42;

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback>() {
            @NonNull
            @Override
            public BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> addBloodPressureMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(bloodPressureMeasurement.getBytes(), characteristicValue);
                assertArrayEquals(bpmclientCharacteristicConfiguration.getBytes(), descriptorValue);
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                atomicBoolean.set(true);
                return super.addBloodPressureMeasurement(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addBloodPressureMeasurement(originalCharacteristicResponseCode, originalCharacteristicDelay, bloodPressureMeasurement.getBytes(), originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, bpmclientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBloodPressureMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback>() {

            @NonNull
            @Override
            public BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> removeBloodPressureMeasurement() {
                atomicBoolean.set(true);
                return super.removeBloodPressureMeasurement();
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeBloodPressureMeasurement());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addIntermediateCuffPressure_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        int icpFlags = 1;
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueDiastolicUnused = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueMeanArterialPressureUnused = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        int icpYear = 10;
        int icpMonth = 11;
        int icpDay = 12;
        int icpHours = 13;
        int icpMinutes = 14;
        int icpSeconds = 15;
        IEEE_11073_20601_SFLOAT icpPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{16, 17}, 0);
        int icpUserId = 18;
        byte[] icpMeasurementStatus = new byte[]{19};
        final IntermediateCuffPressure intermediateCuffPressure = new IntermediateCuffPressure(icpFlags
                , intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg
                , intermediateCuffPressureCompoundValueCurrentCuffPressureKpa
                , intermediateCuffPressureCompoundValueDiastolicUnused
                , intermediateCuffPressureCompoundValueMeanArterialPressureUnused
                , icpYear, icpMonth, icpDay, icpHours, icpMinutes, icpSeconds, icpPulseRate, icpUserId, icpMeasurementStatus);

        byte[] icpDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration icpclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(icpDescriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback>() {

            @NonNull
            @Override
            public BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> addIntermediateCuffPressure(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(intermediateCuffPressure.getBytes(), characteristicValue);
                assertArrayEquals(icpclientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addIntermediateCuffPressure(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addIntermediateCuffPressure(intermediateCuffPressure, icpclientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addIntermediateCuffPressure_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        int icpFlags = 1;
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueDiastolicUnused = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueMeanArterialPressureUnused = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        int icpYear = 10;
        int icpMonth = 11;
        int icpDay = 12;
        int icpHours = 13;
        int icpMinutes = 14;
        int icpSeconds = 15;
        IEEE_11073_20601_SFLOAT icpPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{16, 17}, 0);
        int icpUserId = 18;
        byte[] icpMeasurementStatus = new byte[]{19};
        final IntermediateCuffPressure intermediateCuffPressure = new IntermediateCuffPressure(icpFlags
                , intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg
                , intermediateCuffPressureCompoundValueCurrentCuffPressureKpa
                , intermediateCuffPressureCompoundValueDiastolicUnused
                , intermediateCuffPressureCompoundValueMeanArterialPressureUnused
                , icpYear, icpMonth, icpDay, icpHours, icpMinutes, icpSeconds, icpPulseRate, icpUserId, icpMeasurementStatus);

        byte[] icpDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration icpclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(icpDescriptorValue);

        final int originalCharacteristicResponseCode = 75;
        final long originalCharacteristicDelay = 76;
        final int originalDescriptorResponseCode = 77;
        final long originalDescriptorDelay = 78;

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback>() {
            @NonNull
            @Override
            public BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> addIntermediateCuffPressure(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(intermediateCuffPressure.getBytes(), characteristicValue);
                assertArrayEquals(icpclientCharacteristicConfiguration.getBytes(), descriptorValue);
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                atomicBoolean.set(true);
                return super.addIntermediateCuffPressure(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addIntermediateCuffPressure(originalCharacteristicResponseCode, originalCharacteristicDelay, intermediateCuffPressure.getBytes(), originalDescriptorResponseCode, originalDescriptorResponseCode, originalDescriptorDelay, icpclientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeIntermediateCuffPressure_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback>() {
            @NonNull
            @Override
            public BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> removeIntermediateCuffPressure() {
                atomicBoolean.set(true);
                return super.removeIntermediateCuffPressure();
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeIntermediateCuffPressure());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addBloodPressureFeature_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback>() {

            @NonNull
            @Override
            public BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> addBloodPressureFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(bloodPressureFeature.getBytes(), value);
                atomicBoolean.set(true);
                return super.addBloodPressureFeature(responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addBloodPressureFeature(bloodPressureFeature));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addBloodPressureFeature_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        final int originalResponseCode = 1;
        final long originalDelay = 2;

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback>() {

            @NonNull
            @Override
            public BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> addBloodPressureFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(bloodPressureFeature.getBytes(), value);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                atomicBoolean.set(true);
                return super.addBloodPressureFeature(responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addBloodPressureFeature(originalResponseCode, originalDelay, bloodPressureFeature.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBloodPressureFeature_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder = new BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback>() {
            @NonNull
            @Override
            public BloodPressureServiceMockCallback.Builder<BloodPressureServiceMockCallback> removeBloodPressureFeature() {
                atomicBoolean.set(true);
                return super.removeBloodPressureFeature();
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeBloodPressureFeature());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_build_00001() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new BloodPressureServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>()).build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Manufacturer Name String data", exception.getMessage());
    }

    @Test
    public void test_build_00101() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new BloodPressureServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addManufacturerNameString("")
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Model Number String data", exception.getMessage());
    }

    @Test
    public void test_build_00102() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new BloodPressureServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addManufacturerNameString(new ManufacturerNameString(""))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Model Number String data", exception.getMessage());
    }

    @Test
    public void test_build_00103() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new BloodPressureServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addManufacturerNameString(new ManufacturerNameString("").getBytes())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Model Number String data", exception.getMessage());
    }

    @Test
    public void test_build_00104() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new BloodPressureServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addManufacturerNameString(0, 0, new ManufacturerNameString("").getBytes())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Model Number String data", exception.getMessage());
    }

    @Test
    public void test_build_00201() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new BloodPressureServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addModelNumberString("")
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Manufacturer Name String data", exception.getMessage());
    }

    @Test
    public void test_build_00202() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new BloodPressureServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addModelNumberString(new ModelNumberString(""))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Manufacturer Name String data", exception.getMessage());
    }

    @Test
    public void test_build_00203() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new BloodPressureServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addModelNumberString(new ModelNumberString("").getBytes())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Manufacturer Name String data", exception.getMessage());
    }

    @Test
    public void test_build_00204() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new BloodPressureServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addModelNumberString(0, 0, new ModelNumberString("").getBytes())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Manufacturer Name String data", exception.getMessage());
    }

    @Test
    public void test_build_00301() {
        int bpmFlags = 1;
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int bpmYear = 14;
        int bpmMonth = 15;
        int bpmDay = 16;
        int bpmHours = 17;
        int bpmMinutes = 18;
        int bpmSeconds = 19;
        IEEE_11073_20601_SFLOAT bpmPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int bpmUserId = 22;
        byte[] bpmMeasurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(bpmFlags, bpmBloodPressureMeasurementCompoundValueSystolicMmhg, bpmBloodPressureMeasurementCompoundValueDiastolicMmhg, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bpmBloodPressureMeasurementCompoundValueSystolicKpa, bpmBloodPressureMeasurementCompoundValueDiastolicKpa, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa, bpmYear, bpmMonth, bpmDay, bpmHours, bpmMinutes, bpmSeconds, bpmPulseRate, bpmUserId, bpmMeasurementStatus);

        byte[] bpmDescriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration bpmclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(bpmDescriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        BloodPressureProfileMockCallback callback = new BaseBuilder(ApplicationProvider.getApplicationContext(), new BloodPressureServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                .addManufacturerNameString("")
                .addModelNumberString("")
                .addBloodPressureMeasurement(bloodPressureMeasurement, bpmclientCharacteristicConfiguration)
                .addBloodPressureFeature(bloodPressureFeature)
                .build();

        assertNotNull(callback);
    }

}
