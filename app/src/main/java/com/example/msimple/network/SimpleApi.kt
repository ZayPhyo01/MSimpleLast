package com.example.msimple.network

import com.example.msimple.data.vos.CategoryVO
import com.example.msimple.data.vos.CurrentVO
import com.example.msimple.network.response.CategoryResponse
import com.example.msimple.network.response.CurrentProgramResponse
import com.example.msimple.network.response.LoginResponse
import com.example.msimple.network.response.TopicResponse
import com.example.msimple.utils.AppConstants

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SimpleApi {

    @FormUrlEncoded
    @POST(AppConstants.CATEGORIES_URL)
    fun getCategory(@Field("page") page: Int, @Field("access_token") accessToken: String): Call<CategoryResponse>


    @FormUrlEncoded
    @POST(AppConstants.CURRENT_PROGRAM_URL)
    fun getCurrentProgram(@Field("page") page: Int, @Field("access_token") accessToken: String): Call<CurrentProgramResponse>

    @FormUrlEncoded
    @POST(AppConstants.TOPIC_URL)
    fun getTopicResponse(@Field("page") page: Int, @Field("access_token") accessToken: String): Call<TopicResponse>

    @FormUrlEncoded
    @POST(AppConstants.LOGIN_URL)
    fun login(@Field("phoneNo") phoneNo: String,
              @Field("password") password: String): Call<LoginResponse>


}
