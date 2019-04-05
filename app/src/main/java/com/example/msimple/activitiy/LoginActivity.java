package com.example.msimple.activitiy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.msimple.Delegate.LoginDelegate;
import com.example.msimple.MainActivity;
import com.example.msimple.R;
import com.example.msimple.data.model.UserModel;
import com.example.msimple.data.model.UserModelImpl;
import com.example.msimple.data.vos.LoginUserVO;

public class LoginActivity extends BaseActivity {

    EditText email,password;
    Button login;
    UserModelImpl userModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.btn_login);
        email = findViewById(R.id.et_email_or_phone);
        password = findViewById(R.id.et_password);
        userModel = UserModelImpl.getInstance(this);

if(userModel.getLoginUser() !=null) {
    Log.d("User email", userModel.getLoginUser().getEmail());
    startActivity(MainActivity.newIntent(this));
    finish();
}
            final ProgressDialog progressDialog = new ProgressDialog(this);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    progressDialog.show();
                    String emailOrPhone = email.getText().toString();
                    String pass = password.getText().toString();
                    userModel.login(emailOrPhone, pass, new LoginDelegate() {
                        @Override
                        public void onSuccess(LoginUserVO loginUser) {
                            progressDialog.cancel();
                            Intent intent = MainActivity.newIntent(LoginActivity.this);
                            startActivity(intent);
                            finish();
                        }

                        @Override
                        public void fail(String message) {

                            progressDialog.cancel();
                            Log.d("Login", "fail");
                        }
                    });

                }
            });


        }



}
