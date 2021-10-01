package com.apps.haraj.model

import com.google.gson.annotations.SerializedName
import java.util.*
import java.io.Serializable
data class Posts(
@SerializedName("title")
    val title: String? = null,
@SerializedName("city")
    val city: String? = null,
@SerializedName("username")
    val userName: String? = null,
@SerializedName("body")
    val body: String? = null,
@SerializedName("commentCount")
    val commentCount: Int? = null,
@SerializedName("date")
    val date: String? = null,
@SerializedName("thumbURL")
    val thumbUrl: String? = null
) : Serializable