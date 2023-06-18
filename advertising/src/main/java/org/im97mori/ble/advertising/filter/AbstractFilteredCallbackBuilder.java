package org.im97mori.ble.advertising.filter;

import android.os.ParcelUuid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.AdvertisingInterval;
import org.im97mori.ble.advertising.AdvertisingIntervalLong;
import org.im97mori.ble.advertising.Appearance;
import org.im97mori.ble.advertising.BigInfo;
import org.im97mori.ble.advertising.ChannelMapUpdateIndication;
import org.im97mori.ble.advertising.CompleteListOf128BitServiceUUIDs;
import org.im97mori.ble.advertising.CompleteListOf16BitServiceUUIDs;
import org.im97mori.ble.advertising.CompleteListOf32BitServiceUUIDs;
import org.im97mori.ble.advertising.CompleteLocalName;
import org.im97mori.ble.advertising.EncryptedData;
import org.im97mori.ble.advertising.Flags;
import org.im97mori.ble.advertising.IncompleteListOf128BitServiceUUIDs;
import org.im97mori.ble.advertising.IncompleteListOf16BitServiceUUIDs;
import org.im97mori.ble.advertising.IncompleteListOf32BitServiceUUIDs;
import org.im97mori.ble.advertising.IndoorPositioning;
import org.im97mori.ble.advertising.LeSupportedFeatures;
import org.im97mori.ble.advertising.ListOf128BitServiceSolicitationUUIDs;
import org.im97mori.ble.advertising.ListOf16BitServiceSolicitationUUIDs;
import org.im97mori.ble.advertising.ListOf32BitServiceSolicitationUUIDs;
import org.im97mori.ble.advertising.ManufacturerSpecificData;
import org.im97mori.ble.advertising.PeriodicAdvertisingResponseTimingInformation;
import org.im97mori.ble.advertising.PeripheralConnectionIntervalRange;
import org.im97mori.ble.advertising.PublicTargetAddress;
import org.im97mori.ble.advertising.RandomTargetAddress;
import org.im97mori.ble.advertising.ServiceData128BitUUID;
import org.im97mori.ble.advertising.ServiceData16BitUUID;
import org.im97mori.ble.advertising.ServiceData32BitUUID;
import org.im97mori.ble.advertising.ShortenedLocalName;
import org.im97mori.ble.advertising.TransportDiscoveryData;
import org.im97mori.ble.advertising.TxPowerLevel;
import org.im97mori.ble.advertising.UniformResourceIdentifier;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Builder for {@link FilteredLeScanCallback} or {@link FilteredLeScanCallback} with filter function
 *
 * @param <T> instance of {@link FilteredLeScanCallback} or {@link FilteredLeScanCallback}
 */
@SuppressWarnings({"WeakerAccess"})
public abstract class AbstractFilteredCallbackBuilder<T> {

    /**
     * filter list
     */
    protected final List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> mFilterList = new LinkedList<>();

    /**
     * {@link AdvertisingDataParser} instance for parse
     */
    protected AdvertisingDataParser mAdvertisingDataParser;

    /**
     * @param filter filter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addFilter(@NonNull AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter) {
        mFilterList.add(filter);
        return this;
    }

    /**
     * @see #addFilters(List)
     */
    @SafeVarargs
    @NonNull
    public final AbstractFilteredCallbackBuilder<T> addFilters(@NonNull AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>... filters) {
        return addFilters(Arrays.asList(filters));
    }

    /**
     * @param filterList filter list
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addFilters(@NonNull List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> filterList) {
        mFilterList.addAll(filterList);
        return this;
    }

    /**
     * clear current filter list
     *
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> clearFilter() {
        mFilterList.clear();
        return this;
    }

    /**
     * <p>
     * set original parser
     * if not set, {@link org.im97mori.ble.advertising.AdvertisingDataParser.Builder} with {@code true} will use
     * </p>
     *
     * @param parser {@link org.im97mori.ble.advertising.AdvertisingDataParser} instance for parse
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> setAdvertisingDataParser(@Nullable AdvertisingDataParser parser) {
        mAdvertisingDataParser = parser;
        return this;
    }

    /**
     * add Advertising Interval filter
     *
     * @param data Advertising Interval data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addAdvertisingIntervalFilter(@NonNull byte[] data) {
        return addAdvertisingIntervalFilter(data, 0, data[0]);
    }

    /**
     * add Advertising Interval filter
     *
     * @param data   {@link AdvertisingInterval#AdvertisingInterval(byte[], int, int)} 1st parameter
     * @param offset {@link AdvertisingInterval#AdvertisingInterval(byte[], int, int)} 2nd parameter
     * @param length {@link AdvertisingInterval#AdvertisingInterval(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addAdvertisingIntervalFilter(@NonNull byte[] data, int offset, int length) {
        return addAdvertisingIntervalFilter(new AdvertisingInterval(data, offset, length));
    }

    /**
     * add Advertising Interval filter
     *
     * @param expect {@link AdvertisingInterval} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addAdvertisingIntervalFilter(@NonNull AdvertisingInterval expect) {
        mFilterList.add(new AdvertisingIntervalFilter(expect));
        return this;
    }

    /**
     * add Advertising Interval - long filter
     *
     * @param data Advertising Interval data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addAdvertisingIntervalLongFilter(@NonNull byte[] data) {
        return addAdvertisingIntervalLongFilter(data, 0, data[0]);
    }

    /**
     * add Advertising Interval - long filter
     *
     * @param data   {@link AdvertisingIntervalLong#AdvertisingIntervalLong(byte[], int, int)} 1st parameter
     * @param offset {@link AdvertisingIntervalLong#AdvertisingIntervalLong(byte[], int, int)} 2nd parameter
     * @param length {@link AdvertisingIntervalLong#AdvertisingIntervalLong(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addAdvertisingIntervalLongFilter(@NonNull byte[] data, int offset, int length) {
        return addAdvertisingIntervalLongFilter(new AdvertisingIntervalLong(data, offset, length));
    }

    /**
     * add Advertising Interval - long filter
     *
     * @param expect {@link AdvertisingIntervalLong} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addAdvertisingIntervalLongFilter(@NonNull AdvertisingIntervalLong expect) {
        mFilterList.add(new AdvertisingIntervalLongFilter(expect));
        return this;
    }

    /**
     * add Appearance filter
     *
     * @param data Appearance data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addAppearanceFilter(@NonNull byte[] data) {
        return addAppearanceFilter(data, 0, data[0]);
    }

    /**
     * add Appearance filter
     *
     * @param data   {@link Appearance#Appearance(byte[], int, int)} 1st parameter
     * @param offset {@link Appearance#Appearance(byte[], int, int)} 2nd parameter
     * @param length {@link Appearance#Appearance(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addAppearanceFilter(@NonNull byte[] data, int offset, int length) {
        return addAppearanceFilter(new Appearance(data, offset, length));
    }

    /**
     * add Appearance filter
     *
     * @param expect {@link BigInfo} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addBigInfoFilter(@NonNull BigInfo expect) {
        mFilterList.add(new BigInfoFilter(expect));
        return this;
    }

    /**
     * add Appearance filter
     *
     * @param data Appearance data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addBigInfoFilter(@NonNull byte[] data) {
        return addBigInfoFilter(data, 0, data[0]);
    }

    /**
     * add Appearance filter
     *
     * @param data   {@link Appearance#Appearance(byte[], int, int)} 1st parameter
     * @param offset {@link Appearance#Appearance(byte[], int, int)} 2nd parameter
     * @param length {@link Appearance#Appearance(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addBigInfoFilter(@NonNull byte[] data, int offset, int length) {
        return addBigInfoFilter(new BigInfo(data, offset, length));
    }

    /**
     * add Appearance filter
     *
     * @param expect {@link Appearance} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addAppearanceFilter(@NonNull Appearance expect) {
        mFilterList.add(new AppearanceFilter(expect));
        return this;
    }

    /**
     * add Channel Map Update Indication filter
     *
     * @param data Channel Map Update Indication data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addChannelMapUpdateIndicationFilter(@NonNull byte[] data) {
        return addChannelMapUpdateIndicationFilter(data, 0, data.length);
    }

    /**
     * add Channel Map Update Indication filter
     *
     * @param data   {@link ChannelMapUpdateIndication#ChannelMapUpdateIndication(byte[], int, int)} 1st parameter
     * @param offset {@link ChannelMapUpdateIndication#ChannelMapUpdateIndication(byte[], int, int)} 2nd parameter
     * @param length {@link ChannelMapUpdateIndication#ChannelMapUpdateIndication(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addChannelMapUpdateIndicationFilter(@NonNull byte[] data, int offset, int length) {
        return addChannelMapUpdateIndicationFilter(new ChannelMapUpdateIndication(data, offset, length));
    }

    /**
     * add Channel Map Update Indication filter
     *
     * @param expect {@link ChannelMapUpdateIndication} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addChannelMapUpdateIndicationFilter(@NonNull ChannelMapUpdateIndication expect) {
        mFilterList.add(new ChannelMapUpdateIndicationFilter(expect));
        return this;
    }

    /**
     * add Complete List of 16-bit Service Class UUIDs filter
     *
     * @param data Complete List of 16-bit Service Class UUIDs data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf16BitServiceUUIDsFilter(@NonNull byte[] data) {
        return addCompleteListOf16BitServiceUUIDsFilter(data, 0, data[0]);
    }

    /**
     * add Channel Map Update Indication filter
     *
     * @param data   {@link ChannelMapUpdateIndication#ChannelMapUpdateIndication(byte[], int, int)} 1st parameter
     * @param offset {@link ChannelMapUpdateIndication#ChannelMapUpdateIndication(byte[], int, int)} 2nd parameter
     * @param length {@link ChannelMapUpdateIndication#ChannelMapUpdateIndication(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf16BitServiceUUIDsFilter(@NonNull byte[] data, int offset, int length) {
        return addCompleteListOf16BitServiceUUIDsFilter(new CompleteListOf16BitServiceUUIDs(data, offset, length));
    }

    /**
     * add Complete List of 16-bit Service Class UUIDs filter
     *
     * @param expect {@link CompleteListOf16BitServiceUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf16BitServiceUUIDsFilter(@NonNull CompleteListOf16BitServiceUUIDs expect) {
        mFilterList.add(new CompleteListOf16BitServiceUUIDsFilter(expect));
        return this;
    }

    /**
     * add Complete List of 16-bit Service Class UUIDs filter
     *
     * @param expectList List of {@link CompleteListOf16BitServiceUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf16BitServiceUUIDsFilter(@NonNull List<? extends CompleteListOf16BitServiceUUIDs> expectList) {
        mFilterList.add(new CompleteListOf16BitServiceUUIDsFilter(expectList));
        return this;
    }

    /**
     * add Complete List of 32-bit Service Class UUIDs filter
     *
     * @param data Complete List of 32-bit Service Class UUIDs data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf32BitServiceUUIDsFilter(@NonNull byte[] data) {
        return addCompleteListOf32BitServiceUUIDsFilter(data, 0, data[0]);
    }

    /**
     * add Complete List of 32-bit Service Class UUIDs filter
     *
     * @param data   {@link CompleteListOf32BitServiceUUIDs#CompleteListOf32BitServiceUUIDs(byte[], int, int)} 1st parameter
     * @param offset {@link CompleteListOf32BitServiceUUIDs#CompleteListOf32BitServiceUUIDs(byte[], int, int)} 2nd parameter
     * @param length {@link CompleteListOf32BitServiceUUIDs#CompleteListOf32BitServiceUUIDs(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf32BitServiceUUIDsFilter(@NonNull byte[] data, int offset, int length) {
        return addCompleteListOf32BitServiceUUIDsFilter(new CompleteListOf32BitServiceUUIDs(data, offset, length));
    }

    /**
     * add Complete List of 32-bit Service Class UUIDs filter
     *
     * @param expect {@link CompleteListOf32BitServiceUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf32BitServiceUUIDsFilter(@NonNull CompleteListOf32BitServiceUUIDs expect) {
        mFilterList.add(new CompleteListOf32BitServiceUUIDsFilter(expect));
        return this;
    }

    /**
     * add Complete List of 32-bit Service Class UUIDs filter
     *
     * @param expectList List of {@link CompleteListOf32BitServiceUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf32BitServiceUUIDsFilter(@NonNull List<? extends CompleteListOf32BitServiceUUIDs> expectList) {
        mFilterList.add(new CompleteListOf32BitServiceUUIDsFilter(expectList));
        return this;
    }

    /**
     * add Complete List of 128-bit Service Class UUIDs filter
     *
     * @param data Complete List of 128-bit Service Class UUIDs data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf128BitServiceUUIDsFilter(@NonNull byte[] data) {
        return addCompleteListOf128BitServiceUUIDsFilter(data, 0, data[0]);
    }

    /**
     * add Complete List of 128-bit Service Class UUIDs filter
     *
     * @param data   {@link CompleteListOf128BitServiceUUIDs#CompleteListOf128BitServiceUUIDs(byte[], int, int)} 1st parameter
     * @param offset {@link CompleteListOf128BitServiceUUIDs#CompleteListOf128BitServiceUUIDs(byte[], int, int)} 2nd parameter
     * @param length {@link CompleteListOf128BitServiceUUIDs#CompleteListOf128BitServiceUUIDs(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf128BitServiceUUIDsFilter(@NonNull byte[] data, int offset, int length) {
        return addCompleteListOf128BitServiceUUIDsFilter(new CompleteListOf128BitServiceUUIDs(data, offset, length));
    }

    /**
     * add Complete List of 128-bit Service Class UUIDs filter
     *
     * @param expect {@link CompleteListOf128BitServiceUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf128BitServiceUUIDsFilter(@NonNull CompleteListOf128BitServiceUUIDs expect) {
        mFilterList.add(new CompleteListOf128BitServiceUUIDsFilter(expect));
        return this;
    }

    /**
     * add Complete List of 128-bit Service Class UUIDs filter
     *
     * @param expectList List of {@link CompleteListOf128BitServiceUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf128BitServiceUUIDsFilter(@NonNull List<? extends CompleteListOf128BitServiceUUIDs> expectList) {
        mFilterList.add(new CompleteListOf128BitServiceUUIDsFilter(expectList));
        return this;
    }

    /**
     * add Complete Local Name filter
     *
     * @param data Complete Local Name UUIDs data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteLocalNameFilter(@NonNull byte[] data) {
        return addCompleteLocalNameFilter(data, 0, data[0]);
    }

    /**
     * add Complete Local Name filter
     *
     * @param data   {@link CompleteLocalName#CompleteLocalName(byte[], int, int)} 1st parameter
     * @param offset {@link CompleteLocalName#CompleteLocalName(byte[], int, int)} 2nd parameter
     * @param length {@link CompleteLocalName#CompleteLocalName(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteLocalNameFilter(@NonNull byte[] data, int offset, int length) {
        return addCompleteLocalNameFilter(new CompleteLocalName(data, offset, length));
    }

    /**
     * add Complete Local Name filter
     *
     * @param expect {@link CompleteLocalName} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteLocalNameFilter(@NonNull CompleteLocalName expect) {
        mFilterList.add(new CompleteLocalNameFilter(expect));
        return this;
    }

    /**
     * add Flags filter
     *
     * @param data Flags data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addFlagsFilter(@NonNull byte[] data) {
        return addFlagsFilter(data, 0, data[0]);
    }

    /**
     * add Flags filter
     *
     * @param data   {@link Flags#Flags(byte[], int, int)} 1st parameter
     * @param offset {@link Flags#Flags(byte[], int, int)} 2nd parameter
     * @param length {@link Flags#Flags(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addFlagsFilter(@NonNull byte[] data, int offset, int length) {
        return addFlagsFilter(new Flags(data, offset, length));
    }

    /**
     * add Flags filter
     *
     * @param expect {@link Flags} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addFlagsFilter(@NonNull Flags expect) {
        mFilterList.add(new FlagsFilter(expect));
        return this;
    }

    /**
     * add Incomplete List of 16-bit Service Class UUIDs filter
     *
     * @param data Incomplete List of 16-bit Service Class UUIDs data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf16BitServiceUUIDsFilter(@NonNull byte[] data) {
        return addIncompleteListOf16BitServiceUUIDsFilter(data, 0, data[0]);
    }

    /**
     * add Incomplete List of 16-bit Service Class UUIDs filter
     *
     * @param data   {@link IncompleteListOf16BitServiceUUIDs#IncompleteListOf16BitServiceUUIDs(byte[], int, int)} 1st parameter
     * @param offset {@link IncompleteListOf16BitServiceUUIDs#IncompleteListOf16BitServiceUUIDs(byte[], int, int)} 2nd parameter
     * @param length {@link IncompleteListOf16BitServiceUUIDs#IncompleteListOf16BitServiceUUIDs(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf16BitServiceUUIDsFilter(@NonNull byte[] data, int offset, int length) {
        return addIncompleteListOf16BitServiceUUIDsFilter(new IncompleteListOf16BitServiceUUIDs(data, offset, length));
    }

    /**
     * add Incomplete List of 16-bit Service Class UUIDs filter
     *
     * @param expect {@link IncompleteListOf16BitServiceUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf16BitServiceUUIDsFilter(@NonNull IncompleteListOf16BitServiceUUIDs expect) {
        mFilterList.add(new IncompleteListOf16BitServiceUUIDsFilter(expect));
        return this;
    }

    /**
     * add Incomplete List of 16-bit Service Class UUIDs filter
     *
     * @param expectList List of {@link IncompleteListOf16BitServiceUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf16BitServiceUUIDsFilter(@NonNull List<? extends IncompleteListOf16BitServiceUUIDs> expectList) {
        mFilterList.add(new IncompleteListOf16BitServiceUUIDsFilter(expectList));
        return this;
    }

    /**
     * add Incomplete List of 32-bit Service Class UUIDs filter
     *
     * @param data Incomplete List of 32-bit Service Class UUIDs data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf32BitServiceUUIDsFilter(@NonNull byte[] data) {
        return addIncompleteListOf32BitServiceUUIDsFilter(data, 0, data[0]);
    }

    /**
     * add Incomplete List of 32-bit Service Class UUIDs filter
     *
     * @param data   {@link IncompleteListOf32BitServiceUUIDs#IncompleteListOf32BitServiceUUIDs(byte[], int, int)} 1st parameter
     * @param offset {@link IncompleteListOf32BitServiceUUIDs#IncompleteListOf32BitServiceUUIDs(byte[], int, int)} 2nd parameter
     * @param length {@link IncompleteListOf32BitServiceUUIDs#IncompleteListOf32BitServiceUUIDs(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf32BitServiceUUIDsFilter(@NonNull byte[] data, int offset, int length) {
        return addIncompleteListOf32BitServiceUUIDsFilter(new IncompleteListOf32BitServiceUUIDs(data, offset, length));
    }

    /**
     * add Incomplete List of 32-bit Service Class UUIDs filter
     *
     * @param expect {@link IncompleteListOf32BitServiceUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf32BitServiceUUIDsFilter(@NonNull IncompleteListOf32BitServiceUUIDs expect) {
        mFilterList.add(new IncompleteListOf32BitServiceUUIDsFilter(expect));
        return this;
    }

    /**
     * add Incomplete List of 32-bit Service Class UUIDs filter
     *
     * @param expectList List of {@link IncompleteListOf32BitServiceUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf32BitServiceUUIDsFilter(@NonNull List<? extends IncompleteListOf32BitServiceUUIDs> expectList) {
        mFilterList.add(new IncompleteListOf32BitServiceUUIDsFilter(expectList));
        return this;
    }

    /**
     * add Incomplete List of 128-bit Service Class UUIDs filter
     *
     * @param data Incomplete List of 128-bit Service Class UUIDs data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf128BitServiceUUIDsFilter(@NonNull byte[] data) {
        return addIncompleteListOf128BitServiceUUIDsFilter(data, 0, data[0]);
    }

    /**
     * add Incomplete List of 128-bit Service Class UUIDs filter
     *
     * @param data   {@link IncompleteListOf128BitServiceUUIDs#IncompleteListOf128BitServiceUUIDs(byte[], int, int)} 1st parameter
     * @param offset {@link IncompleteListOf128BitServiceUUIDs#IncompleteListOf128BitServiceUUIDs(byte[], int, int)} 2nd parameter
     * @param length {@link IncompleteListOf128BitServiceUUIDs#IncompleteListOf128BitServiceUUIDs(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf128BitServiceUUIDsFilter(@NonNull byte[] data, int offset, int length) {
        return addIncompleteListOf128BitServiceUUIDsFilter(new IncompleteListOf128BitServiceUUIDs(data, offset, length));
    }

    /**
     * add Incomplete List of 128-bit Service Class UUIDs filter
     *
     * @param expect {@link IncompleteListOf128BitServiceUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf128BitServiceUUIDsFilter(@NonNull IncompleteListOf128BitServiceUUIDs expect) {
        mFilterList.add(new IncompleteListOf128BitServiceUUIDsFilter(expect));
        return this;
    }

    /**
     * add Incomplete List of 128-bit Service Class UUIDs filter
     *
     * @param expectList {@link IncompleteListOf128BitServiceUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf128BitServiceUUIDsFilter(@NonNull List<? extends IncompleteListOf128BitServiceUUIDs> expectList) {
        mFilterList.add(new IncompleteListOf128BitServiceUUIDsFilter(expectList));
        return this;
    }

    /**
     * add Indoor Positioning filter
     *
     * @param data Indoor Positioning data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIndoorPositioningFilter(@NonNull byte[] data) {
        return addIndoorPositioningFilter(data, 0, data[0]);
    }

    /**
     * add Indoor Positioning filter
     *
     * @param data   {@link IndoorPositioning#IndoorPositioning(byte[], int, int)} 1st parameter
     * @param offset {@link IndoorPositioning#IndoorPositioning(byte[], int, int)} 2nd parameter
     * @param length {@link IndoorPositioning#IndoorPositioning(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIndoorPositioningFilter(@NonNull byte[] data, int offset, int length) {
        return addIndoorPositioningFilter(new IndoorPositioning(data, offset, length));
    }

    /**
     * add Indoor Positioning filter
     *
     * @param expect {@link IndoorPositioning} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIndoorPositioningFilter(@NonNull IndoorPositioning expect) {
        mFilterList.add(new IndoorPositioningFilter(expect));
        return this;
    }

    /**
     * add LE Supported Features filter
     *
     * @param data LE Supported Features data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addLeSupportedFeaturesFilter(@NonNull byte[] data) {
        return addLeSupportedFeaturesFilter(data, 0, data[0]);
    }

    /**
     * add LE Supported Features filter
     *
     * @param data   {@link LeSupportedFeatures#LeSupportedFeatures(byte[], int, int)} 1st parameter
     * @param offset {@link LeSupportedFeatures#LeSupportedFeatures(byte[], int, int)} 2nd parameter
     * @param length {@link LeSupportedFeatures#LeSupportedFeatures(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addLeSupportedFeaturesFilter(@NonNull byte[] data, int offset, int length) {
        return addLeSupportedFeaturesFilter(new LeSupportedFeatures(data, offset, length));
    }

    /**
     * add LE Supported Features filter
     *
     * @param expect {@link LeSupportedFeatures} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addLeSupportedFeaturesFilter(@NonNull LeSupportedFeatures expect) {
        mFilterList.add(new LeSupportedFeaturesFilter(expect));
        return this;
    }

    /**
     * add List of 16-bit Service Solicitation UUIDs filter
     *
     * @param data List of 16-bit Service Solicitation UUIDs data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf16BitServiceSolicitationUUIDsFilter(@NonNull byte[] data) {
        return addListOf16BitServiceSolicitationUUIDsFilter(data, 0, data[0]);
    }

    /**
     * add Complete List of 16-bit Service Class UUIDs filter
     *
     * @param data   {@link ListOf16BitServiceSolicitationUUIDs#ListOf16BitServiceSolicitationUUIDs(byte[], int, int)} 1st parameter
     * @param offset {@link ListOf16BitServiceSolicitationUUIDs#ListOf16BitServiceSolicitationUUIDs(byte[], int, int)} 2nd parameter
     * @param length {@link ListOf16BitServiceSolicitationUUIDs#ListOf16BitServiceSolicitationUUIDs(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf16BitServiceSolicitationUUIDsFilter(@NonNull byte[] data, int offset, int length) {
        return addListOf16BitServiceSolicitationUUIDsFilter(new ListOf16BitServiceSolicitationUUIDs(data, offset, length));
    }

    /**
     * add List of 16-bit Service Solicitation UUIDs filter
     *
     * @param expect {@link ListOf16BitServiceSolicitationUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf16BitServiceSolicitationUUIDsFilter(@NonNull ListOf16BitServiceSolicitationUUIDs expect) {
        mFilterList.add(new ListOf16BitServiceSolicitationUUIDsFilter(expect));
        return this;
    }

    /**
     * add List of 16-bit Service Solicitation UUIDs filter
     *
     * @param expectList List of {@link ListOf16BitServiceSolicitationUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf16BitServiceSolicitationUUIDsFilter(@NonNull List<? extends ListOf16BitServiceSolicitationUUIDs> expectList) {
        mFilterList.add(new ListOf16BitServiceSolicitationUUIDsFilter(expectList));
        return this;
    }

    /**
     * add List of 32-bit Service Solicitation UUIDs filter
     *
     * @param data List of 32-bit Service Solicitation UUIDs data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf32BitServiceSolicitationUUIDsFilter(@NonNull byte[] data) {
        return addListOf32BitServiceSolicitationUUIDsFilter(data, 0, data[0]);
    }

    /**
     * add List of 32-bit Service Solicitation UUIDs filter
     *
     * @param data   {@link ListOf32BitServiceSolicitationUUIDs#ListOf32BitServiceSolicitationUUIDs(byte[], int, int)} 1st parameter
     * @param offset {@link ListOf32BitServiceSolicitationUUIDs#ListOf32BitServiceSolicitationUUIDs(byte[], int, int)} 2nd parameter
     * @param length {@link ListOf32BitServiceSolicitationUUIDs#ListOf32BitServiceSolicitationUUIDs(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf32BitServiceSolicitationUUIDsFilter(@NonNull byte[] data, int offset, int length) {
        return addListOf32BitServiceSolicitationUUIDsFilter(new ListOf32BitServiceSolicitationUUIDs(data, offset, length));
    }

    /**
     * add List of 32-bit Service Solicitation UUIDs filter
     *
     * @param expect {@link ListOf32BitServiceSolicitationUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf32BitServiceSolicitationUUIDsFilter(@NonNull ListOf32BitServiceSolicitationUUIDs expect) {
        mFilterList.add(new ListOf32BitServiceSolicitationUUIDsFilter(expect));
        return this;
    }

    /**
     * add List of 32-bit Service Solicitation UUIDs filter
     *
     * @param expectList List of {@link ListOf32BitServiceSolicitationUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf32BitServiceSolicitationUUIDsFilter(@NonNull List<? extends ListOf32BitServiceSolicitationUUIDs> expectList) {
        mFilterList.add(new ListOf32BitServiceSolicitationUUIDsFilter(expectList));
        return this;
    }

    /**
     * add List of 128-bit Service Solicitation UUIDs filter
     *
     * @param data List of 128-bit Service Solicitation UUIDs data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf128BitServiceSolicitationUUIDsFilter(@NonNull byte[] data) {
        return addListOf128BitServiceSolicitationUUIDsFilter(data, 0, data[0]);
    }

    /**
     * add List of 128-bit Service Solicitation UUIDs filter
     *
     * @param data   {@link ListOf128BitServiceSolicitationUUIDs#ListOf128BitServiceSolicitationUUIDs(byte[], int, int)} 1st parameter
     * @param offset {@link ListOf128BitServiceSolicitationUUIDs#ListOf128BitServiceSolicitationUUIDs(byte[], int, int)} 2nd parameter
     * @param length {@link ListOf128BitServiceSolicitationUUIDs#ListOf128BitServiceSolicitationUUIDs(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf128BitServiceSolicitationUUIDsFilter(@NonNull byte[] data, int offset, int length) {
        return addListOf128BitServiceSolicitationUUIDsFilter(new ListOf128BitServiceSolicitationUUIDs(data, offset, length));
    }

    /**
     * add List of 128-bit Service Solicitation UUIDs filter
     *
     * @param expect {@link ListOf128BitServiceSolicitationUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf128BitServiceSolicitationUUIDsFilter(@NonNull ListOf128BitServiceSolicitationUUIDs expect) {
        mFilterList.add(new ListOf128BitServiceSolicitationUUIDsFilter(expect));
        return this;
    }

    /**
     * add List of 128-bit Service Solicitation UUIDs filter
     *
     * @param expectList List of {@link ListOf128BitServiceSolicitationUUIDs} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf128BitServiceSolicitationUUIDsFilter(@NonNull List<? extends ListOf128BitServiceSolicitationUUIDs> expectList) {
        mFilterList.add(new ListOf128BitServiceSolicitationUUIDsFilter(expectList));
        return this;
    }

    /**
     * add Manufacturer Specific Data filter
     *
     * @param data    Manufacturer Specific Data data array
     * @param bitmask bitmask for filter
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     * @see android.bluetooth.le.ScanFilter.Builder#setManufacturerData(int, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addManufacturerSpecificDataFilter(@NonNull byte[] data, @Nullable byte[] bitmask) {
        return addManufacturerSpecificDataFilter(data, 0, data[0], bitmask);
    }

    /**
     * add Manufacturer Specific Data filter
     *
     * @param data    {@link ManufacturerSpecificData#ManufacturerSpecificData(byte[], int, int)} 1st parameter
     * @param offset  {@link ManufacturerSpecificData#ManufacturerSpecificData(byte[], int, int)} 2nd parameter
     * @param length  {@link ManufacturerSpecificData#ManufacturerSpecificData(byte[], int, int)} 3rd parameter
     * @param bitmask bitmask for filter
     * @return myself
     * @see android.bluetooth.le.ScanFilter.Builder#setManufacturerData(int, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addManufacturerSpecificDataFilter(@NonNull byte[] data, int offset, int length, @Nullable byte[] bitmask) {
        return addManufacturerSpecificDataFilter(new ManufacturerSpecificData(data, offset, length), bitmask);
    }

    /**
     * add Manufacturer Specific Data filter
     *
     * @param expect  {@link ManufacturerSpecificData} instance
     * @param bitmask bitmask for filter
     * @return myself
     * @see android.bluetooth.le.ScanFilter.Builder#setManufacturerData(int, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addManufacturerSpecificDataFilter(@NonNull ManufacturerSpecificData expect, @Nullable byte[] bitmask) {
        mFilterList.add(new ManufacturerSpecificDataFilter(expect, bitmask));
        return this;
    }

    /**
     * add Manufacturer Specific Data filter
     *
     * @param expectList  List of {@link ManufacturerSpecificData} instance
     * @param bitmaskList bitmask for filter
     * @return myself
     * @see android.bluetooth.le.ScanFilter.Builder#setManufacturerData(int, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addManufacturerSpecificDataFilter(@NonNull List<? extends ManufacturerSpecificData> expectList, @Nullable List<byte[]> bitmaskList) {
        mFilterList.add(new ManufacturerSpecificDataFilter(expectList, bitmaskList));
        return this;
    }

    /**
     * add Public Target Address filter
     *
     * @param data        Public Target Address data array
     * @param bitmaskList bitmask for filter
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addPublicTargetAddressFilter(@NonNull byte[] data, @Nullable List<byte[]> bitmaskList) {
        return addPublicTargetAddressFilter(data, 0, data.length, bitmaskList);
    }

    /**
     * add Public Target Address filter
     *
     * @param data   {@link PublicTargetAddress#PublicTargetAddress(byte[], int, int)} 1st parameter
     * @param offset {@link PublicTargetAddress#PublicTargetAddress(byte[], int, int)} 2nd parameter
     * @param length {@link PublicTargetAddress#PublicTargetAddress(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addPublicTargetAddressFilter(@NonNull byte[] data, int offset, int length, @Nullable List<byte[]> bitmaskList) {
        return addPublicTargetAddressFilter(new PublicTargetAddress(data, offset, length), bitmaskList);
    }

    /**
     * add Public Target Address filter
     *
     * @param expect      {@link PublicTargetAddress} instance
     * @param bitmaskList bitmask for filter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addPublicTargetAddressFilter(@NonNull PublicTargetAddress expect, @Nullable List<byte[]> bitmaskList) {
        mFilterList.add(new PublicTargetAddressFilter(expect, bitmaskList));
        return this;
    }

    /**
     * add Random Target Address filter
     *
     * @param data Random Target Address array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addRandomTargetAddressFilter(@NonNull byte[] data, @Nullable List<byte[]> bitmaskList) {
        return addRandomTargetAddressFilter(data, 0, data.length, bitmaskList);
    }

    /**
     * add Random Target Address filter
     *
     * @param data   {@link RandomTargetAddress#RandomTargetAddress(byte[], int, int)} 1st parameter
     * @param offset {@link RandomTargetAddress#RandomTargetAddress(byte[], int, int)} 2nd parameter
     * @param length {@link RandomTargetAddress#RandomTargetAddress(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addRandomTargetAddressFilter(@NonNull byte[] data, int offset, int length, @Nullable List<byte[]> bitmaskList) {
        return addRandomTargetAddressFilter(new RandomTargetAddress(data, offset, length), bitmaskList);
    }

    /**
     * add Random Target Address filter
     *
     * @param expect      {@link RandomTargetAddress} instance
     * @param bitmaskList bitmask for filter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addRandomTargetAddressFilter(@NonNull RandomTargetAddress expect, @Nullable List<byte[]> bitmaskList) {
        mFilterList.add(new RandomTargetAddressFilter(expect, bitmaskList));
        return this;
    }

    /**
     * add Service Data - 16-bit UUID filter
     *
     * @param data    Service Data - 16-bit UUID array
     * @param bitmask bitmask for filter
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData16BitUUIDFilter(@NonNull byte[] data, @Nullable byte[] bitmask) {
        return addServiceData16BitUUIDFilter(data, 0, data[0], bitmask);
    }

    /**
     * add Service Data - 16-bit UUID filter
     *
     * @param data    {@link ServiceData16BitUUID#ServiceData16BitUUID(byte[], int, int)} 1st parameter
     * @param offset  {@link ServiceData16BitUUID#ServiceData16BitUUID(byte[], int, int)} 2nd parameter
     * @param length  {@link ServiceData16BitUUID#ServiceData16BitUUID(byte[], int, int)} 3rd parameter
     * @param bitmask bitmask for filter
     * @return myself
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData16BitUUIDFilter(@NonNull byte[] data, int offset, int length, @Nullable byte[] bitmask) {
        return addServiceData16BitUUIDFilter(new ServiceData16BitUUID(data, offset, length), bitmask);
    }

    /**
     * add Service Data - 16-bit UUID filter
     *
     * @param expect  {@link ServiceData16BitUUID} instance
     * @param bitmask bitmask for filter
     * @return myself
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData16BitUUIDFilter(@NonNull ServiceData16BitUUID expect, @Nullable byte[] bitmask) {
        mFilterList.add(new ServiceData16BitUUIDFilter(expect, bitmask));
        return this;
    }

    /**
     * add Service Data - 16-bit UUID filter
     *
     * @param expectList  List of {@link ServiceData16BitUUID} instance
     * @param bitmaskList bitmask for filter
     * @return myself
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData16BitUUIDFilter(@NonNull List<? extends ServiceData16BitUUID> expectList, @Nullable List<byte[]> bitmaskList) {
        mFilterList.add(new ServiceData16BitUUIDFilter(expectList, bitmaskList));
        return this;
    }

    /**
     * add Service Data - 32-bit UUID filter
     *
     * @param data    Service Data - 32-bit UUID array
     * @param bitmask bitmask for filter
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData32BitUUIDFilter(@NonNull byte[] data, @Nullable byte[] bitmask) {
        return addServiceData32BitUUIDFilter(data, 0, data[0], bitmask);
    }

    /**
     * add Service Data - 32-bit UUID filter
     *
     * @param data    {@link ServiceData32BitUUID#ServiceData32BitUUID(byte[], int, int)} 1st parameter
     * @param offset  {@link ServiceData32BitUUID#ServiceData32BitUUID(byte[], int, int)} 2nd parameter
     * @param length  {@link ServiceData32BitUUID#ServiceData32BitUUID(byte[], int, int)} 3rd parameter
     * @param bitmask bitmask for filter
     * @return myself
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData32BitUUIDFilter(@NonNull byte[] data, int offset, int length, @Nullable byte[] bitmask) {
        return addServiceData32BitUUIDFilter(new ServiceData32BitUUID(data, offset, length), bitmask);
    }

    /**
     * add Service Data - 32-bit UUID filter
     *
     * @param expect  {@link ServiceData32BitUUID} instance
     * @param bitmask bitmask for filter
     * @return myself
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData32BitUUIDFilter(@NonNull ServiceData32BitUUID expect, @Nullable byte[] bitmask) {
        mFilterList.add(new ServiceData32BitUUIDFilter(expect, bitmask));
        return this;
    }

    /**
     * add Service Data - 32-bit UUID filter
     *
     * @param expectList  List of {@link ServiceData32BitUUID} instance
     * @param bitmaskList bitmask for filter
     * @return myself
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData32BitUUIDFilter(@NonNull List<? extends ServiceData32BitUUID> expectList, @Nullable List<byte[]> bitmaskList) {
        mFilterList.add(new ServiceData32BitUUIDFilter(expectList, bitmaskList));
        return this;
    }

    /**
     * add Service Data - 128-bit UUID filter
     *
     * @param data    Service Data - 128-bit UUID array
     * @param bitmask bitmask for filter
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData128BitUUIDFilter(@NonNull byte[] data, @Nullable byte[] bitmask) {
        return addServiceData128BitUUIDFilter(data, 0, data[0], bitmask);
    }

    /**
     * add Service Data - 128-bit UUID filter
     *
     * @param data    {@link ServiceData128BitUUID#ServiceData128BitUUID(byte[], int, int)} 1st parameter
     * @param offset  {@link ServiceData128BitUUID#ServiceData128BitUUID(byte[], int, int)} 2nd parameter
     * @param length  {@link ServiceData128BitUUID#ServiceData128BitUUID(byte[], int, int)} 3rd parameter
     * @param bitmask bitmask for filter
     * @return myself
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData128BitUUIDFilter(@NonNull byte[] data, int offset, int length, @Nullable byte[] bitmask) {
        return addServiceData128BitUUIDFilter(new ServiceData128BitUUID(data, offset, length), bitmask);
    }

    /**
     * add Service Data - 128-bit UUID filter
     *
     * @param expect  {@link ServiceData128BitUUID} instance
     * @param bitmask bitmask for filter
     * @return myself
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData128BitUUIDFilter(@NonNull ServiceData128BitUUID expect, @Nullable byte[] bitmask) {
        mFilterList.add(new ServiceData128BitUUIDFilter(expect, bitmask));
        return this;
    }

    /**
     * add Service Data - 128-bit UUID filter
     *
     * @param expectList  List of {@link ServiceData128BitUUID} instance
     * @param bitmaskList bitmask for filter
     * @return myself
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData128BitUUIDFilter(@NonNull List<? extends ServiceData128BitUUID> expectList, @Nullable List<byte[]> bitmaskList) {
        mFilterList.add(new ServiceData128BitUUIDFilter(expectList, bitmaskList));
        return this;
    }

    /**
     * add Shortened Local Name filter
     *
     * @param data Shortened Local Name array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addShortenedLocalNameFilter(@NonNull byte[] data) {
        return addShortenedLocalNameFilter(data, 0, data[0]);
    }

    /**
     * add Shortened Local Name filter
     *
     * @param data   {@link ShortenedLocalName#ShortenedLocalName(byte[], int, int)} 1st parameter
     * @param offset {@link ShortenedLocalName#ShortenedLocalName(byte[], int, int)} 2nd parameter
     * @param length {@link ShortenedLocalName#ShortenedLocalName(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addShortenedLocalNameFilter(@NonNull byte[] data, int offset, int length) {
        return addShortenedLocalNameFilter(new ShortenedLocalName(data, offset, length));
    }

    /**
     * add Shortened Local Name filter
     *
     * @param expect {@link ShortenedLocalName} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addShortenedLocalNameFilter(@NonNull ShortenedLocalName expect) {
        mFilterList.add(new ShortenedLocalNameFilter(expect));
        return this;
    }

    /**
     * add Peripheral Connection Interval Range filter
     *
     * @param data Peripheral Connection Interval Range array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addPeripheralConnectionIntervalRangeFilter(@NonNull byte[] data) {
        return addPeripheralConnectionIntervalRangeFilter(data, 0, data[0]);
    }

    /**
     * add Peripheral Connection Interval Range filter
     *
     * @param data   {@link PeripheralConnectionIntervalRange#PeripheralConnectionIntervalRange(byte[], int, int)} 1st parameter
     * @param offset {@link PeripheralConnectionIntervalRange#PeripheralConnectionIntervalRange(byte[], int, int)} 2nd parameter
     * @param length {@link PeripheralConnectionIntervalRange#PeripheralConnectionIntervalRange(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addPeripheralConnectionIntervalRangeFilter(@NonNull byte[] data, int offset, int length) {
        return addPeripheralConnectionIntervalRangeFilter(new PeripheralConnectionIntervalRange(data, offset, length));
    }

    /**
     * add Peripheral Connection Interval Range filter
     *
     * @param expect {@link PeripheralConnectionIntervalRange} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addPeripheralConnectionIntervalRangeFilter(@NonNull PeripheralConnectionIntervalRange expect) {
        mFilterList.add(new PeripheralConnectionIntervalRangeFilter(expect));
        return this;
    }

    /**
     * add Peripheral Connection Interval Range filter
     *
     * @param expectList List of {@link PeripheralConnectionIntervalRange} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addPeripheralConnectionIntervalRangeFilter(@NonNull List<? extends PeripheralConnectionIntervalRange> expectList) {
        mFilterList.add(new PeripheralConnectionIntervalRangeFilter(expectList));
        return this;
    }

    /**
     * add Transport Discovery Data filter
     *
     * @param data Transport Discovery Data data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addTransportDiscoveryDataFilter(@NonNull byte[] data) {
        return addTransportDiscoveryDataFilter(data, 0, data.length);
    }

    /**
     * add Indoor Positioning filter
     *
     * @param data   {@link TransportDiscoveryData#TransportDiscoveryData(byte[], int, int)} 1st parameter
     * @param offset {@link TransportDiscoveryData#TransportDiscoveryData(byte[], int, int)} 2nd parameter
     * @param length {@link TransportDiscoveryData#TransportDiscoveryData(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addTransportDiscoveryDataFilter(@NonNull byte[] data, int offset, int length) {
        return addTransportDiscoveryDataFilter(new TransportDiscoveryData(data, offset, length));
    }

    /**
     * add Indoor Positioning filter
     *
     * @param expect {@link Flags} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addTransportDiscoveryDataFilter(@NonNull TransportDiscoveryData expect) {
        mFilterList.add(new TransportDiscoveryDataFilter(expect));
        return this;
    }

    /**
     * add Tx Power Level filter
     *
     * @param data Tx Power Level array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addTxPowerLevelFilter(@NonNull byte[] data) {
        return addTxPowerLevelFilter(data, 0, data.length);
    }

    /**
     * add Tx Power Level filter
     *
     * @param data   {@link TxPowerLevel#TxPowerLevel(byte[], int, int)} 1st parameter
     * @param offset {@link TxPowerLevel#TxPowerLevel(byte[], int, int)} 2nd parameter
     * @param length {@link TxPowerLevel#TxPowerLevel(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addTxPowerLevelFilter(@NonNull byte[] data, int offset, int length) {
        return addTxPowerLevelFilter(new TxPowerLevel(data, offset, length));
    }

    /**
     * add Tx Power Level filter
     *
     * @param expect {@link TxPowerLevel} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addTxPowerLevelFilter(@NonNull TxPowerLevel expect) {
        mFilterList.add(new TxPowerLevelFilter(expect));
        return this;
    }

    /**
     * add Tx Power Level filter
     *
     * @param expectList List of {@link TxPowerLevel} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addTxPowerLevelFilter(@NonNull List<? extends TxPowerLevel> expectList) {
        mFilterList.add(new TxPowerLevelFilter(expectList));
        return this;
    }

    /**
     * add URI filter
     *
     * @param data URI array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addUniformResourceIdentifier(@NonNull byte[] data) {
        return addUniformResourceIdentifier(data, 0, data[0]);
    }

    /**
     * add URI filter
     *
     * @param data   {@link UniformResourceIdentifier#UniformResourceIdentifier(byte[], int, int)} 1st parameter
     * @param offset {@link UniformResourceIdentifier#UniformResourceIdentifier(byte[], int, int)} 2nd parameter
     * @param length {@link UniformResourceIdentifier#UniformResourceIdentifier(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addUniformResourceIdentifier(@NonNull byte[] data, int offset, int length) {
        return addUniformResourceIdentifier(new UniformResourceIdentifier(data, offset, length));
    }

    /**
     * add URI filter
     *
     * @param expect {@link UniformResourceIdentifier} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addUniformResourceIdentifier(@NonNull UniformResourceIdentifier expect) {
        mFilterList.add(new UniformResourceIdentifierFilter(expect));
        return this;
    }

    /**
     * add URI filter
     *
     * @param expectList {@link UniformResourceIdentifier} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addUniformResourceIdentifier(@NonNull List<? extends UniformResourceIdentifier> expectList) {
        mFilterList.add(new UniformResourceIdentifierFilter(expectList));
        return this;
    }

    /**
     * add Encrypted Data filter
     *
     * @param data Encrypted Data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addEncryptedData(@NonNull byte[] data) {
        return addEncryptedData(data, 0, data.length);
    }

    /**
     * add Encrypted Data filter
     *
     * @param data   {@link EncryptedData#EncryptedData(byte[], int, int)} 1st parameter
     * @param offset {@link EncryptedData#EncryptedData(byte[], int, int)} 2nd parameter
     * @param length {@link EncryptedData#EncryptedData(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addEncryptedData(@NonNull byte[] data, int offset, int length) {
        return addEncryptedData(new EncryptedData(data, offset, length));
    }

    /**
     * add Encrypted Data filter
     *
     * @param expect {@link UniformResourceIdentifier} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addEncryptedData(@NonNull EncryptedData expect) {
        mFilterList.add(new EncryptedDataFilter(expect));
        return this;
    }

    /**
     * add Encrypted Data filter
     *
     * @param expectList {@link EncryptedData} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addEncryptedData(@NonNull List<? extends EncryptedData> expectList) {
        mFilterList.add(new EncryptedDataFilter(expectList));
        return this;
    }

    /**
     * add Periodic Advertising Response Timing Information filter
     *
     * @param data Encrypted Data array
     * @return myself
     * @see ByteArrayCreator#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addPeriodicAdvertisingResponseTimingInformation(@NonNull byte[] data) {
        return addPeriodicAdvertisingResponseTimingInformation(data, 0, data.length);
    }

    /**
     * add Periodic Advertising Response Timing Information filter
     *
     * @param data   {@link PeriodicAdvertisingResponseTimingInformation#PeriodicAdvertisingResponseTimingInformation(byte[], int, int)} 1st parameter
     * @param offset {@link PeriodicAdvertisingResponseTimingInformation#PeriodicAdvertisingResponseTimingInformation(byte[], int, int)} 2nd parameter
     * @param length {@link PeriodicAdvertisingResponseTimingInformation#PeriodicAdvertisingResponseTimingInformation(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addPeriodicAdvertisingResponseTimingInformation(@NonNull byte[] data, int offset, int length) {
        return addPeriodicAdvertisingResponseTimingInformation(new PeriodicAdvertisingResponseTimingInformation(data, offset, length));
    }

    /**
     * add Periodic Advertising Response Timing Information filter
     *
     * @param expect {@link PeriodicAdvertisingResponseTimingInformation} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addPeriodicAdvertisingResponseTimingInformation(@NonNull PeriodicAdvertisingResponseTimingInformation expect) {
        mFilterList.add(new PeriodicAdvertisingResponseTimingInformationFilter(expect));
        return this;
    }

    /**
     * add Periodic Advertising Response Timing Information filter
     *
     * @param expectList {@link PeriodicAdvertisingResponseTimingInformation} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addPeriodicAdvertisingResponseTimingInformation(@NonNull List<? extends PeriodicAdvertisingResponseTimingInformation> expectList) {
        mFilterList.add(new PeriodicAdvertisingResponseTimingInformationFilter(expectList));
        return this;
    }

    /**
     * @return {@link FilteredLeScanCallback} or {@link FilteredLeScanCallback} instance
     */
    public abstract T build();

}
