package org.im97mori.ble.sample.lolipop;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

@SuppressWarnings({"WeakerAccess", "RedundantSuppression"})
public class AlertDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    private static final String KEY_MESSAGE = "KEY_MESSAGE";
    private static final String KEY_ARGUMENT = "KEY_ARGUMENT";

    public static AlertDialogFragment createInstance(@NonNull String message, @Nullable Bundle argument) {
        AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MESSAGE, message);
        if (argument != null) {
            bundle.putBundle(KEY_ARGUMENT, argument);
        }
        alertDialogFragment.setArguments(bundle);
        return alertDialogFragment;
    }

    public interface AlertDialogFragmentCallback {
        void onOk(@Nullable Bundle argument);

        void onCancel();
    }

    private AlertDialogFragmentCallback mAlertDialogFragmentCallback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof AlertDialogFragmentCallback) {
            mAlertDialogFragmentCallback = (AlertDialogFragmentCallback) context;
        } else {
            throw new ClassCastException(context
                    + " must implement "
                    + AlertDialogFragmentCallback.class.getCanonicalName());
        }
    }

    @Override
    public void onDetach() {
        mAlertDialogFragmentCallback = null;
        super.onDetach();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setPositiveButton(android.R.string.ok, this);
        builder.setNegativeButton(android.R.string.cancel, this);
        Bundle argument = getArguments();
        if (argument != null) {
            builder.setMessage(argument.getString(KEY_MESSAGE));
        }
        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        try {
            if (mAlertDialogFragmentCallback != null) {
                if (DialogInterface.BUTTON_POSITIVE == which) {
                    Bundle argument = getArguments();
                    mAlertDialogFragmentCallback.onOk(argument == null ? null : argument.getBundle(KEY_ARGUMENT));
                } else if (DialogInterface.BUTTON_NEGATIVE == which) {
                    mAlertDialogFragmentCallback.onCancel();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
