package com.apps.haraj.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apps.haraj.R
import com.apps.haraj.adapters.PostAdapter
import com.apps.haraj.model.Posts
import com.apps.haraj.viewmodel.PostViewModel
import com.apps.haraj.viewmodelfactory.PostViewModelFactory


class MainActivity : AppCompatActivity() {
    private lateinit var listPosts: MutableList<Posts>
    private lateinit var adapter: PostAdapter
    private lateinit var recycler_main: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "HarajAndroidChallenge"
        recycler_main = findViewById(R.id.recycler_main)
        recycler_main.layoutManager = LinearLayoutManager(this@MainActivity)

        listPosts = mutableListOf<Posts>()
        adapter = PostAdapter(
            this,
            listPosts
        )
        recycler_main.adapter = adapter

        val postViewModel =
            ViewModelProviders.of(this, PostViewModelFactory(this)).get(PostViewModel::class.java)
        postViewModel.getData().observe(this, object : Observer<ArrayList<Posts>> {
            override fun onChanged(t: ArrayList<Posts>?) {
                listPosts.clear()
                t?.let { listPosts.addAll(it) }
                adapter.notifyDataSetChanged()
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.search) {
            Toast.makeText(this, "Search", Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}