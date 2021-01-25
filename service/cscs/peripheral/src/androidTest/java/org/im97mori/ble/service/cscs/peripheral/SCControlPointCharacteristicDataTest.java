package org.im97mori.ble.service.cscs.peripheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SC_CONTROL_POINT_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SCControlPointCharacteristicDataTest {

    @Test
    public void test_constructor_00001() {
        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        Gson gson = new Gson();
        SCControlPointCharacteristicData result2 = gson.fromJson(gson.toJson(result1), SCControlPointCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertTrue(result2.descriptorDataList.isEmpty());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.setCumulativeValueResponseValue, result2.setCumulativeValueResponseValue);
        assertEquals(result1.updateSensorLocationResponseValue, result2.updateSensorLocationResponseValue);
        assertEquals(result1.requestSupportedSensorLocationsResponseValue, result2.requestSupportedSensorLocationsResponseValue);
        assertArrayEquals(result1.requestSupportedSensorLocationsResponseParameter, result2.requestSupportedSensorLocationsResponseParameter);
    }

    @Test
    public void test_constructor_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        Gson gson = new Gson();
        SCControlPointCharacteristicData result2 = gson.fromJson(gson.toJson(result1), SCControlPointCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result1.descriptorDataList);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.setCumulativeValueResponseValue, result2.setCumulativeValueResponseValue);
        assertEquals(result1.updateSensorLocationResponseValue, result2.updateSensorLocationResponseValue);
        assertEquals(result1.requestSupportedSensorLocationsResponseValue, result2.requestSupportedSensorLocationsResponseValue);
        assertArrayEquals(result1.requestSupportedSensorLocationsResponseParameter, result2.requestSupportedSensorLocationsResponseParameter);
    }

    @Test
    public void test_setCumulativeValueResponseValue_00001() {
        int firstSetCumulativeValueResponseValue = 3;
        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , firstSetCumulativeValueResponseValue
                , 4
                , 5
                , new byte[]{6});

        assertEquals(firstSetCumulativeValueResponseValue, result1.setCumulativeValueResponseValue);

        int secondSetCumulativeValueResponseValue = 33;
        result1.setCumulativeValueResponseValue = secondSetCumulativeValueResponseValue;
        assertEquals(secondSetCumulativeValueResponseValue, result1.setCumulativeValueResponseValue);
    }

    @Test
    public void test_updateSensorLocationResponseValue_00001() {
        int firstUpdateSensorLocationResponseValue = 4;
        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , firstUpdateSensorLocationResponseValue
                , 5
                , new byte[]{6});

        assertEquals(firstUpdateSensorLocationResponseValue, result1.updateSensorLocationResponseValue);

        int secondUpdateSensorLocationResponseValue = 44;
        result1.updateSensorLocationResponseValue = secondUpdateSensorLocationResponseValue;
        assertEquals(secondUpdateSensorLocationResponseValue, result1.updateSensorLocationResponseValue);
    }

    @Test
    public void test_requestSupportedSensorLocationsResponseValue_00001() {
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , firstRequestSupportedSensorLocationsResponseValue
                , new byte[]{6});

        assertEquals(firstRequestSupportedSensorLocationsResponseValue, result1.requestSupportedSensorLocationsResponseValue);

        int secondRequestSupportedSensorLocationsResponseValue = 55;
        result1.requestSupportedSensorLocationsResponseValue = secondRequestSupportedSensorLocationsResponseValue;
        assertEquals(secondRequestSupportedSensorLocationsResponseValue, result1.requestSupportedSensorLocationsResponseValue);
    }

    @Test
    public void test_requestSupportedSensorLocationsResponseParameter_00001() {
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , firstRequestSupportedSensorLocationsResponseParameter);

        assertArrayEquals(firstRequestSupportedSensorLocationsResponseParameter, result1.requestSupportedSensorLocationsResponseParameter);

        byte[] secondRequestSupportedSensorLocationsResponseParameter = new byte[]{66};
        result1.requestSupportedSensorLocationsResponseParameter = secondRequestSupportedSensorLocationsResponseParameter;
        assertArrayEquals(secondRequestSupportedSensorLocationsResponseParameter, result1.requestSupportedSensorLocationsResponseParameter);
    }

    @Test
    public void test_getBytes_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE
                , 0
                , 0
                , SCControlPoint.OP_CODE_RESPONSE_CODE
                , SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetCumulativeValueResponseValue = 3;
        SCControlPointCharacteristicData scControlPointCharacteristicData = new SCControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , firstSetCumulativeValueResponseValue
                , 4
                , 5
                , new byte[]{6});
        assertArrayEquals(firstData, scControlPointCharacteristicData.getBytes());

        byte[] secondData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE
                , 0
                , 0
                , SCControlPoint.OP_CODE_SET_CUMULATIVE_VALUE
                , firstSetCumulativeValueResponseValue
                , new byte[0]).getBytes();
        scControlPointCharacteristicData.currentData = new SCControlPoint(SCControlPoint.OP_CODE_SET_CUMULATIVE_VALUE
                , 0
                , 0
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, scControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE
                , 0
                , 0
                , SCControlPoint.OP_CODE_RESPONSE_CODE
                , SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstUpdateSensorLocationResponseValue = 4;
        SCControlPointCharacteristicData scControlPointCharacteristicData = new SCControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , firstUpdateSensorLocationResponseValue
                , 5
                , new byte[]{6});
        assertArrayEquals(firstData, scControlPointCharacteristicData.getBytes());

        byte[] secondData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE
                , 0
                , 0
                , SCControlPoint.OP_CODE_UPDATE_SENSOR_LOCATION
                , firstUpdateSensorLocationResponseValue
                , new byte[0]).getBytes();
        scControlPointCharacteristicData.currentData = new SCControlPoint(SCControlPoint.OP_CODE_UPDATE_SENSOR_LOCATION
                , 0
                , 0
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, scControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00003() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE
                , 0
                , 0
                , SCControlPoint.OP_CODE_RESPONSE_CODE
                , SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        SCControlPointCharacteristicData scControlPointCharacteristicData = new SCControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        assertArrayEquals(firstData, scControlPointCharacteristicData.getBytes());

        byte[] secondData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE
                , 0
                , 0
                , SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter).getBytes();
        scControlPointCharacteristicData.currentData = new SCControlPoint(SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS
                , 0
                , 0
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, scControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00004() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE
                , 0
                , 0
                , SCControlPoint.OP_CODE_RESPONSE_CODE
                , SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        SCControlPointCharacteristicData scControlPointCharacteristicData = new SCControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});
        assertArrayEquals(firstData, scControlPointCharacteristicData.getBytes());

        byte[] secondData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE
                , 0
                , 0
                , SCControlPoint.OP_CODE_RESPONSE_CODE + 1
                , SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        scControlPointCharacteristicData.currentData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE + 1
                , 0
                , 0
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, scControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00005() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE
                , 0
                , 0
                , SCControlPoint.OP_CODE_RESPONSE_CODE
                , SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        SCControlPointCharacteristicData scControlPointCharacteristicData = new SCControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});
        assertArrayEquals(firstData, scControlPointCharacteristicData.getBytes());
        assertNull(scControlPointCharacteristicData.highPriorityResponseData);

        byte[] secondData = new byte[]{100};
        scControlPointCharacteristicData.highPriorityResponseData = secondData;
        assertNotNull(scControlPointCharacteristicData.highPriorityResponseData);
        assertArrayEquals(secondData, scControlPointCharacteristicData.getBytes());
        assertNull(scControlPointCharacteristicData.highPriorityResponseData);
    }

    @Test
    public void test_parcelable_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPointCharacteristicData result2 = SCControlPointCharacteristicData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result1.descriptorDataList);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.setCumulativeValueResponseValue, result2.setCumulativeValueResponseValue);
        assertEquals(result1.updateSensorLocationResponseValue, result2.updateSensorLocationResponseValue);
        assertEquals(result1.requestSupportedSensorLocationsResponseValue, result2.requestSupportedSensorLocationsResponseValue);
        assertArrayEquals(result1.requestSupportedSensorLocationsResponseParameter, result2.requestSupportedSensorLocationsResponseParameter);
    }

    @Test
    public void test_parcelable_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPointCharacteristicData result2 = SCControlPointCharacteristicData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result1.descriptorDataList);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        result1.descriptorDataList.clear();
        assertNotEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.setCumulativeValueResponseValue, result2.setCumulativeValueResponseValue);
        assertEquals(result1.updateSensorLocationResponseValue, result2.updateSensorLocationResponseValue);
        assertEquals(result1.requestSupportedSensorLocationsResponseValue, result2.requestSupportedSensorLocationsResponseValue);
        assertArrayEquals(result1.requestSupportedSensorLocationsResponseParameter, result2.requestSupportedSensorLocationsResponseParameter);
    }

    @Test
    public void test_hashCode_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int responseCode = 1;
        long delay = 2;
        int setCumulativeValueResponseValue = 3;
        int updateSensorLocationResponseValue = 4;
        int requestSupportedSensorLocationsResponseValue = 5;
        byte[] requestSupportedSensorLocationsResponseParameter = new byte[]{6};

        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , updateSensorLocationResponseValue
                , requestSupportedSensorLocationsResponseValue
                , requestSupportedSensorLocationsResponseParameter);

        assertEquals(SC_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE).hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PERMISSION_WRITE).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(0).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(setCumulativeValueResponseValue).hashCode()
                        ^ Integer.valueOf(updateSensorLocationResponseValue).hashCode()
                        ^ Integer.valueOf(requestSupportedSensorLocationsResponseValue).hashCode()
                        ^ Arrays.hashCode(requestSupportedSensorLocationsResponseParameter)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int responseCode = 1;
        long delay = 2;
        int setCumulativeValueResponseValue = 3;
        int updateSensorLocationResponseValue = 4;
        int requestSupportedSensorLocationsResponseValue = 5;
        byte[] requestSupportedSensorLocationsResponseParameter = new byte[]{6};
        byte[] currentData = new byte[]{28};
        byte[] temporaryData = new byte[]{29};

        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , updateSensorLocationResponseValue
                , requestSupportedSensorLocationsResponseValue
                , requestSupportedSensorLocationsResponseParameter);

        result1.currentData = currentData;
        result1.temporaryData = temporaryData;

        assertEquals(SC_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE).hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PERMISSION_WRITE).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(0).hashCode()
                        ^ Arrays.hashCode(currentData)
                        ^ Arrays.hashCode(temporaryData)
                        ^ Integer.valueOf(setCumulativeValueResponseValue).hashCode()
                        ^ Integer.valueOf(updateSensorLocationResponseValue).hashCode()
                        ^ Integer.valueOf(requestSupportedSensorLocationsResponseValue).hashCode()
                        ^ Arrays.hashCode(requestSupportedSensorLocationsResponseParameter)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};

        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        SCControlPointCharacteristicData result2 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 32, 33, 34, new byte[]{35}));

        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        SCControlPointCharacteristicData result2 = new SCControlPointCharacteristicData(secondDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};

        int secondResponseCode = 101;

        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        SCControlPointCharacteristicData result2 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , secondResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};

        long secondDelay = 102;

        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        SCControlPointCharacteristicData result2 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , secondDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};

        int secondSetCumulativeValueResponseValue = 103;

        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        SCControlPointCharacteristicData result2 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , secondSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};

        int secondUpdateSensorLocationResponseValue = 104;

        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        SCControlPointCharacteristicData result2 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , secondUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};

        int secondRequestSupportedSensorLocationsResponseValue = 105;

        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        SCControlPointCharacteristicData result2 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , secondRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00008() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};

        byte[] secondRequestSupportedSensorLocationsResponseParameter = new byte[]{106};

        SCControlPointCharacteristicData result1 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter);
        SCControlPointCharacteristicData result2 = new SCControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , secondRequestSupportedSensorLocationsResponseParameter);
        assertNotEquals(result1, result2);
    }

}
