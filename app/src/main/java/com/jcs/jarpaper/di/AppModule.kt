package com.jcs.jarpaper.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jcs.jarpaper.data.local.JarpaperDatabase
import com.jcs.jarpaper.data.local.WallpaperDao
import com.jcs.jarpaper.data.remote.WallpaperRemoteDataSource
import com.jcs.jarpaper.data.remote.WallpaperService
import com.jcs.jarpaper.data.repository.WallpaperRepository
import com.jcs.jarpaper.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl(Constants.URL_BASE)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideWallpaperService(retrofit: Retrofit): WallpaperService = retrofit.create(WallpaperService::class.java)

    @Singleton
    @Provides
    fun provideWallpaperRemoteDataSource(characterService: WallpaperService) = WallpaperRemoteDataSource(characterService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = JarpaperDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideWallpaperDao(db: JarpaperDatabase) = db.getWallpaperDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: WallpaperRemoteDataSource,
                          localDataSource: WallpaperDao) =
        WallpaperRepository(remoteDataSource, localDataSource)

}