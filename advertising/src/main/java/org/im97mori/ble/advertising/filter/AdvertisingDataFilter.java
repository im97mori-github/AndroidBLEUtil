package org.im97mori.ble.advertising.filter;

/**
 * filter interface for Advertising data
 *
 * @param <T> Advertising data or check target data
 */
public interface AdvertisingDataFilter<T> {

    /**
     * filter check
     *
     * @param result Advertising data or check target data
     * @return {@code true}:not filtered, {@code false}:filtered(suppressed)
     */
    boolean isMatched(T result);

}
