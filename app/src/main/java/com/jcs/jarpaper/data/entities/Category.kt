package com.jcs.jarpaper.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
data class Category(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    val name: String,
    val quantity: Int,
    val url: String
)