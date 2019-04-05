package com.example.msimple.network.response;

import com.example.msimple.data.vos.LoginUserVO;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("login_user")
    private LoginUserVO loginUser;

    public LoginUserVO getLoginUser() {
        return loginUser;
    }
}
