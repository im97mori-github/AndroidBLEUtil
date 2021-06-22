package org.im97mori.ble.characteristic.u2a14;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.text.format.DateUtils;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReferenceTimeInformationAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = ReferenceTimeInformation.TIME_SOURCE_UNKNOWN;
        data[ 1] = (byte) ReferenceTimeInformation.ACCURACY_OUT_OF_RANGE;
        data[ 2] = (byte) ReferenceTimeInformation.DAYS_SINCE_UPDATE_255_OR_MORE_DAYS;
        data[ 3] = (byte) ReferenceTimeInformation.DAYS_SINCE_UPDATE_255_OR_MORE_HOURS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReferenceTimeInformationAndroid result1 = new ReferenceTimeInformationAndroid(bluetoothGattCharacteristic);
        assertEquals(ReferenceTimeInformation.TIME_SOURCE_UNKNOWN, result1.getTimeSource());
        assertTrue(result1.isTimeSourceNotKnown());
        assertFalse(result1.isTimeSourceNetworkTimeProtocol());
        assertFalse(result1.isTimeSourceGps());
        assertFalse(result1.isTimeSourceRadioTimeSignal());
        assertFalse(result1.isTimeSourceManual());
        assertFalse(result1.isTimeSourceAtomicClock());
        assertFalse(result1.isTimeSourceCellularNetwork());
        assertEquals(ReferenceTimeInformation.ACCURACY_OUT_OF_RANGE, result1.getAccuracy());
        assertTrue(result1.isAccuracyOutOfRange());
        assertFalse(result1.isAccuracyUnknown());
        assertEquals(ReferenceTimeInformation.ACCURACY_UNIT_FRACTIONS256_SUPPORTED_MILLIS
                        * ReferenceTimeInformation.ACCURACY_OUT_OF_RANGE
                , result1.getAccuracyFraction256SupportedMillis());
        assertEquals(ReferenceTimeInformation.ACCURACY_UNIT_FRACTIONS256_NOT_SUPPORTED_MILLIS
                        * ReferenceTimeInformation.ACCURACY_OUT_OF_RANGE
                , result1.getAccuracyFraction256NotSupportedMillis());
        assertEquals(ReferenceTimeInformation.DAYS_SINCE_UPDATE_255_OR_MORE_DAYS, result1.getDaysSinceUpdate());
        assertTrue(result1.isDaysSinceUpdate255OrMoreDays());
        assertEquals(ReferenceTimeInformation.DAYS_SINCE_UPDATE_255_OR_MORE_HOURS, result1.getHoursSinceUpdate());
        assertTrue(result1.isHoursSinceUpdate255OrMoreHours());
        assertEquals(DateUtils.DAY_IN_MILLIS
                        * ReferenceTimeInformation.DAYS_SINCE_UPDATE_255_OR_MORE_DAYS
                        + DateUtils.HOUR_IN_MILLIS
                        * ReferenceTimeInformation.DAYS_SINCE_UPDATE_255_OR_MORE_DAYS
                , result1.getTimeFromUpdateMillis());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = ReferenceTimeInformation.TIME_SOURCE_NETWORK_TIME_PROTOCOL;
        data[ 1] = (byte) ReferenceTimeInformation.ACCURACY_UNKNOWN;
        data[ 2] = 0;
        data[ 3] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReferenceTimeInformationAndroid result1 = new ReferenceTimeInformationAndroid(bluetoothGattCharacteristic);
        assertEquals(ReferenceTimeInformation.TIME_SOURCE_NETWORK_TIME_PROTOCOL, result1.getTimeSource());
        assertFalse(result1.isTimeSourceNotKnown());
        assertTrue(result1.isTimeSourceNetworkTimeProtocol());
        assertFalse(result1.isTimeSourceGps());
        assertFalse(result1.isTimeSourceRadioTimeSignal());
        assertFalse(result1.isTimeSourceManual());
        assertFalse(result1.isTimeSourceAtomicClock());
        assertFalse(result1.isTimeSourceCellularNetwork());
        assertEquals(ReferenceTimeInformation.ACCURACY_UNKNOWN, result1.getAccuracy());
        assertFalse(result1.isAccuracyOutOfRange());
        assertTrue(result1.isAccuracyUnknown());
        assertEquals(ReferenceTimeInformation.ACCURACY_UNIT_FRACTIONS256_SUPPORTED_MILLIS
                        * ReferenceTimeInformation.ACCURACY_UNKNOWN
                , result1.getAccuracyFraction256SupportedMillis());
        assertEquals(ReferenceTimeInformation.ACCURACY_UNIT_FRACTIONS256_NOT_SUPPORTED_MILLIS
                        * ReferenceTimeInformation.ACCURACY_UNKNOWN
                , result1.getAccuracyFraction256NotSupportedMillis());
        assertEquals(0, result1.getDaysSinceUpdate());
        assertFalse(result1.isDaysSinceUpdate255OrMoreDays());
        assertEquals(0, result1.getHoursSinceUpdate());
        assertFalse(result1.isHoursSinceUpdate255OrMoreHours());
        assertEquals(0, result1.getTimeFromUpdateMillis());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = ReferenceTimeInformation.TIME_SOURCE_GPS;
        data[ 1] = 0;
        data[ 2] = (byte) 254;
        data[ 3] = 23;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReferenceTimeInformationAndroid result1 = new ReferenceTimeInformationAndroid(bluetoothGattCharacteristic);
        assertEquals(ReferenceTimeInformation.TIME_SOURCE_GPS, result1.getTimeSource());
        assertFalse(result1.isTimeSourceNotKnown());
        assertFalse(result1.isTimeSourceNetworkTimeProtocol());
        assertTrue(result1.isTimeSourceGps());
        assertFalse(result1.isTimeSourceRadioTimeSignal());
        assertFalse(result1.isTimeSourceManual());
        assertFalse(result1.isTimeSourceAtomicClock());
        assertFalse(result1.isTimeSourceCellularNetwork());
        assertEquals(0, result1.getAccuracy());
        assertFalse(result1.isAccuracyOutOfRange());
        assertFalse(result1.isAccuracyUnknown());
        assertEquals(0, result1.getAccuracyFraction256SupportedMillis());
        assertEquals(0, result1.getAccuracyFraction256NotSupportedMillis());
        assertEquals(254, result1.getDaysSinceUpdate());
        assertFalse(result1.isDaysSinceUpdate255OrMoreDays());
        assertEquals(23, result1.getHoursSinceUpdate());
        assertFalse(result1.isHoursSinceUpdate255OrMoreHours());
        assertEquals(DateUtils.DAY_IN_MILLIS
                * 254
                + DateUtils.HOUR_IN_MILLIS
                * 23, result1.getTimeFromUpdateMillis());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = ReferenceTimeInformation.TIME_SOURCE_RADIO_TIME_SIGNAL;
        data[ 1] = (byte) 253;
        data[ 2] = (byte) 254;
        data[ 3] = 23;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReferenceTimeInformationAndroid result1 = new ReferenceTimeInformationAndroid(bluetoothGattCharacteristic);
        assertEquals(ReferenceTimeInformation.TIME_SOURCE_RADIO_TIME_SIGNAL, result1.getTimeSource());
        assertFalse(result1.isTimeSourceNotKnown());
        assertFalse(result1.isTimeSourceNetworkTimeProtocol());
        assertFalse(result1.isTimeSourceGps());
        assertTrue(result1.isTimeSourceRadioTimeSignal());
        assertFalse(result1.isTimeSourceManual());
        assertFalse(result1.isTimeSourceAtomicClock());
        assertFalse(result1.isTimeSourceCellularNetwork());
        assertEquals(253, result1.getAccuracy());
        assertFalse(result1.isAccuracyOutOfRange());
        assertFalse(result1.isAccuracyUnknown());
        assertEquals(ReferenceTimeInformation.ACCURACY_UNIT_FRACTIONS256_SUPPORTED_MILLIS
                * 253, result1.getAccuracyFraction256SupportedMillis());
        assertEquals(ReferenceTimeInformation.ACCURACY_UNIT_FRACTIONS256_NOT_SUPPORTED_MILLIS
                * 253, result1.getAccuracyFraction256NotSupportedMillis());
        assertEquals(254, result1.getDaysSinceUpdate());
        assertFalse(result1.isDaysSinceUpdate255OrMoreDays());
        assertEquals(23, result1.getHoursSinceUpdate());
        assertFalse(result1.isHoursSinceUpdate255OrMoreHours());
        assertEquals(DateUtils.DAY_IN_MILLIS
                * 254
                + DateUtils.HOUR_IN_MILLIS
                * 23, result1.getTimeFromUpdateMillis());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = ReferenceTimeInformation.TIME_SOURCE_MANUAL;
        data[ 1] = (byte) 253;
        data[ 2] = (byte) 254;
        data[ 3] = 23;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReferenceTimeInformationAndroid result1 = new ReferenceTimeInformationAndroid(bluetoothGattCharacteristic);
        assertEquals(ReferenceTimeInformation.TIME_SOURCE_MANUAL, result1.getTimeSource());
        assertFalse(result1.isTimeSourceNotKnown());
        assertFalse(result1.isTimeSourceNetworkTimeProtocol());
        assertFalse(result1.isTimeSourceGps());
        assertFalse(result1.isTimeSourceRadioTimeSignal());
        assertTrue(result1.isTimeSourceManual());
        assertFalse(result1.isTimeSourceAtomicClock());
        assertFalse(result1.isTimeSourceCellularNetwork());
        assertEquals(253, result1.getAccuracy());
        assertFalse(result1.isAccuracyOutOfRange());
        assertFalse(result1.isAccuracyUnknown());
        assertEquals(ReferenceTimeInformation.ACCURACY_UNIT_FRACTIONS256_SUPPORTED_MILLIS
                * 253, result1.getAccuracyFraction256SupportedMillis());
        assertEquals(ReferenceTimeInformation.ACCURACY_UNIT_FRACTIONS256_NOT_SUPPORTED_MILLIS
                * 253, result1.getAccuracyFraction256NotSupportedMillis());
        assertEquals(254, result1.getDaysSinceUpdate());
        assertFalse(result1.isDaysSinceUpdate255OrMoreDays());
        assertEquals(23, result1.getHoursSinceUpdate());
        assertFalse(result1.isHoursSinceUpdate255OrMoreHours());
        assertEquals(DateUtils.DAY_IN_MILLIS
                * 254
                + DateUtils.HOUR_IN_MILLIS
                * 23, result1.getTimeFromUpdateMillis());
    }

    @Test
    public void test_constructor006() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = ReferenceTimeInformation.TIME_SOURCE_ATOMIC_CLOCK;
        data[ 1] = (byte) 253;
        data[ 2] = (byte) 254;
        data[ 3] = 23;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReferenceTimeInformationAndroid result1 = new ReferenceTimeInformationAndroid(bluetoothGattCharacteristic);
        assertEquals(ReferenceTimeInformation.TIME_SOURCE_ATOMIC_CLOCK, result1.getTimeSource());
        assertFalse(result1.isTimeSourceNotKnown());
        assertFalse(result1.isTimeSourceNetworkTimeProtocol());
        assertFalse(result1.isTimeSourceGps());
        assertFalse(result1.isTimeSourceRadioTimeSignal());
        assertFalse(result1.isTimeSourceManual());
        assertTrue(result1.isTimeSourceAtomicClock());
        assertFalse(result1.isTimeSourceCellularNetwork());
        assertEquals(253, result1.getAccuracy());
        assertFalse(result1.isAccuracyOutOfRange());
        assertFalse(result1.isAccuracyUnknown());
        assertEquals(ReferenceTimeInformation.ACCURACY_UNIT_FRACTIONS256_SUPPORTED_MILLIS
                * 253, result1.getAccuracyFraction256SupportedMillis());
        assertEquals(ReferenceTimeInformation.ACCURACY_UNIT_FRACTIONS256_NOT_SUPPORTED_MILLIS
                * 253, result1.getAccuracyFraction256NotSupportedMillis());
        assertEquals(254, result1.getDaysSinceUpdate());
        assertFalse(result1.isDaysSinceUpdate255OrMoreDays());
        assertEquals(23, result1.getHoursSinceUpdate());
        assertFalse(result1.isHoursSinceUpdate255OrMoreHours());
        assertEquals(DateUtils.DAY_IN_MILLIS
                * 254
                + DateUtils.HOUR_IN_MILLIS
                * 23, result1.getTimeFromUpdateMillis());
    }

    @Test
    public void test_constructor007() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = ReferenceTimeInformation.TIME_SOURCE_CELLULAR_NETWORK;
        data[ 1] = (byte) 253;
        data[ 2] = (byte) 254;
        data[ 3] = 23;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReferenceTimeInformationAndroid result1 = new ReferenceTimeInformationAndroid(bluetoothGattCharacteristic);
        assertEquals(ReferenceTimeInformation.TIME_SOURCE_CELLULAR_NETWORK, result1.getTimeSource());
        assertFalse(result1.isTimeSourceNotKnown());
        assertFalse(result1.isTimeSourceNetworkTimeProtocol());
        assertFalse(result1.isTimeSourceGps());
        assertFalse(result1.isTimeSourceRadioTimeSignal());
        assertFalse(result1.isTimeSourceManual());
        assertFalse(result1.isTimeSourceAtomicClock());
        assertTrue(result1.isTimeSourceCellularNetwork());
        assertEquals(253, result1.getAccuracy());
        assertFalse(result1.isAccuracyOutOfRange());
        assertFalse(result1.isAccuracyUnknown());
        assertEquals(ReferenceTimeInformation.ACCURACY_UNIT_FRACTIONS256_SUPPORTED_MILLIS
                * 253, result1.getAccuracyFraction256SupportedMillis());
        assertEquals(ReferenceTimeInformation.ACCURACY_UNIT_FRACTIONS256_NOT_SUPPORTED_MILLIS
                * 253, result1.getAccuracyFraction256NotSupportedMillis());
        assertEquals(254, result1.getDaysSinceUpdate());
        assertFalse(result1.isDaysSinceUpdate255OrMoreDays());
        assertEquals(23, result1.getHoursSinceUpdate());
        assertFalse(result1.isHoursSinceUpdate255OrMoreHours());
        assertEquals(DateUtils.DAY_IN_MILLIS
                * 254
                + DateUtils.HOUR_IN_MILLIS
                * 23, result1.getTimeFromUpdateMillis());
    }

    @Test
    public void test_constructor008() {
        int timeSource = 1;
        int accuracy = 2;
        int daysSinceUpdate = 3;
        int hoursSinceUpdate = 4;

        ReferenceTimeInformationAndroid result1 = new ReferenceTimeInformationAndroid(timeSource, accuracy, daysSinceUpdate, hoursSinceUpdate);
        assertEquals(timeSource, result1.getTimeSource());
        assertEquals(accuracy, result1.getAccuracy());
        assertEquals(daysSinceUpdate, result1.getDaysSinceUpdate());
        assertFalse(result1.isDaysSinceUpdate255OrMoreDays());
        assertEquals(hoursSinceUpdate, result1.getHoursSinceUpdate());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReferenceTimeInformationAndroid result1 = new ReferenceTimeInformationAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReferenceTimeInformationAndroid result2 = ReferenceTimeInformationAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeSource(), result1.getTimeSource());
        assertEquals(result2.isTimeSourceNotKnown(), result1.isTimeSourceNotKnown());
        assertEquals(result2.isTimeSourceNetworkTimeProtocol(), result1.isTimeSourceNetworkTimeProtocol());
        assertEquals(result2.isTimeSourceGps(), result1.isTimeSourceGps());
        assertEquals(result2.isTimeSourceRadioTimeSignal(), result1.isTimeSourceRadioTimeSignal());
        assertEquals(result2.isTimeSourceManual(), result1.isTimeSourceManual());
        assertEquals(result2.isTimeSourceAtomicClock(), result1.isTimeSourceAtomicClock());
        assertEquals(result2.isTimeSourceCellularNetwork(), result1.isTimeSourceCellularNetwork());
        assertEquals(result2.getAccuracy(), result1.getAccuracy());
        assertEquals(result2.isAccuracyOutOfRange(), result1.isAccuracyOutOfRange());
        assertEquals(result2.isAccuracyUnknown(), result1.isAccuracyUnknown());
        assertEquals(result2.getAccuracyFraction256SupportedMillis(), result1.getAccuracyFraction256SupportedMillis());
        assertEquals(result2.getAccuracyFraction256NotSupportedMillis(), result1.getAccuracyFraction256NotSupportedMillis());
        assertEquals(result2.getDaysSinceUpdate(), result1.getDaysSinceUpdate());
        assertEquals(result2.isDaysSinceUpdate255OrMoreDays(), result1.isDaysSinceUpdate255OrMoreDays());
        assertEquals(result2.getHoursSinceUpdate(), result1.getHoursSinceUpdate());
        assertEquals(result2.isHoursSinceUpdate255OrMoreHours(), result1.isHoursSinceUpdate255OrMoreHours());
        assertEquals(result2.getTimeFromUpdateMillis(), result1.getTimeFromUpdateMillis());
    }


    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReferenceTimeInformationAndroid result1 = new ReferenceTimeInformationAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ReferenceTimeInformationAndroid result1 = new ReferenceTimeInformationAndroid(bluetoothGattCharacteristic);
        ReferenceTimeInformationAndroid result2 = ReferenceTimeInformationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
