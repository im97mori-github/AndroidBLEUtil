package org.im97mori.ble.profile.cpp.central;

import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.service.bas.central.BatteryServiceCallback;
import org.im97mori.ble.service.cps.central.CyclingPowerServiceCallback;
import org.im97mori.ble.service.dis.central.DeviceInformationServiceCallback;

/**
 * Cycling Power Profile callback
 *
 * @see CyclingPowerServiceCallback
 * @see DeviceInformationServiceCallback
 * @see BatteryServiceCallback
 * @see ProfileCallback
 */
public interface CyclingPowerProfileCallback extends CyclingPowerServiceCallback, DeviceInformationServiceCallback, BatteryServiceCallback, ProfileCallback {
}
