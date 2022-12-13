package com.example.cloudmusic.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.cloudmusic.R
import com.example.cloudmusic.beans.RecoSongsItem

class RecoSongsAdapter(
  private var initList: ArrayList<RecoSongsItem>,
  private var content: Context
) : RecyclerView.Adapter<RecoSongsAdapter.RecoSongsViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecoSongsViewHolder {
    return RecoSongsViewHolder(LayoutInflater.from(content).inflate(R.layout.item_reco_songs, parent, false))
  }

  override fun onBindViewHolder(holder: RecoSongsViewHolder, position: Int) {
    val options = RequestOptions.bitmapTransform(RoundedCorners(30))
    Glide.with(content).load(initList[position].url).apply(options).into(holder.imageView)
    holder.textView.text = initList[position].text
  }

  override fun getItemCount(): Int {
    return initList.size
  }

  @SuppressLint("NotifyDataSetChanged")
  fun reset(newList: ArrayList<RecoSongsItem>) {
    initList.clear()
    initList = newList
    notifyDataSetChanged()
  }

  class RecoSongsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var imageView: ImageView = view.findViewById(R.id.surface)
    var textView: TextView = view.findViewById(R.id.text)
  }
}