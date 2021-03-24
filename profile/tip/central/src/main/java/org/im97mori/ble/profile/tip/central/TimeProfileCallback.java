package org.im97mori.ble.profile.tip.central;

import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.service.cts.central.CurrentTimeServiceCallback;
import org.im97mori.ble.service.ndcs.central.NextDstChangeServiceCallback;
import org.im97mori.ble.service.rtus.central.ReferenceTimeUpdateServiceCallback;

/**
 * Time Profile callback
 *
 * @see CurrentTimeServiceCallback
 * @see NextDstChangeServiceCallback
 * @see ReferenceTimeUpdateServiceCallback
 * @see ProfileCallback
 */
public interface TimeProfileCallback extends CurrentTimeServiceCallback, NextDstChangeServiceCallback, ReferenceTimeUpdateServiceCallback, ProfileCallback {
}
