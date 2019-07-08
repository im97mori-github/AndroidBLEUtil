package org.im97mori.ble.sample.kitkat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import org.im97mori.ble.sample.kitkat.R;

public class AlertDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    public interface AlertDialogFragmentCallback {
        void onOk();

        void onCancel();
    }

    private AlertDialogFragmentCallback mAlertDialogFragmentCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof AlertDialogFragmentCallback) {
            mAlertDialogFragmentCallback = (AlertDialogFragmentCallback) context;
        } else {
            throw new ClassCastException(context.toString()
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
        builder.setMessage(R.string.permission_message);
        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        try {
            if (mAlertDialogFragmentCallback != null) {
                if (DialogInterface.BUTTON_POSITIVE == which) {
                    mAlertDialogFragmentCallback.onOk();
                } else if (DialogInterface.BUTTON_NEGATIVE == which) {
                    mAlertDialogFragmentCallback.onCancel();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
