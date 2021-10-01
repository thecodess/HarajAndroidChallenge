package com.apps.haraj.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.apps.haraj.util.Utility.hideProgressBar
import com.apps.haraj.util.Utility.showProgressBar
import com.apps.haraj.api.ApiClient
import com.apps.haraj.model.Posts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object PostRepository {

    fun getMutableLiveData(context: Context) : MutableLiveData<ArrayList<Posts>> {

        val mutableLiveData = MutableLiveData<ArrayList<Posts>>()

        context.showProgressBar()

        ApiClient.apiService.getPosts().enqueue(object : Callback<MutableList<Posts>> {
            override fun onFailure(call: Call<MutableList<Posts>>, t: Throwable) {
                hideProgressBar()
                Log.e("error", t.localizedMessage)
            }

            override fun onResponse(
                call: Call<MutableList<Posts>>,
                response: Response<MutableList<Posts>>
            ) {
                hideProgressBar()
                val postsResponse = response.body()
                postsResponse?.let { mutableLiveData.value = it as ArrayList<Posts> }
            }

        })

        return mutableLiveData
    }

}