package com.jcs.jarpaper.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jcs.jarpaper.data.entities.Wallpaper
import com.jcs.jarpaper.databinding.WallpaperListItemBinding

class LatestAdaper : ListAdapter<Wallpaper, LatestAdaper.LatestViewHolder>(ITEM_COMPARATOR) {

    inner class LatestViewHolder(private val binding: WallpaperListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(wallpaper: Wallpaper) {
            Glide.with(binding.root)
                .load(wallpaper.thumbUrl)
                .into(binding.wallpaperItem)
            binding.wallpaperNameItem.text = wallpaper.subtitle
        }

    }

    override fun getItemCount(): Int = currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
        val binding =
            WallpaperListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
        return LatestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        private val ITEM_COMPARATOR = object : DiffUtil.ItemCallback<Wallpaper>() {
            override fun areItemsTheSame(oldItem: Wallpaper, newItem: Wallpaper): Boolean {
                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(oldItem: Wallpaper, newItem: Wallpaper): Boolean {
                return oldItem == newItem
            }

        }

    }
}