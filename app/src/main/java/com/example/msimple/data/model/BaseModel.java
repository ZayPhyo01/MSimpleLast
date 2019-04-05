package com.example.msimple.data.model;

import com.example.msimple.network.RetrofitDA;

public abstract class BaseModel {

    public RetrofitDA mRetrofit;

    public BaseModel(){

        mRetrofit = RetrofitDA.getInstance();
    }


}
