package com.jcs.jarpaper.data.repository

import com.jcs.jarpaper.data.local.WallpaperDao
import com.jcs.jarpaper.data.remote.WallpaperRemoteDataSource
import com.jcs.jarpaper.utils.performGetOperation
import javax.inject.Inject

class WallpaperRepository @Inject constructor(
    private val remoteDataSource: WallpaperRemoteDataSource,
    private val localDataSource: WallpaperDao
) {
    fun getWallpapers() = performGetOperation(
        databaseQuery = { localDataSource.getWallpapers() },
        networkCall = { remoteDataSource.getAllWallpaper() },
        deleteSavedData = { localDataSource.deleteAll() },
        saveCallResult = { localDataSource.insertAllWallpaper(it) }
    )
}