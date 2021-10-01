package com.apps.haraj.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apps.haraj.repository.PostRepository
import com.apps.haraj.util.Utility.isInternetAvailable
import com.apps.haraj.model.Posts

class PostViewModel(private val context: Context) : ViewModel() {

    private var listData = MutableLiveData<ArrayList<Posts>>()

    init {
        val postRepository: PostRepository by lazy {
            PostRepository
        }
        if (context.isInternetAvailable()) {
            listData = PostRepository.getMutableLiveData(context)
        }
    }

    fun getData(): MutableLiveData<ArrayList<Posts>> {
        return listData
    }
}