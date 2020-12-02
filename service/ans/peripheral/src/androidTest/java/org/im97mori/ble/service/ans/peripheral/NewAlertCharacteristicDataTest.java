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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.NEW_ALERT_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class NewAlertCharacteristicDataTest {

    @Test
    public void test_constructor_00001() {
        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(1
                , "a"
                , 2
                , "b"
                , 3
                , "c"
                , 4
                , "d"
                , 5
                , "e"
                , 6
                , "f"
                , 7
                , "g"
                , 8
                , "h"
                , 9
                , "i"
                , 10
                , "j"
                , new ArrayList<DescriptorData>());

        Gson gson = new Gson();
        NewAlertCharacteristicData result2 = gson.fromJson(gson.toJson(result1), NewAlertCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertTrue(result2.descriptorDataList.isEmpty());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.simpleAlertNumberOfNewAlert, result2.simpleAlertNumberOfNewAlert);
        assertEquals(result1.simpleAlertTextStringInformation, result2.simpleAlertTextStringInformation);
        assertEquals(result1.emailNumberOfNewAlert, result2.emailNumberOfNewAlert);
        assertEquals(result1.emailTextStringInformation, result2.emailTextStringInformation);
        assertEquals(result1.newsNumberOfNewAlert, result2.newsNumberOfNewAlert);
        assertEquals(result1.newsTextStringInformation, result2.newsTextStringInformation);
        assertEquals(result1.callNumberOfNewAlert, result2.callNumberOfNewAlert);
        assertEquals(result1.callTextStringInformation, result2.callTextStringInformation);
        assertEquals(result1.missedCallNumberOfNewAlert, result2.missedCallNumberOfNewAlert);
        assertEquals(result1.missedCallTextStringInformation, result2.missedCallTextStringInformation);
        assertEquals(result1.smsMmsNumberOfNewAlert, result2.smsMmsNumberOfNewAlert);
        assertEquals(result1.smsMmsTextStringInformation, result2.smsMmsTextStringInformation);
        assertEquals(result1.voiceMailNumberOfNewAlert, result2.voiceMailNumberOfNewAlert);
        assertEquals(result1.voiceMailTextStringInformation, result2.voiceMailTextStringInformation);
        assertEquals(result1.scheduleNumberOfNewAlert, result2.scheduleNumberOfNewAlert);
        assertEquals(result1.scheduleTextStringInformation, result2.scheduleTextStringInformation);
        assertEquals(result1.highPrioritizedAlertNumberOfNewAlert, result2.highPrioritizedAlertNumberOfNewAlert);
        assertEquals(result1.highPrioritizedAlertTextStringInformation, result2.highPrioritizedAlertTextStringInformation);
        assertEquals(result1.instantMessageAlertNumberOfNewAlert, result2.instantMessageAlertNumberOfNewAlert);
        assertEquals(result1.instantMessageTextStringInformation, result2.instantMessageTextStringInformation);
    }

    @Test
    public void test_simpleAlertNumberOfNewAlert_00001() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstSimpleAlertNumberOfNewAlert, characteristicData.simpleAlertNumberOfNewAlert);

        int secondSimpleAlertNumberOfNewAlert = 101;
        characteristicData.simpleAlertNumberOfNewAlert = secondSimpleAlertNumberOfNewAlert;
        assertEquals(secondSimpleAlertNumberOfNewAlert, characteristicData.simpleAlertNumberOfNewAlert);
    }

    @Test
    public void test_simpleAlertTextStringInformation_00001() {
        String firstSimpleAlertTextStringInformation = "a";
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , firstSimpleAlertTextStringInformation
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstSimpleAlertTextStringInformation, characteristicData.simpleAlertTextStringInformation);

        String secondSimpleAlertTextStringInformation = "b";
        characteristicData.simpleAlertTextStringInformation = secondSimpleAlertTextStringInformation;
        assertEquals(secondSimpleAlertTextStringInformation, characteristicData.simpleAlertTextStringInformation);
    }

    @Test
    public void test_emailNumberOfNewAlert_00001() {
        int firstEmailNumberOfNewAlert = 1;
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , firstEmailNumberOfNewAlert
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstEmailNumberOfNewAlert, characteristicData.emailNumberOfNewAlert);

        int secondEmailNumberOfNewAlert = 101;
        characteristicData.emailNumberOfNewAlert = secondEmailNumberOfNewAlert;
        assertEquals(secondEmailNumberOfNewAlert, characteristicData.emailNumberOfNewAlert);
    }

    @Test
    public void test_emailTextStringInformation_00001() {
        String firstEmailTextStringInformation = "a";
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , firstEmailTextStringInformation
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstEmailTextStringInformation, characteristicData.emailTextStringInformation);

        String secondEmailTextStringInformation = "b";
        characteristicData.emailTextStringInformation = secondEmailTextStringInformation;
        assertEquals(secondEmailTextStringInformation, characteristicData.emailTextStringInformation);
    }

    @Test
    public void test_newsNumberOfNewAlert_00001() {
        int firstNewsNumberOfNewAlert = 1;
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , firstNewsNumberOfNewAlert
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstNewsNumberOfNewAlert, characteristicData.newsNumberOfNewAlert);

        int secondNewsNumberOfNewAlert = 101;
        characteristicData.newsNumberOfNewAlert = secondNewsNumberOfNewAlert;
        assertEquals(secondNewsNumberOfNewAlert, characteristicData.newsNumberOfNewAlert);
    }

    @Test
    public void test_newsTextStringInformation_00001() {
        String firstNewsTextStringInformation = "a";
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , firstNewsTextStringInformation
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstNewsTextStringInformation, characteristicData.newsTextStringInformation);

        String secondNewsTextStringInformation = "b";
        characteristicData.newsTextStringInformation = secondNewsTextStringInformation;
        assertEquals(secondNewsTextStringInformation, characteristicData.newsTextStringInformation);
    }

    @Test
    public void test_callNumberOfNewAlert_00001() {
        int firstCallNumberOfNewAlert = 1;
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , null
                , firstCallNumberOfNewAlert
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstCallNumberOfNewAlert, characteristicData.callNumberOfNewAlert);

        int secondCallNumberOfNewAlert = 101;
        characteristicData.callNumberOfNewAlert = secondCallNumberOfNewAlert;
        assertEquals(secondCallNumberOfNewAlert, characteristicData.callNumberOfNewAlert);
    }

    @Test
    public void test_callTextStringInformation_00001() {
        String firstCallTextStringInformation = "a";
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , firstCallTextStringInformation
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstCallTextStringInformation, characteristicData.callTextStringInformation);

        String secondCallTextStringInformation = "b";
        characteristicData.callTextStringInformation = secondCallTextStringInformation;
        assertEquals(secondCallTextStringInformation, characteristicData.callTextStringInformation);
    }

    @Test
    public void test_missedCallNumberOfNewAlert_00001() {
        int firstMissedCallNumberOfNewAlert = 1;
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , firstMissedCallNumberOfNewAlert
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstMissedCallNumberOfNewAlert, characteristicData.missedCallNumberOfNewAlert);

        int secondMissedCallNumberOfNewAlert = 101;
        characteristicData.missedCallNumberOfNewAlert = secondMissedCallNumberOfNewAlert;
        assertEquals(secondMissedCallNumberOfNewAlert, characteristicData.missedCallNumberOfNewAlert);
    }

    @Test
    public void test_missedCallTextStringInformation_00001() {
        String firstMissedCallTextStringInformation = "a";
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , firstMissedCallTextStringInformation
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstMissedCallTextStringInformation, characteristicData.missedCallTextStringInformation);

        String secondMissedCallTextStringInformation = "b";
        characteristicData.missedCallTextStringInformation = secondMissedCallTextStringInformation;
        assertEquals(secondMissedCallTextStringInformation, characteristicData.missedCallTextStringInformation);
    }

    @Test
    public void test_smsMmsNumberOfNewAlert_00001() {
        int firstSmsMmsNumberOfNewAlert = 1;
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , firstSmsMmsNumberOfNewAlert
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstSmsMmsNumberOfNewAlert, characteristicData.smsMmsNumberOfNewAlert);

        int secondSmsMmsNumberOfNewAlert = 101;
        characteristicData.smsMmsNumberOfNewAlert = secondSmsMmsNumberOfNewAlert;
        assertEquals(secondSmsMmsNumberOfNewAlert, characteristicData.smsMmsNumberOfNewAlert);
    }

    @Test
    public void test_smsMmsTextStringInformation_00001() {
        String firstSmsMmsTextStringInformation = "a";
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , firstSmsMmsTextStringInformation
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstSmsMmsTextStringInformation, characteristicData.smsMmsTextStringInformation);

        String secondSmsMmsTextStringInformation = "b";
        characteristicData.smsMmsTextStringInformation = secondSmsMmsTextStringInformation;
        assertEquals(secondSmsMmsTextStringInformation, characteristicData.smsMmsTextStringInformation);
    }

    @Test
    public void test_voiceMailNumberOfNewAlert_00001() {
        int firstVoiceMailNumberOfNewAlert = 1;
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , firstVoiceMailNumberOfNewAlert
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstVoiceMailNumberOfNewAlert, characteristicData.voiceMailNumberOfNewAlert);

        int secondVoiceMailNumberOfNewAlert = 101;
        characteristicData.voiceMailNumberOfNewAlert = secondVoiceMailNumberOfNewAlert;
        assertEquals(secondVoiceMailNumberOfNewAlert, characteristicData.voiceMailNumberOfNewAlert);
    }

    @Test
    public void test_voiceMailTextStringInformation_00001() {
        String firstVoiceMailTextStringInformation = "a";
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , firstVoiceMailTextStringInformation
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstVoiceMailTextStringInformation, characteristicData.voiceMailTextStringInformation);

        String secondVoiceMailTextStringInformation = "b";
        characteristicData.voiceMailTextStringInformation = secondVoiceMailTextStringInformation;
        assertEquals(secondVoiceMailTextStringInformation, characteristicData.voiceMailTextStringInformation);
    }

    @Test
    public void test_scheduleNumberOfNewAlert_00001() {
        int firstScheduleNumberOfNewAlert = 1;
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , firstScheduleNumberOfNewAlert
                , null
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstScheduleNumberOfNewAlert, characteristicData.scheduleNumberOfNewAlert);

        int secondScheduleNumberOfNewAlert = 101;
        characteristicData.scheduleNumberOfNewAlert = secondScheduleNumberOfNewAlert;
        assertEquals(secondScheduleNumberOfNewAlert, characteristicData.scheduleNumberOfNewAlert);
    }

    @Test
    public void test_scheduleTextStringInformation_00001() {
        String firstScheduleTextStringInformation = "a";
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , firstScheduleTextStringInformation
                , 0
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstScheduleTextStringInformation, characteristicData.scheduleTextStringInformation);

        String secondScheduleTextStringInformation = "b";
        characteristicData.scheduleTextStringInformation = secondScheduleTextStringInformation;
        assertEquals(secondScheduleTextStringInformation, characteristicData.scheduleTextStringInformation);
    }

    @Test
    public void test_highPrioritizedAlertNumberOfNewAlert_00001() {
        int firstHighPrioritizedAlertNumberOfNewAlert = 1;
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , firstHighPrioritizedAlertNumberOfNewAlert
                , null
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstHighPrioritizedAlertNumberOfNewAlert, characteristicData.highPrioritizedAlertNumberOfNewAlert);

        int secondHighPrioritizedAlertNumberOfNewAlert = 101;
        characteristicData.highPrioritizedAlertNumberOfNewAlert = secondHighPrioritizedAlertNumberOfNewAlert;
        assertEquals(secondHighPrioritizedAlertNumberOfNewAlert, characteristicData.highPrioritizedAlertNumberOfNewAlert);
    }

    @Test
    public void test_highPrioritizedAlertTextStringInformation_00001() {
        String firstHighPrioritizedAlertTextStringInformation = "a";
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , firstHighPrioritizedAlertTextStringInformation
                , 0
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstHighPrioritizedAlertTextStringInformation, characteristicData.highPrioritizedAlertTextStringInformation);

        String secondHighPrioritizedAlertTextStringInformation = "b";
        characteristicData.highPrioritizedAlertTextStringInformation = secondHighPrioritizedAlertTextStringInformation;
        assertEquals(secondHighPrioritizedAlertTextStringInformation, characteristicData.highPrioritizedAlertTextStringInformation);
    }

    @Test
    public void test_instantMessageAlertNumberOfNewAlert_00001() {
        int firstInstantMessageAlertNumberOfNewAlert = 1;
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , firstInstantMessageAlertNumberOfNewAlert
                , null
                , new ArrayList<DescriptorData>());
        assertEquals(firstInstantMessageAlertNumberOfNewAlert, characteristicData.instantMessageAlertNumberOfNewAlert);

        int secondInstantMessageAlertNumberOfNewAlert = 101;
        characteristicData.instantMessageAlertNumberOfNewAlert = secondInstantMessageAlertNumberOfNewAlert;
        assertEquals(secondInstantMessageAlertNumberOfNewAlert, characteristicData.instantMessageAlertNumberOfNewAlert);
    }

    @Test
    public void test_instantMessageTextStringInformation_00001() {
        String firstInstantMessageTextStringInformation = "a";
        NewAlertCharacteristicData characteristicData = new NewAlertCharacteristicData(0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , null
                , 0
                , firstInstantMessageTextStringInformation
                , new ArrayList<DescriptorData>());
        assertEquals(firstInstantMessageTextStringInformation, characteristicData.instantMessageTextStringInformation);

        String secondInstantMessageTextStringInformation = "b";
        characteristicData.instantMessageTextStringInformation = secondInstantMessageTextStringInformation;
        assertEquals(secondInstantMessageTextStringInformation, characteristicData.instantMessageTextStringInformation);
    }

    @Test
    public void test_parcelable_00001() {
        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(1
                , "a"
                , 2
                , "b"
                , 3
                , "c"
                , 4
                , "d"
                , 5
                , "e"
                , 6
                , "f"
                , 7
                , "g"
                , 8
                , "h"
                , 9
                , "i"
                , 10
                , "j"
                , new ArrayList<DescriptorData>());
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        NewAlertCharacteristicData result2 = NewAlertCharacteristicData.CREATOR.createFromParcel(parcel);

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
        assertEquals(result1.simpleAlertNumberOfNewAlert, result2.simpleAlertNumberOfNewAlert);
        assertEquals(result1.simpleAlertTextStringInformation, result2.simpleAlertTextStringInformation);
        assertEquals(result1.emailNumberOfNewAlert, result2.emailNumberOfNewAlert);
        assertEquals(result1.emailTextStringInformation, result2.emailTextStringInformation);
        assertEquals(result1.newsNumberOfNewAlert, result2.newsNumberOfNewAlert);
        assertEquals(result1.newsTextStringInformation, result2.newsTextStringInformation);
        assertEquals(result1.callNumberOfNewAlert, result2.callNumberOfNewAlert);
        assertEquals(result1.callTextStringInformation, result2.callTextStringInformation);
        assertEquals(result1.missedCallNumberOfNewAlert, result2.missedCallNumberOfNewAlert);
        assertEquals(result1.missedCallTextStringInformation, result2.missedCallTextStringInformation);
        assertEquals(result1.smsMmsNumberOfNewAlert, result2.smsMmsNumberOfNewAlert);
        assertEquals(result1.smsMmsTextStringInformation, result2.smsMmsTextStringInformation);
        assertEquals(result1.voiceMailNumberOfNewAlert, result2.voiceMailNumberOfNewAlert);
        assertEquals(result1.voiceMailTextStringInformation, result2.voiceMailTextStringInformation);
        assertEquals(result1.scheduleNumberOfNewAlert, result2.scheduleNumberOfNewAlert);
        assertEquals(result1.scheduleTextStringInformation, result2.scheduleTextStringInformation);
        assertEquals(result1.highPrioritizedAlertNumberOfNewAlert, result2.highPrioritizedAlertNumberOfNewAlert);
        assertEquals(result1.highPrioritizedAlertTextStringInformation, result2.highPrioritizedAlertTextStringInformation);
        assertEquals(result1.instantMessageAlertNumberOfNewAlert, result2.instantMessageAlertNumberOfNewAlert);
        assertEquals(result1.instantMessageTextStringInformation, result2.instantMessageTextStringInformation);
    }

    @Test
    public void test_hashCode_00001() {
        int property = BluetoothGattCharacteristic.PROPERTY_NOTIFY;
        int permission = 0;
        int responseCode = BluetoothGatt.GATT_SUCCESS;
        int simpleAlertNumberOfNewAlert = 1;
        String simpleAlertTextStringInformation = "a";
        int emailNumberOfNewAlert = 2;
        String emailTextStringInformation = "b";
        int newsNumberOfNewAlert = 3;
        String newsTextStringInformation = "c";
        int callNumberOfNewAlert = 4;
        String callTextStringInformation = "d";
        int missedCallNumberOfNewAlert = 5;
        String missedCallTextStringInformation = "e";
        int smsMmsNumberOfNewAlert = 6;
        String smsMmsTextStringInformation = "f";
        int voiceMailNumberOfNewAlert = 7;
        String voiceMailTextStringInformation = "g";
        int scheduleNumberOfNewAlert = 8;
        String scheduleTextStringInformation = "h";
        int highPrioritizedAlertNumberOfNewAlert = 9;
        String highPrioritizedAlertTextStringInformation = "i";
        int instantMessageAlertNumberOfNewAlert = 10;
        String instantMessageTextStringInformation = "j";
        long delay = 0;
        int notificationCount = 1;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(simpleAlertNumberOfNewAlert
                , simpleAlertTextStringInformation
                , emailNumberOfNewAlert
                , emailTextStringInformation
                , newsNumberOfNewAlert
                , newsTextStringInformation
                , callNumberOfNewAlert
                , callTextStringInformation
                , missedCallNumberOfNewAlert
                , missedCallTextStringInformation
                , smsMmsNumberOfNewAlert
                , smsMmsTextStringInformation
                , voiceMailNumberOfNewAlert
                , voiceMailTextStringInformation
                , scheduleNumberOfNewAlert
                , scheduleTextStringInformation
                , highPrioritizedAlertNumberOfNewAlert
                , highPrioritizedAlertTextStringInformation
                , instantMessageAlertNumberOfNewAlert
                , instantMessageTextStringInformation
                , descriptorDataList);
        assertEquals(NEW_ALERT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(property).hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Integer.valueOf(notificationCount).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(simpleAlertNumberOfNewAlert).hashCode()
                        ^ simpleAlertTextStringInformation.hashCode()
                        ^ Integer.valueOf(emailNumberOfNewAlert).hashCode()
                        ^ emailTextStringInformation.hashCode()
                        ^ Integer.valueOf(newsNumberOfNewAlert).hashCode()
                        ^ newsTextStringInformation.hashCode()
                        ^ Integer.valueOf(callNumberOfNewAlert).hashCode()
                        ^ callTextStringInformation.hashCode()
                        ^ Integer.valueOf(missedCallNumberOfNewAlert).hashCode()
                        ^ missedCallTextStringInformation.hashCode()
                        ^ Integer.valueOf(smsMmsNumberOfNewAlert).hashCode()
                        ^ smsMmsTextStringInformation.hashCode()
                        ^ Integer.valueOf(voiceMailNumberOfNewAlert).hashCode()
                        ^ voiceMailTextStringInformation.hashCode()
                        ^ Integer.valueOf(scheduleNumberOfNewAlert).hashCode()
                        ^ scheduleTextStringInformation.hashCode()
                        ^ Integer.valueOf(highPrioritizedAlertNumberOfNewAlert).hashCode()
                        ^ highPrioritizedAlertTextStringInformation.hashCode()
                        ^ Integer.valueOf(instantMessageAlertNumberOfNewAlert).hashCode()
                        ^ instantMessageTextStringInformation.hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondSimpleAlertNumberOfNewAlert = 101;

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(secondSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        String secondSimpleAlertTextStringInformation = "z";

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , secondSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondEmailNumberOfNewAlert = 101;

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , secondEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        String secondEmailTextStringInformation = "z";

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , secondEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondNewsNumberOfNewAlert = 101;

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , secondNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        String secondNewsTextStringInformation = "z";

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , secondNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00008() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondCallNumberOfNewAlert = 101;

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , secondCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00009() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        String secondCallTextStringInformation = "z";

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , secondCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00010() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondMissedCallNumberOfNewAlert = 101;

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , secondMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00011() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        String secondMissedCallTextStringInformation = "z";

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , secondMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00012() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondSmsMmsNumberOfNewAlert = 101;

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , secondSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00013() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        String secondSmsMmsTextStringInformation = "z";

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , secondSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00014() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondVoiceMailNumberOfNewAlert = 101;

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , secondVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00015() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        String secondVoiceMailTextStringInformation = "z";

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , secondVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00016() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondScheduleNumberOfNewAlert = 101;

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , secondScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00017() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        String secondScheduleTextStringInformation = "z";

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , secondScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00018() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondHighPrioritizedAlertNumberOfNewAlert = 101;

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , secondHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00019() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        String secondHighPrioritizedAlertTextStringInformation = "z";

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , secondHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00020() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        int secondInstantMessageAlertNumberOfNewAlert = 101;

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , secondInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00021() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        String secondInstantMessageTextStringInformation = "z";

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , secondInstantMessageTextStringInformation
                , firstDescriptorDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00022() {
        int firstSimpleAlertNumberOfNewAlert = 1;
        String firstSimpleAlertTextStringInformation = "a";
        int firstEmailNumberOfNewAlert = 2;
        String firstEmailTextStringInformation = "b";
        int firstNewsNumberOfNewAlert = 3;
        String firstNewsTextStringInformation = "c";
        int firstCallNumberOfNewAlert = 4;
        String firstCallTextStringInformation = "d";
        int firstMissedCallNumberOfNewAlert = 5;
        String firstMissedCallTextStringInformation = "e";
        int firstSmsMmsNumberOfNewAlert = 6;
        String firstSmsMmsTextStringInformation = "f";
        int firstVoiceMailNumberOfNewAlert = 7;
        String firstVoiceMailTextStringInformation = "g";
        int firstScheduleNumberOfNewAlert = 8;
        String firstScheduleTextStringInformation = "h";
        int firstHighPrioritizedAlertNumberOfNewAlert = 9;
        String firstHighPrioritizedAlertTextStringInformation = "i";
        int firstInstantMessageAlertNumberOfNewAlert = 10;
        String firstInstantMessageTextStringInformation = "j";
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 12, 13, new byte[]{20}));

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 111, 112, 113, new byte[]{120}));

        NewAlertCharacteristicData result1 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , firstDescriptorDataList);
        NewAlertCharacteristicData result2 = new NewAlertCharacteristicData(firstSimpleAlertNumberOfNewAlert
                , firstSimpleAlertTextStringInformation
                , firstEmailNumberOfNewAlert
                , firstEmailTextStringInformation
                , firstNewsNumberOfNewAlert
                , firstNewsTextStringInformation
                , firstCallNumberOfNewAlert
                , firstCallTextStringInformation
                , firstMissedCallNumberOfNewAlert
                , firstMissedCallTextStringInformation
                , firstSmsMmsNumberOfNewAlert
                , firstSmsMmsTextStringInformation
                , firstVoiceMailNumberOfNewAlert
                , firstVoiceMailTextStringInformation
                , firstScheduleNumberOfNewAlert
                , firstScheduleTextStringInformation
                , firstHighPrioritizedAlertNumberOfNewAlert
                , firstHighPrioritizedAlertTextStringInformation
                , firstInstantMessageAlertNumberOfNewAlert
                , firstInstantMessageTextStringInformation
                , secondDescriptorDataList);
        assertNotEquals(result1, result2);
    }

}
