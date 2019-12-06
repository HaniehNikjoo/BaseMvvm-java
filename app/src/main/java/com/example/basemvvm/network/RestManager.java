package com.example.basemvvm.network;


import com.example.basemvvm.view.mvvm_test.Demo;

import io.reactivex.Observable;
import retrofit2.Response;

public interface RestManager {

    Observable<Response<Demo>> getState(String s1, String s2, String s3, String s4);

//    Observable<Response<City>> getCity(String id);
//
//    Observable<CommonResponse> postAttachment(String expireDate,
//                                              String filePath,
//                                              int stepCode, int attachmentType, String mobileNumber);



}
