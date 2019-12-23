package org.im97mori.ble.characteristic.core;

import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * Multiple Packet array Creator
 *
 * @param <T1> T1 must have constructor with T2 array
 */
@SuppressWarnings("unused")
public interface MultiplePacketCreater<T1, T2> extends Parcelable.Creator<T1> {

    /**
     * Create instance from Registered User Data array
     *
     * @param multiplePacketArray first to last T2 packet array
     * @return T1 instance
     */
    @NonNull
    T1 createFromMultiplePacketArray(@NonNull T2[] multiplePacketArray);

}
