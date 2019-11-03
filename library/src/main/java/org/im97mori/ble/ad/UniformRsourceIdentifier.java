package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreater;

import java.net.URI;

import static org.im97mori.ble.BLEConstants.URI_SCHEME_NAME_STRING_MAPPING;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;

/**
 * <p>
 * URI
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class UniformRsourceIdentifier extends AbstractAdvertisingData {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<UniformRsourceIdentifier> CREATOR = new ByteArrayCreater<UniformRsourceIdentifier>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UniformRsourceIdentifier createFromParcel(@NonNull Parcel in) {
            return new UniformRsourceIdentifier(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UniformRsourceIdentifier[] newArray(int size) {
            return new UniformRsourceIdentifier[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public UniformRsourceIdentifier createFromByteArray(@NonNull byte[] values) {
            return new UniformRsourceIdentifier(values, 0, values.length - 1);
        }

    };

    /**
     * URI text
     */
    private final String mUriString;

    /**
     * URI
     */
    private final URI mUri;

    /**
     * Constructor for URI
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public UniformRsourceIdentifier(@NonNull byte[] data
            , int offset
            , int length) {
        super(length);

        mUriString = new String(data, offset + 2, length - 1);
        int scheme = mUriString.charAt(0) & 0xff;
        if (URI_SCHEME_NAME_STRING_MAPPING.containsKey(scheme)) {
            mUri = URI.create(URI_SCHEME_NAME_STRING_MAPPING.get(scheme) + mUriString.substring(1));
        } else {
            mUri = null;
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UniformRsourceIdentifier(@NonNull Parcel in) {
        super(in.readInt());
        mUriString = in.readString();
        mUri = (URI) in.readSerializable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(mLength);
        dest.writeString(mUriString);
        dest.writeSerializable(mUri);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
    }

    /**
     * @return URI text
     */
    @NonNull
    public String getUriString() {
        return mUriString;
    }

    /**
     * @return {@link URI}, or {@code null} when unknown scheme
     */
    @Nullable
    public URI getUri() {
        return mUri;
    }

}
