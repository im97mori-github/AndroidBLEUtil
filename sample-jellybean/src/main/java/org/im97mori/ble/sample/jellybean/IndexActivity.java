package org.im97mori.ble.sample.jellybean;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.BLELogUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IndexActivity extends Activity implements AdapterView.OnItemClickListener {

    private static class IndexAdapter extends ArrayAdapter<ActivityInfo> {

        private final LayoutInflater mLayoutInflater;

        IndexAdapter(Context context, List<ActivityInfo> list) {
            super(context, 0, list);
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        @NonNull
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = mLayoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            ActivityInfo activityInfo = getItem(position);
            if (activityInfo != null) {
                TextView textView = view.findViewById(android.R.id.text1);
                textView.setText(activityInfo.labelRes);
            }
            return view;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_index);

        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException e) {
            BLELogUtils.stackLog(e);
        }

        if (packageInfo != null) {
            ListView listView = findViewById(R.id.list);
            List<ActivityInfo> list = new ArrayList<>();
            for (ActivityInfo activityInfo : packageInfo.activities) {
                if (activityInfo.name.equals(CentralSampleActivity.class.getName())) {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        continue;
                    }
                }
                if (!activityInfo.name.substring(0, activityInfo.name.lastIndexOf('.')).equals(activityInfo.packageName)) {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                        continue;
                    }
                }
                if (!this.getClass().getName().equals(activityInfo.name)) {
                    list.add(activityInfo);
                }
            }
            Collections.reverse(list);
            listView.setAdapter(new IndexAdapter(this, list));
            listView.setOnItemClickListener(this);
        }
    }

    @Override
    protected void onDestroy() {
        BLEConnectionHolder.clearInstance();
        super.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ActivityInfo activityInfo = (ActivityInfo) parent.getItemAtPosition(position);

        ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        startActivity(intent);
    }
}
