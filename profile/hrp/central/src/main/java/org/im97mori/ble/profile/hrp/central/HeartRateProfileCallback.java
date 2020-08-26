package org.im97mori.ble.profile.hrp.central;

import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.service.dis.central.DeviceInformationServiceCallback;
import org.im97mori.ble.service.hrs.central.HeartRateServiceCallback;

/**
 * Heart Rate Profile callback
 *
 * @see DeviceInformationServiceCallback
 * @see HeartRateServiceCallback
 * @see ProfileCallback
 */
public interface HeartRateProfileCallback extends DeviceInformationServiceCallback, HeartRateServiceCallback, ProfileCallback {
}
