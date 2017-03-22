package com.app2m.demo.network.module;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.app2m.demo.network.module.databinding.ActivityOkHttpBinding;
import com.app2m.demo.network.module.request.OkhttpRequest;
import com.app2m.demo.network.module.request.Uris;
import com.app2m.demo.network.module.util.OkHttpUtil;

import java.io.IOException;
import java.util.logging.Logger;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {
    public final ObservableField<String> resultField = new ObservableField<>();
    private ActivityOkHttpBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_ok_http);
        mBinding.setActivity(this);
        resultField.set("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    public void sendRequest(View view) {
        resultField.set("");
        getAsyncHttp();
    }
    private void getAsyncHttp() {
        Request.Builder requestBuilder = new Request.Builder().url(Uris.Gjj.COMMON_CODE+"a");
        //可以省略，默认是GET请求
        requestBuilder.method("GET",null);
        Request request = requestBuilder.build();
        Call mcall= OkHttpUtil.getInstance().getOkHttpClient().newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                resultField.set(e.getMessage());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.code() != 200) {
                    IOException exception = new IOException(response.message());
                    onFailure(call, exception);
                } else {
                    if (null != response.cacheResponse()) {
                        String str = response.cacheResponse().toString();
                        Log.i("wangshu", "cache---" + str);
                    } else {
                        String strBody = response.body().string();
                        resultField.set(strBody);
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
            }
        });
    }
}
