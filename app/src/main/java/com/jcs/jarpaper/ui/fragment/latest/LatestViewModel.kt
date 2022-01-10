package com.jcs.jarpaper.ui.fragment.latest

import androidx.lifecycle.ViewModel
import com.jcs.jarpaper.data.repository.WallpaperRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Jardson Costa on 28/11/2021.
 */

@HiltViewModel
class LatestViewModel @Inject constructor(private val repository: WallpaperRepository) :
    ViewModel() {

        val lastWallpapers = repository.getWallpapers()
}