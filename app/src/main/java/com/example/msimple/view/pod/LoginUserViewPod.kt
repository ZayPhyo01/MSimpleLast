package com.example.msimple.view.pod

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView


import com.example.msimple.R
import com.example.msimple.data.model.UserModel
import com.example.msimple.data.model.UserModelImpl
import com.example.msimple.data.vos.LoginUserVO

import butterknife.BindView
import butterknife.ButterKnife

class LoginUserViewPod : RelativeLayout {

    @BindView(R.id.iv_login_user_bg)
    internal var ivLoginUserBg: ImageView? = null

    @BindView(R.id.iv_login_user)
    internal var ivLoginUser: ImageView? = null

    @BindView(R.id.tv_name)
    internal var tvName: TextView? = null

    @BindView(R.id.tv_phone_no)
    internal var tvPhoneNo: TextView? = null

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    override fun onFinishInflate() {
        super.onFinishInflate()
        ButterKnife.bind(this, this)
        tvName!!.text = UserModelImpl.getInstance(context).loginUser.email
        tvPhoneNo!!.text = UserModelImpl.getInstance(context).loginUser.name
    }

    fun setData(loginUser: LoginUserVO) {


    }
}
