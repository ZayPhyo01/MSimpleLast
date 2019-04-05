package com.example.msimple.network;

import android.util.Log;

import com.example.msimple.Delegate.CategoryDelegate;
import com.example.msimple.Delegate.CurrentProgramDelegate;
import com.example.msimple.Delegate.LoginDelegate;
import com.example.msimple.Delegate.TopicDelegate;
import com.example.msimple.data.vos.CategoryVO;
import com.example.msimple.data.vos.CurrentVO;
import com.example.msimple.network.response.CategoryResponse;
import com.example.msimple.network.response.CurrentProgramResponse;
import com.example.msimple.network.response.LoginResponse;
import com.example.msimple.network.response.TopicResponse;
import com.example.msimple.utils.AppConstants;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDA implements DataAgent {


    private static RetrofitDA mRetrofitDA;
    private SimpleApi simpleApi;


    private RetrofitDA() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        simpleApi = retrofit.create(SimpleApi.class);

    }

    public static RetrofitDA getInstance() {
        if (mRetrofitDA == null) {
            mRetrofitDA = new RetrofitDA();

        }

        return mRetrofitDA;
    }


    @Override
    public void loadCategory(String access_token, String page, final CategoryDelegate categoryDelegate) {

        simpleApi.getCategory(1, access_token).enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                CategoryResponse categoryResponse = response.body();

                Log.d("Api", "success with " + categoryResponse.getCategoryVOS().get(0).getTitle());
                categoryDelegate.onSuccess(categoryResponse.getCategoryVOS());
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadTopic(String access_token, int page, final TopicDelegate topicDelegate) {

        simpleApi.getTopicResponse(page, access_token).enqueue(new Callback<TopicResponse>() {
            @Override
            public void onResponse(Call<TopicResponse> call, Response<TopicResponse> response) {
                topicDelegate.onSuccess(response.body().getTopicVOS());
            }

            @Override
            public void onFailure(Call<TopicResponse> call, Throwable t) {
                topicDelegate.fail("Network error");
            }
        });


    }

    @Override
    public void loadCurrentProgram(String access_token, int page, final CurrentProgramDelegate currentProgramDelegate) {
        simpleApi.getCurrentProgram(page, access_token).enqueue(new Callback<CurrentProgramResponse>() {
            @Override
            public void onResponse(Call<CurrentProgramResponse> call, Response<CurrentProgramResponse> response) {
                CurrentProgramResponse currentProgramResponse = response.body();
                currentProgramDelegate.onSuccess(currentProgramResponse.getCurrentVO());
            }

            @Override
            public void onFailure(Call<CurrentProgramResponse> call, Throwable t) {

                currentProgramDelegate.fail("Network fail");
            }
        });
    }

    @Override
    public void login(String phone, String password, final LoginDelegate loginDelegate) {

        simpleApi.login(phone,password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                loginDelegate.onSuccess(response.body().getLoginUser());
                Log.d("Login","Success");
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginDelegate.fail("Network fail");
                Log.d("Login","fail");

            }
        });

    }

    @Override
    public void register() {

    }
}
