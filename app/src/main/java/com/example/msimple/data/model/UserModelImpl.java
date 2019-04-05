package com.example.msimple.data.model;

import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import com.example.msimple.Delegate.LoginDelegate;
import com.example.msimple.data.vos.LoginUserVO;
import com.example.msimple.persistance.SimpleHabitDb;


public class UserModelImpl extends BaseModel implements UserModel {


    private static UserModelImpl userModel;
    SimpleHabitDb simpleHabitDb;
    private UserModelImpl(Context context){
        simpleHabitDb = SimpleHabitDb.getInstance(context);

    }

    public static UserModelImpl getInstance(Context context)
    {
        if (userModel == null) {
            userModel = new UserModelImpl(context);
        }
        return userModel;
    }


    @Override
    public void login(String emailOrPassword, String password, final LoginDelegate loginDelegate) {

        mRetrofit.login(emailOrPassword, password, new LoginDelegate() {
            @Override
            public void onSuccess(LoginUserVO loginUser) {
                loginDelegate.onSuccess(loginUser);
               long i = simpleHabitDb.getLoginDao().insertLoginUser(loginUser);
               Log.d("Database insert ",i+" Success");

            }

            @Override
            public void fail(String message) {
                loginDelegate.fail(message);
            }
        });
    }

    @Override
    public LoginUserVO getLoginUser() {
        return simpleHabitDb.getLoginDao().getLoginUser();
    }
}
