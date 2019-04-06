package com.example.msimple.view.pod;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.msimple.R;
import com.example.msimple.data.model.UserModel;
import com.example.msimple.data.model.UserModelImpl;
import com.example.msimple.data.vos.LoginUserVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginUserViewPod extends RelativeLayout {

    @BindView(R.id.iv_login_user_bg)
    ImageView ivLoginUserBg;

    @BindView(R.id.iv_login_user)
    ImageView ivLoginUser;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_phone_no)
    TextView tvPhoneNo;

    public LoginUserViewPod(Context context) {
        super(context);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
        tvName.setText(UserModelImpl.getInstance(getContext()).getLoginUser().getEmail());
        tvPhoneNo.setText(UserModelImpl.getInstance(getContext()).getLoginUser().getName());
    }

    public void setData(LoginUserVO loginUser) {



    }
}
