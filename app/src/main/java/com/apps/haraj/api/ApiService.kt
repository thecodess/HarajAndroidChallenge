package com.apps.haraj.api

import com.apps.haraj.model.Posts
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("data")
    fun getPosts(): Call<MutableList<Posts>>

}