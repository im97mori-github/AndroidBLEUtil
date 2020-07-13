package org.im97mori.ble.profile.blp.central;

import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.service.bls.central.BloodPressureServiceCallback;
import org.im97mori.ble.service.dis.central.DeviceInformationServiceCallback;

/**
 * Blood Pressure Profile callback
 *
 * @see DeviceInformationServiceCallback
 * @see BloodPressureServiceCallback
 * @see ProfileCallback
 */
public interface BloodPressureProfileCallback extends DeviceInformationServiceCallback, BloodPressureServiceCallback, ProfileCallback {
}
