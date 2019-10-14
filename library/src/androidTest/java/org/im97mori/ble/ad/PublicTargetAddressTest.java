package org.im97mori.ble.ad;

import android.os.Parcel;

import org.junit.Test;

import java.util.List;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_PUBLIC_TARGET_ADDRESS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PublicTargetAddressTest {

    @Test
    public void constructTest1() {
        byte[] address = new byte[6];
        address[0] = 0;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 0;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);

        PublicTargetAddress result = new PublicTargetAddress(data, 0, data[0]);
        assertEquals(7, result.getLength());
        assertEquals(DATA_TYPE_PUBLIC_TARGET_ADDRESS, result.getDataType());
        assertEquals(1, result.getAddressList().size());
        assertArrayEquals(address, result.getAddressList().get(0));
    }

    @Test
    public void constructTest2() {
        byte[] address = new byte[6];
        address[0] = 127;
        address[1] = 127;
        address[2] = 127;
        address[3] = 127;
        address[4] = 127;
        address[5] = 127;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);

        PublicTargetAddress result = new PublicTargetAddress(data, 0, data[0]);
        assertEquals(7, result.getLength());
        assertEquals(DATA_TYPE_PUBLIC_TARGET_ADDRESS, result.getDataType());
        assertEquals(1, result.getAddressList().size());
        assertArrayEquals(address, result.getAddressList().get(0));
    }

    @Test
    public void constructTest3() {
        byte[] address = new byte[6];
        address[0] = 0;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 127;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);

        PublicTargetAddress result = new PublicTargetAddress(data, 0, data[0]);
        assertEquals(7, result.getLength());
        assertEquals(DATA_TYPE_PUBLIC_TARGET_ADDRESS, result.getDataType());
        assertEquals(1, result.getAddressList().size());
        assertArrayEquals(address, result.getAddressList().get(0));
    }

    @Test
    public void constructTest4() {
        byte[] address = new byte[6];
        address[0] = 127;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 0;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);

        PublicTargetAddress result = new PublicTargetAddress(data, 0, data[0]);
        assertEquals(7, result.getLength());
        assertEquals(DATA_TYPE_PUBLIC_TARGET_ADDRESS, result.getDataType());
        assertEquals(1, result.getAddressList().size());
        assertArrayEquals(address, result.getAddressList().get(0));
    }

    @Test
    public void constructTest5() {
        byte[] address = new byte[6];
        address[0] = (byte) 0b11111111;
        address[1] = (byte) 0b11111111;
        address[2] = (byte) 0b11111111;
        address[3] = (byte) 0b11111111;
        address[4] = (byte) 0b11111111;
        address[5] = (byte) 0b11111111;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);

        PublicTargetAddress result = new PublicTargetAddress(data, 0, data[0]);
        assertEquals(7, result.getLength());
        assertEquals(DATA_TYPE_PUBLIC_TARGET_ADDRESS, result.getDataType());
        assertEquals(1, result.getAddressList().size());
        assertArrayEquals(address, result.getAddressList().get(0));
    }

    @Test
    public void constructTest6() {
        byte[] address = new byte[6];
        address[0] = 0;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = (byte) 0b11111111;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);

        PublicTargetAddress result = new PublicTargetAddress(data, 0, data[0]);
        assertEquals(7, result.getLength());
        assertEquals(DATA_TYPE_PUBLIC_TARGET_ADDRESS, result.getDataType());
        assertEquals(1, result.getAddressList().size());
        assertArrayEquals(address, result.getAddressList().get(0));
    }

    @Test
    public void constructTest7() {
        byte[] address = new byte[6];
        address[0] = (byte) 0b11111111;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 0;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);

        PublicTargetAddress result = new PublicTargetAddress(data, 0, data[0]);
        assertEquals(7, result.getLength());
        assertEquals(DATA_TYPE_PUBLIC_TARGET_ADDRESS, result.getDataType());
        assertEquals(1, result.getAddressList().size());
        assertArrayEquals(address, result.getAddressList().get(0));
    }

    @Test
    public void constructTest8() {
        byte[] data = new byte[8];
        data[0] = 1;
        data[1] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;

        PublicTargetAddress result = new PublicTargetAddress(data, 0, data[0]);
        assertEquals(1, result.getLength());
        assertEquals(DATA_TYPE_PUBLIC_TARGET_ADDRESS, result.getDataType());
        assertEquals(0, result.getAddressList().size());
    }

    @Test
    public void constructTest9() {
        byte[] address1 = new byte[6];
        address1[0] = 0x00;
        address1[1] = 0x01;
        address1[2] = 0x02;
        address1[3] = 0x03;
        address1[4] = 0x04;
        address1[5] = 0x05;

        byte[] address2 = new byte[6];
        address2[0] = 0x06;
        address2[1] = 0x07;
        address2[2] = 0x08;
        address2[3] = 0x09;
        address2[4] = 0x0a;
        address2[5] = 0x0b;

        byte[] data = new byte[14];
        data[0] = 13;
        data[1] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        System.arraycopy(address1, 0, data, 2, address1.length);
        System.arraycopy(address2, 0, data, 8, address2.length);

        PublicTargetAddress result = new PublicTargetAddress(data, 0, data[0]);
        assertEquals(13, result.getLength());
        assertEquals(DATA_TYPE_PUBLIC_TARGET_ADDRESS, result.getDataType());
        assertEquals(2, result.getAddressList().size());
        assertArrayEquals(address1, result.getAddressList().get(0));
        assertArrayEquals(address2, result.getAddressList().get(1));
    }

    @Test
    public void constructTest10() {
        byte[] address1 = new byte[6];
        address1[0] = 0x00;
        address1[1] = 0x01;
        address1[2] = 0x02;
        address1[3] = 0x03;
        address1[4] = 0x04;
        address1[5] = 0x05;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        System.arraycopy(address1, 0, data, 2, address1.length);

        PublicTargetAddress result1 = new PublicTargetAddress(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PublicTargetAddress result2 = PublicTargetAddress.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());

        List<byte[]> list1 = result1.getAddressList();
        List<byte[]> list2 = result2.getAddressList();
        assertEquals(list1.size(), list2.size());
        for (int i = 0; i < list1.size(); i++) {
            assertArrayEquals(list1.get(i), list2.get(i));
        }
    }

    @Test
    public void constructTest11() {
        byte[] address = new byte[6];
        address[0] = 0;
        address[1] = 0;
        address[2] = 0;
        address[3] = 0;
        address[4] = 0;
        address[5] = 0;

        byte[] data = new byte[8];
        data[0] = 7;
        data[1] = DATA_TYPE_PUBLIC_TARGET_ADDRESS;
        System.arraycopy(address, 0, data, 2, address.length);

        PublicTargetAddress result1 = new PublicTargetAddress(data, 0, data[0]);
        PublicTargetAddress result2 = PublicTargetAddress.CREATOR.createFromByteArray(data);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());

        List<byte[]> list1 = result1.getAddressList();
        List<byte[]> list2 = result2.getAddressList();
        assertEquals(list1.size(), list2.size());
        for (int i = 0; i < list1.size(); i++) {
            assertArrayEquals(list1.get(i), list2.get(i));
        }
    }
}
