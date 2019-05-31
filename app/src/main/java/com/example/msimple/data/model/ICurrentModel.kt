package com.example.msimple.data.model

import com.example.msimple.data.vos.CategoryVO
import com.example.msimple.data.vos.CurrentVO

interface ICurrentModel {

    fun getCurrentProgram(response: Response)


    interface Response {

        fun onSuccess(currentVO: CurrentVO)
        fun onFail(message: String)

    }
}
