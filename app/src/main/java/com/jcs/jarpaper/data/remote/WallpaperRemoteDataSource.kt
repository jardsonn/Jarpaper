package com.jcs.jarpaper.data.remote

import javax.inject.Inject

/**
 * Created by Jardson Costa on 28/11/2021.
 */

class WallpaperRemoteDataSource @Inject constructor(
    private val wallpaperService: WallpaperService
): BaseDataSource(){
    suspend fun getAllWallpaper() = getResult { wallpaperService.getAllWallpaper() }
}