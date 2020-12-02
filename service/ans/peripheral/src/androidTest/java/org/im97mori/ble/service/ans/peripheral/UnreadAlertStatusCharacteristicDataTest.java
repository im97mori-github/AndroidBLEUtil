package org.im97mori.ble.service.ans.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.DescriptorData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.UNREAD_ALERT_STATUS_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UnreadAlertStatusCharacteristicDataTest {

    @Test
    public void test_constructor_00001() {
        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , new ArrayList<DescriptorData>());

        Gson gson = new Gson();
        UnreadAlertStatusCharacteristicData result2 = gson.fromJson(gson.toJson(result1), UnreadAlertStatusCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertTrue(result2.descriptorDataList.isEmpty());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.simpleAlertUnreadCount, result2.simpleAlertUnreadCount);
        assertEquals(result1.emailUnreadCount, result2.emailUnreadCount);
        assertEquals(result1.newsUnreadCount, result2.newsUnreadCount);
        assertEquals(result1.callUnreadCount, result2.callUnreadCount);
        assertEquals(result1.missedCallUnreadCount, result2.missedCallUnreadCount);
        assertEquals(result1.smsMmsUnreadCount, result2.smsMmsUnreadCount);
        assertEquals(result1.voiceMailUnreadCount, result2.voiceMailUnreadCount);
        assertEquals(result1.scheduleUnreadCount, result2.scheduleUnreadCount);
        assertEquals(result1.highPrioritizedAlertUnreadCount, result2.highPrioritizedAlertUnreadCount);
        assertEquals(result1.instantMessageAlertUnreadCount, result2.instantMessageAlertUnreadCount);
    }

    @Test
    public void test_simpleAlertUnreadCount_00001() {
        int firstSimpleAlertUnreadCount = 1;
        UnreadAlertStatusCharacteristicData characteristicData = new UnreadAlertStatusCharacteristicData(firstSimpleAlertUnreadCount
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , new ArrayList<DescriptorData>());
        assertEquals(firstSimpleAlertUnreadCount, characteristicData.simpleAlertUnreadCount);

        int secondSimpleAlertUnreadCount = 101;
        characteristicData.simpleAlertUnreadCount = secondSimpleAlertUnreadCount;
        assertEquals(secondSimpleAlertUnreadCount, characteristicData.simpleAlertUnreadCount);
    }

    @Test
    public void test_emailUnreadCount_00001() {
        int firstEmailUnreadCount = 1;
        UnreadAlertStatusCharacteristicData characteristicData = new UnreadAlertStatusCharacteristicData(0
                , firstEmailUnreadCount
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , new ArrayList<DescriptorData>());
        assertEquals(firstEmailUnreadCount, characteristicData.emailUnreadCount);

        int secondEmailUnreadCount = 101;
        characteristicData.emailUnreadCount = secondEmailUnreadCount;
        assertEquals(secondEmailUnreadCount, characteristicData.emailUnreadCount);
    }

    @Test
    public void test_newsUnreadCount_00001() {
        int firstNewsUnreadCount = 1;
        UnreadAlertStatusCharacteristicData characteristicData = new UnreadAlertStatusCharacteristicData(0
                , 0
                , firstNewsUnreadCount
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , new ArrayList<DescriptorData>());
        assertEquals(firstNewsUnreadCount, characteristicData.newsUnreadCount);

        int secondNewsUnreadCount = 101;
        characteristicData.newsUnreadCount = secondNewsUnreadCount;
        assertEquals(secondNewsUnreadCount, characteristicData.newsUnreadCount);
    }

    @Test
    public void test_callUnreadCount_00001() {
        int firstCallUnreadCount = 1;
        UnreadAlertStatusCharacteristicData characteristicData = new UnreadAlertStatusCharacteristicData(0
                , 0
                , 0
                , firstCallUnreadCount
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , new ArrayList<DescriptorData>());
        assertEquals(firstCallUnreadCount, characteristicData.callUnreadCount);

        int secondCallUnreadCount = 101;
        characteristicData.callUnreadCount = secondCallUnreadCount;
        assertEquals(secondCallUnreadCount, characteristicData.callUnreadCount);
    }

    @Test
    public void test_missedCallUnreadCount_00001() {
        int firstMissedCallUnreadCount = 1;
        UnreadAlertStatusCharacteristicData characteristicData = new UnreadAlertStatusCharacteristicData(0
                , 0
                , 0
                , 0
                , firstMissedCallUnreadCount
                , 0
                , 0
                , 0
                , 0
                , 0
                , new ArrayList<DescriptorData>());
        assertEquals(firstMissedCallUnreadCount, characteristicData.missedCallUnreadCount);

        int secondMissedCallUnreadCount = 101;
        characteristicData.missedCallUnreadCount = secondMissedCallUnreadCount;
        assertEquals(secondMissedCallUnreadCount, characteristicData.missedCallUnreadCount);
    }

    @Test
    public void test_smsMmsUnreadCount_00001() {
        int firstSmsMmsUnreadCount = 1;
        UnreadAlertStatusCharacteristicData characteristicData = new UnreadAlertStatusCharacteristicData(0
                , 0
                , 0
                , 0
                , 0
                , firstSmsMmsUnreadCount
                , 0
                , 0
                , 0
                , 0
                , new ArrayList<DescriptorData>());
        assertEquals(firstSmsMmsUnreadCount, characteristicData.smsMmsUnreadCount);

        int secondSmsMmsUnreadCount = 101;
        characteristicData.smsMmsUnreadCount = secondSmsMmsUnreadCount;
        assertEquals(secondSmsMmsUnreadCount, characteristicData.smsMmsUnreadCount);
    }

    @Test
    public void test_voiceMailUnreadCount_00001() {
        int firstVoiceMailUnreadCount = 1;
        UnreadAlertStatusCharacteristicData characteristicData = new UnreadAlertStatusCharacteristicData(0
                , 0
                , 0
                , 0
                , 0
                , 0
                , firstVoiceMailUnreadCount
                , 0
                , 0
                , 0
                , new ArrayList<DescriptorData>());
        assertEquals(firstVoiceMailUnreadCount, characteristicData.voiceMailUnreadCount);

        int secondVoiceMailUnreadCount = 101;
        characteristicData.voiceMailUnreadCount = secondVoiceMailUnreadCount;
        assertEquals(secondVoiceMailUnreadCount, characteristicData.voiceMailUnreadCount);
    }

    @Test
    public void test_scheduleUnreadCount_00001() {
        int firstScheduleUnreadCount = 1;
        UnreadAlertStatusCharacteristicData characteristicData = new UnreadAlertStatusCharacteristicData(0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , firstScheduleUnreadCount
                , 0
                , 0
                , new ArrayList<DescriptorData>());
        assertEquals(firstScheduleUnreadCount, characteristicData.scheduleUnreadCount);

        int secondScheduleUnreadCount = 101;
        characteristicData.scheduleUnreadCount = secondScheduleUnreadCount;
        assertEquals(secondScheduleUnreadCount, characteristicData.scheduleUnreadCount);
    }

    @Test
    public void test_highPrioritizedAlertUnreadCount_00001() {
        int firstHighPrioritizedAlertUnreadCount = 1;
        UnreadAlertStatusCharacteristicData characteristicData = new UnreadAlertStatusCharacteristicData(0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , firstHighPrioritizedAlertUnreadCount
                , 0
                , new ArrayList<DescriptorData>());
        assertEquals(firstHighPrioritizedAlertUnreadCount, characteristicData.highPrioritizedAlertUnreadCount);

        int secondHighPrioritizedAlertUnreadCount = 101;
        characteristicData.highPrioritizedAlertUnreadCount = secondHighPrioritizedAlertUnreadCount;
        assertEquals(secondHighPrioritizedAlertUnreadCount, characteristicData.highPrioritizedAlertUnreadCount);
    }

    @Test
    public void test_instantMessageAlertUnreadCount_00001() {
        int firstInstantMessageAlertUnreadCount = 1;
        UnreadAlertStatusCharacteristicData characteristicData = new UnreadAlertStatusCharacteristicData(0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , firstInstantMessageAlertUnreadCount
                , new ArrayList<DescriptorData>());
        assertEquals(firstInstantMessageAlertUnreadCount, characteristicData.instantMessageAlertUnreadCount);

        int secondInstantMessageAlertUnreadCount = 101;
        characteristicData.instantMessageAlertUnreadCount = secondInstantMessageAlertUnreadCount;
        assertEquals(secondInstantMessageAlertUnreadCount, characteristicData.instantMessageAlertUnreadCount);
    }

    @Test
    public void test_parcelable_00001() {
        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , new ArrayList<DescriptorData>());
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UnreadAlertStatusCharacteristicData result2 = UnreadAlertStatusCharacteristicData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.simpleAlertUnreadCount, result2.simpleAlertUnreadCount);
        assertEquals(result1.emailUnreadCount, result2.emailUnreadCount);
        assertEquals(result1.newsUnreadCount, result2.newsUnreadCount);
        assertEquals(result1.callUnreadCount, result2.callUnreadCount);
        assertEquals(result1.missedCallUnreadCount, result2.missedCallUnreadCount);
        assertEquals(result1.smsMmsUnreadCount, result2.smsMmsUnreadCount);
        assertEquals(result1.voiceMailUnreadCount, result2.voiceMailUnreadCount);
        assertEquals(result1.scheduleUnreadCount, result2.scheduleUnreadCount);
        assertEquals(result1.highPrioritizedAlertUnreadCount, result2.highPrioritizedAlertUnreadCount);
        assertEquals(result1.instantMessageAlertUnreadCount, result2.instantMessageAlertUnreadCount);
    }

    @Test
    public void test_hashCode_00001() {
        int property = BluetoothGattCharacteristic.PROPERTY_NOTIFY;
        int permission = 0;
        int responseCode = BluetoothGatt.GATT_SUCCESS;
        int simpleAlertNumberOfNewAlert = 1;
        int emailNumberOfNewAlert = 2;
        int newsNumberOfNewAlert = 3;
        int callNumberOfNewAlert = 4;
        int missedCallNumberOfNewAlert = 5;
        int smsMmsNumberOfNewAlert = 6;
        int voiceMailNumberOfNewAlert = 7;
        int scheduleNumberOfNewAlert = 8;
        int highPrioritizedAlertNumberOfNewAlert = 9;
        int instantMessageAlertNumberOfNewAlert = 10;
        long delay = 0;
        int notificationCount = 1;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(simpleAlertNumberOfNewAlert
                , emailNumberOfNewAlert
                , newsNumberOfNewAlert
                , callNumberOfNewAlert
                , missedCallNumberOfNewAlert
                , smsMmsNumberOfNewAlert
                , voiceMailNumberOfNewAlert
                , scheduleNumberOfNewAlert
                , highPrioritizedAlertNumberOfNewAlert
                , instantMessageAlertNumberOfNewAlert
                , descriptorDataList);
        assertEquals(UNREAD_ALERT_STATUS_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(property).hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Integer.valueOf(notificationCount).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(simpleAlertNumberOfNewAlert).hashCode()
                        ^ Integer.valueOf(emailNumberOfNewAlert).hashCode()
                        ^ Integer.valueOf(newsNumberOfNewAlert).hashCode()
                        ^ Integer.valueOf(callNumberOfNewAlert).hashCode()
                        ^ Integer.valueOf(missedCallNumberOfNewAlert).hashCode()
                        ^ Integer.valueOf(smsMmsNumberOfNewAlert).hashCode()
                        ^ Integer.valueOf(voiceMailNumberOfNewAlert).hashCode()
                        ^ Integer.valueOf(scheduleNumberOfNewAlert).hashCode()
                        ^ Integer.valueOf(highPrioritizedAlertNumberOfNewAlert).hashCode()
                        ^ Integer.valueOf(instantMessageAlertNumberOfNewAlert).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        int firstEmailNumberOfNewAlert = 2;
        int firstNewsNumberOfNewAlert = 3;
        int firstCallNumberOfNewAlert = 4;
        int firstMissedCallNumberOfNewAlert = 5;
        int firstSmsMmsNumberOfNewAlert = 6;
        int firstVoiceMailNumberOfNewAlert = 7;
        int firstScheduleNumberOfNewAlert = 8;
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        UnreadAlertStatusCharacteristicData result2 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        int firstEmailNumberOfNewAlert = 2;
        int firstNewsNumberOfNewAlert = 3;
        int firstCallNumberOfNewAlert = 4;
        int firstMissedCallNumberOfNewAlert = 5;
        int firstSmsMmsNumberOfNewAlert = 6;
        int firstVoiceMailNumberOfNewAlert = 7;
        int firstScheduleNumberOfNewAlert = 8;
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondSimpleAlertNumberOfNewAlert = 101;

        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        UnreadAlertStatusCharacteristicData result2 = new UnreadAlertStatusCharacteristicData(secondSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        int firstEmailNumberOfNewAlert = 2;
        int firstNewsNumberOfNewAlert = 3;
        int firstCallNumberOfNewAlert = 4;
        int firstMissedCallNumberOfNewAlert = 5;
        int firstSmsMmsNumberOfNewAlert = 6;
        int firstVoiceMailNumberOfNewAlert = 7;
        int firstScheduleNumberOfNewAlert = 8;
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondEmailNumberOfNewAlert = 101;

        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        UnreadAlertStatusCharacteristicData result2 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , secondEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        int firstEmailNumberOfNewAlert = 2;
        int firstNewsNumberOfNewAlert = 3;
        int firstCallNumberOfNewAlert = 4;
        int firstMissedCallNumberOfNewAlert = 5;
        int firstSmsMmsNumberOfNewAlert = 6;
        int firstVoiceMailNumberOfNewAlert = 7;
        int firstScheduleNumberOfNewAlert = 8;
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondNewsNumberOfNewAlert = 101;

        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        UnreadAlertStatusCharacteristicData result2 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , secondNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        int firstEmailNumberOfNewAlert = 2;
        int firstNewsNumberOfNewAlert = 3;
        int firstCallNumberOfNewAlert = 4;
        int firstMissedCallNumberOfNewAlert = 5;
        int firstSmsMmsNumberOfNewAlert = 6;
        int firstVoiceMailNumberOfNewAlert = 7;
        int firstScheduleNumberOfNewAlert = 8;
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondCallNumberOfNewAlert = 101;

        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        UnreadAlertStatusCharacteristicData result2 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , secondCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        int firstEmailNumberOfNewAlert = 2;
        int firstNewsNumberOfNewAlert = 3;
        int firstCallNumberOfNewAlert = 4;
        int firstMissedCallNumberOfNewAlert = 5;
        int firstSmsMmsNumberOfNewAlert = 6;
        int firstVoiceMailNumberOfNewAlert = 7;
        int firstScheduleNumberOfNewAlert = 8;
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondMissedCallNumberOfNewAlert = 101;

        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        UnreadAlertStatusCharacteristicData result2 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , secondMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        int firstEmailNumberOfNewAlert = 2;
        int firstNewsNumberOfNewAlert = 3;
        int firstCallNumberOfNewAlert = 4;
        int firstMissedCallNumberOfNewAlert = 5;
        int firstSmsMmsNumberOfNewAlert = 6;
        int firstVoiceMailNumberOfNewAlert = 7;
        int firstScheduleNumberOfNewAlert = 8;
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondSmsMmsNumberOfNewAlert = 101;

        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        UnreadAlertStatusCharacteristicData result2 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , secondSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00008() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        int firstEmailNumberOfNewAlert = 2;
        int firstNewsNumberOfNewAlert = 3;
        int firstCallNumberOfNewAlert = 4;
        int firstMissedCallNumberOfNewAlert = 5;
        int firstSmsMmsNumberOfNewAlert = 6;
        int firstVoiceMailNumberOfNewAlert = 7;
        int firstScheduleNumberOfNewAlert = 8;
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondVoiceMailNumberOfNewAlert = 101;

        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        UnreadAlertStatusCharacteristicData result2 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , secondVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00009() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        int firstEmailNumberOfNewAlert = 2;
        int firstNewsNumberOfNewAlert = 3;
        int firstCallNumberOfNewAlert = 4;
        int firstMissedCallNumberOfNewAlert = 5;
        int firstSmsMmsNumberOfNewAlert = 6;
        int firstVoiceMailNumberOfNewAlert = 7;
        int firstScheduleNumberOfNewAlert = 8;
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondScheduleNumberOfNewAlert = 101;

        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        UnreadAlertStatusCharacteristicData result2 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , secondScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00010() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        int firstEmailNumberOfNewAlert = 2;
        int firstNewsNumberOfNewAlert = 3;
        int firstCallNumberOfNewAlert = 4;
        int firstMissedCallNumberOfNewAlert = 5;
        int firstSmsMmsNumberOfNewAlert = 6;
        int firstVoiceMailNumberOfNewAlert = 7;
        int firstScheduleNumberOfNewAlert = 8;
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondHighPrioritizedAlertNumberOfNewAlert = 101;

        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        UnreadAlertStatusCharacteristicData result2 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , secondHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00011() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        int firstEmailNumberOfNewAlert = 2;
        int firstNewsNumberOfNewAlert = 3;
        int firstCallNumberOfNewAlert = 4;
        int firstMissedCallNumberOfNewAlert = 5;
        int firstSmsMmsNumberOfNewAlert = 6;
        int firstVoiceMailNumberOfNewAlert = 7;
        int firstScheduleNumberOfNewAlert = 8;
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondInstantMessageAlertNumberOfNewAlert = 101;

        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        UnreadAlertStatusCharacteristicData result2 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , secondInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00012() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        int firstEmailNumberOfNewAlert = 2;
        int firstNewsNumberOfNewAlert = 3;
        int firstCallNumberOfNewAlert = 4;
        int firstMissedCallNumberOfNewAlert = 5;
        int firstSmsMmsNumberOfNewAlert = 6;
        int firstVoiceMailNumberOfNewAlert = 7;
        int firstScheduleNumberOfNewAlert = 8;
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 111, 112, 13, new byte[]{120}));

        UnreadAlertStatusCharacteristicData result1 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , firstDescriptorDataList);
        UnreadAlertStatusCharacteristicData result2 = new UnreadAlertStatusCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstEmailNumberOfNewAlert
                , firstNewsNumberOfNewAlert
                , firstCallNumberOfNewAlert
                , firstMissedCallNumberOfNewAlert
                , firstSmsMmsNumberOfNewAlert
                , firstVoiceMailNumberOfNewAlert
                , firstScheduleNumberOfNewAlert
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstInstantMessageAlertNumberOfNewAlert
                , secondDescriptorDataList);
        assertNotEquals(result1, result2);
    }

}
