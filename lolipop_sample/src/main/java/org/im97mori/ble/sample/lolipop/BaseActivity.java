package org.im97mori.ble.sample.lolipop;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

@SuppressWarnings({"SameReturnValue"})
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback {

    protected static final int REQUEST_PERMISSION_COARSE_LOCATION = 0;
    protected static final String FRAGMENT_TAG_ALERT_DIALOG = "FRAGMENT_TAG_ALERT_DIALOG";

    protected Button mGetPermissionButton;

    protected FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mFragmentManager = getSupportFragmentManager();

        mGetPermissionButton = findViewById(R.id.getPermissionButton);
        mGetPermissionButton.setOnClickListener(this);
    }

    abstract protected int getLayoutId();

    @Override
    protected void onResume() {
        super.onResume();

        hasPermission();
    }

    @Override
    public void onClick(View v) {
        if (R.id.getPermissionButton == v.getId()) {
            hasPermission();
        }
    }

    @Override
    public void onOk() {
        try {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCancel() {
        Fragment fragment = mFragmentManager.findFragmentByTag(FRAGMENT_TAG_ALERT_DIALOG);
        if (fragment instanceof AlertDialogFragment) {
            ((AlertDialogFragment) fragment).dismissAllowingStateLoss();
        }
    }

    protected boolean hasPermission() {
        boolean result = true;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (PackageManager.PERMISSION_DENIED == checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                result = false;
                if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                    if (mFragmentManager.findFragmentByTag(FRAGMENT_TAG_ALERT_DIALOG) == null) {
                        AlertDialogFragment fragment = new AlertDialogFragment();
                        fragment.show(mFragmentManager, FRAGMENT_TAG_ALERT_DIALOG);
                    }
                } else {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_PERMISSION_COARSE_LOCATION);
                }
            }
        }
        if (result) {
            mGetPermissionButton.setVisibility(View.GONE);
        } else {
            mGetPermissionButton.setVisibility(View.VISIBLE);
        }
        return result;
    }
}
