package org.im97mori.ble.profile.rscp.central;

import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.service.dis.central.DeviceInformationServiceCallback;
import org.im97mori.ble.service.rscs.central.RunningSpeedAndCadenceServiceCallback;

/**
 * Running Speed and Cadence Profile callback
 *
 * @see RunningSpeedAndCadenceServiceCallback
 * @see DeviceInformationServiceCallback
 * @see ProfileCallback
 */
public interface RunningSpeedAndCadenceProfileCallback extends RunningSpeedAndCadenceServiceCallback, DeviceInformationServiceCallback, ProfileCallback {
}
