package com.example.msimple.activitiy

import android.content.Context
import android.content.Intent
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AlertDialog
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem

import com.example.msimple.Delegate.OnClickItem
import com.example.msimple.R
import com.example.msimple.adapter.CategoryAdapter
import com.example.msimple.adapter.TopicsAdapter
import com.example.msimple.data.model.CategoryModel
import com.example.msimple.data.model.ICategoryModel
import com.example.msimple.data.model.ITopicModel
import com.example.msimple.data.model.TopicModel
import com.example.msimple.data.model.UserModelImpl
import com.example.msimple.data.vos.CategoryVO
import com.example.msimple.data.vos.ProgramVO
import com.example.msimple.data.vos.TopicVO
import com.example.msimple.view.pod.LoginUserViewPod

class MainActivity : BaseActivity(), OnClickItem {

    internal var viewPod: LoginUserViewPod
    internal var mCategoryList: RecyclerView
    internal var mCategoryModel: CategoryModel
    internal var categoryAdapter: CategoryAdapter
    internal var topicsAdapter: TopicsAdapter
    internal var topicModel: TopicModel
    internal var mTopicList: RecyclerView
    internal var bottomNavigationView: BottomNavigationView
    internal var userModel: UserModelImpl
    internal var alertDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mCategoryModel = CategoryModel.getInstance()
        categoryAdapter = CategoryAdapter(this)
        topicModel = TopicModel.getInstance()
        topicsAdapter = TopicsAdapter()
        mTopicList = findViewById(R.id.rv_topics)
        mTopicList.adapter = topicsAdapter
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        mTopicList.layoutManager = LinearLayoutManager(this)
        mCategoryList = findViewById(R.id.rv_programs)
        mCategoryList.adapter = categoryAdapter
        val layoutManager = LinearLayoutManager(this)
        mCategoryList.layoutManager = layoutManager
        loadFromModel()
        mTopicList.isNestedScrollingEnabled = false
        mCategoryList.isNestedScrollingEnabled = false
        userModel = UserModelImpl.getInstance(this)

        Log.d("UserModel", userModel.loginUser.email)
        viewPod = LoginUserViewPod(this@MainActivity)


        alertDialog = AlertDialog.Builder(this@MainActivity)
                .setTitle("User Profile")
                .setView(LayoutInflater.from(this).inflate(R.layout.view_pod_login_user, null, false))
                .create()
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId
            when (id) {
                R.id.action_home -> Log.d("Now you ", "at home")
                R.id.action_profile ->


                    alertDialog.show()
                R.id.action_menu -> {
                }
            }
            true
        }


    }

    override fun onStart() {
        super.onStart()
        viewPod.setData(userModel.loginUser)
    }

    override fun onTap(programVO: ProgramVO) {
        Log.d("Pos : ", programVO.title + "")

        val intent = DetailActivity.newIntent(this)
        intent.putExtra("programId", programVO.programId)
        startActivity(intent)
    }

    fun loadFromModel() {
        mCategoryModel.getCategory(object : ICategoryModel.Response {
            override fun onSuccess(categoryVO: List<CategoryVO>) {
                Log.d("MainActivity", categoryVO[0].title)
                categoryAdapter.setNewData(categoryVO)
            }

            override fun onFail(message: String) {

            }
        })

        topicModel.getTopic(object : ITopicModel.Response {
            override fun onSuccess(topicVOS: List<TopicVO>) {
                Log.d("Topic list ", "size " + topicVOS.size)
                topicsAdapter.setNewData(topicVOS)
            }

            override fun onFail(message: String) {

            }
        })

    }

    companion object {


        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)


        }
    }
}
