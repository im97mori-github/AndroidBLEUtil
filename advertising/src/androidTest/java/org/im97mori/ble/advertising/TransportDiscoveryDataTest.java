package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.im97mori.ble.TransportDiscoveryServiceUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.constants.DataType.TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("unused")
public class TransportDiscoveryDataTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_NOT_SPECIFIED
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_FALSE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_OFF;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[3] = (byte) flag;
        data[4] = 0;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_SEEKER_ONLY
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_FALSE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_OFF;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING;
        data[3] = (byte) flag;
        data[4] = 0;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_PROVIDER_ONLY
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_FALSE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_OFF;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT;
        data[3] = (byte) flag;
        data[4] = 0;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_FALSE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_OFF;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT;
        data[3] = (byte) flag;
        data[4] = 0;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_TRUE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_OFF;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT;
        data[3] = (byte) flag;
        data[4] = 0;
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_TRUE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_ON;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT;
        data[3] = (byte) flag;
        data[4] = 0;
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_TRUE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_TEMPORARILY_UNAVAILABLE;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT;
        data[3] = (byte) flag;
        data[4] = 0;
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_TRUE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_TEMPORARILY_UNAVAILABLE;
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT;
        data[3] = (byte) flag;
        data[4] = 1;
        data[5] = 2;
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        int flag1 = TransportDiscoveryData.TDS_FLAGS_ROLE_NOT_SPECIFIED
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_FALSE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_OFF;
        int flag2 = TransportDiscoveryData.TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_TRUE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_TEMPORARILY_UNAVAILABLE;
        byte[] data = new byte[11];
        data[0] = 10;
        data[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[3] = (byte) flag1;
        data[4] = 1;
        data[5] = 2;
        data[6] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING;
        data[7] = (byte) flag2;
        data[8] = 2;
        data[9] = 3;
        data[10] = 4;
        data_00009 = data;
    }
    //@formatter:on

    private byte[] getData() {
        int index = -1;
        byte[] data = null;

        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if ("getData".equals(stackTraceElement.getMethodName())) {
                index = i + 1;
                break;
            }
        }
        if (index >= 0 && index < stackTraceElementArray.length) {
            StackTraceElement stackTraceElement = stackTraceElementArray[index];
            String[] splitted = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + splitted[splitted.length - 1]).get(null);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(TRANSPORT_DISCOVERY_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG, result1.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(data[3], result1.getTransportBlockList().get(0).getTdsFlags());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(0, result1.getTransportBlockList().get(0).getTransportDataLength());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(TRANSPORT_DISCOVERY_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING, result1.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(data[3], result1.getTransportBlockList().get(0).getTdsFlags());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(0, result1.getTransportBlockList().get(0).getTransportDataLength());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(TRANSPORT_DISCOVERY_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT, result1.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(data[3], result1.getTransportBlockList().get(0).getTdsFlags());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(0, result1.getTransportBlockList().get(0).getTransportDataLength());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(TRANSPORT_DISCOVERY_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT, result1.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(data[3], result1.getTransportBlockList().get(0).getTdsFlags());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(0, result1.getTransportBlockList().get(0).getTransportDataLength());
    }

    @Test
    public void test_constructor_00005() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(TRANSPORT_DISCOVERY_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT, result1.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(data[3], result1.getTransportBlockList().get(0).getTdsFlags());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(0, result1.getTransportBlockList().get(0).getTransportDataLength());
    }

    @Test
    public void test_constructor_00006() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(TRANSPORT_DISCOVERY_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT, result1.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(data[3], result1.getTransportBlockList().get(0).getTdsFlags());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(0, result1.getTransportBlockList().get(0).getTransportDataLength());
    }

    @Test
    public void test_constructor_00007() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(TRANSPORT_DISCOVERY_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT, result1.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(data[3], result1.getTransportBlockList().get(0).getTdsFlags());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(0, result1.getTransportBlockList().get(0).getTransportDataLength());
    }

    @Test
    public void test_constructor_00008() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(TRANSPORT_DISCOVERY_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT, result1.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(data[3], result1.getTransportBlockList().get(0).getTdsFlags());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(1, result1.getTransportBlockList().get(0).getTransportDataLength());
        assertArrayEquals(Arrays.copyOfRange(data, 5, 6), result1.getTransportBlockList().get(0).getTransportData());
    }

    @Test
    public void test_constructor_00009() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertEquals(10, result1.getLength());
        assertEquals(TRANSPORT_DISCOVERY_DATA_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG, result1.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(data[3], result1.getTransportBlockList().get(0).getTdsFlags());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertTrue(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertFalse(result1.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(1, result1.getTransportBlockList().get(0).getTransportDataLength());
        assertArrayEquals(Arrays.copyOfRange(data, 5, 6), result1.getTransportBlockList().get(0).getTransportData());

        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING, result1.getTransportBlockList().get(1).getOrganizationId());
        assertEquals(data[7], result1.getTransportBlockList().get(1).getTdsFlags());
        assertFalse(result1.getTransportBlockList().get(1).isTdsFlagsRoleNotSpecified());
        assertFalse(result1.getTransportBlockList().get(1).isTdsFlagsRoleSeekerOnly());
        assertFalse(result1.getTransportBlockList().get(1).isTdsFlagsRoleProviderOnly());
        assertTrue(result1.getTransportBlockList().get(1).isTdsFlagsRoleBothSeekerAndProvider());
        assertFalse(result1.getTransportBlockList().get(1).isTdsFlagsTransportDataIncompleteFalse());
        assertTrue(result1.getTransportBlockList().get(1).isTdsFlagsTransportDataIncompleteTrue());
        assertFalse(result1.getTransportBlockList().get(1).isTdsFlagsTransportStateOff());
        assertFalse(result1.getTransportBlockList().get(1).isTdsFlagsTransportStateOn());
        assertTrue(result1.getTransportBlockList().get(1).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(2, result1.getTransportBlockList().get(1).getTransportDataLength());
        assertArrayEquals(Arrays.copyOfRange(data, 9, 11), result1.getTransportBlockList().get(1).getTransportData());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getTransportBlockList().size(), result2.getTransportBlockList().size());
        for (int i = 0; i < result1.getTransportBlockList().size(); i++) {
            TransportDiscoveryData.TransportBlock block1 = result1.getTransportBlockList().get(i);
            TransportDiscoveryData.TransportBlock block2 = result2.getTransportBlockList().get(i);
            assertEquals(block1.getOrganizationId(), block2.getOrganizationId());
            assertEquals(block1.getTdsFlags(), block2.getTdsFlags());
            assertEquals(block1.getTransportDataLength(), block2.getTransportDataLength());
            assertArrayEquals(block1.getTransportData(), block2.getTransportData());
        }
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getTransportBlockList().size(), result2.getTransportBlockList().size());
        for (int i = 0; i < result1.getTransportBlockList().size(); i++) {
            TransportDiscoveryData.TransportBlock block1 = result1.getTransportBlockList().get(i);
            TransportDiscoveryData.TransportBlock block2 = result2.getTransportBlockList().get(i);
            assertEquals(block1.getOrganizationId(), block2.getOrganizationId());
            assertEquals(block1.getTdsFlags(), block2.getTdsFlags());
            assertEquals(block1.getTransportDataLength(), block2.getTransportDataLength());
            assertArrayEquals(block1.getTransportData(), block2.getTransportData());
        }
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getTransportBlockList().size(), result2.getTransportBlockList().size());
        for (int i = 0; i < result1.getTransportBlockList().size(); i++) {
            TransportDiscoveryData.TransportBlock block1 = result1.getTransportBlockList().get(i);
            TransportDiscoveryData.TransportBlock block2 = result2.getTransportBlockList().get(i);
            assertEquals(block1.getOrganizationId(), block2.getOrganizationId());
            assertEquals(block1.getTdsFlags(), block2.getTdsFlags());
            assertEquals(block1.getTransportDataLength(), block2.getTransportDataLength());
            assertArrayEquals(block1.getTransportData(), block2.getTransportData());
        }
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getTransportBlockList().size(), result2.getTransportBlockList().size());
        for (int i = 0; i < result1.getTransportBlockList().size(); i++) {
            TransportDiscoveryData.TransportBlock block1 = result1.getTransportBlockList().get(i);
            TransportDiscoveryData.TransportBlock block2 = result2.getTransportBlockList().get(i);
            assertEquals(block1.getOrganizationId(), block2.getOrganizationId());
            assertEquals(block1.getTdsFlags(), block2.getTdsFlags());
            assertEquals(block1.getTransportDataLength(), block2.getTransportDataLength());
            assertArrayEquals(block1.getTransportData(), block2.getTransportData());
        }
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getTransportBlockList().size(), result2.getTransportBlockList().size());
        for (int i = 0; i < result1.getTransportBlockList().size(); i++) {
            TransportDiscoveryData.TransportBlock block1 = result1.getTransportBlockList().get(i);
            TransportDiscoveryData.TransportBlock block2 = result2.getTransportBlockList().get(i);
            assertEquals(block1.getOrganizationId(), block2.getOrganizationId());
            assertEquals(block1.getTdsFlags(), block2.getTdsFlags());
            assertEquals(block1.getTransportDataLength(), block2.getTransportDataLength());
            assertArrayEquals(block1.getTransportData(), block2.getTransportData());
        }
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getTransportBlockList().size(), result2.getTransportBlockList().size());
        for (int i = 0; i < result1.getTransportBlockList().size(); i++) {
            TransportDiscoveryData.TransportBlock block1 = result1.getTransportBlockList().get(i);
            TransportDiscoveryData.TransportBlock block2 = result2.getTransportBlockList().get(i);
            assertEquals(block1.getOrganizationId(), block2.getOrganizationId());
            assertEquals(block1.getTdsFlags(), block2.getTdsFlags());
            assertEquals(block1.getTransportDataLength(), block2.getTransportDataLength());
            assertArrayEquals(block1.getTransportData(), block2.getTransportData());
        }
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getTransportBlockList().size(), result2.getTransportBlockList().size());
        for (int i = 0; i < result1.getTransportBlockList().size(); i++) {
            TransportDiscoveryData.TransportBlock block1 = result1.getTransportBlockList().get(i);
            TransportDiscoveryData.TransportBlock block2 = result2.getTransportBlockList().get(i);
            assertEquals(block1.getOrganizationId(), block2.getOrganizationId());
            assertEquals(block1.getTdsFlags(), block2.getTdsFlags());
            assertEquals(block1.getTransportDataLength(), block2.getTransportDataLength());
            assertArrayEquals(block1.getTransportData(), block2.getTransportData());
        }
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getTransportBlockList().size(), result2.getTransportBlockList().size());
        for (int i = 0; i < result1.getTransportBlockList().size(); i++) {
            TransportDiscoveryData.TransportBlock block1 = result1.getTransportBlockList().get(i);
            TransportDiscoveryData.TransportBlock block2 = result2.getTransportBlockList().get(i);
            assertEquals(block1.getOrganizationId(), block2.getOrganizationId());
            assertEquals(block1.getTdsFlags(), block2.getTdsFlags());
            assertEquals(block1.getTransportDataLength(), block2.getTransportDataLength());
            assertArrayEquals(block1.getTransportData(), block2.getTransportData());
        }
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getTransportBlockList().size(), result2.getTransportBlockList().size());
        for (int i = 0; i < result1.getTransportBlockList().size(); i++) {
            TransportDiscoveryData.TransportBlock block1 = result1.getTransportBlockList().get(i);
            TransportDiscoveryData.TransportBlock block2 = result2.getTransportBlockList().get(i);
            assertEquals(block1.getOrganizationId(), block2.getOrganizationId());
            assertEquals(block1.getTdsFlags(), block2.getTdsFlags());
            assertEquals(block1.getTransportDataLength(), block2.getTransportDataLength());
            assertArrayEquals(block1.getTransportData(), block2.getTransportData());
        }
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        TransportDiscoveryDataAndroid result1 = new TransportDiscoveryDataAndroid(data, 0, data[0]);
        TransportDiscoveryDataAndroid result2 = TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
