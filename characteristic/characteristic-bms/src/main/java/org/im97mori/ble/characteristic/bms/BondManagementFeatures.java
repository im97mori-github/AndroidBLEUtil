package org.im97mori.ble.characteristic.bms;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BOND_MANAGEMENT_FEATURES_CHARACTERISTIC;

/**
 * Bond Management Features (Characteristics UUID: 0x2AA5)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BondManagementFeatures implements ByteArrayInterface, Parcelable {

    /**
     * @see #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_SUPPORTED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_SUPPORTED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_SUPPORTED_MASK = 0b00000000_00000000_00000001;

    /**
     * 0: Delete Bond of current connection (BR/EDR and LE) supported False
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Delete Bond of current connection (BR/EDR and LE) supported True
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_SUPPORTED_TRUE = 0b00000000_00000000_00000001;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_MASK = 0b00000000_00000000_00000010;

    /**
     * 0: Authorization Code required for feature above False
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_FALSE = 0b00000000_00000000_000000000;

    /**
     * 1: Authorization Code required for feature above True
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE = 0b00000000_00000000_00000010;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_SUPPORTED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_SUPPORTED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_SUPPORTED_MASK = 0b00000000_00000000_00000100;

    /**
     * 0: Delete bond of current connection (BR/EDR transport only) supported False
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Delete bond of current connection (BR/EDR transport only) supported True
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_SUPPORTED_TRUE = 0b00000000_00000000_00000100;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_AUTHORIZATION_CODE_REQUIRED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_AUTHORIZATION_CODE_REQUIRED_MASK = 0b00000000_00000000_00001000;

    /**
     * 0: Authorization Code required for feature above False
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_AUTHORIZATION_CODE_REQUIRED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Authorization Code required for feature above True
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE = 0b00000000_00000000_00001000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_SUPPORTED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_SUPPORTED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_SUPPORTED_MASK = 0b00000000_00000000_00010000;

    /**
     * 0: Delete bond of current connection (LE transport only) supported False
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Delete bond of current connection (LE transport only) supported True
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_SUPPORTED_TRUE = 0b00000000_00000000_00010000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_AUTHORIZATION_CODE_REQUIRED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_AUTHORIZATION_CODE_REQUIRED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_AUTHORIZATION_CODE_REQUIRED_MASK = 0b00000000_00000000_00100000;

    /**
     * 0: Authorization Code required for feature above False
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_AUTHORIZATION_CODE_REQUIRED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Authorization Code required for feature above True
     */
    public static final int BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_AUTHORIZATION_CODE_REQUIRED_TRUE = 0b00000000_00000000_00100000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_SUPPORTED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_SUPPORTED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_SUPPORTED_MASK = 0b00000000_00000000_01000000;

    /**
     * 0: Remove all bonds on server (BR/EDR and LE) supported False
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Remove all bonds on server (BR/EDR and LE) supported True
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_SUPPORTED_TRUE = 0b00000000_00000000_01000000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_MASK = 0b00000000_00000000_10000000;

    /**
     * 0: Authorization Code required for feature above False
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Authorization Code required for feature above True
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE = 0b00000000_00000000_10000000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_SUPPORTED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_SUPPORTED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_SUPPORTED_MASK = 0b00000000_00000001_00000000;

    /**
     * 0: Remove all bonds on server (BR/EDR transport only) supported False
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 2: Remove all bonds on server (BR/EDR transport only) supported True
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_SUPPORTED_TRUE = 0b00000000_00000001_00000000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_MASK = 0b00000000_00000010_00000000;

    /**
     * 0: Authorization Code required for feature above False
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Authorization Code required for feature above True
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE = 0b00000000_00000010_00000000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_SUPPORTED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_SUPPORTED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_SUPPORTED_MASK = 0b00000000_00000100_00000000;

    /**
     * 0: Remove all bonds on server (LE transport only) supported False
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Remove all bonds on server (LE transport only) supported True
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_SUPPORTED_TRUE = 0b00000000_00000100_00000000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_MASK = 0b00000000_00001000_00000000;

    /**
     * 0: Authorization Code required for feature above False
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Authorization Code required for feature above True
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_TRUE = 0b00000000_00001000_00000000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_SUPPORTED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_SUPPORTED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_SUPPORTED_MASK = 0b00000000_00010000_00000000;

    /**
     * 0: Remove all but the active bond on server (BR/EDR and LE) supported False
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Remove all but the active bond on server (BR/EDR and LE) supported True
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_SUPPORTED_TRUE = 0b00000000_00010000_00000000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_MASK = 0b00000000_00100000_00000000;

    /**
     * 0: Authorization Code required for feature above False
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Authorization Code required for feature above True
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE = 0b00000000_00100000_00000000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_SUPPORTED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_SUPPORTED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_SUPPORTED_MASK = 0b00000000_01000000_00000000;

    /**
     * 0: Remove all but the active bond on server (BR/EDR transport only) supported False
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Remove all but the active bond on server (BR/EDR transport only) supported True
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_SUPPORTED_TRUE = 0b00000000_01000000_00000000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_MASK = 0b00000000_10000000_00000000;

    /**
     * 0: Authorization Code required for feature above False
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Authorization Code required for feature above True
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE = 0b00000000_10000000_00000000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_SUPPORTED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_SUPPORTED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_SUPPORTED_MASK = 0b00000001_00000000_00000000;

    /**
     * 0: Remove all but the active bond on server (LE transport only) supported False
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Remove all but the active bond on server (LE transport only) supported True
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_SUPPORTED_TRUE = 0b00000001_00000000_00000000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_MASK = 0b00000010_00000000_00000000;

    /**
     * 0: Authorization Code required for feature above False
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Authorization Code required for feature above True
     */
    public static final int BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_TRUE = 0b00000010_00000000_00000000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_IDENTIFY_YOURSELF_SUPPORTED_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_IDENTIFY_YOURSELF_SUPPORTED_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_IDENTIFY_YOURSELF_SUPPORTED_MASK = 0b00000100_00000000_00000000;

    /**
     * 0: Identify yourself supported False
     */
    public static final int BOND_MANAGEMENT_FEATURES_IDENTIFY_YOURSELF_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Identify yourself supported True
     */
    public static final int BOND_MANAGEMENT_FEATURES_IDENTIFY_YOURSELF_SUPPORTED_TRUE = 0b00000100_00000000_00000000;

    /**
     * @see #BOND_MANAGEMENT_FEATURES_FEATURE_EXTENSION_FALSE
     * @see #BOND_MANAGEMENT_FEATURES_FEATURE_EXTENSION_TRUE
     */
    public static final int BOND_MANAGEMENT_FEATURES_FEATURE_EXTENSION_MASK = 0b10000000_00000000_00000000;

    /**
     * 0: Feature Extension False
     */
    public static final int BOND_MANAGEMENT_FEATURES_FEATURE_EXTENSION_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Feature Extension True
     */
    public static final int BOND_MANAGEMENT_FEATURES_FEATURE_EXTENSION_TRUE = 0b10000000_00000000_00000000;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BondManagementFeatures> CREATOR = new ByteArrayCreater<BondManagementFeatures>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BondManagementFeatures createFromParcel(@NonNull Parcel in) {
            return new BondManagementFeatures(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BondManagementFeatures[] newArray(int size) {
            return new BondManagementFeatures[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BondManagementFeatures createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BOND_MANAGEMENT_FEATURES_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BondManagementFeatures(bluetoothGattCharacteristic);
        }

    };

    /**
     * Bond Management Features
     */
    private final byte[] mBondManagementFeatures;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA5
     */
    public BondManagementFeatures(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mBondManagementFeatures = Arrays.copyOfRange(values, 0, 3);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BondManagementFeatures(@NonNull Parcel in) {
        mBondManagementFeatures = in.createByteArray();
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
        dest.writeByteArray(mBondManagementFeatures);
    }

    /**
     * @return Bond Management Features
     */
    public byte[] getBondManagementFeatures() {
        return mBondManagementFeatures;
    }

    /**
     * @return {@code true}:Delete Bond of current connection (BR/EDR and LE) not supported, {@code false}:Delete Bond of current connection (BR/EDR and LE) supported
     */
    public boolean isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrLeNotSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Delete Bond of current connection (BR/EDR and LE) supported, {@code false}:Delete Bond of current connection (BR/EDR and LE) not supported
     */
    public boolean isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrLeSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Authorization Code not required for Delete Bond of current connection (BR/EDR and LE), {@code false}:Authorization Code required for Delete Bond of current connection (BR/EDR and LE)
     */
    public boolean isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrLeAuthorizationCodeNotRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_FALSE);
    }

    /**
     * @return {@code true}:Authorization Code required for Delete Bond of current connection (BR/EDR and LE), {@code false}:Authorization Code not required for Delete Bond of current connection (BR/EDR and LE)
     */
    public boolean isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrLeAuthorizationCodeRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE);
    }

    /**
     * @return {@code true}:Delete bond of current connection (BR/EDR transport only) not supported, {@code false}:Delete bond of current connection (BR/EDR transport only) supported
     */
    public boolean isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrNotSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Delete bond of current connection (BR/EDR transport only) supported, {@code false}:Delete bond of current connection (BR/EDR transport only) not supported
     */
    public boolean isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Authorization Code not required for Delete bond of current connection (BR/EDR transport only), {@code false}:Authorization Code required for Delete bond of current connection (BR/EDR transport only)
     */
    public boolean isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrAuthorizationCodeNotRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_AUTHORIZATION_CODE_REQUIRED_FALSE);
    }

    /**
     * @return {@code true}:Authorization Code required for Delete bond of current connection (BR/EDR transport only), {@code false}:Authorization Code not required for Delete bond of current connection (BR/EDR transport only)
     */
    public boolean isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrAuthorizationCodeRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE);
    }

    /**
     * @return {@code true}:Delete bond of current connection (LE transport only) not supported, {@code false}:Delete bond of current connection (LE transport only) supported
     */
    public boolean isBondManagementFeaturesDeleteBondOfCurrentConnectionLeNotSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Delete bond of current connection (LE transport only) supported, {@code false}:Delete bond of current connection (LE transport only) not supported
     */
    public boolean isBondManagementFeaturesDeleteBondOfCurrentConnectionLeSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Authorization Code not required for Delete bond of current connection (LE transport only), {@code false}:Authorization Code required for Delete bond of current connection (LE transport only)
     */
    public boolean isBondManagementFeaturesDeleteBondOfCurrentConnectionLeAuthorizationCodeNotRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_AUTHORIZATION_CODE_REQUIRED_FALSE);
    }

    /**
     * @return {@code true}:Authorization Code required for Delete bond of current connection (LE transport only), {@code false}:Authorization Code not required for Delete bond of current connection (LE transport only)
     */
    public boolean isBondManagementFeaturesDeleteBondOfCurrentConnectionLeAuthorizationCodeRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_AUTHORIZATION_CODE_REQUIRED_TRUE);
    }

    /**
     * @return {@code true}:Remove all bonds on server (BR/EDR and LE) not supported, {@code false}:Remove all bonds on server (BR/EDR and LE) supported
     */
    public boolean isBondManagementFeaturesRemoveAllBondsOnServerBrEdrLeNotSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Remove all bonds on server (BR/EDR and LE) supported, {@code false}:Remove all bonds on server (BR/EDR and LE) not supported
     */
    public boolean isBondManagementFeaturesRemoveAllBondsOnServerBrEdrLeSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Authorization Code not required for Remove all bonds on server (BR/EDR and LE), {@code false}:Authorization Code required for Remove all bonds on server (BR/EDR and LE)
     */
    public boolean isBondManagementFeaturesRemoveAllBondsOnServerBrEdrLeAuthorizationCodeNotRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_FALSE);
    }

    /**
     * @return {@code true}:Authorization Code required for Remove all bonds on server (BR/EDR and LE), {@code false}:Authorization Code not required for Remove all bonds on server (BR/EDR and LE)
     */
    public boolean isBondManagementFeaturesRemoveAllBondsOnServerBrEdrLeAuthorizationCodeRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE);
    }

    /**
     * @return {@code true}:Remove all bonds on server (BR/EDR transport only) not supported, {@code false}:Remove all bonds on server (BR/EDR transport only) supported
     */
    public boolean isBondManagementFeaturesRemoveAllBondsOnServerBrEdrNotSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Remove all bonds on server (BR/EDR transport only) supported, {@code false}:Remove all bonds on server (BR/EDR transport only) not supported
     */
    public boolean isBondManagementFeaturesRemoveAllBondsOnServerBrEdrSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Authorization Code not required for Remove all bonds on server (BR/EDR transport only), {@code false}:Authorization Code required for Remove all bonds on server (BR/EDR transport only)
     */
    public boolean isBondManagementFeaturesRemoveAllBondsOnServerBrEdrAuthorizationCodeNotRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_FALSE);
    }

    /**
     * @return {@code true}:Authorization Code required for Remove all bonds on server (BR/EDR transport only), {@code false}:Authorization Code not required for Remove all bonds on server (BR/EDR transport only)
     */
    public boolean isBondManagementFeaturesRemoveAllBondsOnServerBrEdrAuthorizationCodeRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE);
    }

    /**
     * @return {@code true}:Remove all bonds on server (LE transport only) not supported, {@code false}:Remove all bonds on server (LE transport only) supported
     */
    public boolean isBondManagementFeaturesRemoveAllBondsOnServerLeNotSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Remove all bonds on server (LE transport only)) supported, {@code false}:Remove all bonds on server (LE transport only)) not supported
     */
    public boolean isBondManagementFeaturesRemoveAllBondsOnServerLeSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Authorization Code not required for Remove all bonds on server (LE transport only), {@code false}:Authorization Code required for Remove all bonds on server (LE transport only)
     */
    public boolean isBondManagementFeaturesRemoveAllBondsOnServerLeAuthorizationCodeNotRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_FALSE);
    }

    /**
     * @return {@code true}:Authorization Code required for Remove all bonds on server (LE transport only), {@code false}:Authorization Code not required for Remove all bonds on server (LE transport only)
     */
    public boolean isBondManagementFeaturesRemoveAllBondsOnServerLeAuthorizationCodeRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_TRUE);
    }

    /**
     * @return {@code true}:Remove all but the active bond on server (BR/EDR and LE) not supported, {@code false}:Remove all but the active bond on server (BR/EDR and LE) supported
     */
    public boolean isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrLeNotSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Remove all but the active bond on server (BR/EDR and LE) supported, {@code false}:Remove all but the active bond on server (BR/EDR and LE) not supported
     */
    public boolean isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrLeSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Authorization Code not required for Remove all but the active bond on server (BR/EDR and LE), {@code false}:Authorization Code required for Remove all but the active bond on server (BR/EDR and LE)
     */
    public boolean isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrLeAuthorizationCodeNotRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_FALSE);
    }

    /**
     * @return {@code true}:Authorization Code required for Remove all but the active bond on server (BR/EDR and LE), {@code false}:Authorization Code not required for Remove all but the active bond on server (BR/EDR and LE)
     */
    public boolean isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrLeAuthorizationCodeRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE);
    }

    /**
     * @return {@code true}:Remove all but the active bond on server (BR/EDR transport only) not supported, {@code false}:Remove all but the active bond on server (BR/EDR transport only) supported
     */
    public boolean isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrNotSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Remove all but the active bond on server (BR/EDR transport only) supported, {@code false}:Remove all but the active bond on server (BR/EDR transport only) not supported
     */
    public boolean isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Authorization Code not required for Remove all but the active bond on server (BR/EDR transport only), {@code false}:Authorization Code required for Remove all but the active bond on server (BR/EDR transport only)
     */
    public boolean isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrAuthorizationCodeNotRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_FALSE);
    }

    /**
     * @return {@code true}:Authorization Code required for Remove all but the active bond on server (BR/EDR transport only), {@code false}:Authorization Code not required for Remove all but the active bond on server (BR/EDR transport only)
     */
    public boolean isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrAuthorizationCodeRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE);
    }

    /**
     * @return {@code true}:Remove all but the active bond on server (LE transport only) not supported, {@code false}:Remove all but the active bond on server (LE transport only) supported
     */
    public boolean isBondManagementFeaturesRemoveAllButTheActiveBondOnServerLeNotSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Remove all but the active bond on server (LE transport only) supported, {@code false}:Remove all but the active bond on server (LE transport only)not supported
     */
    public boolean isBondManagementFeaturesRemoveAllButTheActiveBondOnServerLeSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Authorization Code not required for Remove all but the active bond on server (LE transport only), {@code false}:Authorization Code required for Remove all but the active bond on server (LE transport only)
     */
    public boolean isBondManagementFeaturesRemoveAllButTheActiveBondOnServerLeAuthorizationCodeNotRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_FALSE);
    }

    /**
     * @return {@code true}:Authorization Code required for Remove all but the active bond on server (LE transport only), {@code false}:Authorization Code not required for Remove all but the active bond on server (LE transport only)
     */
    public boolean isBondManagementFeaturesRemoveAllButTheActiveBondOnServerLeAuthorizationCodeRequired() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_MASK
                , BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_TRUE);
    }

    /**
     * @return {@code true}:Identify yourself not supported, {@code false}:Identify yourself supported
     */
    public boolean isBondManagementFeaturesIdentifyYourselfNotSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_IDENTIFY_YOURSELF_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_IDENTIFY_YOURSELF_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Identify yourself supported, {@code false}:Identify yourself not supported
     */
    public boolean isBondManagementFeaturesIdentifyYourselfSupported() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_IDENTIFY_YOURSELF_SUPPORTED_MASK
                , BOND_MANAGEMENT_FEATURES_IDENTIFY_YOURSELF_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Feature Extension False, {@code false}:Feature Extension True
     */
    public boolean isBondManagementFeaturesFeatureExtensionFalse() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_FEATURE_EXTENSION_MASK
                , BOND_MANAGEMENT_FEATURES_FEATURE_EXTENSION_FALSE);
    }

    /**
     * @return {@code true}:Feature Extension True, {@code false}::Feature Extension False
     */
    public boolean isBondManagementFeaturesFeatureExtensionTrue() {
        return isBondManagementFeaturesMatched(BOND_MANAGEMENT_FEATURES_FEATURE_EXTENSION_MASK
                , BOND_MANAGEMENT_FEATURES_FEATURE_EXTENSION_TRUE);
    }

    /**
     * @return operand for {@link BondManagementControlPoint}
     */
    public String createOperand() {
        StringBuilder sb = new StringBuilder();
        if (isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrLeSupported() && isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrLeAuthorizationCodeRequired()) {
            sb.append('1');
        }
        if (isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrSupported() && isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrAuthorizationCodeRequired()) {
            sb.append('2');
        }
        if (isBondManagementFeaturesDeleteBondOfCurrentConnectionLeSupported() && isBondManagementFeaturesDeleteBondOfCurrentConnectionLeAuthorizationCodeRequired()) {
            sb.append('3');
        }
        if (isBondManagementFeaturesRemoveAllBondsOnServerBrEdrLeSupported() && isBondManagementFeaturesRemoveAllBondsOnServerBrEdrLeAuthorizationCodeRequired()) {
            sb.append('4');
        }
        if (isBondManagementFeaturesRemoveAllBondsOnServerBrEdrSupported() && isBondManagementFeaturesRemoveAllBondsOnServerBrEdrAuthorizationCodeRequired()) {
            sb.append('5');
        }
        if (isBondManagementFeaturesRemoveAllBondsOnServerLeSupported() && isBondManagementFeaturesRemoveAllBondsOnServerLeAuthorizationCodeRequired()) {
            sb.append('6');
        }
        if (isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrLeSupported() && isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrLeAuthorizationCodeRequired()) {
            sb.append('7');
        }
        if (isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrSupported() && isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrAuthorizationCodeRequired()) {
            sb.append('8');
        }
        if (isBondManagementFeaturesRemoveAllButTheActiveBondOnServerLeSupported() && isBondManagementFeaturesRemoveAllButTheActiveBondOnServerLeAuthorizationCodeRequired()) {
            sb.append('9');
        }
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[3];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mBondManagementFeatures);
        return data;
    }

    /**
     * check Bond Management Features
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_SUPPORTED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_SUPPORTED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_SUPPORTED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_SUPPORTED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_AUTHORIZATION_CODE_REQUIRED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_SUPPORTED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_SUPPORTED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_AUTHORIZATION_CODE_REQUIRED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_DELETE_BOND_OF_CURRENT_CONNECTION_LE_AUTHORIZATION_CODE_REQUIRED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_SUPPORTED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_SUPPORTED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_SUPPORTED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_SUPPORTED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_SUPPORTED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_SUPPORTED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BONDS_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_SUPPORTED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_SUPPORTED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_LE_AUTHORIZATION_CODE_REQUIRED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_SUPPORTED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_SUPPORTED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_BR_EDR_AUTHORIZATION_CODE_REQUIRED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_SUPPORTED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_SUPPORTED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_REMOVE_ALL_BUT_THE_ACTIVE_BOND_ON_SERVER_LE_AUTHORIZATION_CODE_REQUIRED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_IDENTIFY_YOURSELF_SUPPORTED_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_IDENTIFY_YOURSELF_SUPPORTED_TRUE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_FEATURE_EXTENSION_FALSE}
     *               , {@link #BOND_MANAGEMENT_FEATURES_FEATURE_EXTENSION_TRUE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isBondManagementFeaturesMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt24(mBondManagementFeatures, 0)) == expect;
    }

}
