package ru.geekbrains.android2.redditapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import ru.geekbrains.android2.redditapp.model.RedditPost
import ru.geekbrains.android2.redditapp.repository.RedditRepo

class RedditViewModel (application: Application) : AndroidViewModel(application) {
    private val redditRepo = RedditRepo(application)

    fun fetchPosts(): Flow<PagingData<RedditPost>> {
        return redditRepo.fetchPosts().cachedIn(viewModelScope)
    }
}