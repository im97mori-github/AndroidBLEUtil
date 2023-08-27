package org.im97mori.ble.characteristic.u2a17;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** @noinspection DataFlowIssue*/
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TimeUpdateStateAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_SUCCESSFUL;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertEquals(TimeUpdateState.CURRENT_STATE_IDLE, result1.getCurrentState());
        assertTrue(result1.isCurrentStateIdle());
        assertFalse(result1.isCurrentStateUpdatePending());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_UPDATE_PENDING;
        data[ 1] = TimeUpdateState.RESULT_SUCCESSFUL;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertEquals(TimeUpdateState.CURRENT_STATE_UPDATE_PENDING, result1.getCurrentState());
        assertFalse(result1.isCurrentStateIdle());
        assertTrue(result1.isCurrentStateUpdatePending());
    }

    @Test
    public void test_constructor101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_SUCCESSFUL;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertEquals(TimeUpdateState.RESULT_SUCCESSFUL, result1.getResult());
        assertTrue(result1.isResultSuccessful());
        assertFalse(result1.isResultCanceled());
        assertFalse(result1.isResultNoConnectionToReference());
        assertFalse(result1.isResultReferenceRespondedWithAnError());
        assertFalse(result1.isResultTimeout());
        assertFalse(result1.isResultUpdateNotAttemptedAfterReset());
    }

    @Test
    public void test_constructor102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_CANCELED;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertEquals(TimeUpdateState.RESULT_CANCELED, result1.getResult());
        assertFalse(result1.isResultSuccessful());
        assertTrue(result1.isResultCanceled());
        assertFalse(result1.isResultNoConnectionToReference());
        assertFalse(result1.isResultReferenceRespondedWithAnError());
        assertFalse(result1.isResultTimeout());
        assertFalse(result1.isResultUpdateNotAttemptedAfterReset());
    }

    @Test
    public void test_constructor103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_NO_CONNECTION_TO_REFERENCE;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertEquals(TimeUpdateState.RESULT_NO_CONNECTION_TO_REFERENCE, result1.getResult());
        assertFalse(result1.isResultSuccessful());
        assertFalse(result1.isResultCanceled());
        assertTrue(result1.isResultNoConnectionToReference());
        assertFalse(result1.isResultReferenceRespondedWithAnError());
        assertFalse(result1.isResultTimeout());
        assertFalse(result1.isResultUpdateNotAttemptedAfterReset());
    }

    @Test
    public void test_constructor104() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_REFERENCE_RESPONDED_WITH_AN_ERROR;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertEquals(TimeUpdateState.RESULT_REFERENCE_RESPONDED_WITH_AN_ERROR, result1.getResult());
        assertFalse(result1.isResultSuccessful());
        assertFalse(result1.isResultCanceled());
        assertFalse(result1.isResultNoConnectionToReference());
        assertTrue(result1.isResultReferenceRespondedWithAnError());
        assertFalse(result1.isResultTimeout());
        assertFalse(result1.isResultUpdateNotAttemptedAfterReset());
    }

    @Test
    public void test_constructor105() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_TIMEOUT;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertEquals(TimeUpdateState.RESULT_TIMEOUT, result1.getResult());
        assertFalse(result1.isResultSuccessful());
        assertFalse(result1.isResultCanceled());
        assertFalse(result1.isResultNoConnectionToReference());
        assertFalse(result1.isResultReferenceRespondedWithAnError());
        assertTrue(result1.isResultTimeout());
        assertFalse(result1.isResultUpdateNotAttemptedAfterReset());
    }

    @Test
    public void test_constructor106() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_UPDATE_NOT_ATTEMPTED_AFTER_RESET;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertEquals(TimeUpdateState.RESULT_UPDATE_NOT_ATTEMPTED_AFTER_RESET, result1.getResult());
        assertFalse(result1.isResultSuccessful());
        assertFalse(result1.isResultCanceled());
        assertFalse(result1.isResultNoConnectionToReference());
        assertFalse(result1.isResultReferenceRespondedWithAnError());
        assertFalse(result1.isResultTimeout());
        assertTrue(result1.isResultUpdateNotAttemptedAfterReset());
    }

    @Test
    public void test_constructor107() {
        int currentState = 1;
        int result = 2;

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(currentState, result);
        assertEquals(currentState, result1.getCurrentState());
        assertEquals(result, result1.getResult());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_SUCCESSFUL;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCurrentState(), result1.getCurrentState());
        assertEquals(result2.getResult(), result1.getResult());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_UPDATE_PENDING;
        data[ 1] = TimeUpdateState.RESULT_SUCCESSFUL;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCurrentState(), result1.getCurrentState());
        assertEquals(result2.getResult(), result1.getResult());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_SUCCESSFUL;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCurrentState(), result1.getCurrentState());
        assertEquals(result2.getResult(), result1.getResult());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_CANCELED;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCurrentState(), result1.getCurrentState());
        assertEquals(result2.getResult(), result1.getResult());
    }

    @Test
    public void test_parcelable005() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_NO_CONNECTION_TO_REFERENCE;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCurrentState(), result1.getCurrentState());
        assertEquals(result2.getResult(), result1.getResult());
    }

    @Test
    public void test_parcelable006() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_REFERENCE_RESPONDED_WITH_AN_ERROR;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCurrentState(), result1.getCurrentState());
        assertEquals(result2.getResult(), result1.getResult());
    }

    @Test
    public void test_parcelable007() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_TIMEOUT;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCurrentState(), result1.getCurrentState());
        assertEquals(result2.getResult(), result1.getResult());
    }

    @Test
    public void test_parcelable008() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_UPDATE_NOT_ATTEMPTED_AFTER_RESET;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCurrentState(), result1.getCurrentState());
        assertEquals(result2.getResult(), result1.getResult());
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_SUCCESSFUL;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_UPDATE_PENDING;
        data[ 1] = TimeUpdateState.RESULT_SUCCESSFUL;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_SUCCESSFUL;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_CANCELED;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_NO_CONNECTION_TO_REFERENCE;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_REFERENCE_RESPONDED_WITH_AN_ERROR;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_TIMEOUT;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_UPDATE_NOT_ATTEMPTED_AFTER_RESET;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_SUCCESSFUL;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_UPDATE_PENDING;
        data[ 1] = TimeUpdateState.RESULT_SUCCESSFUL;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_SUCCESSFUL;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_CANCELED;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_NO_CONNECTION_TO_REFERENCE;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_REFERENCE_RESPONDED_WITH_AN_ERROR;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_TIMEOUT;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = TimeUpdateState.CURRENT_STATE_IDLE;
        data[ 1] = TimeUpdateState.RESULT_UPDATE_NOT_ATTEMPTED_AFTER_RESET;
        //@formatter:on

        TimeUpdateStateAndroid result1 = new TimeUpdateStateAndroid(data);
        TimeUpdateStateAndroid result2 = TimeUpdateStateAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
