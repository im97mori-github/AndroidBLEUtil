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
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        int notificationCount = 7;
        int setCumulativeValueResponseValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int navigationControlResponseValue = 10;
        int requestNumberOfRoutesResponseValue = 11;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{12};
        int requestNameOfRouteResponseValue = 13;
        byte[] requestNameOfRouteResponseParameter = new byte[]{14};
        int selectRouteResponseValue = 15;
        int setFixRateResponseValue = 16;
        int setElevationResponseValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
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
                        ^ Integer.valueOf(notificationCount).hashCode()
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
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] currentData = new byte[]{7, 8};
        byte[] temporaryData = new byte[]{9, 10};
        int notificationCount = 11;
        int setCumulativeValueResponseValue = 12;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 13;
        int navigationControlResponseValue = 14;
        int requestNumberOfRoutesResponseValue = 15;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{16};
        int requestNameOfRouteResponseValue = 17;
        byte[] requestNameOfRouteResponseParameter = new byte[]{18};
        int selectRouteResponseValue = 19;
        int setFixRateResponseValue = 20;
        int setElevationResponseValue = 21;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
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
                        ^ Integer.valueOf(notificationCount).hashCode()
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
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        int secondProperty = 101;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        int secondPermission = 102;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 22, 33, null));

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        int secondResponseCode = 103;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        int secondResponseCode = 104;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        long secondDelay = 104;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
    public void test_equals_00009() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        int secondNotificationCount = 107;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , secondNotificationCount
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
    public void test_equals_00010() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        int secondSetCumulativeValueResponseValue = 108;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
    public void test_equals_00011() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        int secondMaskLocationAndSpeedCharacteristicContentResponseValue = 109;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
    public void test_equals_00012() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        int secondNavigationControlResponseValue = 110;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
    public void test_equals_00013() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        int secondRequestNumberOfRoutesResponseValue = 111;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
    public void test_equals_00014() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        byte[] secondRequestNumberOfRoutesResponseParameter = new byte[]{112};

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
    public void test_equals_00015() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        int secondRequestNameOfRouteResponseValue = 113;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
    public void test_equals_00016() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        byte[] secondRequestNameOfRouteResponseParameter = new byte[]{114};

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
    public void test_equals_00017() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        int secondSelectRouteResponseValue = 115;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
    public void test_equals_00018() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        int secondSetFixRateResponseValue = 116;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
    public void test_equals_00019() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        int firstNotificationCount = 7;
        int firstSetCumulativeValueResponseValue = 8;
        int firstMaskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int firstNavigationControlResponseValue = 10;
        int firstRequestNumberOfRoutesResponseValue = 11;
        byte[] firstRequestNumberOfRoutesResponseParameter = new byte[]{12};
        int firstRequestNameOfRouteResponseValue = 13;
        byte[] firstRequestNameOfRouteResponseParameter = new byte[]{14};
        int firstSelectRouteResponseValue = 15;
        int firstSetFixRateResponseValue = 16;
        int firstSetElevationResponseValue = 17;

        int secondSetElevationResponseValue = 117;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstResponseCode
                , firstDelay
                , firstNotificationCount
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
                , firstNotificationCount
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
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponseValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int navigationControlResponseValue = 10;
        int requestNumberOfRoutesResponseValue = 11;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{12};
        int requestNameOfRouteResponseValue = 13;
        byte[] requestNameOfRouteResponseParameter = new byte[]{14};
        int selectRouteResponseValue = 15;
        int setFixRateResponseValue = 16;
        int setElevationResponseValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
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
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponseValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int navigationControlResponseValue = 10;
        int requestNumberOfRoutesResponseValue = 11;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{12};
        int requestNameOfRouteResponseValue = 13;
        byte[] requestNameOfRouteResponseParameter = new byte[]{14};
        int selectRouteResponseValue = 15;
        int setFixRateResponseValue = 16;
        int setElevationResponseValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
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
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_NAVIGATION_CONTROL, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponseValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int navigationControlResponseValue = 10;
        int requestNumberOfRoutesResponseValue = 11;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{12};
        int requestNameOfRouteResponseValue = 13;
        byte[] requestNameOfRouteResponseParameter = new byte[]{14};
        int selectRouteResponseValue = 15;
        int setFixRateResponseValue = 16;
        int setElevationResponseValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
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
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_REQUEST_NUMBER_OF_ROUTES, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponseValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int navigationControlResponseValue = 10;
        int requestNumberOfRoutesResponseValue = 11;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{12};
        int requestNameOfRouteResponseValue = 13;
        byte[] requestNameOfRouteResponseParameter = new byte[]{14};
        int selectRouteResponseValue = 15;
        int setFixRateResponseValue = 16;
        int setElevationResponseValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
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
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_REQUEST_NAME_OF_ROUTE, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponseValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int navigationControlResponseValue = 10;
        int requestNumberOfRoutesResponseValue = 11;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{12};
        int requestNameOfRouteResponseValue = 13;
        byte[] requestNameOfRouteResponseParameter = new byte[]{14};
        int selectRouteResponseValue = 15;
        int setFixRateResponseValue = 16;
        int setElevationResponseValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
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
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_SELECT_ROUTE, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponseValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int navigationControlResponseValue = 10;
        int requestNumberOfRoutesResponseValue = 11;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{12};
        int requestNameOfRouteResponseValue = 13;
        byte[] requestNameOfRouteResponseParameter = new byte[]{14};
        int selectRouteResponseValue = 15;
        int setFixRateResponseValue = 16;
        int setElevationResponseValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
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
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_SET_FIX_RATE, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponseValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int navigationControlResponseValue = 10;
        int requestNumberOfRoutesResponseValue = 11;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{12};
        int requestNameOfRouteResponseValue = 13;
        byte[] requestNameOfRouteResponseParameter = new byte[]{14};
        int selectRouteResponseValue = 15;
        int setFixRateResponseValue = 16;
        int setElevationResponseValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
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
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_SET_ELEVATION, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponseValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int navigationControlResponseValue = 10;
        int requestNumberOfRoutesResponseValue = 11;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{12};
        int requestNameOfRouteResponseValue = 13;
        byte[] requestNameOfRouteResponseParameter = new byte[]{14};
        int selectRouteResponseValue = 15;
        int setFixRateResponseValue = 16;
        int setElevationResponseValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
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
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponseValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int navigationControlResponseValue = 10;
        int requestNumberOfRoutesResponseValue = 11;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{12};
        int requestNameOfRouteResponseValue = 13;
        byte[] requestNameOfRouteResponseParameter = new byte[]{14};
        int selectRouteResponseValue = 15;
        int setFixRateResponseValue = 16;
        int setElevationResponseValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
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
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        int notificationCount = 7;
        int setCumulativeValueResponseValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int navigationControlResponseValue = 10;
        int requestNumberOfRoutesResponseValue = 11;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{12};
        int requestNameOfRouteResponseValue = 13;
        byte[] requestNameOfRouteResponseParameter = new byte[]{14};
        int selectRouteResponseValue = 15;
        int setFixRateResponseValue = 16;
        int setElevationResponseValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
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
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new LNControlPoint(-1, new byte[0], 0, 0, new byte[0]).getBytes();
        int notificationCount = 7;
        int setCumulativeValueResponseValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int navigationControlResponseValue = 10;
        int requestNumberOfRoutesResponseValue = 11;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{12};
        int requestNameOfRouteResponseValue = 13;
        byte[] requestNameOfRouteResponseParameter = new byte[]{14};
        int selectRouteResponseValue = 15;
        int setFixRateResponseValue = 16;
        int setElevationResponseValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
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
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        int notificationCount = 7;
        int setCumulativeValueResponseValue = 8;
        int maskLocationAndSpeedCharacteristicContentResponseValue = 9;
        int navigationControlResponseValue = 10;
        int requestNumberOfRoutesResponseValue = 11;
        byte[] requestNumberOfRoutesResponseParameter = new byte[]{12};
        int requestNameOfRouteResponseValue = 13;
        byte[] requestNameOfRouteResponseParameter = new byte[]{14};
        int selectRouteResponseValue = 15;
        int setFixRateResponseValue = 16;
        int setElevationResponseValue = 17;

        LNControlPointCharacteristicData result1 = new LNControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , notificationCount
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
