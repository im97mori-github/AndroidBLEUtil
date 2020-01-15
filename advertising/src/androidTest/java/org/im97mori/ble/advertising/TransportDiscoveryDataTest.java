package org.im97mori.ble.advertising;

import org.im97mori.ble.TransportDiscoveryServiceUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TransportDiscoveryDataTest {

    @Test
    public void constructTest1() {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_NOT_SPECIFIED
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_FALSE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_OFF;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[3] = (byte) flag;
        data[4] = 0;

        TransportDiscoveryData result = new TransportDiscoveryData(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_TRANSPORT_DISCOVERY_DATA, result.getDataType());
        assertEquals(1, result.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG
                , result.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(flag, result.getTransportBlockList().get(0).getTdsFlags());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(0, result.getTransportBlockList().get(0).getTransportDataLength());
    }

    @Test
    public void constructTest2() {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_SEEKER_ONLY
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_FALSE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_OFF;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING;
        data[3] = (byte) flag;
        data[4] = 0;

        TransportDiscoveryData result = new TransportDiscoveryData(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_TRANSPORT_DISCOVERY_DATA, result.getDataType());
        assertEquals(1, result.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING
                , result.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(flag, result.getTransportBlockList().get(0).getTdsFlags());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(0, result.getTransportBlockList().get(0).getTransportDataLength());
    }

    @Test
    public void constructTest3() {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_PROVIDER_ONLY
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_FALSE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_OFF;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT;
        data[3] = (byte) flag;
        data[4] = 0;

        TransportDiscoveryData result = new TransportDiscoveryData(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_TRANSPORT_DISCOVERY_DATA, result.getDataType());
        assertEquals(1, result.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT
                , result.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(flag, result.getTransportBlockList().get(0).getTdsFlags());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(0, result.getTransportBlockList().get(0).getTransportDataLength());
    }

    @Test
    public void constructTest4() {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_FALSE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_OFF;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT;
        data[3] = (byte) flag;
        data[4] = 0;

        TransportDiscoveryData result = new TransportDiscoveryData(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_TRANSPORT_DISCOVERY_DATA, result.getDataType());
        assertEquals(1, result.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT
                , result.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(flag, result.getTransportBlockList().get(0).getTdsFlags());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(0, result.getTransportBlockList().get(0).getTransportDataLength());
    }

    @Test
    public void constructTest5() {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_TRUE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_OFF;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT;
        data[3] = (byte) flag;
        data[4] = 0;

        TransportDiscoveryData result = new TransportDiscoveryData(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_TRANSPORT_DISCOVERY_DATA, result.getDataType());
        assertEquals(1, result.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT
                , result.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(flag, result.getTransportBlockList().get(0).getTdsFlags());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(0, result.getTransportBlockList().get(0).getTransportDataLength());
    }

    @Test
    public void constructTest6() {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_TRUE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_ON;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT;
        data[3] = (byte) flag;
        data[4] = 0;

        TransportDiscoveryData result = new TransportDiscoveryData(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_TRANSPORT_DISCOVERY_DATA, result.getDataType());
        assertEquals(1, result.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT
                , result.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(flag, result.getTransportBlockList().get(0).getTdsFlags());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(0, result.getTransportBlockList().get(0).getTransportDataLength());
    }

    @Test
    public void constructTest7() {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_TRUE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_TEMPORARILY_UNAVAILABLE;
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT;
        data[3] = (byte) flag;
        data[4] = 0;

        TransportDiscoveryData result = new TransportDiscoveryData(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_TRANSPORT_DISCOVERY_DATA, result.getDataType());
        assertEquals(1, result.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT
                , result.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(flag, result.getTransportBlockList().get(0).getTdsFlags());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(0, result.getTransportBlockList().get(0).getTransportDataLength());
    }

    @Test
    public void constructTest8() {
        int flag = TransportDiscoveryData.TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_TRUE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_TEMPORARILY_UNAVAILABLE;
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT;
        data[3] = (byte) flag;
        data[4] = 1;
        data[5] = 2;

        TransportDiscoveryData result = new TransportDiscoveryData(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_TRANSPORT_DISCOVERY_DATA, result.getDataType());
        assertEquals(1, result.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT
                , result.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(flag, result.getTransportBlockList().get(0).getTdsFlags());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(1, result.getTransportBlockList().get(0).getTransportDataLength());
        assertArrayEquals(Arrays.copyOfRange(data, 5, 6), result.getTransportBlockList().get(0).getTransportData());
    }

    @Test
    public void constructTest9() {
        int flag1 = TransportDiscoveryData.TDS_FLAGS_ROLE_NOT_SPECIFIED
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_FALSE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_OFF;
        int flag2 = TransportDiscoveryData.TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_TRUE
                | TransportDiscoveryData.TDS_FLSGS_TRANSPORT_STATE_TEMPORARILY_UNAVAILABLE;
        byte[] data = new byte[11];
        data[0] = 10;
        data[1] = DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
        data[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        data[3] = (byte) flag1;
        data[4] = 1;
        data[5] = 2;
        data[6] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING;
        data[7] = (byte) flag2;
        data[8] = 2;
        data[9] = 3;
        data[10] = 4;

        TransportDiscoveryData result = new TransportDiscoveryData(data, 0, data[0]);
        assertEquals(10, result.getLength());
        assertEquals(DATA_TYPE_TRANSPORT_DISCOVERY_DATA, result.getDataType());
        assertEquals(2, result.getTransportBlockList().size());
        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG
                , result.getTransportBlockList().get(0).getOrganizationId());
        assertEquals(flag1, result.getTransportBlockList().get(0).getTdsFlags());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsRoleNotSpecified());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleSeekerOnly());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleProviderOnly());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsRoleBothSeekerAndProvider());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteFalse());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportDataIncompleteTrue());
        assertTrue(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOff());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateOn());
        assertFalse(result.getTransportBlockList().get(0).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(1, result.getTransportBlockList().get(0).getTransportDataLength());
        assertArrayEquals(Arrays.copyOfRange(data, 5, 6), result.getTransportBlockList().get(0).getTransportData());

        assertEquals(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING
                , result.getTransportBlockList().get(1).getOrganizationId());
        assertEquals(flag2, result.getTransportBlockList().get(1).getTdsFlags());
        assertFalse(result.getTransportBlockList().get(1).isTdsFlagsRoleNotSpecified());
        assertFalse(result.getTransportBlockList().get(1).isTdsFlagsRoleSeekerOnly());
        assertFalse(result.getTransportBlockList().get(1).isTdsFlagsRoleProviderOnly());
        assertTrue(result.getTransportBlockList().get(1).isTdsFlagsRoleBothSeekerAndProvider());
        assertFalse(result.getTransportBlockList().get(1).isTdsFlagsTransportDataIncompleteFalse());
        assertTrue(result.getTransportBlockList().get(1).isTdsFlagsTransportDataIncompleteTrue());
        assertFalse(result.getTransportBlockList().get(1).isTdsFlagsTransportStateOff());
        assertFalse(result.getTransportBlockList().get(1).isTdsFlagsTransportStateOn());
        assertTrue(result.getTransportBlockList().get(1).isTdsFlagsTransportStateTemporarilyUnavailable());
        assertEquals(2, result.getTransportBlockList().get(1).getTransportDataLength());
        assertArrayEquals(Arrays.copyOfRange(data, 9, 11), result.getTransportBlockList().get(1).getTransportData());
    }

}
