package com.app2m.demo.network.module.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by CongHao on 2017/3/12.
 * E-mail: hao.cong@app2m.com
 */

public class OkHttpUtil {
    public static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
//                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
//                .addInterceptor(new SlpRequestInterceptor())
                .build();
    }
}
