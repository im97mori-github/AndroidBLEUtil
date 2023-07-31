package org.im97mori.ble.characteristic.u2ac3;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ShiftOutOfRange")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ObjectIdAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT;
        data[ 1] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 8);
        data[ 2] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 16);
        data[ 3] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 24);
        data[ 4] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 32);
        data[ 5] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 40);
        //@formatter:on

        ObjectIdAndroid result1 = new ObjectIdAndroid(data);
        assertEquals(BLEUtils.createUInt48(data, 0), result1.getObjectId());
        assertTrue(result1.isObjectIdDirectoryListingObject());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 0x000000000100;
        data[ 1] = (byte) (0x000000000100 >> 8);
        data[ 2] = (byte) (0x000000000100 >> 16);
        data[ 3] = (byte) (0x000000000100 >> 24);
        data[ 4] = (byte) (0x000000000100 >> 32);
        data[ 5] = (byte) (0x000000000100 >> 40);
        //@formatter:on

        ObjectIdAndroid result1 = new ObjectIdAndroid(data);
        assertEquals(BLEUtils.createUInt48(data, 0), result1.getObjectId());
        assertFalse(result1.isObjectIdDirectoryListingObject());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 0xFFFFFFFFFFFFL ;
        data[ 1] = (byte) (0xFFFFFFFFFFFFL  >> 8);
        data[ 2] = (byte) (0xFFFFFFFFFFFFL  >> 16);
        data[ 3] = (byte) (0xFFFFFFFFFFFFL  >> 24);
        data[ 4] = (byte) (0xFFFFFFFFFFFFL  >> 32);
        data[ 5] = (byte) (0xFFFFFFFFFFFFL  >> 40);
        //@formatter:on

        ObjectIdAndroid result1 = new ObjectIdAndroid(data);
        assertEquals(BLEUtils.createUInt48(data, 0), result1.getObjectId());
        assertFalse(result1.isObjectIdDirectoryListingObject());
    }

    @Test
    public void test_constructor_00101() {
        long objectId = ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT;

        ObjectIdAndroid result1 = new ObjectIdAndroid(objectId);
        assertEquals(objectId, result1.getObjectId());
    }

    @Test
    public void test_constructor_00102() {
        long objectId = 0x000000000100;

        ObjectIdAndroid result1 = new ObjectIdAndroid(objectId);
        assertEquals(objectId, result1.getObjectId());
    }

    @Test
    public void test_constructor_00103() {
        long objectId = 0xFFFFFFFFFFFFL;

        ObjectIdAndroid result1 = new ObjectIdAndroid(objectId);
        assertEquals(objectId, result1.getObjectId());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT;
        data[ 1] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 8);
        data[ 2] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 16);
        data[ 3] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 24);
        data[ 4] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 32);
        data[ 5] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 40);
        //@formatter:on

        ObjectIdAndroid result1 = new ObjectIdAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectIdAndroid result2 = ObjectIdAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getObjectId(), result1.getObjectId());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 0x000000000100;
        data[ 1] = (byte) (0x000000000100 >> 8);
        data[ 2] = (byte) (0x000000000100 >> 16);
        data[ 3] = (byte) (0x000000000100 >> 24);
        data[ 4] = (byte) (0x000000000100 >> 32);
        data[ 5] = (byte) (0x000000000100 >> 40);
        //@formatter:on

        ObjectIdAndroid result1 = new ObjectIdAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectIdAndroid result2 = ObjectIdAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getObjectId(), result1.getObjectId());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 0xFFFFFFFFFFFFL ;
        data[ 1] = (byte) (0xFFFFFFFFFFFFL  >> 8);
        data[ 2] = (byte) (0xFFFFFFFFFFFFL  >> 16);
        data[ 3] = (byte) (0xFFFFFFFFFFFFL  >> 24);
        data[ 4] = (byte) (0xFFFFFFFFFFFFL  >> 32);
        data[ 5] = (byte) (0xFFFFFFFFFFFFL  >> 40);
        //@formatter:on

        ObjectIdAndroid result1 = new ObjectIdAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectIdAndroid result2 = ObjectIdAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getObjectId(), result1.getObjectId());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT;
        data[ 1] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 8);
        data[ 2] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 16);
        data[ 3] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 24);
        data[ 4] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 32);
        data[ 5] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 40);
        //@formatter:on

        ObjectIdAndroid result1 = new ObjectIdAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 0x000000000100;
        data[ 1] = (byte) (0x000000000100 >> 8);
        data[ 2] = (byte) (0x000000000100 >> 16);
        data[ 3] = (byte) (0x000000000100 >> 24);
        data[ 4] = (byte) (0x000000000100 >> 32);
        data[ 5] = (byte) (0x000000000100 >> 40);
        //@formatter:on

        ObjectIdAndroid result1 = new ObjectIdAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 0xFFFFFFFFFFFFL ;
        data[ 1] = (byte) (0xFFFFFFFFFFFFL  >> 8);
        data[ 2] = (byte) (0xFFFFFFFFFFFFL  >> 16);
        data[ 3] = (byte) (0xFFFFFFFFFFFFL  >> 24);
        data[ 4] = (byte) (0xFFFFFFFFFFFFL  >> 32);
        data[ 5] = (byte) (0xFFFFFFFFFFFFL  >> 40);
        //@formatter:on

        ObjectIdAndroid result1 = new ObjectIdAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT;
        data[ 1] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 8);
        data[ 2] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 16);
        data[ 3] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 24);
        data[ 4] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 32);
        data[ 5] = (byte) (ObjectId.OBJECT_ID_DIRECTORY_LISTING_OBJECT >> 40);
        //@formatter:on

        ObjectIdAndroid result1 = new ObjectIdAndroid(data);
        ObjectIdAndroid result2 = ObjectIdAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 0x000000000100;
        data[ 1] = (byte) (0x000000000100 >> 8);
        data[ 2] = (byte) (0x000000000100 >> 16);
        data[ 3] = (byte) (0x000000000100 >> 24);
        data[ 4] = (byte) (0x000000000100 >> 32);
        data[ 5] = (byte) (0x000000000100 >> 40);
        //@formatter:on

        ObjectIdAndroid result1 = new ObjectIdAndroid(data);
        ObjectIdAndroid result2 = ObjectIdAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 0xFFFFFFFFFFFFL ;
        data[ 1] = (byte) (0xFFFFFFFFFFFFL  >> 8);
        data[ 2] = (byte) (0xFFFFFFFFFFFFL  >> 16);
        data[ 3] = (byte) (0xFFFFFFFFFFFFL  >> 24);
        data[ 4] = (byte) (0xFFFFFFFFFFFFL  >> 32);
        data[ 5] = (byte) (0xFFFFFFFFFFFFL  >> 40);
        //@formatter:on

        ObjectIdAndroid result1 = new ObjectIdAndroid(data);
        ObjectIdAndroid result2 = ObjectIdAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
