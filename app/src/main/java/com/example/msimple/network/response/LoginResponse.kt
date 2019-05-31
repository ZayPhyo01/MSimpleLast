package com.example.msimple.network.response

import com.example.msimple.data.vos.LoginUserVO
import com.google.gson.annotations.SerializedName

class LoginResponse {

    @SerializedName("login_user")
    val loginUser: LoginUserVO? = null
}
