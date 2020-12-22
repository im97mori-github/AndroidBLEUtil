package org.im97mori.ble.service.cps.peripheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.characteristic.u2a66.CyclingPowerControlPoint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CyclingPowerControlPointCharacteristicDataTest {

    @Test
    public void test_constructor_00001() {
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        Gson gson = new Gson();
        CyclingPowerControlPointCharacteristicData result2 = gson.fromJson(gson.toJson(result1), CyclingPowerControlPointCharacteristicData.class);

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
        assertEquals(result1.setCrankLengthResponseValue, result2.setCrankLengthResponseValue);
        assertEquals(result1.requestCrankLengthResponseValue, result2.requestCrankLengthResponseValue);
        assertArrayEquals(result1.requestCrankLengthResponseParameter, result2.requestCrankLengthResponseParameter);
        assertEquals(result1.setChainLengthResponseValue, result2.setChainLengthResponseValue);
        assertEquals(result1.requestChainLengthResponseValue, result2.requestChainLengthResponseValue);
        assertArrayEquals(result1.requestChainLengthResponseParameter, result2.requestChainLengthResponseParameter);
        assertEquals(result1.setChainWeightResponseValue, result2.setChainWeightResponseValue);
        assertEquals(result1.requestChainWeightResponseValue, result2.requestChainWeightResponseValue);
        assertArrayEquals(result1.requestChainWeightResponseParameter, result2.requestChainWeightResponseParameter);
        assertEquals(result1.setSpanLengthResponseValue, result2.setSpanLengthResponseValue);
        assertEquals(result1.requestSpanLengthResponseValue, result2.requestSpanLengthResponseValue);
        assertArrayEquals(result1.requestSpanLengthResponseParameter, result2.requestSpanLengthResponseParameter);
        assertEquals(result1.startOffsetCompensationResponseValue, result2.startOffsetCompensationResponseValue);
        assertArrayEquals(result1.startOffsetCompensationResponseParameter, result2.startOffsetCompensationResponseParameter);
        assertEquals(result1.maskCyclingPowerMeasurementCharacteristicContentResponseValue, result2.maskCyclingPowerMeasurementCharacteristicContentResponseValue);
        assertEquals(result1.requestSamplingRateResponseValue, result2.requestSamplingRateResponseValue);
        assertArrayEquals(result1.requestSamplingRateResponseParameter, result2.requestSamplingRateResponseParameter);
        assertEquals(result1.requestFactoryCalibrationDateResponseValue, result2.requestFactoryCalibrationDateResponseValue);
        assertArrayEquals(result1.requestFactoryCalibrationDateResponseParameter, result2.requestFactoryCalibrationDateResponseParameter);
        assertEquals(result1.startEnhancedOffsetCompensationResponseValue, result2.startEnhancedOffsetCompensationResponseValue);
        assertArrayEquals(result1.startEnhancedOffsetCompensationResponseParameter, result2.startEnhancedOffsetCompensationResponseParameter);
    }

    @Test
    public void test_constructor_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        Gson gson = new Gson();
        CyclingPowerControlPointCharacteristicData result2 = gson.fromJson(gson.toJson(result1), CyclingPowerControlPointCharacteristicData.class);

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
        assertEquals(result1.setCrankLengthResponseValue, result2.setCrankLengthResponseValue);
        assertEquals(result1.requestCrankLengthResponseValue, result2.requestCrankLengthResponseValue);
        assertArrayEquals(result1.requestCrankLengthResponseParameter, result2.requestCrankLengthResponseParameter);
        assertEquals(result1.setChainLengthResponseValue, result2.setChainLengthResponseValue);
        assertEquals(result1.requestChainLengthResponseValue, result2.requestChainLengthResponseValue);
        assertArrayEquals(result1.requestChainLengthResponseParameter, result2.requestChainLengthResponseParameter);
        assertEquals(result1.setChainWeightResponseValue, result2.setChainWeightResponseValue);
        assertEquals(result1.requestChainWeightResponseValue, result2.requestChainWeightResponseValue);
        assertArrayEquals(result1.requestChainWeightResponseParameter, result2.requestChainWeightResponseParameter);
        assertEquals(result1.setSpanLengthResponseValue, result2.setSpanLengthResponseValue);
        assertEquals(result1.requestSpanLengthResponseValue, result2.requestSpanLengthResponseValue);
        assertArrayEquals(result1.requestSpanLengthResponseParameter, result2.requestSpanLengthResponseParameter);
        assertEquals(result1.startOffsetCompensationResponseValue, result2.startOffsetCompensationResponseValue);
        assertArrayEquals(result1.startOffsetCompensationResponseParameter, result2.startOffsetCompensationResponseParameter);
        assertEquals(result1.maskCyclingPowerMeasurementCharacteristicContentResponseValue, result2.maskCyclingPowerMeasurementCharacteristicContentResponseValue);
        assertEquals(result1.requestSamplingRateResponseValue, result2.requestSamplingRateResponseValue);
        assertArrayEquals(result1.requestSamplingRateResponseParameter, result2.requestSamplingRateResponseParameter);
        assertEquals(result1.requestFactoryCalibrationDateResponseValue, result2.requestFactoryCalibrationDateResponseValue);
        assertArrayEquals(result1.requestFactoryCalibrationDateResponseParameter, result2.requestFactoryCalibrationDateResponseParameter);
        assertEquals(result1.startEnhancedOffsetCompensationResponseValue, result2.startEnhancedOffsetCompensationResponseValue);
        assertArrayEquals(result1.startEnhancedOffsetCompensationResponseParameter, result2.startEnhancedOffsetCompensationResponseParameter);
    }

    @Test
    public void test_setCumulativeValueResponseValue_00001() {
        int firstSetCumulativeValueResponseValue = 3;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , firstSetCumulativeValueResponseValue
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstSetCumulativeValueResponseValue, result1.setCumulativeValueResponseValue);

        int secondSetCumulativeValueResponseValue = 33;
        result1.setCumulativeValueResponseValue = secondSetCumulativeValueResponseValue;
        assertEquals(secondSetCumulativeValueResponseValue, result1.setCumulativeValueResponseValue);
    }

    @Test
    public void test_updateSensorLocationResponseValue_00001() {
        int firstUpdateSensorLocationResponseValue = 4;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , firstUpdateSensorLocationResponseValue
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstUpdateSensorLocationResponseValue, result1.updateSensorLocationResponseValue);

        int secondUpdateSensorLocationResponseValue = 44;
        result1.updateSensorLocationResponseValue = secondUpdateSensorLocationResponseValue;
        assertEquals(secondUpdateSensorLocationResponseValue, result1.updateSensorLocationResponseValue);
    }

    @Test
    public void test_requestSupportedSensorLocationsResponseValue_00001() {
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , firstRequestSupportedSensorLocationsResponseValue
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstRequestSupportedSensorLocationsResponseValue, result1.requestSupportedSensorLocationsResponseValue);

        int secondRequestSupportedSensorLocationsResponseValue = 55;
        result1.requestSupportedSensorLocationsResponseValue = secondRequestSupportedSensorLocationsResponseValue;
        assertEquals(secondRequestSupportedSensorLocationsResponseValue, result1.requestSupportedSensorLocationsResponseValue);
    }

    @Test
    public void test_requestSupportedSensorLocationsResponseParameter_00001() {
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , firstRequestSupportedSensorLocationsResponseParameter
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertArrayEquals(firstRequestSupportedSensorLocationsResponseParameter, result1.requestSupportedSensorLocationsResponseParameter);

        byte[] secondRequestSupportedSensorLocationsResponseParameter = new byte[]{66};
        result1.requestSupportedSensorLocationsResponseParameter = secondRequestSupportedSensorLocationsResponseParameter;
        assertArrayEquals(secondRequestSupportedSensorLocationsResponseParameter, result1.requestSupportedSensorLocationsResponseParameter);
    }

    @Test
    public void test_setCrankLengthResponseValue_00001() {
        int firstSetCrankLengthResponseValue = 7;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , firstSetCrankLengthResponseValue
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstSetCrankLengthResponseValue, result1.setCrankLengthResponseValue);

        int secondSetCrankLengthResponseValue = 77;
        result1.setCrankLengthResponseValue = secondSetCrankLengthResponseValue;
        assertEquals(secondSetCrankLengthResponseValue, result1.setCrankLengthResponseValue);
    }

    @Test
    public void test_requestCrankLengthResponseValue_00001() {
        int firstRequestCrankLengthResponseValue = 8;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , firstRequestCrankLengthResponseValue
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstRequestCrankLengthResponseValue, result1.requestCrankLengthResponseValue);

        int secondRequestCrankLengthResponseValue = 88;
        result1.requestCrankLengthResponseValue = secondRequestCrankLengthResponseValue;
        assertEquals(secondRequestCrankLengthResponseValue, result1.requestCrankLengthResponseValue);
    }

    @Test
    public void test_requestCrankLengthResponseParameter_00001() {
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , firstRequestCrankLengthResponseParameter
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertArrayEquals(firstRequestCrankLengthResponseParameter, result1.requestCrankLengthResponseParameter);

        byte[] secondRequestCrankLengthResponseParameter = new byte[]{99};
        result1.requestCrankLengthResponseParameter = secondRequestCrankLengthResponseParameter;
        assertArrayEquals(secondRequestCrankLengthResponseParameter, result1.requestCrankLengthResponseParameter);
    }

    @Test
    public void test_setChainLengthResponseValue_00001() {
        int firstSetChainLengthResponseValue = 10;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , firstSetChainLengthResponseValue
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstSetChainLengthResponseValue, result1.setChainLengthResponseValue);

        int secondSetChainLengthResponseValue = 100;
        result1.setChainLengthResponseValue = secondSetChainLengthResponseValue;
        assertEquals(secondSetChainLengthResponseValue, result1.setChainLengthResponseValue);
    }

    @Test
    public void test_requestChainLengthResponseValue_00001() {
        int firstRequestChainLengthResponseValue = 11;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , firstRequestChainLengthResponseValue
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstRequestChainLengthResponseValue, result1.requestChainLengthResponseValue);

        int secondRequestChainLengthResponseValue = 111;
        result1.requestChainLengthResponseValue = secondRequestChainLengthResponseValue;
        assertEquals(secondRequestChainLengthResponseValue, result1.requestChainLengthResponseValue);
    }

    @Test
    public void test_requestChainLengthResponseParameter_00001() {
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , firstRequestChainLengthResponseParameter
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertArrayEquals(firstRequestChainLengthResponseParameter, result1.requestChainLengthResponseParameter);

        byte[] secondRequestChainLengthResponseParameter = new byte[]{122};
        result1.requestChainLengthResponseParameter = secondRequestChainLengthResponseParameter;
        assertArrayEquals(secondRequestChainLengthResponseParameter, result1.requestChainLengthResponseParameter);
    }

    @Test
    public void test_setChainWeightResponseValue_00001() {
        int firstSetChainWeightResponseValue = 13;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , firstSetChainWeightResponseValue
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstSetChainWeightResponseValue, result1.setChainWeightResponseValue);

        int secondSetChainWeightResponseValue = 133;
        result1.setChainWeightResponseValue = secondSetChainWeightResponseValue;
        assertEquals(secondSetChainWeightResponseValue, result1.setChainWeightResponseValue);
    }

    @Test
    public void test_requestChainWeightResponseValue_00001() {
        int firstRequestChainWeightResponseValue = 14;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , firstRequestChainWeightResponseValue
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstRequestChainWeightResponseValue, result1.requestChainWeightResponseValue);

        int secondRequestChainWeightResponseValue = 144;
        result1.requestChainWeightResponseValue = secondRequestChainWeightResponseValue;
        assertEquals(secondRequestChainWeightResponseValue, result1.requestChainWeightResponseValue);
    }

    @Test
    public void test_requestChainWeightResponseParameter_00001() {
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , firstRequestChainWeightResponseParameter
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertArrayEquals(firstRequestChainWeightResponseParameter, result1.requestChainWeightResponseParameter);

        byte[] secondRequestChainWeightResponseParameter = new byte[]{55};
        result1.requestChainWeightResponseParameter = secondRequestChainWeightResponseParameter;
        assertArrayEquals(secondRequestChainWeightResponseParameter, result1.requestChainWeightResponseParameter);
    }

    @Test
    public void test_setSpanLengthResponseValue_00001() {
        int firstSetSpanLengthResponseValue = 16;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , firstSetSpanLengthResponseValue
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstSetSpanLengthResponseValue, result1.setSpanLengthResponseValue);

        int secondSetSpanLengthResponseValue = 144;
        result1.setSpanLengthResponseValue = secondSetSpanLengthResponseValue;
        assertEquals(secondSetSpanLengthResponseValue, result1.setSpanLengthResponseValue);
    }

    @Test
    public void test_requestSpanLengthResponseValue_00001() {
        int firstRequestSpanLengthResponseValue = 17;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , firstRequestSpanLengthResponseValue
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstRequestSpanLengthResponseValue, result1.requestSpanLengthResponseValue);

        int secondRequestSpanLengthResponseValue = 77;
        result1.requestSpanLengthResponseValue = secondRequestSpanLengthResponseValue;
        assertEquals(secondRequestSpanLengthResponseValue, result1.requestSpanLengthResponseValue);
    }

    @Test
    public void test_requestSpanLengthResponseParameter_00001() {
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , firstRequestSpanLengthResponseParameter
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertArrayEquals(firstRequestSpanLengthResponseParameter, result1.requestSpanLengthResponseParameter);

        byte[] secondRequestSpanLengthResponseParameter = new byte[]{88};
        result1.requestSpanLengthResponseParameter = secondRequestSpanLengthResponseParameter;
        assertArrayEquals(secondRequestSpanLengthResponseParameter, result1.requestSpanLengthResponseParameter);
    }

    @Test
    public void test_startOffsetCompensationResponseValue_00001() {
        int firstStartOffsetCompensationResponseValue = 19;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , firstStartOffsetCompensationResponseValue
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstStartOffsetCompensationResponseValue, result1.startOffsetCompensationResponseValue);

        int secondStartOffsetCompensationResponseValue = 99;
        result1.startOffsetCompensationResponseValue = secondStartOffsetCompensationResponseValue;
        assertEquals(secondStartOffsetCompensationResponseValue, result1.startOffsetCompensationResponseValue);
    }

    @Test
    public void test_startOffsetCompensationResponseParameter_00001() {
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , firstStartOffsetCompensationResponseParameter
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertArrayEquals(firstStartOffsetCompensationResponseParameter, result1.startOffsetCompensationResponseParameter);

        byte[] secondStartOffsetCompensationResponseParameter = new byte[]{0};
        result1.startOffsetCompensationResponseParameter = secondStartOffsetCompensationResponseParameter;
        assertArrayEquals(secondStartOffsetCompensationResponseParameter, result1.startOffsetCompensationResponseParameter);
    }

    @Test
    public void test_maskCyclingPowerMeasurementCharacteristicContentResponseValue_00001() {
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue, result1.maskCyclingPowerMeasurementCharacteristicContentResponseValue);

        int secondMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 211;
        result1.maskCyclingPowerMeasurementCharacteristicContentResponseValue = secondMaskCyclingPowerMeasurementCharacteristicContentResponseValue;
        assertEquals(secondMaskCyclingPowerMeasurementCharacteristicContentResponseValue, result1.maskCyclingPowerMeasurementCharacteristicContentResponseValue);
    }

    @Test
    public void test_requestSamplingRateResponseValue_00001() {
        int firstRequestSamplingRateResponseValue = 22;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , firstRequestSamplingRateResponseValue
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstRequestSamplingRateResponseValue, result1.requestSamplingRateResponseValue);

        int secondRequestSamplingRateResponseValue = 211;
        result1.requestSamplingRateResponseValue = secondRequestSamplingRateResponseValue;
        assertEquals(secondRequestSamplingRateResponseValue, result1.requestSamplingRateResponseValue);
    }

    @Test
    public void test_requestSamplingRateResponseParameter_00001() {
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , firstRequestSamplingRateResponseParameter
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertArrayEquals(firstRequestSamplingRateResponseParameter, result1.requestSamplingRateResponseParameter);

        byte[] secondRequestSamplingRateResponseParameter = new byte[]{33};
        result1.requestSamplingRateResponseParameter = secondRequestSamplingRateResponseParameter;
        assertArrayEquals(secondRequestSamplingRateResponseParameter, result1.requestSamplingRateResponseParameter);
    }

    @Test
    public void test_requestFactoryCalibrationDateResponseValue_00001() {
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , firstRequestFactoryCalibrationDateResponseValue
                , new byte[]{25}
                , 26
                , new byte[]{27});

        assertEquals(firstRequestFactoryCalibrationDateResponseValue, result1.requestFactoryCalibrationDateResponseValue);

        int secondRequestFactoryCalibrationDateResponseValue = 44;
        result1.requestFactoryCalibrationDateResponseValue = secondRequestFactoryCalibrationDateResponseValue;
        assertEquals(secondRequestFactoryCalibrationDateResponseValue, result1.requestFactoryCalibrationDateResponseValue);
    }

    @Test
    public void test_requestFactoryCalibrationDateResponseParameter_00001() {
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , firstRequestFactoryCalibrationDateResponseParameter
                , 26
                , new byte[]{27});

        assertArrayEquals(firstRequestFactoryCalibrationDateResponseParameter, result1.requestFactoryCalibrationDateResponseParameter);

        byte[] secondRequestFactoryCalibrationDateResponseParameter = new byte[]{55};
        result1.requestFactoryCalibrationDateResponseParameter = secondRequestFactoryCalibrationDateResponseParameter;
        assertArrayEquals(secondRequestFactoryCalibrationDateResponseParameter, result1.requestFactoryCalibrationDateResponseParameter);
    }

    @Test
    public void test_startEnhancedOffsetCompensationResponseValue_00001() {
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , firstStartEnhancedOffsetCompensationResponseValue
                , new byte[]{27});

        assertEquals(firstStartEnhancedOffsetCompensationResponseValue, result1.startEnhancedOffsetCompensationResponseValue);

        int secondStartEnhancedOffsetCompensationResponseValue = 44;
        result1.startEnhancedOffsetCompensationResponseValue = secondStartEnhancedOffsetCompensationResponseValue;
        assertEquals(secondStartEnhancedOffsetCompensationResponseValue, result1.startEnhancedOffsetCompensationResponseValue);
    }

    @Test
    public void test_startEnhancedOffsetCompensationResponseParameter_00001() {
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(new ArrayList<DescriptorData>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , firstStartEnhancedOffsetCompensationResponseParameter);

        assertArrayEquals(firstStartEnhancedOffsetCompensationResponseParameter, result1.startEnhancedOffsetCompensationResponseParameter);

        byte[] secondStartEnhancedOffsetCompensationResponseParameter = new byte[]{77};
        result1.startEnhancedOffsetCompensationResponseParameter = secondStartEnhancedOffsetCompensationResponseParameter;
        assertArrayEquals(secondStartEnhancedOffsetCompensationResponseParameter, result1.startEnhancedOffsetCompensationResponseParameter);
    }

    @Test
    public void test_getBytes_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetCumulativeValueResponseValue = 3;
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , firstSetCumulativeValueResponseValue
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE
                , firstSetCumulativeValueResponseValue
                , new byte[0]).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE
                , new byte[4]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstUdateSensorLocationResponseValue = 4;
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , firstUdateSensorLocationResponseValue
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_UPDATE_SENSOR_LOCATION
                , firstUdateSensorLocationResponseValue
                , new byte[0]).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_UPDATE_SENSOR_LOCATION
                , new byte[1]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00003() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstRequestSupportedSensorLocationsResponseValue = 4;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_REQUEST_SUPPORTED_SENSOR_LOCATION
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_REQUEST_SUPPORTED_SENSOR_LOCATION
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00004() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetCrankLengthResponseValue = 7;
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , firstSetCrankLengthResponseValue
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_SET_CRANK_LENGTH
                , firstSetCrankLengthResponseValue
                , new byte[0]).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_SET_CRANK_LENGTH
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00005() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_REQUEST_CRANK_LENGTH
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_REQUEST_CRANK_LENGTH
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00006() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetChainLengthResponseValue = 10;
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , firstSetChainLengthResponseValue
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_SET_CHAIN_LENGTH
                , firstSetChainLengthResponseValue
                , new byte[0]).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_SET_CHAIN_LENGTH
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00007() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_LENGTH
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_LENGTH
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00008() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetChainWeightResponseValue = 13;
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , firstSetChainWeightResponseValue
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_SET_CHAIN_WEIGHT
                , firstSetChainWeightResponseValue
                , new byte[0]).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_SET_CHAIN_WEIGHT
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00009() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_WEIGHT
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_WEIGHT
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00010() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetSpanLengthResponseValue = 16;
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , firstSetSpanLengthResponseValue
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_SET_SPAN_LENGTH
                , firstSetSpanLengthResponseValue
                , new byte[0]).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_SET_SPAN_LENGTH
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00011() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_REQUEST_SPAN_LENGTH
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_REQUEST_SPAN_LENGTH
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00012() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_START_OFFSET_COMPENSATION
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_START_OFFSET_COMPENSATION
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00013() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , new byte[0]).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00014() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_REQUEST_SAMPLING_RATE
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_REQUEST_SAMPLING_RATE
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00015() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_REQUEST_FACTORY_CALIBRATION_DATE
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_REQUEST_FACTORY_CALIBRATION_DATE
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00016() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_START_ENHANCED_OFFSET_COMPENSATION
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_START_ENHANCED_OFFSET_COMPENSATION
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00017() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());

        byte[] secondData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE + 1
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        cyclingPowerControlPointCharacteristicData.currentData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE + 1
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00018() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        byte[] firstData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , new byte[0]
                , CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE
                , CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        assertArrayEquals(firstData, cyclingPowerControlPointCharacteristicData.getBytes());
        assertNull(cyclingPowerControlPointCharacteristicData.highPriorityResponseData);

        byte[] secondData = new byte[]{100};
        cyclingPowerControlPointCharacteristicData.highPriorityResponseData = secondData;
        assertNotNull(cyclingPowerControlPointCharacteristicData.highPriorityResponseData);
        assertArrayEquals(secondData, cyclingPowerControlPointCharacteristicData.getBytes());
        assertNull(cyclingPowerControlPointCharacteristicData.highPriorityResponseData);
    }

    @Test
    public void test_parcelable_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointCharacteristicData result2 = CyclingPowerControlPointCharacteristicData.CREATOR.createFromParcel(parcel);

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
        assertEquals(result1.setCrankLengthResponseValue, result2.setCrankLengthResponseValue);
        assertEquals(result1.requestCrankLengthResponseValue, result2.requestCrankLengthResponseValue);
        assertArrayEquals(result1.requestCrankLengthResponseParameter, result2.requestCrankLengthResponseParameter);
        assertEquals(result1.setChainLengthResponseValue, result2.setChainLengthResponseValue);
        assertEquals(result1.requestChainLengthResponseValue, result2.requestChainLengthResponseValue);
        assertArrayEquals(result1.requestChainLengthResponseParameter, result2.requestChainLengthResponseParameter);
        assertEquals(result1.setChainWeightResponseValue, result2.setChainWeightResponseValue);
        assertEquals(result1.requestChainWeightResponseValue, result2.requestChainWeightResponseValue);
        assertArrayEquals(result1.requestChainWeightResponseParameter, result2.requestChainWeightResponseParameter);
        assertEquals(result1.setSpanLengthResponseValue, result2.setSpanLengthResponseValue);
        assertEquals(result1.requestSpanLengthResponseValue, result2.requestSpanLengthResponseValue);
        assertArrayEquals(result1.requestSpanLengthResponseParameter, result2.requestSpanLengthResponseParameter);
        assertEquals(result1.startOffsetCompensationResponseValue, result2.startOffsetCompensationResponseValue);
        assertArrayEquals(result1.startOffsetCompensationResponseParameter, result2.startOffsetCompensationResponseParameter);
        assertEquals(result1.maskCyclingPowerMeasurementCharacteristicContentResponseValue, result2.maskCyclingPowerMeasurementCharacteristicContentResponseValue);
        assertEquals(result1.requestSamplingRateResponseValue, result2.requestSamplingRateResponseValue);
        assertArrayEquals(result1.requestSamplingRateResponseParameter, result2.requestSamplingRateResponseParameter);
        assertEquals(result1.requestFactoryCalibrationDateResponseValue, result2.requestFactoryCalibrationDateResponseValue);
        assertArrayEquals(result1.requestFactoryCalibrationDateResponseParameter, result2.requestFactoryCalibrationDateResponseParameter);
        assertEquals(result1.startEnhancedOffsetCompensationResponseValue, result2.startEnhancedOffsetCompensationResponseValue);
        assertArrayEquals(result1.startEnhancedOffsetCompensationResponseParameter, result2.startEnhancedOffsetCompensationResponseParameter);
    }

    @Test
    public void test_parcelable_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerControlPointCharacteristicData result2 = CyclingPowerControlPointCharacteristicData.CREATOR.createFromParcel(parcel);

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
        assertEquals(result1.setCrankLengthResponseValue, result2.setCrankLengthResponseValue);
        assertEquals(result1.requestCrankLengthResponseValue, result2.requestCrankLengthResponseValue);
        assertArrayEquals(result1.requestCrankLengthResponseParameter, result2.requestCrankLengthResponseParameter);
        assertEquals(result1.setChainLengthResponseValue, result2.setChainLengthResponseValue);
        assertEquals(result1.requestChainLengthResponseValue, result2.requestChainLengthResponseValue);
        assertArrayEquals(result1.requestChainLengthResponseParameter, result2.requestChainLengthResponseParameter);
        assertEquals(result1.setChainWeightResponseValue, result2.setChainWeightResponseValue);
        assertEquals(result1.requestChainWeightResponseValue, result2.requestChainWeightResponseValue);
        assertArrayEquals(result1.requestChainWeightResponseParameter, result2.requestChainWeightResponseParameter);
        assertEquals(result1.setSpanLengthResponseValue, result2.setSpanLengthResponseValue);
        assertEquals(result1.requestSpanLengthResponseValue, result2.requestSpanLengthResponseValue);
        assertArrayEquals(result1.requestSpanLengthResponseParameter, result2.requestSpanLengthResponseParameter);
        assertEquals(result1.startOffsetCompensationResponseValue, result2.startOffsetCompensationResponseValue);
        assertArrayEquals(result1.startOffsetCompensationResponseParameter, result2.startOffsetCompensationResponseParameter);
        assertEquals(result1.maskCyclingPowerMeasurementCharacteristicContentResponseValue, result2.maskCyclingPowerMeasurementCharacteristicContentResponseValue);
        assertEquals(result1.requestSamplingRateResponseValue, result2.requestSamplingRateResponseValue);
        assertArrayEquals(result1.requestSamplingRateResponseParameter, result2.requestSamplingRateResponseParameter);
        assertEquals(result1.requestFactoryCalibrationDateResponseValue, result2.requestFactoryCalibrationDateResponseValue);
        assertArrayEquals(result1.requestFactoryCalibrationDateResponseParameter, result2.requestFactoryCalibrationDateResponseParameter);
        assertEquals(result1.startEnhancedOffsetCompensationResponseValue, result2.startEnhancedOffsetCompensationResponseValue);
        assertArrayEquals(result1.startEnhancedOffsetCompensationResponseParameter, result2.startEnhancedOffsetCompensationResponseParameter);
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
        int setCrankLengthResponseValue = 7;
        int requestCrankLengthResponseValue = 8;
        byte[] requestCrankLengthResponseParameter = new byte[]{9};
        int setChainLengthResponseValue = 10;
        int requestChainLengthResponseValue = 11;
        byte[] requestChainLengthResponseParameter = new byte[]{12};
        int setChainWeightResponseValue = 13;
        int requestChainWeightResponseValue = 14;
        byte[] requestChainWeightResponseParameter = new byte[]{15};
        int setSpanLengthResponseValue = 16;
        int requestSpanLengthResponseValue = 17;
        byte[] requestSpanLengthResponseParameter = new byte[]{18};
        int startOffsetCompensationResponseValue = 19;
        byte[] startOffsetCompensationResponseParameter = new byte[]{20};
        int maskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int requestSamplingRateResponseValue = 22;
        byte[] requestSamplingRateResponseParameter = new byte[]{23};
        int requestFactoryCalibrationDateResponseValue = 24;
        byte[] requestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int startEnhancedOffsetCompensationResponseValue = 26;
        byte[] startEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , updateSensorLocationResponseValue
                , requestSupportedSensorLocationsResponseValue
                , requestSupportedSensorLocationsResponseParameter
                , setCrankLengthResponseValue
                , requestCrankLengthResponseValue
                , requestCrankLengthResponseParameter
                , setChainLengthResponseValue
                , requestChainLengthResponseValue
                , requestChainLengthResponseParameter
                , setChainWeightResponseValue
                , requestChainWeightResponseValue
                , requestChainWeightResponseParameter
                , setSpanLengthResponseValue
                , requestSpanLengthResponseValue
                , requestSpanLengthResponseParameter
                , startOffsetCompensationResponseValue
                , startOffsetCompensationResponseParameter
                , maskCyclingPowerMeasurementCharacteristicContentResponseValue
                , requestSamplingRateResponseValue
                , requestSamplingRateResponseParameter
                , requestFactoryCalibrationDateResponseValue
                , requestFactoryCalibrationDateResponseParameter
                , startEnhancedOffsetCompensationResponseValue
                , startEnhancedOffsetCompensationResponseParameter);

        assertEquals(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE).hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PERMISSION_WRITE).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(1).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(setCumulativeValueResponseValue).hashCode()
                        ^ Integer.valueOf(updateSensorLocationResponseValue).hashCode()
                        ^ Integer.valueOf(requestSupportedSensorLocationsResponseValue).hashCode()
                        ^ Arrays.hashCode(requestSupportedSensorLocationsResponseParameter)
                        ^ Integer.valueOf(setCrankLengthResponseValue).hashCode()
                        ^ Integer.valueOf(requestCrankLengthResponseValue).hashCode()
                        ^ Arrays.hashCode(requestCrankLengthResponseParameter)
                        ^ Integer.valueOf(setChainLengthResponseValue).hashCode()
                        ^ Integer.valueOf(requestChainLengthResponseValue).hashCode()
                        ^ Arrays.hashCode(requestChainLengthResponseParameter)
                        ^ Integer.valueOf(setChainWeightResponseValue).hashCode()
                        ^ Integer.valueOf(requestChainWeightResponseValue).hashCode()
                        ^ Arrays.hashCode(requestChainWeightResponseParameter)
                        ^ Integer.valueOf(setSpanLengthResponseValue).hashCode()
                        ^ Integer.valueOf(requestSpanLengthResponseValue).hashCode()
                        ^ Arrays.hashCode(requestSpanLengthResponseParameter)
                        ^ Integer.valueOf(startOffsetCompensationResponseValue).hashCode()
                        ^ Arrays.hashCode(startOffsetCompensationResponseParameter)
                        ^ Integer.valueOf(maskCyclingPowerMeasurementCharacteristicContentResponseValue).hashCode()
                        ^ Integer.valueOf(requestSamplingRateResponseValue).hashCode()
                        ^ Arrays.hashCode(requestSamplingRateResponseParameter)
                        ^ Integer.valueOf(requestFactoryCalibrationDateResponseValue).hashCode()
                        ^ Arrays.hashCode(requestFactoryCalibrationDateResponseParameter)
                        ^ Integer.valueOf(startEnhancedOffsetCompensationResponseValue).hashCode()
                        ^ Arrays.hashCode(startEnhancedOffsetCompensationResponseParameter)
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
        int setCrankLengthResponseValue = 7;
        int requestCrankLengthResponseValue = 8;
        byte[] requestCrankLengthResponseParameter = new byte[]{9};
        int setChainLengthResponseValue = 10;
        int requestChainLengthResponseValue = 11;
        byte[] requestChainLengthResponseParameter = new byte[]{12};
        int setChainWeightResponseValue = 13;
        int requestChainWeightResponseValue = 14;
        byte[] requestChainWeightResponseParameter = new byte[]{15};
        int setSpanLengthResponseValue = 16;
        int requestSpanLengthResponseValue = 17;
        byte[] requestSpanLengthResponseParameter = new byte[]{18};
        int startOffsetCompensationResponseValue = 19;
        byte[] startOffsetCompensationResponseParameter = new byte[]{20};
        int maskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int requestSamplingRateResponseValue = 22;
        byte[] requestSamplingRateResponseParameter = new byte[]{23};
        int requestFactoryCalibrationDateResponseValue = 24;
        byte[] requestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int startEnhancedOffsetCompensationResponseValue = 26;
        byte[] startEnhancedOffsetCompensationResponseParameter = new byte[]{27};
        byte[] currentData = new byte[]{28};
        byte[] temporaryData = new byte[]{29};

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , updateSensorLocationResponseValue
                , requestSupportedSensorLocationsResponseValue
                , requestSupportedSensorLocationsResponseParameter
                , setCrankLengthResponseValue
                , requestCrankLengthResponseValue
                , requestCrankLengthResponseParameter
                , setChainLengthResponseValue
                , requestChainLengthResponseValue
                , requestChainLengthResponseParameter
                , setChainWeightResponseValue
                , requestChainWeightResponseValue
                , requestChainWeightResponseParameter
                , setSpanLengthResponseValue
                , requestSpanLengthResponseValue
                , requestSpanLengthResponseParameter
                , startOffsetCompensationResponseValue
                , startOffsetCompensationResponseParameter
                , maskCyclingPowerMeasurementCharacteristicContentResponseValue
                , requestSamplingRateResponseValue
                , requestSamplingRateResponseParameter
                , requestFactoryCalibrationDateResponseValue
                , requestFactoryCalibrationDateResponseParameter
                , startEnhancedOffsetCompensationResponseValue
                , startEnhancedOffsetCompensationResponseParameter);

        result1.currentData = currentData;
        result1.temporaryData = temporaryData;

        assertEquals(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE).hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PERMISSION_WRITE).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(1).hashCode()
                        ^ Arrays.hashCode(currentData)
                        ^ Arrays.hashCode(temporaryData)
                        ^ Integer.valueOf(setCumulativeValueResponseValue).hashCode()
                        ^ Integer.valueOf(updateSensorLocationResponseValue).hashCode()
                        ^ Integer.valueOf(requestSupportedSensorLocationsResponseValue).hashCode()
                        ^ Arrays.hashCode(requestSupportedSensorLocationsResponseParameter)
                        ^ Integer.valueOf(setCrankLengthResponseValue).hashCode()
                        ^ Integer.valueOf(requestCrankLengthResponseValue).hashCode()
                        ^ Arrays.hashCode(requestCrankLengthResponseParameter)
                        ^ Integer.valueOf(setChainLengthResponseValue).hashCode()
                        ^ Integer.valueOf(requestChainLengthResponseValue).hashCode()
                        ^ Arrays.hashCode(requestChainLengthResponseParameter)
                        ^ Integer.valueOf(setChainWeightResponseValue).hashCode()
                        ^ Integer.valueOf(requestChainWeightResponseValue).hashCode()
                        ^ Arrays.hashCode(requestChainWeightResponseParameter)
                        ^ Integer.valueOf(setSpanLengthResponseValue).hashCode()
                        ^ Integer.valueOf(requestSpanLengthResponseValue).hashCode()
                        ^ Arrays.hashCode(requestSpanLengthResponseParameter)
                        ^ Integer.valueOf(startOffsetCompensationResponseValue).hashCode()
                        ^ Arrays.hashCode(startOffsetCompensationResponseParameter)
                        ^ Integer.valueOf(maskCyclingPowerMeasurementCharacteristicContentResponseValue).hashCode()
                        ^ Integer.valueOf(requestSamplingRateResponseValue).hashCode()
                        ^ Arrays.hashCode(requestSamplingRateResponseParameter)
                        ^ Integer.valueOf(requestFactoryCalibrationDateResponseValue).hashCode()
                        ^ Arrays.hashCode(requestFactoryCalibrationDateResponseParameter)
                        ^ Integer.valueOf(startEnhancedOffsetCompensationResponseValue).hashCode()
                        ^ Arrays.hashCode(startEnhancedOffsetCompensationResponseParameter)
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
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
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
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 32, 33, 34, new byte[]{35}));

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(secondDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
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
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondResponseCode = 101;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , secondResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
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
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        long secondDelay = 102;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , secondDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
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
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondSetCumulativeValueResponseValue = 103;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , secondSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
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
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondUpdateSensorLocationResponseValue = 104;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , secondUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
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
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondRequestSupportedSensorLocationsResponseValue = 105;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , secondRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
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
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        byte[] secondRequestSupportedSensorLocationsResponseParameter = new byte[]{106};

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , secondRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00009() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondSetCrankLengthResponseValue = 8;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , secondSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00010() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondRequestCrankLengthResponseValue = 108;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , secondRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00011() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        byte[] secondRequestCrankLengthResponseParameter = new byte[]{109};

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , secondRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00012() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondSetChainLengthResponseValue = 110;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , secondSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00013() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondRequestChainLengthResponseValue = 111;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , secondRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00014() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        byte[] secondRequestChainLengthResponseParameter = new byte[]{1};

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , secondRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00015() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondSetChainWeightResponseValue = 14;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , secondSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00016() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        byte[] secondRequestChainWeightResponseParameter = new byte[]{115};

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , secondRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00017() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondSetSpanLengthResponseValue = 116;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , secondSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00018() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondRequestSpanLengthResponseValue = 117;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , secondRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00019() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        byte[] secoondRequestSpanLengthResponseParameter = new byte[]{118};

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , secoondRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00020() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondStartOffsetCompensationResponseValue = 119;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , secondStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00021() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        byte[] secondStartOffsetCompensationResponseParameter = new byte[]{120};

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , secondStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00022() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 121;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , secondMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00023() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondRequestSamplingRateResponseValue = 122;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , secondRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00024() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        byte[] secondRequestSamplingRateResponseParameter = new byte[]{123};

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , secondRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00025() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondRequestFactoryCalibrationDateResponseValue = 124;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , secondRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00026() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        byte[] secondRequestFactoryCalibrationDateResponseParameter = new byte[]{125};

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , secondRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00027() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        int secondStartEnhancedOffsetCompensationResponseValue = 126;

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , secondStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00028() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));
        int firstResponseCode = 1;
        long firstDelay = 2;
        int firstSetCumulativeValueResponseValue = 3;
        int firstUpdateSensorLocationResponseValue = 4;
        int firstRequestSupportedSensorLocationsResponseValue = 5;
        byte[] firstRequestSupportedSensorLocationsResponseParameter = new byte[]{6};
        int firstSetCrankLengthResponseValue = 7;
        int firstRequestCrankLengthResponseValue = 8;
        byte[] firstRequestCrankLengthResponseParameter = new byte[]{9};
        int firstSetChainLengthResponseValue = 10;
        int firstRequestChainLengthResponseValue = 11;
        byte[] firstRequestChainLengthResponseParameter = new byte[]{12};
        int firstSetChainWeightResponseValue = 13;
        int firstRequestChainWeightResponseValue = 14;
        byte[] firstRequestChainWeightResponseParameter = new byte[]{15};
        int firstSetSpanLengthResponseValue = 16;
        int firstRequestSpanLengthResponseValue = 17;
        byte[] firstRequestSpanLengthResponseParameter = new byte[]{18};
        int firstStartOffsetCompensationResponseValue = 19;
        byte[] firstStartOffsetCompensationResponseParameter = new byte[]{20};
        int firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 21;
        int firstRequestSamplingRateResponseValue = 22;
        byte[] firstRequestSamplingRateResponseParameter = new byte[]{23};
        int firstRequestFactoryCalibrationDateResponseValue = 24;
        byte[] firstRequestFactoryCalibrationDateResponseParameter = new byte[]{25};
        int firstStartEnhancedOffsetCompensationResponseValue = 26;
        byte[] firstStartEnhancedOffsetCompensationResponseParameter = new byte[]{27};

        byte[] secondStartEnhancedOffsetCompensationResponseParameter = new byte[]{127};

        CyclingPowerControlPointCharacteristicData result1 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , firstStartEnhancedOffsetCompensationResponseParameter);
        CyclingPowerControlPointCharacteristicData result2 = new CyclingPowerControlPointCharacteristicData(firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstUpdateSensorLocationResponseValue
                , firstRequestSupportedSensorLocationsResponseValue
                , firstRequestSupportedSensorLocationsResponseParameter
                , firstSetCrankLengthResponseValue
                , firstRequestCrankLengthResponseValue
                , firstRequestCrankLengthResponseParameter
                , firstSetChainLengthResponseValue
                , firstRequestChainLengthResponseValue
                , firstRequestChainLengthResponseParameter
                , firstSetChainWeightResponseValue
                , firstRequestChainWeightResponseValue
                , firstRequestChainWeightResponseParameter
                , firstSetSpanLengthResponseValue
                , firstRequestSpanLengthResponseValue
                , firstRequestSpanLengthResponseParameter
                , firstStartOffsetCompensationResponseValue
                , firstStartOffsetCompensationResponseParameter
                , firstMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , firstRequestSamplingRateResponseValue
                , firstRequestSamplingRateResponseParameter
                , firstRequestFactoryCalibrationDateResponseValue
                , firstRequestFactoryCalibrationDateResponseParameter
                , firstStartEnhancedOffsetCompensationResponseValue
                , secondStartEnhancedOffsetCompensationResponseParameter);
        assertNotEquals(result1, result2);
    }

}
