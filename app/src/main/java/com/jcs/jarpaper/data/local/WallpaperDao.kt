package com.jcs.jarpaper.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jcs.jarpaper.data.entities.Wallpaper

@Dao
interface WallpaperDao {

    @Query("SELECT * FROM wallpaper_table")
    fun getWallpapers(): LiveData<List<Wallpaper>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllWallpaper(wallpaper: List<Wallpaper>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWallpaper(wallpaper: Wallpaper)

    @Query("DELETE FROM wallpaper_table")
    suspend fun deleteAll()

}