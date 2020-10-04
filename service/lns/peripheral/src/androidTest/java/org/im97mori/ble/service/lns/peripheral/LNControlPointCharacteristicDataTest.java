package org.im97mori.ble.service.lns.peripheral;

import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.characteristic.u2a6b.LNControlPoint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LN_CONTROL_POINT_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LNControlPointCharacteristicDataTest {

    @Test
    public void test_constructor_00001() {
        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<DescriptorData>()
                , 3
                , 4
                , 6
                , 7
                , 8
                , 9
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , 16);

        Gson gson = new Gson();
        LNControlPointCharacteristicData result2 = gson.fromJson(gson.toJson(result1), LNControlPointCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertTrue(result2.descriptorDataList.isEmpty());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.setCumulativeValueResponceValue, result2.setCumulativeValueResponceValue);
        assertEquals(result1.maskLocationAndSpeedCharacteristicContentResponceValue, result2.maskLocationAndSpeedCharacteristicContentResponceValue);
        assertEquals(result1.navigationControlResponceValue, result2.navigationControlResponceValue);
        assertEquals(result1.requestNumberOfRoutesResponceValue, result2.requestNumberOfRoutesResponceValue);
        assertArrayEquals(result1.requestNumberOfRoutesResponceParameter, result2.requestNumberOfRoutesResponceParameter);
        assertEquals(result1.requestNameOfRouteResponceValue, result2.requestNameOfRouteResponceValue);
        assertArrayEquals(result1.requestNameOfRouteResponceParameter, result2.requestNameOfRouteResponceParameter);
        assertEquals(result1.selectRouteResponceValue, result2.selectRouteResponceValue);
        assertEquals(result1.setFixRateResponceValue, result2.setFixRateResponceValue);
        assertEquals(result1.setElevationResponceValue, result2.setElevationResponceValue);
    }

    @Test
    public void test_constructor_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(1
                , 2
                , descriptorDataList
                , 3
                , 4
                , 6
                , 7
                , 8
                , 9
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , 16);

        Gson gson = new Gson();
        LNControlPointCharacteristicData result2 = gson.fromJson(gson.toJson(result1), LNControlPointCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.setCumulativeValueResponceValue, result2.setCumulativeValueResponceValue);
        assertEquals(result1.maskLocationAndSpeedCharacteristicContentResponceValue, result2.maskLocationAndSpeedCharacteristicContentResponceValue);
        assertEquals(result1.navigationControlResponceValue, result2.navigationControlResponceValue);
        assertEquals(result1.requestNumberOfRoutesResponceValue, result2.requestNumberOfRoutesResponceValue);
        assertArrayEquals(result1.requestNumberOfRoutesResponceParameter, result2.requestNumberOfRoutesResponceParameter);
        assertEquals(result1.requestNameOfRouteResponceValue, result2.requestNameOfRouteResponceValue);
        assertArrayEquals(result1.requestNameOfRouteResponceParameter, result2.requestNameOfRouteResponceParameter);
        assertEquals(result1.selectRouteResponceValue, result2.selectRouteResponceValue);
        assertEquals(result1.setFixRateResponceValue, result2.setFixRateResponceValue);
        assertEquals(result1.setElevationResponceValue, result2.setElevationResponceValue);
    }

    @Test
    public void test_setCumulativeValueResponceValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstCumulativeValueResponceValue = 1;
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData characteristicData = new LNControlPointCharacteristicData(0
                , 0
                , descriptorDataList
                , 0
                , 0
                , 0
                , firstCumulativeValueResponceValue
                , 0
                , 0
                , 0
                , new byte[0]
                , 0
                , new byte[0]
                , 0
                , 0
                , 0);
        assertEquals(firstCumulativeValueResponceValue, characteristicData.setCumulativeValueResponceValue);

        int secondCumulativeValueResponceValue = 11;
        characteristicData.setCumulativeValueResponceValue = secondCumulativeValueResponceValue;
        assertEquals(secondCumulativeValueResponceValue, characteristicData.setCumulativeValueResponceValue);
    }

    @Test
    public void test_maskLocationAndSpeedCharacteristicContentResponceValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 1;
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData characteristicData = new LNControlPointCharacteristicData(0
                , 0
                , descriptorDataList
                , 0
                , 0
                , 0
                , 0
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , 0
                , 0
                , new byte[0]
                , 0
                , new byte[0]
                , 0
                , 0
                , 0);
        assertEquals(firstMaskLocationAndSpeedCharacteristicContentResponceValue, characteristicData.maskLocationAndSpeedCharacteristicContentResponceValue);

        int secondMaskLocationAndSpeedCharacteristicContentResponceValue = 11;
        characteristicData.maskLocationAndSpeedCharacteristicContentResponceValue = secondMaskLocationAndSpeedCharacteristicContentResponceValue;
        assertEquals(secondMaskLocationAndSpeedCharacteristicContentResponceValue, characteristicData.maskLocationAndSpeedCharacteristicContentResponceValue);
    }

    @Test
    public void test_navigationControlResponceValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstNavigationControlResponceValue = 1;
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData characteristicData = new LNControlPointCharacteristicData(0
                , 0
                , descriptorDataList
                , 0
                , 0
                , 0
                , 0
                , 0
                , firstNavigationControlResponceValue
                , 0
                , new byte[0]
                , 0
                , new byte[0]
                , 0
                , 0
                , 0);
        assertEquals(firstNavigationControlResponceValue, characteristicData.navigationControlResponceValue);

        int secondNavigationControlResponceValue = 11;
        characteristicData.navigationControlResponceValue = secondNavigationControlResponceValue;
        assertEquals(secondNavigationControlResponceValue, characteristicData.navigationControlResponceValue);
    }

    @Test
    public void test_requestNumberOfRoutesResponceValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstRequestNumberOfRoutesResponceValue = 1;
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData characteristicData = new LNControlPointCharacteristicData(0
                , 0
                , descriptorDataList
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , firstRequestNumberOfRoutesResponceValue
                , new byte[0]
                , 0
                , new byte[0]
                , 0
                , 0
                , 0);
        assertEquals(firstRequestNumberOfRoutesResponceValue, characteristicData.requestNumberOfRoutesResponceValue);

        int secondRequestNumberOfRoutesResponceValue = 11;
        characteristicData.requestNumberOfRoutesResponceValue = secondRequestNumberOfRoutesResponceValue;
        assertEquals(secondRequestNumberOfRoutesResponceValue, characteristicData.requestNumberOfRoutesResponceValue);
    }

    @Test
    public void test_requestNumberOfRoutesResponceParameter_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[1];
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData characteristicData = new LNControlPointCharacteristicData(0
                , 0
                , descriptorDataList
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , firstRequestNumberOfRoutesResponceParameter
                , 0
                , new byte[0]
                , 0
                , 0
                , 0);
        assertArrayEquals(firstRequestNumberOfRoutesResponceParameter, characteristicData.requestNumberOfRoutesResponceParameter);

        byte[] secondRequestNumberOfRoutesResponceParameter = new byte[2];
        characteristicData.requestNumberOfRoutesResponceParameter = secondRequestNumberOfRoutesResponceParameter;
        assertArrayEquals(secondRequestNumberOfRoutesResponceParameter, characteristicData.requestNumberOfRoutesResponceParameter);
    }

    @Test
    public void test_requestNameOfRouteResponceValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstRequestNameOfRouteResponceValue = 1;
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData characteristicData = new LNControlPointCharacteristicData(0
                , 0
                , descriptorDataList
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , new byte[0]
                , firstRequestNameOfRouteResponceValue
                , new byte[0]
                , 0
                , 0
                , 0);
        assertEquals(firstRequestNameOfRouteResponceValue, characteristicData.requestNameOfRouteResponceValue);

        int secondRequestNameOfRouteResponceValue = 11;
        characteristicData.requestNameOfRouteResponceValue = secondRequestNameOfRouteResponceValue;
        assertEquals(secondRequestNameOfRouteResponceValue, characteristicData.requestNameOfRouteResponceValue);
    }

    @Test
    public void test_requestNameOfRouteResponceParameter_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        byte[] firstRequestNameOfRouteResponceParameter = new byte[1];
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData characteristicData = new LNControlPointCharacteristicData(0
                , 0
                , descriptorDataList
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , new byte[0]
                , 0
                , firstRequestNameOfRouteResponceParameter
                , 0
                , 0
                , 0);
        assertArrayEquals(firstRequestNameOfRouteResponceParameter, characteristicData.requestNameOfRouteResponceParameter);

        byte[] secondRequestNameOfRouteResponceParameter = new byte[2];
        characteristicData.requestNameOfRouteResponceParameter = secondRequestNameOfRouteResponceParameter;
        assertArrayEquals(secondRequestNameOfRouteResponceParameter, characteristicData.requestNameOfRouteResponceParameter);
    }

    @Test
    public void test_selectRouteResponceValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstSelectRouteResponceValue = 1;
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData characteristicData = new LNControlPointCharacteristicData(0
                , 0
                , descriptorDataList
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , new byte[0]
                , 0
                , new byte[0]
                , firstSelectRouteResponceValue
                , 0
                , 0);
        assertEquals(firstSelectRouteResponceValue, characteristicData.selectRouteResponceValue);

        int secondSelectRouteResponceValue = 11;
        characteristicData.selectRouteResponceValue = secondSelectRouteResponceValue;
        assertEquals(secondSelectRouteResponceValue, characteristicData.selectRouteResponceValue);
    }

    @Test
    public void test_setFixRateResponceValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstSetFixRateResponceValue = 1;
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData characteristicData = new LNControlPointCharacteristicData(0
                , 0
                , descriptorDataList
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , new byte[0]
                , 0
                , new byte[0]
                , 0
                , firstSetFixRateResponceValue
                , 0);
        assertEquals(firstSetFixRateResponceValue, characteristicData.setFixRateResponceValue);

        int secondSetFixRateResponceValue = 11;
        characteristicData.setFixRateResponceValue = secondSetFixRateResponceValue;
        assertEquals(secondSetFixRateResponceValue, characteristicData.setFixRateResponceValue);
    }

    @Test
    public void test_setElevationResponceValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstSetElevationResponceValue = 1;
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData characteristicData = new LNControlPointCharacteristicData(0
                , 0
                , descriptorDataList
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , new byte[0]
                , 0
                , new byte[0]
                , 0
                , 0
                , firstSetElevationResponceValue);
        assertEquals(firstSetElevationResponceValue, characteristicData.setElevationResponceValue);

        int secondSetElevationResponceValue = 11;
        characteristicData.setElevationResponceValue = secondSetElevationResponceValue;
        assertEquals(secondSetElevationResponceValue, characteristicData.setElevationResponceValue);
    }

    @Test
    public void test_parcelable_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(1
                , 2
                , descriptorDataList
                , 3
                , 4
                , 6
                , 7
                , 8
                , 9
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , 16);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNControlPointCharacteristicData result2 = LNControlPointCharacteristicData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        result1.descriptorDataList.clear();
        assertNotEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.setCumulativeValueResponceValue, result2.setCumulativeValueResponceValue);
        assertEquals(result1.maskLocationAndSpeedCharacteristicContentResponceValue, result2.maskLocationAndSpeedCharacteristicContentResponceValue);
        assertEquals(result1.navigationControlResponceValue, result2.navigationControlResponceValue);
        assertEquals(result1.requestNumberOfRoutesResponceValue, result2.requestNumberOfRoutesResponceValue);
        assertArrayEquals(result1.requestNumberOfRoutesResponceParameter, result2.requestNumberOfRoutesResponceParameter);
        assertEquals(result1.requestNameOfRouteResponceValue, result2.requestNameOfRouteResponceValue);
        assertArrayEquals(result1.requestNameOfRouteResponceParameter, result2.requestNameOfRouteResponceParameter);
        assertEquals(result1.selectRouteResponceValue, result2.selectRouteResponceValue);
        assertEquals(result1.setFixRateResponceValue, result2.setFixRateResponceValue);
        assertEquals(result1.setElevationResponceValue, result2.setElevationResponceValue);
    }

    @Test
    public void test_parcelable_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(1
                , 2
                , descriptorDataList
                , 3
                , 4
                , 6
                , 7
                , 8
                , 9
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , 16);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNControlPointCharacteristicData result2 = LNControlPointCharacteristicData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        result1.descriptorDataList.clear();
        assertNotEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.setCumulativeValueResponceValue, result2.setCumulativeValueResponceValue);
        assertEquals(result1.maskLocationAndSpeedCharacteristicContentResponceValue, result2.maskLocationAndSpeedCharacteristicContentResponceValue);
        assertEquals(result1.navigationControlResponceValue, result2.navigationControlResponceValue);
        assertEquals(result1.requestNumberOfRoutesResponceValue, result2.requestNumberOfRoutesResponceValue);
        assertArrayEquals(result1.requestNumberOfRoutesResponceParameter, result2.requestNumberOfRoutesResponceParameter);
        assertEquals(result1.requestNameOfRouteResponceValue, result2.requestNameOfRouteResponceValue);
        assertArrayEquals(result1.requestNameOfRouteResponceParameter, result2.requestNameOfRouteResponceParameter);
        assertEquals(result1.selectRouteResponceValue, result2.selectRouteResponceValue);
        assertEquals(result1.setFixRateResponceValue, result2.setFixRateResponceValue);
        assertEquals(result1.setElevationResponceValue, result2.setElevationResponceValue);
    }

    @Test
    public void test_hashCode_00001() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        int notificationCount = 7;
        int setCumulativeValueResponceValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int navigationControlResponceValue = 10;
        int requestNumberOfRoutesResponceValue = 11;
        byte[] requestNumberOfRoutesResponceParameter = new byte[]{12};
        int requestNameOfRouteResponceValue = 13;
        byte[] requestNameOfRouteResponceParameter = new byte[]{14};
        int selectRouteResponceValue = 15;
        int setFixRateResponceValue = 16;
        int setElevationResponceValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
                , setCumulativeValueResponceValue
                , maskLocationAndSpeedCharacteristicContentResponceValue
                , navigationControlResponceValue
                , requestNumberOfRoutesResponceValue
                , requestNumberOfRoutesResponceParameter
                , requestNameOfRouteResponceValue
                , requestNameOfRouteResponceParameter
                , selectRouteResponceValue
                , setFixRateResponceValue
                , setElevationResponceValue);
        assertEquals(LN_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(property).hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode(new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_RESPONSE_CODE, LNControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes())
                        ^ Integer.valueOf(notificationCount).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(setCumulativeValueResponceValue).hashCode()
                        ^ Integer.valueOf(maskLocationAndSpeedCharacteristicContentResponceValue).hashCode()
                        ^ Integer.valueOf(navigationControlResponceValue).hashCode()
                        ^ Integer.valueOf(requestNumberOfRoutesResponceValue).hashCode()
                        ^ Arrays.hashCode(requestNumberOfRoutesResponceParameter)
                        ^ Integer.valueOf(requestNameOfRouteResponceValue).hashCode()
                        ^ Arrays.hashCode(requestNameOfRouteResponceParameter)
                        ^ Integer.valueOf(selectRouteResponceValue).hashCode()
                        ^ Integer.valueOf(setFixRateResponceValue).hashCode()
                        ^ Integer.valueOf(setElevationResponceValue).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] currentData = new byte[]{7, 8};
        byte[] temporaryData = new byte[]{9, 10};
        int notificationCount = 11;
        int setCumulativeValueResponceValue = 12;
        int maskLocationAndSpeedCharacteristicContentResponceValue = 13;
        int navigationControlResponceValue = 14;
        int requestNumberOfRoutesResponceValue = 15;
        byte[] requestNumberOfRoutesResponceParameter = new byte[]{16};
        int requestNameOfRouteResponceValue = 17;
        byte[] requestNameOfRouteResponceParameter = new byte[]{18};
        int selectRouteResponceValue = 19;
        int setFixRateResponceValue = 20;
        int setElevationResponceValue = 21;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
                , setCumulativeValueResponceValue
                , maskLocationAndSpeedCharacteristicContentResponceValue
                , navigationControlResponceValue
                , requestNumberOfRoutesResponceValue
                , requestNumberOfRoutesResponceParameter
                , requestNameOfRouteResponceValue
                , requestNameOfRouteResponceParameter
                , selectRouteResponceValue
                , setFixRateResponceValue
                , setElevationResponceValue);
        result1.currentData = currentData;
        result1.temporaryData = temporaryData;
        assertEquals(LN_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(property).hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode(new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_RESPONSE_CODE, LNControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes())
                        ^ Integer.valueOf(notificationCount).hashCode()
                        ^ Arrays.hashCode(currentData)
                        ^ Arrays.hashCode(temporaryData)
                        ^ Integer.valueOf(setCumulativeValueResponceValue).hashCode()
                        ^ Integer.valueOf(maskLocationAndSpeedCharacteristicContentResponceValue).hashCode()
                        ^ Integer.valueOf(navigationControlResponceValue).hashCode()
                        ^ Integer.valueOf(requestNumberOfRoutesResponceValue).hashCode()
                        ^ Arrays.hashCode(requestNumberOfRoutesResponceParameter)
                        ^ Integer.valueOf(requestNameOfRouteResponceValue).hashCode()
                        ^ Arrays.hashCode(requestNameOfRouteResponceParameter)
                        ^ Integer.valueOf(selectRouteResponceValue).hashCode()
                        ^ Integer.valueOf(setFixRateResponceValue).hashCode()
                        ^ Integer.valueOf(setElevationResponceValue).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        int secondProperty = 101;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(secondProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        int secondPermission = 102;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , secondPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 22, 33, null));

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , secondDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        int secondResponseCode = 103;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , secondResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        int secondResponseCode = 104;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , secondResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        long secondDelay = 104;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , secondDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00009() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        int secondNotificationCount = 107;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , secondNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00010() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        int secondSetCumulativeValueResponceValue = 108;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , secondSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00011() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        int secondMaskLocationAndSpeedCharacteristicContentResponceValue = 109;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , secondMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00012() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        int secondNavigationControlResponceValue = 110;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , secondNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00013() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        int secondRequestNumberOfRoutesResponceValue = 111;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , secondRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00014() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        byte[] secondRequestNumberOfRoutesResponceParameter = new byte[]{112};

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , secondRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00015() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        int secondRequestNameOfRouteResponceValue = 113;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , secondRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00016() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        byte[] secondRequestNameOfRouteResponceParameter = new byte[]{114};

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , secondRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00017() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        int secondSelectRouteResponceValue = 115;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , secondSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00018() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        int secondSetFixRateResponceValue = 116;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , secondSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00019() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponceValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int firstNavigationControlResponceValue = 10;
        int firstRequestNumberOfRoutesResponceValue = 11;
        byte[] firstRequestNumberOfRoutesResponceParameter = new byte[]{12};
        int firstRequestNameOfRouteResponceValue = 13;
        byte[] firstRequestNameOfRouteResponceParameter = new byte[]{14};
        int firstSelectRouteResponceValue = 15;
        int firstSetFixRateResponceValue = 16;
        int firstSetElevationResponceValue = 17;

        int secondSetElevationResponceValue = 117;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , firstSetElevationResponceValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
                , firstSetCumulativeValueResponceValue
                , firstMaskLocationAndSpeedCharacteristicContentResponceValue
                , firstNavigationControlResponceValue
                , firstRequestNumberOfRoutesResponceValue
                , firstRequestNumberOfRoutesResponceParameter
                , firstRequestNameOfRouteResponceValue
                , firstRequestNameOfRouteResponceParameter
                , firstSelectRouteResponceValue
                , firstSetFixRateResponceValue
                , secondSetElevationResponceValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_getBytes_00001() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponceValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int navigationControlResponceValue = 10;
        int requestNumberOfRoutesResponceValue = 11;
        byte[] requestNumberOfRoutesResponceParameter = new byte[]{12};
        int requestNameOfRouteResponceValue = 13;
        byte[] requestNameOfRouteResponceParameter = new byte[]{14};
        int selectRouteResponceValue = 15;
        int setFixRateResponceValue = 16;
        int setElevationResponceValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
                , setCumulativeValueResponceValue
                , maskLocationAndSpeedCharacteristicContentResponceValue
                , navigationControlResponceValue
                , requestNumberOfRoutesResponceValue
                , requestNumberOfRoutesResponceParameter
                , requestNameOfRouteResponceValue
                , requestNameOfRouteResponceParameter
                , selectRouteResponceValue
                , setFixRateResponceValue
                , setElevationResponceValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, setCumulativeValueResponceValue, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00002() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponceValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int navigationControlResponceValue = 10;
        int requestNumberOfRoutesResponceValue = 11;
        byte[] requestNumberOfRoutesResponceParameter = new byte[]{12};
        int requestNameOfRouteResponceValue = 13;
        byte[] requestNameOfRouteResponceParameter = new byte[]{14};
        int selectRouteResponceValue = 15;
        int setFixRateResponceValue = 16;
        int setElevationResponceValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
                , setCumulativeValueResponceValue
                , maskLocationAndSpeedCharacteristicContentResponceValue
                , navigationControlResponceValue
                , requestNumberOfRoutesResponceValue
                , requestNumberOfRoutesResponceParameter
                , requestNameOfRouteResponceValue
                , requestNameOfRouteResponceParameter
                , selectRouteResponceValue
                , setFixRateResponceValue
                , setElevationResponceValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT, maskLocationAndSpeedCharacteristicContentResponceValue, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00003() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_NAVIGATION_CONTROL, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponceValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int navigationControlResponceValue = 10;
        int requestNumberOfRoutesResponceValue = 11;
        byte[] requestNumberOfRoutesResponceParameter = new byte[]{12};
        int requestNameOfRouteResponceValue = 13;
        byte[] requestNameOfRouteResponceParameter = new byte[]{14};
        int selectRouteResponceValue = 15;
        int setFixRateResponceValue = 16;
        int setElevationResponceValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
                , setCumulativeValueResponceValue
                , maskLocationAndSpeedCharacteristicContentResponceValue
                , navigationControlResponceValue
                , requestNumberOfRoutesResponceValue
                , requestNumberOfRoutesResponceParameter
                , requestNameOfRouteResponceValue
                , requestNameOfRouteResponceParameter
                , selectRouteResponceValue
                , setFixRateResponceValue
                , setElevationResponceValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_NAVIGATION_CONTROL, navigationControlResponceValue, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00004() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_REQUEST_NUMBER_OF_ROUTES, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponceValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int navigationControlResponceValue = 10;
        int requestNumberOfRoutesResponceValue = 11;
        byte[] requestNumberOfRoutesResponceParameter = new byte[]{12};
        int requestNameOfRouteResponceValue = 13;
        byte[] requestNameOfRouteResponceParameter = new byte[]{14};
        int selectRouteResponceValue = 15;
        int setFixRateResponceValue = 16;
        int setElevationResponceValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
                , setCumulativeValueResponceValue
                , maskLocationAndSpeedCharacteristicContentResponceValue
                , navigationControlResponceValue
                , requestNumberOfRoutesResponceValue
                , requestNumberOfRoutesResponceParameter
                , requestNameOfRouteResponceValue
                , requestNameOfRouteResponceParameter
                , selectRouteResponceValue
                , setFixRateResponceValue
                , setElevationResponceValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_REQUEST_NUMBER_OF_ROUTES, requestNumberOfRoutesResponceValue, requestNumberOfRoutesResponceParameter).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00005() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_REQUEST_NAME_OF_ROUTE, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponceValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int navigationControlResponceValue = 10;
        int requestNumberOfRoutesResponceValue = 11;
        byte[] requestNumberOfRoutesResponceParameter = new byte[]{12};
        int requestNameOfRouteResponceValue = 13;
        byte[] requestNameOfRouteResponceParameter = new byte[]{14};
        int selectRouteResponceValue = 15;
        int setFixRateResponceValue = 16;
        int setElevationResponceValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
                , setCumulativeValueResponceValue
                , maskLocationAndSpeedCharacteristicContentResponceValue
                , navigationControlResponceValue
                , requestNumberOfRoutesResponceValue
                , requestNumberOfRoutesResponceParameter
                , requestNameOfRouteResponceValue
                , requestNameOfRouteResponceParameter
                , selectRouteResponceValue
                , setFixRateResponceValue
                , setElevationResponceValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_REQUEST_NAME_OF_ROUTE, requestNameOfRouteResponceValue, requestNameOfRouteResponceParameter).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00006() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_SELECT_ROUTE, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponceValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int navigationControlResponceValue = 10;
        int requestNumberOfRoutesResponceValue = 11;
        byte[] requestNumberOfRoutesResponceParameter = new byte[]{12};
        int requestNameOfRouteResponceValue = 13;
        byte[] requestNameOfRouteResponceParameter = new byte[]{14};
        int selectRouteResponceValue = 15;
        int setFixRateResponceValue = 16;
        int setElevationResponceValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
                , setCumulativeValueResponceValue
                , maskLocationAndSpeedCharacteristicContentResponceValue
                , navigationControlResponceValue
                , requestNumberOfRoutesResponceValue
                , requestNumberOfRoutesResponceParameter
                , requestNameOfRouteResponceValue
                , requestNameOfRouteResponceParameter
                , selectRouteResponceValue
                , setFixRateResponceValue
                , setElevationResponceValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SELECT_ROUTE, selectRouteResponceValue, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00007() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_SET_FIX_RATE, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponceValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int navigationControlResponceValue = 10;
        int requestNumberOfRoutesResponceValue = 11;
        byte[] requestNumberOfRoutesResponceParameter = new byte[]{12};
        int requestNameOfRouteResponceValue = 13;
        byte[] requestNameOfRouteResponceParameter = new byte[]{14};
        int selectRouteResponceValue = 15;
        int setFixRateResponceValue = 16;
        int setElevationResponceValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
                , setCumulativeValueResponceValue
                , maskLocationAndSpeedCharacteristicContentResponceValue
                , navigationControlResponceValue
                , requestNumberOfRoutesResponceValue
                , requestNumberOfRoutesResponceParameter
                , requestNameOfRouteResponceValue
                , requestNameOfRouteResponceParameter
                , selectRouteResponceValue
                , setFixRateResponceValue
                , setElevationResponceValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SET_FIX_RATE, setFixRateResponceValue, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00008() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_SET_ELEVATION, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponceValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int navigationControlResponceValue = 10;
        int requestNumberOfRoutesResponceValue = 11;
        byte[] requestNumberOfRoutesResponceParameter = new byte[]{12};
        int requestNameOfRouteResponceValue = 13;
        byte[] requestNameOfRouteResponceParameter = new byte[]{14};
        int selectRouteResponceValue = 15;
        int setFixRateResponceValue = 16;
        int setElevationResponceValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
                , setCumulativeValueResponceValue
                , maskLocationAndSpeedCharacteristicContentResponceValue
                , navigationControlResponceValue
                , requestNumberOfRoutesResponceValue
                , requestNumberOfRoutesResponceParameter
                , requestNameOfRouteResponceValue
                , requestNameOfRouteResponceParameter
                , selectRouteResponceValue
                , setFixRateResponceValue
                , setElevationResponceValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SET_ELEVATION, setElevationResponceValue, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00009() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponceValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int navigationControlResponceValue = 10;
        int requestNumberOfRoutesResponceValue = 11;
        byte[] requestNumberOfRoutesResponceParameter = new byte[]{12};
        int requestNameOfRouteResponceValue = 13;
        byte[] requestNameOfRouteResponceParameter = new byte[]{14};
        int selectRouteResponceValue = 15;
        int setFixRateResponceValue = 16;
        int setElevationResponceValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
                , setCumulativeValueResponceValue
                , maskLocationAndSpeedCharacteristicContentResponceValue
                , navigationControlResponceValue
                , requestNumberOfRoutesResponceValue
                , requestNumberOfRoutesResponceParameter
                , requestNameOfRouteResponceValue
                , requestNameOfRouteResponceParameter
                , selectRouteResponceValue
                , setFixRateResponceValue
                , setElevationResponceValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_RESPONSE_CODE, LNControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00010() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        int notificationCount = 7;
        int setCumulativeValueResponceValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int navigationControlResponceValue = 10;
        int requestNumberOfRoutesResponceValue = 11;
        byte[] requestNumberOfRoutesResponceParameter = new byte[]{12};
        int requestNameOfRouteResponceValue = 13;
        byte[] requestNameOfRouteResponceParameter = new byte[]{14};
        int selectRouteResponceValue = 15;
        int setFixRateResponceValue = 16;
        int setElevationResponceValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
                , setCumulativeValueResponceValue
                , maskLocationAndSpeedCharacteristicContentResponceValue
                , navigationControlResponceValue
                , requestNumberOfRoutesResponceValue
                , requestNumberOfRoutesResponceParameter
                , requestNameOfRouteResponceValue
                , requestNameOfRouteResponceParameter
                , selectRouteResponceValue
                , setFixRateResponceValue
                , setElevationResponceValue);
        result1.currentData = new LNControlPoint(LNControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, new byte[0], 0, 0, new byte[0]).getBytes();

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, setCumulativeValueResponceValue, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00011() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(-1, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponceValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int navigationControlResponceValue = 10;
        int requestNumberOfRoutesResponceValue = 11;
        byte[] requestNumberOfRoutesResponceParameter = new byte[]{12};
        int requestNameOfRouteResponceValue = 13;
        byte[] requestNameOfRouteResponceParameter = new byte[]{14};
        int selectRouteResponceValue = 15;
        int setFixRateResponceValue = 16;
        int setElevationResponceValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
                , setCumulativeValueResponceValue
                , maskLocationAndSpeedCharacteristicContentResponceValue
                , navigationControlResponceValue
                , requestNumberOfRoutesResponceValue
                , requestNumberOfRoutesResponceParameter
                , requestNameOfRouteResponceValue
                , requestNameOfRouteResponceParameter
                , selectRouteResponceValue
                , setFixRateResponceValue
                , setElevationResponceValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], -1, LNControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00012() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        int notificationCount = 7;
        int setCumulativeValueResponceValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponceValue = 9;
        int navigationControlResponceValue = 10;
        int requestNumberOfRoutesResponceValue = 11;
        byte[] requestNumberOfRoutesResponceParameter = new byte[]{12};
        int requestNameOfRouteResponceValue = 13;
        byte[] requestNameOfRouteResponceParameter = new byte[]{14};
        int selectRouteResponceValue = 15;
        int setFixRateResponceValue = 16;
        int setElevationResponceValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
                , setCumulativeValueResponceValue
                , maskLocationAndSpeedCharacteristicContentResponceValue
                , navigationControlResponceValue
                , requestNumberOfRoutesResponceValue
                , requestNumberOfRoutesResponceParameter
                , requestNameOfRouteResponceValue
                , requestNameOfRouteResponceParameter
                , selectRouteResponceValue
                , setFixRateResponceValue
                , setElevationResponceValue);
        result1.currentData = new byte[0];

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_RESPONSE_CODE, LNControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

}
