package com.example.basemvvm.network;

import com.example.basemvvm.view.demo.Demo;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GoodToturialApi {

    @FormUrlEncoded
    @POST("getInitInfo")
    Observable<Response<Demo>> getState(@Field("ApiKey") String apiKey,
                                        @Field("AppPlatform") String appPlatform,
                                        @Field ("AppVersion") String AppVersion,
                                        @Field ("UsertokenIfExist") String UsertokenIfExist);

//    @FormUrlEncoded
//    @POST("GetCities")
//    Observable<Response<City>> postCitiesList(
//            @Field("StateId") String id
//    );



}
