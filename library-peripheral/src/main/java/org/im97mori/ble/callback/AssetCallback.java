package org.im97mori.ble.callback;

import android.content.Context;

import com.google.gson.Gson;

import org.im97mori.ble.MockData;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Mockdata from asset callback
 */
@SuppressWarnings("WeakerAccess")
public abstract class AssetCallback extends BaseMockCallback {

    /**
     * @param context             {@link Context} instance
     * @param serviceListFileName mock data file path
     * @param isFallback          fallback flag
     * @throws IOException file not found
     */
    public AssetCallback(Context context, String serviceListFileName, boolean isFallback) throws IOException {
        super(new Gson().fromJson(new InputStreamReader(context.getAssets().open(serviceListFileName)), MockData.class), isFallback);
    }

}
