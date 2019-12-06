package com.example.basemvvm.network;


import com.example.basemvvm.view.mvvm_test.Demo;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;


public class AppRestManager implements RestManager {

    @SuppressWarnings("WeakerAccess")
    @Inject
    public AppRestManager() {
    }

    @SuppressWarnings("WeakerAccess")
    @Inject
    GoodToturialApi goodToturialApi;


    @Override
    public Observable<Response<Demo>> getState(String s1, String s2, String s3, String s4) {
        return goodToturialApi.getState(s1,s2,s3,s4);
    }

//    @Override
//    public Observable<Response<City>> getCity(String id) {
//        return goodToturialApi.postCitiesList(id);
//    }

//    @Override
//    public Observable<CommonResponse> postAttachment(String expireDate,
//                                                     String filePath,
//                                                     int stepCode, int attachmentType, String mobileNumber
//    ) {
//        File file = new File(filePath);
//        RequestBody upload = RequestBody.create(MediaType.parse("image/" + Tools.getFileExtension(file)), file);
//        MultipartBody.Part uploadPart = MultipartBody.Part.createFormData("upload", file.getName(), upload);
//        RequestBody ed = RequestBody.create(MediaType.parse("text/plain"), expireDate);
//        RequestBody mn = RequestBody.create(MediaType.parse("text/plain"), mobileNumber);
//        RequestBody sc = RequestBody.create(MediaType.parse("text/plain"), String.valueOf(stepCode));
//        RequestBody at = RequestBody.create(MediaType.parse("text/plain"), String.valueOf(attachmentType));
//        return goodToturialApi.postAttachment(ed, mn, uploadPart, sc, at);
//    }

}
