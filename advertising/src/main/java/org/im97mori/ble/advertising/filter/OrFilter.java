package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

/**
 * Or condition filter
 *
 * @param <T> Advertising data or check target data
 */
@SuppressWarnings({"WeakerAccess"})
public class OrFilter<T> implements AdvertisingDataFilter<T> {

    /**
     * filter list for <b>OR</b> conditions
     */
    private final List<AdvertisingDataFilter<T>> mFilters;

    /**
     * @param filters filter list for <b>OR</b> conditions
     */
    @SafeVarargs
    public OrFilter(@NonNull AdvertisingDataFilter<T>... filters) {
        this(Arrays.asList(filters));
    }

    /**
     * @see #OrFilter(List)
     */
    public OrFilter(@NonNull List<AdvertisingDataFilter<T>> filterList) {
        mFilters = filterList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull T parseResult) {
        boolean result;
        if (mFilters.isEmpty()) {
            result = true;
        } else {
            result = false;
            for (AdvertisingDataFilter<T> filter : mFilters) {
                if (filter.isMatched(parseResult)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
