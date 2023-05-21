package org.d3if0052.newser.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.d3if0052.newser.db.News

@Dao
interface NewsDao {
    @Insert
    fun insert(news: News)
    @Query("SELECT * FROM news ORDER BY id DESC")
    fun getHasilNews(): LiveData<List<News>>
    @Query("DELETE FROM news")
    fun clearData()
}
