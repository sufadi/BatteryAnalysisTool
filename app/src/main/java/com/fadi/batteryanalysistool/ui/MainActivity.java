package com.fadi.batteryanalysistool.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.fadi.batteryanalysistool.R;
import com.fadi.batteryanalysistool.util.Constant;
import com.fadi.batteryanalysistool.util.ShareUtil;

public class MainActivity extends AppCompatActivity {

    private TextView tv_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initValue();
    }

    private void initView() {
        tv_info = (TextView) findViewById(R.id.tv_info);
    }

    private void initValue() {
        tv_info.setText(getVersionName() + "\n" + Constant.GITHUB_ADDR);
    }

    private String getVersionName() {
        ShareUtil mShareUtil = new ShareUtil(this);
        return  mShareUtil.getString(Constant.KEY_VERSION_NAME, "Happy!");
    }
}
