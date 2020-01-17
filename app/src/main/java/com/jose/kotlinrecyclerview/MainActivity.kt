package com.jose.kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var blogAdapter: BlogRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView();
        addDataSet();
    }

    private fun initRecyclerView(){
        //without using "apply" we need to use recycler id repeatedly
//        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
//        blogAdapter = BlogRecyclerAdapter()
//        recycler_view.adapter = blogAdapter

                recycler_view.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    val topSpaceingItemDecoration = TopSpaceingItemDecoration(30)
                    addItemDecoration(topSpaceingItemDecoration)
                    blogAdapter = BlogRecyclerAdapter()
                    adapter = blogAdapter
        }
    }

    private fun addDataSet(){
        val data = DataSource.createDataSet()
        blogAdapter.submitList(data)
    }
}
