package org.im97mori.ble.profile.rcp.central;

import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.service.bms.central.BondManagementServiceCallback;
import org.im97mori.ble.service.rcs.central.ReconnectionConfigurationServiceCallback;

/**
 * Reconnection Configuration Profile callback
 *
 * @see ReconnectionConfigurationServiceCallback
 * @see BondManagementServiceCallback
 * @see ProfileCallback
 */
public interface ReconnectionConfigurationProfileCallback extends ReconnectionConfigurationServiceCallback, BondManagementServiceCallback, ProfileCallback {
}
