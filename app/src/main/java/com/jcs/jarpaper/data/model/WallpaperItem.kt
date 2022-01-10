package com.jcs.jarpaper.data.model

data class WallpaperItem(
    val authorName: String,
    val authorPortfolioLink: String,
    val category: String,
    val differentResolutions: List<DifferentResolution>,
    val publicationDate: String,
    val relatedWallpapers: List<Wallpaper>,
    val title: String,
    val url: String
)