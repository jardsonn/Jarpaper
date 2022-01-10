package com.jcs.jarpaper.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wallpaper_table")
data class Wallpaper(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    val subtitle: String,
    @ColumnInfo(name = "thumb_url") val thumbUrl: String,
    val url: String
)