package com.app2m.demo.network.module;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.app2m.demo.network.module.databinding.ActivityModuleHomeBinding;
import com.app2m.demo.network.module.request.Uris;
import com.app2m.demo.network.module.util.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ModuleHomeActivity extends BaseActivity {
    private ActivityModuleHomeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_module_home);
        getAsyncHttp();
    }

    private void getAsyncHttp() {
        Request.Builder requestBuilder = new Request.Builder().url(Uris.Gjj.COMMON_CODE);
        //可以省略，默认是GET请求
        requestBuilder.method("GET",null);
        Request request = requestBuilder.build();
        Call mcall= OkHttpUtil.buildClient().newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (null != response.cacheResponse()) {
                    String str = response.cacheResponse().toString();
                    Log.i("wangshu", "cache---" + str);
                } else {
                    String strBody = response.body().string();
                    String str = response.networkResponse().toString();
                    Log.i("wangshu", "network---" + str);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
