package com.example.msimple.data.model

import com.example.msimple.network.RetrofitDA

abstract class BaseModel {

    var mRetrofit: RetrofitDA

    init {

        mRetrofit = RetrofitDA.getInstance()
    }


}
