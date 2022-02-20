package com.example.twitterui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterui.R
import com.example.twitterui.adapter.FeedAdapter
import com.example.twitterui.adapter.StoryAdapter
import com.example.twitterui.model.Post
import com.example.twitterui.model.Story

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerViewStory: RecyclerView
    private lateinit var recyclerViewFeed: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        context = this

        recyclerViewStory = findViewById(R.id.recycler_view_story)
        recyclerViewStory.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        recyclerViewFeed = findViewById(R.id.recycler_view_feed)
        recyclerViewFeed.layoutManager = GridLayoutManager(context, 1)

        refreshFeedAdapter(prepareFeedList())
        refreshStoryAdapter(prepareStoryList())

    }

    private fun refreshStoryAdapter(items: ArrayList<Story>) {
        val adapter = StoryAdapter(context, items)
        recyclerViewStory.adapter = adapter
    }

    private fun refreshFeedAdapter(items: ArrayList<Post>) {
        val adapter = FeedAdapter(context, items)
        recyclerViewFeed.adapter = adapter
    }

    private fun prepareStoryList(): ArrayList<Story> {
        val list = ArrayList<Story>()

        for (i in 1..20) list.add(Story(R.drawable.im_user_profile, "Xurshidbek"))
        return list
    }

    private fun prepareFeedList(): ArrayList<Post> {
        val list = ArrayList<Post>()

        for (i in 1..50) {
            if (i%5 == 0){
                list.add(
                    Post(
                        R.drawable.im_user_profile,
                        "Khurshidbek Kurbanov",
                        R.drawable.im_user_profile
                    )
                )
            }else if(i%7 == 0){
                list.add(
                    Post(
                        R.drawable.im_user_profile,
                        "Khurshidbek Kurbanov",
                        R.drawable.img_1
                    )
                )
            }
        }
        list.add(
            Post(
                R.drawable.im_user_profile,
                "Khurshidbek Kurbanov",
                R.drawable.img_5
            )
        )
        list.add(
                Post(
                    R.drawable.im_user_profile,
                    "Khurshidbek Kurbanov",
                    R.drawable.img_3
                )
                )
        list.add(
                Post(
                    R.drawable.im_user_profile,
                    "Khurshidbek Kurbanov",
                    R.drawable.img_2
                )
                )
        return list
    }
}








