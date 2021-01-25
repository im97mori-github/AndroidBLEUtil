package org.im97mori.ble.profile.ftmp.central;

import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.service.dis.central.DeviceInformationServiceCallback;
import org.im97mori.ble.service.ftms.central.FitnessMachineServiceCallback;
import org.im97mori.ble.service.uds.central.UserDataServiceCallback;

/**
 * Weight Scale Profile callback
 *
 * @see FitnessMachineServiceCallback
 * @see DeviceInformationServiceCallback
 * @see UserDataServiceCallback
 * @see ProfileCallback
 */
public interface FitnessMachineProfileCallback extends FitnessMachineServiceCallback, DeviceInformationServiceCallback, UserDataServiceCallback, ProfileCallback {
}
