package ru.geekbrains.android2.redditapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.android2.redditapp.databinding.ItemPostBinding
import ru.geekbrains.android2.redditapp.model.RedditPost
import ru.geekbrains.android2.redditapp.utils.DiffUtilCallBack


class RedditAdapter :
    PagingDataAdapter<RedditPost, RedditAdapter.RedditViewHolder>(DiffUtilCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditViewHolder {
        return RedditViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RedditViewHolder, position: Int) {
        getItem(position)?.let { holder.bindPost(it) }
    }

    class RedditViewHolder(binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        private val scoreText: TextView = binding.score
        private val commentsText: TextView = binding.comments
        private val titleText: TextView = binding.title

        fun bindPost(redditPost: RedditPost) {
            with(redditPost) {
                scoreText.text = score.toString()
                commentsText.text = commentCount.toString()
                titleText.text = title
            }
        }
    }
}