package org.im97mori.ble.profile.esp.central;

import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.service.bas.central.BatteryServiceCallback;
import org.im97mori.ble.service.dis.central.DeviceInformationServiceCallback;
import org.im97mori.ble.service.ess.central.EnvironmentalSensingServiceCallback;

/**
 * Environmental Sensing Profile callback
 *
 * @see org.im97mori.ble.service.ess.central.EnvironmentalSensingServiceCallback
 * @see org.im97mori.ble.service.dis.central.DeviceInformationServiceCallback
 * @see org.im97mori.ble.service.bas.central.BatteryServiceCallback
 * @see ProfileCallback
 */
public interface EnvironmentalSensingProfileCallback extends EnvironmentalSensingServiceCallback, DeviceInformationServiceCallback, BatteryServiceCallback, ProfileCallback {
}
