package org.im97mori.ble.profile.cscp.central;

import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.service.cscs.central.CyclingSpeedAndCadenceServiceCallback;
import org.im97mori.ble.service.dis.central.DeviceInformationServiceCallback;

/**
 * Cycling Speed and Cadence Profile callback
 *
 * @see CyclingSpeedAndCadenceServiceCallback
 * @see DeviceInformationServiceCallback
 * @see ProfileCallback
 */
public interface CyclingSpeedAndCadenceProfileCallback extends CyclingSpeedAndCadenceServiceCallback, DeviceInformationServiceCallback, ProfileCallback {
}
