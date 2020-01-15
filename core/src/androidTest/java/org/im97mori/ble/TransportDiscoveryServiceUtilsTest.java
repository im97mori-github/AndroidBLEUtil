package org.im97mori.ble;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused"})
public class TransportDiscoveryServiceUtilsTest {

    @Test
    public void test_00001() {
        assertTrue(TransportDiscoveryServiceUtils.isOrganizationIdBluetoothSig(TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG));
        assertFalse(TransportDiscoveryServiceUtils.isOrganizationIdWifiAllianceNeighborAwarenessNetworking(TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG));
        assertFalse(TransportDiscoveryServiceUtils.isOrganizationIdWifiAllianceServiceAdvertisement(TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG));
    }

    @Test
    public void test_00002() {
        assertFalse(TransportDiscoveryServiceUtils.isOrganizationIdBluetoothSig(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING));
        assertTrue(TransportDiscoveryServiceUtils.isOrganizationIdWifiAllianceNeighborAwarenessNetworking(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING));
        assertFalse(TransportDiscoveryServiceUtils.isOrganizationIdWifiAllianceServiceAdvertisement(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING));
    }

    @Test
    public void test_00003() {
        assertFalse(TransportDiscoveryServiceUtils.isOrganizationIdBluetoothSig(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT));
        assertFalse(TransportDiscoveryServiceUtils.isOrganizationIdWifiAllianceNeighborAwarenessNetworking(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT));
        assertTrue(TransportDiscoveryServiceUtils.isOrganizationIdWifiAllianceServiceAdvertisement(TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT));
    }

}
