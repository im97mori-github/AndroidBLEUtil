package org.im97mori.ble.advertising;

import static org.im97mori.ble.constants.DataType.CLASSOF_DEVICE_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.constants.MajorDeviceClass;
import org.im97mori.ble.constants.MajorServiceClasses;
import org.im97mori.ble.constants.MinorDeviceClass;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * @noinspection
 */
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings("unused")
public class ClassOfDeviceAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        int classOfDevice = MajorServiceClasses.INFORMATION_MAJOR_SERVICE_CLASSES
                | MajorDeviceClass.COMPUTER_MAJOR_DEVICE_CLASS
                | MinorDeviceClass.COMPUTER_UNCATEGORIZED_MINOR_DEVICE_CLASS;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = CLASSOF_DEVICE_DATA_TYPE;
        data[2] = (byte) classOfDevice;
        data[3] = (byte) (classOfDevice >> 8);
        data[4] = (byte) (classOfDevice >> 16);
        data_00001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        ClassOfDeviceAndroid result1 = new ClassOfDeviceAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(CLASSOF_DEVICE_DATA_TYPE, result1.getDataType());
        long ClassOfDeviceAndroid = (data[2] & 0xff) | ((data[3] & 0xff) << 8) | ((data[4] & 0xff) << 16);
        assertEquals(MajorServiceClasses.INFORMATION_MAJOR_SERVICE_CLASSES,
                result1.getMajorServiceClasses());
        assertEquals("Information (WEB-server, WAP-server, ...)",
                result1.getMajorServiceClassesName());
        assertEquals(
                MajorDeviceClass.COMPUTER_MAJOR_DEVICE_CLASS,
                result1.getMajorDeviceClass());
        assertEquals("Computer (desktop, notebook, PDA, organizer, ...)",
                result1.getMajorDeviceClassName());
        assertEquals(ClassOfDevice.CLASS_OF_DEVICE_MINOR_DEVICE_CLASS_MASK &
                        MinorDeviceClass.COMPUTER_UNCATEGORIZED_MINOR_DEVICE_CLASS,
                result1.getMinorDeviceClass());
        assertEquals("Uncategorized, code for device not assigned",
                result1.getMinorDeviceClassName());
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        ClassOfDeviceAndroid result1 = new ClassOfDeviceAndroid(data, 0);
        assertEquals(4, result1.getLength());
        assertEquals(CLASSOF_DEVICE_DATA_TYPE, result1.getDataType());
        long ClassOfDeviceAndroid = (data[2] & 0xff) | ((data[3] & 0xff) << 8) | ((data[4] & 0xff) << 16);
        assertEquals(MajorServiceClasses.INFORMATION_MAJOR_SERVICE_CLASSES,
                result1.getMajorServiceClasses());
        assertEquals("Information (WEB-server, WAP-server, ...)",
                result1.getMajorServiceClassesName());
        assertEquals(
                MajorDeviceClass.COMPUTER_MAJOR_DEVICE_CLASS,
                result1.getMajorDeviceClass());
        assertEquals("Computer (desktop, notebook, PDA, organizer, ...)",
                result1.getMajorDeviceClassName());
        assertEquals(ClassOfDevice.CLASS_OF_DEVICE_MINOR_DEVICE_CLASS_MASK &
                        MinorDeviceClass.COMPUTER_UNCATEGORIZED_MINOR_DEVICE_CLASS,
                result1.getMinorDeviceClass());
        assertEquals("Uncategorized, code for device not assigned",
                result1.getMinorDeviceClassName());
    }

    @Test
    public void test_constructor_3_00001() {
        byte[] data = getData();

        ClassOfDeviceAndroid result1 = new ClassOfDeviceAndroid(BLEUtils.createUInt24(data, 2));
        assertEquals(4, result1.getLength());
        assertEquals(CLASSOF_DEVICE_DATA_TYPE, result1.getDataType());
        long ClassOfDeviceAndroid = (data[2] & 0xff) | ((data[3] & 0xff) << 8) | ((data[4] & 0xff) << 16);
        assertEquals(MajorServiceClasses.INFORMATION_MAJOR_SERVICE_CLASSES,
                result1.getMajorServiceClasses());
        assertEquals("Information (WEB-server, WAP-server, ...)",
                result1.getMajorServiceClassesName());
        assertEquals(
                MajorDeviceClass.COMPUTER_MAJOR_DEVICE_CLASS,
                result1.getMajorDeviceClass());
        assertEquals("Computer (desktop, notebook, PDA, organizer, ...)",
                result1.getMajorDeviceClassName());
        assertEquals(ClassOfDevice.CLASS_OF_DEVICE_MINOR_DEVICE_CLASS_MASK &
                        MinorDeviceClass.COMPUTER_UNCATEGORIZED_MINOR_DEVICE_CLASS,
                result1.getMinorDeviceClass());
        assertEquals("Uncategorized, code for device not assigned",
                result1.getMinorDeviceClassName());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ClassOfDeviceAndroid result1 = new ClassOfDeviceAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ClassOfDeviceAndroid result2 = ClassOfDeviceAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getMajorServiceClasses(), result2.getMajorServiceClasses());
        assertEquals(result1.getMajorDeviceClass(), result2.getMajorDeviceClass());
        assertEquals(result1.getMinorDeviceClass(), result2.getMinorDeviceClass());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ClassOfDeviceAndroid result1 = new ClassOfDeviceAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ClassOfDeviceAndroid result1 = new ClassOfDeviceAndroid(data, 0, data[0]);
        ClassOfDeviceAndroid result2 = ClassOfDeviceAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
