package com.example.msimple.network

import com.example.msimple.delegate.CategoryDelegate
import com.example.msimple.delegate.CurrentProgramDelegate
import com.example.msimple.delegate.LoginDelegate
import com.example.msimple.delegate.TopicDelegate

interface DataAgent {

    fun loadCategory(access_token: String, page: String, categoryDelegate: CategoryDelegate)
    fun loadTopic(access_token: String, page: Int, topicDelegate: TopicDelegate)
    fun loadCurrentProgram(access_token: String, page: Int, currentProgramDelegate: CurrentProgramDelegate)
    fun login(phone: String, password: String, loginDelegate: LoginDelegate)
    fun register()


}
