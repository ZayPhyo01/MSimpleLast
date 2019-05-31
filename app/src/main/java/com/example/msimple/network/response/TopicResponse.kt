package com.example.msimple.network.response

import com.example.msimple.data.vos.TopicVO
import com.google.gson.annotations.SerializedName

class TopicResponse {

    @SerializedName("topics")
    var topicVOS: List<TopicVO>? = null
        internal set
}
