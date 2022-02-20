package com.example.twitterui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterui.R
import com.example.twitterui.model.Post
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(private val context: Context, private val items: ArrayList<Post>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater =
            LayoutInflater.from(context).inflate(R.layout.item_feed_post, parent, false)

        return FeedViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = items[position]

        if (holder is FeedViewHolder) {
            val imageViewProfile = (holder as FeedViewHolder).imageViewProfile
            val imageViewPost = (holder as FeedViewHolder).imageViewPost
            val textViewFullName = (holder as FeedViewHolder).textViewFullName

            imageViewProfile.setImageResource(post.profile)
            imageViewPost.setImageResource(post.photo)
            textViewFullName.text = post.fullName
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private class FeedViewHolder(myItemView: View) : RecyclerView.ViewHolder(myItemView) {
        val imageViewProfile: ShapeableImageView =
            myItemView.findViewById(R.id.image_view_profile_feed)
        val imageViewPost: ShapeableImageView = myItemView.findViewById(R.id.image_view_post)
        val textViewFullName: TextView = myItemView.findViewById(R.id.text_view_full_name)
    }
}
