package org.im97mori.ble.characteristic.u2ac8;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@SuppressWarnings("unused")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ObjectChangedAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        int flags = ObjectChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
        		| ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_CONTENTS_FALSE
        		| ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_METADATA_FALSE
        		| ObjectChanged.FLAGS_OBJECT_CREATION_FALSE
        		| ObjectChanged.FLAGS_OBJECT_DELETION_FALSE;
        byte[] data = new byte[7];
        data[ 0] = (byte) flags;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
		data_00001 = data;
	}

    private static final byte[] data_00002;
    static {
        int flags = ObjectChanged.FLAGS_SOURCE_OF_CHANGE_CLIENT
        		| ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_CONTENTS_FALSE
        		| ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_METADATA_FALSE
        		| ObjectChanged.FLAGS_OBJECT_CREATION_FALSE
        		| ObjectChanged.FLAGS_OBJECT_DELETION_FALSE;
        byte[] data = new byte[7];
        data[ 0] = (byte) flags;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data_00002 = data;
	}

    private static final byte[] data_00003;
    static {
        int flags = ObjectChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
        		| ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_CONTENTS_TRUE
        		| ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_METADATA_FALSE
        		| ObjectChanged.FLAGS_OBJECT_CREATION_FALSE
        		| ObjectChanged.FLAGS_OBJECT_DELETION_FALSE;
        byte[] data = new byte[7];
        data[ 0] = (byte) flags;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data_00003 = data;
	}

    private static final byte[] data_00004;
    static {
        int flags = ObjectChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
        		| ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_CONTENTS_FALSE
        		| ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_METADATA_TRUE
        		| ObjectChanged.FLAGS_OBJECT_CREATION_FALSE
        		| ObjectChanged.FLAGS_OBJECT_DELETION_FALSE;
        byte[] data = new byte[7];
        data[ 0] = (byte) flags;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data_00004 = data;
	}

    private static final byte[] data_00005;
    static {
        int flags = ObjectChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
        		| ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_CONTENTS_FALSE
        		| ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_METADATA_FALSE
        		| ObjectChanged.FLAGS_OBJECT_CREATION_TRUE
        		| ObjectChanged.FLAGS_OBJECT_DELETION_FALSE;
        byte[] data = new byte[7];
        data[ 0] = (byte) flags;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data_00005 = data;
	}

    private static final byte[] data_00006;
    static {
        int flags = ObjectChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
        		| ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_CONTENTS_FALSE
        		| ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_METADATA_FALSE
        		| ObjectChanged.FLAGS_OBJECT_CREATION_FALSE
        		| ObjectChanged.FLAGS_OBJECT_DELETION_TRUE;
        byte[] data = new byte[7];
        data[ 0] = (byte) flags;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data_00006 = data;
	}
	//@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsSourceOfChangeServer());
        assertFalse(result1.isFlagsSourceOfChangeClient());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectContentsFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectContentsTrue());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectMetadataFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectMetadataTrue());
        assertTrue(result1.isFlagsObjectCreationFalse());
        assertFalse(result1.isFlagsObjectCreationTrue());
        assertTrue(result1.isFlagsObjectDeletionFalse());
        assertFalse(result1.isFlagsObjectDeletionTrue());
        assertEquals(BLEUtils.createUInt48(data, 1), result1.getObjectId());
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsSourceOfChangeServer());
        assertTrue(result1.isFlagsSourceOfChangeClient());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectContentsFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectContentsTrue());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectMetadataFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectMetadataTrue());
        assertTrue(result1.isFlagsObjectCreationFalse());
        assertFalse(result1.isFlagsObjectCreationTrue());
        assertTrue(result1.isFlagsObjectDeletionFalse());
        assertFalse(result1.isFlagsObjectDeletionTrue());
        assertEquals(BLEUtils.createUInt48(data, 1), result1.getObjectId());
    }

    @Test
    public void test_constructor_1_00003() {
        byte[] data = getData();

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsSourceOfChangeServer());
        assertFalse(result1.isFlagsSourceOfChangeClient());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectContentsFalse());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectContentsTrue());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectMetadataFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectMetadataTrue());
        assertTrue(result1.isFlagsObjectCreationFalse());
        assertFalse(result1.isFlagsObjectCreationTrue());
        assertTrue(result1.isFlagsObjectDeletionFalse());
        assertFalse(result1.isFlagsObjectDeletionTrue());
        assertEquals(BLEUtils.createUInt48(data, 1), result1.getObjectId());
    }

    @Test
    public void test_constructor_1_00004() {
        byte[] data = getData();

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsSourceOfChangeServer());
        assertFalse(result1.isFlagsSourceOfChangeClient());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectContentsFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectContentsTrue());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectMetadataFalse());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectMetadataTrue());
        assertTrue(result1.isFlagsObjectCreationFalse());
        assertFalse(result1.isFlagsObjectCreationTrue());
        assertTrue(result1.isFlagsObjectDeletionFalse());
        assertFalse(result1.isFlagsObjectDeletionTrue());
        assertEquals(BLEUtils.createUInt48(data, 1), result1.getObjectId());
    }

    @Test
    public void test_constructor_1_00005() {
        byte[] data = getData();

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsSourceOfChangeServer());
        assertFalse(result1.isFlagsSourceOfChangeClient());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectContentsFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectContentsTrue());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectMetadataFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectMetadataTrue());
        assertFalse(result1.isFlagsObjectCreationFalse());
        assertTrue(result1.isFlagsObjectCreationTrue());
        assertTrue(result1.isFlagsObjectDeletionFalse());
        assertFalse(result1.isFlagsObjectDeletionTrue());
        assertEquals(BLEUtils.createUInt48(data, 1), result1.getObjectId());
    }

    @Test
    public void test_constructor_1_00006() {
        byte[] data = getData();

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsSourceOfChangeServer());
        assertFalse(result1.isFlagsSourceOfChangeClient());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectContentsFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectContentsTrue());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectMetadataFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectMetadataTrue());
        assertTrue(result1.isFlagsObjectCreationFalse());
        assertFalse(result1.isFlagsObjectCreationTrue());
        assertFalse(result1.isFlagsObjectDeletionFalse());
        assertTrue(result1.isFlagsObjectDeletionTrue());
        assertEquals(BLEUtils.createUInt48(data, 1), result1.getObjectId());
    }

    @Test
    public void test_constructor_2_00001() {
        int flags = ObjectChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_CONTENTS_FALSE
                | ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_METADATA_FALSE
                | ObjectChanged.FLAGS_OBJECT_CREATION_FALSE | ObjectChanged.FLAGS_OBJECT_DELETION_FALSE;
        long objectId = 1;

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(flags, objectId);
        assertEquals(flags, result1.getFlags());
        assertTrue(result1.isFlagsSourceOfChangeServer());
        assertFalse(result1.isFlagsSourceOfChangeClient());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectContentsFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectContentsTrue());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectMetadataFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectMetadataTrue());
        assertTrue(result1.isFlagsObjectCreationFalse());
        assertFalse(result1.isFlagsObjectCreationTrue());
        assertTrue(result1.isFlagsObjectDeletionFalse());
        assertFalse(result1.isFlagsObjectDeletionTrue());
        assertEquals(objectId, result1.getObjectId());
    }

    @Test
    public void test_constructor_2_00002() {
        int flags = ObjectChanged.FLAGS_SOURCE_OF_CHANGE_CLIENT
                | ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_CONTENTS_FALSE
                | ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_METADATA_FALSE
                | ObjectChanged.FLAGS_OBJECT_CREATION_FALSE | ObjectChanged.FLAGS_OBJECT_DELETION_FALSE;
        long objectId = 1;

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(flags, objectId);
        assertEquals(flags, result1.getFlags());
        assertFalse(result1.isFlagsSourceOfChangeServer());
        assertTrue(result1.isFlagsSourceOfChangeClient());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectContentsFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectContentsTrue());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectMetadataFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectMetadataTrue());
        assertTrue(result1.isFlagsObjectCreationFalse());
        assertFalse(result1.isFlagsObjectCreationTrue());
        assertTrue(result1.isFlagsObjectDeletionFalse());
        assertFalse(result1.isFlagsObjectDeletionTrue());
        assertEquals(objectId, result1.getObjectId());
    }

    @Test
    public void test_constructor_2_00003() {
        int flags = ObjectChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_CONTENTS_TRUE
                | ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_METADATA_FALSE
                | ObjectChanged.FLAGS_OBJECT_CREATION_FALSE | ObjectChanged.FLAGS_OBJECT_DELETION_FALSE;
        long objectId = 1;

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(flags, objectId);
        assertEquals(flags, result1.getFlags());
        assertTrue(result1.isFlagsSourceOfChangeServer());
        assertFalse(result1.isFlagsSourceOfChangeClient());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectContentsFalse());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectContentsTrue());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectMetadataFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectMetadataTrue());
        assertTrue(result1.isFlagsObjectCreationFalse());
        assertFalse(result1.isFlagsObjectCreationTrue());
        assertTrue(result1.isFlagsObjectDeletionFalse());
        assertFalse(result1.isFlagsObjectDeletionTrue());
        assertEquals(objectId, result1.getObjectId());
    }

    @Test
    public void test_constructor_2_00004() {
        int flags = ObjectChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_CONTENTS_FALSE
                | ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_METADATA_TRUE
                | ObjectChanged.FLAGS_OBJECT_CREATION_FALSE | ObjectChanged.FLAGS_OBJECT_DELETION_FALSE;
        long objectId = 1;

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(flags, objectId);
        assertEquals(flags, result1.getFlags());
        assertTrue(result1.isFlagsSourceOfChangeServer());
        assertFalse(result1.isFlagsSourceOfChangeClient());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectContentsFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectContentsTrue());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectMetadataFalse());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectMetadataTrue());
        assertTrue(result1.isFlagsObjectCreationFalse());
        assertFalse(result1.isFlagsObjectCreationTrue());
        assertTrue(result1.isFlagsObjectDeletionFalse());
        assertFalse(result1.isFlagsObjectDeletionTrue());
        assertEquals(objectId, result1.getObjectId());
    }

    @Test
    public void test_constructor_2_00005() {
        int flags = ObjectChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_CONTENTS_FALSE
                | ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_METADATA_FALSE
                | ObjectChanged.FLAGS_OBJECT_CREATION_TRUE | ObjectChanged.FLAGS_OBJECT_DELETION_FALSE;
        long objectId = 1;

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(flags, objectId);
        assertEquals(flags, result1.getFlags());
        assertTrue(result1.isFlagsSourceOfChangeServer());
        assertFalse(result1.isFlagsSourceOfChangeClient());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectContentsFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectContentsTrue());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectMetadataFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectMetadataTrue());
        assertFalse(result1.isFlagsObjectCreationFalse());
        assertTrue(result1.isFlagsObjectCreationTrue());
        assertTrue(result1.isFlagsObjectDeletionFalse());
        assertFalse(result1.isFlagsObjectDeletionTrue());
        assertEquals(objectId, result1.getObjectId());
    }

    @Test
    public void test_constructor_2_00006() {
        int flags = ObjectChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_CONTENTS_FALSE
                | ObjectChanged.FLAGS_CHANGE_OCCURRED_TO_THE_OBJECT_METADATA_FALSE
                | ObjectChanged.FLAGS_OBJECT_CREATION_FALSE | ObjectChanged.FLAGS_OBJECT_DELETION_TRUE;
        long objectId = 1;

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(flags, objectId);
        assertEquals(flags, result1.getFlags());
        assertTrue(result1.isFlagsSourceOfChangeServer());
        assertFalse(result1.isFlagsSourceOfChangeClient());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectContentsFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectContentsTrue());
        assertTrue(result1.isFlagsChangeOccurredToTheObjectMetadataFalse());
        assertFalse(result1.isFlagsChangeOccurredToTheObjectMetadataTrue());
        assertTrue(result1.isFlagsObjectCreationFalse());
        assertFalse(result1.isFlagsObjectCreationTrue());
        assertFalse(result1.isFlagsObjectDeletionFalse());
        assertTrue(result1.isFlagsObjectDeletionTrue());
        assertEquals(objectId, result1.getObjectId());
    }

	@Test
	public void test_parcelable_1_00001() {
		byte[] data = getData();

		ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		ObjectChangedAndroid result2 = ObjectChangedAndroid.CREATOR.createFromParcel(parcel);

		assertEquals(result2.getFlags(), result1.getFlags());
		assertEquals(result2.getObjectId(), result1.getObjectId());
	}

	@Test
	public void test_parcelable_1_00002() {
		byte[] data = getData();

		ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		ObjectChangedAndroid result2 = ObjectChangedAndroid.CREATOR.createFromParcel(parcel);

		assertEquals(result2.getFlags(), result1.getFlags());
		assertEquals(result2.getObjectId(), result1.getObjectId());
	}

	@Test
	public void test_parcelable_1_00003() {
		byte[] data = getData();

		ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		ObjectChangedAndroid result2 = ObjectChangedAndroid.CREATOR.createFromParcel(parcel);

		assertEquals(result2.getFlags(), result1.getFlags());
		assertEquals(result2.getObjectId(), result1.getObjectId());
	}

	@Test
	public void test_parcelable_1_00004() {
		byte[] data = getData();

		ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		ObjectChangedAndroid result2 = ObjectChangedAndroid.CREATOR.createFromParcel(parcel);

		assertEquals(result2.getFlags(), result1.getFlags());
		assertEquals(result2.getObjectId(), result1.getObjectId());
	}

	@Test
	public void test_parcelable_1_00005() {
		byte[] data = getData();

		ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		ObjectChangedAndroid result2 = ObjectChangedAndroid.CREATOR.createFromParcel(parcel);

		assertEquals(result2.getFlags(), result1.getFlags());
		assertEquals(result2.getObjectId(), result1.getObjectId());
	}

	@Test
	public void test_parcelable_1_00006() {
		byte[] data = getData();

		ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		ObjectChangedAndroid result2 = ObjectChangedAndroid.CREATOR.createFromParcel(parcel);

		assertEquals(result2.getFlags(), result1.getFlags());
		assertEquals(result2.getObjectId(), result1.getObjectId());
	}

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

	@Test
	public void test_parcelable_3_00001() {
		byte[] data = getData();

		ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
		ObjectChangedAndroid result2 = ObjectChangedAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00002() {
		byte[] data = getData();

		ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
		ObjectChangedAndroid result2 = ObjectChangedAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00003() {
		byte[] data = getData();

		ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
		ObjectChangedAndroid result2 = ObjectChangedAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00004() {
		byte[] data = getData();

		ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
		ObjectChangedAndroid result2 = ObjectChangedAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00005() {
		byte[] data = getData();

		ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
		ObjectChangedAndroid result2 = ObjectChangedAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00006() {
		byte[] data = getData();

		ObjectChangedAndroid result1 = new ObjectChangedAndroid(data);
		ObjectChangedAndroid result2 = ObjectChangedAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

}
