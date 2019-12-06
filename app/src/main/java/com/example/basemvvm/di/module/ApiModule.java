package com.example.basemvvm.di.module;


import com.example.basemvvm.network.EndPoint;
import com.example.basemvvm.network.GoodToturialApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    @Provides
    OkHttpClient okHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.connectTimeout(30, TimeUnit.SECONDS);
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofit(OkHttpClient okHttpClient) {
        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(Date.class, new UTCDateTypeAdapter())
                .setLenient()
                .create();
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient);

    }

    @Provides
    @Singleton
    GoodToturialApi provideLanding(Retrofit.Builder builder) {
        return builder.baseUrl(EndPoint.BASE_URL).build().create(GoodToturialApi.class);
    }
}
