package com.example.msimple.data.model

import android.content.Context
import android.util.Log

import com.example.msimple.delegate.LoginDelegate
import com.example.msimple.data.vos.LoginUserVO
import com.example.msimple.persistance.SimpleHabitDb


class UserModelImpl private constructor(context: Context) : BaseModel(), UserModel {
    internal var simpleHabitDb: SimpleHabitDb

    override val loginUser: LoginUserVO
        get() = simpleHabitDb.loginDao.loginUser

    init {
        simpleHabitDb = SimpleHabitDb.getInstance(context)

    }


    override fun login(emailOrPassword: String, password: String, loginDelegate: LoginDelegate) {

        mRetrofit.login(emailOrPassword, password, object : LoginDelegate {
            override fun onSuccess(loginUser: LoginUserVO) {
                loginDelegate.onSuccess(loginUser)
                val i = simpleHabitDb.loginDao.insertLoginUser(loginUser)
                Log.d("Database insert ", "$i Success")

            }

            override fun fail(message: String) {
                loginDelegate.fail(message)
            }
        })
    }

    companion object {


        private var userModel: UserModelImpl? = null

        fun getInstance(context: Context): UserModelImpl {
            if (userModel == null) {
                userModel = UserModelImpl(context)
            }
            return userModel
        }
    }
}
