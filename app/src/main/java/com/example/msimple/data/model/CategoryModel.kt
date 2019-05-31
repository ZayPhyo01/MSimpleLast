package com.example.msimple.data.model

import com.example.msimple.delegate.CategoryDelegate
import com.example.msimple.data.vos.CategoryVO
import com.example.msimple.data.vos.ProgramVO
import com.example.msimple.utils.AppConstants

import java.util.HashMap

class CategoryModel private constructor() : BaseModel(), ICategoryModel {

    internal var mData: MutableMap<String, ProgramVO>

    init {
        mData = HashMap()
    }

    override fun getCategory(response: ICategoryModel.Response) {

        mRetrofit.loadCategory(AppConstants.ACCESS_TOKEN, "1", object : CategoryDelegate {
            override fun onSuccess(categoryVO: List<CategoryVO>) {
                response.onSuccess(categoryVO)
                for (i in categoryVO.indices) {
                    for (j in 0 until categoryVO[i].programs.size) {
                        mData[categoryVO[i].programs[j].programId] = categoryVO[i].programs[j]
                    }
                }
            }

            override fun fail(message: String) {

                response.onFail(message)
            }
        })

    }

    override fun getProgramVO(id: String): ProgramVO? {

        return mData[id]
    }

    companion object {
        private var mCategoryModel: CategoryModel? = null

        val instance: CategoryModel
            get() {
                if (mCategoryModel == null) {
                    mCategoryModel = CategoryModel()
                }
                return mCategoryModel
            }
    }
}
