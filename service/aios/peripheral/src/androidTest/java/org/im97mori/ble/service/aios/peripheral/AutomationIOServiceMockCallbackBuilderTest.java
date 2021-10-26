package org.im97mori.ble.service.aios.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.AGGREGATE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ANALOG_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DIGITAL_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.NUMBER_OF_DIGITALS_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.TIME_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.VALUE_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.AUTOMATION_IO_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Build;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

import org.im97mori.ble.characteristic.u2a56.Digital;
import org.im97mori.ble.characteristic.u2a58.Analog;
import org.im97mori.ble.descriptor.u2900.CharacteristicExtendedProperties;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormat;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.descriptor.u2909.NumberOfDigitals;
import org.im97mori.ble.descriptor.u290a.ValueTriggerSetting;
import org.im97mori.ble.descriptor.u290e.TimeTriggerSetting;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class AutomationIOServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Digital and Analog Characteristic not found", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00002() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_NOTIFY | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("The Indicate and Notify properties shall not be permitted simultaneously for Aggregate characteristic", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00003() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Aggregate characteristic Read property is not supported", exception.getMessage());
    }


    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00004() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Aggregate characteristic Read property is not supported", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00101() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_NOTIFY | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("The Indicate and Notify properties shall not be permitted simultaneously for Digital characteristic. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00102() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Indicate or Notify property shall be supported only if the Read property is supported for the characteristic. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00103() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Indicate or Notify property shall be supported only if the Read property is supported for the characteristic. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00104() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("The Indicate and Notify properties are excluded for the Digital characteristic if the Aggregate characteristic is supported. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00105() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Digital characteristic Characteristic Presentation Format descriptor not found. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00106() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x00, 0x00}).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Description values from 0x0001 and upwards shall be used to uniquely identify each Digital characteristic. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00107() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Number of Digitals descriptor not found. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00108() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new NumberOfDigitals(5).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Data size not match. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00109() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new NumberOfDigitals(1).getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_NOTIFY | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("The Indicate and Notify properties shall not be permitted simultaneously for Digital characteristic. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00110() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new NumberOfDigitals(1).getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Indicate or Notify property shall be supported only if the Read property is supported for the characteristic. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00111() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new NumberOfDigitals(1).getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Indicate or Notify property shall be supported only if the Read property is supported for the characteristic. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00112() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new NumberOfDigitals(1).getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("The Indicate and Notify properties are excluded for the Digital characteristic if the Aggregate characteristic is supported. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00113() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new NumberOfDigitals(1).getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Digital characteristic Characteristic Presentation Format descriptor not found. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00114() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new NumberOfDigitals(1).getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x00, 0x00}).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Description values from 0x0001 and upwards shall be used to uniquely identify each Digital characteristic. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00115() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new NumberOfDigitals(1).getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x02, 0x00}).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Number of Digitals descriptor not found. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00116() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new NumberOfDigitals(1).getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x02, 0x00}).getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new NumberOfDigitals(5).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Data size not match. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00117() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new NumberOfDigitals(1).getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new NumberOfDigitals(1).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Description values from 0x0001 and upwards shall be used to uniquely identify each Digital characteristic", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00201() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_NOTIFY | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("The Indicate and Notify properties shall not be permitted simultaneously for Analog characteristic. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00202() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Indicate or Notify property shall be supported only if the Read property is supported for the characteristic. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00203() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Indicate or Notify property shall be supported only if the Read property is supported for the characteristic. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00204() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("The Indicate and Notify properties are excluded for the Analog characteristic if the Aggregate characteristic is supported. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00205() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Analog characteristic Characteristic Presentation Format descriptor not found. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00206() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x00, 0x00}).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Description values from 0x0001 and upwards shall be used to uniquely identify each Analog characteristic. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00207() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Valid Range descriptor not found. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00208() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x01, 0x00}, new byte[]{0x01, 0x00}).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Data size not match. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00209() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[]{0, 0})
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x01, 0x00}, new byte[]{0x01, 0x00}).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Analog data is not in Valid Range. index:0", exception.getMessage());
    }


    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00210() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[]{0, 0})
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x00, 0x00}, new byte[]{0x01, 0x00}).getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_NOTIFY | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("The Indicate and Notify properties shall not be permitted simultaneously for Analog characteristic. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00211() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[]{0, 0})
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x00, 0x00}, new byte[]{0x01, 0x00}).getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Indicate or Notify property shall be supported only if the Read property is supported for the characteristic. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00212() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[]{0, 0})
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x00, 0x00}, new byte[]{0x01, 0x00}).getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Indicate or Notify property shall be supported only if the Read property is supported for the characteristic. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00213() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[]{0, 0})
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x00, 0x00}, new byte[]{0x01, 0x00}).getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("The Indicate and Notify properties are excluded for the Analog characteristic if the Aggregate characteristic is supported. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00214() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[]{0, 0})
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x00, 0x00}, new byte[]{0x01, 0x00}).getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Analog characteristic Characteristic Presentation Format descriptor not found. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00215() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[]{0, 0})
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x00, 0x00}, new byte[]{0x01, 0x00}).getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 1
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x00, 0x00}).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Description values from 0x0001 and upwards shall be used to uniquely identify each Analog characteristic. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00216() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[]{0, 0})
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x00, 0x00}, new byte[]{0x01, 0x00}).getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Valid Range descriptor not found. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00217() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[]{0, 0})
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x00, 0x00}, new byte[]{0x01, 0x00}).getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[1])
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x01, 0x00}, new byte[]{0x01, 0x00}).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Data size not match. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00218() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[]{0, 0})
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x00, 0x00}, new byte[]{0x01, 0x00}).getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[]{0, 0})
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x01, 0x00}, new byte[]{0x01, 0x00}).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Analog data is not in Valid Range. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00219() {
        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[]{0, 0})
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x00, 0x00}, new byte[]{0x01, 0x00}).getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new byte[]{0, 0})
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                                    , 0
                                    , 0
                                    , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                                    , new byte[]{0x01, 0x00}).getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , new ValidRange(new byte[]{0x00, 0x00}, new byte[]{0x00, 0x00}).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Description values from 0x0001 and upwards shall be used to uniquely identify each Analog characteristic", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigital_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(digital.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigital_00002() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_WRITE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(digital.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigital_00003() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(digital.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigital_00101() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(digital1.getBytes(), bluetoothGattCharacteristic.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(digital2.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigital_00102() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_WRITE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(digital1.getBytes(), bluetoothGattCharacteristic.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(digital2.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigital_00103() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(digital1.getBytes(), bluetoothGattCharacteristic.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(digital2.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigital_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});

        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .removeDigital(0)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Digital and Analog Characteristic not found", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigital_00101() {
        Digital digital = new Digital(new byte[]{0b00000001});

        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .removeDigital(0)
                    .removeDigital(1)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Digital and Analog Characteristic not found", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalClientCharacteristicConfiguration_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalClientCharacteristicConfiguration_00002() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalClientCharacteristicConfiguration_00003() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalClientCharacteristicConfiguration(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(value, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalClientCharacteristicConfiguration_00004() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalClientCharacteristicConfiguration(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(value, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalClientCharacteristicConfiguration_00101() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalClientCharacteristicConfiguration_00102() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalClientCharacteristicConfiguration_00103() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalClientCharacteristicConfiguration(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(value, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalClientCharacteristicConfiguration_00104() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});
        byte[] value = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalClientCharacteristicConfiguration(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(value, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalClientCharacteristicConfiguration_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalClientCharacteristicConfiguration(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .removeDigitalClientCharacteristicConfiguration(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalClientCharacteristicConfiguration_00002() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);
        byte[] value = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalClientCharacteristicConfiguration(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .removeDigitalClientCharacteristicConfiguration(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalClientCharacteristicConfiguration_00003() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .removeDigitalClientCharacteristicConfiguration(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalClientCharacteristicConfiguration_00004() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .removeDigitalClientCharacteristicConfiguration(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalClientCharacteristicConfiguration_00101() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalClientCharacteristicConfiguration(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .removeDigitalClientCharacteristicConfiguration(1)
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalClientCharacteristicConfiguration_00102() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalClientCharacteristicConfiguration(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .removeDigitalClientCharacteristicConfiguration(1)
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalClientCharacteristicConfiguration_00103() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .removeDigitalClientCharacteristicConfiguration(1)
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalClientCharacteristicConfiguration_00104() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .removeDigitalClientCharacteristicConfiguration(1)
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalCharacteristicPresentationFormat_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicPresentationFormat.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalCharacteristicPresentationFormat_00002() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .removeDigitalClientCharacteristicConfiguration(1)
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicPresentationFormat2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalCharacteristicPresentationFormat_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat.getBytes())
                    .removeDigitalCharacteristicPresentationFormat(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalCharacteristicPresentationFormat_00002() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .removeDigitalCharacteristicPresentationFormat(1)
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Digital characteristic Characteristic Presentation Format descriptor not found. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalCharacteristicUserDescription_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        CharacteristicUserDescription characteristicUserDescription = new CharacteristicUserDescription("a".getBytes());
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalCharacteristicUserDescription(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicUserDescription.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicUserDescription.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalCharacteristicUserDescription_00002() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        CharacteristicUserDescription characteristicUserDescription1 = new CharacteristicUserDescription("a".getBytes());
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        CharacteristicUserDescription characteristicUserDescription2 = new CharacteristicUserDescription("b".getBytes());
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalCharacteristicUserDescription(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicUserDescription1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalCharacteristicUserDescription(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicUserDescription2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicUserDescription2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalCharacteristicUserDescription_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        CharacteristicUserDescription characteristicUserDescription = new CharacteristicUserDescription("a".getBytes());
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalCharacteristicUserDescription(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicUserDescription.getBytes())
                    .removeDigitalCharacteristicUserDescription(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalCharacteristicUserDescription_00002() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        CharacteristicUserDescription characteristicUserDescription1 = new CharacteristicUserDescription("a".getBytes());
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        CharacteristicUserDescription characteristicUserDescription2 = new CharacteristicUserDescription("b".getBytes());
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalCharacteristicUserDescription(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicUserDescription1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalCharacteristicUserDescription(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicUserDescription2.getBytes())
                    .removeDigitalCharacteristicUserDescription(1)
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalCharacteristicExtendedProperties_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        CharacteristicExtendedProperties characteristicExtendedProperties = new CharacteristicExtendedProperties(true, false);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalCharacteristicExtendedProperties(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicExtendedProperties.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicExtendedProperties.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalCharacteristicExtendedProperties_00002() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        CharacteristicExtendedProperties characteristicExtendedProperties1 = new CharacteristicExtendedProperties(true, false);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        CharacteristicExtendedProperties characteristicExtendedProperties2 = new CharacteristicExtendedProperties(false, true);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalCharacteristicExtendedProperties(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicExtendedProperties1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalCharacteristicExtendedProperties(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicExtendedProperties2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicExtendedProperties2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalCharacteristicExtendedProperties_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        CharacteristicExtendedProperties characteristicExtendedProperties = new CharacteristicExtendedProperties(true, false);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalCharacteristicExtendedProperties(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicExtendedProperties.getBytes())
                    .removeDigitalCharacteristicExtendedProperties(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalCharacteristicExtendedProperties_00002() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        CharacteristicExtendedProperties characteristicExtendedProperties1 = new CharacteristicExtendedProperties(true, false);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        CharacteristicExtendedProperties characteristicExtendedProperties2 = new CharacteristicExtendedProperties(false, true);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalCharacteristicExtendedProperties(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicExtendedProperties1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalCharacteristicExtendedProperties(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicExtendedProperties2.getBytes())
                    .removeDigitalCharacteristicExtendedProperties(1)
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalValueTriggerSetting_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalValueTriggerSetting_00002() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalValueTriggerSetting_00003() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalValueTriggerSetting_00004() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalValueTriggerSetting_00005() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalValueTriggerSetting_00101() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalValueTriggerSetting_00102() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalValueTriggerSetting_00103() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalValueTriggerSetting_00104() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalValueTriggerSetting_00105() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalValueTriggerSetting_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .removeDigitalValueTriggerSetting(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalValueTriggerSetting_00002() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .removeDigitalValueTriggerSetting(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalValueTriggerSetting_00003() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .removeDigitalValueTriggerSetting(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalValueTriggerSetting_00004() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .removeDigitalValueTriggerSetting(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalValueTriggerSetting_00101() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .removeDigitalValueTriggerSetting(1)
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalValueTriggerSetting_00102() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .removeDigitalValueTriggerSetting(1)
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalValueTriggerSetting_00103() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .removeDigitalValueTriggerSetting(1)
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalValueTriggerSetting_00104() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .removeDigitalValueTriggerSetting(1)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .removeDigitalValueTriggerSetting(1)
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00002() {
        Digital digital = new Digital(new byte[]{0b00000001});
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00003() {
        Digital digital = new Digital(new byte[]{0b00000001});
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00004() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00005() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00006() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00007() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00008() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00101() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00102() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00103() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00104() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00105() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00106() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalTimeTriggerSetting_00107() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalTimeTriggerSetting_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .removeDigitalTimeTriggerSetting(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalTimeTriggerSetting_00002() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .removeDigitalTimeTriggerSetting(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalTimeTriggerSetting_00003() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .removeDigitalTimeTriggerSetting(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalTimeTriggerSetting_00004() {
        Digital digital = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .removeDigitalTimeTriggerSetting(0)
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalTimeTriggerSetting_00101() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .removeDigitalTimeTriggerSetting(1)
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalTimeTriggerSetting_00102() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .removeDigitalTimeTriggerSetting(1)
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalTimeTriggerSetting_00103() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .removeDigitalTimeTriggerSetting(1)
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalTimeTriggerSetting_00104() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addDigitalTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addDigitalTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .removeDigitalTimeTriggerSetting(1)
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalNumberOfDigitals_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DIGITAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(NUMBER_OF_DIGITALS_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(NUMBER_OF_DIGITALS_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(numberOfDigitals.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDigitalNumberOfDigitals_00101() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(NUMBER_OF_DIGITALS_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(NUMBER_OF_DIGITALS_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(numberOfDigitals2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalNumberOfDigitals_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .removeDigitalNumberOfDigitals(0)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Number of Digitals descriptor not found. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDigitalNumberOfDigitals_00101() {
        Digital digital1 = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals1 = new NumberOfDigitals(1);
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Digital digital2 = new Digital(new byte[]{0b00000010});
        NumberOfDigitals numberOfDigitals2 = new NumberOfDigitals(2);
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital1.getBytes())
                    .addDigitalCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals1.getBytes())
                    .addDigital(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital2.getBytes())
                    .addDigitalCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addDigitalNumberOfDigitals(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals2.getBytes())
                    .removeDigitalNumberOfDigitals(1)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Number of Digitals descriptor not found. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalog_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(analog.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalog_00002() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_WRITE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(analog.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalog_00003() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(analog.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalog_00101() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(analog1.getBytes(), bluetoothGattCharacteristic.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(analog2.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalog_00102() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_WRITE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(analog1.getBytes(), bluetoothGattCharacteristic.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(analog2.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalog_00103() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(analog1.getBytes(), bluetoothGattCharacteristic.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(analog2.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalog_00001() {
        Analog analog = new Analog(new byte[]{1, 2});

        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .removeAnalog(0)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Digital and Analog Characteristic not found", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalog_00101() {
        Analog analog = new Analog(new byte[]{1, 2});

        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .removeAnalog(0)
                    .removeAnalog(1)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Digital and Analog Characteristic not found", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogClientCharacteristicConfiguration_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogClientCharacteristicConfiguration_00002() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogClientCharacteristicConfiguration_00003() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogClientCharacteristicConfiguration(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(value, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogClientCharacteristicConfiguration_00004() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogClientCharacteristicConfiguration(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(value, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogClientCharacteristicConfiguration_00101() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogClientCharacteristicConfiguration_00102() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogClientCharacteristicConfiguration_00103() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogClientCharacteristicConfiguration(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(value, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogClientCharacteristicConfiguration_00104() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});
        byte[] value = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogClientCharacteristicConfiguration(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(value, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogClientCharacteristicConfiguration_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogClientCharacteristicConfiguration(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .removeAnalogClientCharacteristicConfiguration(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogClientCharacteristicConfiguration_00002() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        byte[] value = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogClientCharacteristicConfiguration(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .removeAnalogClientCharacteristicConfiguration(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogClientCharacteristicConfiguration_00003() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .removeAnalogClientCharacteristicConfiguration(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogClientCharacteristicConfiguration_00004() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .removeAnalogClientCharacteristicConfiguration(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogClientCharacteristicConfiguration_00101() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogClientCharacteristicConfiguration(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .removeAnalogClientCharacteristicConfiguration(1)
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogClientCharacteristicConfiguration_00102() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogClientCharacteristicConfiguration(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .removeAnalogClientCharacteristicConfiguration(1)
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogClientCharacteristicConfiguration_00103() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .removeAnalogClientCharacteristicConfiguration(1)
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogClientCharacteristicConfiguration_00104() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .removeAnalogClientCharacteristicConfiguration(1)
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogCharacteristicPresentationFormat_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicPresentationFormat.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogCharacteristicPresentationFormat_00002() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .removeAnalogClientCharacteristicConfiguration(1)
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicPresentationFormat2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogCharacteristicPresentationFormat_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat.getBytes())
                    .removeAnalogCharacteristicPresentationFormat(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogCharacteristicPresentationFormat_00002() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .removeAnalogCharacteristicPresentationFormat(1)
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Analog characteristic Characteristic Presentation Format descriptor not found. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogCharacteristicUserDescription_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        CharacteristicUserDescription characteristicUserDescription = new CharacteristicUserDescription("a".getBytes());
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogCharacteristicUserDescription(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicUserDescription.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicUserDescription.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogCharacteristicUserDescription_00002() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        CharacteristicUserDescription characteristicUserDescription1 = new CharacteristicUserDescription("a".getBytes());
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        CharacteristicUserDescription characteristicUserDescription2 = new CharacteristicUserDescription("b".getBytes());
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogCharacteristicUserDescription(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicUserDescription1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogCharacteristicUserDescription(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicUserDescription2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicUserDescription2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogCharacteristicUserDescription_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        CharacteristicUserDescription characteristicUserDescription = new CharacteristicUserDescription("a".getBytes());
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogCharacteristicUserDescription(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicUserDescription.getBytes())
                    .removeAnalogCharacteristicUserDescription(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogCharacteristicUserDescription_00002() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        CharacteristicUserDescription characteristicUserDescription1 = new CharacteristicUserDescription("a".getBytes());
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        CharacteristicUserDescription characteristicUserDescription2 = new CharacteristicUserDescription("b".getBytes());
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogCharacteristicUserDescription(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicUserDescription1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogCharacteristicUserDescription(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicUserDescription2.getBytes())
                    .removeAnalogCharacteristicUserDescription(1)
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogCharacteristicExtendedProperties_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        CharacteristicExtendedProperties characteristicExtendedProperties = new CharacteristicExtendedProperties(true, false);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogCharacteristicExtendedProperties(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicExtendedProperties.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicExtendedProperties.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogCharacteristicExtendedProperties_00002() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        CharacteristicExtendedProperties characteristicExtendedProperties1 = new CharacteristicExtendedProperties(true, false);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        CharacteristicExtendedProperties characteristicExtendedProperties2 = new CharacteristicExtendedProperties(false, true);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogCharacteristicExtendedProperties(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicExtendedProperties1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogCharacteristicExtendedProperties(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicExtendedProperties2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicExtendedProperties2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogCharacteristicExtendedProperties_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        CharacteristicExtendedProperties characteristicExtendedProperties = new CharacteristicExtendedProperties(true, false);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogCharacteristicExtendedProperties(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicExtendedProperties.getBytes())
                    .removeAnalogCharacteristicExtendedProperties(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogCharacteristicExtendedProperties_00002() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        CharacteristicExtendedProperties characteristicExtendedProperties1 = new CharacteristicExtendedProperties(true, false);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        CharacteristicExtendedProperties characteristicExtendedProperties2 = new CharacteristicExtendedProperties(false, true);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogCharacteristicExtendedProperties(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicExtendedProperties1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogCharacteristicExtendedProperties(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicExtendedProperties2.getBytes())
                    .removeAnalogCharacteristicExtendedProperties(1)
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogValueTriggerSetting_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogValueTriggerSetting_00002() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogValueTriggerSetting_00003() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogValueTriggerSetting_00004() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogValueTriggerSetting_00005() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogValueTriggerSetting_00101() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogValueTriggerSetting_00102() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogValueTriggerSetting_00103() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogValueTriggerSetting_00104() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogValueTriggerSetting_00105() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALUE_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(valueTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogValueTriggerSetting_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .removeAnalogValueTriggerSetting(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogValueTriggerSetting_00002() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .removeAnalogValueTriggerSetting(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogValueTriggerSetting_00003() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .removeAnalogValueTriggerSetting(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogValueTriggerSetting_00004() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .removeAnalogValueTriggerSetting(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogValueTriggerSetting_00101() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .removeAnalogValueTriggerSetting(1)
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogValueTriggerSetting_00102() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .removeAnalogValueTriggerSetting(1)
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())

                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogValueTriggerSetting_00103() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .removeAnalogValueTriggerSetting(1)
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogValueTriggerSetting_00104() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .removeAnalogValueTriggerSetting(1)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .removeAnalogValueTriggerSetting(1)
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00002() {
        Analog analog = new Analog(new byte[]{1, 0});
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00003() {
        Analog analog = new Analog(new byte[]{1, 0});
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00004() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00005() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});


        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00006() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});


        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00007() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});


        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00008() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00101() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00102() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00103() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00104() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00105() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00106() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogTimeTriggerSetting_00107() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(TIME_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(timeTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogTimeTriggerSetting_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .removeAnalogTimeTriggerSetting(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogTimeTriggerSetting_00002() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .removeAnalogTimeTriggerSetting(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogTimeTriggerSetting_00003() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .removeAnalogTimeTriggerSetting(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogTimeTriggerSetting_00004() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting.getBytes())
                    .removeAnalogTimeTriggerSetting(0)
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogTimeTriggerSetting_00101() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .removeAnalogTimeTriggerSetting(1)
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogTimeTriggerSetting_00102() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .removeAnalogTimeTriggerSetting(1)
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogTimeTriggerSetting_00103() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .removeAnalogTimeTriggerSetting(1)
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogTimeTriggerSetting_00104() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValueTriggerSetting valueTriggerSetting1 = new ValueTriggerSetting(ValueTriggerSetting.NONE_0, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting1 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0, 0, 0);
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValueTriggerSetting valueTriggerSetting2 = new ValueTriggerSetting(ValueTriggerSetting.NONE_7, 0, new byte[0], 0, 0);
        TimeTriggerSetting timeTriggerSetting2 = new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 0);
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValueTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting1.getBytes())
                    .addAnalogTimeTriggerSetting(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValueTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , valueTriggerSetting2.getBytes())
                    .addAnalogTimeTriggerSetting(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , timeTriggerSetting2.getBytes())
                    .removeAnalogTimeTriggerSetting(1)
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(2);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogValidRange_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANALOG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(validRange.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAnalogValidRange_00101() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(validRange2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogValidRange_00001() {
        Analog analog = new Analog(new byte[]{1, 0});
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});

        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .removeAnalogValidRange(0)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Valid Range descriptor not found. index:0", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAnalogValidRange_00101() {
        Analog analog1 = new Analog(new byte[]{1, 0});
        ValidRange validRange1 = new ValidRange(new byte[]{0, 0}, new byte[]{1, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat1 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x01, 0x02});

        Analog analog2 = new Analog(new byte[]{2, 0});
        ValidRange validRange2 = new ValidRange(new byte[]{1, 0}, new byte[]{2, 0});
        CharacteristicPresentationFormat characteristicPresentationFormat2 = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER
                , 0
                , 0
                , CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS
                , new byte[]{0x03, 0x04});

        Exception exception = null;
        try {
            new AutomationIOServiceMockCallback.Builder<>()
                    .addAnalog(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog1.getBytes())
                    .addAnalogCharacteristicPresentationFormat(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat1.getBytes())
                    .addAnalogValidRange(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange1.getBytes())
                    .addAnalog(1
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , analog2.getBytes())
                    .addAnalogCharacteristicPresentationFormat(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , characteristicPresentationFormat2.getBytes())
                    .addAnalogValidRange(1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange2.getBytes())
                    .removeAnalogValidRange(1)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Valid Range descriptor not found. index:1", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAggregate_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGGREGATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGGREGATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAggregate_00002() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGGREGATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGGREGATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAggregate_00003() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGGREGATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGGREGATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAggregate_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .removeAggregate()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGGREGATE_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAggregateClientCharacteristicConfiguration_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGGREGATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGGREGATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAggregateClientCharacteristicConfiguration_00002() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGGREGATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGGREGATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAggregateClientCharacteristicConfiguration_00003() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .addAggregateClientCharacteristicConfiguration(BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGGREGATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGGREGATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(value, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAggregateClientCharacteristicConfiguration_00004() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalClientCharacteristicConfiguration(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .addAggregateClientCharacteristicConfiguration(BluetoothGatt.GATT_SUCCESS
                            , 0,
                            clientCharacteristicConfiguration.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGGREGATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGGREGATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(value, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAggregateClientCharacteristicConfiguration_00001() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);
        byte[] value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .addAggregateClientCharacteristicConfiguration(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , clientCharacteristicConfiguration.getBytes())
                    .removeAggregateClientCharacteristicConfiguration()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGGREGATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGGREGATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAggregateClientCharacteristicConfiguration_00002() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);
        byte[] value = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .addAggregateClientCharacteristicConfiguration(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , clientCharacteristicConfiguration.getBytes())
                    .removeAggregateClientCharacteristicConfiguration()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGGREGATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGGREGATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAggregateClientCharacteristicConfiguration_00003() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .removeAggregateClientCharacteristicConfiguration()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGGREGATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGGREGATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAggregateClientCharacteristicConfiguration_00004() {
        Digital digital = new Digital(new byte[]{0b00000001});
        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(1);

        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AutomationIOServiceMockCallback callback = new AutomationIOServiceMockCallback.Builder<>()
                    .addDigital(0
                            , BluetoothGattCharacteristic.PROPERTY_READ
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , digital.getBytes())
                    .addDigitalNumberOfDigitals(0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , numberOfDigitals.getBytes())
                    .addAggregate(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .removeAggregateClientCharacteristicConfiguration()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(AUTOMATION_IO_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGGREGATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(AGGREGATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

}