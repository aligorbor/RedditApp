package ru.geekbrains.android2.redditapp.networking

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.geekbrains.android2.redditapp.model.RedditApiResponse

interface RedditService {
    @GET("/r/aww/hot.json")
    suspend fun fetchPosts(
        @Query("limit") loadSize: Int = 0,
        @Query("after") after: String? = null,
        @Query("before") before: String? = null
    ): Response<RedditApiResponse>
}