package ru.geekbrains.android2.redditapp.repository

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.geekbrains.android2.redditapp.datasbase.RedditDatabase
import ru.geekbrains.android2.redditapp.model.RedditPost
import ru.geekbrains.android2.redditapp.networking.RedditClient
import ru.geekbrains.android2.redditapp.networking.RedditService

class RedditRepo(context: Context) {
    private val redditService = RedditClient.getClient().create(RedditService::class.java)
    private val redditDatabase = RedditDatabase.create(context)

    @OptIn(ExperimentalPagingApi::class)
    fun fetchPosts(): Flow<PagingData<RedditPost>> {
//        return Pager(
//            PagingConfig(pageSize = 40, enablePlaceholders = false, prefetchDistance = 3)){
//            RedditPagingSource(redditService)
//        }.flow
        return Pager(
            PagingConfig(pageSize = 40, enablePlaceholders = false, prefetchDistance = 3),
            remoteMediator = RedditRemoteMediator(redditService, redditDatabase),
            pagingSourceFactory = { redditDatabase.redditPostsDao().getPosts() }
        ).flow
    }
}