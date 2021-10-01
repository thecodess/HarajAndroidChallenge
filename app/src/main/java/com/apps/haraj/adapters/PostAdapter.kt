package com.apps.haraj.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apps.haraj.activities.DetailActivity
import com.apps.haraj.R
import com.apps.haraj.model.Posts
import com.squareup.picasso.Picasso

class PostAdapter(private val context: Context, private var list: MutableList<Posts>) : RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.post_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val posts = list.get(position)
        holder.title?.text = posts.title
        holder.city?.text = posts.city
        holder.username?.text = posts.userName
        holder.date?.text = posts.date
        holder.commentCount?.text = posts.commentCount.toString()
        Picasso.get().load(posts.thumbUrl).into(holder.image)
        holder.view.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("title", posts.title)
            bundle.putString("city", posts.city)
            bundle.putString("username", posts.userName)
            bundle.putString("date", posts.date)
            bundle.putString("body", posts.body)
bundle.putString("image",posts.thumbUrl)

            val showDetailIntent = Intent(context, DetailActivity::class.java)

           showDetailIntent.putExtra("title", posts.title)
            showDetailIntent.putExtra("city", posts.city)
            showDetailIntent.putExtra("username", posts.userName)
            showDetailIntent.putExtra("date", posts.date)
            showDetailIntent.putExtra("body", posts.body)
            showDetailIntent.putExtra("image", posts.thumbUrl)
            context.startActivity(showDetailIntent)
        }
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){

   var title: TextView? = null
        var username: TextView? = null
        var city: TextView? = null
        var date: TextView? = null
        var commentCount: TextView? = null
        var image: ImageView?=null

        init {
            title = view.findViewById(R.id.postTitle)
            username = view.findViewById(R.id.postUserName)
            city = view.findViewById(R.id.postCity)
           date = view.findViewById(R.id.postDate)
            commentCount = view.findViewById(R.id.commentCount)
           image=view.findViewById(R.id.postImage)

        }

    }

}