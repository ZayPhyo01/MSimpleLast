package com.example.msimple.activitiy

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewTreeObserver
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.example.msimple.R
import com.example.msimple.adapter.SessionAdapter
import com.example.msimple.data.model.CategoryModel
import com.example.msimple.data.vos.ProgramVO


class DetailActivity : BaseActivity() {
    private var recyclerView: RecyclerView? = null
    private var toolbar: Toolbar? = null
    private var collapsingToolbarLayout: CollapsingToolbarLayout? = null
    private val ivBackground: ImageView? = null
    private val ivLecturer: ImageView? = null
    private var tvDescription: TextView? = null
    private var tvReadMore: TextView? = null
    private val tvLecturerName: TextView? = null
    private val expandable = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false) // hide the toolbar

        supportActionBar!!.setDisplayHomeAsUpEnabled(true) // for back arrow
        supportActionBar!!.setDisplayShowHomeEnabled(true) // for back arrow


        collapsingToolbarLayout = findViewById(R.id.collapsingToolBar)
        tvDescription = findViewById(R.id.tv_description)


        val id = intent.getStringExtra("programId")
        val categoryModel = CategoryModel.getInstance()
        val programsVO = categoryModel.getProgramVO(id)


        collapsingToolbarLayout!!.title = programsVO.title
        tvDescription!!.text = programsVO.description


        recyclerView = findViewById(R.id.rv_sessions)
        val sessionsAdapter = SessionAdapter()
        recyclerView!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.adapter = sessionsAdapter
        sessionsAdapter.setNewData(programsVO.sessionsList)

        tvDescription = findViewById(R.id.tv_description)
        tvReadMore = findViewById(R.id.tv_read_more)

        tvDescription!!.setOnClickListener {
            // Toast.makeText(getApplicationContext(), "Description", Toast.LENGTH_SHORT).show();
        }


        tvReadMore!!.setOnClickListener { Toast.makeText(applicationContext, "Readmore", Toast.LENGTH_SHORT).show() }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {


        fun newIntent(context: Context): Intent {
            return Intent(context, DetailActivity::class.java)


        }
    }
}
