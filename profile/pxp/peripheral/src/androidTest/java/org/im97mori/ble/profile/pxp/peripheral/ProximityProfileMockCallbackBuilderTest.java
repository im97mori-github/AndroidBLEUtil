package org.im97mori.ble.profile.pxp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.characteristic.u2a07.TxPowerLevel;
import org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback;
import org.im97mori.ble.service.lls.peripheral.LinkLossServiceMockCallback;
import org.im97mori.ble.service.tps.peripheral.TxPowerServiceMockCallback;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ProximityProfileMockCallbackBuilderTest {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<>();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<>();
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(linkLossServiceMockCallbackBuilder, baseBuilder.mLinkLossServiceMockCallbackBuilder);
        assertEquals(immediateAlertServiceMockCallbackBuilder, baseBuilder.mImmediateAlertServiceMockCallbackBuilder);
        assertEquals(txPowerServiceMockCallbackkBuilder, baseBuilder.mTxPowerServiceMockCallbackBuilder);
    }

    @Test
    public void test_addLinkLossServiceAlertLevel_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AlertLevel originalAlertLevel = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT);

        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback>() {
            @NonNull
            @Override
            public LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> addAlertLevel(int alertLevel) {
                assertEquals(originalAlertLevel.getAlertLevel(), alertLevel);
                atomicBoolean.set(true);
                return super.addAlertLevel(alertLevel);
            }
        };
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<>();
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.addLinkLossServiceAlertLevel(originalAlertLevel.getAlertLevel()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addLinkLossServiceAlertLevel_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AlertLevel originalAlertLevel = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT);

        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback>() {
            @NonNull
            @Override
            public LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> addAlertLevel(@NonNull AlertLevel alertLevel) {
                assertArrayEquals(originalAlertLevel.getBytes(), alertLevel.getBytes());
                atomicBoolean.set(true);
                return super.addAlertLevel(alertLevel);
            }
        };
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<>();
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.addLinkLossServiceAlertLevel(originalAlertLevel));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addLinkLossServiceAlertLevel_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AlertLevel originalAlertLevel = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT);

        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback>() {
            @NonNull
            @Override
            public LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> addAlertLevel(@NonNull byte[] value) {
                assertArrayEquals(originalAlertLevel.getBytes(), value);
                atomicBoolean.set(true);
                return super.addAlertLevel(value);
            }
        };
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<>();
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.addLinkLossServiceAlertLevel(originalAlertLevel.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addLinkLossServiceAlertLevel_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT).getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback>() {
            @NonNull
            @Override
            public LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> addAlertLevel(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addAlertLevel(responseCode, delay, value);
            }
        };
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<>();
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.addLinkLossServiceAlertLevel(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeLinkLossServiceAlertLevel_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback>() {
            @NonNull
            @Override
            public LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> removeAlertLevel() {
                atomicBoolean.set(true);
                return super.removeAlertLevel();
            }
        };
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<>();
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.removeLinkLossServiceAlertLevel());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addImmediateAlertServiceAlertLevel_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AlertLevel originalAlertLevel = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT);

        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<>();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback>() {
            @NonNull
            @Override
            public ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> addAlertLevel(int alertLevel) {
                assertEquals(originalAlertLevel.getAlertLevel(), alertLevel);
                atomicBoolean.set(true);
                return super.addAlertLevel(alertLevel);
            }
        };
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.addImmediateAlertServiceAlertLevel(originalAlertLevel.getAlertLevel()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addImmediateAlertServiceAlertLevel_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AlertLevel originalAlertLevel = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT);

        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<>();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback>() {
            @NonNull
            @Override
            public ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> addAlertLevel(@NonNull AlertLevel alertLevel) {
                assertArrayEquals(originalAlertLevel.getBytes(), alertLevel.getBytes());
                atomicBoolean.set(true);
                return super.addAlertLevel(alertLevel);
            }
        };
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.addImmediateAlertServiceAlertLevel(originalAlertLevel));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addImmediateAlertServiceAlertLevel_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AlertLevel originalAlertLevel = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT);

        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<>();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback>() {
            @NonNull
            @Override
            public ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> addAlertLevel(@NonNull byte[] value) {
                assertArrayEquals(originalAlertLevel.getBytes(), value);
                atomicBoolean.set(true);
                return super.addAlertLevel(value);
            }
        };
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.addImmediateAlertServiceAlertLevel(originalAlertLevel.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addImmediateAlertServiceAlertLevel_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT).getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<>();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback>() {
            @NonNull
            @Override
            public ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> addAlertLevel(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addAlertLevel(responseCode, delay, value);
            }
        };
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.addImmediateAlertServiceAlertLevel(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeImmediateAlertServiceAlertLevel_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<>();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback>() {
            @NonNull
            @Override
            public ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> removeAlertLevel() {
                atomicBoolean.set(true);
                return super.removeAlertLevel();
            }
        };
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.removeImmediateAlertServiceAlertLevel());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTxPowerLevel_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final TxPowerLevel originalTxPowerLevel = new TxPowerLevel(1);

        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<>();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<>();
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback>() {
            @NonNull
            @Override
            public TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> addTxPowerLevel(int txPower) {
                assertEquals(originalTxPowerLevel.getTxPower(), txPower);
                atomicBoolean.set(true);
                return super.addTxPowerLevel(txPower);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.addTxPowerLevel(originalTxPowerLevel.getTxPower()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTxPowerLevel_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final TxPowerLevel originalTxPowerLevel = new TxPowerLevel(1);

        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<>();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<>();
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback>() {
            @NonNull
            @Override
            public TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> addTxPowerLevel(@NonNull TxPowerLevel txPowerLevel) {
                assertArrayEquals(originalTxPowerLevel.getBytes(), txPowerLevel.getBytes());
                atomicBoolean.set(true);
                return super.addTxPowerLevel(txPowerLevel);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.addTxPowerLevel(originalTxPowerLevel));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTxPowerLevel_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final TxPowerLevel originalTxPowerLevel = new TxPowerLevel(1);

        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<>();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<>();
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback>() {
            @NonNull
            @Override
            public TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> addTxPowerLevel(@NonNull byte[] value) {
                assertArrayEquals(originalTxPowerLevel.getBytes(), value);
                atomicBoolean.set(true);
                return super.addTxPowerLevel(value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.addTxPowerLevel(originalTxPowerLevel.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTxPowerLevel_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = new TxPowerLevel(1).getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<>();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<>();
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback>() {
            @NonNull
            @Override
            public TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> addTxPowerLevel(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addTxPowerLevel(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.addTxPowerLevel(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeTxPowerLevel_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<>();
        LinkLossServiceMockCallback.Builder<LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder = new LinkLossServiceMockCallback.Builder<>();
        TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> txPowerServiceMockCallbackkBuilder = new TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback>() {
            @NonNull
            @Override
            public TxPowerServiceMockCallback.Builder<TxPowerServiceMockCallback> removeTxPowerLevel() {
                atomicBoolean.set(true);
                return super.removeTxPowerLevel();
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackkBuilder);
        assertEquals(baseBuilder, baseBuilder.removeTxPowerLevel());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_build_00001() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new LinkLossServiceMockCallback.Builder<>()
                    , new ImmediateAlertServiceMockCallback.Builder<>()
                    , new TxPowerServiceMockCallback.Builder<>())
                    .addImmediateAlertServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_NO_ALERT))
                    .addTxPowerLevel(new TxPowerLevel(0))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Alert Level data", exception.getMessage());
    }

    @Test
    public void test_build_00002() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new LinkLossServiceMockCallback.Builder<>()
                    , new ImmediateAlertServiceMockCallback.Builder<>()
                    , new TxPowerServiceMockCallback.Builder<>())
                    .addLinkLossServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_NO_ALERT))
                    .addImmediateAlertServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_NO_ALERT))
                    .addTxPowerLevel(new TxPowerLevel(0))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00101() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new LinkLossServiceMockCallback.Builder<>()
                    , new ImmediateAlertServiceMockCallback.Builder<>()
                    , new TxPowerServiceMockCallback.Builder<>())
                    .addLinkLossServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_NO_ALERT))
                    .addTxPowerLevel(new TxPowerLevel(0))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Alert Level data", exception.getMessage());
    }

    @Test
    public void test_build_00201() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new LinkLossServiceMockCallback.Builder<>()
                    , new ImmediateAlertServiceMockCallback.Builder<>()
                    , new TxPowerServiceMockCallback.Builder<>())
                    .addLinkLossServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_NO_ALERT))
                    .addImmediateAlertServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_NO_ALERT))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Tx Power Level data", exception.getMessage());
    }

    @Test
    public void test_build_00202() {
        ProximityProfileMockCallback callback = new BaseBuilder(ApplicationProvider.getApplicationContext()
                , new LinkLossServiceMockCallback.Builder<>()
                , new ImmediateAlertServiceMockCallback.Builder<>()
                , new TxPowerServiceMockCallback.Builder<>())
                .addLinkLossServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_NO_ALERT))
                .addImmediateAlertServiceAlertLevel(new AlertLevel(AlertLevel.ALERT_LEVEL_NO_ALERT))
                .addTxPowerLevel(new TxPowerLevel(0))
                .build();

        assertNotNull(callback);
    }


}
