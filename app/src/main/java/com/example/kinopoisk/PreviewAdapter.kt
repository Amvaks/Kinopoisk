package com.example.kinopoisk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.databinding.PreviewItemBinding
import com.squareup.picasso.Picasso

class PreviewAdapter: RecyclerView.Adapter<PreviewAdapter.PreviewHolder>() {
    val previewList = ArrayList<PreviewListItem>()
    class PreviewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PreviewItemBinding.bind(item)
        fun bind(preview: PreviewListItem) = with(binding) {
            Picasso.get().load(preview.posterUrlPreview).into(imagePreviewFilm)
            namePreviewFilm.text = preview.nameRu
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.preview_item, parent, false)
        return PreviewHolder(view)
    }

    override fun onBindViewHolder(holder: PreviewHolder, position: Int) {
        holder.bind(previewList[position])
    }

    override fun getItemCount(): Int {
        return previewList.size
    }

    fun addPreview(preview: PreviewListItem) {
        previewList.add(preview)
        notifyDataSetChanged()
    }
}