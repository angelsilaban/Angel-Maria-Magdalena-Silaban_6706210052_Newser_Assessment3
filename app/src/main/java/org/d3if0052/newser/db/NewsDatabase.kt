package org.d3if0052.newser.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if0052.newser.db.dao.NewsDao
import org.d3if0052.newser.db.entity.News

@Database(entities = [News::class], version = 1)

abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao() : NewsDao

    companion object {
        private var instance: NewsDatabase? = null

        fun getInstance(context: Context): NewsDatabase {
            if(instance== null) {
                instance = Room.databaseBuilder(context, NewsDatabase::class.java, "news-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }

            return instance!!
        }
    }
}