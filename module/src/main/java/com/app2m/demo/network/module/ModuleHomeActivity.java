package com.app2m.demo.network.module;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app2m.demo.network.module.databinding.ActivityModuleHomeBinding;

public class ModuleHomeActivity extends BaseActivity {
    private ActivityModuleHomeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_module_home);
    }
}
