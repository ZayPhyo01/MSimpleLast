package com.example.msimple.activitiy;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;

import com.example.msimple.Delegate.OnClickItem;
import com.example.msimple.R;
import com.example.msimple.adapter.CategoryAdapter;
import com.example.msimple.adapter.TopicsAdapter;
import com.example.msimple.data.model.CategoryModel;
import com.example.msimple.data.model.ICategoryModel;
import com.example.msimple.data.model.ITopicModel;
import com.example.msimple.data.model.TopicModel;
import com.example.msimple.data.model.UserModelImpl;
import com.example.msimple.data.vos.CategoryVO;
import com.example.msimple.data.vos.ProgramVO;
import com.example.msimple.data.vos.TopicVO;
import com.example.msimple.view.pod.LoginUserViewPod;

import java.util.List;

public class MainActivity extends BaseActivity implements OnClickItem {

    LoginUserViewPod viewPod;
    RecyclerView mCategoryList;
    CategoryModel mCategoryModel;
    CategoryAdapter categoryAdapter;
    TopicsAdapter topicsAdapter;
    TopicModel topicModel;
    RecyclerView mTopicList;
    BottomNavigationView bottomNavigationView;
    UserModelImpl userModel;
    AlertDialog alertDialog;


    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCategoryModel = CategoryModel.getInstance();
        categoryAdapter = new CategoryAdapter(this);
        topicModel = TopicModel.getInstance();
        topicsAdapter = new TopicsAdapter();
        mTopicList = findViewById(R.id.rv_topics);
        mTopicList.setAdapter(topicsAdapter);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        mTopicList.setLayoutManager(new LinearLayoutManager(this));
        mCategoryList = findViewById(R.id.rv_programs);
        mCategoryList.setAdapter(categoryAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mCategoryList.setLayoutManager(layoutManager);
        loadFromModel();
        mTopicList.setNestedScrollingEnabled(false);
        mCategoryList.setNestedScrollingEnabled(false);
        userModel = UserModelImpl.getInstance(this);

        Log.d("UserModel", userModel.getLoginUser().getEmail());
       viewPod  = new LoginUserViewPod(MainActivity.this);


        alertDialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("User Profile")
                .setView(LayoutInflater.from(this).inflate(R.layout.view_pod_login_user, null, false))
                .create();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.action_home:
                        Log.d("Now you ", "at home");
                        break;
                    case R.id.action_profile:


                        alertDialog.show();

                        break;
                    case R.id.action_menu:
                        break;

                }
                return true;
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        viewPod.setData(userModel.getLoginUser());
    }

    @Override
    public void onTap(ProgramVO programVO) {
        Log.d("Pos : ", programVO.getTitle() + "");

        Intent intent = DetailActivity.newIntent(this);
        intent.putExtra("programId",programVO.getProgramId());
        startActivity(intent);
    }

    public void loadFromModel() {
        mCategoryModel.getCategory(new ICategoryModel.Response() {
            @Override
            public void onSuccess(List<CategoryVO> categoryVO) {
                Log.d("MainActivity", categoryVO.get(0).getTitle());
                categoryAdapter.setNewData(categoryVO);
            }

            @Override
            public void onFail(String message) {

            }
        });

        topicModel.getTopic(new ITopicModel.Response() {
            @Override
            public void onSuccess(List<TopicVO> topicVOS) {
                Log.d("Topic list ", "size " + topicVOS.size());
                topicsAdapter.setNewData(topicVOS);
            }

            @Override
            public void onFail(String message) {

            }
        });

    }
}
