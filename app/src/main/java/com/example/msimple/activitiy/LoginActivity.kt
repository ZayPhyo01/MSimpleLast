package com.example.msimple.activitiy

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

import com.example.msimple.Delegate.LoginDelegate
import com.example.msimple.R
import com.example.msimple.data.model.UserModelImpl
import com.example.msimple.data.vos.LoginUserVO

class LoginActivity : BaseActivity() {

    internal var email: EditText
    internal var password: EditText
    internal var login: Button
    internal var userModel: UserModelImpl


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login = findViewById(R.id.btn_login)
        email = findViewById(R.id.et_email_or_phone)
        password = findViewById(R.id.et_password)
        userModel = UserModelImpl.getInstance(this)

        if (userModel.loginUser != null) {
            Log.d("User email", userModel.loginUser.email)
            startActivity(MainActivity.newIntent(this))
            finish()
        }
        val progressDialog = ProgressDialog(this)
        login.setOnClickListener {
            progressDialog.show()
            val emailOrPhone = email.text.toString()
            val pass = password.text.toString()
            userModel.login(emailOrPhone, pass, object : LoginDelegate {
                override fun onSuccess(loginUser: LoginUserVO) {
                    progressDialog.cancel()
                    val intent = MainActivity.newIntent(this@LoginActivity)
                    startActivity(intent)
                    finish()
                }

                override fun fail(message: String) {

                    progressDialog.cancel()
                    Log.d("Login", "fail")
                }
            })
        }


    }


}
