package org.d3if0052.newser.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class News(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var tanggal: Long = System.currentTimeMillis(),
    val judul: String
)
