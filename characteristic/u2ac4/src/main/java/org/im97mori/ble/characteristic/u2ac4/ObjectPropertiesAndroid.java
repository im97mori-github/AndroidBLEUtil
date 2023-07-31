package org.im97mori.ble.characteristic.u2ac4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * object properties (Characteristics UUID: 0x2AC4)
 */
@SuppressWarnings({"WeakerAccess"})
public class ObjectPropertiesAndroid extends ObjectProperties implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ObjectPropertiesAndroid> CREATOR = new ByteArrayCreator<ObjectPropertiesAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectPropertiesAndroid createFromParcel(@NonNull Parcel in) {
            return new ObjectPropertiesAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectPropertiesAndroid[] newArray(int size) {
            return new ObjectPropertiesAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ObjectPropertiesAndroid createFromByteArray(@NonNull byte[] values) {
            return new ObjectPropertiesAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AC4
     */
    @Deprecated
    public ObjectPropertiesAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ObjectPropertiesAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from flags
     *
     * @param isObjectPropertiesDeletePermitted   {@code true}:{@link #OBJECT_PROPERTIES_DELETE_TRUE},
     *                                            {@code false}:{@link #OBJECT_PROPERTIES_DELETE_FALSE}
     * @param isObjectPropertiesExecutePermitted  {@code true}:{@link #OBJECT_PROPERTIES_EXECUTE_TRUE},
     *                                            {@code false}:{@link #OBJECT_PROPERTIES_EXECUTE_FALSE}
     * @param isObjectPropertiesReadPermitted     {@code true}:{@link #OBJECT_PROPERTIES_READ_TRUE},
     *                                            {@code false}:{@link #OBJECT_PROPERTIES_READ_FALSE}
     * @param isObjectPropertiesWritePermitted    {@code true}:{@link #OBJECT_PROPERTIES_WRITE_TRUE},
     *                                            {@code false}:{@link #OBJECT_PROPERTIES_WRITE_FALSE}
     * @param isObjectPropertiesAppendPermitted   {@code true}:{@link #OBJECT_PROPERTIES_APPEND_TRUE},
     *                                            {@code false}:{@link #OBJECT_PROPERTIES_APPEND_FALSE}
     * @param isObjectPropertiesTruncatePermitted {@code true}:{@link #OBJECT_PROPERTIES_TRUNCATE_TRUE},
     *                                            {@code false}:{@link #OBJECT_PROPERTIES_TRUNCATE_FALSE}
     * @param isObjectPropertiesPatchPermitted    {@code true}:{@link #OBJECT_PROPERTIES_PATCH_TRUE},
     *                                            {@code false}:{@link #OBJECT_PROPERTIES_PATCH_FALSE}
     * @param isObjectPropertiesMarked            {@code true}:{@link #OBJECT_PROPERTIES_MARK_TRUE},
     *                                            {@code false}:{@link #OBJECT_PROPERTIES_MARK_FALSE}
     */
    public ObjectPropertiesAndroid(boolean isObjectPropertiesDeletePermitted
            , boolean isObjectPropertiesExecutePermitted
            , boolean isObjectPropertiesReadPermitted
            , boolean isObjectPropertiesWritePermitted
            , boolean isObjectPropertiesAppendPermitted
            , boolean isObjectPropertiesTruncatePermitted
            , boolean isObjectPropertiesPatchPermitted
            , boolean isObjectPropertiesMarked) {
        super(isObjectPropertiesDeletePermitted, isObjectPropertiesExecutePermitted, isObjectPropertiesReadPermitted, isObjectPropertiesWritePermitted, isObjectPropertiesAppendPermitted, isObjectPropertiesTruncatePermitted, isObjectPropertiesPatchPermitted, isObjectPropertiesMarked);
    }


    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ObjectPropertiesAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()));
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
        dest.writeByteArray(getBytes());
    }

}
