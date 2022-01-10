package com.jcs.jarpaper.data.remote

import com.jcs.jarpaper.data.entities.Wallpaper
import retrofit2.Response
import retrofit2.http.GET

interface WallpaperService {
    @GET(".")
    suspend fun getAllWallpaper(): Response<List<Wallpaper>>
}