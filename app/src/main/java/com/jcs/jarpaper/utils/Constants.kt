package com.jcs.jarpaper.utils

class Constants {
    companion object{
        const val URL_BASE = "https://jarpaper.herokuapp.com/api/v1/"
        const val ENDPOINT_POPULAR = "/wallpaper/popular-wallpapers"
        const val ENDPOINT_RANDOM = "/wallpaper/random-wallpapers"
        const val ENDPOINT_BY_PAGE = "/wallpaper/page="
        const val ENDPOINT_POPULAR_BY_PAGE = "/wallpaper/popular-wallpapers/page="
        const val ENDPOINT_CATEGORIES = "/category"
        const val ENDPOINT_CATEGORY = "/wallpaper/category/"
        const val ENDPOINT_CATEGORY_BY_PAGE = "/category/%s/page="
        const val ENDPOINT_SEARCH = "/search="
        const val ENDPOINT_SEARCH_BY_PAGE = "/search=%s&page="
    }
}