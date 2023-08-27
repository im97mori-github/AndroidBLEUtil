package org.im97mori.ble.profile.aiop.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.ANALOG_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.service.aios.peripheral.AutomationIOServiceData;
import org.im97mori.ble.service.aios.peripheral.DigitalCharacteristicData;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Collections;
import java.util.Objects;

public class AutomationIOProfileMockDataTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        CharacteristicData characteristicData = new CharacteristicData(ANALOG_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        DigitalCharacteristicData digitalCharacteristicData = new DigitalCharacteristicData(1, 2, 3, 4, new byte[]{5});
        AutomationIOServiceData automationIOServiceData = new AutomationIOServiceData(Collections.singletonList(characteristicData)
                , Collections.singletonList(digitalCharacteristicData));

        AutomationIOProfileMockData result1 = new AutomationIOProfileMockData(automationIOServiceData);

        Gson gson = new Gson();
        AutomationIOProfileMockData result2 = gson.fromJson(gson.toJson(result1), AutomationIOProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.automationIO, result2.automationIO);
    }

    @Test
    public void test_constructor_00101() {
        AutomationIOProfileMockData result1 = new AutomationIOProfileMockData();

        assertNull(result1.automationIO);
    }

    @Test
    public void test_getServiceDataList_00001() {
        CharacteristicData characteristicData = new CharacteristicData(ANALOG_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        DigitalCharacteristicData digitalCharacteristicData = new DigitalCharacteristicData(1, 2, 3, 4, new byte[]{5});
        AutomationIOServiceData automationIOServiceData = new AutomationIOServiceData(Collections.singletonList(characteristicData)
                , Collections.singletonList(digitalCharacteristicData));

        AutomationIOProfileMockData result1 = new AutomationIOProfileMockData(automationIOServiceData);

        assertArrayEquals(Collections.singletonList(automationIOServiceData).toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_parcelable_00001() {
        CharacteristicData characteristicData = new CharacteristicData(ANALOG_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        DigitalCharacteristicData digitalCharacteristicData = new DigitalCharacteristicData(1, 2, 3, 4, new byte[]{5});
        AutomationIOServiceData automationIOServiceData = new AutomationIOServiceData(Collections.singletonList(characteristicData)
                , Collections.singletonList(digitalCharacteristicData));

        AutomationIOProfileMockData result1 = new AutomationIOProfileMockData(automationIOServiceData);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AutomationIOProfileMockData result2 = AutomationIOProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.automationIO, result2.automationIO);
    }

    @Test
    public void test_hashCode_00001() {
        CharacteristicData characteristicData = new CharacteristicData(ANALOG_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        DigitalCharacteristicData digitalCharacteristicData = new DigitalCharacteristicData(1, 2, 3, 4, new byte[]{5});
        AutomationIOServiceData automationIOServiceData = new AutomationIOServiceData(Collections.singletonList(characteristicData)
                , Collections.singletonList(digitalCharacteristicData));

        AutomationIOProfileMockData result1 = new AutomationIOProfileMockData(automationIOServiceData);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(automationIOServiceData)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData firstCharacteristicData = new CharacteristicData(ANALOG_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        DigitalCharacteristicData firstDigitalCharacteristicData = new DigitalCharacteristicData(1, 2, 3, 4, new byte[]{5});
        AutomationIOServiceData firstAutomationIOServiceData = new AutomationIOServiceData(Collections.singletonList(firstCharacteristicData)
                , Collections.singletonList(firstDigitalCharacteristicData));

        AutomationIOProfileMockData result1 = new AutomationIOProfileMockData(firstAutomationIOServiceData);

        AutomationIOProfileMockData result2 = new AutomationIOProfileMockData(firstAutomationIOServiceData);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData firstCharacteristicData = new CharacteristicData(ANALOG_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        DigitalCharacteristicData firstDigitalCharacteristicData = new DigitalCharacteristicData(1, 2, 3, 4, new byte[]{5});
        AutomationIOServiceData firstAutomationIOServiceData = new AutomationIOServiceData(Collections.singletonList(firstCharacteristicData)
                , Collections.singletonList(firstDigitalCharacteristicData));

        AutomationIOServiceData secondAutomationIOServiceData = new AutomationIOServiceData(Collections.emptyList(), Collections.emptyList());

        AutomationIOProfileMockData result1 = new AutomationIOProfileMockData(firstAutomationIOServiceData);

        AutomationIOProfileMockData result2 = new AutomationIOProfileMockData(secondAutomationIOServiceData);

        assertNotEquals(result1, result2);
    }

}
