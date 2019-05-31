package com.example.msimple.network.response

import com.example.msimple.data.vos.CategoryVO
import com.google.gson.annotations.SerializedName

class CategoryResponse {

    @SerializedName("categoriesPrograms")
    var categoryVOS: List<CategoryVO>? = null
        internal set
}
