package com.example.msimple.data.model

import com.example.msimple.data.vos.CategoryVO
import com.example.msimple.data.vos.ProgramVO

interface ICategoryModel {
    fun getCategory(response: Response)
    fun getProgramVO(id: String): ProgramVO

    interface Response {

        fun onSuccess(categoryVO: List<CategoryVO>)
        fun onFail(message: String)

    }
}
