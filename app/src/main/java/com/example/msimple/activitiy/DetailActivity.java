package com.example.msimple.activitiy;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.msimple.R;
import com.example.msimple.adapter.SessionAdapter;
import com.example.msimple.data.model.CategoryModel;
import com.example.msimple.data.vos.ProgramVO;


public class DetailActivity extends BaseActivity {


    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, DetailActivity.class);
        return intent;


    }
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView ivBackground,ivLecturer;
    private TextView tvDescription, tvReadMore,tvLecturerName;
    private  boolean expandable = true;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // hide the toolbar

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for back arrow
        getSupportActionBar().setDisplayShowHomeEnabled(true); // for back arrow



        collapsingToolbarLayout = findViewById(R.id.collapsingToolBar);
        tvDescription = findViewById(R.id.tv_description);


        String id = getIntent().getStringExtra("programId");
        CategoryModel categoryModel = CategoryModel.getInstance();
        ProgramVO programsVO = categoryModel.getProgramVO(id);


        collapsingToolbarLayout.setTitle(programsVO.getTitle());
        tvDescription.setText(programsVO.getDescription());


        recyclerView = findViewById(R.id.rv_sessions);
        SessionAdapter sessionsAdapter = new SessionAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(sessionsAdapter);
        sessionsAdapter.setNewData(programsVO.getSessionsList());

        tvDescription = findViewById(R.id.tv_description);
        tvReadMore = findViewById(R.id.tv_read_more);

        tvDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Toast.makeText(getApplicationContext(), "Description", Toast.LENGTH_SHORT).show();
            }
        });


        tvReadMore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Readmore", Toast.LENGTH_SHORT).show();



            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
