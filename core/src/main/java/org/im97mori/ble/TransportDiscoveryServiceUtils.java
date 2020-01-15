package org.im97mori.ble;

/**
 * <p>
 * Utility for
 * https://www.bluetooth.com/ja-jp/specifications/assigned-numbers/transport-discovery-service-organization-ids/
 * </p>
 */
@SuppressWarnings("WeakerAccess")
public class TransportDiscoveryServiceUtils {

    /**
     * 0x01: Bluetooth SIG
     */
    public static final int ORGANIZATION_ID_BLUETOOTH_SIG = 0x01;

    /**
     * 0x02: Wi-Fi Alliance Neighbor Awareness Networking
     */
    public static final int ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING = 0x02;

    /**
     * 0x03: Wi-Fi Alliance Service Advertisement
     */
    public static final int ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT = 0x03;

    /**
     * @param organizationId Organization ID
     * @return {@code true}:Bluetooth SIG, {@code false}:not Bluetooth SIG
     */
    public static boolean isOrganizationIdBluetoothSig(int organizationId) {
        return ORGANIZATION_ID_BLUETOOTH_SIG == organizationId;
    }

    /**
     * @param organizationId Organization ID
     * @return {@code true}:Wi-Fi Alliance Neighbor Awareness Networking, {@code false}:not Wi-Fi Alliance Neighbor Awareness Networking
     */
    public static boolean isOrganizationIdWifiAllianceNeighborAwarenessNetworking(int organizationId) {
        return ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING == organizationId;
    }

    /**
     * @param organizationId Organization ID
     * @return {@code true}:Wi-Fi Alliance Service Advertisement, {@code false}:not Wi-Fi Alliance Service Advertisement
     */
    public static boolean isOrganizationIdWifiAllianceServiceAdvertisement(int organizationId) {
        return ORGANIZATION_ID_WIFI_ALLIANCE_SERVICE_ADVERTISEMENT == organizationId;
    }

}
