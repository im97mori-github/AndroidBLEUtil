package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

/**
 * And condition filter
 *
 * @param <T> Advertising data or check target data
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class AndFilter<T> implements AdvertisingDataFilter<T> {

    /**
     * filter list for <b>AND</b> conditions
     */
    private final List<AdvertisingDataFilter<T>> mFilters;

    /**
     * @param filters filter list for <b>AND</b> conditions
     */
    @SafeVarargs
    public AndFilter(@NonNull AdvertisingDataFilter<T>... filters) {
        this(Arrays.asList(filters));
    }

    /**
     * @see #AndFilter(List)
     */
    public AndFilter(@NonNull List<AdvertisingDataFilter<T>> filterList) {
        mFilters = filterList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull T parseResult) {
        boolean result = true;
        for (AdvertisingDataFilter<T> filter : mFilters) {
            if (!filter.isMatched(parseResult)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
