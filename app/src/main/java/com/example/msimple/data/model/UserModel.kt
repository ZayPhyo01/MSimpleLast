package com.example.msimple.data.model

import com.example.msimple.delegate.LoginDelegate
import com.example.msimple.data.vos.LoginUserVO


interface UserModel {

    val loginUser: LoginUserVO

    fun login(emailOrPassword: String, password: String, loginDelegate: LoginDelegate)

}
