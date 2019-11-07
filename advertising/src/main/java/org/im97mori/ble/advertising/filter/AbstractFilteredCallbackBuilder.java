package org.im97mori.ble.advertising.filter;

import android.os.ParcelUuid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.AdvertisingInterval;
import org.im97mori.ble.advertising.Appearance;
import org.im97mori.ble.advertising.ChannelMapUpdateIndication;
import org.im97mori.ble.advertising.CompleteListOf128BitServiceUUIDs;
import org.im97mori.ble.advertising.CompleteListOf16BitServiceUUIDs;
import org.im97mori.ble.advertising.CompleteListOf32BitServiceUUIDs;
import org.im97mori.ble.advertising.CompleteLocalName;
import org.im97mori.ble.advertising.Flags;
import org.im97mori.ble.advertising.IncompleteListOf128BitServiceUUIDs;
import org.im97mori.ble.advertising.IncompleteListOf16BitServiceUUIDs;
import org.im97mori.ble.advertising.IncompleteListOf32BitServiceUUIDs;
import org.im97mori.ble.advertising.LeSupportedFeatures;
import org.im97mori.ble.advertising.ListOf128BitServiceSolicitationUUIDs;
import org.im97mori.ble.advertising.ListOf16BitServiceSolicitationUUIDs;
import org.im97mori.ble.advertising.ListOf32BitServiceSolicitationUUIDs;
import org.im97mori.ble.advertising.ManufacturerSpecificData;
import org.im97mori.ble.advertising.PublicTargetAddress;
import org.im97mori.ble.advertising.RandomTargetAddress;
import org.im97mori.ble.advertising.ServiceData128BitUUID;
import org.im97mori.ble.advertising.ServiceData16BitUUID;
import org.im97mori.ble.advertising.ServiceData32BitUUID;
import org.im97mori.ble.advertising.ShortenedLocalName;
import org.im97mori.ble.advertising.SlaveConnectionIntervalRange;
import org.im97mori.ble.advertising.TxPowerLevel;
import org.im97mori.ble.advertising.UniformRsourceIdentifier;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Builder for {@link FilteredLeScanCallback} or {@link FilteredLeScanCallback} with filter function
 *
 * @param <T> instance of {@link FilteredLeScanCallback} or {@link FilteredLeScanCallback}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
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
     * constructor
     */
    public AbstractFilteredCallbackBuilder() {
    }

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
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addAdvertisingIntervalFilter(@NonNull byte[] data) {
        return addAdvertisingIntervalFilter(AdvertisingInterval.CREATOR.createFromByteArray(data));
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
     * add Appearance filter
     *
     * @param data Appearance data array
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addAppearanceFilter(@NonNull byte[] data) {
        return addAppearanceFilter(Appearance.CREATOR.createFromByteArray(data));
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
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addChannelMapUpdateIndicationFilter(@NonNull byte[] data) {
        return addChannelMapUpdateIndicationFilter(ChannelMapUpdateIndication.CREATOR.createFromByteArray(data));
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
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf16BitServiceUUIDsFilter(@NonNull byte[] data) {
        return addCompleteListOf16BitServiceUUIDsFilter(CompleteListOf16BitServiceUUIDs.CREATOR.createFromByteArray(data));
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
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf16BitServiceUUIDsFilter(@NonNull List<CompleteListOf16BitServiceUUIDs> expectList) {
        mFilterList.add(new CompleteListOf16BitServiceUUIDsFilter(expectList));
        return this;
    }

    /**
     * add Complete List of 32-bit Service Class UUIDs filter
     *
     * @param data Complete List of 32-bit Service Class UUIDs data array
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf32BitServiceUUIDsFilter(@NonNull byte[] data) {
        return addCompleteListOf32BitServiceUUIDsFilter(CompleteListOf32BitServiceUUIDs.CREATOR.createFromByteArray(data));
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
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf32BitServiceUUIDsFilter(@NonNull List<CompleteListOf32BitServiceUUIDs> expectList) {
        mFilterList.add(new CompleteListOf32BitServiceUUIDsFilter(expectList));
        return this;
    }

    /**
     * add Complete List of 128-bit Service Class UUIDs filter
     *
     * @param data Complete List of 128-bit Service Class UUIDs data array
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf128BitServiceUUIDsFilter(@NonNull byte[] data) {
        return addCompleteListOf128BitServiceUUIDsFilter(CompleteListOf128BitServiceUUIDs.CREATOR.createFromByteArray(data));
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
    public AbstractFilteredCallbackBuilder<T> addCompleteListOf128BitServiceUUIDsFilter(@NonNull List<CompleteListOf128BitServiceUUIDs> expectList) {
        mFilterList.add(new CompleteListOf128BitServiceUUIDsFilter(expectList));
        return this;
    }

    /**
     * add Complete Local Name filter
     *
     * @param data Complete Local Name UUIDs data array
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addCompleteLocalNameFilter(@NonNull byte[] data) {
        return addCompleteLocalNameFilter(CompleteLocalName.CREATOR.createFromByteArray(data));
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
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addFlagsFilter(@NonNull byte[] data) {
        return addFlagsFilter(Flags.CREATOR.createFromByteArray(data));
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
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf16BitServiceUUIDsFilter(@NonNull byte[] data) {
        return addIncompleteListOf16BitServiceUUIDsFilter(IncompleteListOf16BitServiceUUIDs.CREATOR.createFromByteArray(data));
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
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf16BitServiceUUIDsFilter(@NonNull List<IncompleteListOf16BitServiceUUIDs> expectList) {
        mFilterList.add(new IncompleteListOf16BitServiceUUIDsFilter(expectList));
        return this;
    }

    /**
     * add Incomplete List of 32-bit Service Class UUIDs filter
     *
     * @param data Incomplete List of 32-bit Service Class UUIDs data array
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf32BitServiceUUIDsFilter(@NonNull byte[] data) {
        return addIncompleteListOf32BitServiceUUIDsFilter(IncompleteListOf32BitServiceUUIDs.CREATOR.createFromByteArray(data));
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
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf32BitServiceUUIDsFilter(@NonNull List<IncompleteListOf32BitServiceUUIDs> expectList) {
        mFilterList.add(new IncompleteListOf32BitServiceUUIDsFilter(expectList));
        return this;
    }

    /**
     * add Incomplete List of 128-bit Service Class UUIDs filter
     *
     * @param data Incomplete List of 128-bit Service Class UUIDs data array
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf128BitServiceUUIDsFilter(@NonNull byte[] data) {
        return addIncompleteListOf128BitServiceUUIDsFilter(IncompleteListOf128BitServiceUUIDs.CREATOR.createFromByteArray(data));
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
    public AbstractFilteredCallbackBuilder<T> addIncompleteListOf128BitServiceUUIDsFilter(@NonNull List<IncompleteListOf128BitServiceUUIDs> expectList) {
        mFilterList.add(new IncompleteListOf128BitServiceUUIDsFilter(expectList));
        return this;
    }

    /**
     * add LE Supported Features filter
     *
     * @param data LE Supported Features data array
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addLeSupportedFeaturesFilter(@NonNull byte[] data) {
        return addLeSupportedFeaturesFilter(LeSupportedFeatures.CREATOR.createFromByteArray(data));
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
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf16BitServiceSolicitationUUIDsFilter(@NonNull byte[] data) {
        return addListOf16BitServiceSolicitationUUIDsFilter(ListOf16BitServiceSolicitationUUIDs.CREATOR.createFromByteArray(data));
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
    public AbstractFilteredCallbackBuilder<T> addListOf16BitServiceSolicitationUUIDsFilter(@NonNull List<ListOf16BitServiceSolicitationUUIDs> expectList) {
        mFilterList.add(new ListOf16BitServiceSolicitationUUIDsFilter(expectList));
        return this;
    }

    /**
     * add List of 32-bit Service Solicitation UUIDs filter
     *
     * @param data List of 32-bit Service Solicitation UUIDs data array
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf32BitServiceSolicitationUUIDsFilter(@NonNull byte[] data) {
        return addListOf32BitServiceSolicitationUUIDsFilter(ListOf32BitServiceSolicitationUUIDs.CREATOR.createFromByteArray(data));
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
    public AbstractFilteredCallbackBuilder<T> addListOf32BitServiceSolicitationUUIDsFilter(@NonNull List<ListOf32BitServiceSolicitationUUIDs> expectList) {
        mFilterList.add(new ListOf32BitServiceSolicitationUUIDsFilter(expectList));
        return this;
    }

    /**
     * add List of 128-bit Service Solicitation UUIDs filter
     *
     * @param data List of 128-bit Service Solicitation UUIDs data array
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addListOf128BitServiceSolicitationUUIDsFilter(@NonNull byte[] data) {
        return addListOf128BitServiceSolicitationUUIDsFilter(ListOf128BitServiceSolicitationUUIDs.CREATOR.createFromByteArray(data));
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
    public AbstractFilteredCallbackBuilder<T> addListOf128BitServiceSolicitationUUIDsFilter(@NonNull List<ListOf128BitServiceSolicitationUUIDs> expectList) {
        mFilterList.add(new ListOf128BitServiceSolicitationUUIDsFilter(expectList));
        return this;
    }

    /**
     * add Manufacturer Specific Data filter
     *
     * @param data    Manufacturer Specific Data data array
     * @param bitmask bitmask for filter
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     * @see android.bluetooth.le.ScanFilter.Builder#setManufacturerData(int, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addManufacturerSpecificDataFilter(@NonNull byte[] data, @Nullable byte[] bitmask) {
        return addManufacturerSpecificDataFilter(ManufacturerSpecificData.CREATOR.createFromByteArray(data), bitmask);
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
    public AbstractFilteredCallbackBuilder<T> addManufacturerSpecificDataFilter(@NonNull List<ManufacturerSpecificData> expectList, @Nullable List<byte[]> bitmaskList) {
        mFilterList.add(new ManufacturerSpecificDataFilter(expectList, bitmaskList));
        return this;
    }

    /**
     * add Public Target Address filter
     *
     * @param data        Public Target Address data array
     * @param bitmaskList bitmask for filter
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addPublicTargetAddressFilter(@NonNull byte[] data, @Nullable List<byte[]> bitmaskList) {
        return addPublicTargetAddressFilter(PublicTargetAddress.CREATOR.createFromByteArray(data), bitmaskList);
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
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addRandomTargetAddressFilter(@NonNull byte[] data, @Nullable List<byte[]> bitmaskList) {
        return addRandomTargetAddressFilter(RandomTargetAddress.CREATOR.createFromByteArray(data), bitmaskList);
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
     * @see ByteArrayCreater#createFromByteArray(byte[])
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData16BitUUIDFilter(@NonNull byte[] data, @Nullable byte[] bitmask) {
        return addServiceData16BitUUIDFilter(ServiceData16BitUUID.CREATOR.createFromByteArray(data), bitmask);
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
    public AbstractFilteredCallbackBuilder<T> addServiceData16BitUUIDFilter(@NonNull List<ServiceData16BitUUID> expectList, @Nullable List<byte[]> bitmaskList) {
        mFilterList.add(new ServiceData16BitUUIDFilter(expectList, bitmaskList));
        return this;
    }

    /**
     * add Service Data - 32-bit UUID filter
     *
     * @param data    Service Data - 32-bit UUID array
     * @param bitmask bitmask for filter
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData32BitUUIDFilter(@NonNull byte[] data, @Nullable byte[] bitmask) {
        return addServiceData32BitUUIDFilter(ServiceData32BitUUID.CREATOR.createFromByteArray(data), bitmask);
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
    public AbstractFilteredCallbackBuilder<T> addServiceData32BitUUIDFilter(@NonNull List<ServiceData32BitUUID> expectList, @Nullable List<byte[]> bitmaskList) {
        mFilterList.add(new ServiceData32BitUUIDFilter(expectList, bitmaskList));
        return this;
    }

    /**
     * add Service Data - 128-bit UUID filter
     *
     * @param data    Service Data - 128-bit UUID array
     * @param bitmask bitmask for filter
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     * @see android.bluetooth.le.ScanFilter.Builder#setServiceData(ParcelUuid, byte[], byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addServiceData128BitUUIDFilter(@NonNull byte[] data, @Nullable byte[] bitmask) {
        return addServiceData128BitUUIDFilter(ServiceData128BitUUID.CREATOR.createFromByteArray(data), bitmask);
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
    public AbstractFilteredCallbackBuilder<T> addServiceData128BitUUIDFilter(@NonNull List<ServiceData128BitUUID> expectList, @Nullable List<byte[]> bitmaskList) {
        mFilterList.add(new ServiceData128BitUUIDFilter(expectList, bitmaskList));
        return this;
    }

    /**
     * add Shortened Local Name filter
     *
     * @param data Shortened Local Name array
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addShortenedLocalNameFilter(@NonNull byte[] data) {
        return addShortenedLocalNameFilter(ShortenedLocalName.CREATOR.createFromByteArray(data));
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
     * add Slave Connection Interval Range filter
     *
     * @param data Slave Connection Interval Range array
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addSlaveConnectionIntervalRangeFilter(@NonNull byte[] data) {
        return addSlaveConnectionIntervalRangeFilter(SlaveConnectionIntervalRange.CREATOR.createFromByteArray(data));
    }

    /**
     * add Slave Connection Interval Range filter
     *
     * @param data   {@link SlaveConnectionIntervalRange#SlaveConnectionIntervalRange(byte[], int, int)} 1st parameter
     * @param offset {@link SlaveConnectionIntervalRange#SlaveConnectionIntervalRange(byte[], int, int)} 2nd parameter
     * @param length {@link SlaveConnectionIntervalRange#SlaveConnectionIntervalRange(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addSlaveConnectionIntervalRangeFilter(@NonNull byte[] data, int offset, int length) {
        return addSlaveConnectionIntervalRangeFilter(new SlaveConnectionIntervalRange(data, offset, length));
    }

    /**
     * add Slave Connection Interval Range filter
     *
     * @param expect {@link SlaveConnectionIntervalRange} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addSlaveConnectionIntervalRangeFilter(@NonNull SlaveConnectionIntervalRange expect) {
        mFilterList.add(new SlaveConnectionIntervalRangeFilter(expect));
        return this;
    }

    /**
     * add Slave Connection Interval Range filter
     *
     * @param expectList List of {@link SlaveConnectionIntervalRange} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addSlaveConnectionIntervalRangeFilter(@NonNull List<SlaveConnectionIntervalRange> expectList) {
        mFilterList.add(new SlaveConnectionIntervalRangeFilter(expectList));
        return this;
    }

    /**
     * add Tx Power Level filter
     *
     * @param data Tx Power Level array
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addTxPowerLevelFilter(@NonNull byte[] data) {
        return addTxPowerLevelFilter(TxPowerLevel.CREATOR.createFromByteArray(data));
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
    public AbstractFilteredCallbackBuilder<T> addTxPowerLevelFilter(@NonNull List<TxPowerLevel> expectList) {
        mFilterList.add(new TxPowerLevelFilter(expectList));
        return this;
    }

    /**
     * add URI filter
     *
     * @param data URI array
     * @return myself
     * @see ByteArrayCreater#createFromByteArray(byte[])
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addUniformRsourceIdentifier(@NonNull byte[] data) {
        return addUniformRsourceIdentifier(UniformRsourceIdentifier.CREATOR.createFromByteArray(data));
    }

    /**
     * add URI filter
     *
     * @param data   {@link UniformRsourceIdentifier#UniformRsourceIdentifier(byte[], int, int)} 1st parameter
     * @param offset {@link UniformRsourceIdentifier#UniformRsourceIdentifier(byte[], int, int)} 2nd parameter
     * @param length {@link UniformRsourceIdentifier#UniformRsourceIdentifier(byte[], int, int)} 3rd parameter
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addUniformRsourceIdentifier(@NonNull byte[] data, int offset, int length) {
        return addUniformRsourceIdentifier(new UniformRsourceIdentifier(data, offset, length));
    }

    /**
     * add URI filter
     *
     * @param expect {@link UniformRsourceIdentifier} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addUniformRsourceIdentifier(@NonNull UniformRsourceIdentifier expect) {
        mFilterList.add(new UniformRsourceIdentifierFilter(expect));
        return this;
    }

    /**
     * add URI filter
     *
     * @param expectList {@link UniformRsourceIdentifier} instance
     * @return myself
     */
    @NonNull
    public AbstractFilteredCallbackBuilder<T> addUniformRsourceIdentifier(@NonNull List<UniformRsourceIdentifier> expectList) {
        mFilterList.add(new UniformRsourceIdentifierFilter(expectList));
        return this;
    }

    /**
     * @return {@link FilteredLeScanCallback} or {@link FilteredLeScanCallback} instance
     */
    public abstract T build();

}
