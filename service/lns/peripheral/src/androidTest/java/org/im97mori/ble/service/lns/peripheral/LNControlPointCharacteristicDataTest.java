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

import static org.im97mori.ble.constants.CharacteristicUUID.LN_CONTROL_POINT_CHARACTERISTIC;
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
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);

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
        assertEquals(result1.setCumulativeValueResponseValue, result2.setCumulativeValueResponseValue);
        assertEquals(result1.maskLocationAndSpeedCharacteristicContentResponseValue, result2.maskLocationAndSpeedCharacteristicContentResponseValue);
        assertEquals(result1.navigationControlResponseValue, result2.navigationControlResponseValue);
        assertEquals(result1.requestNumberOfRoutesResponseValue, result2.requestNumberOfRoutesResponseValue);
        assertArrayEquals(result1.requestNumberOfRoutesResponseParameter, result2.requestNumberOfRoutesResponseParameter);
        assertEquals(result1.requestNameOfRouteResponseValue, result2.requestNameOfRouteResponseValue);
        assertArrayEquals(result1.requestNameOfRouteResponseParameter, result2.requestNameOfRouteResponseParameter);
        assertEquals(result1.selectRouteResponseValue, result2.selectRouteResponseValue);
        assertEquals(result1.setFixRateResponseValue, result2.setFixRateResponseValue);
        assertEquals(result1.setElevationResponseValue, result2.setElevationResponseValue);
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
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);

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
        assertEquals(result1.setCumulativeValueResponseValue, result2.setCumulativeValueResponseValue);
        assertEquals(result1.maskLocationAndSpeedCharacteristicContentResponseValue, result2.maskLocationAndSpeedCharacteristicContentResponseValue);
        assertEquals(result1.navigationControlResponseValue, result2.navigationControlResponseValue);
        assertEquals(result1.requestNumberOfRoutesResponseValue, result2.requestNumberOfRoutesResponseValue);
        assertArrayEquals(result1.requestNumberOfRoutesResponseParameter, result2.requestNumberOfRoutesResponseParameter);
        assertEquals(result1.requestNameOfRouteResponseValue, result2.requestNameOfRouteResponseValue);
        assertArrayEquals(result1.requestNameOfRouteResponseParameter, result2.requestNameOfRouteResponseParameter);
        assertEquals(result1.selectRouteResponseValue, result2.selectRouteResponseValue);
        assertEquals(result1.setFixRateResponseValue, result2.setFixRateResponseValue);
        assertEquals(result1.setElevationResponseValue, result2.setElevationResponseValue);
    }

    @Test
    public void test_setCumulativeValueResponseValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstCumulativeValueResponseValue = 1;
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData characteristicData = new LNControlPointCharacteristicData(0
                , 0
                , descriptorDataList
                , 0
                , 0
                , firstCumulativeValueResponseValue
                , 0
                , 0
                , 0
                , new byte[0]
                , 0
                , new byte[0]
                , 0
                , 0
                , 0);
        assertEquals(firstCumulativeValueResponseValue, characteristicData.setCumulativeValueResponseValue);

        int secondCumulativeValueResponseValue = 11;
        characteristicData.setCumulativeValueResponseValue = secondCumulativeValueResponseValue;
        assertEquals(secondCumulativeValueResponseValue, characteristicData.setCumulativeValueResponseValue);
    }

    @Test
    public void test_maskLocationAndSpeedCharacteristicContentResponseValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 1;
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData characteristicData = new LNControlPointCharacteristicData(0
                , 0
                , descriptorDataList
                , 0
                , 0
                , 0
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , 0
                , 0
                , new byte[0]
                , 0
                , new byte[0]
                , 0
                , 0
                , 0);
        assertEquals(firstMaskLocationAndSpeedCharacteristicContentResponseValue, characteristicData.maskLocationAndSpeedCharacteristicContentResponseValue);

        int secondMaskLocationAndSpeedCharacteristicContentResponseValue = 11;
        characteristicData.maskLocationAndSpeedCharacteristicContentResponseValue = secondMaskLocationAndSpeedCharacteristicContentResponseValue;
        assertEquals(secondMaskLocationAndSpeedCharacteristicContentResponseValue, characteristicData.maskLocationAndSpeedCharacteristicContentResponseValue);
    }

    @Test
    public void test_navigationControlResponseValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstNavigationControlResponseValue = 1;
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData characteristicData = new LNControlPointCharacteristicData(0
                , 0
                , descriptorDataList
                , 0
                , 0
                , 0
                , 0
                , firstNavigationControlResponseValue
                , 0
                , new byte[0]
                , 0
                , new byte[0]
                , 0
                , 0
                , 0);
        assertEquals(firstNavigationControlResponseValue, characteristicData.navigationControlResponseValue);

        int secondNavigationControlResponseValue = 11;
        characteristicData.navigationControlResponseValue = secondNavigationControlResponseValue;
        assertEquals(secondNavigationControlResponseValue, characteristicData.navigationControlResponseValue);
    }

    @Test
    public void test_requestNumberOfRoutesResponseValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstRequestNumberOfRoutesResponseValue = 1;
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        LNControlPointCharacteristicData characteristicData = new LNControlPointCharacteristicData(0
                , 0
                , descriptorDataList
                , 0
                , 0
                , 0
                , 0
                , 0
                , firstRequestNumberOfRoutesResponseValue
                , new byte[0]
                , 0
                , new byte[0]
                , 0
                , 0
                , 0);
        assertEquals(firstRequestNumberOfRoutesResponseValue, characteristicData.requestNumberOfRoutesResponseValue);

        int secondRequestNumberOfRoutesResponseValue = 11;
        characteristicData.requestNumberOfRoutesResponseValue = secondRequestNumberOfRoutesResponseValue;
        assertEquals(secondRequestNumberOfRoutesResponseValue, characteristicData.requestNumberOfRoutesResponseValue);
    }

    @Test
    public void test_requestNumberOfRoutesResponseParameter_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[1];
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
                , firstRequestNumberOfRoutesResponseParameter
                , 0
                , new byte[0]
                , 0
                , 0
                , 0);
        assertArrayEquals(firstRequestNumberOfRoutesResponseParameter, characteristicData.requestNumberOfRoutesResponseParameter);

        byte[] secondRequestNumberOfRoutesResponseParameter = new byte[2];
        characteristicData.requestNumberOfRoutesResponseParameter = secondRequestNumberOfRoutesResponseParameter;
        assertArrayEquals(secondRequestNumberOfRoutesResponseParameter, characteristicData.requestNumberOfRoutesResponseParameter);
    }

    @Test
    public void test_requestNameOfRouteResponseValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstRequestNameOfRouteResponseValue = 1;
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
                , new byte[0]
                , firstRequestNameOfRouteResponseValue
                , new byte[0]
                , 0
                , 0
                , 0);
        assertEquals(firstRequestNameOfRouteResponseValue, characteristicData.requestNameOfRouteResponseValue);

        int secondRequestNameOfRouteResponseValue = 11;
        characteristicData.requestNameOfRouteResponseValue = secondRequestNameOfRouteResponseValue;
        assertEquals(secondRequestNameOfRouteResponseValue, characteristicData.requestNameOfRouteResponseValue);
    }

    @Test
    public void test_requestNameOfRouteResponseParameter_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        byte[] firstRequestNameOfRouteResponseParameter = new byte[1];
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
                , new byte[0]
                , 0
                , firstRequestNameOfRouteResponseParameter
                , 0
                , 0
                , 0);
        assertArrayEquals(firstRequestNameOfRouteResponseParameter, characteristicData.requestNameOfRouteResponseParameter);

        byte[] secondRequestNameOfRouteResponseParameter = new byte[2];
        characteristicData.requestNameOfRouteResponseParameter = secondRequestNameOfRouteResponseParameter;
        assertArrayEquals(secondRequestNameOfRouteResponseParameter, characteristicData.requestNameOfRouteResponseParameter);
    }

    @Test
    public void test_selectRouteResponseValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstSelectRouteResponseValue = 1;
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
                , new byte[0]
                , 0
                , new byte[0]
                , firstSelectRouteResponseValue
                , 0
                , 0);
        assertEquals(firstSelectRouteResponseValue, characteristicData.selectRouteResponseValue);

        int secondSelectRouteResponseValue = 11;
        characteristicData.selectRouteResponseValue = secondSelectRouteResponseValue;
        assertEquals(secondSelectRouteResponseValue, characteristicData.selectRouteResponseValue);
    }

    @Test
    public void test_setFixRateResponseValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstSetFixRateResponseValue = 1;
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
                , new byte[0]
                , 0
                , new byte[0]
                , 0
                , firstSetFixRateResponseValue
                , 0);
        assertEquals(firstSetFixRateResponseValue, characteristicData.setFixRateResponseValue);

        int secondSetFixRateResponseValue = 11;
        characteristicData.setFixRateResponseValue = secondSetFixRateResponseValue;
        assertEquals(secondSetFixRateResponseValue, characteristicData.setFixRateResponseValue);
    }

    @Test
    public void test_setElevationResponseValue_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstSetElevationResponseValue = 1;
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
                , new byte[0]
                , 0
                , new byte[0]
                , 0
                , 0
                , firstSetElevationResponseValue);
        assertEquals(firstSetElevationResponseValue, characteristicData.setElevationResponseValue);

        int secondSetElevationResponseValue = 11;
        characteristicData.setElevationResponseValue = secondSetElevationResponseValue;
        assertEquals(secondSetElevationResponseValue, characteristicData.setElevationResponseValue);
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
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
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
        assertEquals(result1.setCumulativeValueResponseValue, result2.setCumulativeValueResponseValue);
        assertEquals(result1.maskLocationAndSpeedCharacteristicContentResponseValue, result2.maskLocationAndSpeedCharacteristicContentResponseValue);
        assertEquals(result1.navigationControlResponseValue, result2.navigationControlResponseValue);
        assertEquals(result1.requestNumberOfRoutesResponseValue, result2.requestNumberOfRoutesResponseValue);
        assertArrayEquals(result1.requestNumberOfRoutesResponseParameter, result2.requestNumberOfRoutesResponseParameter);
        assertEquals(result1.requestNameOfRouteResponseValue, result2.requestNameOfRouteResponseValue);
        assertArrayEquals(result1.requestNameOfRouteResponseParameter, result2.requestNameOfRouteResponseParameter);
        assertEquals(result1.selectRouteResponseValue, result2.selectRouteResponseValue);
        assertEquals(result1.setFixRateResponseValue, result2.setFixRateResponseValue);
        assertEquals(result1.setElevationResponseValue, result2.setElevationResponseValue);
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
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
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
        assertEquals(result1.setCumulativeValueResponseValue, result2.setCumulativeValueResponseValue);
        assertEquals(result1.maskLocationAndSpeedCharacteristicContentResponseValue, result2.maskLocationAndSpeedCharacteristicContentResponseValue);
        assertEquals(result1.navigationControlResponseValue, result2.navigationControlResponseValue);
        assertEquals(result1.requestNumberOfRoutesResponseValue, result2.requestNumberOfRoutesResponseValue);
        assertArrayEquals(result1.requestNumberOfRoutesResponseParameter, result2.requestNumberOfRoutesResponseParameter);
        assertEquals(result1.requestNameOfRouteResponseValue, result2.requestNameOfRouteResponseValue);
        assertArrayEquals(result1.requestNameOfRouteResponseParameter, result2.requestNameOfRouteResponseParameter);
        assertEquals(result1.selectRouteResponseValue, result2.selectRouteResponseValue);
        assertEquals(result1.setFixRateResponseValue, result2.setFixRateResponseValue);
        assertEquals(result1.setElevationResponseValue, result2.setElevationResponseValue);
    }

    @Test
    public void test_hashCode_00001() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 7, null));
        int responseCode = 3;
        long delay = 4;
        int setCumulativeValueResponseValue = 5;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int navigationControlResponseValue = 7;
        int requestNumberOfRoutesResponseValue = 8;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{9};
        int requestNameOfRouteResponseValue = 10;
        byte[] requestNameOfRouteResponseParameter = new byte[]{11};
        int selectRouteResponseValue = 12;
        int setFixRateResponseValue = 13;
        int setElevationResponseValue = 14;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , maskLocationAndSpeedCharacteristicContentResponseValue
                , navigationControlResponseValue
                , requestNumberOfRoutesResponseValue
                , requestNumberOfRoutesResponseParameter
                , requestNameOfRouteResponseValue
                , requestNameOfRouteResponseParameter
                , selectRouteResponseValue
                , setFixRateResponseValue
                , setElevationResponseValue);
        assertEquals(LN_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(property).hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode(new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_RESPONSE_CODE, LNControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes())
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(setCumulativeValueResponseValue).hashCode()
                        ^ Integer.valueOf(maskLocationAndSpeedCharacteristicContentResponseValue).hashCode()
                        ^ Integer.valueOf(navigationControlResponseValue).hashCode()
                        ^ Integer.valueOf(requestNumberOfRoutesResponseValue).hashCode()
                        ^ Arrays.hashCode(requestNumberOfRoutesResponseParameter)
                        ^ Integer.valueOf(requestNameOfRouteResponseValue).hashCode()
                        ^ Arrays.hashCode(requestNameOfRouteResponseParameter)
                        ^ Integer.valueOf(selectRouteResponseValue).hashCode()
                        ^ Integer.valueOf(setFixRateResponseValue).hashCode()
                        ^ Integer.valueOf(setElevationResponseValue).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 19, 20, 21, null));
        int responseCode = 3;
        long delay = 4;
        byte[] currentData = new byte[]{5, 6};
        byte[] temporaryData = new byte[]{7, 8};
        int setCumulativeValueResponseValue = 9;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 10;
        int navigationControlResponseValue = 11;
        int requestNumberOfRoutesResponseValue = 12;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{13};
        int requestNameOfRouteResponseValue = 14;
        byte[] requestNameOfRouteResponseParameter = new byte[]{15};
        int selectRouteResponseValue = 16;
        int setFixRateResponseValue = 17;
        int setElevationResponseValue = 18;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , maskLocationAndSpeedCharacteristicContentResponseValue
                , navigationControlResponseValue
                , requestNumberOfRoutesResponseValue
                , requestNumberOfRoutesResponseParameter
                , requestNameOfRouteResponseValue
                , requestNameOfRouteResponseParameter
                , selectRouteResponseValue
                , setFixRateResponseValue
                , setElevationResponseValue);
        result1.currentData = currentData;
        result1.temporaryData = temporaryData;
        assertEquals(LN_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(property).hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode(new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_RESPONSE_CODE, LNControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes())
                        ^ Arrays.hashCode(currentData)
                        ^ Arrays.hashCode(temporaryData)
                        ^ Integer.valueOf(setCumulativeValueResponseValue).hashCode()
                        ^ Integer.valueOf(maskLocationAndSpeedCharacteristicContentResponseValue).hashCode()
                        ^ Integer.valueOf(navigationControlResponseValue).hashCode()
                        ^ Integer.valueOf(requestNumberOfRoutesResponseValue).hashCode()
                        ^ Arrays.hashCode(requestNumberOfRoutesResponseParameter)
                        ^ Integer.valueOf(requestNameOfRouteResponseValue).hashCode()
                        ^ Arrays.hashCode(requestNameOfRouteResponseParameter)
                        ^ Integer.valueOf(selectRouteResponseValue).hashCode()
                        ^ Integer.valueOf(setFixRateResponseValue).hashCode()
                        ^ Integer.valueOf(setElevationResponseValue).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        int secondProperty = 101;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(secondProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        int secondPermission = 102;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , secondPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 115, 116, 117, null));

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , secondDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        int secondResponseCode = 103;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , secondResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        int secondResponseCode = 103;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , secondResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        long secondDelay = 104;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , secondDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00008() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        int secondSetCumulativeValueResponseValue = 105;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , secondSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00009() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        int secondMaskLocationAndSpeedCharacteristicContentResponseValue = 106;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , secondMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00010() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        int secondNavigationControlResponseValue = 107;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , secondNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00011() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        int secondRequestNumberOfRoutesResponseValue = 109;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , secondRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00012() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        byte[] secondRequestNumberOfRoutesResponseParameter = new byte[]{110};

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , secondRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00013() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        int secondRequestNameOfRouteResponseValue = 111;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , secondRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00014() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        byte[] secondRequestNameOfRouteResponseParameter = new byte[]{111};

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , secondRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00015() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        int secondSelectRouteResponseValue = 112;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , secondSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00016() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        int secondSetFixRateResponseValue = 113;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , secondSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00017() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstSetCumulativeValueResponseValue = 5;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int firstNavigationControlResponseValue = 7;
        int firstRequestNumberOfRoutesResponseValue = 8;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{9};
        int firstRequestNameOfRouteResponseValue = 10;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{11};
        int firstSelectRouteResponseValue = 12;
        int firstSetFixRateResponseValue = 13;
        int firstSetElevationResponseValue = 14;

        int secondSetElevationResponseValue = 114;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , firstSetElevationResponseValue
        );
        LNControlPointCharacteristicData result2 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstSetCumulativeValueResponseValue
                , firstMaskLocationAndSpeedCharacteristicContentResponseValue
                , firstNavigationControlResponseValue
                , firstRequestNumberOfRoutesResponseValue
                , firstRequestNumberOfRoutesResponseParameter
                , firstRequestNameOfRouteResponseValue
                , firstRequestNameOfRouteResponseParameter
                , firstSelectRouteResponseValue
                , firstSetFixRateResponseValue
                , secondSetElevationResponseValue
        );
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_getBytes_00001() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, new byte[0], 0, 0, new byte[0]).getBytes();
        int setCumulativeValueResponseValue = 5;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int navigationControlResponseValue = 7;
        int requestNumberOfRoutesResponseValue = 8;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{9};
        int requestNameOfRouteResponseValue = 10;
        byte[] requestNameOfRouteResponseParameter = new byte[]{11};
        int selectRouteResponseValue = 12;
        int setFixRateResponseValue = 13;
        int setElevationResponseValue = 14;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , maskLocationAndSpeedCharacteristicContentResponseValue
                , navigationControlResponseValue
                , requestNumberOfRoutesResponseValue
                , requestNumberOfRoutesResponseParameter
                , requestNameOfRouteResponseValue
                , requestNameOfRouteResponseParameter
                , selectRouteResponseValue
                , setFixRateResponseValue
                , setElevationResponseValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, setCumulativeValueResponseValue, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00002() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT, new byte[0], 0, 0, new byte[0]).getBytes();
        int setCumulativeValueResponseValue = 5;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int navigationControlResponseValue = 7;
        int requestNumberOfRoutesResponseValue = 8;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{9};
        int requestNameOfRouteResponseValue = 10;
        byte[] requestNameOfRouteResponseParameter = new byte[]{11};
        int selectRouteResponseValue = 12;
        int setFixRateResponseValue = 13;
        int setElevationResponseValue = 14;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , maskLocationAndSpeedCharacteristicContentResponseValue
                , navigationControlResponseValue
                , requestNumberOfRoutesResponseValue
                , requestNumberOfRoutesResponseParameter
                , requestNameOfRouteResponseValue
                , requestNameOfRouteResponseParameter
                , selectRouteResponseValue
                , setFixRateResponseValue
                , setElevationResponseValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT, maskLocationAndSpeedCharacteristicContentResponseValue, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00003() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_NAVIGATION_CONTROL, new byte[0], 0, 0, new byte[0]).getBytes();
        int setCumulativeValueResponseValue = 5;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int navigationControlResponseValue = 7;
        int requestNumberOfRoutesResponseValue = 8;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{9};
        int requestNameOfRouteResponseValue = 10;
        byte[] requestNameOfRouteResponseParameter = new byte[]{11};
        int selectRouteResponseValue = 12;
        int setFixRateResponseValue = 13;
        int setElevationResponseValue = 14;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , maskLocationAndSpeedCharacteristicContentResponseValue
                , navigationControlResponseValue
                , requestNumberOfRoutesResponseValue
                , requestNumberOfRoutesResponseParameter
                , requestNameOfRouteResponseValue
                , requestNameOfRouteResponseParameter
                , selectRouteResponseValue
                , setFixRateResponseValue
                , setElevationResponseValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_NAVIGATION_CONTROL, navigationControlResponseValue, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00004() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_REQUEST_NUMBER_OF_ROUTES, new byte[0], 0, 0, new byte[0]).getBytes();
        int setCumulativeValueResponseValue = 5;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int navigationControlResponseValue = 7;
        int requestNumberOfRoutesResponseValue = 8;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{9};
        int requestNameOfRouteResponseValue = 10;
        byte[] requestNameOfRouteResponseParameter = new byte[]{11};
        int selectRouteResponseValue = 12;
        int setFixRateResponseValue = 13;
        int setElevationResponseValue = 14;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , maskLocationAndSpeedCharacteristicContentResponseValue
                , navigationControlResponseValue
                , requestNumberOfRoutesResponseValue
                , requestNumberOfRoutesResponseParameter
                , requestNameOfRouteResponseValue
                , requestNameOfRouteResponseParameter
                , selectRouteResponseValue
                , setFixRateResponseValue
                , setElevationResponseValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_REQUEST_NUMBER_OF_ROUTES, requestNumberOfRoutesResponseValue, requestNumberOfRoutesResponseParameter).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00005() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_REQUEST_NAME_OF_ROUTE, new byte[0], 0, 0, new byte[0]).getBytes();
        int setCumulativeValueResponseValue = 5;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int navigationControlResponseValue = 7;
        int requestNumberOfRoutesResponseValue = 8;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{9};
        int requestNameOfRouteResponseValue = 10;
        byte[] requestNameOfRouteResponseParameter = new byte[]{11};
        int selectRouteResponseValue = 12;
        int setFixRateResponseValue = 13;
        int setElevationResponseValue = 14;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , maskLocationAndSpeedCharacteristicContentResponseValue
                , navigationControlResponseValue
                , requestNumberOfRoutesResponseValue
                , requestNumberOfRoutesResponseParameter
                , requestNameOfRouteResponseValue
                , requestNameOfRouteResponseParameter
                , selectRouteResponseValue
                , setFixRateResponseValue
                , setElevationResponseValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_REQUEST_NAME_OF_ROUTE, requestNameOfRouteResponseValue, requestNameOfRouteResponseParameter).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00006() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_SELECT_ROUTE, new byte[0], 0, 0, new byte[0]).getBytes();
        int setCumulativeValueResponseValue = 5;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int navigationControlResponseValue = 7;
        int requestNumberOfRoutesResponseValue = 8;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{9};
        int requestNameOfRouteResponseValue = 10;
        byte[] requestNameOfRouteResponseParameter = new byte[]{11};
        int selectRouteResponseValue = 12;
        int setFixRateResponseValue = 13;
        int setElevationResponseValue = 14;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , maskLocationAndSpeedCharacteristicContentResponseValue
                , navigationControlResponseValue
                , requestNumberOfRoutesResponseValue
                , requestNumberOfRoutesResponseParameter
                , requestNameOfRouteResponseValue
                , requestNameOfRouteResponseParameter
                , selectRouteResponseValue
                , setFixRateResponseValue
                , setElevationResponseValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SELECT_ROUTE, selectRouteResponseValue, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00007() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_SET_FIX_RATE, new byte[0], 0, 0, new byte[0]).getBytes();
        int setCumulativeValueResponseValue = 5;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int navigationControlResponseValue = 7;
        int requestNumberOfRoutesResponseValue = 8;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{9};
        int requestNameOfRouteResponseValue = 10;
        byte[] requestNameOfRouteResponseParameter = new byte[]{11};
        int selectRouteResponseValue = 12;
        int setFixRateResponseValue = 13;
        int setElevationResponseValue = 14;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , maskLocationAndSpeedCharacteristicContentResponseValue
                , navigationControlResponseValue
                , requestNumberOfRoutesResponseValue
                , requestNumberOfRoutesResponseParameter
                , requestNameOfRouteResponseValue
                , requestNameOfRouteResponseParameter
                , selectRouteResponseValue
                , setFixRateResponseValue
                , setElevationResponseValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SET_FIX_RATE, setFixRateResponseValue, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00008() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_SET_ELEVATION, new byte[0], 0, 0, new byte[0]).getBytes();
        int setCumulativeValueResponseValue = 5;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int navigationControlResponseValue = 7;
        int requestNumberOfRoutesResponseValue = 8;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{9};
        int requestNameOfRouteResponseValue = 10;
        byte[] requestNameOfRouteResponseParameter = new byte[]{11};
        int selectRouteResponseValue = 12;
        int setFixRateResponseValue = 13;
        int setElevationResponseValue = 14;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , maskLocationAndSpeedCharacteristicContentResponseValue
                , navigationControlResponseValue
                , requestNumberOfRoutesResponseValue
                , requestNumberOfRoutesResponseParameter
                , requestNameOfRouteResponseValue
                , requestNameOfRouteResponseParameter
                , selectRouteResponseValue
                , setFixRateResponseValue
                , setElevationResponseValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SET_ELEVATION, setElevationResponseValue, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00009() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], 0, 0, new byte[0]).getBytes();
        int setCumulativeValueResponseValue = 5;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int navigationControlResponseValue = 7;
        int requestNumberOfRoutesResponseValue = 8;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{9};
        int requestNameOfRouteResponseValue = 10;
        byte[] requestNameOfRouteResponseParameter = new byte[]{11};
        int selectRouteResponseValue = 12;
        int setFixRateResponseValue = 13;
        int setElevationResponseValue = 14;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , maskLocationAndSpeedCharacteristicContentResponseValue
                , navigationControlResponseValue
                , requestNumberOfRoutesResponseValue
                , requestNumberOfRoutesResponseParameter
                , requestNameOfRouteResponseValue
                , requestNameOfRouteResponseParameter
                , selectRouteResponseValue
                , setFixRateResponseValue
                , setElevationResponseValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_RESPONSE_CODE, LNControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00010() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int responseCode = 3;
        long delay = 4;
        int setCumulativeValueResponseValue = 5;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int navigationControlResponseValue = 7;
        int requestNumberOfRoutesResponseValue = 8;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{9};
        int requestNameOfRouteResponseValue = 10;
        byte[] requestNameOfRouteResponseParameter = new byte[]{11};
        int selectRouteResponseValue = 12;
        int setFixRateResponseValue = 13;
        int setElevationResponseValue = 14;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , maskLocationAndSpeedCharacteristicContentResponseValue
                , navigationControlResponseValue
                , requestNumberOfRoutesResponseValue
                , requestNumberOfRoutesResponseParameter
                , requestNameOfRouteResponseValue
                , requestNameOfRouteResponseParameter
                , selectRouteResponseValue
                , setFixRateResponseValue
                , setElevationResponseValue);
        result1.currentData = new LNControlPoint(LNControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, new byte[0], 0, 0, new byte[0]).getBytes();

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, setCumulativeValueResponseValue, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00011() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(-1, new byte[0], 0, 0, new byte[0]).getBytes();
        int setCumulativeValueResponseValue = 5;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int navigationControlResponseValue = 7;
        int requestNumberOfRoutesResponseValue = 8;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{9};
        int requestNameOfRouteResponseValue = 10;
        byte[] requestNameOfRouteResponseParameter = new byte[]{11};
        int selectRouteResponseValue = 12;
        int setFixRateResponseValue = 13;
        int setElevationResponseValue = 14;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , maskLocationAndSpeedCharacteristicContentResponseValue
                , navigationControlResponseValue
                , requestNumberOfRoutesResponseValue
                , requestNumberOfRoutesResponseParameter
                , requestNameOfRouteResponseValue
                , requestNameOfRouteResponseParameter
                , selectRouteResponseValue
                , setFixRateResponseValue
                , setElevationResponseValue);
        result1.currentData = data;

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], -1, LNControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

    @Test
    public void test_getBytes_00012() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 15, 16, 17, null));
        int responseCode = 3;
        long delay = 4;
        int setCumulativeValueResponseValue = 5;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 6;
        int navigationControlResponseValue = 7;
        int requestNumberOfRoutesResponseValue = 8;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{9};
        int requestNameOfRouteResponseValue = 10;
        byte[] requestNameOfRouteResponseParameter = new byte[]{11};
        int selectRouteResponseValue = 12;
        int setFixRateResponseValue = 13;
        int setElevationResponseValue = 14;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , setCumulativeValueResponseValue
                , maskLocationAndSpeedCharacteristicContentResponseValue
                , navigationControlResponseValue
                , requestNumberOfRoutesResponseValue
                , requestNumberOfRoutesResponseParameter
                , requestNameOfRouteResponseValue
                , requestNameOfRouteResponseParameter
                , selectRouteResponseValue
                , setFixRateResponseValue
                , setElevationResponseValue);
        result1.currentData = new byte[0];

        byte[] result2 = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_RESPONSE_CODE, LNControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
        assertArrayEquals(result2, result1.getBytes());
    }

}
