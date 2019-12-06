package com.example.basemvvm.demo.di;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarah on 3/13/2018.
 */

public class Demo {

    @SerializedName("provincelist")
    public List<ProvinceModel> provincelist = new ArrayList<>();

    public class ProvinceModel {

        @SerializedName("id")
        public String id;

        @SerializedName("provincename")
        public String provincename;
    }

}
