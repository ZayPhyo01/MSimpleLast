package com.example.msimple.data.model;

import com.example.msimple.Delegate.LoginDelegate;
import com.example.msimple.data.vos.LoginUserVO;


public interface UserModel {

    void login(String emailOrPassword, String password, LoginDelegate loginDelegate);

    LoginUserVO getLoginUser();

}
