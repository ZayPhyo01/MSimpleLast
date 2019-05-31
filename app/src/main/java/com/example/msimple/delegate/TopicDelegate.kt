package com.example.msimple.delegate

import com.example.msimple.data.vos.TopicVO

interface TopicDelegate : BaseDelegate {
    fun onSuccess(topicVOS: List<TopicVO>)
}
