package org.im97mori.ble.characteristic.u2ac7;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import java.util.Arrays;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.DateTimeUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

@SuppressWarnings({"unused", "ConstantConditions"})
public class ObjectListFilterAndroidTest extends TestBase {

	//@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = (byte) ObjectListFilter.FILTER_NO_FILTER;
		data_00001 = data;
	}

    private static final byte[] data_00101;
    static {
    	byte[] stringData = "0".getBytes();
        byte[] data = new byte[1 + stringData.length];
        data[ 0] = (byte) ObjectListFilter.FILTER_NAME_STARTS_WITH;
        System.arraycopy(stringData, 0, data, 1, stringData.length);
        data_00101 = data;
	}

    private static final byte[] data_00201;
    static {
    	byte[] stringData = "0".getBytes();
        byte[] data = new byte[1 + stringData.length];
        data[ 0] = (byte) ObjectListFilter.FILTER_NAME_ENDS_WITH;
        System.arraycopy(stringData, 0, data, 1, stringData.length);
        data_00201 = data;
	}

    private static final byte[] data_00301;
    static {
    	byte[] stringData = "0".getBytes();
        byte[] data = new byte[1 + stringData.length];
        data[ 0] = (byte) ObjectListFilter.FILTER_NAME_CONTAINS;
        System.arraycopy(stringData, 0, data, 1, stringData.length);
        data_00301 = data;
	}

    private static final byte[] data_00401;
    static {
    	byte[] stringData = "0".getBytes();
        byte[] data = new byte[1 + stringData.length];
        data[ 0] = (byte) ObjectListFilter.FILTER_NAME_IS_EXACTLY;
        System.arraycopy(stringData, 0, data, 1, stringData.length);
        data_00401 = data;
	}

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) ObjectListFilter.FILTER_OBJECT_TYPE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00501 = data;
	}

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[17];
        data[ 0] = (byte) ObjectListFilter.FILTER_OBJECT_TYPE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data_00502 = data;
	}

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = (byte) DateTimeUtils.YEAR_IS_NOT_KNOWN;
        data[ 2] = (byte) (DateTimeUtils.YEAR_IS_NOT_KNOWN >> 8);
        data[ 3] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 4] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00601 = data;
	}

    private static final byte[] data_00602;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = (byte) 1582;
        data[ 2] = (byte) (1582 >> 8);
        data[ 3] = DateTimeUtils.MONTH_JANUARY;
        data[ 4] = 1;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00602 = data;
	}

    private static final byte[] data_00603;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00603 = data;
	}

    private static final byte[] data_00604;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_MARCH;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00604 = data;
	}

    private static final byte[] data_00605;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_APRIL;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00605 = data;
	}

    private static final byte[] data_00606;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_MAY;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00606 = data;
	}

    private static final byte[] data_00607;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_JUNE;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00607 = data;
	}

    private static final byte[] data_00608;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_JULY;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00608 = data;
	}

    private static final byte[] data_00609;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_AUGUST;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00609 = data;
	}

    private static final byte[] data_00610;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00610 = data;
	}

    private static final byte[] data_00611;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_OCTOBER;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00611 = data;
	}

    private static final byte[] data_00612;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00612 = data;
	}

    private static final byte[] data_00613;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_DECEMBER;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00613 = data;
	}

    private static final byte[] data_00614;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) DateTimeUtils.YEAR_IS_NOT_KNOWN;
        data[ 9] = (byte) (DateTimeUtils.YEAR_IS_NOT_KNOWN >> 8);
        data[10] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[11] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00614 = data;
	}

    private static final byte[] data_00615;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 1582;
        data[ 9] = (byte) (1582 >> 8);
        data[10] = DateTimeUtils.MONTH_JANUARY;
        data[11] = 1;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00615 = data;
	}

    private static final byte[] data_00616;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_FEBRUARY;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00616 = data;
	}

    private static final byte[] data_00617;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_MARCH;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00617 = data;
	}

    private static final byte[] data_00618;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_APRIL;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00618 = data;
	}

    private static final byte[] data_00619;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_MAY;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00619 = data;
	}

    private static final byte[] data_00620;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_JUNE;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00620 = data;
	}

    private static final byte[] data_00621;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_JULY;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00621 = data;
	}

    private static final byte[] data_00622;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_AUGUST;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00622 = data;
	}

    private static final byte[] data_00623;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_SEPTEMBER;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00623 = data;
	}

    private static final byte[] data_00624;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_OCTOBER;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00624 = data;
	}

    private static final byte[] data_00625;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_NOVEMBER;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00625 = data;
	}

    private static final byte[] data_00626;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_CREATED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_DECEMBER;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00626 = data;
	}


    private static final byte[] data_00701;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = (byte) DateTimeUtils.YEAR_IS_NOT_KNOWN;
        data[ 2] = (byte) (DateTimeUtils.YEAR_IS_NOT_KNOWN >> 8);
        data[ 3] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 4] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00701 = data;
	}

    private static final byte[] data_00702;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = (byte) 1582;
        data[ 2] = (byte) (1582 >> 8);
        data[ 3] = DateTimeUtils.MONTH_JANUARY;
        data[ 4] = 1;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00702 = data;
	}

    private static final byte[] data_00703;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00703 = data;
	}

    private static final byte[] data_00704;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_MARCH;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00704 = data;
	}

    private static final byte[] data_00705;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_APRIL;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00705 = data;
	}

    private static final byte[] data_00706;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_MAY;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00706 = data;
	}

    private static final byte[] data_00707;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_JUNE;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00707 = data;
	}

    private static final byte[] data_00708;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_JULY;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00708 = data;
	}

    private static final byte[] data_00709;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_AUGUST;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00709 = data;
	}

    private static final byte[] data_00710;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00710 = data;
	}

    private static final byte[] data_00711;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_OCTOBER;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00711 = data;
	}

    private static final byte[] data_00712;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00712 = data;
	}

    private static final byte[] data_00713;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = (byte) 9999;
        data[ 2] = (byte) (9999 >> 8);
        data[ 3] = DateTimeUtils.MONTH_DECEMBER;
        data[ 4] = 31;
        data[ 5] = 23;
        data[ 6] = 59;
        data[ 7] = 59;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00713 = data;
	}

    private static final byte[] data_00714;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) DateTimeUtils.YEAR_IS_NOT_KNOWN;
        data[ 9] = (byte) (DateTimeUtils.YEAR_IS_NOT_KNOWN >> 8);
        data[10] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[11] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[12] = 0;
        data[13] = 0;
        data[14] = 0;
        data_00714 = data;
	}

    private static final byte[] data_00715;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 1582;
        data[ 9] = (byte) (1582 >> 8);
        data[10] = DateTimeUtils.MONTH_JANUARY;
        data[11] = 1;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00715 = data;
	}

    private static final byte[] data_00716;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_FEBRUARY;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00716 = data;
	}

    private static final byte[] data_00717;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_MARCH;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00717 = data;
	}

    private static final byte[] data_00718;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_APRIL;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00718 = data;
	}

    private static final byte[] data_00719;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_MAY;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00719 = data;
	}

    private static final byte[] data_00720;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_JUNE;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00720 = data;
	}

    private static final byte[] data_00721;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_JULY;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00721 = data;
	}

    private static final byte[] data_00722;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_AUGUST;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00722 = data;
	}

    private static final byte[] data_00723;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_SEPTEMBER;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00723 = data;
	}

    private static final byte[] data_00724;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_OCTOBER;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00724 = data;
	}

    private static final byte[] data_00725;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_NOVEMBER;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00725 = data;
	}

    private static final byte[] data_00726;
    static {
        byte[] data = new byte[15];
        data[ 0] = (byte) ObjectListFilter.FILTER_MODIFIED_BETWEEN;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) 9999;
        data[ 9] = (byte) (9999 >> 8);
        data[10] = DateTimeUtils.MONTH_DECEMBER;
        data[11] = 31;
        data[12] = 23;
        data[13] = 59;
        data[14] = 59;
        data_00726 = data;
	}

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[9];
        data[ 0] = (byte) ObjectListFilter.FILTER_CURRENT_SIZE_BETWEEN;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x07;
        data_00801 = data;
	}

    private static final byte[] data_00901;
    static {
        byte[] data = new byte[9];
        data[ 0] = (byte) ObjectListFilter.FILTER_ALLOCATED_SIZE_BETWEEN;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x07;
        data_00901 = data;
	}

    private static final byte[] data_01001;
    static {
        byte[] data = new byte[1];
        data[ 0] = (byte) ObjectListFilter.FILTER_MARKED_OBJECTS;
        data_01001 = data;
	}
	//@formatter:on

	@Test
	public void test_constructor_1_00001() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_NO_FILTER, result1.getFilter());
		assertTrue(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
	}

	@Test
	public void test_constructor_1_00101() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_NAME_STARTS_WITH, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertTrue(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(new String(data, 1, data.length - 1), result1.getName());
	}

	@Test
	public void test_constructor_1_00201() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_NAME_ENDS_WITH, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertTrue(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(new String(data, 1, data.length - 1), result1.getName());
	}

	@Test
	public void test_constructor_1_00301() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_NAME_CONTAINS, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertTrue(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(new String(data, 1, data.length - 1), result1.getName());
	}

	@Test
	public void test_constructor_1_00401() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_NAME_IS_EXACTLY, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertTrue(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(new String(data, 1, data.length - 1), result1.getName());
	}

	@Test
	public void test_constructor_1_00501() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_OBJECT_TYPE, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertTrue(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertArrayEquals(Arrays.copyOfRange(data, 1, data.length), result1.getObjectType());
	}

	@Test
	public void test_constructor_1_00502() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_OBJECT_TYPE, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertTrue(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertArrayEquals(Arrays.copyOfRange(data, 1, data.length), result1.getObjectType());
	}

	@Test
	public void test_constructor_1_00601() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00602() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00603() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00604() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00605() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00606() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00607() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00608() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00609() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00610() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00611() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00612() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00613() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00614() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00615() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00616() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00617() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00618() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00619() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00620() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00621() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00622() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00623() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00624() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00625() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00626() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00701() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00702() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00703() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00704() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00705() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00706() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00707() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00708() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00709() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00710() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00711() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00712() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00713() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00714() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00715() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00716() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00717() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00718() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00719() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00720() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00721() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00722() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00723() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00724() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00725() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00726() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt16(data, 1), result1.getYear1());
		assertEquals(BLEUtils.createUInt8(data, 3), result1.getMonth1());
		assertEquals(BLEUtils.createUInt8(data, 4), result1.getDay1());
		assertEquals(BLEUtils.createUInt8(data, 5), result1.getHours1());
		assertEquals(BLEUtils.createUInt8(data, 6), result1.getMinutes1());
		assertEquals(BLEUtils.createUInt8(data, 7), result1.getSeconds1());
		assertEquals(BLEUtils.createUInt16(data, 8), result1.getYear2());
		assertEquals(BLEUtils.createUInt8(data, 10), result1.getMonth2());
		assertEquals(BLEUtils.createUInt8(data, 11), result1.getDay2());
		assertEquals(BLEUtils.createUInt8(data, 12), result1.getHours2());
		assertEquals(BLEUtils.createUInt8(data, 13), result1.getMinutes2());
		assertEquals(BLEUtils.createUInt8(data, 14), result1.getSeconds2());
	}

	@Test
	public void test_constructor_1_00801() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_CURRENT_SIZE_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertTrue(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt32(data, 1), result1.getSize1());
		assertEquals(BLEUtils.createUInt32(data, 5), result1.getSize2());
	}

	@Test
	public void test_constructor_1_00901() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_ALLOCATED_SIZE_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertTrue(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(BLEUtils.createUInt32(data, 1), result1.getSize1());
		assertEquals(BLEUtils.createUInt32(data, 5), result1.getSize2());
	}

	@Test
	public void test_constructor_1_01001() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertEquals(ObjectListFilter.FILTER_MARKED_OBJECTS, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertTrue(result1.isFilterMarkedObjects());
	}

	@Test
	public void test_constructor_2_00001() {
		int filter = ObjectListFilter.FILTER_NO_FILTER;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_NO_FILTER, result1.getFilter());
		assertTrue(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
	}

	@Test
	public void test_constructor_2_00101() {
		int filter = ObjectListFilter.FILTER_NAME_STARTS_WITH;
		String name = "0";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_NAME_STARTS_WITH, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertTrue(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(name, result1.getName());
	}

	@Test
	public void test_constructor_2_00201() {
		int filter = ObjectListFilter.FILTER_NAME_ENDS_WITH;
		String name = "0";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_NAME_ENDS_WITH, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertTrue(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(name, result1.getName());
	}

	@Test
	public void test_constructor_2_00301() {
		int filter = ObjectListFilter.FILTER_NAME_CONTAINS;
		String name = "0";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_NAME_CONTAINS, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertTrue(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(name, result1.getName());
	}

	@Test
	public void test_constructor_2_00401() {
		int filter = ObjectListFilter.FILTER_NAME_IS_EXACTLY;
		String name = "0";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_NAME_IS_EXACTLY, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertTrue(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(name, result1.getName());
	}

	@Test
	public void test_constructor_2_00501() {
		int filter = ObjectListFilter.FILTER_OBJECT_TYPE;
		String name = "";
		byte[] objectType = new byte[] { 1, 2 };
		int year1 = 3;
		int month1 = 4;
		int day1 = 5;
		int hours1 = 6;
		int minutes1 = 7;
		int seconds1 = 8;
		int year2 = 9;
		int month2 = 10;
		int day2 = 11;
		int hours2 = 12;
		int minutes2 = 13;
		int seconds2 = 14;
		long size1 = 15;
		long size2 = 16;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_OBJECT_TYPE, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertTrue(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertArrayEquals(objectType, result1.getObjectType());
	}

	@Test
	public void test_constructor_2_00502() {
		int filter = ObjectListFilter.FILTER_OBJECT_TYPE;
		String name = "";
		byte[] objectType = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		int year1 = 17;
		int month1 = 18;
		int day1 = 19;
		int hours1 = 20;
		int minutes1 = 21;
		int seconds1 = 22;
		int year2 = 23;
		int month2 = 24;
		int day2 = 25;
		int hours2 = 26;
		int minutes2 = 27;
		int seconds2 = 28;
		long size1 = 29;
		long size2 = 30;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_OBJECT_TYPE, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertTrue(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertArrayEquals(objectType, result1.getObjectType());
	}

	@Test
	public void test_constructor_2_00601() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00602() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00603() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00604() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00605() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00606() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00607() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00608() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00609() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00610() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00611() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00612() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00613() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00614() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00615() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00616() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00617() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00618() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00619() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00620() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00621() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00622() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00623() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00624() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00625() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00626() {
		int filter = ObjectListFilter.FILTER_CREATED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CREATED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertTrue(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00701() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00702() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00703() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00704() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00705() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00706() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00707() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00708() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00709() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00710() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00711() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00712() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00713() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00714() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00715() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00716() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00717() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00718() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00719() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00720() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00721() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00722() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00723() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00724() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00725() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00726() {
		int filter = ObjectListFilter.FILTER_MODIFIED_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MODIFIED_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertTrue(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(year1, result1.getYear1());
		assertEquals(month1, result1.getMonth1());
		assertEquals(day1, result1.getDay1());
		assertEquals(hours1, result1.getHours1());
		assertEquals(minutes1, result1.getMinutes1());
		assertEquals(seconds1, result1.getSeconds1());
		assertEquals(year2, result1.getYear2());
		assertEquals(month2, result1.getMonth2());
		assertEquals(day2, result1.getDay2());
		assertEquals(hours2, result1.getHours2());
		assertEquals(minutes2, result1.getMinutes2());
		assertEquals(seconds2, result1.getSeconds2());
	}

	@Test
	public void test_constructor_2_00801() {
		int filter = ObjectListFilter.FILTER_CURRENT_SIZE_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_CURRENT_SIZE_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertTrue(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(size1, result1.getSize1());
		assertEquals(size2, result1.getSize2());
	}

	@Test
	public void test_constructor_2_00901() {
		int filter = ObjectListFilter.FILTER_ALLOCATED_SIZE_BETWEEN;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_ALLOCATED_SIZE_BETWEEN, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertTrue(result1.isFilterAllocatedSizeBetween());
		assertFalse(result1.isFilterMarkedObjects());
		assertEquals(size1, result1.getSize1());
		assertEquals(size2, result1.getSize2());
	}

	@Test
	public void test_constructor_2_01001() {
		int filter = ObjectListFilter.FILTER_MARKED_OBJECTS;
		String name = "";
		byte[] objectType = new byte[0];
		int year1 = 1;
		int month1 = 2;
		int day1 = 3;
		int hours1 = 4;
		int minutes1 = 5;
		int seconds1 = 6;
		int year2 = 7;
		int month2 = 8;
		int day2 = 9;
		int hours2 = 10;
		int minutes2 = 11;
		int seconds2 = 12;
		long size1 = 13;
		long size2 = 14;

		ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(filter, name, objectType, year1, month1, day1, hours1, minutes1,
				seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
		assertEquals(ObjectListFilter.FILTER_MARKED_OBJECTS, result1.getFilter());
		assertFalse(result1.isFilterNoFilter());
		assertFalse(result1.isFilterNameStartsWith());
		assertFalse(result1.isFilterNameEndsWith());
		assertFalse(result1.isFilterNameContains());
		assertFalse(result1.isFilterNameIsExactly());
		assertFalse(result1.isFilterObjectType());
		assertFalse(result1.isFilterCreatedBetween());
		assertFalse(result1.isFilterModifiedBetween());
		assertFalse(result1.isFilterCurrentSizeBetween());
		assertFalse(result1.isFilterAllocatedSizeBetween());
		assertTrue(result1.isFilterMarkedObjects());
	}

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00604() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00605() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00606() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00607() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00608() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00609() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00610() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00611() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00612() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00613() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00614() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00615() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00616() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00617() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00618() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00619() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00620() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00621() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00622() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00623() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00624() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00625() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00626() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00705() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00706() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00707() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00708() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00709() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00710() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00711() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00712() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00713() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00714() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00715() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00716() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00717() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00718() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00719() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00720() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00721() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00722() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00723() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00724() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00725() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00726() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

    @Test
    public void test_parcelable_1_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFilter(), result1.getFilter());
        assertEquals(result2.getName(), result1.getName());
        assertEquals(result2.getObjectType(), result1.getObjectType());
        assertEquals(result2.getYear1(), result1.getYear1());
        assertEquals(result2.getMonth1(), result1.getMonth1());
        assertEquals(result2.getDay1(), result1.getDay1());
        assertEquals(result2.getHours1(), result1.getHours1());
        assertEquals(result2.getMinutes1(), result1.getMinutes1());
        assertEquals(result2.getSeconds1(), result1.getSeconds1());
        assertEquals(result2.getYear2(), result1.getYear2());
        assertEquals(result2.getMonth2(), result1.getMonth2());
        assertEquals(result2.getDay2(), result1.getDay2());
        assertEquals(result2.getHours2(), result1.getHours2());
        assertEquals(result2.getMinutes2(), result1.getMinutes2());
        assertEquals(result2.getSeconds2(), result1.getSeconds2());
        assertEquals(result2.getSize1(), result1.getSize1());
        assertEquals(result2.getSize2(), result1.getSize2());
    }

	@Test
	public void test_parcelable_2_00001() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00101() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00201() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00301() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00401() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00501() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00502() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00601() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00602() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00603() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00604() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00605() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00606() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00607() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00608() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00609() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00610() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00611() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00612() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00613() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00614() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00615() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00616() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00617() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00618() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00619() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00620() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00621() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00622() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00623() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00624() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00625() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00626() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00701() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00702() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00703() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00704() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00705() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00706() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00707() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00708() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00709() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00710() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00711() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00712() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00713() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00714() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00715() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00716() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00717() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00718() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00719() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00720() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00721() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00722() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00723() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00724() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00725() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00726() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00801() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00901() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_01001() {
		byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00604() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00605() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00606() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00607() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00608() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00609() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00610() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00611() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00612() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00613() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00614() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00615() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00616() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00617() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00618() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00619() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00621() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00622() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00623() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00624() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00625() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00626() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00705() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00706() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00707() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00708() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00709() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00710() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00711() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00712() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00713() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00714() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00715() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00716() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00717() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00718() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00719() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00721() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00722() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00723() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00724() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00725() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00726() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectListFilterAndroid result1 = new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        ObjectListFilterAndroid result2 = ObjectListFilterAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
