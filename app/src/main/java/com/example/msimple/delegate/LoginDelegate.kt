package com.example.msimple.delegate


import com.example.msimple.data.vos.LoginUserVO

interface LoginDelegate : BaseDelegate {

    fun onSuccess(loginUser: LoginUserVO)
}
