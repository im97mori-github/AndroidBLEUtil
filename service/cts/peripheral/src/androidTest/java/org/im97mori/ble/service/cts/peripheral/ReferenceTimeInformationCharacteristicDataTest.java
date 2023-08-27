package org.im97mori.ble.service.cts.peripheral;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.os.SystemClock;
import android.text.format.DateUtils;

import com.google.gson.Gson;

import org.im97mori.ble.characteristic.u2a14.ReferenceTimeInformation;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

public class ReferenceTimeInformationCharacteristicDataTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        ReferenceTimeInformationCharacteristicData result1 = new ReferenceTimeInformationCharacteristicData(1, 2, new byte[]{3, 4, 5, 6});

        Gson gson = new Gson();
        ReferenceTimeInformationCharacteristicData result2 = gson.fromJson(gson.toJson(result1), ReferenceTimeInformationCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertTrue(result2.descriptorDataList.isEmpty());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
    }

    @Test
    public void test_constructor_00101() {
        ReferenceTimeInformationCharacteristicData result1 = new ReferenceTimeInformationCharacteristicData();

        assertEquals(0, result1.lastUpdate);
    }

    @Test
    public void test_getBytes_00001() {
        ReferenceTimeInformationCharacteristicData result1 = new ReferenceTimeInformationCharacteristicData(1, 2, new byte[]{3, 4, 5, 6});
        result1.lastUpdate = SystemClock.elapsedRealtime();
        ReferenceTimeInformation result2 = new ReferenceTimeInformation(result1.getBytes());
        assertFalse(result2.isDaysSinceUpdate255OrMoreDays());
        assertFalse(result2.isHoursSinceUpdate255OrMoreHours());
    }

    @Test
    public void test_getBytes_00002() {
        ReferenceTimeInformationCharacteristicData result1 = new ReferenceTimeInformationCharacteristicData(1, 2, new byte[]{3, 4, 5, 6});
        result1.lastUpdate = SystemClock.elapsedRealtime() - DateUtils.HOUR_IN_MILLIS * (ReferenceTimeInformation.DAYS_SINCE_UPDATE_255_OR_MORE_HOURS + 1);
        ReferenceTimeInformation result2 = new ReferenceTimeInformation(result1.getBytes());
        assertFalse(result2.isDaysSinceUpdate255OrMoreDays());
        assertTrue(result2.isHoursSinceUpdate255OrMoreHours());
    }

    @Test
    public void test_getBytes_00003() {
        ReferenceTimeInformationCharacteristicData result1 = new ReferenceTimeInformationCharacteristicData(1, 2, new byte[]{3, 4, 5, 6});
        result1.lastUpdate = SystemClock.elapsedRealtime() - DateUtils.DAY_IN_MILLIS * (ReferenceTimeInformation.DAYS_SINCE_UPDATE_255_OR_MORE_DAYS + 1);
        ReferenceTimeInformation result2 = new ReferenceTimeInformation(result1.getBytes());
        assertTrue(result2.isDaysSinceUpdate255OrMoreDays());
        assertTrue(result2.isHoursSinceUpdate255OrMoreHours());
    }

}
