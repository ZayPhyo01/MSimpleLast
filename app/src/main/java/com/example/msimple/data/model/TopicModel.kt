package com.example.msimple.data.model

import com.example.msimple.delegate.TopicDelegate
import com.example.msimple.data.vos.TopicVO
import com.example.msimple.utils.AppConstants

class TopicModel private constructor() : BaseModel(), ITopicModel {

    override fun getTopic(response: ITopicModel.Response) {

        mRetrofit.loadTopic(AppConstants.ACCESS_TOKEN, 1, object : TopicDelegate {
            override fun onSuccess(topicVOS: List<TopicVO>) {
                response.onSuccess(topicVOS)
            }

            override fun fail(message: String) {

            }
        })

    }

    companion object {

        private var mTopicModel: TopicModel? = null

        val instance: TopicModel
            get() {
                if (mTopicModel == null) {
                    mTopicModel = TopicModel()
                }

                return mTopicModel
            }
    }
}
