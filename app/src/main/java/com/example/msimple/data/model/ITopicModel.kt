package com.example.msimple.data.model

import com.example.msimple.data.vos.CurrentVO
import com.example.msimple.data.vos.TopicVO

interface ITopicModel {

    fun getTopic(response: Response)

    interface Response {

        fun onSuccess(topicVOS: List<TopicVO>)
        fun onFail(message: String)

    }

}
