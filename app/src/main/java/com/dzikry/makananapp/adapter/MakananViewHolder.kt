package com.dzikry.makananapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dzikry.makananapp.databinding.ItemRestoranBinding
import com.dzikry.makananapp.model.RestoranItem

class MakananViewHolder(val makananBinding: ItemRestoranBinding) : RecyclerView.ViewHolder(makananBinding.root) {
    fun bindview(item: RestoranItem) {
        itemView.run {
            makananBinding.txtJudulgallery.text = item.judul
            makananBinding.txtDeskgallery.text = item.desk
            Glide.with(this).load(item.gambar).into(makananBinding.imgMakanan)
        }
    }

}