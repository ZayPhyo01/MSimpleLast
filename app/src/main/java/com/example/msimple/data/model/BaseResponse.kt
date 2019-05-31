package com.example.msimple.data.model

import com.example.msimple.data.vos.CategoryVO

interface BaseResponse<T> {

    fun onSuccess(categoryVO: List<T>)
    fun onFail(message: String)


}
