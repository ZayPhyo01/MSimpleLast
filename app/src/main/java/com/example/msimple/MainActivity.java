package com.example.msimple;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.example.msimple.Delegate.OnClickItem;
import com.example.msimple.activitiy.BaseActivity;
import com.example.msimple.adapter.CategoryAdapter;
import com.example.msimple.adapter.TopicsAdapter;
import com.example.msimple.data.model.CategoryModel;
import com.example.msimple.data.model.ICategoryModel;
import com.example.msimple.data.model.ITopicModel;
import com.example.msimple.data.model.TopicModel;
import com.example.msimple.data.model.UserModelImpl;
import com.example.msimple.data.vos.CategoryVO;
import com.example.msimple.data.vos.TopicVO;
import com.example.msimple.view.pod.LoginUserViewPod;

import java.util.List;

public class MainActivity extends BaseActivity implements OnClickItem {

    RecyclerView mCategoryList;
    CategoryModel mCategoryModel;
    CategoryAdapter categoryAdapter;
    TopicsAdapter topicsAdapter;
    TopicModel topicModel;
    RecyclerView mTopicList;
    BottomNavigationView bottomNavigationView;
    UserModelImpl userModel;



    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        return intent;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCategoryModel = CategoryModel.getInstance();
        categoryAdapter = new CategoryAdapter();
        topicModel  = TopicModel.getInstance();
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

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

               LoginUserViewPod viewPod = new LoginUserViewPod(MainActivity.this);

                int id = menuItem.getItemId();
                switch (id){
                    case R.id.action_home:
                        Log.d("Now you ","at home");
                        break;
                    case R.id.action_profile:

                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                                .create();
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
    public void onTap(int i) {

    }

    public void loadFromModel(){
        mCategoryModel.getCategory(new ICategoryModel.Response() {
            @Override
            public void onSuccess(List<CategoryVO> categoryVO) {
                Log.d("MainActivity",categoryVO.get(0).getTitle());
                categoryAdapter.setNewData(categoryVO);
            }

            @Override
            public void onFail(String message) {

            }
        });

        topicModel.getTopic(new ITopicModel.Response() {
            @Override
            public void onSuccess(List<TopicVO> topicVOS) {
                Log.d("Topic list ","size "+topicVOS.size());
            topicsAdapter.setNewData(topicVOS);
            }

            @Override
            public void onFail(String message) {

            }
        });

    }
}
