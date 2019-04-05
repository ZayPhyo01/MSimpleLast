package com.example.msimple.Delegate;


import com.example.msimple.data.vos.LoginUserVO;

public interface LoginDelegate extends BaseDelegate {

    void onSuccess(LoginUserVO loginUser);
}
