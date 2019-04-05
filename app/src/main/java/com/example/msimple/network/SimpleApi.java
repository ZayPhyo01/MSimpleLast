package com.example.msimple.network;

import com.example.msimple.data.vos.CategoryVO;
import com.example.msimple.data.vos.CurrentVO;
import com.example.msimple.network.response.CategoryResponse;
import com.example.msimple.network.response.CurrentProgramResponse;
import com.example.msimple.network.response.LoginResponse;
import com.example.msimple.network.response.TopicResponse;
import com.example.msimple.utils.AppConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SimpleApi {

    @FormUrlEncoded
    @POST(AppConstants.CATEGORIES_URL)
    public Call<CategoryResponse> getCategory(@Field("page") int page, @Field("access_token") String accessToken);


    @FormUrlEncoded
    @POST(AppConstants.CURRENT_PROGRAM_URL)
    public Call<CurrentProgramResponse>getCurrentProgram(@Field("page") int page,@Field("access_token")String accessToken);

    @FormUrlEncoded
    @POST(AppConstants.TOPIC_URL)
    public Call<TopicResponse>getTopicResponse(@Field("page")int page,@Field("access_token")String accessToken);

    @FormUrlEncoded
    @POST(AppConstants.LOGIN_URL)
    Call<LoginResponse> login(@Field("phoneNo") String phoneNo,
                              @Field("password") String password);


}
