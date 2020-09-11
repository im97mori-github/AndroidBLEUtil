package org.im97mori.ble.profile.htp.central;

import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.service.dis.central.DeviceInformationServiceCallback;
import org.im97mori.ble.service.hts.central.HealthThermometerServiceCallback;

/**
 * Health Thermometer Profile callback
 *
 * @see DeviceInformationServiceCallback
 * @see HealthThermometerServiceCallback
 * @see ProfileCallback
 */
public interface HealthThermometerProfileCallback extends DeviceInformationServiceCallback, HealthThermometerServiceCallback, ProfileCallback {
}
