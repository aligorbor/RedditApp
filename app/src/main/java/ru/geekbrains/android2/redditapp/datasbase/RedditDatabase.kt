package ru.geekbrains.android2.redditapp.datasbase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.geekbrains.android2.redditapp.datasbase.dao.RedditKeysDao
import ru.geekbrains.android2.redditapp.datasbase.dao.RedditPostsDao
import ru.geekbrains.android2.redditapp.model.RedditKeys
import ru.geekbrains.android2.redditapp.model.RedditPost

@Database(
    entities = [RedditPost::class, RedditKeys::class],
    version = 1,
    exportSchema = false
)
abstract class RedditDatabase : RoomDatabase() {
    companion object {
        fun create(context: Context): RedditDatabase {
            val databaseBuilder =
                Room.databaseBuilder(context, RedditDatabase::class.java, "redditposts.db")
            return databaseBuilder.build()
        }
    }

    abstract fun redditPostsDao(): RedditPostsDao
    abstract fun redditKeysDao(): RedditKeysDao
}