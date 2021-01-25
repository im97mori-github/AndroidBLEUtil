package org.im97mori.ble.profile.wsp.central;

import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.service.bas.central.BatteryServiceCallback;
import org.im97mori.ble.service.bcs.central.BodyCompositionServiceCallback;
import org.im97mori.ble.service.cts.central.CurrentTimeServiceCallback;
import org.im97mori.ble.service.dis.central.DeviceInformationServiceCallback;
import org.im97mori.ble.service.uds.central.UserDataServiceCallback;
import org.im97mori.ble.service.wss.central.WeightScaleServiceCallback;

/**
 * Weight Scale Profile callback
 *
 * @see WeightScaleServiceCallback
 * @see DeviceInformationServiceCallback
 * @see UserDataServiceCallback
 * @see BodyCompositionServiceCallback
 * @see CurrentTimeServiceCallback
 * @see ProfileCallback
 */
public interface WeightScaleProfileCallback extends WeightScaleServiceCallback, DeviceInformationServiceCallback, UserDataServiceCallback, BodyCompositionServiceCallback, BatteryServiceCallback, CurrentTimeServiceCallback, ProfileCallback {
}
