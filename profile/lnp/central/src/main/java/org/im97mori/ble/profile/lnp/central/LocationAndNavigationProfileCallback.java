package org.im97mori.ble.profile.lnp.central;

import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.service.bas.central.BatteryServiceCallback;
import org.im97mori.ble.service.dis.central.DeviceInformationServiceCallback;
import org.im97mori.ble.service.lns.central.LocationAndNavigationServiceCallback;

/**
 * Location and Navigation Profile callback
 *
 * @see DeviceInformationServiceCallback
 * @see BatteryServiceCallback
 * @see LocationAndNavigationServiceCallback
 * @see ProfileCallback
 */
public interface LocationAndNavigationProfileCallback extends DeviceInformationServiceCallback, BatteryServiceCallback, LocationAndNavigationServiceCallback, ProfileCallback {
}
