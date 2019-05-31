package com.example.msimple.delegate

import com.example.msimple.data.vos.CategoryVO

interface CategoryDelegate : BaseDelegate {

    fun onSuccess(categoryVO: List<CategoryVO>)

}
