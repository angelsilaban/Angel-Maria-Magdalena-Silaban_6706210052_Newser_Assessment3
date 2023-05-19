package org.d3if0052.newser.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.d3if0052.newser.db.entity.News

interface NewsDao {

    @Query("SELECT * FROM news")
    fun getAll(): List<News>

    @Query("SELECT * FROM news WHERE idBerita IN (:NewsIds)")
    fun loadAllByIds(NewsIds: IntArray): List<News>

    @Insert
    fun insertAll(vararg news: News)

    @Delete
    fun delete(news: News)
}