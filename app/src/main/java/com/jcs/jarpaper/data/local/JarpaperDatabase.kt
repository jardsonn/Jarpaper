package com.jcs.jarpaper.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jcs.jarpaper.data.entities.Category
import com.jcs.jarpaper.data.entities.Wallpaper

@Database(entities = [Wallpaper::class, Category::class], version = 1)
abstract class JarpaperDatabase: RoomDatabase() {

    abstract fun getWallpaperDao(): WallpaperDao
    abstract fun getCategoryDao(): CategoryDao

    companion object{
        private var INSTANCE: JarpaperDatabase? = null;

        fun getDatabase(context: Context): JarpaperDatabase{
            return INSTANCE ?: synchronized(this){
               INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context) = Room
            .databaseBuilder(context, JarpaperDatabase::class.java, "jarpaper_database")
            .fallbackToDestructiveMigration()
            .build()
    }
}