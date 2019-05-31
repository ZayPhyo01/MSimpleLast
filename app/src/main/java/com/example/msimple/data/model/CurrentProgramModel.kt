package com.example.msimple.data.model

import com.example.msimple.delegate.CurrentProgramDelegate
import com.example.msimple.data.vos.CurrentVO
import com.example.msimple.utils.AppConstants

class CurrentProgramModel private constructor() : BaseModel(), ICurrentModel {


    override fun getCurrentProgram(response: ICurrentModel.Response) {
        mRetrofit.loadCurrentProgram(AppConstants.ACCESS_TOKEN, 1, object : CurrentProgramDelegate {
            override fun onSuccess(currentVOS: CurrentVO) {
                response.onSuccess(currentVOS)
            }

            override fun fail(message: String) {
                response.onFail(message)
            }
        })
    }

    companion object {

        private var mCurrentProgramModel: CurrentProgramModel? = null

        val instance: CurrentProgramModel
            get() {
                if (mCurrentProgramModel == null) {
                    mCurrentProgramModel = CurrentProgramModel()
                }

                return mCurrentProgramModel
            }
    }
}
