package com.example.msimple.network

import android.util.Log

import com.example.msimple.delegate.CategoryDelegate
import com.example.msimple.delegate.CurrentProgramDelegate
import com.example.msimple.delegate.LoginDelegate
import com.example.msimple.delegate.TopicDelegate
import com.example.msimple.network.response.CategoryResponse
import com.example.msimple.network.response.CurrentProgramResponse
import com.example.msimple.network.response.LoginResponse
import com.example.msimple.network.response.TopicResponse
import com.example.msimple.utils.AppConstants

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitDA private constructor() : DataAgent {
    private val simpleApi: SimpleApi


    init {

        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        simpleApi = retrofit.create(SimpleApi::class.java)

    }


    override fun loadCategory(access_token: String, page: String, categoryDelegate: CategoryDelegate) {

        simpleApi.getCategory(1, access_token).enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                val categoryResponse = response.body()

                Log.d("Api", "success with " + categoryResponse!!.categoryVOS!![0].title!!)
                categoryDelegate.onSuccess(categoryResponse.categoryVOS!!)
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {

            }
        })
    }

    override fun loadTopic(access_token: String, page: Int, topicDelegate: TopicDelegate) {

        simpleApi.getTopicResponse(page, access_token).enqueue(object : Callback<TopicResponse> {
            override fun onResponse(call: Call<TopicResponse>, response: Response<TopicResponse>) {
                topicDelegate.onSuccess(response.body()!!.topicVOS!!)
            }

            override fun onFailure(call: Call<TopicResponse>, t: Throwable) {
                topicDelegate.fail("Network error")
            }
        })


    }

    override fun loadCurrentProgram(access_token: String, page: Int, currentProgramDelegate: CurrentProgramDelegate) {
        simpleApi.getCurrentProgram(page, access_token).enqueue(object : Callback<CurrentProgramResponse> {
            override fun onResponse(call: Call<CurrentProgramResponse>, response: Response<CurrentProgramResponse>) {
                val currentProgramResponse = response.body()
                currentProgramDelegate.onSuccess(currentProgramResponse!!.currentVO!!)
            }

            override fun onFailure(call: Call<CurrentProgramResponse>, t: Throwable) {

                currentProgramDelegate.fail("Network fail")
            }
        })
    }

    override fun login(phone: String, password: String, loginDelegate: LoginDelegate) {

        simpleApi.login(phone, password).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                loginDelegate.onSuccess(response.body()!!.loginUser!!)
                Log.d("Login", "Success")
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                loginDelegate.fail("Network fail")
                Log.d("Login", "fail")

            }
        })

    }

    override fun register() {

    }

    companion object {


        private var mRetrofitDA: RetrofitDA? = null

        val instance: RetrofitDA
            get() {
                if (mRetrofitDA == null) {
                    mRetrofitDA = RetrofitDA()

                }

                return mRetrofitDA
            }
    }
}
