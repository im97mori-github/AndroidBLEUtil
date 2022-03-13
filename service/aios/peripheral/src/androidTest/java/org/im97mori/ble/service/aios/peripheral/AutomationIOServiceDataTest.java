package org.im97mori.ble.service.aios.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.ANALOG_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.AUTOMATION_IO_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.bluetooth.BluetoothGattService;
import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.CharacteristicData;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class AutomationIOServiceDataTest {

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
        AutomationIOServiceData result1 = new AutomationIOServiceData(Collections.singletonList(characteristicData)
                , Collections.singletonList(digitalCharacteristicData));

        Gson gson = new Gson();
        AutomationIOServiceData result2 = gson.fromJson(gson.toJson(result1), AutomationIOServiceData.class);

        assertEquals(AUTOMATION_IO_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.digitalList.size(), result2.digitalList.size());
        assertArrayEquals(result1.digitalList.toArray(), result2.digitalList.toArray());
    }

    @Test
    public void test_constructor_00101() {
        AutomationIOServiceData result1 = new AutomationIOServiceData();

        assertNull(result1.digitalList);
    }

    @Test
    public void test_getCharacteristicDataList_00001() {
        CharacteristicData characteristicData = new CharacteristicData(ANALOG_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        DigitalCharacteristicData digitalCharacteristicData = new DigitalCharacteristicData(1, 2, 3, 4, new byte[]{5});

        AutomationIOServiceData result1 = new AutomationIOServiceData(Collections.singletonList(characteristicData)
                , Collections.singletonList(digitalCharacteristicData));

        assertArrayEquals(Arrays.asList(characteristicData
                , digitalCharacteristicData).toArray(), result1.getCharacteristicDataList().toArray());
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

        AutomationIOServiceData result1 = new AutomationIOServiceData(Collections.singletonList(characteristicData)
                , Collections.singletonList(digitalCharacteristicData));
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AutomationIOServiceData result2 = AutomationIOServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(AUTOMATION_IO_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.digitalList.size(), result2.digitalList.size());
        assertArrayEquals(result1.digitalList.toArray(), result2.digitalList.toArray());
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

        AutomationIOServiceData result1 = new AutomationIOServiceData(Collections.singletonList(characteristicData)
                , Collections.singletonList(digitalCharacteristicData));

        assertEquals(Objects.hashCode(AUTOMATION_IO_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.singletonList(characteristicData))
                        ^ Objects.hashCode(Collections.singletonList(digitalCharacteristicData))
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

        AutomationIOServiceData result1 = new AutomationIOServiceData(Collections.singletonList(firstCharacteristicData)
                , Collections.singletonList(firstDigitalCharacteristicData));
        AutomationIOServiceData result2 = new AutomationIOServiceData(Collections.singletonList(firstCharacteristicData)
                , Collections.singletonList(firstDigitalCharacteristicData));
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

        CharacteristicData secondCharacteristicData = new CharacteristicData(ANALOG_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        AutomationIOServiceData result1 = new AutomationIOServiceData(Collections.singletonList(firstCharacteristicData)
                , Collections.singletonList(firstDigitalCharacteristicData));
        AutomationIOServiceData result2 = new AutomationIOServiceData(Collections.singletonList(secondCharacteristicData)
                , Collections.singletonList(firstDigitalCharacteristicData));
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData firstCharacteristicData = new CharacteristicData(ANALOG_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        DigitalCharacteristicData firstDigitalCharacteristicData = new DigitalCharacteristicData(1, 2, 3, 4, new byte[]{5});

        DigitalCharacteristicData secondDigitalCharacteristicData = new DigitalCharacteristicData(11, 22, 33, 44, new byte[]{55});

        AutomationIOServiceData result1 = new AutomationIOServiceData(Collections.singletonList(firstCharacteristicData)
                , Collections.singletonList(firstDigitalCharacteristicData));
        AutomationIOServiceData result2 = new AutomationIOServiceData(Collections.singletonList(firstCharacteristicData)
                , Collections.singletonList(secondDigitalCharacteristicData));
        assertNotEquals(result1, result2);
    }

}
