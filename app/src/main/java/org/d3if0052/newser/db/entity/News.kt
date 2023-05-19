package org.d3if0052.newser.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class News(
    @PrimaryKey(autoGenerate = true) var idBerita: Int? = null,
    @ColumnInfo(name = "judul") var judul: String?,
    @ColumnInfo(name = "desc") var desc: String?,
    @ColumnInfo(name = "image") var image: Int? = null
)
