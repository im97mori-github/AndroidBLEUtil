package org.im97mori.ble.descriptor.u2907;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;

import org.junit.Test;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ExternalReportReferenceAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;

        long target = value[0] & 0xff;
        target |= (value[1] & 0xff) << 8;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ExternalReportReferenceAndroid result = new ExternalReportReferenceAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result.getExternalReportReference());
        assertEquals(uuid, result.getExternalReportReferenceUuid());
    }

    @Test
    public void test_constructor002() {
        byte[] externalReportReference = new byte[]{1};
        UUID uuid = UUID.randomUUID();

        ExternalReportReferenceAndroid result = new ExternalReportReferenceAndroid(externalReportReference, uuid);
        assertArrayEquals(externalReportReference, result.getExternalReportReference());
        assertEquals(uuid, result.getExternalReportReferenceUuid());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ExternalReportReferenceAndroid result1 = new ExternalReportReferenceAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ExternalReportReferenceAndroid result2 = ExternalReportReferenceAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getExternalReportReference(), result2.getExternalReportReference());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ExternalReportReferenceAndroid result1 = new ExternalReportReferenceAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ExternalReportReferenceAndroid result1 = new ExternalReportReferenceAndroid(bluetoothGattDescriptor);
        ExternalReportReferenceAndroid result2 = ExternalReportReferenceAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
