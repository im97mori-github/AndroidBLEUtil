package org.im97mori.ble.sample.jellybean;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Pair;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SuppressWarnings({"SameReturnValue", "WeakerAccess", "RedundantSuppression"})
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback {

    protected static final int REQUEST_PERMISSION_LOCATION = 0;
    protected static final String FRAGMENT_TAG_ALERT_DIALOG = "FRAGMENT_TAG_ALERT_DIALOG";
    protected static final String KEY_MODE = "KEY_MODE";
    protected static final String MODE_PERMISSION = "MODE_PERMISSION";
    protected static final String MODE_LOCATION = "MODE_LOCATION";

    protected ArrayAdapter<Pair<String, String>> mAdapter;
    protected ListView mListView;

    protected Button mGetPermissionButton;
    protected Button mEnableLocationButton;

    protected FragmentManager mFragmentManager;

    protected LocationManager mLocationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        mFragmentManager = getSupportFragmentManager();

        mGetPermissionButton = findViewById(R.id.getPermissionButton);
        mGetPermissionButton.setOnClickListener(this);
        mEnableLocationButton = findViewById(R.id.enableLocationButton);
        mEnableLocationButton.setOnClickListener(this);

        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
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
        } else if (R.id.enableLocationButton == v.getId()) {
            hasPermission();
        }
    }

    @Override
    public void onOk(@Nullable Bundle argument) {
        if (argument != null) {
            if (MODE_PERMISSION.equals(argument.getString(KEY_MODE))) {
                try {
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(Uri.parse("package:" + getPackageName()));
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (MODE_LOCATION.equals(argument.getString(KEY_MODE))) {
                try {
                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (PackageManager.PERMISSION_DENIED == checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                    || PackageManager.PERMISSION_DENIED == checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    || PackageManager.PERMISSION_DENIED == checkSelfPermission(Manifest.permission.ACCESS_BACKGROUND_LOCATION)) {
                result = false;
                if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION)
                        || shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)
                        || shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_BACKGROUND_LOCATION)) {
                    if (mFragmentManager.findFragmentByTag(FRAGMENT_TAG_ALERT_DIALOG) == null) {
                        Bundle bundle = new Bundle();
                        bundle.putString(KEY_MODE, MODE_PERMISSION);
                        AlertDialogFragment fragment = AlertDialogFragment.createInstance(getString(R.string.permission_message), bundle);
                        fragment.show(mFragmentManager, FRAGMENT_TAG_ALERT_DIALOG);
                    }
                } else {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION
                            , Manifest.permission.ACCESS_FINE_LOCATION
                            , Manifest.permission.ACCESS_BACKGROUND_LOCATION}, REQUEST_PERMISSION_LOCATION);
                }
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (PackageManager.PERMISSION_DENIED == checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                result = false;
                if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                    if (mFragmentManager.findFragmentByTag(FRAGMENT_TAG_ALERT_DIALOG) == null) {
                        Bundle bundle = new Bundle();
                        bundle.putString(KEY_MODE, MODE_PERMISSION);
                        AlertDialogFragment fragment = AlertDialogFragment.createInstance(getString(R.string.permission_message), bundle);
                        fragment.show(mFragmentManager, FRAGMENT_TAG_ALERT_DIALOG);
                    }
                } else {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_PERMISSION_LOCATION);
                }
            }
        }
        if (result) {
            mGetPermissionButton.setVisibility(View.GONE);

            if (mLocationManager == null) {
                result = false;
            } else {
                if (mLocationManager.getBestProvider(new Criteria(), true) == null) {
                    result = false;

                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_MODE, MODE_LOCATION);
                    AlertDialogFragment fragment = AlertDialogFragment.createInstance(getString(R.string.location_message), bundle);
                    fragment.show(mFragmentManager, FRAGMENT_TAG_ALERT_DIALOG);
                }
            }

            if (result) {
                mEnableLocationButton.setVisibility(View.GONE);
            } else {
                mEnableLocationButton.setVisibility(View.VISIBLE);
            }
        } else {
            mGetPermissionButton.setVisibility(View.VISIBLE);
            mEnableLocationButton.setVisibility(View.GONE);
        }
        return result;
    }


    protected void addRow(@NonNull String prefix, @Nullable Object result) {
        String text;
        if (result == null) {
            text = prefix + "\nnull";
        } else {
            text = prefix + "\n" + result.toString();
        }
        mAdapter.add(Pair.create(new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US).format(new Date()), text));
        mListView.smoothScrollToPosition(mAdapter.getCount());
        updateLayout();
    }

    abstract protected void updateLayout();

}
