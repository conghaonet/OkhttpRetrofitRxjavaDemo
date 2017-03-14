package com.app2m.demo.network.module.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by CongHao on 2017/3/12.
 * E-mail: hao.cong@app2m.com
 */

public class OkHttpUtil {
    private volatile static OkHttpUtil mInstance;
    private OkHttpClient mOkHttpClient;

    private OkHttpUtil() {
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
//                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
//                .addInterceptor(new SlpRequestInterceptor())
                .build();
    }

    public static OkHttpUtil getInstance() {
        if (mInstance == null) {
            synchronized(OkHttpUtil.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpUtil();
                }
            }
        }
        return mInstance;
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }
}
